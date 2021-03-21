package com.contract.dto;

import com.contract.model.Order;
import lombok.Data;
import org.apache.ibatis.javassist.Loader;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author deng
 * @version 1.0
 * @description 订单合同的DTO
 * @date 2020/11/16 15:00
 */
@Data
public class OrderDTO {
    private Long id;

    private Long templateId;

    private Long supplierId;

    private String bankName;

    private String branchBankName;

    private String bankNum;

    private String bankImagePath;

    private String supplierName;

    private String supplierIdNum;

    private String supplierHomeAddress;

    private String supplierPhone;

    private String createTime;

    private String itemName;

    private String companyCode;

    private String companyName;

    private String companyAddress;

    private Double weight;

    private BigDecimal price;

    private Double amount;

    private String orderNum;

    private String orderNumTime;

    private Integer status;

    private String updateTime;

    private Long updateBy;

    private String check1Time;

    private Long chech1By;

    private String check1Note;

    private String check2Time;

    private Long chech2Bby;

    private String check2Note;

    private String signaturePath;

    private String path;

    private String pdfPath;

    private String startDate;

    private String endDate;

    private Integer origin;

    public OrderDTO(Order order) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.id=order.getId();
        this.templateId=order.getTemplateId();
        this.supplierId=order.getSupplierId();
        this.bankName=order.getBankName();
        this.branchBankName=order.getBranchBankName();
        this.bankNum=order.getBankNum();
        this.bankImagePath=order.getBankImagePath();
        this.supplierName=order.getSupplierName();
        this.supplierIdNum=order.getSupplierIdNum();
        this.supplierHomeAddress=order.getSupplierHomeAddress();
        this.supplierPhone=order.getSupplierPhone();
        this.createTime=sdf.format(order.getCreateTime());
        this.itemName=order.getItemName();
        this.companyCode=order.getCompanyCode();
        this.companyName=order.getCompanyName();
        this.companyAddress=order.getCompanyAddress();
        this.weight=order.getWeight();
        this.price=order.getPrice();
        this.amount=order.getAmount();
        this.orderNum=order.getOrderNum();
        this.orderNumTime=order.getOrderNum();
        this.status=order.getStatus();
        this.updateTime=sdf.format(order.getUpdateTime());
        this.updateBy=order.getUpdateBy();
        this.signaturePath=order.getSignaturePath();
        this.path=order.getPath();
        this.pdfPath=order.getPdfPath();
        this.startDate=order.getStartDate();
        this.endDate=order.getEndDate();
        this.origin=order.getOrigin();
    }

    public OrderDTO() {
    }
}
