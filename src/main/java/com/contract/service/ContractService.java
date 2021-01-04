package com.contract.service;

import com.contract.Utils.PdfUtils;
import com.contract.Utils.SupplierUtils;
import com.contract.Utils.WordToPDFAndJPG;
import com.contract.Utils.WordUtils;
import com.contract.contractEnumerate.KeyWord;
import com.contract.dto.OrderDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.CompanyMapper;
import com.contract.mapper.ContractTemplateMapper;
import com.contract.mapper.OrderMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.*;
import com.mysql.cj.util.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author deng
 * @version 1.0
 * @description 负责合同的处理
 * @date 2020/11/2 21:19
 */
@Service
public class ContractService {

    @Resource
    private PdfUtils pdfUtils;

    @Resource
    private ContractTemplateMapper contractTemplateMapper;

    @Resource
    private SupplierMapper supplierMapper;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private WordToPDFAndJPG wordToPDFAndJPG;



    @Value("${rootPatch}")
    private String rootPatch;

    @Value("${contractJPGPatch}")
    private String contractJPGPatch;

    @Value("${orderBankJPGPatch}")
    private String orderBankJPGPatch;

    @Value("${contractPDFPatch}")
    private String contractPDFPatch;

    @Value("${signaturePatch}")
    String signaturePatch;

    /**
     *  @filePath 合同模板文件存放路径,在配置文件中规定
     */
    @Value("${contractPatch}")
    String filePath;

    /**
     *  @orderPatch 订单合同路径
     */
    @Value("${orderPatch}")
    String orderPatch;

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

    private SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");

    private String[] formart={"年","月","日"};


