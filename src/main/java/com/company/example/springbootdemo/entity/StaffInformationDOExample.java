package com.company.example.springbootdemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StaffInformationDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffInformationDOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlIsNull() {
            addCriterion("staff_profile_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlIsNotNull() {
            addCriterion("staff_profile_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlEqualTo(String value) {
            addCriterion("staff_profile_photo_url =", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlNotEqualTo(String value) {
            addCriterion("staff_profile_photo_url <>", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlGreaterThan(String value) {
            addCriterion("staff_profile_photo_url >", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("staff_profile_photo_url >=", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlLessThan(String value) {
            addCriterion("staff_profile_photo_url <", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("staff_profile_photo_url <=", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlLike(String value) {
            addCriterion("staff_profile_photo_url like", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlNotLike(String value) {
            addCriterion("staff_profile_photo_url not like", value, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlIn(List<String> values) {
            addCriterion("staff_profile_photo_url in", values, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlNotIn(List<String> values) {
            addCriterion("staff_profile_photo_url not in", values, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlBetween(String value1, String value2) {
            addCriterion("staff_profile_photo_url between", value1, value2, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffProfilePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("staff_profile_photo_url not between", value1, value2, "staffProfilePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentIsNull() {
            addCriterion("staff_department is null");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentIsNotNull() {
            addCriterion("staff_department is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentEqualTo(String value) {
            addCriterion("staff_department =", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentNotEqualTo(String value) {
            addCriterion("staff_department <>", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentGreaterThan(String value) {
            addCriterion("staff_department >", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("staff_department >=", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentLessThan(String value) {
            addCriterion("staff_department <", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentLessThanOrEqualTo(String value) {
            addCriterion("staff_department <=", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentLike(String value) {
            addCriterion("staff_department like", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentNotLike(String value) {
            addCriterion("staff_department not like", value, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentIn(List<String> values) {
            addCriterion("staff_department in", values, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentNotIn(List<String> values) {
            addCriterion("staff_department not in", values, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentBetween(String value1, String value2) {
            addCriterion("staff_department between", value1, value2, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffDepartmentNotBetween(String value1, String value2) {
            addCriterion("staff_department not between", value1, value2, "staffDepartment");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNull() {
            addCriterion("staff_sex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("staff_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("staff_sex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("staff_sex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("staff_sex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("staff_sex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("staff_sex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("staff_sex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("staff_sex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("staff_sex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("staff_sex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("staff_sex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("staff_sex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("staff_sex not between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayIsNull() {
            addCriterion("staff_birth_day is null");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayIsNotNull() {
            addCriterion("staff_birth_day is not null");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayEqualTo(Date value) {
            addCriterionForJDBCDate("staff_birth_day =", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("staff_birth_day <>", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayGreaterThan(Date value) {
            addCriterionForJDBCDate("staff_birth_day >", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("staff_birth_day >=", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayLessThan(Date value) {
            addCriterionForJDBCDate("staff_birth_day <", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("staff_birth_day <=", value, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayIn(List<Date> values) {
            addCriterionForJDBCDate("staff_birth_day in", values, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("staff_birth_day not in", values, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("staff_birth_day between", value1, value2, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffBirthDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("staff_birth_day not between", value1, value2, "staffBirthDay");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNull() {
            addCriterion("staff_phone is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNotNull() {
            addCriterion("staff_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneEqualTo(String value) {
            addCriterion("staff_phone =", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotEqualTo(String value) {
            addCriterion("staff_phone <>", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThan(String value) {
            addCriterion("staff_phone >", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("staff_phone >=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThan(String value) {
            addCriterion("staff_phone <", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
            addCriterion("staff_phone <=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLike(String value) {
            addCriterion("staff_phone like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotLike(String value) {
            addCriterion("staff_phone not like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIn(List<String> values) {
            addCriterion("staff_phone in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotIn(List<String> values) {
            addCriterion("staff_phone not in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneBetween(String value1, String value2) {
            addCriterion("staff_phone between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotBetween(String value1, String value2) {
            addCriterion("staff_phone not between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffEmailIsNull() {
            addCriterion("staff_email is null");
            return (Criteria) this;
        }

        public Criteria andStaffEmailIsNotNull() {
            addCriterion("staff_email is not null");
            return (Criteria) this;
        }

        public Criteria andStaffEmailEqualTo(String value) {
            addCriterion("staff_email =", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotEqualTo(String value) {
            addCriterion("staff_email <>", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailGreaterThan(String value) {
            addCriterion("staff_email >", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailGreaterThanOrEqualTo(String value) {
            addCriterion("staff_email >=", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailLessThan(String value) {
            addCriterion("staff_email <", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailLessThanOrEqualTo(String value) {
            addCriterion("staff_email <=", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailLike(String value) {
            addCriterion("staff_email like", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotLike(String value) {
            addCriterion("staff_email not like", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailIn(List<String> values) {
            addCriterion("staff_email in", values, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotIn(List<String> values) {
            addCriterion("staff_email not in", values, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailBetween(String value1, String value2) {
            addCriterion("staff_email between", value1, value2, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotBetween(String value1, String value2) {
            addCriterion("staff_email not between", value1, value2, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIsNull() {
            addCriterion("staff_id_card is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIsNotNull() {
            addCriterion("staff_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardEqualTo(String value) {
            addCriterion("staff_id_card =", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotEqualTo(String value) {
            addCriterion("staff_id_card <>", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardGreaterThan(String value) {
            addCriterion("staff_id_card >", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id_card >=", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLessThan(String value) {
            addCriterion("staff_id_card <", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLessThanOrEqualTo(String value) {
            addCriterion("staff_id_card <=", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLike(String value) {
            addCriterion("staff_id_card like", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotLike(String value) {
            addCriterion("staff_id_card not like", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIn(List<String> values) {
            addCriterion("staff_id_card in", values, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotIn(List<String> values) {
            addCriterion("staff_id_card not in", values, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardBetween(String value1, String value2) {
            addCriterion("staff_id_card between", value1, value2, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotBetween(String value1, String value2) {
            addCriterion("staff_id_card not between", value1, value2, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIsNull() {
            addCriterion("staff_location is null");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIsNotNull() {
            addCriterion("staff_location is not null");
            return (Criteria) this;
        }

        public Criteria andStaffLocationEqualTo(String value) {
            addCriterion("staff_location =", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotEqualTo(String value) {
            addCriterion("staff_location <>", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationGreaterThan(String value) {
            addCriterion("staff_location >", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationGreaterThanOrEqualTo(String value) {
            addCriterion("staff_location >=", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationLessThan(String value) {
            addCriterion("staff_location <", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationLessThanOrEqualTo(String value) {
            addCriterion("staff_location <=", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationLike(String value) {
            addCriterion("staff_location like", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotLike(String value) {
            addCriterion("staff_location not like", value, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationIn(List<String> values) {
            addCriterion("staff_location in", values, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotIn(List<String> values) {
            addCriterion("staff_location not in", values, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationBetween(String value1, String value2) {
            addCriterion("staff_location between", value1, value2, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffLocationNotBetween(String value1, String value2) {
            addCriterion("staff_location not between", value1, value2, "staffLocation");
            return (Criteria) this;
        }

        public Criteria andStaffDomainIsNull() {
            addCriterion("staff_domain is null");
            return (Criteria) this;
        }

        public Criteria andStaffDomainIsNotNull() {
            addCriterion("staff_domain is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDomainEqualTo(String value) {
            addCriterion("staff_domain =", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainNotEqualTo(String value) {
            addCriterion("staff_domain <>", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainGreaterThan(String value) {
            addCriterion("staff_domain >", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainGreaterThanOrEqualTo(String value) {
            addCriterion("staff_domain >=", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainLessThan(String value) {
            addCriterion("staff_domain <", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainLessThanOrEqualTo(String value) {
            addCriterion("staff_domain <=", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainLike(String value) {
            addCriterion("staff_domain like", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainNotLike(String value) {
            addCriterion("staff_domain not like", value, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainIn(List<String> values) {
            addCriterion("staff_domain in", values, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainNotIn(List<String> values) {
            addCriterion("staff_domain not in", values, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainBetween(String value1, String value2) {
            addCriterion("staff_domain between", value1, value2, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffDomainNotBetween(String value1, String value2) {
            addCriterion("staff_domain not between", value1, value2, "staffDomain");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlIsNull() {
            addCriterion("staff_certifficare_url is null");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlIsNotNull() {
            addCriterion("staff_certifficare_url is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlEqualTo(String value) {
            addCriterion("staff_certifficare_url =", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlNotEqualTo(String value) {
            addCriterion("staff_certifficare_url <>", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlGreaterThan(String value) {
            addCriterion("staff_certifficare_url >", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("staff_certifficare_url >=", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlLessThan(String value) {
            addCriterion("staff_certifficare_url <", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlLessThanOrEqualTo(String value) {
            addCriterion("staff_certifficare_url <=", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlLike(String value) {
            addCriterion("staff_certifficare_url like", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlNotLike(String value) {
            addCriterion("staff_certifficare_url not like", value, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlIn(List<String> values) {
            addCriterion("staff_certifficare_url in", values, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlNotIn(List<String> values) {
            addCriterion("staff_certifficare_url not in", values, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlBetween(String value1, String value2) {
            addCriterion("staff_certifficare_url between", value1, value2, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffCertifficareUrlNotBetween(String value1, String value2) {
            addCriterion("staff_certifficare_url not between", value1, value2, "staffCertifficareUrl");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionIsNull() {
            addCriterion("staff_description is null");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionIsNotNull() {
            addCriterion("staff_description is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionEqualTo(String value) {
            addCriterion("staff_description =", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionNotEqualTo(String value) {
            addCriterion("staff_description <>", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionGreaterThan(String value) {
            addCriterion("staff_description >", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("staff_description >=", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionLessThan(String value) {
            addCriterion("staff_description <", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionLessThanOrEqualTo(String value) {
            addCriterion("staff_description <=", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionLike(String value) {
            addCriterion("staff_description like", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionNotLike(String value) {
            addCriterion("staff_description not like", value, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionIn(List<String> values) {
            addCriterion("staff_description in", values, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionNotIn(List<String> values) {
            addCriterion("staff_description not in", values, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionBetween(String value1, String value2) {
            addCriterion("staff_description between", value1, value2, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffDescriptionNotBetween(String value1, String value2) {
            addCriterion("staff_description not between", value1, value2, "staffDescription");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdIsNull() {
            addCriterion("staff_outcome_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdIsNotNull() {
            addCriterion("staff_outcome_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdEqualTo(Integer value) {
            addCriterion("staff_outcome_id =", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdNotEqualTo(Integer value) {
            addCriterion("staff_outcome_id <>", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdGreaterThan(Integer value) {
            addCriterion("staff_outcome_id >", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_outcome_id >=", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdLessThan(Integer value) {
            addCriterion("staff_outcome_id <", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_outcome_id <=", value, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdIn(List<Integer> values) {
            addCriterion("staff_outcome_id in", values, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdNotIn(List<Integer> values) {
            addCriterion("staff_outcome_id not in", values, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_outcome_id between", value1, value2, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_outcome_id not between", value1, value2, "staffOutcomeId");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagIsNull() {
            addCriterion("staff_outcome_flag is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagIsNotNull() {
            addCriterion("staff_outcome_flag is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagEqualTo(String value) {
            addCriterion("staff_outcome_flag =", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagNotEqualTo(String value) {
            addCriterion("staff_outcome_flag <>", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagGreaterThan(String value) {
            addCriterion("staff_outcome_flag >", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("staff_outcome_flag >=", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagLessThan(String value) {
            addCriterion("staff_outcome_flag <", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagLessThanOrEqualTo(String value) {
            addCriterion("staff_outcome_flag <=", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagLike(String value) {
            addCriterion("staff_outcome_flag like", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagNotLike(String value) {
            addCriterion("staff_outcome_flag not like", value, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagIn(List<String> values) {
            addCriterion("staff_outcome_flag in", values, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagNotIn(List<String> values) {
            addCriterion("staff_outcome_flag not in", values, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagBetween(String value1, String value2) {
            addCriterion("staff_outcome_flag between", value1, value2, "staffOutcomeFlag");
            return (Criteria) this;
        }

        public Criteria andStaffOutcomeFlagNotBetween(String value1, String value2) {
            addCriterion("staff_outcome_flag not between", value1, value2, "staffOutcomeFlag");
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