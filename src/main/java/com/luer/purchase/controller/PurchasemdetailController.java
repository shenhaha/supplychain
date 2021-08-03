package com.luer.purchase.controller;


import com.luer.comm.utils.ResultSet;
import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.PurchaseEnca;
import com.luer.purchase.bean.Purchasemdetail;
import com.luer.purchase.service.PurchasemdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase/material")
@Api(description = "原材料采购单详细接口")
public class PurchasemdetailController {


    @Autowired
    PurchasemdetailService mdetailService;

    @CrossOrigin
    @ApiOperation(value = "根据采购单号查询商品详细信息", notes = "根据采购单号查询商品详细信息", httpMethod = "GET")
    @ApiImplicitParam(name = "purchaseNumber", value = "采购单号", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectByPNumber")
    public ResultSet selectByPurchaseNumber(String purchaseNumber) {

        List<Purchasemdetail> purchasemdetails = mdetailService.selectByPurchaseNumber(purchaseNumber);
        /**对list集合进行判空*/
        if (purchasemdetails.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(purchasemdetails);
    }



    @CrossOrigin
    @ApiOperation(value = " 根据id查询全部信息", notes = "根据id查询全部信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "采购单id", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectBById")
    public Purchasemdetail selectBById(String id) {
        Purchasemdetail purchasemdetail = mdetailService.selectById(id);
        return purchasemdetail;
    }



}