    /**
     * 根据信息生成一份合同
     * @return 合同路径
     * @param  file,  phoneNum, item, price
     */
    public Long getContract(MultipartFile file, String idNum,String item,String price,String companyCode,String bankNum,String bankName,String branchBankName,
                              MultipartFile bankImage,String startDate,String endDate,String phoneNum,String orderId)
    {
        //格式化时间
        String[] starts=startDate.split("-");
        String[] ends=endDate.split("-");
        startDate="";
        endDate="";
        for(int a=0;a<3;a++)
        {
            startDate=startDate+starts[a]+formart[a];
            endDate=endDate+ends[a]+formart[a];
        }
        //获得供货人
        Supplier supplier=getSupplierByIdNum(idNum);
        supplier.setPhoneNum(phoneNum);
        supplierMapper.updateByPrimaryKey(supplier);
        //获得甲方
        Company company=getCompanyByCode(companyCode);
        if(SupplierUtils.infoComplete(supplier))
        {
            Map<String,Object> infoMap=new HashMap<>();
            //设置标记符和替换变量
            //签订时间
            infoMap.put(KeyWord.CREATE_TIME.getValue(), startDate);
            //终止日期
            infoMap.put(KeyWord.END_TIME.getValue(), endDate);
            //乙方
            infoMap.put(KeyWord.PartyB.getValue(),supplier.getName());
            //身份证号
            infoMap.put(KeyWord.ID_NUM.getValue(),supplier.getIdNum());
            //电话号
            infoMap.put(KeyWord.PHONE_NUM.getValue(),supplier.getPhoneNum());
            //银行卡号
            infoMap.put(KeyWord.BANK_ID.getValue(),bankNum);
            //开户行
            infoMap.put(KeyWord.BANK_NAME.getValue(),bankName+branchBankName);
            //设置甲方
            infoMap.put(KeyWord.COMPANY.getValue(),company.getName());
            //设置甲方地址
            infoMap.put(KeyWord.PLACE.getValue(),company.getAddress());
            //物品名
            String s;
            if(item.equals("paper"))
            {
                infoMap.put(KeyWord.ITEM_NAM.getValue(),"废纸");
                s="废纸";
            }
            else if(item.equals("steel"))
            {
                infoMap.put(KeyWord.ITEM_NAM.getValue(),"废钢");
                s="废钢";
            }
            else
            {
                infoMap.put(KeyWord.ITEM_NAM.getValue(),"    ");
                s="    ";
            }
            //价格
            if(StringUtils.isNullOrEmpty(price))
            {
                infoMap.put(KeyWord.PRICE.getValue(),"    ");
            }
            else
            {
                infoMap.put(KeyWord.PRICE.getValue(),price);
            }
            //获得合同
            ContractTemplateExample contractTemplateExample=new ContractTemplateExample();
            contractTemplateExample.createCriteria().andIsUsingEqualTo(true);
            String temPath=contractTemplateMapper.selectByExample(contractTemplateExample).get(0).getPath();
            //新合同路径
            String path=getNewOrderContract(new File(temPath),idNum);
            //WordUtils.replaceAll(path,infoMap);

            //后台替换关键字
            //WordUtils.replaceAndGenerateWord(path,path,infoMap);
            //上传签名照片
            //如果上传了图片就合成
            String signature=" ";
            if(file!=null)
            {
                signature=upload(file,path.substring(0,path.lastIndexOf("/")+1));
                //图片插入
                Map<String,Object> header = new HashMap<>();
                header.put("width",150);
                header.put("height",75);
                header.put("type", "png");
                header.put("content", signature);//图片路径
                infoMap.put(KeyWord.PartyB_NAMEPAGE.getValue(),header);
            }
            //替换关键字和图片
            XWPFDocument doc = WordUtils.generateWord(infoMap,temPath);
            try {
                FileOutputStream fopts = new FileOutputStream(path);
                doc.write(fopts);
                fopts.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Order order;
            //把新合同写入数据库
            if(StringUtils.isNullOrEmpty(orderId))
            {
                order=new Order();
            }
            else
            {
                order=orderMapper.selectByPrimaryKey(Long.valueOf(orderId));
            }
            if(order==null)
            {
                throw new CustomizeException(CustomizeErrorCode.ORDER_ID_WRONG);
            }
            //保存签名图片
            order.setSignaturePath(signature);
            //设置所使用模板id
            order.setTemplateId(contractTemplateMapper.selectByExample(contractTemplateExample).get(0).getId());
            //设置供货人id
            order.setSupplierId(supplier.getId());
            //设置创建时间
            order.setCreateTime(new Date());
            //更新日期
            order.setUpdateTime(new Date());
            //设置合同生效日期
            order.setStartDate(startDate);
            //设置合同终止日期
            order.setEndDate(endDate);
            //设置货物名称
            order.setItemName(s);
            //设置合同需方
            order.setCompanyCode(companyCode);
            order.setCompanyName(company.getName());
            order.setCompanyAddress(company.getAddress());
            //设置银行卡号
            order.setBankNum(bankNum);
            //设置开户行
            order.setBankName(bankName);
            //设置支行
            order.setBranchBankName(branchBankName);


            //设置价格
            if(!StringUtils.isNullOrEmpty(price))
            {
                order.setPrice(Double.valueOf(price));
            }

            //设置审核状态
            // -1--未签名 0--已提交(签名,没审核),10--审核通过(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
            if(StringUtils.isNullOrEmpty(orderId))
            {
                order.setStatus(-1);
            }
            else
            {
                order.setStatus(0);
            }
            //设置合同存储路径
            order.setPath(path);

            //银行卡图片不为空
            if(bankImage!=null)
            {
                //上传对应的银行卡照片
                String bankImageLocal=upload(bankImage,rootPatch+orderBankJPGPatch);
//                String bankImageOss=uploadOss.uploadOss(bankImageLocal);
                order.setBankImagePath(bankImageLocal);
            }
            //docx转PDF
            String pdfPath=wordToPDFAndJPG.docxToPDF(path);
            order.setPdfPath(pdfPath);
//            String ossUrl=uploadOss.uploadOss(path);
//            order.setOssPath(ossUrl);
            //如果有订单
            if(StringUtils.isNullOrEmpty(orderId))
            {
                orderMapper.insert(order);
            }
            else
            {
                orderMapper.updateByPrimaryKey(order);
            }
            return order.getId();
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_LOST);
        }
    }

