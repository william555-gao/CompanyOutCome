package com.company.example.springbootdemo.entity;

import java.util.ArrayList;
import java.util.List;

public class IndustryDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndustryDOExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIndustryIdIsNull() {
            addCriterion("industry_id is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIsNotNull() {
            addCriterion("industry_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdEqualTo(Integer value) {
            addCriterion("industry_id =", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotEqualTo(Integer value) {
            addCriterion("industry_id <>", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThan(Integer value) {
            addCriterion("industry_id >", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry_id >=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThan(Integer value) {
            addCriterion("industry_id <", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThanOrEqualTo(Integer value) {
            addCriterion("industry_id <=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIn(List<Integer> values) {
            addCriterion("industry_id in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotIn(List<Integer> values) {
            addCriterion("industry_id not in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdBetween(Integer value1, Integer value2) {
            addCriterion("industry_id between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("industry_id not between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNull() {
            addCriterion("industry_name is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNotNull() {
            addCriterion("industry_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEqualTo(String value) {
            addCriterion("industry_name =", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotEqualTo(String value) {
            addCriterion("industry_name <>", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThan(String value) {
            addCriterion("industry_name >", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThanOrEqualTo(String value) {
            addCriterion("industry_name >=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThan(String value) {
            addCriterion("industry_name <", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThanOrEqualTo(String value) {
            addCriterion("industry_name <=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLike(String value) {
            addCriterion("industry_name like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotLike(String value) {
            addCriterion("industry_name not like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIn(List<String> values) {
            addCriterion("industry_name in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotIn(List<String> values) {
            addCriterion("industry_name not in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameBetween(String value1, String value2) {
            addCriterion("industry_name between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotBetween(String value1, String value2) {
            addCriterion("industry_name not between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionIsNull() {
            addCriterion("industry_description is null");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionIsNotNull() {
            addCriterion("industry_description is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionEqualTo(String value) {
            addCriterion("industry_description =", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionNotEqualTo(String value) {
            addCriterion("industry_description <>", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionGreaterThan(String value) {
            addCriterion("industry_description >", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("industry_description >=", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionLessThan(String value) {
            addCriterion("industry_description <", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionLessThanOrEqualTo(String value) {
            addCriterion("industry_description <=", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionLike(String value) {
            addCriterion("industry_description like", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionNotLike(String value) {
            addCriterion("industry_description not like", value, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionIn(List<String> values) {
            addCriterion("industry_description in", values, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionNotIn(List<String> values) {
            addCriterion("industry_description not in", values, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionBetween(String value1, String value2) {
            addCriterion("industry_description between", value1, value2, "industryDescription");
            return (Criteria) this;
        }

        public Criteria andIndustryDescriptionNotBetween(String value1, String value2) {
            addCriterion("industry_description not between", value1, value2, "industryDescription");
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