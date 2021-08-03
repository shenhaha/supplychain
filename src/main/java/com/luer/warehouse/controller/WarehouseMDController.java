package com.luer.warehouse.controller;


import com.luer.comm.utils.ResultSet;
import com.luer.warehouse.bean.Warehousemdetail;
import com.luer.warehouse.service.WarehouseMDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse/material")
@Api(description = "原材料入库单详细接口")
public class WarehouseMDController {


    @Autowired
    WarehouseMDService wMDService;

    @CrossOrigin
    @ApiOperation(value = "根据采购单号查询入库单详细信息", notes = "根据采购单号查询入库单详细信息", httpMethod = "GET")
    @ApiImplicitParam(name = "purchaseNumber", value = "采购单号", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectByPNumber")
    public ResultSet selectByPurchaseNumber(String purchaseNumber) {
        List<Warehousemdetail> warehousemdetails = wMDService.selectByPurchaseNumber(purchaseNumber);
        /**对list集合进行判空*/
        if (warehousemdetails.isEmpty()) {
            //为空
            return ResultSet.getFail("入库单详细数据为空");
        }
        return ResultSet.getSuccess(warehousemdetails);
    }








}
