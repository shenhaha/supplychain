package com.luer.basicsetup.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Goodsmessage {
    private String id;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "物料编码")
    private String merchantCode;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "货品编号")
    private String itemCode;
    @ApiModelProperty(value = "分类")
    private String type;
    @ApiModelProperty(value = "盒装sku")
    private String sku;
    @ApiModelProperty(value = "品牌")
    private String brand;
    @ApiModelProperty(value = "对应工艺流程")
    private String process;
    @ApiModelProperty(value = "季节")
    private String season;
    @ApiModelProperty(value = "商品成本价")
    private Double costPrice;
    @ApiModelProperty(value = "基本单位")
    private String unit;
    @ApiModelProperty(value = "面料材料")
    private String packag;
    @ApiModelProperty(value = "重量")
    private String weight;
    @ApiModelProperty(value = "条形码")
    private String barCode;
    @ApiModelProperty(value = "面料成份")
    private String ingredients;
    @ApiModelProperty(value = "执行工艺标准")
    private String standard;
    @ApiModelProperty(value = "数据状态 001位可用数据 002为回收站数据")
    private String dataState;
    @ApiModelProperty(value = "商品采购数量")
    private Integer number;
    @ApiModelProperty(value = "其他查询")
    private String other;
    @ApiModelProperty(value = "不含税价格")
    private Double unitPrice;
    @ApiModelProperty(value = "含税单价")
    private Double taxPrice;
    @ApiModelProperty(value = "不含税总价")
    private Double totalPrice;
    @ApiModelProperty(value = "含税总价")
    private Double taxTotalPrice;
    @ApiModelProperty(value = "预计入库时间")
    private String warehouseTime;
    @ApiModelProperty(value = "金额")
    private Double amountMoney;
    @ApiModelProperty(value = "已入库数量")
    private Integer warehouseNumber;
    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;
    @ApiModelProperty(value = "备用")
    private String spare04;
    @ApiModelProperty(value = "备用")
    private String spare05;
    @ApiModelProperty(value = "备用")
    private String spare06;
    @ApiModelProperty(value = "备注")
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

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPackag() {
        return packag;
    }

    public void setPackag(String packag) {
        this.packag = packag == null ? null : packag.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients == null ? null : ingredients.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState == null ? null : dataState.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(Double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTaxTotalPrice() {
        return taxTotalPrice;
    }

    public void setTaxTotalPrice(Double taxTotalPrice) {
        this.taxTotalPrice = taxTotalPrice;
    }

    public String getWarehouseTime() {
        return warehouseTime;
    }

    public void setWarehouseTime(String warehouseTime) {
        this.warehouseTime = warehouseTime == null ? null : warehouseTime.trim();
    }

    public Double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public Integer getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(Integer warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber == null ? null : purchaseNumber.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}