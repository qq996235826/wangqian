package com.contract.service;

import com.contract.Utils.SupplierUtils;
import com.contract.dto.SupplierDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.SupplierAccountMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.Supplier;
import com.contract.model.SupplierAccount;
import com.contract.model.SupplierAccountExample;
import com.contract.model.SupplierExample;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * @author deng
 * @version 1.0
 * @description 供货人的service
 * @date 2020/11/5 19:24
 */
@Service
public class SupplierService {

    @Resource
    SupplierMapper supplierMapper;

    @Resource
    SupplierAccountMapper supplierAccountMapper;

    @Value("${rootPatch}")
    String rootPatch;

    @Value("${signaturePatch}")
    String signaturePatch;


    /**
     * 通过身份证号注册供货人
     * @param supplierDTO
     * @return 供货人id
     */
    public Long createSupplier(SupplierDTO supplierDTO) {
        //检查需要的参数是否完整
        if(!supplierDTO.registeredReady())
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_LOST);
        }

        //先看看数据库里是否已经有了这个身份证号
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andIdNumEqualTo(supplierDTO.getIdNum());
        List<Supplier> supplierList=supplierMapper.selectByExample(supplierExample);
        //已经存在,更新信息
        if(supplierList.size()!=0)
        {
            throw new CustomizeException(CustomizeErrorCode.CREATE_WRONG);
        }
        //没有这个身份证,新建用户并插入
        Supplier supplier=new Supplier();
        supplier.setPhoneNum(supplierDTO.getPhoneNum());
        supplier.setIdNum(supplierDTO.getIdNum());
        supplier.setPassword(supplierDTO.getPassword());
        supplier.setStstus(1);

        if(supplierMapper.insert(supplier)!=1)
        {
            throw new CustomizeException(CustomizeErrorCode.SQL_INSERT_FAIL);
        }
