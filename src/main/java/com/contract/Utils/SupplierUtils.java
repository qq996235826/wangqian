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
        supplier.setIdNum(supplierDTO.getIdNum()==null?supplier.getIdNum():supplierDTO.getIdNum());
        //银行卡号
        supplier.setBankNumber(supplierDTO.getBankNum()==null?supplier.getBankNumber():supplierDTO.getBankNum());
        //开户行名
        supplier.setBankName(supplierDTO.getBankName()==null?supplier.getBankName():supplierDTO.getBankName());
        //家庭住址
        supplier.setHomeAddress(supplierDTO.getHomeAddress()==null?supplier.getHomeAddress():supplierDTO.getHomeAddress());
        //手机号
        supplier.setPhoneNum(supplierDTO.getPhoneNum()==null?supplier.getPhoneNum():supplierDTO.getPhoneNum());
        //供货人名
        supplier.setName(supplierDTO.getName()==null?supplier.getName():supplierDTO.getName());
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
        else if(StringUtils.isNullOrEmpty(supplier.getBankNumber()))
        {
            //throw new CustomizeException(CustomizeErrorCode.SUPPLIER_BANKNUM_LOST);
            return false;
        }
        else if (StringUtils.isNullOrEmpty(supplier.getBankName()))
        {
            //throw new CustomizeException(CustomizeErrorCode.SUPPLIER_BANKNUME_LOST);
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
