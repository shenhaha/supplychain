package com.luer.warehouse.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehousematerialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehousematerialExample() {
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

        public Criteria andWarehouseTimeIsNull() {
            addCriterion("warehouse_time is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeIsNotNull() {
            addCriterion("warehouse_time is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeEqualTo(Date value) {
            addCriterion("warehouse_time =", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeNotEqualTo(Date value) {
            addCriterion("warehouse_time <>", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeGreaterThan(Date value) {
            addCriterion("warehouse_time >", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warehouse_time >=", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeLessThan(Date value) {
            addCriterion("warehouse_time <", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeLessThanOrEqualTo(Date value) {
            addCriterion("warehouse_time <=", value, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeIn(List<Date> values) {
            addCriterion("warehouse_time in", values, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeNotIn(List<Date> values) {
            addCriterion("warehouse_time not in", values, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeBetween(Date value1, Date value2) {
            addCriterion("warehouse_time between", value1, value2, "warehouseTime");
            return (Criteria) this;
        }

        public Criteria andWarehouseTimeNotBetween(Date value1, Date value2) {
            addCriterion("warehouse_time not between", value1, value2, "warehouseTime");
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

        public Criteria andWarehouseStatusIsNull() {
            addCriterion("warehouse_status is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusIsNotNull() {
            addCriterion("warehouse_status is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusEqualTo(String value) {
            addCriterion("warehouse_status =", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusNotEqualTo(String value) {
            addCriterion("warehouse_status <>", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusGreaterThan(String value) {
            addCriterion("warehouse_status >", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_status >=", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusLessThan(String value) {
            addCriterion("warehouse_status <", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusLessThanOrEqualTo(String value) {
            addCriterion("warehouse_status <=", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusLike(String value) {
            addCriterion("warehouse_status like", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusNotLike(String value) {
            addCriterion("warehouse_status not like", value, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusIn(List<String> values) {
            addCriterion("warehouse_status in", values, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusNotIn(List<String> values) {
            addCriterion("warehouse_status not in", values, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusBetween(String value1, String value2) {
            addCriterion("warehouse_status between", value1, value2, "warehouseStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseStatusNotBetween(String value1, String value2) {
            addCriterion("warehouse_status not between", value1, value2, "warehouseStatus");
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberIsNull() {
            addCriterion("introduce_number is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberIsNotNull() {
            addCriterion("introduce_number is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberEqualTo(String value) {
            addCriterion("introduce_number =", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberNotEqualTo(String value) {
            addCriterion("introduce_number <>", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberGreaterThan(String value) {
            addCriterion("introduce_number >", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_number >=", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberLessThan(String value) {
            addCriterion("introduce_number <", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberLessThanOrEqualTo(String value) {
            addCriterion("introduce_number <=", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberLike(String value) {
            addCriterion("introduce_number like", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberNotLike(String value) {
            addCriterion("introduce_number not like", value, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberIn(List<String> values) {
            addCriterion("introduce_number in", values, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberNotIn(List<String> values) {
            addCriterion("introduce_number not in", values, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberBetween(String value1, String value2) {
            addCriterion("introduce_number between", value1, value2, "introduceNumber");
            return (Criteria) this;
        }

        public Criteria andIntroduceNumberNotBetween(String value1, String value2) {
            addCriterion("introduce_number not between", value1, value2, "introduceNumber");
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

        public Criteria andLogisticsNumberIsNull() {
            addCriterion("logistics_number is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIsNotNull() {
            addCriterion("logistics_number is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberEqualTo(String value) {
            addCriterion("logistics_number =", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotEqualTo(String value) {
            addCriterion("logistics_number <>", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThan(String value) {
            addCriterion("logistics_number >", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_number >=", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThan(String value) {
            addCriterion("logistics_number <", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThanOrEqualTo(String value) {
            addCriterion("logistics_number <=", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLike(String value) {
            addCriterion("logistics_number like", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotLike(String value) {
            addCriterion("logistics_number not like", value, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIn(List<String> values) {
            addCriterion("logistics_number in", values, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotIn(List<String> values) {
            addCriterion("logistics_number not in", values, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberBetween(String value1, String value2) {
            addCriterion("logistics_number between", value1, value2, "logisticsNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotBetween(String value1, String value2) {
            addCriterion("logistics_number not between", value1, value2, "logisticsNumber");
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

        public Criteria andExpensesIsNull() {
            addCriterion("expenses is null");
            return (Criteria) this;
        }

        public Criteria andExpensesIsNotNull() {
            addCriterion("expenses is not null");
            return (Criteria) this;
        }

        public Criteria andExpensesEqualTo(Double value) {
            addCriterion("expenses =", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesNotEqualTo(Double value) {
            addCriterion("expenses <>", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesGreaterThan(Double value) {
            addCriterion("expenses >", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesGreaterThanOrEqualTo(Double value) {
            addCriterion("expenses >=", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesLessThan(Double value) {
            addCriterion("expenses <", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesLessThanOrEqualTo(Double value) {
            addCriterion("expenses <=", value, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesIn(List<Double> values) {
            addCriterion("expenses in", values, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesNotIn(List<Double> values) {
            addCriterion("expenses not in", values, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesBetween(Double value1, Double value2) {
            addCriterion("expenses between", value1, value2, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesNotBetween(Double value1, Double value2) {
            addCriterion("expenses not between", value1, value2, "expenses");
            return (Criteria) this;
        }

        public Criteria andExpensesShareIsNull() {
            addCriterion("expenses_share is null");
            return (Criteria) this;
        }

        public Criteria andExpensesShareIsNotNull() {
            addCriterion("expenses_share is not null");
            return (Criteria) this;
        }

        public Criteria andExpensesShareEqualTo(Double value) {
            addCriterion("expenses_share =", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareNotEqualTo(Double value) {
            addCriterion("expenses_share <>", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareGreaterThan(Double value) {
            addCriterion("expenses_share >", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareGreaterThanOrEqualTo(Double value) {
            addCriterion("expenses_share >=", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareLessThan(Double value) {
            addCriterion("expenses_share <", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareLessThanOrEqualTo(Double value) {
            addCriterion("expenses_share <=", value, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareIn(List<Double> values) {
            addCriterion("expenses_share in", values, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareNotIn(List<Double> values) {
            addCriterion("expenses_share not in", values, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareBetween(Double value1, Double value2) {
            addCriterion("expenses_share between", value1, value2, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesShareNotBetween(Double value1, Double value2) {
            addCriterion("expenses_share not between", value1, value2, "expensesShare");
            return (Criteria) this;
        }

        public Criteria andExpensesModeIsNull() {
            addCriterion("expenses_mode is null");
            return (Criteria) this;
        }

        public Criteria andExpensesModeIsNotNull() {
            addCriterion("expenses_mode is not null");
            return (Criteria) this;
        }

        public Criteria andExpensesModeEqualTo(String value) {
            addCriterion("expenses_mode =", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeNotEqualTo(String value) {
            addCriterion("expenses_mode <>", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeGreaterThan(String value) {
            addCriterion("expenses_mode >", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeGreaterThanOrEqualTo(String value) {
            addCriterion("expenses_mode >=", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeLessThan(String value) {
            addCriterion("expenses_mode <", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeLessThanOrEqualTo(String value) {
            addCriterion("expenses_mode <=", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeLike(String value) {
            addCriterion("expenses_mode like", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeNotLike(String value) {
            addCriterion("expenses_mode not like", value, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeIn(List<String> values) {
            addCriterion("expenses_mode in", values, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeNotIn(List<String> values) {
            addCriterion("expenses_mode not in", values, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeBetween(String value1, String value2) {
            addCriterion("expenses_mode between", value1, value2, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andExpensesModeNotBetween(String value1, String value2) {
            addCriterion("expenses_mode not between", value1, value2, "expensesMode");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIsNull() {
            addCriterion("warehouse_number is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIsNotNull() {
            addCriterion("warehouse_number is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberEqualTo(Integer value) {
            addCriterion("warehouse_number =", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotEqualTo(Integer value) {
            addCriterion("warehouse_number <>", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberGreaterThan(Integer value) {
            addCriterion("warehouse_number >", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number >=", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberLessThan(Integer value) {
            addCriterion("warehouse_number <", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberLessThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number <=", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIn(List<Integer> values) {
            addCriterion("warehouse_number in", values, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotIn(List<Integer> values) {
            addCriterion("warehouse_number not in", values, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_number between", value1, value2, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_number not between", value1, value2, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1IsNull() {
            addCriterion("warehouse_number1 is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1IsNotNull() {
            addCriterion("warehouse_number1 is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1EqualTo(Integer value) {
            addCriterion("warehouse_number1 =", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1NotEqualTo(Integer value) {
            addCriterion("warehouse_number1 <>", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1GreaterThan(Integer value) {
            addCriterion("warehouse_number1 >", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1GreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number1 >=", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1LessThan(Integer value) {
            addCriterion("warehouse_number1 <", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1LessThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number1 <=", value, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1In(List<Integer> values) {
            addCriterion("warehouse_number1 in", values, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1NotIn(List<Integer> values) {
            addCriterion("warehouse_number1 not in", values, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1Between(Integer value1, Integer value2) {
            addCriterion("warehouse_number1 between", value1, value2, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber1NotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_number1 not between", value1, value2, "warehouseNumber1");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2IsNull() {
            addCriterion("warehouse_number2 is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2IsNotNull() {
            addCriterion("warehouse_number2 is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2EqualTo(Integer value) {
            addCriterion("warehouse_number2 =", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2NotEqualTo(Integer value) {
            addCriterion("warehouse_number2 <>", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2GreaterThan(Integer value) {
            addCriterion("warehouse_number2 >", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2GreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number2 >=", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2LessThan(Integer value) {
            addCriterion("warehouse_number2 <", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2LessThanOrEqualTo(Integer value) {
            addCriterion("warehouse_number2 <=", value, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2In(List<Integer> values) {
            addCriterion("warehouse_number2 in", values, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2NotIn(List<Integer> values) {
            addCriterion("warehouse_number2 not in", values, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2Between(Integer value1, Integer value2) {
            addCriterion("warehouse_number2 between", value1, value2, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumber2NotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_number2 not between", value1, value2, "warehouseNumber2");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountIsNull() {
            addCriterion("warehouse_amount is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountIsNotNull() {
            addCriterion("warehouse_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountEqualTo(Double value) {
            addCriterion("warehouse_amount =", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountNotEqualTo(Double value) {
            addCriterion("warehouse_amount <>", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountGreaterThan(Double value) {
            addCriterion("warehouse_amount >", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("warehouse_amount >=", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountLessThan(Double value) {
            addCriterion("warehouse_amount <", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountLessThanOrEqualTo(Double value) {
            addCriterion("warehouse_amount <=", value, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountIn(List<Double> values) {
            addCriterion("warehouse_amount in", values, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountNotIn(List<Double> values) {
            addCriterion("warehouse_amount not in", values, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountBetween(Double value1, Double value2) {
            addCriterion("warehouse_amount between", value1, value2, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseAmountNotBetween(Double value1, Double value2) {
            addCriterion("warehouse_amount not between", value1, value2, "warehouseAmount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountIsNull() {
            addCriterion("warehouse_taxamount is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountIsNotNull() {
            addCriterion("warehouse_taxamount is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountEqualTo(Double value) {
            addCriterion("warehouse_taxamount =", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountNotEqualTo(Double value) {
            addCriterion("warehouse_taxamount <>", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountGreaterThan(Double value) {
            addCriterion("warehouse_taxamount >", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountGreaterThanOrEqualTo(Double value) {
            addCriterion("warehouse_taxamount >=", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountLessThan(Double value) {
            addCriterion("warehouse_taxamount <", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountLessThanOrEqualTo(Double value) {
            addCriterion("warehouse_taxamount <=", value, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountIn(List<Double> values) {
            addCriterion("warehouse_taxamount in", values, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountNotIn(List<Double> values) {
            addCriterion("warehouse_taxamount not in", values, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountBetween(Double value1, Double value2) {
            addCriterion("warehouse_taxamount between", value1, value2, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andWarehouseTaxamountNotBetween(Double value1, Double value2) {
            addCriterion("warehouse_taxamount not between", value1, value2, "warehouseTaxamount");
            return (Criteria) this;
        }

        public Criteria andGoodQualityIsNull() {
            addCriterion("good_quality is null");
            return (Criteria) this;
        }

        public Criteria andGoodQualityIsNotNull() {
            addCriterion("good_quality is not null");
            return (Criteria) this;
        }

        public Criteria andGoodQualityEqualTo(Integer value) {
            addCriterion("good_quality =", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityNotEqualTo(Integer value) {
            addCriterion("good_quality <>", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityGreaterThan(Integer value) {
            addCriterion("good_quality >", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_quality >=", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityLessThan(Integer value) {
            addCriterion("good_quality <", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityLessThanOrEqualTo(Integer value) {
            addCriterion("good_quality <=", value, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityIn(List<Integer> values) {
            addCriterion("good_quality in", values, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityNotIn(List<Integer> values) {
            addCriterion("good_quality not in", values, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityBetween(Integer value1, Integer value2) {
            addCriterion("good_quality between", value1, value2, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andGoodQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("good_quality not between", value1, value2, "goodQuality");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(String value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(String value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(String value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(String value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(String value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(String value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLike(String value) {
            addCriterion("mode like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotLike(String value) {
            addCriterion("mode not like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<String> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<String> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(String value1, String value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(String value1, String value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andFreightShareIsNull() {
            addCriterion("freight_share is null");
            return (Criteria) this;
        }

        public Criteria andFreightShareIsNotNull() {
            addCriterion("freight_share is not null");
            return (Criteria) this;
        }

        public Criteria andFreightShareEqualTo(String value) {
            addCriterion("freight_share =", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareNotEqualTo(String value) {
            addCriterion("freight_share <>", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareGreaterThan(String value) {
            addCriterion("freight_share >", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareGreaterThanOrEqualTo(String value) {
            addCriterion("freight_share >=", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareLessThan(String value) {
            addCriterion("freight_share <", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareLessThanOrEqualTo(String value) {
            addCriterion("freight_share <=", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareLike(String value) {
            addCriterion("freight_share like", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareNotLike(String value) {
            addCriterion("freight_share not like", value, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareIn(List<String> values) {
            addCriterion("freight_share in", values, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareNotIn(List<String> values) {
            addCriterion("freight_share not in", values, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareBetween(String value1, String value2) {
            addCriterion("freight_share between", value1, value2, "freightShare");
            return (Criteria) this;
        }

        public Criteria andFreightShareNotBetween(String value1, String value2) {
            addCriterion("freight_share not between", value1, value2, "freightShare");
            return (Criteria) this;
        }

        public Criteria andOddNumberIsNull() {
            addCriterion("odd_number is null");
            return (Criteria) this;
        }

        public Criteria andOddNumberIsNotNull() {
            addCriterion("odd_number is not null");
            return (Criteria) this;
        }

        public Criteria andOddNumberEqualTo(String value) {
            addCriterion("odd_number =", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberNotEqualTo(String value) {
            addCriterion("odd_number <>", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberGreaterThan(String value) {
            addCriterion("odd_number >", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberGreaterThanOrEqualTo(String value) {
            addCriterion("odd_number >=", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberLessThan(String value) {
            addCriterion("odd_number <", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberLessThanOrEqualTo(String value) {
            addCriterion("odd_number <=", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberLike(String value) {
            addCriterion("odd_number like", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberNotLike(String value) {
            addCriterion("odd_number not like", value, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberIn(List<String> values) {
            addCriterion("odd_number in", values, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberNotIn(List<String> values) {
            addCriterion("odd_number not in", values, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberBetween(String value1, String value2) {
            addCriterion("odd_number between", value1, value2, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andOddNumberNotBetween(String value1, String value2) {
            addCriterion("odd_number not between", value1, value2, "oddNumber");
            return (Criteria) this;
        }

        public Criteria andPersonChargeIsNull() {
            addCriterion("person_charge is null");
            return (Criteria) this;
        }

        public Criteria andPersonChargeIsNotNull() {
            addCriterion("person_charge is not null");
            return (Criteria) this;
        }

        public Criteria andPersonChargeEqualTo(String value) {
            addCriterion("person_charge =", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeNotEqualTo(String value) {
            addCriterion("person_charge <>", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeGreaterThan(String value) {
            addCriterion("person_charge >", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeGreaterThanOrEqualTo(String value) {
            addCriterion("person_charge >=", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeLessThan(String value) {
            addCriterion("person_charge <", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeLessThanOrEqualTo(String value) {
            addCriterion("person_charge <=", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeLike(String value) {
            addCriterion("person_charge like", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeNotLike(String value) {
            addCriterion("person_charge not like", value, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeIn(List<String> values) {
            addCriterion("person_charge in", values, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeNotIn(List<String> values) {
            addCriterion("person_charge not in", values, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeBetween(String value1, String value2) {
            addCriterion("person_charge between", value1, value2, "personCharge");
            return (Criteria) this;
        }

        public Criteria andPersonChargeNotBetween(String value1, String value2) {
            addCriterion("person_charge not between", value1, value2, "personCharge");
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