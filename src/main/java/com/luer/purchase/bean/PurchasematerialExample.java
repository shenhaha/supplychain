package com.luer.purchase.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchasematerialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchasematerialExample() {
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

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Date value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Date value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Date value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Date value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Date> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Date> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeIsNull() {
            addCriterion("financial_time is null");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeIsNotNull() {
            addCriterion("financial_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeEqualTo(Date value) {
            addCriterion("financial_time =", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeNotEqualTo(Date value) {
            addCriterion("financial_time <>", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeGreaterThan(Date value) {
            addCriterion("financial_time >", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("financial_time >=", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeLessThan(Date value) {
            addCriterion("financial_time <", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeLessThanOrEqualTo(Date value) {
            addCriterion("financial_time <=", value, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeIn(List<Date> values) {
            addCriterion("financial_time in", values, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeNotIn(List<Date> values) {
            addCriterion("financial_time not in", values, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeBetween(Date value1, Date value2) {
            addCriterion("financial_time between", value1, value2, "financialTime");
            return (Criteria) this;
        }

        public Criteria andFinancialTimeNotBetween(Date value1, Date value2) {
            addCriterion("financial_time not between", value1, value2, "financialTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIsNull() {
            addCriterion("purchase_number is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIsNotNull() {
            addCriterion("purchase_number is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberEqualTo(String value) {
            addCriterion("purchase_number =", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotEqualTo(String value) {
            addCriterion("purchase_number <>", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberGreaterThan(String value) {
            addCriterion("purchase_number >", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_number >=", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLessThan(String value) {
            addCriterion("purchase_number <", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLessThanOrEqualTo(String value) {
            addCriterion("purchase_number <=", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLike(String value) {
            addCriterion("purchase_number like", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotLike(String value) {
            addCriterion("purchase_number not like", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIn(List<String> values) {
            addCriterion("purchase_number in", values, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotIn(List<String> values) {
            addCriterion("purchase_number not in", values, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberBetween(String value1, String value2) {
            addCriterion("purchase_number between", value1, value2, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotBetween(String value1, String value2) {
            addCriterion("purchase_number not between", value1, value2, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceIsNull() {
            addCriterion("purchase_source is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceIsNotNull() {
            addCriterion("purchase_source is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceEqualTo(String value) {
            addCriterion("purchase_source =", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotEqualTo(String value) {
            addCriterion("purchase_source <>", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceGreaterThan(String value) {
            addCriterion("purchase_source >", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_source >=", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLessThan(String value) {
            addCriterion("purchase_source <", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLessThanOrEqualTo(String value) {
            addCriterion("purchase_source <=", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLike(String value) {
            addCriterion("purchase_source like", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotLike(String value) {
            addCriterion("purchase_source not like", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceIn(List<String> values) {
            addCriterion("purchase_source in", values, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotIn(List<String> values) {
            addCriterion("purchase_source not in", values, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceBetween(String value1, String value2) {
            addCriterion("purchase_source between", value1, value2, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotBetween(String value1, String value2) {
            addCriterion("purchase_source not between", value1, value2, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIsNull() {
            addCriterion("receive_status is null");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIsNotNull() {
            addCriterion("receive_status is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusEqualTo(String value) {
            addCriterion("receive_status =", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotEqualTo(String value) {
            addCriterion("receive_status <>", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusGreaterThan(String value) {
            addCriterion("receive_status >", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("receive_status >=", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusLessThan(String value) {
            addCriterion("receive_status <", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusLessThanOrEqualTo(String value) {
            addCriterion("receive_status <=", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusLike(String value) {
            addCriterion("receive_status like", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotLike(String value) {
            addCriterion("receive_status not like", value, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusIn(List<String> values) {
            addCriterion("receive_status in", values, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotIn(List<String> values) {
            addCriterion("receive_status not in", values, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusBetween(String value1, String value2) {
            addCriterion("receive_status between", value1, value2, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andReceiveStatusNotBetween(String value1, String value2) {
            addCriterion("receive_status not between", value1, value2, "receiveStatus");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIsNull() {
            addCriterion("commodity_type is null");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIsNotNull() {
            addCriterion("commodity_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeEqualTo(String value) {
            addCriterion("commodity_type =", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotEqualTo(String value) {
            addCriterion("commodity_type <>", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeGreaterThan(String value) {
            addCriterion("commodity_type >", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_type >=", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeLessThan(String value) {
            addCriterion("commodity_type <", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeLessThanOrEqualTo(String value) {
            addCriterion("commodity_type <=", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeLike(String value) {
            addCriterion("commodity_type like", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotLike(String value) {
            addCriterion("commodity_type not like", value, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeIn(List<String> values) {
            addCriterion("commodity_type in", values, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotIn(List<String> values) {
            addCriterion("commodity_type not in", values, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeBetween(String value1, String value2) {
            addCriterion("commodity_type between", value1, value2, "commodityType");
            return (Criteria) this;
        }

        public Criteria andCommodityTypeNotBetween(String value1, String value2) {
            addCriterion("commodity_type not between", value1, value2, "commodityType");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("receive_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("receive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("receive_address =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("receive_address <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("receive_address >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("receive_address <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("receive_address <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("receive_address like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("receive_address not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("receive_address in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("receive_address not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("receive_address between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("receive_address not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andSinglePersonIsNull() {
            addCriterion("single_person is null");
            return (Criteria) this;
        }

        public Criteria andSinglePersonIsNotNull() {
            addCriterion("single_person is not null");
            return (Criteria) this;
        }

        public Criteria andSinglePersonEqualTo(String value) {
            addCriterion("single_person =", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonNotEqualTo(String value) {
            addCriterion("single_person <>", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonGreaterThan(String value) {
            addCriterion("single_person >", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonGreaterThanOrEqualTo(String value) {
            addCriterion("single_person >=", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonLessThan(String value) {
            addCriterion("single_person <", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonLessThanOrEqualTo(String value) {
            addCriterion("single_person <=", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonLike(String value) {
            addCriterion("single_person like", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonNotLike(String value) {
            addCriterion("single_person not like", value, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonIn(List<String> values) {
            addCriterion("single_person in", values, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonNotIn(List<String> values) {
            addCriterion("single_person not in", values, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonBetween(String value1, String value2) {
            addCriterion("single_person between", value1, value2, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSinglePersonNotBetween(String value1, String value2) {
            addCriterion("single_person not between", value1, value2, "singlePerson");
            return (Criteria) this;
        }

        public Criteria andSubmitterIsNull() {
            addCriterion("submitter is null");
            return (Criteria) this;
        }

        public Criteria andSubmitterIsNotNull() {
            addCriterion("submitter is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitterEqualTo(String value) {
            addCriterion("submitter =", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterNotEqualTo(String value) {
            addCriterion("submitter <>", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterGreaterThan(String value) {
            addCriterion("submitter >", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterGreaterThanOrEqualTo(String value) {
            addCriterion("submitter >=", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterLessThan(String value) {
            addCriterion("submitter <", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterLessThanOrEqualTo(String value) {
            addCriterion("submitter <=", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterLike(String value) {
            addCriterion("submitter like", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterNotLike(String value) {
            addCriterion("submitter not like", value, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterIn(List<String> values) {
            addCriterion("submitter in", values, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterNotIn(List<String> values) {
            addCriterion("submitter not in", values, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterBetween(String value1, String value2) {
            addCriterion("submitter between", value1, value2, "submitter");
            return (Criteria) this;
        }

        public Criteria andSubmitterNotBetween(String value1, String value2) {
            addCriterion("submitter not between", value1, value2, "submitter");
            return (Criteria) this;
        }

        public Criteria andContractTermIsNull() {
            addCriterion("contract_term is null");
            return (Criteria) this;
        }

        public Criteria andContractTermIsNotNull() {
            addCriterion("contract_term is not null");
            return (Criteria) this;
        }

        public Criteria andContractTermEqualTo(String value) {
            addCriterion("contract_term =", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermNotEqualTo(String value) {
            addCriterion("contract_term <>", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermGreaterThan(String value) {
            addCriterion("contract_term >", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermGreaterThanOrEqualTo(String value) {
            addCriterion("contract_term >=", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermLessThan(String value) {
            addCriterion("contract_term <", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermLessThanOrEqualTo(String value) {
            addCriterion("contract_term <=", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermLike(String value) {
            addCriterion("contract_term like", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermNotLike(String value) {
            addCriterion("contract_term not like", value, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermIn(List<String> values) {
            addCriterion("contract_term in", values, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermNotIn(List<String> values) {
            addCriterion("contract_term not in", values, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermBetween(String value1, String value2) {
            addCriterion("contract_term between", value1, value2, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andContractTermNotBetween(String value1, String value2) {
            addCriterion("contract_term not between", value1, value2, "contractTerm");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeIsNull() {
            addCriterion("financial_judge is null");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeIsNotNull() {
            addCriterion("financial_judge is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeEqualTo(String value) {
            addCriterion("financial_judge =", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeNotEqualTo(String value) {
            addCriterion("financial_judge <>", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeGreaterThan(String value) {
            addCriterion("financial_judge >", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeGreaterThanOrEqualTo(String value) {
            addCriterion("financial_judge >=", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeLessThan(String value) {
            addCriterion("financial_judge <", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeLessThanOrEqualTo(String value) {
            addCriterion("financial_judge <=", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeLike(String value) {
            addCriterion("financial_judge like", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeNotLike(String value) {
            addCriterion("financial_judge not like", value, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeIn(List<String> values) {
            addCriterion("financial_judge in", values, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeNotIn(List<String> values) {
            addCriterion("financial_judge not in", values, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeBetween(String value1, String value2) {
            addCriterion("financial_judge between", value1, value2, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andFinancialJudgeNotBetween(String value1, String value2) {
            addCriterion("financial_judge not between", value1, value2, "financialJudge");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andTotalSumIsNull() {
            addCriterion("total_sum is null");
            return (Criteria) this;
        }

        public Criteria andTotalSumIsNotNull() {
            addCriterion("total_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSumEqualTo(Double value) {
            addCriterion("total_sum =", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotEqualTo(Double value) {
            addCriterion("total_sum <>", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumGreaterThan(Double value) {
            addCriterion("total_sum >", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumGreaterThanOrEqualTo(Double value) {
            addCriterion("total_sum >=", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumLessThan(Double value) {
            addCriterion("total_sum <", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumLessThanOrEqualTo(Double value) {
            addCriterion("total_sum <=", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumIn(List<Double> values) {
            addCriterion("total_sum in", values, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotIn(List<Double> values) {
            addCriterion("total_sum not in", values, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumBetween(Double value1, Double value2) {
            addCriterion("total_sum between", value1, value2, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotBetween(Double value1, Double value2) {
            addCriterion("total_sum not between", value1, value2, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumIsNull() {
            addCriterion("tax_total_sum is null");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumIsNotNull() {
            addCriterion("tax_total_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumEqualTo(Double value) {
            addCriterion("tax_total_sum =", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumNotEqualTo(Double value) {
            addCriterion("tax_total_sum <>", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumGreaterThan(Double value) {
            addCriterion("tax_total_sum >", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_total_sum >=", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumLessThan(Double value) {
            addCriterion("tax_total_sum <", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumLessThanOrEqualTo(Double value) {
            addCriterion("tax_total_sum <=", value, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumIn(List<Double> values) {
            addCriterion("tax_total_sum in", values, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumNotIn(List<Double> values) {
            addCriterion("tax_total_sum not in", values, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumBetween(Double value1, Double value2) {
            addCriterion("tax_total_sum between", value1, value2, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTaxTotalSumNotBetween(Double value1, Double value2) {
            addCriterion("tax_total_sum not between", value1, value2, "taxTotalSum");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityIsNull() {
            addCriterion("total_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityIsNotNull() {
            addCriterion("total_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityEqualTo(Integer value) {
            addCriterion("total_quantity =", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotEqualTo(Integer value) {
            addCriterion("total_quantity <>", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityGreaterThan(Integer value) {
            addCriterion("total_quantity >", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_quantity >=", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityLessThan(Integer value) {
            addCriterion("total_quantity <", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_quantity <=", value, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityIn(List<Integer> values) {
            addCriterion("total_quantity in", values, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotIn(List<Integer> values) {
            addCriterion("total_quantity not in", values, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_quantity between", value1, value2, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_quantity not between", value1, value2, "totalQuantity");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNull() {
            addCriterion("complete_status is null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNotNull() {
            addCriterion("complete_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusEqualTo(String value) {
            addCriterion("complete_status =", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotEqualTo(String value) {
            addCriterion("complete_status <>", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThan(String value) {
            addCriterion("complete_status >", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("complete_status >=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThan(String value) {
            addCriterion("complete_status <", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThanOrEqualTo(String value) {
            addCriterion("complete_status <=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLike(String value) {
            addCriterion("complete_status like", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotLike(String value) {
            addCriterion("complete_status not like", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIn(List<String> values) {
            addCriterion("complete_status in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotIn(List<String> values) {
            addCriterion("complete_status not in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusBetween(String value1, String value2) {
            addCriterion("complete_status between", value1, value2, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotBetween(String value1, String value2) {
            addCriterion("complete_status not between", value1, value2, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIsNull() {
            addCriterion("invoice_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIsNotNull() {
            addCriterion("invoice_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountEqualTo(Double value) {
            addCriterion("invoice_amount =", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotEqualTo(Double value) {
            addCriterion("invoice_amount <>", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountGreaterThan(Double value) {
            addCriterion("invoice_amount >", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("invoice_amount >=", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountLessThan(Double value) {
            addCriterion("invoice_amount <", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountLessThanOrEqualTo(Double value) {
            addCriterion("invoice_amount <=", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIn(List<Double> values) {
            addCriterion("invoice_amount in", values, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotIn(List<Double> values) {
            addCriterion("invoice_amount not in", values, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountBetween(Double value1, Double value2) {
            addCriterion("invoice_amount between", value1, value2, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotBetween(Double value1, Double value2) {
            addCriterion("invoice_amount not between", value1, value2, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceIsNull() {
            addCriterion("non_invoice is null");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceIsNotNull() {
            addCriterion("non_invoice is not null");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceEqualTo(Double value) {
            addCriterion("non_invoice =", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceNotEqualTo(Double value) {
            addCriterion("non_invoice <>", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceGreaterThan(Double value) {
            addCriterion("non_invoice >", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceGreaterThanOrEqualTo(Double value) {
            addCriterion("non_invoice >=", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceLessThan(Double value) {
            addCriterion("non_invoice <", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceLessThanOrEqualTo(Double value) {
            addCriterion("non_invoice <=", value, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceIn(List<Double> values) {
            addCriterion("non_invoice in", values, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceNotIn(List<Double> values) {
            addCriterion("non_invoice not in", values, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceBetween(Double value1, Double value2) {
            addCriterion("non_invoice between", value1, value2, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andNonInvoiceNotBetween(Double value1, Double value2) {
            addCriterion("non_invoice not between", value1, value2, "nonInvoice");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIsNull() {
            addCriterion("tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIsNotNull() {
            addCriterion("tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAmountEqualTo(Double value) {
            addCriterion("tax_amount =", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotEqualTo(Double value) {
            addCriterion("tax_amount <>", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountGreaterThan(Double value) {
            addCriterion("tax_amount >", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_amount >=", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountLessThan(Double value) {
            addCriterion("tax_amount <", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountLessThanOrEqualTo(Double value) {
            addCriterion("tax_amount <=", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIn(List<Double> values) {
            addCriterion("tax_amount in", values, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotIn(List<Double> values) {
            addCriterion("tax_amount not in", values, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountBetween(Double value1, Double value2) {
            addCriterion("tax_amount between", value1, value2, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotBetween(Double value1, Double value2) {
            addCriterion("tax_amount not between", value1, value2, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(Double value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(Double value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(Double value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(Double value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(Double value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<Double> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<Double> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(Double value1, Double value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(Double value1, Double value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(String value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(String value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(String value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(String value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(String value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLike(String value) {
            addCriterion("invoice like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotLike(String value) {
            addCriterion("invoice not like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<String> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<String> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(String value1, String value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(String value1, String value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Double value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Double value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Double value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Double value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Double value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Double value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Double> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Double> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Double value1, Double value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Double value1, Double value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationIsNull() {
            addCriterion("freight_transportation is null");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationIsNotNull() {
            addCriterion("freight_transportation is not null");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationEqualTo(String value) {
            addCriterion("freight_transportation =", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationNotEqualTo(String value) {
            addCriterion("freight_transportation <>", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationGreaterThan(String value) {
            addCriterion("freight_transportation >", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationGreaterThanOrEqualTo(String value) {
            addCriterion("freight_transportation >=", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationLessThan(String value) {
            addCriterion("freight_transportation <", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationLessThanOrEqualTo(String value) {
            addCriterion("freight_transportation <=", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationLike(String value) {
            addCriterion("freight_transportation like", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationNotLike(String value) {
            addCriterion("freight_transportation not like", value, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationIn(List<String> values) {
            addCriterion("freight_transportation in", values, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationNotIn(List<String> values) {
            addCriterion("freight_transportation not in", values, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationBetween(String value1, String value2) {
            addCriterion("freight_transportation between", value1, value2, "freightTransportation");
            return (Criteria) this;
        }

        public Criteria andFreightTransportationNotBetween(String value1, String value2) {
            addCriterion("freight_transportation not between", value1, value2, "freightTransportation");
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

        public Criteria andTypeTimeIsNull() {
            addCriterion("type_time is null");
            return (Criteria) this;
        }

        public Criteria andTypeTimeIsNotNull() {
            addCriterion("type_time is not null");
            return (Criteria) this;
        }

        public Criteria andTypeTimeEqualTo(String value) {
            addCriterion("type_time =", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeNotEqualTo(String value) {
            addCriterion("type_time <>", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeGreaterThan(String value) {
            addCriterion("type_time >", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("type_time >=", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeLessThan(String value) {
            addCriterion("type_time <", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeLessThanOrEqualTo(String value) {
            addCriterion("type_time <=", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeLike(String value) {
            addCriterion("type_time like", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeNotLike(String value) {
            addCriterion("type_time not like", value, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeIn(List<String> values) {
            addCriterion("type_time in", values, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeNotIn(List<String> values) {
            addCriterion("type_time not in", values, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeBetween(String value1, String value2) {
            addCriterion("type_time between", value1, value2, "typeTime");
            return (Criteria) this;
        }

        public Criteria andTypeTimeNotBetween(String value1, String value2) {
            addCriterion("type_time not between", value1, value2, "typeTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNull() {
            addCriterion("factory_name is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNotNull() {
            addCriterion("factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameEqualTo(String value) {
            addCriterion("factory_name =", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotEqualTo(String value) {
            addCriterion("factory_name <>", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThan(String value) {
            addCriterion("factory_name >", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("factory_name >=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThan(String value) {
            addCriterion("factory_name <", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("factory_name <=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLike(String value) {
            addCriterion("factory_name like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotLike(String value) {
            addCriterion("factory_name not like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIn(List<String> values) {
            addCriterion("factory_name in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotIn(List<String> values) {
            addCriterion("factory_name not in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameBetween(String value1, String value2) {
            addCriterion("factory_name between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotBetween(String value1, String value2) {
            addCriterion("factory_name not between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNull() {
            addCriterion("submit_status is null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNotNull() {
            addCriterion("submit_status is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusEqualTo(String value) {
            addCriterion("submit_status =", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotEqualTo(String value) {
            addCriterion("submit_status <>", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThan(String value) {
            addCriterion("submit_status >", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThanOrEqualTo(String value) {
            addCriterion("submit_status >=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThan(String value) {
            addCriterion("submit_status <", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThanOrEqualTo(String value) {
            addCriterion("submit_status <=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLike(String value) {
            addCriterion("submit_status like", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotLike(String value) {
            addCriterion("submit_status not like", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIn(List<String> values) {
            addCriterion("submit_status in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotIn(List<String> values) {
            addCriterion("submit_status not in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusBetween(String value1, String value2) {
            addCriterion("submit_status between", value1, value2, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotBetween(String value1, String value2) {
            addCriterion("submit_status not between", value1, value2, "submitStatus");
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