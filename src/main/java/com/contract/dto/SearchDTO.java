package com.contract.dto;

import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description 用于接受前端搜索数据的DTO
 * @date 2021/1/23 22:13
 */
@Data
public class SearchDTO
{
    private Integer total;
    private Integer page;
    private Integer rows;
    private String orderCode;
    private String status;
    private String supplierName;
    private String supplierIdNum;
    private String bank;
    private String item;
    private String company;
};
