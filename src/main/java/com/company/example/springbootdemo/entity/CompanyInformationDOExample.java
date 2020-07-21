package com.company.example.springbootdemo.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyInformationDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInformationDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIsNull() {
            addCriterion("company_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIsNotNull() {
            addCriterion("company_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeEqualTo(Integer value) {
            addCriterion("company_credit_code =", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotEqualTo(Integer value) {
            addCriterion("company_credit_code <>", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeGreaterThan(Integer value) {
            addCriterion("company_credit_code >", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_credit_code >=", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeLessThan(Integer value) {
            addCriterion("company_credit_code <", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeLessThanOrEqualTo(Integer value) {
            addCriterion("company_credit_code <=", value, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeIn(List<Integer> values) {
            addCriterion("company_credit_code in", values, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotIn(List<Integer> values) {
            addCriterion("company_credit_code not in", values, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeBetween(Integer value1, Integer value2) {
            addCriterion("company_credit_code between", value1, value2, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCreditCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("company_credit_code not between", value1, value2, "companyCreditCode");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIsNull() {
            addCriterion("company_legal_person is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIsNotNull() {
            addCriterion("company_legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonEqualTo(String value) {
            addCriterion("company_legal_person =", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotEqualTo(String value) {
            addCriterion("company_legal_person <>", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonGreaterThan(String value) {
            addCriterion("company_legal_person >", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("company_legal_person >=", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLessThan(String value) {
            addCriterion("company_legal_person <", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("company_legal_person <=", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLike(String value) {
            addCriterion("company_legal_person like", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotLike(String value) {
            addCriterion("company_legal_person not like", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIn(List<String> values) {
            addCriterion("company_legal_person in", values, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotIn(List<String> values) {
            addCriterion("company_legal_person not in", values, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonBetween(String value1, String value2) {
            addCriterion("company_legal_person between", value1, value2, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotBetween(String value1, String value2) {
            addCriterion("company_legal_person not between", value1, value2, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumIsNull() {
            addCriterion("company_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumIsNotNull() {
            addCriterion("company_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumEqualTo(String value) {
            addCriterion("company_phone_num =", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumNotEqualTo(String value) {
            addCriterion("company_phone_num <>", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumGreaterThan(String value) {
            addCriterion("company_phone_num >", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("company_phone_num >=", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumLessThan(String value) {
            addCriterion("company_phone_num <", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("company_phone_num <=", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumLike(String value) {
            addCriterion("company_phone_num like", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumNotLike(String value) {
            addCriterion("company_phone_num not like", value, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumIn(List<String> values) {
            addCriterion("company_phone_num in", values, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumNotIn(List<String> values) {
            addCriterion("company_phone_num not in", values, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumBetween(String value1, String value2) {
            addCriterion("company_phone_num between", value1, value2, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNumNotBetween(String value1, String value2) {
            addCriterion("company_phone_num not between", value1, value2, "companyPhoneNum");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlIsNull() {
            addCriterion("company_image_url is null");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlIsNotNull() {
            addCriterion("company_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlEqualTo(String value) {
            addCriterion("company_image_url =", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlNotEqualTo(String value) {
            addCriterion("company_image_url <>", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlGreaterThan(String value) {
            addCriterion("company_image_url >", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("company_image_url >=", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlLessThan(String value) {
            addCriterion("company_image_url <", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlLessThanOrEqualTo(String value) {
            addCriterion("company_image_url <=", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlLike(String value) {
            addCriterion("company_image_url like", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlNotLike(String value) {
            addCriterion("company_image_url not like", value, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlIn(List<String> values) {
            addCriterion("company_image_url in", values, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlNotIn(List<String> values) {
            addCriterion("company_image_url not in", values, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlBetween(String value1, String value2) {
            addCriterion("company_image_url between", value1, value2, "companyImageUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyImageUrlNotBetween(String value1, String value2) {
            addCriterion("company_image_url not between", value1, value2, "companyImageUrl");
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
    }
}