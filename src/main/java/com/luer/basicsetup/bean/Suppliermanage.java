package com.luer.basicsetup.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Suppliermanage {

    private String id;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "单位编码")
    private String unitCode;
    @ApiModelProperty(value = "供应商单位名称")
    private String unitName;
    @ApiModelProperty(value = "主联系人")
    private String mainContact;
    @ApiModelProperty(value = "类别代码")
    private String classCode;
    @ApiModelProperty(value = "类别名称")
    private String className;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    @ApiModelProperty(value = "所属地区")
    private String region;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;
    @ApiModelProperty(value = "传真")
    private String fax;
    @ApiModelProperty(value = "邮箱")
    private String mailbox;
    @ApiModelProperty(value = "全称")
    private String fullName;
    @ApiModelProperty(value = "税号")
    private String tax;
    @ApiModelProperty(value = "银行")
    private String bank;
    @ApiModelProperty(value = "银行账号")
    private String bankAccount;
    @ApiModelProperty(value = "法人代表")
    private String corporateRepresentative;
    @ApiModelProperty(value = "开票地址")
    private String billAddress;
    @ApiModelProperty(value = "开票信息1")
    private String invoice01;
    @ApiModelProperty(value = "开票信息2")
    private String invoice02;
    @ApiModelProperty(value = "数据状态")
    private String dataState;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "备注信息")
    private String remark;
    @ApiModelProperty(value = "信用额度")
    private String lineCredit;
    @ApiModelProperty(value = "生日")
    private String birthday;
    @ApiModelProperty(value = "业务员")
    private String salesman;
    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "经营范围")
    private String businessScope;
    @ApiModelProperty(value = "下次业务提示")
    private String businessTips;
    @ApiModelProperty(value = "备用")
    private String spare01;
    @ApiModelProperty(value = "备用")
    private String spare02;
    @ApiModelProperty(value = "备用")
    private String spare03;
    @ApiModelProperty(value = "备用")
    private String spare04;
    @ApiModelProperty(value = "备用")
    private String spare05;
    @ApiModelProperty(value = "备用")
    private String spare06;

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

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact == null ? null : mainContact.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getCorporateRepresentative() {
        return corporateRepresentative;
    }

    public void setCorporateRepresentative(String corporateRepresentative) {
        this.corporateRepresentative = corporateRepresentative == null ? null : corporateRepresentative.trim();
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress == null ? null : billAddress.trim();
    }

    public String getInvoice01() {
        return invoice01;
    }

    public void setInvoice01(String invoice01) {
        this.invoice01 = invoice01 == null ? null : invoice01.trim();
    }

    public String getInvoice02() {
        return invoice02;
    }

    public void setInvoice02(String invoice02) {
        this.invoice02 = invoice02 == null ? null : invoice02.trim();
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState == null ? null : dataState.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getLineCredit() {
        return lineCredit;
    }

    public void setLineCredit(String lineCredit) {
        this.lineCredit = lineCredit == null ? null : lineCredit.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getBusinessTips() {
        return businessTips;
    }

    public void setBusinessTips(String businessTips) {
        this.businessTips = businessTips == null ? null : businessTips.trim();
    }

    public String getSpare01() {
        return spare01;
    }

    public void setSpare01(String spare01) {
        this.spare01 = spare01 == null ? null : spare01.trim();
    }

    public String getSpare02() {
        return spare02;
    }

    public void setSpare02(String spare02) {
        this.spare02 = spare02 == null ? null : spare02.trim();
    }

    public String getSpare03() {
        return spare03;
    }

    public void setSpare03(String spare03) {
        this.spare03 = spare03 == null ? null : spare03.trim();
    }

    public String getSpare04() {
        return spare04;
    }

    public void setSpare04(String spare04) {
        this.spare04 = spare04 == null ? null : spare04.trim();
    }

    public String getSpare05() {
        return spare05;
    }

    public void setSpare05(String spare05) {
        this.spare05 = spare05 == null ? null : spare05.trim();
    }

    public String getSpare06() {
        return spare06;
    }

    public void setSpare06(String spare06) {
        this.spare06 = spare06 == null ? null : spare06.trim();
    }
}