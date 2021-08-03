package com.luer.purchase.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;


@Api(description = "商品采购单实体类")
public class Purchase {
    private String id;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建时间")
    private Date updateTime;
    @ApiModelProperty(value = "采购时间")
    private Date purchaseTime;
    @ApiModelProperty(value = "财审时间")
    private Date financialTime;
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
    @ApiModelProperty(value = "关闭时间")
    private Date closeTime;
    @ApiModelProperty(value = "货品编号")
    private String itemCode;
    @ApiModelProperty(value = "商品数量")
    private Integer number;
    @ApiModelProperty(value = "供应商")
    private String supplier;
    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;
    @ApiModelProperty(value = "采购订单来源")
    private String purchaseSource;
    @ApiModelProperty(value = "审核状态 sh01已审核 sh02未审核")
    private String auditStatus;
    @ApiModelProperty(value = "收货状态 sh01已收货 sh02部分收货 sh03未收货")
    private String receiveStatus;
    @ApiModelProperty(value = "已入库数量")
    private Integer frequency;
    @ApiModelProperty(value = "采购订单类型")
    private String type;
    @ApiModelProperty(value = "商品类型")
    private String commodityType;
    @ApiModelProperty(value = "收货地址")
    private String receiveAddress;
    @ApiModelProperty(value = "制单人")
    private String singlePerson;
    @ApiModelProperty(value = "提交人")
    private String submitter;
    @ApiModelProperty(value = "合同条款")
    private String contractTerm;
    @ApiModelProperty(value = "财审人")
    private String financialJudge;
    @ApiModelProperty(value = "审核人")
    private String auditor;
    @ApiModelProperty(value = "不含税总金额")
    private Double totalSum;
    @ApiModelProperty(value = "含税总金额")
    private Double taxTotalSum;
    @ApiModelProperty(value = "总数量")
    private Integer totalQuantity;
    @ApiModelProperty(value = "采购完成状态")
    private String completeStatus;
    @ApiModelProperty(value = "开票金额")
    private Double invoiceAmount;
    @ApiModelProperty(value = "不开票金额")
    private Double nonInvoice;
    @ApiModelProperty(value = "税额")
    private Double taxAmount;
    @ApiModelProperty(value = "税率")
    private Double taxRate;
    @ApiModelProperty(value = "单位")
    private String unit;
    @ApiModelProperty(value = "工厂联系人")
    private String contacts;
    @ApiModelProperty(value = "发票种类")
    private String invoice;
    @ApiModelProperty(value = "运费")
    private Double freight;
    @ApiModelProperty(value = "货运方式")
    private String freightTransportation;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "时间类型")
    private String typeTime;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
    @ApiModelProperty(value = "工厂名字")
    private String factoryName;
    @ApiModelProperty(value = "提交状态")
    private String submitStatus;
    @ApiModelProperty(value = "备用")
    private String spare06;
    @ApiModelProperty(value = "备用")
    private String spare07;
    @ApiModelProperty(value = "备用")
    private String spare08;

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

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getFinancialTime() {
        return financialTime;
    }

    public void setFinancialTime(Date financialTime) {
        this.financialTime = financialTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber == null ? null : purchaseNumber.trim();
    }

    public String getPurchaseSource() {
        return purchaseSource;
    }

    public void setPurchaseSource(String purchaseSource) {
        this.purchaseSource = purchaseSource == null ? null : purchaseSource.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus == null ? null : receiveStatus.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType == null ? null : commodityType.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public String getSinglePerson() {
        return singlePerson;
    }

    public void setSinglePerson(String singlePerson) {
        this.singlePerson = singlePerson == null ? null : singlePerson.trim();
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter == null ? null : submitter.trim();
    }

    public String getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(String contractTerm) {
        this.contractTerm = contractTerm == null ? null : contractTerm.trim();
    }

    public String getFinancialJudge() {
        return financialJudge;
    }

    public void setFinancialJudge(String financialJudge) {
        this.financialJudge = financialJudge == null ? null : financialJudge.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Double getTaxTotalSum() {
        return taxTotalSum;
    }

    public void setTaxTotalSum(Double taxTotalSum) {
        this.taxTotalSum = taxTotalSum;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus == null ? null : completeStatus.trim();
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getNonInvoice() {
        return nonInvoice;
    }

    public void setNonInvoice(Double nonInvoice) {
        this.nonInvoice = nonInvoice;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getFreightTransportation() {
        return freightTransportation;
    }

    public void setFreightTransportation(String freightTransportation) {
        this.freightTransportation = freightTransportation == null ? null : freightTransportation.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(String typeTime) {
        this.typeTime = typeTime == null ? null : typeTime.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus == null ? null : submitStatus.trim();
    }

    public String getSpare06() {
        return spare06;
    }

    public void setSpare06(String spare06) {
        this.spare06 = spare06 == null ? null : spare06.trim();
    }

    public String getSpare07() {
        return spare07;
    }

    public void setSpare07(String spare07) {
        this.spare07 = spare07 == null ? null : spare07.trim();
    }

    public String getSpare08() {
        return spare08;
    }

    public void setSpare08(String spare08) {
        this.spare08 = spare08 == null ? null : spare08.trim();
    }
}