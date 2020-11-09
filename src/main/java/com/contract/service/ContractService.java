package com.contract.service;

import com.contract.Utils.PdfUtils;
import com.contract.Utils.SupplierUtils;
import com.contract.Utils.WordUtils;
import com.contract.contractEnumerate.KeyWord;
import com.contract.dto.ContractInfoDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.ContractTemplateMapper;
import com.contract.mapper.OrderMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.*;
import com.contract.oss.UploadOss;
import com.mysql.cj.util.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.DateFormat;
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
    private OrderMapper orderMapper;

    @Resource
    private UploadOss uploadOss;

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


    /**
     * 根据信息生成一份合同
     * @return 合同路径
     * @param contractInfoDTO
     */
    public String getContract(ContractInfoDTO contractInfoDTO)
    {
        //获得供货人
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andPhoneNumEqualTo(contractInfoDTO.getPhoneNum());
        List<Supplier> suppliers=supplierMapper.selectByExample(supplierExample);
        //正常情况一个号码只能得到一个供货人
        if(suppliers.size()!=1)
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_WRONG);
        }
        else {
            //获得供货人
            Supplier supplier=suppliers.get(0);
            if(SupplierUtils.infoComplete(supplier))
            {
                Map<String,Object> infoMap=new HashMap<>();
                //设置标记符和替换变量
                //签订时间
                infoMap.put(KeyWord.CREATE_TIME.getValue(), DateFormat.getDateInstance().format(new Date()));
                //乙方
                infoMap.put(KeyWord.PartyB.getValue(),supplier.getName());
                //身份证号
                infoMap.put(KeyWord.ID_NUM.getValue(),supplier.getIdNum());
                //电话号
                infoMap.put(KeyWord.PHONE_NUM.getValue(),supplier.getPhoneNum());
                //银行卡号
                infoMap.put(KeyWord.BANK_ID.getValue(),supplier.getBankNumber());
                //开户行
                infoMap.put(KeyWord.BANK_NAME.getValue(),supplier.getBankName());
                //物品名
                infoMap.put(KeyWord.ITEM_NAM.getValue(),contractInfoDTO.getItem());
                //价格
                if(StringUtils.isNullOrEmpty(contractInfoDTO.getPrice()))
                {
                    infoMap.put(KeyWord.PRICE.getValue(),"    ");
                }
                else
                {
                    infoMap.put(KeyWord.PRICE.getValue(),contractInfoDTO.getPrice());
                }
                //获得合同
                ContractTemplateExample contractTemplateExample=new ContractTemplateExample();
                contractTemplateExample.createCriteria().andIsUsingEqualTo(true);
                String temPath=contractTemplateMapper.selectByExample(contractTemplateExample).get(0).getPath();
                //新合同路径
                String path=getNewOrderContract(new File(temPath),contractInfoDTO.getPhoneNum());
                //WordUtils.replaceAll(path,infoMap);

                //后台替换关键字
                //WordUtils.replaceAndGenerateWord(path,path,infoMap);
                //图片插入
                Map<String,Object> header = new HashMap<>();
                header.put("width",150);
                header.put("height",75);
                header.put("type", "png");
                header.put("content", "F:\\project\\JAVA\\hetong\\src\\main\\java\\com\\contract\\Utils\\签名.png");//图片路径
                infoMap.put(KeyWord.PartyB_NAMEPAGE.getValue(),header);
                //替换关键字和图片
                XWPFDocument doc = WordUtils.generateWord(infoMap, "F:\\project\\JAVA\\hetong\\src\\main\\java\\com\\contract\\Utils\\合同——新格式.docx");
                try {
                    FileOutputStream fopts = new FileOutputStream(path);
                    doc.write(fopts);
                    fopts.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }



                //把新合同写入数据库
                Order order=new Order();
                //设置所使用模板id
                order.setTemplateId(contractTemplateMapper.selectByExample(contractTemplateExample).get(0).getId());
                //设置供货人id
                order.setSupplierId(supplier.getId());
                //设置创建时间
                order.setCreateTime(new Date());
                //设置货物名称
                order.setItemName(contractInfoDTO.getItem());
                //设置审核状态,0未审核
                order.setStatus(0);
                //设置合同存储路径
                order.setPath(path);
                orderMapper.insert(order);

                return path;
            }
            else
            {
                throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_LOST);
            }
        }
    }

    /**
     * 根据模板获得一个合同
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
        String newFilePath=orderPatch+phoneNum+"/"+newFileName;

        //将传来的文件写入新建的文件
        try {
            //创建新文件
            File file1=new File(newFilePath);
            //判断文件夹是否存在,不存在则创建
            if(file1.getParentFile().exists())
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
    public String uploadContract(MultipartFile upload) {
        //上传模板文件
        String path=upload(upload,filePath);
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
        String ossName=uploadOss.uploadOss(path);
        //把模板文件数据写入数据库
        ContractTemplate contractTemplate=new ContractTemplate();
        contractTemplate.setIsUsing(true);
        contractTemplate.setPath(path);
        contractTemplate.setCreateTime(new Date());
        contractTemplate.setOssName(ossName);
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
        //判断文件夹是否存在,不存在则创建
        File file=new File(patch);
        if(!file.exists()){
            file.mkdirs();
        }

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
        example.createCriteria().andIsUsingEqualTo(true);
        List<ContractTemplate> templates=contractTemplateMapper.selectByExample(example);
        if(templates.size()==1)
        {
            String fileName = templates.get(0).getOssName();
            String domainOfBucket = "http://qjfkdtkza.hd-bkt.clouddn.com";
            return String.format("%s/%s", domainOfBucket, fileName);
        }
        else
        {
            throw new  CustomizeException(CustomizeErrorCode.CONTRACT_TEMPLATE_WRONG);
        }

    }
}
