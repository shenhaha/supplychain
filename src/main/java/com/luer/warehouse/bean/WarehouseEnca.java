package com.luer.warehouse.bean;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Api(description = "原材料入库单数据封装类")
@Data
public class WarehouseEnca {

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

    private String expensesMode;

    private Double expensesShare;

    private Integer warehouseNumber;

    private Integer warehouseNumber1;

    private Integer warehouseNumber2;

    private Double warehouseAmount;

    private Double warehouseTaxamount;

    private String mode;

    private String freightShare;

    private Integer goodQuality;

    private String oddNumber;




    private String personCharge;

    private String remark;

    @ApiModelProperty(value = "Warehousemdetail对象" )
    private List<Warehousemdetail> goodsList;


}
