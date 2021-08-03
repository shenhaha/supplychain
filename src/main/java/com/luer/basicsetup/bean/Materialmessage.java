package com.luer.basicsetup.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Materialmessage {
    private String id;

    private Date createTime;

    private Date updateTime;

    private Date warehouseTime;

    private String name;

    private String materialCode;

    private String itemCode;

    private String type;

    private String brand;

    private String unit;

    private String defaultLoss;

    private String manufacturer;

    private Double costPrice;

    private String ingredients;

    private Integer number;

    private Double unitPrice;

    private Double taxPrice;

    private Double totalPrice;

    private Double taxTotalPrice;

    private String purchaseNumber;

    private String spare;

    private String dataState;

    private String spare02;

    private String spare03;

    private String spare04;

    private String spare05;

    private String spare06;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDefaultLoss() {
        return defaultLoss;
    }

    public void setDefaultLoss(String defaultLoss) {
        this.defaultLoss = defaultLoss == null ? null : defaultLoss.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients == null ? null : ingredients.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber == null ? null : purchaseNumber.trim();
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare == null ? null : spare.trim();
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState == null ? null : dataState.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}