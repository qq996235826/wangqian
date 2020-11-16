package com.contract.model;

import java.util.Date;

public class Order {
    private Long id;

    private Long templateId;

    private Long supplierId;

    private Date createTime;

    private String itemName;

    private String companyName;

    private Double weight;

    private Double price;

    private Double amount;

    private Date endTime;

    private String orderNum;

    private Integer status;

    private Date updateTime;

    private Long updateBy;

    private Date check1Time;

    private Long chech1By;

    private String check1Note;

    private Date check2Time;

    private Long chech2Bby;

    private String check2Note;

    private String path;

    private String ossPath;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getOssPath() {
        return ossPath;
    }

    public void setOssPath(String ossPath) {
        this.ossPath = ossPath == null ? null : ossPath.trim();
    }
}