package com.luer.warehouse.bean;

import java.util.Date;

public class Warehousematerial {
    private String id;

    private Date createTime;

    private Date updateTime;

    private Date warehouseTime;

    private Date auditTime;

    private String warehouseStatus;

    private String submitStatus;

    private String auditStatus;

    private String category;

    private String introduceNumber;

    private String factoryName;

    private String supplier;

    private String company;

    private String logisticsNumber;

    private Double freight;

    private Double expenses;

    private Double expensesShare;

    private String expensesMode;

    private Integer warehouseNumber;

    private Integer warehouseNumber1;

    private Integer warehouseNumber2;

    private Double warehouseAmount;

    private Double warehouseTaxamount;

    private Integer goodQuality;

    private String mode;

    private String freightShare;

    private String oddNumber;

    private String personCharge;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getWarehouseTime() {
        return warehouseTime;
    }

    public void setWarehouseTime(Date warehouseTime) {
        this.warehouseTime = warehouseTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus == null ? null : warehouseStatus.trim();
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus == null ? null : submitStatus.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getIntroduceNumber() {
        return introduceNumber;
    }

    public void setIntroduceNumber(String introduceNumber) {
        this.introduceNumber = introduceNumber == null ? null : introduceNumber.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber == null ? null : logisticsNumber.trim();
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public Double getExpensesShare() {
        return expensesShare;
    }

    public void setExpensesShare(Double expensesShare) {
        this.expensesShare = expensesShare;
    }

    public String getExpensesMode() {
        return expensesMode;
    }

    public void setExpensesMode(String expensesMode) {
        this.expensesMode = expensesMode == null ? null : expensesMode.trim();
    }

    public Integer getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(Integer warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public Integer getWarehouseNumber1() {
        return warehouseNumber1;
    }

    public void setWarehouseNumber1(Integer warehouseNumber1) {
        this.warehouseNumber1 = warehouseNumber1;
    }

    public Integer getWarehouseNumber2() {
        return warehouseNumber2;
    }

    public void setWarehouseNumber2(Integer warehouseNumber2) {
        this.warehouseNumber2 = warehouseNumber2;
    }

    public Double getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(Double warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }

    public Double getWarehouseTaxamount() {
        return warehouseTaxamount;
    }

    public void setWarehouseTaxamount(Double warehouseTaxamount) {
        this.warehouseTaxamount = warehouseTaxamount;
    }

    public Integer getGoodQuality() {
        return goodQuality;
    }

    public void setGoodQuality(Integer goodQuality) {
        this.goodQuality = goodQuality;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public String getFreightShare() {
        return freightShare;
    }

    public void setFreightShare(String freightShare) {
        this.freightShare = freightShare == null ? null : freightShare.trim();
    }

    public String getOddNumber() {
        return oddNumber;
    }

    public void setOddNumber(String oddNumber) {
        this.oddNumber = oddNumber == null ? null : oddNumber.trim();
    }

    public String getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge == null ? null : personCharge.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}