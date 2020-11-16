package com.contract.dto;

import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description 订单合同的DTO
 * @date 2020/11/16 15:00
 */
@Data
public class OrderDTO {
    Long id;
    Long templateId;
    Long supplierId;
    String itemName;
    String orderNum;
    String status;
}
