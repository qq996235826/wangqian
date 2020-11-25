package com.contract.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andTemplateIdIsNull() {
            addCriterion("templateId is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("templateId is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            addCriterion("templateId =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            addCriterion("templateId <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            addCriterion("templateId >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("templateId >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            addCriterion("templateId <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("templateId <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            addCriterion("templateId in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            addCriterion("templateId not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            addCriterion("templateId between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("templateId not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplierId is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplierId is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplierId =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplierId <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplierId >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplierId >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplierId <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplierId <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplierId in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplierId not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplierId between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplierId not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("itemName =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("itemName <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("itemName like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("itemName not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("itemName in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("companyName =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("companyName <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("companyName like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("companyName not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("companyName in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyName");
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

        public Criteria andBranchBankNameIsNull() {
            addCriterion("branchBankName is null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameIsNotNull() {
            addCriterion("branchBankName is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameEqualTo(String value) {
            addCriterion("branchBankName =", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotEqualTo(String value) {
            addCriterion("branchBankName <>", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameGreaterThan(String value) {
            addCriterion("branchBankName >", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("branchBankName >=", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLessThan(String value) {
            addCriterion("branchBankName <", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLessThanOrEqualTo(String value) {
            addCriterion("branchBankName <=", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLike(String value) {
            addCriterion("branchBankName like", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotLike(String value) {
            addCriterion("branchBankName not like", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameIn(List<String> values) {
            addCriterion("branchBankName in", values, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotIn(List<String> values) {
            addCriterion("branchBankName not in", values, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameBetween(String value1, String value2) {
            addCriterion("branchBankName between", value1, value2, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotBetween(String value1, String value2) {
            addCriterion("branchBankName not between", value1, value2, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNull() {
            addCriterion("bankNum is null");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNotNull() {
            addCriterion("bankNum is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumEqualTo(String value) {
            addCriterion("bankNum =", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotEqualTo(String value) {
            addCriterion("bankNum <>", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThan(String value) {
            addCriterion("bankNum >", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThanOrEqualTo(String value) {
            addCriterion("bankNum >=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThan(String value) {
            addCriterion("bankNum <", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThanOrEqualTo(String value) {
            addCriterion("bankNum <=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLike(String value) {
            addCriterion("bankNum like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotLike(String value) {
            addCriterion("bankNum not like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumIn(List<String> values) {
            addCriterion("bankNum in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotIn(List<String> values) {
            addCriterion("bankNum not in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumBetween(String value1, String value2) {
            addCriterion("bankNum between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotBetween(String value1, String value2) {
            addCriterion("bankNum not between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankImagePathIsNull() {
            addCriterion("bankImagePath is null");
            return (Criteria) this;
        }

        public Criteria andBankImagePathIsNotNull() {
            addCriterion("bankImagePath is not null");
            return (Criteria) this;
        }

        public Criteria andBankImagePathEqualTo(String value) {
            addCriterion("bankImagePath =", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathNotEqualTo(String value) {
            addCriterion("bankImagePath <>", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathGreaterThan(String value) {
            addCriterion("bankImagePath >", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("bankImagePath >=", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathLessThan(String value) {
            addCriterion("bankImagePath <", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathLessThanOrEqualTo(String value) {
            addCriterion("bankImagePath <=", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathLike(String value) {
            addCriterion("bankImagePath like", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathNotLike(String value) {
            addCriterion("bankImagePath not like", value, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathIn(List<String> values) {
            addCriterion("bankImagePath in", values, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathNotIn(List<String> values) {
            addCriterion("bankImagePath not in", values, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathBetween(String value1, String value2) {
            addCriterion("bankImagePath between", value1, value2, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andBankImagePathNotBetween(String value1, String value2) {
            addCriterion("bankImagePath not between", value1, value2, "bankImagePath");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("orderNum =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("orderNum >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("orderNum <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("orderNum like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("orderNum not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("orderNum in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andChech2BbyIsNull() {
            addCriterion("chech2Bby is null");
            return (Criteria) this;
        }

        public Criteria andChech2BbyIsNotNull() {
            addCriterion("chech2Bby is not null");
            return (Criteria) this;
        }

        public Criteria andChech2BbyEqualTo(Long value) {
            addCriterion("chech2Bby =", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyNotEqualTo(Long value) {
            addCriterion("chech2Bby <>", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyGreaterThan(Long value) {
            addCriterion("chech2Bby >", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyGreaterThanOrEqualTo(Long value) {
            addCriterion("chech2Bby >=", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyLessThan(Long value) {
            addCriterion("chech2Bby <", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyLessThanOrEqualTo(Long value) {
            addCriterion("chech2Bby <=", value, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyIn(List<Long> values) {
            addCriterion("chech2Bby in", values, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyNotIn(List<Long> values) {
            addCriterion("chech2Bby not in", values, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyBetween(Long value1, Long value2) {
            addCriterion("chech2Bby between", value1, value2, "chech2Bby");
            return (Criteria) this;
        }

        public Criteria andChech2BbyNotBetween(Long value1, Long value2) {
            addCriterion("chech2Bby not between", value1, value2, "chech2Bby");
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

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andOssPathIsNull() {
            addCriterion("ossPath is null");
            return (Criteria) this;
        }

        public Criteria andOssPathIsNotNull() {
            addCriterion("ossPath is not null");
            return (Criteria) this;
        }

        public Criteria andOssPathEqualTo(String value) {
            addCriterion("ossPath =", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotEqualTo(String value) {
            addCriterion("ossPath <>", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathGreaterThan(String value) {
            addCriterion("ossPath >", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathGreaterThanOrEqualTo(String value) {
            addCriterion("ossPath >=", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLessThan(String value) {
            addCriterion("ossPath <", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLessThanOrEqualTo(String value) {
            addCriterion("ossPath <=", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathLike(String value) {
            addCriterion("ossPath like", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotLike(String value) {
            addCriterion("ossPath not like", value, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathIn(List<String> values) {
            addCriterion("ossPath in", values, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotIn(List<String> values) {
            addCriterion("ossPath not in", values, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathBetween(String value1, String value2) {
            addCriterion("ossPath between", value1, value2, "ossPath");
            return (Criteria) this;
        }

        public Criteria andOssPathNotBetween(String value1, String value2) {
            addCriterion("ossPath not between", value1, value2, "ossPath");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("startDate =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("startDate <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("startDate >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("startDate >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("startDate <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("startDate <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("startDate like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("startDate not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("startDate in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("startDate not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("startDate between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("startDate not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("endDate =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("endDate <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("endDate >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("endDate >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("endDate <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("endDate <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("endDate like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("endDate not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("endDate in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("endDate not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("endDate between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("endDate not between", value1, value2, "endDate");
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