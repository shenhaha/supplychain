package com.luer.purchase.bean;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Api(description = "原材料采购单数据封装类")
@Data
public class PurchaseMEnca {


    private String id;
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
    @ApiModelProperty(value = "修改时间" )
    private Date updateTime;
    @ApiModelProperty(value = "采购时间" )
    private Date purchaseTime;
    @ApiModelProperty(value = "财审时间" )
    private Date financialTime;
    @ApiModelProperty(value = "提交时间" )
    private Date submitTime;
    @ApiModelProperty(value = "审核时间" )
    private Date auditTime;
    @ApiModelProperty(value = "关闭时间" )
    private Date closeTime;

    @ApiModelProperty(value = "货品编号" )
    private String itemCode;
    @ApiModelProperty(value = "商品数量" )
    private Integer number;
    @ApiModelProperty(value = "供应商" )
    private String supplier;
    @ApiModelProperty(value = "采购单号" )
    private String purchaseNumber;
    @ApiModelProperty(value = "采购订单来源" )
    private String purchaseSource;
    @ApiModelProperty(value = "审核状态" )
    private String auditStatus;
    @ApiModelProperty(value = "提交状态")
    private String submitStatus;
    @ApiModelProperty(value = "收货状态" )
    private String receiveStatus;
    @ApiModelProperty(value = "已入库数量" )
    private Integer frequency;
    @ApiModelProperty(value = "采购订单类型" )
    private String type;
    @ApiModelProperty(value = "商品类型" )
    private String commodityType;
    @ApiModelProperty(value = "收货地址" )
    private String receiveAddress;
    @ApiModelProperty(value = "合同条款" )
    private String contractTerm;
    @ApiModelProperty(value = "制单人" )
    private String singlePerson;
    @ApiModelProperty(value = "提交人" )
    private String submitter;
    @ApiModelProperty(value = "财审人" )
    private String financialJudge;
    @ApiModelProperty(value = "审核人" )
    private String auditor;
    @ApiModelProperty(value = "总金额" )
    private double totalSum;
    @ApiModelProperty(value = "含税总金额" )
    private Double taxTotalSum;
    @ApiModelProperty(value = "总数量" )
    private Integer totalQuantity;
    @ApiModelProperty(value = "采购完成状态" )
    private String completeStatus;
    @ApiModelProperty(value = "开票金额" )
    private Double invoiceAmount;
    @ApiModelProperty(value = "不开票金额" )
    private Double nonInvoice;
    @ApiModelProperty(value = "税额" )
    private Double taxAmount;
    @ApiModelProperty(value = "税率" )
    private Double taxRate;
    @ApiModelProperty(value = "单位" )
    private String unit;
    @ApiModelProperty(value = "工厂联系人" )
    private String contacts;
    @ApiModelProperty(value = "发票种类" )
    private String invoice;
    @ApiModelProperty(value = "运费" )
    private Double freight;
    @ApiModelProperty(value = "货运方式" )
    private String freightTransportation;
    @ApiModelProperty(value = "工厂名字" )
    private String factoryName;
    @ApiModelProperty(value = "备注" )
    private String remark;

    @ApiModelProperty(value = "Purchasemdetail对象" )
    private List<Purchasemdetail> goodsList;





}
