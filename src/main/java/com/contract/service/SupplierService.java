package com.contract.service;

import com.contract.Utils.SupplierUtils;
import com.contract.dto.SupplierDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.SupplierMapper;
import com.contract.model.Supplier;
import com.contract.model.SupplierExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

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

    @Value("${signaturePatch}")
    String signaturePatch;

    /**
     * 通过号码注册供货人
     * @param supplierDTO
     * @return 供货人id
     */
    public Long createSupplier(SupplierDTO supplierDTO) {
        //检查需要的参数是否完整
        if(!supplierDTO.registeredReady())
        {
            throw new CustomizeException(CustomizeErrorCode.SUPPLIER_INFO_LOST);
        }

        //先看看数据库里是否已经有了这个电话
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andPhoneNumEqualTo(supplierDTO.getPhoneNum());
        if(supplierMapper.selectByExample(supplierExample).size()!=0)
        {
            throw new CustomizeException(CustomizeErrorCode.HAVE_PHONE);
        }
        //没有这个号码,新建用户并插入
        Supplier supplier=new Supplier();
        supplier.setPhoneNum(supplierDTO.getPhoneNum());
        supplier.setIdNum(supplierDTO.getIdNum());
        supplier.setPassword(supplierDTO.getPassword());
        if(supplierMapper.insert(supplier)!=1)
        {
            throw new CustomizeException(CustomizeErrorCode.SQL_INSERT_FAIL);
        }
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
        if(havePhone(supplierDTO.getPhoneNum()))
        {
            SupplierExample example=new SupplierExample();
            example.createCriteria().andPhoneNumEqualTo(supplierDTO.getPhoneNum());
            List<Supplier>supplierList=supplierMapper.selectByExample(example);
            //获得用户
            Supplier supplier=supplierList.get(0);
            //更新信息
            SupplierUtils.update(supplier,supplierDTO);
            supplierMapper.updateByPrimaryKey(supplier);
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
     * @param phoneNum
     * @param role
     * @return 图片路径
     */
    public String uploadImage(MultipartFile upload,String phoneNum ,String role) {
        //先看看数据库里是否有这个用户
        if(havePhone(phoneNum))
        {
            SupplierExample example=new SupplierExample();
            example.createCriteria().andPhoneNumEqualTo(phoneNum);
            List<Supplier>supplierList=supplierMapper.selectByExample(example);
            //获得用户
            Supplier supplier=supplierList.get(0);
            //判断上传的是什么图片 0身份证正面,1身份证反面,2银行卡正面,3银行卡反面
            String Path="";
            if(role.equals("0"))
            {
                Path=upload(upload,signaturePatch+phoneNum+"/");
                supplier.setId0Path(Path);
                supplierMapper.updateByPrimaryKey(supplier);
                return Path;
            }
            else if(role.equals("1"))
            {
                Path=upload(upload,signaturePatch+phoneNum+"/");
                supplier.setId1Path(Path);
                supplierMapper.updateByPrimaryKey(supplier);
                return Path;
            }
            else if(role.equals("2"))
            {
                Path=upload(upload,signaturePatch+phoneNum+"/");
                supplier.setBank0Path(Path);
                supplierMapper.updateByPrimaryKey(supplier);
                return Path;
            }
            else if(role.equals("3"))
            {
                Path=upload(upload,signaturePatch+phoneNum+"/");
                supplier.setBank1Path(Path);
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
     * 判断数据库里是否有这个手机号
     * @param phoneNum
     * @return true或者false
     */
    public boolean havePhone(String phoneNum)
    {
        //看看数据库里是否有这个用户
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andPhoneNumEqualTo(phoneNum);
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
     * @param phoneNum
     * @return true或者false
     */
    public Boolean Registered(String phoneNum) {
        SupplierExample supplierExample=new SupplierExample();
        supplierExample.createCriteria().andPhoneNumEqualTo(phoneNum);
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
}
