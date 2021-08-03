package com.luer.purchase.controller;

import com.luer.basicsetup.bean.ExampleVo;
import com.luer.comm.utils.ResultSet;
import com.luer.purchase.bean.Purchasedetail;
import com.luer.purchase.service.PurchasedetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchasedetail/goods")
@Api(description = "商品采购单详细接口")
public class PurchasedetailController {

    @Autowired
    PurchasedetailService detailService;

    @CrossOrigin
    //@ApiOperation(value = "添加采购单详细信息", notes = "添加采购单详细信息", httpMethod = "POST")
    @ApiImplicitParam(name = "purchasedetail", value = "Purchasedetail对象", required = true, dataType = "Purchasedetail")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody Purchasedetail purchasedetail) {
        detailService.insert(purchasedetail);
        return ResultSet.getSuccess(purchasedetail);
    }


    @CrossOrigin
    //@ApiOperation(value = "根据ids批量删除采购单详细信息", notes = "根据ids批量删除采购单详细信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "采购单信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
    public ResultSet delete(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        detailService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    //@ApiOperation(value = "修改采购单详细信息", notes = "修改采购单详细信息 传入一个Purchase对象", httpMethod = "POST")
    @ApiImplicitParam(name = "purchase", value = "Purchase对象", required = true, dataType = "Purchase")
    @ResponseBody
    @PostMapping(value = "/update")
    public ResultSet update(@RequestBody Purchasedetail purchasedetail) {
        detailService.updateById(purchasedetail.getId(), purchasedetail);
        Purchasedetail purchasedetail1 = detailService.selectById(purchasedetail.getId());
        return ResultSet.getSuccess(purchasedetail1);
    }


    @CrossOrigin
    @ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select() {
        List<Purchasedetail> purchasedetails = detailService.select();
        /**对list集合进行判空*/
        if (purchasedetails.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(purchasedetails);
    }

    @CrossOrigin
    @ApiOperation(value = "根据采购单号查询商品详细信息", notes = "根据采购单号查询商品详细信息", httpMethod = "GET")
    @ApiImplicitParam(name = "purchaseNumber", value = "采购单号", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/selectByPNumber")
    public ResultSet selectByPurchaseNumber(String purchaseNumber) {
        List<Purchasedetail> purchasedetails = detailService.selectByPurchaseNumber(purchaseNumber);
        /**对list集合进行判空*/
        if (purchasedetails.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(purchasedetails);
    }







}