//        SupplierAccount supplierAccount=new SupplierAccount();
//        supplierAccount.setSupplierIDNum(supplierDTO.getIdNum());
//        supplierAccountMapper.insert(supplierAccount);
        //返回供货人id
        return supplierMapper.selectByExample(supplierExample).get(0).getId();
    }

    /**
     * 完善供货人信息
     * @param supplierDTO
     * @return 供货人id
     */
    public Long addSupplierInfo(SupplierDTO supplierDTO) {
        //先看看数据库里是否有这个用户
        if(haveIdNum(supplierDTO.getIdNum()))
        {
            SupplierExample example=new SupplierExample();
            example.createCriteria().andIdNumEqualTo(supplierDTO.getIdNum());
            List<Supplier>supplierList=supplierMapper.selectByExample(example);
            //获得用户
            Supplier supplier=supplierList.get(0);
            //更新信息
            SupplierUtils.update(supplier,supplierDTO);
            supplier.setUpdateTime(new Date());
            supplierMapper.updateByPrimaryKey(supplier);

            SupplierAccountExample supplierAccountExample=new SupplierAccountExample();
            supplierAccountExample.createCriteria().andSupplierIDNumEqualTo(supplierDTO.getIdNum());
            List<SupplierAccount> supplierAccounts=supplierAccountMapper.selectByExample(supplierAccountExample);

            //插入supplierAccount表
            if(supplierAccounts.size()!=0)
            {
                Boolean pd=false;
                for (int a=0;a<supplierAccounts.size();a++)
                {
                    if(supplierAccounts.get(a).getAccount().equals(supplierDTO.getBankNum()))
                    {
                        pd=true;
                        break;
                    }
                }
                if(!pd)
                {
                    SupplierAccount supplierAccount=new SupplierAccount();
                    supplierAccount.setSupplierIDNum(supplierDTO.getIdNum());
                    supplierAccount.setName(supplierDTO.getName());
                    supplierAccount.setAccount(supplierDTO.getBankNum());
                    supplierAccount.setBranchBankName(supplierDTO.getBranchBankName());
                    supplierAccount.setBankName(supplierDTO.getBankName());
                    supplierAccount.setBank(supplierDTO.getBankName()+supplierDTO.getBranchBankName());
                    supplierAccount.setCreateTime(new Date());
                    supplierAccount.setCompanyCode("");
                    supplierAccount.setNote("用户创建时的记录");
                    supplierAccountMapper.insert(supplierAccount);
                }
            }
            else
            {
                SupplierAccount supplierAccount=new SupplierAccount();
                supplierAccount.setSupplierIDNum(supplierDTO.getIdNum());
                supplierAccount.setName(supplierDTO.getName());
                supplierAccount.setAccount(supplierDTO.getBankNum());
                supplierAccount.setBranchBankName(supplierDTO.getBranchBankName());
                supplierAccount.setBankName(supplierDTO.getBankName());
                supplierAccount.setBank(supplierDTO.getBankName()+supplierDTO.getBranchBankName());
                supplierAccount.setCreateTime(new Date());
                supplierAccount.setCompanyCode("");
                supplierAccount.setNote("用户创建时的记录");
                supplierAccountMapper.insert(supplierAccount);
            }


            return supplier.getId();
        }
        //没有这个用户
        else
        {
            throw new CustomizeException(CustomizeErrorCode.HAVEN_PHONE);
        }

    }

    /**
     * 上传供货人图片信息,逻辑上而言,只要查到不是一条数据都不是
     * @param upload
     * @param idNum
     * @param role
     * @return 图片路径
     */
    public String uploadImage(MultipartFile upload,String idNum ,String role) {

        //先看看数据库里是否有这个用户
        if(haveIdNum(idNum))
        {
            //获得用户
            Supplier supplier=getSupplierByIdNum(idNum);
            //判断上传的是什么图片 0身份证正面,1身份证反面,2银行卡正面,3银行卡反面
            String Path="";
            if(role.equals("0"))
            {
                Path=upload(upload,rootPatch+signaturePatch+idNum+"/");
                supplier.setId0Path(Path);
                supplierMapper.updateByPrimaryKey(supplier);
                return Path;
            }
            else if(role.equals("1"))
            {
                Path=upload(upload,rootPatch+signaturePatch+idNum+"/");
                supplier.setId1Path(Path);
                supplierMapper.updateByPrimaryKey(supplier);
                return Path;
            }
            else {
                throw new CustomizeException(CustomizeErrorCode.IMAGE_WRONG);
            }

        }
        //没有这个用户
        else
        {
            throw new CustomizeException(CustomizeErrorCode.HAVEN_PHONE);
        }
    }

    /**
     * 判断数据库里是否有这个身份证号
     * @param idNum
     * @return true或者false
     */
    public boolean haveIdNum(String idNum)
    {
        //看看数据库里是否有这个用户
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andIdNumEqualTo(idNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(supplierExample);
        if(supplierList.size()!=1) {
            return false;
        }
        else {
            return true;
        }
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
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.WRITE_FILE_WRONG);
        }
    }

    /**
     * 判断改手机号是否注册
     * @param idNum
     * @return true或者false
     */
    public Boolean Registered(String idNum) {
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andIdNumEqualTo(idNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(supplierExample);
        if(supplierList.size()==0)
        {
//            createSupplier(phoneNum);
            return false;
        }
        else if(supplierList.size()==1)
        {
            return true;
        }
        else {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_WRONG);
        }
    }

    /**
     * 登录接口
     * @param idNum
     * @param password
     * @return
     */
    public String logIn(String idNum, String password) {
        SupplierExample example=new SupplierExample();
        example.createCriteria().andIdNumEqualTo(idNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(example);
        if(supplierList.size()==1)
        {
            if(supplierList.get(0).getPassword().equals(password))
            {
                if(supplierList.get(0).getStstus()!=4)
                {
                    return UUID.randomUUID().toString();
                }
                else
                {
                    throw  new CustomizeException(CustomizeErrorCode.SUPPLIER_STATUS_WRONG);
                }
            }
            else
            {
                throw  new CustomizeException(CustomizeErrorCode.PASS_WRONG);
            }
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_WRONG);
        }
    }

    /**
     * 根据账号号获得供货人账号信息
     * @param account
     * @return
     */
    public SupplierAccount getSupplierAccountInfo(String account) {
        SupplierAccountExample example=new SupplierAccountExample();
        example.createCriteria().andAccountEqualTo(account);
        List<SupplierAccount> supplierAccounts=supplierAccountMapper.selectByExample(example);
        if(supplierAccounts.size()>0)
        {
            return supplierAccounts.get(0);
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_SUPPLIER);
        }

    }

    /**
     * 根据身份证号号获得供货人账号信息
     * @param account
     * @return
     */
    public Supplier getSupplierInfo(String account) {
        SupplierAccountExample example=new SupplierAccountExample();
        example.createCriteria().andAccountEqualTo(account);
        List<SupplierAccount> supplierAccounts=supplierAccountMapper.selectByExample(example);
        if(supplierAccounts.size()>0)
        {
            Supplier supplier=getSupplierByIdNum(supplierAccounts.get(0).getSupplierIDNum());
            supplier.setBankNum(account);
            supplier.setBankName(supplierAccounts.get(0).getBankName());
            supplier.setBranchBankName(supplierAccounts.get(0).getBranchBankName());
            return supplier;
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_SUPPLIER);
        }

    }

    /**
     * 根据身份证号获得供货人
     * @param idNum
     * @return
     */
    public Supplier getSupplierByIdNum(String idNum)
    {
        SupplierExample example=new SupplierExample();
        example.createCriteria().andIdNumEqualTo(idNum);
        List<Supplier> supplierList=supplierMapper.selectByExample(example);
        if(supplierList.size()==1)
        {
            return supplierList.get(0);
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_WRONG);
        }
    }

    /**
     *
     * @param idNum
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public Boolean changePassword(String idNum, String oldPassword, String newPassword) {

        Supplier supplier=getSupplierByIdNum(idNum);
        if(supplier.getPassword().equals(oldPassword))
        {
            supplier.setPassword(newPassword);
            supplierMapper.updateByPrimaryKey(supplier);
            return true;
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.PASS_WRONG);
        }
    }

    /**
     * @Description: 停用用户
     * @Author: DengHaoRan
     * @Date: 2021/1/7 23:43
     * @params: [id, i]
     * @return: java.lang.Boolean
     **/
    public Boolean deactivate(String id)
    {
        Supplier supplier=supplierMapper.selectByPrimaryKey(Long.valueOf(id));
        if(supplier==null)
        {
            return false;
        }
        supplier.setStstus(4);
        if(supplierMapper.updateByPrimaryKey(supplier)==1)
        {
            return true;
        }
        return false;
    }

    /**
     * @Description: 启用用户
     * @Author: DengHaoRan
     * @Date: 2021/1/7 23:43
     * @params: [id, i]
     * @return: java.lang.Boolean
     **/
    public Boolean enable(String id)
    {
        Supplier supplier=supplierMapper.selectByPrimaryKey(Long.valueOf(id));
        if(supplier==null)
        {
            return false;
        }
        supplier.setStstus(1);
        if(supplierMapper.updateByPrimaryKey(supplier)==1)
        {
            return true;
        }
        return false;
    }

    public List<Map<String, String>> getSupplierAccount(String idNum)
    {
        SupplierAccountExample example=new SupplierAccountExample();
        example.createCriteria().andSupplierIDNumEqualTo(idNum);
        List<SupplierAccount> supplierAccounts=supplierAccountMapper.selectByExample(example);
        if(supplierAccounts.size()==0)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_SUPPLIER);
        }
        List<Map<String, String>> results=new ArrayList<>();
        for(SupplierAccount supplier:supplierAccounts)
        {
            Map<String, String> map=new HashMap();
            map.put("code",supplier.getAccount());
            map.put("account",supplier.getAccount());
            results.add(map);
        }
        return results;
    }
}
