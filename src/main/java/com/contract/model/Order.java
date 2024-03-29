package com.contract.model;

import com.contract.dto.AddByWebDTO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
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

    private Date createTime;

    private String itemName;

    private String companyCode;

    private String companyName;

    private String companyAddress;

    private Double weight;

    private BigDecimal price;

    private Double amount;

    private String orderNum;

    private Date orderNumTime;

    private Integer status;

    private Date updateTime;

    private Long updateBy;

    private Date check1Time;

    private Long chech1By;

    private String check1Note;

    private Date check2Time;

    private Long chech2Bby;

    private String check2Note;

    private String signaturePath;

    private String path;

    private String pdfPath;

    private String startDate;

    private String endDate;

    private Integer origin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBranchBankName() {
        return branchBankName;
    }

    public void setBranchBankName(String branchBankName) {
        this.branchBankName = branchBankName == null ? null : branchBankName.trim();
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum == null ? null : bankNum.trim();
    }

    public String getBankImagePath() {
        return bankImagePath;
    }

    public void setBankImagePath(String bankImagePath) {
        this.bankImagePath = bankImagePath == null ? null : bankImagePath.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierIdNum() {
        return supplierIdNum;
    }

    public void setSupplierIdNum(String supplierIdNum) {
        this.supplierIdNum = supplierIdNum == null ? null : supplierIdNum.trim();
    }

    public String getSupplierHomeAddress() {
        return supplierHomeAddress;
    }

    public void setSupplierHomeAddress(String supplierHomeAddress) {
        this.supplierHomeAddress = supplierHomeAddress == null ? null : supplierHomeAddress.trim();
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone == null ? null : supplierPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Date getOrderNumTime() {
        return orderNumTime;
    }

    public void setOrderNumTime(Date orderNumTime) {
        this.orderNumTime = orderNumTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCheck1Time() {
        return check1Time;
    }

    public void setCheck1Time(Date check1Time) {
        this.check1Time = check1Time;
    }

    public Long getChech1By() {
        return chech1By;
    }

    public void setChech1By(Long chech1By) {
        this.chech1By = chech1By;
    }

    public String getCheck1Note() {
        return check1Note;
    }

    public void setCheck1Note(String check1Note) {
        this.check1Note = check1Note == null ? null : check1Note.trim();
    }

    public Date getCheck2Time() {
        return check2Time;
    }

    public void setCheck2Time(Date check2Time) {
        this.check2Time = check2Time;
    }

    public Long getChech2Bby() {
        return chech2Bby;
    }

    public void setChech2Bby(Long chech2Bby) {
        this.chech2Bby = chech2Bby;
    }

    public String getCheck2Note() {
        return check2Note;
    }

    public void setCheck2Note(String check2Note) {
        this.check2Note = check2Note == null ? null : check2Note.trim();
    }

    public String getSignaturePath() {
        return signaturePath;
    }

    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath == null ? null : signaturePath.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath == null ? null : pdfPath.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public void updateByOrderDTO(AddByWebDTO orderDTO)
    {
        this.id=orderDTO.getId();
        this.supplierId=orderDTO.getSupplierId();
        this.bankName=orderDTO.getBankName();
        this.branchBankName=orderDTO.getBranchBankName();
        this.bankNum=orderDTO.getBankNum();
        this.supplierName=orderDTO.getSupplierName();
        this.supplierIdNum=orderDTO.getSupplierIdNum();
        this.supplierHomeAddress=orderDTO.getSupplierHomeAddress();
        this.supplierPhone=orderDTO.getSupplierPhone();
        try
        {
            this.createTime=new SimpleDateFormat("yyyy-MM-dd").parse(orderDTO.getCreateTime());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        this.itemName=orderDTO.getItemName();
        this.companyCode=orderDTO.getCompanyCode();
        this.companyName=orderDTO.getCompanyName();
        this.weight= Double.valueOf(orderDTO.getWeight());
        this.price=new BigDecimal(orderDTO.getPrice());
        this.orderNum=orderDTO.getOrderCode();
        this.orderNumTime=new Date();
        this.status= Integer.valueOf(orderDTO.getStatus());
        this.updateTime=new Date();
        this.startDate=orderDTO.getStartDate();
        this.endDate=orderDTO.getEndDate();
        this.origin=orderDTO.getOrigin();
        this.bankImagePath=(orderDTO.getBankImage()==null?"":orderDTO.getBankImage());
    }
}