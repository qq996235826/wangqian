package com.contract.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNull() {
            addCriterion("idNum is null");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNotNull() {
            addCriterion("idNum is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumEqualTo(String value) {
            addCriterion("idNum =", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotEqualTo(String value) {
            addCriterion("idNum <>", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThan(String value) {
            addCriterion("idNum >", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("idNum >=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThan(String value) {
            addCriterion("idNum <", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThanOrEqualTo(String value) {
            addCriterion("idNum <=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLike(String value) {
            addCriterion("idNum like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotLike(String value) {
            addCriterion("idNum not like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumIn(List<String> values) {
            addCriterion("idNum in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotIn(List<String> values) {
            addCriterion("idNum not in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumBetween(String value1, String value2) {
            addCriterion("idNum between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotBetween(String value1, String value2) {
            addCriterion("idNum not between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phoneNum is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phoneNum =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phoneNum <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phoneNum >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNum >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phoneNum <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phoneNum <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phoneNum like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phoneNum not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phoneNum in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phoneNum not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phoneNum between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phoneNum not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNull() {
            addCriterion("bankNumber is null");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNotNull() {
            addCriterion("bankNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumberEqualTo(String value) {
            addCriterion("bankNumber =", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotEqualTo(String value) {
            addCriterion("bankNumber <>", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThan(String value) {
            addCriterion("bankNumber >", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bankNumber >=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThan(String value) {
            addCriterion("bankNumber <", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThanOrEqualTo(String value) {
            addCriterion("bankNumber <=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLike(String value) {
            addCriterion("bankNumber like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotLike(String value) {
            addCriterion("bankNumber not like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberIn(List<String> values) {
            addCriterion("bankNumber in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotIn(List<String> values) {
            addCriterion("bankNumber not in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberBetween(String value1, String value2) {
            addCriterion("bankNumber between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotBetween(String value1, String value2) {
            addCriterion("bankNumber not between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bankName is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bankName is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bankName =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bankName <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bankName >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bankName >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bankName <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bankName <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bankName like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bankName not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bankName in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bankName not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bankName between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bankName not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("homeAddress is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("homeAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("homeAddress =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("homeAddress <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("homeAddress >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("homeAddress >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("homeAddress <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("homeAddress <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("homeAddress like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("homeAddress not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("homeAddress in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("homeAddress not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("homeAddress between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("homeAddress not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("birth is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("birth is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(String value) {
            addCriterion("birth =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(String value) {
            addCriterion("birth <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(String value) {
            addCriterion("birth >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(String value) {
            addCriterion("birth >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(String value) {
            addCriterion("birth <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(String value) {
            addCriterion("birth <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLike(String value) {
            addCriterion("birth like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotLike(String value) {
            addCriterion("birth not like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<String> values) {
            addCriterion("birth in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<String> values) {
            addCriterion("birth not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(String value1, String value2) {
            addCriterion("birth between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(String value1, String value2) {
            addCriterion("birth not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andAgenciesIsNull() {
            addCriterion("agencies is null");
            return (Criteria) this;
        }

        public Criteria andAgenciesIsNotNull() {
            addCriterion("agencies is not null");
            return (Criteria) this;
        }

        public Criteria andAgenciesEqualTo(String value) {
            addCriterion("agencies =", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesNotEqualTo(String value) {
            addCriterion("agencies <>", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesGreaterThan(String value) {
            addCriterion("agencies >", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesGreaterThanOrEqualTo(String value) {
            addCriterion("agencies >=", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesLessThan(String value) {
            addCriterion("agencies <", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesLessThanOrEqualTo(String value) {
            addCriterion("agencies <=", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesLike(String value) {
            addCriterion("agencies like", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesNotLike(String value) {
            addCriterion("agencies not like", value, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesIn(List<String> values) {
            addCriterion("agencies in", values, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesNotIn(List<String> values) {
            addCriterion("agencies not in", values, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesBetween(String value1, String value2) {
            addCriterion("agencies between", value1, value2, "agencies");
            return (Criteria) this;
        }

        public Criteria andAgenciesNotBetween(String value1, String value2) {
            addCriterion("agencies not between", value1, value2, "agencies");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andEthnicIsNull() {
            addCriterion("ethnic is null");
            return (Criteria) this;
        }

        public Criteria andEthnicIsNotNull() {
            addCriterion("ethnic is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicEqualTo(String value) {
            addCriterion("ethnic =", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotEqualTo(String value) {
            addCriterion("ethnic <>", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThan(String value) {
            addCriterion("ethnic >", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThanOrEqualTo(String value) {
            addCriterion("ethnic >=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThan(String value) {
            addCriterion("ethnic <", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThanOrEqualTo(String value) {
            addCriterion("ethnic <=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLike(String value) {
            addCriterion("ethnic like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotLike(String value) {
            addCriterion("ethnic not like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicIn(List<String> values) {
            addCriterion("ethnic in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotIn(List<String> values) {
            addCriterion("ethnic not in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicBetween(String value1, String value2) {
            addCriterion("ethnic between", value1, value2, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotBetween(String value1, String value2) {
            addCriterion("ethnic not between", value1, value2, "ethnic");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitIsNull() {
            addCriterion("idCardTimeLimit is null");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitIsNotNull() {
            addCriterion("idCardTimeLimit is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitEqualTo(String value) {
            addCriterion("idCardTimeLimit =", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitNotEqualTo(String value) {
            addCriterion("idCardTimeLimit <>", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitGreaterThan(String value) {
            addCriterion("idCardTimeLimit >", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitGreaterThanOrEqualTo(String value) {
            addCriterion("idCardTimeLimit >=", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitLessThan(String value) {
            addCriterion("idCardTimeLimit <", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitLessThanOrEqualTo(String value) {
            addCriterion("idCardTimeLimit <=", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitLike(String value) {
            addCriterion("idCardTimeLimit like", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitNotLike(String value) {
            addCriterion("idCardTimeLimit not like", value, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitIn(List<String> values) {
            addCriterion("idCardTimeLimit in", values, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitNotIn(List<String> values) {
            addCriterion("idCardTimeLimit not in", values, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitBetween(String value1, String value2) {
            addCriterion("idCardTimeLimit between", value1, value2, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andIdCardTimeLimitNotBetween(String value1, String value2) {
            addCriterion("idCardTimeLimit not between", value1, value2, "idCardTimeLimit");
            return (Criteria) this;
        }

        public Criteria andId0PathIsNull() {
            addCriterion("id0Path is null");
            return (Criteria) this;
        }

        public Criteria andId0PathIsNotNull() {
            addCriterion("id0Path is not null");
            return (Criteria) this;
        }

        public Criteria andId0PathEqualTo(String value) {
            addCriterion("id0Path =", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathNotEqualTo(String value) {
            addCriterion("id0Path <>", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathGreaterThan(String value) {
            addCriterion("id0Path >", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathGreaterThanOrEqualTo(String value) {
            addCriterion("id0Path >=", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathLessThan(String value) {
            addCriterion("id0Path <", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathLessThanOrEqualTo(String value) {
            addCriterion("id0Path <=", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathLike(String value) {
            addCriterion("id0Path like", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathNotLike(String value) {
            addCriterion("id0Path not like", value, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathIn(List<String> values) {
            addCriterion("id0Path in", values, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathNotIn(List<String> values) {
            addCriterion("id0Path not in", values, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathBetween(String value1, String value2) {
            addCriterion("id0Path between", value1, value2, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId0PathNotBetween(String value1, String value2) {
            addCriterion("id0Path not between", value1, value2, "id0Path");
            return (Criteria) this;
        }

        public Criteria andId1PathIsNull() {
            addCriterion("id1Path is null");
            return (Criteria) this;
        }

        public Criteria andId1PathIsNotNull() {
            addCriterion("id1Path is not null");
            return (Criteria) this;
        }

        public Criteria andId1PathEqualTo(String value) {
            addCriterion("id1Path =", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathNotEqualTo(String value) {
            addCriterion("id1Path <>", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathGreaterThan(String value) {
            addCriterion("id1Path >", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathGreaterThanOrEqualTo(String value) {
            addCriterion("id1Path >=", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathLessThan(String value) {
            addCriterion("id1Path <", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathLessThanOrEqualTo(String value) {
            addCriterion("id1Path <=", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathLike(String value) {
            addCriterion("id1Path like", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathNotLike(String value) {
            addCriterion("id1Path not like", value, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathIn(List<String> values) {
            addCriterion("id1Path in", values, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathNotIn(List<String> values) {
            addCriterion("id1Path not in", values, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathBetween(String value1, String value2) {
            addCriterion("id1Path between", value1, value2, "id1Path");
            return (Criteria) this;
        }

        public Criteria andId1PathNotBetween(String value1, String value2) {
            addCriterion("id1Path not between", value1, value2, "id1Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathIsNull() {
            addCriterion("bank0Path is null");
            return (Criteria) this;
        }

        public Criteria andBank0PathIsNotNull() {
            addCriterion("bank0Path is not null");
            return (Criteria) this;
        }

        public Criteria andBank0PathEqualTo(String value) {
            addCriterion("bank0Path =", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathNotEqualTo(String value) {
            addCriterion("bank0Path <>", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathGreaterThan(String value) {
            addCriterion("bank0Path >", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathGreaterThanOrEqualTo(String value) {
            addCriterion("bank0Path >=", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathLessThan(String value) {
            addCriterion("bank0Path <", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathLessThanOrEqualTo(String value) {
            addCriterion("bank0Path <=", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathLike(String value) {
            addCriterion("bank0Path like", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathNotLike(String value) {
            addCriterion("bank0Path not like", value, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathIn(List<String> values) {
            addCriterion("bank0Path in", values, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathNotIn(List<String> values) {
            addCriterion("bank0Path not in", values, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathBetween(String value1, String value2) {
            addCriterion("bank0Path between", value1, value2, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank0PathNotBetween(String value1, String value2) {
            addCriterion("bank0Path not between", value1, value2, "bank0Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathIsNull() {
            addCriterion("bank1Path is null");
            return (Criteria) this;
        }

        public Criteria andBank1PathIsNotNull() {
            addCriterion("bank1Path is not null");
            return (Criteria) this;
        }

        public Criteria andBank1PathEqualTo(String value) {
            addCriterion("bank1Path =", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathNotEqualTo(String value) {
            addCriterion("bank1Path <>", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathGreaterThan(String value) {
            addCriterion("bank1Path >", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathGreaterThanOrEqualTo(String value) {
            addCriterion("bank1Path >=", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathLessThan(String value) {
            addCriterion("bank1Path <", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathLessThanOrEqualTo(String value) {
            addCriterion("bank1Path <=", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathLike(String value) {
            addCriterion("bank1Path like", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathNotLike(String value) {
            addCriterion("bank1Path not like", value, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathIn(List<String> values) {
            addCriterion("bank1Path in", values, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathNotIn(List<String> values) {
            addCriterion("bank1Path not in", values, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathBetween(String value1, String value2) {
            addCriterion("bank1Path between", value1, value2, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andBank1PathNotBetween(String value1, String value2) {
            addCriterion("bank1Path not between", value1, value2, "bank1Path");
            return (Criteria) this;
        }

        public Criteria andStstusIsNull() {
            addCriterion("ststus is null");
            return (Criteria) this;
        }

        public Criteria andStstusIsNotNull() {
            addCriterion("ststus is not null");
            return (Criteria) this;
        }

        public Criteria andStstusEqualTo(Integer value) {
            addCriterion("ststus =", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusNotEqualTo(Integer value) {
            addCriterion("ststus <>", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusGreaterThan(Integer value) {
            addCriterion("ststus >", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ststus >=", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusLessThan(Integer value) {
            addCriterion("ststus <", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusLessThanOrEqualTo(Integer value) {
            addCriterion("ststus <=", value, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusIn(List<Integer> values) {
            addCriterion("ststus in", values, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusNotIn(List<Integer> values) {
            addCriterion("ststus not in", values, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusBetween(Integer value1, Integer value2) {
            addCriterion("ststus between", value1, value2, "ststus");
            return (Criteria) this;
        }

        public Criteria andStstusNotBetween(Integer value1, Integer value2) {
            addCriterion("ststus not between", value1, value2, "ststus");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("updateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("updateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("updateBy =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("updateBy <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("updateBy >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("updateBy >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("updateBy <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("updateBy <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("updateBy in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("updateBy not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("updateBy between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("updateBy not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeIsNull() {
            addCriterion("check1Time is null");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeIsNotNull() {
            addCriterion("check1Time is not null");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeEqualTo(Date value) {
            addCriterion("check1Time =", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeNotEqualTo(Date value) {
            addCriterion("check1Time <>", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeGreaterThan(Date value) {
            addCriterion("check1Time >", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check1Time >=", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeLessThan(Date value) {
            addCriterion("check1Time <", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeLessThanOrEqualTo(Date value) {
            addCriterion("check1Time <=", value, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeIn(List<Date> values) {
            addCriterion("check1Time in", values, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeNotIn(List<Date> values) {
            addCriterion("check1Time not in", values, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeBetween(Date value1, Date value2) {
            addCriterion("check1Time between", value1, value2, "check1Time");
            return (Criteria) this;
        }

        public Criteria andCheck1TimeNotBetween(Date value1, Date value2) {
            addCriterion("check1Time not between", value1, value2, "check1Time");
            return (Criteria) this;
        }

        public Criteria andChech1ByIsNull() {
            addCriterion("chech1By is null");
            return (Criteria) this;
        }

        public Criteria andChech1ByIsNotNull() {
            addCriterion("chech1By is not null");
            return (Criteria) this;
        }

        public Criteria andChech1ByEqualTo(Long value) {
            addCriterion("chech1By =", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByNotEqualTo(Long value) {
            addCriterion("chech1By <>", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByGreaterThan(Long value) {
            addCriterion("chech1By >", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByGreaterThanOrEqualTo(Long value) {
            addCriterion("chech1By >=", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByLessThan(Long value) {
            addCriterion("chech1By <", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByLessThanOrEqualTo(Long value) {
            addCriterion("chech1By <=", value, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByIn(List<Long> values) {
            addCriterion("chech1By in", values, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByNotIn(List<Long> values) {
            addCriterion("chech1By not in", values, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByBetween(Long value1, Long value2) {
            addCriterion("chech1By between", value1, value2, "chech1By");
            return (Criteria) this;
        }

        public Criteria andChech1ByNotBetween(Long value1, Long value2) {
            addCriterion("chech1By not between", value1, value2, "chech1By");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteIsNull() {
            addCriterion("check1Note is null");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteIsNotNull() {
            addCriterion("check1Note is not null");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteEqualTo(String value) {
            addCriterion("check1Note =", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteNotEqualTo(String value) {
            addCriterion("check1Note <>", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteGreaterThan(String value) {
            addCriterion("check1Note >", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteGreaterThanOrEqualTo(String value) {
            addCriterion("check1Note >=", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteLessThan(String value) {
            addCriterion("check1Note <", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteLessThanOrEqualTo(String value) {
            addCriterion("check1Note <=", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteLike(String value) {
            addCriterion("check1Note like", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteNotLike(String value) {
            addCriterion("check1Note not like", value, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteIn(List<String> values) {
            addCriterion("check1Note in", values, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteNotIn(List<String> values) {
            addCriterion("check1Note not in", values, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteBetween(String value1, String value2) {
            addCriterion("check1Note between", value1, value2, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck1NoteNotBetween(String value1, String value2) {
            addCriterion("check1Note not between", value1, value2, "check1Note");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeIsNull() {
            addCriterion("check2Time is null");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeIsNotNull() {
            addCriterion("check2Time is not null");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeEqualTo(Date value) {
            addCriterion("check2Time =", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeNotEqualTo(Date value) {
            addCriterion("check2Time <>", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeGreaterThan(Date value) {
            addCriterion("check2Time >", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check2Time >=", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeLessThan(Date value) {
            addCriterion("check2Time <", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeLessThanOrEqualTo(Date value) {
            addCriterion("check2Time <=", value, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeIn(List<Date> values) {
            addCriterion("check2Time in", values, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeNotIn(List<Date> values) {
            addCriterion("check2Time not in", values, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeBetween(Date value1, Date value2) {
            addCriterion("check2Time between", value1, value2, "check2Time");
            return (Criteria) this;
        }

        public Criteria andCheck2TimeNotBetween(Date value1, Date value2) {
            addCriterion("check2Time not between", value1, value2, "check2Time");
            return (Criteria) this;
        }

        public Criteria andChech2ByIsNull() {
            addCriterion("chech2By is null");
            return (Criteria) this;
        }

        public Criteria andChech2ByIsNotNull() {
            addCriterion("chech2By is not null");
            return (Criteria) this;
        }

        public Criteria andChech2ByEqualTo(Long value) {
            addCriterion("chech2By =", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByNotEqualTo(Long value) {
            addCriterion("chech2By <>", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByGreaterThan(Long value) {
            addCriterion("chech2By >", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByGreaterThanOrEqualTo(Long value) {
            addCriterion("chech2By >=", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByLessThan(Long value) {
            addCriterion("chech2By <", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByLessThanOrEqualTo(Long value) {
            addCriterion("chech2By <=", value, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByIn(List<Long> values) {
            addCriterion("chech2By in", values, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByNotIn(List<Long> values) {
            addCriterion("chech2By not in", values, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByBetween(Long value1, Long value2) {
            addCriterion("chech2By between", value1, value2, "chech2By");
            return (Criteria) this;
        }

        public Criteria andChech2ByNotBetween(Long value1, Long value2) {
            addCriterion("chech2By not between", value1, value2, "chech2By");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteIsNull() {
            addCriterion("check2Note is null");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteIsNotNull() {
            addCriterion("check2Note is not null");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteEqualTo(String value) {
            addCriterion("check2Note =", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteNotEqualTo(String value) {
            addCriterion("check2Note <>", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteGreaterThan(String value) {
            addCriterion("check2Note >", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteGreaterThanOrEqualTo(String value) {
            addCriterion("check2Note >=", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteLessThan(String value) {
            addCriterion("check2Note <", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteLessThanOrEqualTo(String value) {
            addCriterion("check2Note <=", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteLike(String value) {
            addCriterion("check2Note like", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteNotLike(String value) {
            addCriterion("check2Note not like", value, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteIn(List<String> values) {
            addCriterion("check2Note in", values, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteNotIn(List<String> values) {
            addCriterion("check2Note not in", values, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteBetween(String value1, String value2) {
            addCriterion("check2Note between", value1, value2, "check2Note");
            return (Criteria) this;
        }

        public Criteria andCheck2NoteNotBetween(String value1, String value2) {
            addCriterion("check2Note not between", value1, value2, "check2Note");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}