    /**
     * 根据模板获得一个合同文件用于覆盖信息
     * @param file
     * @param phoneNum
     * @return 新合同路径
     */
    public String getNewOrderContract(File file,String phoneNum)
    {
        //获取原始文件名
        String originalFileName = file.getName();
        //找到最后一个.的位置
        int indexOfPoint=originalFileName.lastIndexOf(".");
        //如果找不到.,会返回负数
        if(indexOfPoint<0)
        {
            throw new CustomizeException(CustomizeErrorCode.FILE_NAME_WRONG);
        }
        //获得文件格式
        String typename=originalFileName.substring(indexOfPoint);
        //设置新的名字
        String newFileName = UUID.randomUUID()+typename;
        //新文件的路径
        String newFilePath=rootPatch+orderPatch+phoneNum+"/"+newFileName;

        //将传来的文件写入新建的文件
        try {
            //创建新文件
            File file1=new File(newFilePath);
            //判断文件夹是否存在,不存在则创建
            if(!file1.getParentFile().exists())
            {
                file1.getParentFile().mkdirs();
            }
            //写入新文件
            Files.copy(file.toPath(), file1.toPath());
            //成功返回文件路径
            return newFilePath;
        }catch (Exception e ) {
            //处理异常
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.WRITE_FILE_WRONG);
        }

    }


    /**
     *
     * @param pdf pdf文件
     * @param index 第几页
     * @return 获得指定页面的文字内容
     */
    public String getTextOfPdf(File pdf,int index)
    {
        return pdfUtils.getTextOfPdf(pdf,index);
    }

    /**
     * @param pdfPath pdf路径
     * @param keyWord 标记符
     * @param imagePath 签名图片路径
     * 把签名放到指定标记符上
     */
    public void setPageOnPdf(String pdfPath,String keyWord,String imagePath) {
        pdfUtils.setPageOnPdf(pdfPath,keyWord,imagePath);
    }

    /**
     * 上传合同模板接口
     * @param upload
     * @return 文件路径
     */
    public String uploadContractTemplate(MultipartFile upload) {
        //上传模板文件
        String path=upload(upload,rootPatch+filePath);
        String pdfPath=wordToPDFAndJPG.docxToPDF(path,rootPatch+contractPDFPatch);
        //把以前的模板全部失效
        ContractTemplateExample contractTemplateExample=new ContractTemplateExample();
        contractTemplateExample.createCriteria().andIsUsingEqualTo(true);
        List<ContractTemplate> contractTemplates=contractTemplateMapper.selectByExample(contractTemplateExample);
        for(ContractTemplate con : contractTemplates)
        {
            con.setIsUsing(false);
            contractTemplateMapper.updateByPrimaryKey(con);
        }
        //合同模板上传至七牛云
//        String ossUrl=uploadOss.uploadOss(path);
        //把模板文件数据写入数据库
        ContractTemplate contractTemplate=new ContractTemplate();
        contractTemplate.setIsUsing(true);
        contractTemplate.setPath(path);
        contractTemplate.setPdfPath(pdfPath);
        contractTemplate.setCreateTime(new Date());
        contractTemplate.setUpdateTime(new Date());
//        contractTemplate.setOssUrl(ossUrl);
        contractTemplateMapper.insert(contractTemplate);

        return path;
    }


    /**
     * 上传方法
     * @param upload
     * @param patch
     * @return
     */
    public String upload(MultipartFile upload,String patch) {
        //获取原始文件名
        String originalFileName = upload.getOriginalFilename();
        //找到最后一个.的位置
        int indexOfPoint=originalFileName.lastIndexOf(".");
        //如果找不到.,会返回负数
        if(indexOfPoint<0)
        {
            throw new CustomizeException(CustomizeErrorCode.FILE_NAME_WRONG);
        }
        //获得文件格式
        String typename=originalFileName.substring(indexOfPoint);
        //设置新的名字
        String newFileName = UUID.randomUUID()+typename;
        //新文件的路径
        String newFilePath=patch+newFileName;
        //判断文件夹是否存在,不存在则创建

        File file=new File(newFilePath);
        if(!file.exists()){
            file.mkdirs();
        }
        //将传来的文件写入新建的文件
        try {
            //创建新文件
            File file1=new File(newFilePath);
            //写入新文件
            upload.transferTo(file1);
            //成功返回文件路径
            return newFilePath;
        }catch (Exception e ) {
            //处理异常
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.WRITE_FILE_WRONG);
        }
    }


    /**
     * 获得最新版合同模板的下载链接
     * @return
     */
    public String getTemplateUrl()
    {
        //获得最新版合同
        ContractTemplateExample example=new ContractTemplateExample();
        //获得在用的合同
        example.createCriteria().andIsUsingEqualTo(true);
        List<ContractTemplate> templates=contractTemplateMapper.selectByExample(example);
        if(templates.size()==1)
        {
            return templates.get(0).getOssUrl();
        }
        else
        {
            throw new  CustomizeException(CustomizeErrorCode.CONTRACT_TEMPLATE_WRONG);
        }

    }


    /**
     * 上传当前模板图片
     * @param file
     * @return 图片下载链接
     */
    public String uploadContractTemplateImage(MultipartFile file) {
        //上传到本地文件夹
        String localJPGPath=upload(file,rootPatch+contractJPGPatch);
        //上传到云端
//        String ossUrl=uploadOss.uploadOss(localJPGPath);
        //更新数据
        ContractTemplateExample example=new ContractTemplateExample();
        example.createCriteria().andIsUsingEqualTo(true);
        List<ContractTemplate> templates=contractTemplateMapper.selectByExample(example);
        //应该只有一个合同在用的
        if(templates.size()==1)
        {
//            templates.get(0).setJpgOssUrl(ossUrl);
            templates.get(0).setJpgPath(localJPGPath);
            templates.get(0).setUpdateTime(new Date());
            contractTemplateMapper.updateByPrimaryKey(templates.get(0));
            return localJPGPath;
        }
        else {
            throw new CustomizeException(CustomizeErrorCode.CONTRACT_TEMPLATE_WRONG);
        }

    }

    /**
     * 获得最新模板图片下载地址
     * @return 最新模板图片下载地址
     */
    public String getContractTemplateImage() {
        String imageUrl=getContractTemplate().getJpgOssUrl();
        if(imageUrl.isEmpty())
        {
            throw new CustomizeException(CustomizeErrorCode.CONTRACT_TEMPLATE_IMAGE_WRONG);
        }
        else {
            return imageUrl;
        }
    }

    /**
     * 获得指定合同审核状态
     * @param phoneNum
     * @return 审核状态
     */
    public Map<String,String> getOrderStatus(String phoneNum) {
        //返回结果
        Map<String,String> map=new HashMap();
        //获得最新合同
        Supplier supplier=getSupplier(phoneNum);
        Order order=getLastOrderBySupplierId(supplier.getId());
        map.put("id",order.getId().toString());
        //-1--未签名 0--已提交(签名,没审核),10--审核通过(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
        if(order.getStatus()==0)
        {
            map.put("status","checking");
        }
        else if(order.getStatus()==10)
        {
            map.put("status","checkPass");
        }
        else if(order.getStatus()==20)
        {
            map.put("status","checkFail");
        }
        return map;
    }


    /**
     * 通过号码获得唯一供货人
     * @return Supplier
     */
    private Supplier getSupplier(String phoneNum)
    {
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andPhoneNumEqualTo(phoneNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(supplierExample);
        if(supplierList.size()==1)
        {
            return supplierList.get(0);
        }
        else if(supplierList.size()==0)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_SUPPLIER);
        }
        else {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_WRONG);
        }
    }



    /**
     * 通过身份证获得唯一供货人
     * @return Supplier
     */
    private Supplier getSupplierByIdNum(String IdNum)
    {
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andIdNumEqualTo(IdNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(supplierExample);
        if(supplierList.size()==1)
        {
            return supplierList.get(0);
        }
        else if(supplierList.size()==0)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_SUPPLIER);
        }
        else {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_WRONG);
        }
    }

    /**
     * 获得唯一最新合同模板
     * @return ContractTemplate
     */
    private ContractTemplate getContractTemplate()
    {
        ContractTemplateExample example=new ContractTemplateExample();
        example.createCriteria().andIsUsingEqualTo(true);
        List<ContractTemplate> templates=contractTemplateMapper.selectByExample(example);
        if(templates.size()==1)
        {
            return templates.get(0);
        }
        else if(templates.size()==0)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_CONTRACT_TEMPLATE);
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.CONTRACT_TEMPLATE_WRONG);
        }
    }


    /**
     * 获得指定供货人最新的合同
     * @param id
     * @return Order
     */
    private Order getLastOrderBySupplierId(Long id)
    {
        OrderExample example=new OrderExample();
        example.createCriteria().andSupplierIdEqualTo(id);
        List<Order> orders=orderMapper.selectByExample(example);
        if(orders.size()<1)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_ORDER);
        }
        return orders.get(orders.size()-1);
    }

