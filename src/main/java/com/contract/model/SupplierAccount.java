package com.contract.model;

public class SupplierAccount {
    private Integer ID;

    private String supplierIDNum;

    private String name;

    private String account;

    private String bank;

    private String bankImage;

    private String note;

    private Integer status;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSupplierIDNum() {
        return supplierIDNum;
    }

    public void setSupplierIDNum(String supplierIDNum) {
        this.supplierIDNum = supplierIDNum == null ? null : supplierIDNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankImage() {
        return bankImage;
    }

    public void setBankImage(String bankImage) {
        this.bankImage = bankImage == null ? null : bankImage.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}