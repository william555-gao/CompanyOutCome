package com.company.example.springbootdemo.entity;

import java.util.ArrayList;
import java.util.List;

public class OutcomeInformationDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutcomeInformationDOExample() {
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

        public Criteria andOutcomeIdIsNull() {
            addCriterion("outcome_id is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdIsNotNull() {
            addCriterion("outcome_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdEqualTo(Integer value) {
            addCriterion("outcome_id =", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdNotEqualTo(Integer value) {
            addCriterion("outcome_id <>", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdGreaterThan(Integer value) {
            addCriterion("outcome_id >", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("outcome_id >=", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdLessThan(Integer value) {
            addCriterion("outcome_id <", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("outcome_id <=", value, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdIn(List<Integer> values) {
            addCriterion("outcome_id in", values, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdNotIn(List<Integer> values) {
            addCriterion("outcome_id not in", values, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdBetween(Integer value1, Integer value2) {
            addCriterion("outcome_id between", value1, value2, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("outcome_id not between", value1, value2, "outcomeId");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameIsNull() {
            addCriterion("outcome_name is null");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameIsNotNull() {
            addCriterion("outcome_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameEqualTo(String value) {
            addCriterion("outcome_name =", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameNotEqualTo(String value) {
            addCriterion("outcome_name <>", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameGreaterThan(String value) {
            addCriterion("outcome_name >", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameGreaterThanOrEqualTo(String value) {
            addCriterion("outcome_name >=", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameLessThan(String value) {
            addCriterion("outcome_name <", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameLessThanOrEqualTo(String value) {
            addCriterion("outcome_name <=", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameLike(String value) {
            addCriterion("outcome_name like", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameNotLike(String value) {
            addCriterion("outcome_name not like", value, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameIn(List<String> values) {
            addCriterion("outcome_name in", values, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameNotIn(List<String> values) {
            addCriterion("outcome_name not in", values, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameBetween(String value1, String value2) {
            addCriterion("outcome_name between", value1, value2, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andOutcomeNameNotBetween(String value1, String value2) {
            addCriterion("outcome_name not between", value1, value2, "outcomeName");
            return (Criteria) this;
        }

        public Criteria andBelongDomainIsNull() {
            addCriterion("belong_domain is null");
            return (Criteria) this;
        }

        public Criteria andBelongDomainIsNotNull() {
            addCriterion("belong_domain is not null");
            return (Criteria) this;
        }

        public Criteria andBelongDomainEqualTo(String value) {
            addCriterion("belong_domain =", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainNotEqualTo(String value) {
            addCriterion("belong_domain <>", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainGreaterThan(String value) {
            addCriterion("belong_domain >", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainGreaterThanOrEqualTo(String value) {
            addCriterion("belong_domain >=", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainLessThan(String value) {
            addCriterion("belong_domain <", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainLessThanOrEqualTo(String value) {
            addCriterion("belong_domain <=", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainLike(String value) {
            addCriterion("belong_domain like", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainNotLike(String value) {
            addCriterion("belong_domain not like", value, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainIn(List<String> values) {
            addCriterion("belong_domain in", values, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainNotIn(List<String> values) {
            addCriterion("belong_domain not in", values, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainBetween(String value1, String value2) {
            addCriterion("belong_domain between", value1, value2, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andBelongDomainNotBetween(String value1, String value2) {
            addCriterion("belong_domain not between", value1, value2, "belongDomain");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIsNull() {
            addCriterion("cooperation_type is null");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIsNotNull() {
            addCriterion("cooperation_type is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeEqualTo(String value) {
            addCriterion("cooperation_type =", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotEqualTo(String value) {
            addCriterion("cooperation_type <>", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeGreaterThan(String value) {
            addCriterion("cooperation_type >", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_type >=", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeLessThan(String value) {
            addCriterion("cooperation_type <", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeLessThanOrEqualTo(String value) {
            addCriterion("cooperation_type <=", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeLike(String value) {
            addCriterion("cooperation_type like", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotLike(String value) {
            addCriterion("cooperation_type not like", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIn(List<String> values) {
            addCriterion("cooperation_type in", values, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotIn(List<String> values) {
            addCriterion("cooperation_type not in", values, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeBetween(String value1, String value2) {
            addCriterion("cooperation_type between", value1, value2, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotBetween(String value1, String value2) {
            addCriterion("cooperation_type not between", value1, value2, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceIsNull() {
            addCriterion("transaction_price is null");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceIsNotNull() {
            addCriterion("transaction_price is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceEqualTo(String value) {
            addCriterion("transaction_price =", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceNotEqualTo(String value) {
            addCriterion("transaction_price <>", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceGreaterThan(String value) {
            addCriterion("transaction_price >", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_price >=", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceLessThan(String value) {
            addCriterion("transaction_price <", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceLessThanOrEqualTo(String value) {
            addCriterion("transaction_price <=", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceLike(String value) {
            addCriterion("transaction_price like", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceNotLike(String value) {
            addCriterion("transaction_price not like", value, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceIn(List<String> values) {
            addCriterion("transaction_price in", values, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceNotIn(List<String> values) {
            addCriterion("transaction_price not in", values, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceBetween(String value1, String value2) {
            addCriterion("transaction_price between", value1, value2, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andTransactionPriceNotBetween(String value1, String value2) {
            addCriterion("transaction_price not between", value1, value2, "transactionPrice");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("use_type like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("use_type not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andMaturityIsNull() {
            addCriterion("maturity is null");
            return (Criteria) this;
        }

        public Criteria andMaturityIsNotNull() {
            addCriterion("maturity is not null");
            return (Criteria) this;
        }

        public Criteria andMaturityEqualTo(String value) {
            addCriterion("maturity =", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityNotEqualTo(String value) {
            addCriterion("maturity <>", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityGreaterThan(String value) {
            addCriterion("maturity >", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityGreaterThanOrEqualTo(String value) {
            addCriterion("maturity >=", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityLessThan(String value) {
            addCriterion("maturity <", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityLessThanOrEqualTo(String value) {
            addCriterion("maturity <=", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityLike(String value) {
            addCriterion("maturity like", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityNotLike(String value) {
            addCriterion("maturity not like", value, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityIn(List<String> values) {
            addCriterion("maturity in", values, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityNotIn(List<String> values) {
            addCriterion("maturity not in", values, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityBetween(String value1, String value2) {
            addCriterion("maturity between", value1, value2, "maturity");
            return (Criteria) this;
        }

        public Criteria andMaturityNotBetween(String value1, String value2) {
            addCriterion("maturity not between", value1, value2, "maturity");
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