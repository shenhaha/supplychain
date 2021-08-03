package com.luer.basicsetup.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppliermanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuppliermanageExample() {
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

        public Criteria andUnitCodeIsNull() {
            addCriterion("unit_code is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("unit_code =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("unit_code <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("unit_code >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_code >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("unit_code <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("unit_code <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("unit_code like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("unit_code not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("unit_code in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("unit_code not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("unit_code between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("unit_code not between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andMainContactIsNull() {
            addCriterion("main_contact is null");
            return (Criteria) this;
        }

        public Criteria andMainContactIsNotNull() {
            addCriterion("main_contact is not null");
            return (Criteria) this;
        }

        public Criteria andMainContactEqualTo(String value) {
            addCriterion("main_contact =", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactNotEqualTo(String value) {
            addCriterion("main_contact <>", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactGreaterThan(String value) {
            addCriterion("main_contact >", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactGreaterThanOrEqualTo(String value) {
            addCriterion("main_contact >=", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactLessThan(String value) {
            addCriterion("main_contact <", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactLessThanOrEqualTo(String value) {
            addCriterion("main_contact <=", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactLike(String value) {
            addCriterion("main_contact like", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactNotLike(String value) {
            addCriterion("main_contact not like", value, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactIn(List<String> values) {
            addCriterion("main_contact in", values, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactNotIn(List<String> values) {
            addCriterion("main_contact not in", values, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactBetween(String value1, String value2) {
            addCriterion("main_contact between", value1, value2, "mainContact");
            return (Criteria) this;
        }

        public Criteria andMainContactNotBetween(String value1, String value2) {
            addCriterion("main_contact not between", value1, value2, "mainContact");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNull() {
            addCriterion("class_code is null");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNotNull() {
            addCriterion("class_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassCodeEqualTo(String value) {
            addCriterion("class_code =", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotEqualTo(String value) {
            addCriterion("class_code <>", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThan(String value) {
            addCriterion("class_code >", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("class_code >=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThan(String value) {
            addCriterion("class_code <", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThanOrEqualTo(String value) {
            addCriterion("class_code <=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLike(String value) {
            addCriterion("class_code like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotLike(String value) {
            addCriterion("class_code not like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIn(List<String> values) {
            addCriterion("class_code in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotIn(List<String> values) {
            addCriterion("class_code not in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeBetween(String value1, String value2) {
            addCriterion("class_code between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotBetween(String value1, String value2) {
            addCriterion("class_code not between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
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

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNull() {
            addCriterion("mailbox is null");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNotNull() {
            addCriterion("mailbox is not null");
            return (Criteria) this;
        }

        public Criteria andMailboxEqualTo(String value) {
            addCriterion("mailbox =", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotEqualTo(String value) {
            addCriterion("mailbox <>", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThan(String value) {
            addCriterion("mailbox >", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("mailbox >=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThan(String value) {
            addCriterion("mailbox <", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThanOrEqualTo(String value) {
            addCriterion("mailbox <=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLike(String value) {
            addCriterion("mailbox like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotLike(String value) {
            addCriterion("mailbox not like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxIn(List<String> values) {
            addCriterion("mailbox in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotIn(List<String> values) {
            addCriterion("mailbox not in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxBetween(String value1, String value2) {
            addCriterion("mailbox between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotBetween(String value1, String value2) {
            addCriterion("mailbox not between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNull() {
            addCriterion("full_name is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("full_name =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("full_name <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("full_name >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("full_name >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("full_name <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("full_name <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("full_name like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("full_name not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("full_name in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("full_name not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("full_name between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("full_name not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(String value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(String value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(String value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(String value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(String value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(String value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLike(String value) {
            addCriterion("tax like", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotLike(String value) {
            addCriterion("tax not like", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<String> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<String> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(String value1, String value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(String value1, String value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIsNull() {
            addCriterion("corporate_representative is null");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIsNotNull() {
            addCriterion("corporate_representative is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeEqualTo(String value) {
            addCriterion("corporate_representative =", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotEqualTo(String value) {
            addCriterion("corporate_representative <>", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeGreaterThan(String value) {
            addCriterion("corporate_representative >", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_representative >=", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLessThan(String value) {
            addCriterion("corporate_representative <", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLessThanOrEqualTo(String value) {
            addCriterion("corporate_representative <=", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLike(String value) {
            addCriterion("corporate_representative like", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotLike(String value) {
            addCriterion("corporate_representative not like", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIn(List<String> values) {
            addCriterion("corporate_representative in", values, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotIn(List<String> values) {
            addCriterion("corporate_representative not in", values, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeBetween(String value1, String value2) {
            addCriterion("corporate_representative between", value1, value2, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotBetween(String value1, String value2) {
            addCriterion("corporate_representative not between", value1, value2, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andBillAddressIsNull() {
            addCriterion("bill_address is null");
            return (Criteria) this;
        }

        public Criteria andBillAddressIsNotNull() {
            addCriterion("bill_address is not null");
            return (Criteria) this;
        }

        public Criteria andBillAddressEqualTo(String value) {
            addCriterion("bill_address =", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressNotEqualTo(String value) {
            addCriterion("bill_address <>", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressGreaterThan(String value) {
            addCriterion("bill_address >", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bill_address >=", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressLessThan(String value) {
            addCriterion("bill_address <", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressLessThanOrEqualTo(String value) {
            addCriterion("bill_address <=", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressLike(String value) {
            addCriterion("bill_address like", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressNotLike(String value) {
            addCriterion("bill_address not like", value, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressIn(List<String> values) {
            addCriterion("bill_address in", values, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressNotIn(List<String> values) {
            addCriterion("bill_address not in", values, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressBetween(String value1, String value2) {
            addCriterion("bill_address between", value1, value2, "billAddress");
            return (Criteria) this;
        }

        public Criteria andBillAddressNotBetween(String value1, String value2) {
            addCriterion("bill_address not between", value1, value2, "billAddress");
            return (Criteria) this;
        }

        public Criteria andInvoice01IsNull() {
            addCriterion("invoice01 is null");
            return (Criteria) this;
        }

        public Criteria andInvoice01IsNotNull() {
            addCriterion("invoice01 is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice01EqualTo(String value) {
            addCriterion("invoice01 =", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01NotEqualTo(String value) {
            addCriterion("invoice01 <>", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01GreaterThan(String value) {
            addCriterion("invoice01 >", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01GreaterThanOrEqualTo(String value) {
            addCriterion("invoice01 >=", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01LessThan(String value) {
            addCriterion("invoice01 <", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01LessThanOrEqualTo(String value) {
            addCriterion("invoice01 <=", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01Like(String value) {
            addCriterion("invoice01 like", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01NotLike(String value) {
            addCriterion("invoice01 not like", value, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01In(List<String> values) {
            addCriterion("invoice01 in", values, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01NotIn(List<String> values) {
            addCriterion("invoice01 not in", values, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01Between(String value1, String value2) {
            addCriterion("invoice01 between", value1, value2, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice01NotBetween(String value1, String value2) {
            addCriterion("invoice01 not between", value1, value2, "invoice01");
            return (Criteria) this;
        }

        public Criteria andInvoice02IsNull() {
            addCriterion("invoice02 is null");
            return (Criteria) this;
        }

        public Criteria andInvoice02IsNotNull() {
            addCriterion("invoice02 is not null");
            return (Criteria) this;
        }

        public Criteria andInvoice02EqualTo(String value) {
            addCriterion("invoice02 =", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02NotEqualTo(String value) {
            addCriterion("invoice02 <>", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02GreaterThan(String value) {
            addCriterion("invoice02 >", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02GreaterThanOrEqualTo(String value) {
            addCriterion("invoice02 >=", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02LessThan(String value) {
            addCriterion("invoice02 <", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02LessThanOrEqualTo(String value) {
            addCriterion("invoice02 <=", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02Like(String value) {
            addCriterion("invoice02 like", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02NotLike(String value) {
            addCriterion("invoice02 not like", value, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02In(List<String> values) {
            addCriterion("invoice02 in", values, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02NotIn(List<String> values) {
            addCriterion("invoice02 not in", values, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02Between(String value1, String value2) {
            addCriterion("invoice02 between", value1, value2, "invoice02");
            return (Criteria) this;
        }

        public Criteria andInvoice02NotBetween(String value1, String value2) {
            addCriterion("invoice02 not between", value1, value2, "invoice02");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNull() {
            addCriterion("data_state is null");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNotNull() {
            addCriterion("data_state is not null");
            return (Criteria) this;
        }

        public Criteria andDataStateEqualTo(String value) {
            addCriterion("data_state =", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotEqualTo(String value) {
            addCriterion("data_state <>", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThan(String value) {
            addCriterion("data_state >", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThanOrEqualTo(String value) {
            addCriterion("data_state >=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThan(String value) {
            addCriterion("data_state <", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThanOrEqualTo(String value) {
            addCriterion("data_state <=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLike(String value) {
            addCriterion("data_state like", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotLike(String value) {
            addCriterion("data_state not like", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateIn(List<String> values) {
            addCriterion("data_state in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotIn(List<String> values) {
            addCriterion("data_state not in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateBetween(String value1, String value2) {
            addCriterion("data_state between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotBetween(String value1, String value2) {
            addCriterion("data_state not between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
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

        public Criteria andLineCreditIsNull() {
            addCriterion("line_credit is null");
            return (Criteria) this;
        }

        public Criteria andLineCreditIsNotNull() {
            addCriterion("line_credit is not null");
            return (Criteria) this;
        }

        public Criteria andLineCreditEqualTo(String value) {
            addCriterion("line_credit =", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditNotEqualTo(String value) {
            addCriterion("line_credit <>", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditGreaterThan(String value) {
            addCriterion("line_credit >", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditGreaterThanOrEqualTo(String value) {
            addCriterion("line_credit >=", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditLessThan(String value) {
            addCriterion("line_credit <", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditLessThanOrEqualTo(String value) {
            addCriterion("line_credit <=", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditLike(String value) {
            addCriterion("line_credit like", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditNotLike(String value) {
            addCriterion("line_credit not like", value, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditIn(List<String> values) {
            addCriterion("line_credit in", values, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditNotIn(List<String> values) {
            addCriterion("line_credit not in", values, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditBetween(String value1, String value2) {
            addCriterion("line_credit between", value1, value2, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andLineCreditNotBetween(String value1, String value2) {
            addCriterion("line_credit not between", value1, value2, "lineCredit");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNull() {
            addCriterion("salesman is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNotNull() {
            addCriterion("salesman is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEqualTo(String value) {
            addCriterion("salesman =", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotEqualTo(String value) {
            addCriterion("salesman <>", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThan(String value) {
            addCriterion("salesman >", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThanOrEqualTo(String value) {
            addCriterion("salesman >=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThan(String value) {
            addCriterion("salesman <", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThanOrEqualTo(String value) {
            addCriterion("salesman <=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLike(String value) {
            addCriterion("salesman like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotLike(String value) {
            addCriterion("salesman not like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanIn(List<String> values) {
            addCriterion("salesman in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotIn(List<String> values) {
            addCriterion("salesman not in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanBetween(String value1, String value2) {
            addCriterion("salesman between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotBetween(String value1, String value2) {
            addCriterion("salesman not between", value1, value2, "salesman");
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

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIsNull() {
            addCriterion("business_tips is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIsNotNull() {
            addCriterion("business_tips is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsEqualTo(String value) {
            addCriterion("business_tips =", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotEqualTo(String value) {
            addCriterion("business_tips <>", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsGreaterThan(String value) {
            addCriterion("business_tips >", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsGreaterThanOrEqualTo(String value) {
            addCriterion("business_tips >=", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLessThan(String value) {
            addCriterion("business_tips <", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLessThanOrEqualTo(String value) {
            addCriterion("business_tips <=", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLike(String value) {
            addCriterion("business_tips like", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotLike(String value) {
            addCriterion("business_tips not like", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIn(List<String> values) {
            addCriterion("business_tips in", values, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotIn(List<String> values) {
            addCriterion("business_tips not in", values, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsBetween(String value1, String value2) {
            addCriterion("business_tips between", value1, value2, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotBetween(String value1, String value2) {
            addCriterion("business_tips not between", value1, value2, "businessTips");
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