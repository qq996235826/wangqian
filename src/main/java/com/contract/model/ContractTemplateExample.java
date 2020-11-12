package com.contract.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractTemplateExample() {
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

        public Criteria andIsUsingIsNull() {
            addCriterion("isUsing is null");
            return (Criteria) this;
        }

        public Criteria andIsUsingIsNotNull() {
            addCriterion("isUsing is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsingEqualTo(Boolean value) {
            addCriterion("isUsing =", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingNotEqualTo(Boolean value) {
            addCriterion("isUsing <>", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingGreaterThan(Boolean value) {
            addCriterion("isUsing >", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isUsing >=", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingLessThan(Boolean value) {
            addCriterion("isUsing <", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingLessThanOrEqualTo(Boolean value) {
            addCriterion("isUsing <=", value, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingIn(List<Boolean> values) {
            addCriterion("isUsing in", values, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingNotIn(List<Boolean> values) {
            addCriterion("isUsing not in", values, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingBetween(Boolean value1, Boolean value2) {
            addCriterion("isUsing between", value1, value2, "isUsing");
            return (Criteria) this;
        }

        public Criteria andIsUsingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isUsing not between", value1, value2, "isUsing");
            return (Criteria) this;
        }

        public Criteria andVersionNumIsNull() {
            addCriterion("versionNum is null");
            return (Criteria) this;
        }

        public Criteria andVersionNumIsNotNull() {
            addCriterion("versionNum is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNumEqualTo(String value) {
            addCriterion("versionNum =", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotEqualTo(String value) {
            addCriterion("versionNum <>", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumGreaterThan(String value) {
            addCriterion("versionNum >", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumGreaterThanOrEqualTo(String value) {
            addCriterion("versionNum >=", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLessThan(String value) {
            addCriterion("versionNum <", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLessThanOrEqualTo(String value) {
            addCriterion("versionNum <=", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumLike(String value) {
            addCriterion("versionNum like", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotLike(String value) {
            addCriterion("versionNum not like", value, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumIn(List<String> values) {
            addCriterion("versionNum in", values, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotIn(List<String> values) {
            addCriterion("versionNum not in", values, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumBetween(String value1, String value2) {
            addCriterion("versionNum between", value1, value2, "versionNum");
            return (Criteria) this;
        }

        public Criteria andVersionNumNotBetween(String value1, String value2) {
            addCriterion("versionNum not between", value1, value2, "versionNum");
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

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andOssUrlIsNull() {
            addCriterion("ossUrl is null");
            return (Criteria) this;
        }

        public Criteria andOssUrlIsNotNull() {
            addCriterion("ossUrl is not null");
            return (Criteria) this;
        }

        public Criteria andOssUrlEqualTo(String value) {
            addCriterion("ossUrl =", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotEqualTo(String value) {
            addCriterion("ossUrl <>", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlGreaterThan(String value) {
            addCriterion("ossUrl >", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ossUrl >=", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLessThan(String value) {
            addCriterion("ossUrl <", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLessThanOrEqualTo(String value) {
            addCriterion("ossUrl <=", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLike(String value) {
            addCriterion("ossUrl like", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotLike(String value) {
            addCriterion("ossUrl not like", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlIn(List<String> values) {
            addCriterion("ossUrl in", values, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotIn(List<String> values) {
            addCriterion("ossUrl not in", values, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlBetween(String value1, String value2) {
            addCriterion("ossUrl between", value1, value2, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotBetween(String value1, String value2) {
            addCriterion("ossUrl not between", value1, value2, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andPdfPathIsNull() {
            addCriterion("pdfPath is null");
            return (Criteria) this;
        }

        public Criteria andPdfPathIsNotNull() {
            addCriterion("pdfPath is not null");
            return (Criteria) this;
        }

        public Criteria andPdfPathEqualTo(String value) {
            addCriterion("pdfPath =", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotEqualTo(String value) {
            addCriterion("pdfPath <>", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathGreaterThan(String value) {
            addCriterion("pdfPath >", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathGreaterThanOrEqualTo(String value) {
            addCriterion("pdfPath >=", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLessThan(String value) {
            addCriterion("pdfPath <", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLessThanOrEqualTo(String value) {
            addCriterion("pdfPath <=", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLike(String value) {
            addCriterion("pdfPath like", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotLike(String value) {
            addCriterion("pdfPath not like", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathIn(List<String> values) {
            addCriterion("pdfPath in", values, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotIn(List<String> values) {
            addCriterion("pdfPath not in", values, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathBetween(String value1, String value2) {
            addCriterion("pdfPath between", value1, value2, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotBetween(String value1, String value2) {
            addCriterion("pdfPath not between", value1, value2, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathIsNull() {
            addCriterion("jpgPath is null");
            return (Criteria) this;
        }

        public Criteria andJpgPathIsNotNull() {
            addCriterion("jpgPath is not null");
            return (Criteria) this;
        }

        public Criteria andJpgPathEqualTo(String value) {
            addCriterion("jpgPath =", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathNotEqualTo(String value) {
            addCriterion("jpgPath <>", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathGreaterThan(String value) {
            addCriterion("jpgPath >", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathGreaterThanOrEqualTo(String value) {
            addCriterion("jpgPath >=", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathLessThan(String value) {
            addCriterion("jpgPath <", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathLessThanOrEqualTo(String value) {
            addCriterion("jpgPath <=", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathLike(String value) {
            addCriterion("jpgPath like", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathNotLike(String value) {
            addCriterion("jpgPath not like", value, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathIn(List<String> values) {
            addCriterion("jpgPath in", values, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathNotIn(List<String> values) {
            addCriterion("jpgPath not in", values, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathBetween(String value1, String value2) {
            addCriterion("jpgPath between", value1, value2, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgPathNotBetween(String value1, String value2) {
            addCriterion("jpgPath not between", value1, value2, "jpgPath");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlIsNull() {
            addCriterion("jpgOssUrl is null");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlIsNotNull() {
            addCriterion("jpgOssUrl is not null");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlEqualTo(String value) {
            addCriterion("jpgOssUrl =", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlNotEqualTo(String value) {
            addCriterion("jpgOssUrl <>", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlGreaterThan(String value) {
            addCriterion("jpgOssUrl >", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlGreaterThanOrEqualTo(String value) {
            addCriterion("jpgOssUrl >=", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlLessThan(String value) {
            addCriterion("jpgOssUrl <", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlLessThanOrEqualTo(String value) {
            addCriterion("jpgOssUrl <=", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlLike(String value) {
            addCriterion("jpgOssUrl like", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlNotLike(String value) {
            addCriterion("jpgOssUrl not like", value, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlIn(List<String> values) {
            addCriterion("jpgOssUrl in", values, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlNotIn(List<String> values) {
            addCriterion("jpgOssUrl not in", values, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlBetween(String value1, String value2) {
            addCriterion("jpgOssUrl between", value1, value2, "jpgOssUrl");
            return (Criteria) this;
        }

        public Criteria andJpgOssUrlNotBetween(String value1, String value2) {
            addCriterion("jpgOssUrl not between", value1, value2, "jpgOssUrl");
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