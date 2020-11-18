package com.contract.Utils;

import com.contract.dto.SupplierDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.model.Supplier;
import com.mysql.cj.util.StringUtils;


/**
 * @author deng
 * @version 1.0
 * @description 供货人处理工具
 * @date 2020/11/6 22:03
 */
public class SupplierUtils {
    /**
     * 更新信息
     * @param supplier
     * @param supplierDTO
     */
    public static void update(Supplier supplier, SupplierDTO supplierDTO)
    {
        //身份证号
        supplier.setIdNum(StringUtils.isNullOrEmpty(supplierDTO.getIdNum())?supplier.getIdNum():supplierDTO.getIdNum());
        //家庭住址
        supplier.setHomeAddress(StringUtils.isNullOrEmpty(supplierDTO.getHomeAddress())?supplier.getHomeAddress():supplierDTO.getHomeAddress());
        //手机号
        supplier.setPhoneNum(StringUtils.isNullOrEmpty(supplierDTO.getPhoneNum())?supplier.getPhoneNum():supplierDTO.getPhoneNum());
        //供货人名
        supplier.setName(StringUtils.isNullOrEmpty(supplierDTO.getName())?supplier.getName():supplierDTO.getName());
        //出生日期
        supplier.setBirth(StringUtils.isNullOrEmpty(supplierDTO.getBirth())?supplier.getBirth():supplierDTO.getBirth());
        //发证机关
        supplier.setAgencies(StringUtils.isNullOrEmpty(supplierDTO.getAgencies())?supplier.getName():supplierDTO.getAgencies());
        //性别
        supplier.setSex(StringUtils.isNullOrEmpty(supplierDTO.getSex())?supplier.getSex():supplierDTO.getSex());
        //民族
        supplier.setEthnic(StringUtils.isNullOrEmpty(supplierDTO.getEthnic())?supplier.getEthnic():supplierDTO.getEthnic());
        //身份证有效期
        supplier.setIdCardTimeLimit(StringUtils.isNullOrEmpty(supplierDTO.getIdCardTimeLimit())?supplier.getIdCardTimeLimit():supplierDTO.getIdCardTimeLimit());
    }

    /**
     * 检查供货人信息是否完善
     * @param supplier
     * @return true或fsale
     */
    public static Boolean infoComplete(Supplier supplier)
    {
        if (StringUtils.isNullOrEmpty(supplier.getIdNum()))
        {
            //throw new CustomizeException(CustomizeErrorCode.SUPPLIER_IDNUM_LOST);
            return false;
        }
        else if(StringUtils.isNullOrEmpty(supplier.getHomeAddress()))
        {
            //throw new CustomizeException(CustomizeErrorCode.SUPPLIER_HOMEADDRESS_LOST);
            return false;
        }
        else if(StringUtils.isNullOrEmpty(supplier.getPhoneNum()))
        {
            //throw new CustomizeException(CustomizeErrorCode.SUPPLIER_PHONENUM_LOST);
            return false;
        }
        return true;
    }
}
