package com.contract.model;

import java.util.Date;

public class ContractTemplate {
    private Long id;

    private String path;

    private Date createTime;

    private Boolean isUsing;

    private String versionNum;

    private Date updateTime;

    private Long updateBy;

    private String note;

    private String ossName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(Boolean isUsing) {
        this.isUsing = isUsing;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum == null ? null : versionNum.trim();
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getOssName() {
        return ossName;
    }

    public void setOssName(String ossName) {
        this.ossName = ossName == null ? null : ossName.trim();
    }
}