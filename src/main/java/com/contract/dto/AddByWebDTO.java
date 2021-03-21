package com.contract.dto;

import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description
 * @date 2021/1/14 16:59
 */
@Data
public class AddByWebDTO
{
    private Long id;
    private String orderCode;
    private String createTime;
    private String itemName;
    private String price;
    private String status;
    private String companyName;
    private String companyCode;
    private Long supplierId;
    private String supplierName;
    private String supplierIdNum;
    private String supplierPhone;
    private String supplierHomeAddress;
    private String bankName;
    private String branchBankName;
    private String bankNum;
    private String startDate;
    private String endDate;
    private String phone;
    //重量
    private String weight;
    private Integer origin;


}
