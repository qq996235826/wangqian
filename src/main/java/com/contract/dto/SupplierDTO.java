package com.contract.dto;

import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description 供货商的信息DTO
 * @date 2020/11/5 20:45
 */
@Data
public class SupplierDTO {
    //数据库主键
    Long id;
    //供货单位名
    String name;
    //身份证号
    String idNum;
    //银行卡号
    String bankNum;
    //开户行名
    String bankName;
    //地址
    String homeAddress;
    //电话号
    String phoneNum;


}
