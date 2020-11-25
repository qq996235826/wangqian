package com.contract.dto;

import com.mysql.cj.util.StringUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author deng
 * @version 1.0
 * @description 供货商的信息DTO
 * @date 2020/11/5 20:45
 */
@Data
public class SupplierDTO {
    //身份证号
    String idNum;
    //密码
    String password;
    //电话号
    String phoneNum;
    //供货人名
    String name;
    //银行卡号
    String bankNum;
    //开户行名
    String bankName;
    //家庭地址
    String homeAddress;
    //出生日期
    String birth;
    //发证机关
    String agencies;
    //性别
    String sex;
    //民族
    String ethnic;
    //身份证有效期
    String idCardTimeLimit;



    /**
     * 判断注册需要的信息是不是都不为空
     * @return
     */
    public Boolean registeredReady()
    {
        if(StringUtils.isNullOrEmpty(idNum)||StringUtils.isNullOrEmpty(password))
        {
            return false;
        }
        else {
            return true;
        }
    }

}
