package com.contract.dto;

import com.contract.model.Order;
import lombok.Data;

/**
 * @author deng
 * @version 1.0
 * @description 订单合同的DTO
 * @date 2020/11/16 15:00
 */
@Data
public class OrderDTO {
    //合同id
    Long id;
    Long templateId;
    Long supplierId;
    //品名
    String itemName;
    String orderNum;
    //银行名字
    String bankName;
    String branchBankName;
    //合同状态
    int status;
    //供应商
    String companyName;
    //合同有效期
    String endTime;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.templateId=order.getTemplateId();
        this.supplierId=order.getSupplierId();
        this.itemName=order.getItemName();
        this.orderNum=order.getOrderNum();
        this.status=order.getStatus();
        this.companyName=order.getCompanyName();
        this.endTime=order.getEndDate();
    }

    public OrderDTO() {
    }
}
