package com.luer.basicsetup.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactorymanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FactorymanageExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andSpare01IsNull() {
            addCriterion("spare01 is null");
            return (Criteria) this;
        }

        public Criteria andSpare01IsNotNull() {
            addCriterion("spare01 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare01EqualTo(String value) {
            addCriterion("spare01 =", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01NotEqualTo(String value) {
            addCriterion("spare01 <>", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01GreaterThan(String value) {
            addCriterion("spare01 >", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01GreaterThanOrEqualTo(String value) {
            addCriterion("spare01 >=", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01LessThan(String value) {
            addCriterion("spare01 <", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01LessThanOrEqualTo(String value) {
            addCriterion("spare01 <=", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01Like(String value) {
            addCriterion("spare01 like", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01NotLike(String value) {
            addCriterion("spare01 not like", value, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01In(List<String> values) {
            addCriterion("spare01 in", values, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01NotIn(List<String> values) {
            addCriterion("spare01 not in", values, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01Between(String value1, String value2) {
            addCriterion("spare01 between", value1, value2, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare01NotBetween(String value1, String value2) {
            addCriterion("spare01 not between", value1, value2, "spare01");
            return (Criteria) this;
        }

        public Criteria andSpare02IsNull() {
            addCriterion("spare02 is null");
            return (Criteria) this;
        }

        public Criteria andSpare02IsNotNull() {
            addCriterion("spare02 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare02EqualTo(String value) {
            addCriterion("spare02 =", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02NotEqualTo(String value) {
            addCriterion("spare02 <>", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02GreaterThan(String value) {
            addCriterion("spare02 >", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02GreaterThanOrEqualTo(String value) {
            addCriterion("spare02 >=", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02LessThan(String value) {
            addCriterion("spare02 <", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02LessThanOrEqualTo(String value) {
            addCriterion("spare02 <=", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02Like(String value) {
            addCriterion("spare02 like", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02NotLike(String value) {
            addCriterion("spare02 not like", value, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02In(List<String> values) {
            addCriterion("spare02 in", values, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02NotIn(List<String> values) {
            addCriterion("spare02 not in", values, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02Between(String value1, String value2) {
            addCriterion("spare02 between", value1, value2, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare02NotBetween(String value1, String value2) {
            addCriterion("spare02 not between", value1, value2, "spare02");
            return (Criteria) this;
        }

        public Criteria andSpare03IsNull() {
            addCriterion("spare03 is null");
            return (Criteria) this;
        }

        public Criteria andSpare03IsNotNull() {
            addCriterion("spare03 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare03EqualTo(String value) {
            addCriterion("spare03 =", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03NotEqualTo(String value) {
            addCriterion("spare03 <>", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03GreaterThan(String value) {
            addCriterion("spare03 >", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03GreaterThanOrEqualTo(String value) {
            addCriterion("spare03 >=", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03LessThan(String value) {
            addCriterion("spare03 <", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03LessThanOrEqualTo(String value) {
            addCriterion("spare03 <=", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03Like(String value) {
            addCriterion("spare03 like", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03NotLike(String value) {
            addCriterion("spare03 not like", value, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03In(List<String> values) {
            addCriterion("spare03 in", values, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03NotIn(List<String> values) {
            addCriterion("spare03 not in", values, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03Between(String value1, String value2) {
            addCriterion("spare03 between", value1, value2, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare03NotBetween(String value1, String value2) {
            addCriterion("spare03 not between", value1, value2, "spare03");
            return (Criteria) this;
        }

        public Criteria andSpare04IsNull() {
            addCriterion("spare04 is null");
            return (Criteria) this;
        }

        public Criteria andSpare04IsNotNull() {
            addCriterion("spare04 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare04EqualTo(String value) {
            addCriterion("spare04 =", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04NotEqualTo(String value) {
            addCriterion("spare04 <>", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04GreaterThan(String value) {
            addCriterion("spare04 >", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04GreaterThanOrEqualTo(String value) {
            addCriterion("spare04 >=", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04LessThan(String value) {
            addCriterion("spare04 <", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04LessThanOrEqualTo(String value) {
            addCriterion("spare04 <=", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04Like(String value) {
            addCriterion("spare04 like", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04NotLike(String value) {
            addCriterion("spare04 not like", value, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04In(List<String> values) {
            addCriterion("spare04 in", values, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04NotIn(List<String> values) {
            addCriterion("spare04 not in", values, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04Between(String value1, String value2) {
            addCriterion("spare04 between", value1, value2, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare04NotBetween(String value1, String value2) {
            addCriterion("spare04 not between", value1, value2, "spare04");
            return (Criteria) this;
        }

        public Criteria andSpare05IsNull() {
            addCriterion("spare05 is null");
            return (Criteria) this;
        }

        public Criteria andSpare05IsNotNull() {
            addCriterion("spare05 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare05EqualTo(String value) {
            addCriterion("spare05 =", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05NotEqualTo(String value) {
            addCriterion("spare05 <>", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05GreaterThan(String value) {
            addCriterion("spare05 >", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05GreaterThanOrEqualTo(String value) {
            addCriterion("spare05 >=", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05LessThan(String value) {
            addCriterion("spare05 <", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05LessThanOrEqualTo(String value) {
            addCriterion("spare05 <=", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05Like(String value) {
            addCriterion("spare05 like", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05NotLike(String value) {
            addCriterion("spare05 not like", value, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05In(List<String> values) {
            addCriterion("spare05 in", values, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05NotIn(List<String> values) {
            addCriterion("spare05 not in", values, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05Between(String value1, String value2) {
            addCriterion("spare05 between", value1, value2, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare05NotBetween(String value1, String value2) {
            addCriterion("spare05 not between", value1, value2, "spare05");
            return (Criteria) this;
        }

        public Criteria andSpare06IsNull() {
            addCriterion("spare06 is null");
            return (Criteria) this;
        }

        public Criteria andSpare06IsNotNull() {
            addCriterion("spare06 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare06EqualTo(String value) {
            addCriterion("spare06 =", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06NotEqualTo(String value) {
            addCriterion("spare06 <>", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06GreaterThan(String value) {
            addCriterion("spare06 >", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06GreaterThanOrEqualTo(String value) {
            addCriterion("spare06 >=", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06LessThan(String value) {
            addCriterion("spare06 <", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06LessThanOrEqualTo(String value) {
            addCriterion("spare06 <=", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06Like(String value) {
            addCriterion("spare06 like", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06NotLike(String value) {
            addCriterion("spare06 not like", value, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06In(List<String> values) {
            addCriterion("spare06 in", values, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06NotIn(List<String> values) {
            addCriterion("spare06 not in", values, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06Between(String value1, String value2) {
            addCriterion("spare06 between", value1, value2, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare06NotBetween(String value1, String value2) {
            addCriterion("spare06 not between", value1, value2, "spare06");
            return (Criteria) this;
        }

        public Criteria andSpare07IsNull() {
            addCriterion("spare07 is null");
            return (Criteria) this;
        }

        public Criteria andSpare07IsNotNull() {
            addCriterion("spare07 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare07EqualTo(String value) {
            addCriterion("spare07 =", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07NotEqualTo(String value) {
            addCriterion("spare07 <>", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07GreaterThan(String value) {
            addCriterion("spare07 >", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07GreaterThanOrEqualTo(String value) {
            addCriterion("spare07 >=", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07LessThan(String value) {
            addCriterion("spare07 <", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07LessThanOrEqualTo(String value) {
            addCriterion("spare07 <=", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07Like(String value) {
            addCriterion("spare07 like", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07NotLike(String value) {
            addCriterion("spare07 not like", value, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07In(List<String> values) {
            addCriterion("spare07 in", values, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07NotIn(List<String> values) {
            addCriterion("spare07 not in", values, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07Between(String value1, String value2) {
            addCriterion("spare07 between", value1, value2, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare07NotBetween(String value1, String value2) {
            addCriterion("spare07 not between", value1, value2, "spare07");
            return (Criteria) this;
        }

        public Criteria andSpare08IsNull() {
            addCriterion("spare08 is null");
            return (Criteria) this;
        }

        public Criteria andSpare08IsNotNull() {
            addCriterion("spare08 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare08EqualTo(String value) {
            addCriterion("spare08 =", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08NotEqualTo(String value) {
            addCriterion("spare08 <>", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08GreaterThan(String value) {
            addCriterion("spare08 >", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08GreaterThanOrEqualTo(String value) {
            addCriterion("spare08 >=", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08LessThan(String value) {
            addCriterion("spare08 <", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08LessThanOrEqualTo(String value) {
            addCriterion("spare08 <=", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08Like(String value) {
            addCriterion("spare08 like", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08NotLike(String value) {
            addCriterion("spare08 not like", value, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08In(List<String> values) {
            addCriterion("spare08 in", values, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08NotIn(List<String> values) {
            addCriterion("spare08 not in", values, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08Between(String value1, String value2) {
            addCriterion("spare08 between", value1, value2, "spare08");
            return (Criteria) this;
        }

        public Criteria andSpare08NotBetween(String value1, String value2) {
            addCriterion("spare08 not between", value1, value2, "spare08");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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