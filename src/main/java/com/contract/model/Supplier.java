package com.contract.model;

import java.util.Date;

public class Supplier {
    private Long id;

    private String idNum;

    private String password;

    private String phoneNum;

    private String name;

    private String bankNumber;

    private String bankName;

    private String homeAddress;

    private String birth;

    private String agencies;

    private String sex;

    private String ethnic;

    private String idCardTimeLimit;

    private String id0Path;

    private String id1Path;

    private String bank0Path;

    private String bank1Path;

    private Integer ststus;

    private Date updateTime;

    private Long updateBy;

    private Date check1Time;

    private Long chech1By;

    private String check1Note;

    private Date check2Time;

    private Long chech2By;

    private String check2Note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber == null ? null : bankNumber.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getAgencies() {
        return agencies;
    }

    public void setAgencies(String agencies) {
        this.agencies = agencies == null ? null : agencies.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic == null ? null : ethnic.trim();
    }

    public String getIdCardTimeLimit() {
        return idCardTimeLimit;
    }

    public void setIdCardTimeLimit(String idCardTimeLimit) {
        this.idCardTimeLimit = idCardTimeLimit == null ? null : idCardTimeLimit.trim();
    }

    public String getId0Path() {
        return id0Path;
    }

    public void setId0Path(String id0Path) {
        this.id0Path = id0Path == null ? null : id0Path.trim();
    }

    public String getId1Path() {
        return id1Path;
    }

    public void setId1Path(String id1Path) {
        this.id1Path = id1Path == null ? null : id1Path.trim();
    }

    public String getBank0Path() {
        return bank0Path;
    }

    public void setBank0Path(String bank0Path) {
        this.bank0Path = bank0Path == null ? null : bank0Path.trim();
    }

    public String getBank1Path() {
        return bank1Path;
    }

    public void setBank1Path(String bank1Path) {
        this.bank1Path = bank1Path == null ? null : bank1Path.trim();
    }

    public Integer getStstus() {
        return ststus;
    }

    public void setStstus(Integer ststus) {
        this.ststus = ststus;
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

    public Long getChech2By() {
        return chech2By;
    }

    public void setChech2By(Long chech2By) {
        this.chech2By = chech2By;
    }

    public String getCheck2Note() {
        return check2Note;
    }

    public void setCheck2Note(String check2Note) {
        this.check2Note = check2Note == null ? null : check2Note.trim();
    }
}