//    /**
//     * 返回订单合同的下载链接
//     * @param orderId
//     * @return
//     */
//    public String getOrderUrl(Long orderId) {
//        Order order=orderMapper.selectByPrimaryKey(orderId);
//        if(StringUtils.isNullOrEmpty(order.getOssPath()))
//        {
//            throw new CustomizeException(CustomizeErrorCode.NOT_OSS_ORDER);
//        }
//        return order.getOssPath();
//    }

    /**
     * 通过审核的接口,通过的话还会生成业务编码
     * @param id
     * @return 信息
     */
    //-1--未签名 0--已提交(签名,没审核),10--待盖章(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
    public String changeOrderStatus(String id,int status) {

        //获得订单ID
        Long orderId=Long.valueOf(id);
        //获得order
        Order order=orderMapper.selectByPrimaryKey(orderId);
        //只有待盖章的才能上传盖章文件
        if(status==90&&order.getStatus()!=10)
        {
            throw new CustomizeException(CustomizeErrorCode.ORDER_STATUS_WRONG);
        }

        if(order!=null)
        {
            //如果是通过审核操作,生成合同业务编码
            String code;
            if(status==10)
            {
                OrderExample example=new OrderExample();
                try
                {
                    //获得当年的所有记录
                    example.createCriteria().andOrderNumIsNotNull().andOrderNumTimeGreaterThanOrEqualTo(sdf1.parse(sdf1.format(new Date())));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                    throw new CustomizeException(CustomizeErrorCode.SYSTEM_ERROR);
                }

                //最后的编号
                Long num=orderMapper.countByExample(example)+1;
                StringBuilder num1= new StringBuilder(num.toString());
                int numSize=num1.length();
                for(int a=numSize;a<5;a++)
                {
                    num1.insert(0, '0');
                }

                //获得供应商缩写
                CompanyExample companyExample=new CompanyExample();
                companyExample.createCriteria().andCodeEqualTo(order.getCompanyCode());
                List<Company> companies=companyMapper.selectByExample(companyExample);
                String companyCode=companies.get(0).getCodeName();
                //获得编号
                code="W-"+companyCode+sdf1.format(new Date())+'-'+num1;
                //设置状态
                order.setStatus(status);
                order.setUpdateTime(new Date());
                order.setOrderNum(code);
                order.setOrderNumTime(new Date());
                if(orderMapper.updateByPrimaryKey(order)==1)
                {
                    return "成功";
                }
                else
                {
                    return "出错";
                }


            }
            //设置状态
            order.setStatus(status);
            order.setUpdateTime(new Date());
            if(orderMapper.updateByPrimaryKey(order)==1)
            {
                return "成功";
            }
            else
            {
                return "出错";
            }
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.ORDER_ID_WRONG);
        }


    }




    //弃用
    public String deleteOrder(String id) {
        //获得订单ID
        Long orderId=Long.valueOf(id);
        //删除order
        if(orderMapper.deleteByPrimaryKey(orderId)==1)
        {
            return "删除成功";
        }
        else
        {
            return "删除出错";
        }
    }

    public Boolean onlyOne(String item, String company, String idNum) {
        //获得订单签订人的id
        Supplier supplier=getSupplierByIdNum(idNum);
        //获得订单
        OrderExample example=new OrderExample();
        example.createCriteria().andSupplierIdEqualTo(supplier.getId()).andStatusNotEqualTo(-1);
        List<Order> orders=orderMapper.selectByExample(example);
        for(int a=0;a<orders.size();a++)
        {
            if(orders.get(a).getItemName().equals(item)&&orders.get(a).getCompanyName().equals(company))
            {
                return false;
            }
        }
        return true;
    }

    public Map<String,Object> getOrders(String idNum) {
        //获得供货人
        Supplier supplier=getSupplierByIdNum(idNum);
        //获得该供货人下的所有合同
        OrderExample example=new OrderExample();
        List<Integer> statusList=new ArrayList<>();
        statusList.add(0);
        statusList.add(90);
        example.createCriteria().andSupplierIdEqualTo(supplier.getId()).andStatusIn(statusList);
        List<Order> orders=orderMapper.selectByExample(example);
        //两个列表分别存放废纸和废钢
        List<OrderDTO> steels=new ArrayList<>();
        List<OrderDTO> papers=new ArrayList<>();
        for(Order o:orders)
        {
            if(o.getItemName().equals("废纸"))
            {
                o.setPdfPath("");
                o.setPath("");
                papers.add(new OrderDTO(o));
            }
            else
            {
                o.setPdfPath("");
                o.setPath("");
                steels.add(new OrderDTO(o));
            }
        }
        //Map包含这两个List返回给前端
        Map<String,Object> map=new HashMap<>();
        if(steels.size()!=0)
        {
            map.put("hasSteel",true);
        }
        else
        {
            map.put("hasSteel",false);
        }
        if(papers.size()!=0)
        {
            map.put("hasPaper",true);
        }
        else
        {
            map.put("hasPaper",false);
        }
        map.put("steel",steels);
        map.put("paper",papers);

        return map;
    }

    /**
     * 更改银行信息接口
     * @param orderDTO
     * @return
     */
    public Boolean update(OrderDTO orderDTO) {
        //获得合同订单
        Order order=orderMapper.selectByPrimaryKey(orderDTO.getId());
        order.setBankName(orderDTO.getBankName());
        order.setBranchBankName(orderDTO.getBranchBankName());
        //获得供货人
        Supplier supplier=supplierMapper.selectByPrimaryKey(orderDTO.getSupplierId());
        //设置更新后的合同信息
        Map<String,Object> infoMap=new HashMap<>();
        //设置标记符和替换变量
        //签订时间
        infoMap.put(KeyWord.CREATE_TIME.getValue(), order.getStartDate());
        //终止日期
        infoMap.put(KeyWord.END_TIME.getValue(), order.getEndDate());
        //乙方
        infoMap.put(KeyWord.PartyB.getValue(),supplier.getName());
        //身份证号
        infoMap.put(KeyWord.ID_NUM.getValue(),supplier.getIdNum());
        //电话号
        infoMap.put(KeyWord.PHONE_NUM.getValue(),supplier.getPhoneNum());
        //银行卡号
        infoMap.put(KeyWord.BANK_ID.getValue(),order.getBankNum());
        //开户行
        infoMap.put(KeyWord.BANK_NAME.getValue(),orderDTO.getBankName()+orderDTO.getBranchBankName());
        //设置甲方
        infoMap.put(KeyWord.COMPANY.getValue(),order.getCompanyName());
        //设置甲方地址
        infoMap.put(KeyWord.PLACE.getValue(),order.getCompanyAddress());
        //物品名
        infoMap.put(KeyWord.ITEM_NAM.getValue(),order.getItemName());
        //价格
        infoMap.put(KeyWord.PRICE.getValue(),order.getPrice());

        //合成新的合同
        ContractTemplateExample contractTemplateExample=new ContractTemplateExample();
        contractTemplateExample.createCriteria().andIdEqualTo(orderDTO.getTemplateId());
        String temPath=contractTemplateMapper.selectByExample(contractTemplateExample).get(0).getPath();
        //新合同路径
        String path=getNewOrderContract(new File(temPath),supplier.getIdNum());
        //WordUtils.replaceAll(path,infoMap);

        //后台替换关键字
        //WordUtils.replaceAndGenerateWord(path,path,infoMap);
        //图片插入
        Map<String,Object> header = new HashMap<>();
        header.put("width",150);
        header.put("height",75);
        header.put("type", "png");
        header.put("content", order.getSignaturePath());//图片路径
        infoMap.put(KeyWord.PartyB_NAMEPAGE.getValue(),header);
        //替换关键字和图片
        XWPFDocument doc = WordUtils.generateWord(infoMap,temPath);
        try {
            FileOutputStream fopts = new FileOutputStream(path);
            doc.write(fopts);
            fopts.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //docx转PDF
        String pdfPath=wordToPDFAndJPG.docxToPDF(path);
        //设置合同存储路径
        order.setPath(path);
        order.setPdfPath(pdfPath);
        order.setUpdateTime(new Date());
        if(orderMapper.updateByPrimaryKey(order)==1)
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 接受银行卡图片并生成订单
     * @param bankImage
     * @return
     */
    public Long uploadContractBankImage(MultipartFile bankImage) {
        //银行卡图片不为空
        if(bankImage==null)
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_BANK0_LOST);
        }
        //新建订单
        Order order=new Order();
        //上传对应的银行卡照片
        String bankImageLocal=upload(bankImage,rootPatch+orderBankJPGPatch);
//        String bankImageOss=uploadOss.uploadOss(bankImageLocal);
        order.setBankImagePath(bankImageLocal);
        //设置状态
        order.setStatus(10);
        //设置更新时间
        order.setUpdateTime(new Date());
        //插入数据
        orderMapper.insert(order);

        //获得刚刚插入的主键
        OrderExample example=new OrderExample();
        example.createCriteria().andBankImagePathEqualTo(bankImageLocal);
        List<Order> orders =orderMapper.selectByExample(example);
        if(orders.size()!=1)
        {
            throw new CustomizeException(CustomizeErrorCode.ORDER_WRONG);
        }
        else
        {
            return orders.get(0).getId();
        }
    }


    /**
     * 获得公司
     * @return
     */
    private Company getCompanyByCode(String companyId)
    {
        CompanyExample example=new CompanyExample();
        example.createCriteria().andCodeEqualTo(companyId);
        List<Company> companys=companyMapper.selectByExample(example);
        if(companys.size()!=1)
        {
            throw new CustomizeException(CustomizeErrorCode.COMPANY_INFO_WRONG);
        }
        else
        {
            return companys.get(0);
        }
    }


    /**
     * 上传已盖章文件
     * @param upload
     * @param id
     * @return
     */
    public String uploadContractFile(MultipartFile upload, String id) {
        Order order=orderMapper.selectByPrimaryKey(Long.valueOf(id));
        if(order!=null)
        {
            if(order.getStatus()!=10)
            {
                throw new CustomizeException(CustomizeErrorCode.ORDER_STATUS_WRONG);
            }
            //上传PDF
            String pdfPath=upload(upload,rootPatch+contractPDFPatch);
            order.setPdfPath(pdfPath);
            //设置状态为已生效
            order.setStatus(90);
            orderMapper.updateByPrimaryKey(order);
            return "成功";
        }
        else {
            throw new CustomizeException(CustomizeErrorCode.ORDER_ID_WRONG);
        }
    }

    public Map<String, String> getBankName(String bankNum) {
        OrderExample example=new OrderExample();
        example.createCriteria().andBankNumEqualTo(bankNum);
        example.setOrderByClause("createTime desc");
        List<Order> orders=orderMapper.selectByExample(example);
        Map<String,String> values=new HashMap<>();
        if(orders.size()>0)
        {
            values.put("bankName",orders.get(0).getBankName());
            values.put("branchBankName",orders.get(0).getBranchBankName());
        }
        else {
            values.put("bankName","");
            values.put("branchBankName","");
        }
        return values;
    }
}
