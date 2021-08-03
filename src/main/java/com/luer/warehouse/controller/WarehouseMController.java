package com.luer.warehouse.controller;


import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.service.MaterialmessageService;
import com.luer.comm.utils.*;
import com.luer.purchase.bean.PurchaseEnca;
import com.luer.purchase.bean.Purchasemdetail;
import com.luer.purchase.service.PurchasemdetailService;
import com.luer.warehouse.bean.WarehouseEnca;
import com.luer.warehouse.bean.Warehousematerial;
import com.luer.warehouse.bean.Warehousemdetail;
import com.luer.warehouse.service.WarehouseMDService;
import com.luer.warehouse.service.WarehouseMService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/warehouse/material")
@Api(description = "原材料入库单接口")
public class WarehouseMController {

    @Autowired
    WarehouseMService wMService;
    @Autowired
    WarehouseMDService wMDService;
    @Autowired
    PurchasemdetailService pmdetailService;


    @CrossOrigin
    @ApiOperation(value="根据ids批量删除入库单", notes="根据ids批量删除入库单", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "入库单id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
   public ResultSet delete(@RequestBody ExampleVo vo){

        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        /**删除采购单详细信息*/
        for(int k=0;k<list.size();k++){
           String purchaseNumber = wMService.selectIntroduceNumberById(list.get(k));
            wMDService.deleteByPNumber(purchaseNumber);
       }
       /**批量删除采购单*/
       String[] arr = list.toArray(new String[list.size()]);
       wMService.deleteByIds(arr);
        return ResultSet.getSuccess();

    }

    @CrossOrigin
    @ApiOperation(value = "修改入库单", notes = "修改入库单 传入一个Warehousematerial对象", httpMethod = "POST")
    @ApiImplicitParam(name = "warehousematerial", value = "Warehousematerial对象", required = true, dataType = "Warehousematerial")
    @ResponseBody
    @PostMapping(value="/update")
    public ResultSet update(@RequestBody WarehouseEnca warehouseEnca) {

        /**获得Warehousematerial对象*/
        Warehousematerial warehousematerial = ObtainWarehousematerial(warehouseEnca);
        /**修改Warehousematerial对象*/
        wMService.updateById(warehousematerial.getId(),warehousematerial);

        for(int m=0;m<warehouseEnca.getGoodsList().size();m++){
            Warehousemdetail warehousemdetail1 = warehouseEnca.getGoodsList().get(m);
            wMDService.updateById(warehousemdetail1.getId(),warehousemdetail1);
        }

        /**获得修改后的数据*/
        List<WarehouseEnca> purchaseEnca1 = selectById(warehousematerial.getId());
        return ResultSet.getSuccess(purchaseEnca1);

    }

    @CrossOrigin
   // @ApiOperation(value = "根据id查询入库单", notes = "根据id查询入库单", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "入库单id", required = true, dataType = "String")
    @ResponseBody
    @GetMapping(value="/selectById")
    public List<WarehouseEnca> selectById(String id){
        List<Warehousematerial>  warehousematerials =  wMService.selectById(id);
        List<WarehouseEnca> warehouseEncas = ObtainWarehouseEnca(warehousematerials);
        return warehouseEncas;
    }



    @CrossOrigin
    //@ApiOperation(value = "添加入库单", notes = "添加入库单", httpMethod = "POST")
    @ApiImplicitParam(name = "warehousematerial", value = "Warehousematerial对象", required = true, dataType = "Warehousematerial")
    @ResponseBody
    @PostMapping("/saveWarehouse")
    public ResultSet saveWarehouse(@RequestBody Warehousematerial warehousematerial) {
        if(warehousematerial == null){
            return ResultSet.getFail("参数为空");
        }
        wMService.insert(warehousematerial);
        return ResultSet.getSuccess(warehousematerial);
    }


    @CrossOrigin
    @ApiOperation(value = "查询时间最大的那条记录", notes = "查询时间最大的那条记录", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectMaxCreateTime")
    public Warehousematerial selectMaxCreateTime() {
        Warehousematerial warehousematerial = wMService.selectMaxCreateTime();
        if(warehousematerial == null){
            return null;
        }
        return warehousematerial;
    }


    @CrossOrigin
    //@ApiOperation(value = "查询类别查询记录", notes = "查询类别查询记录", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/seclectByCategory")
    public List<Warehousematerial> seclectByCategory(String category) {
        List<Warehousematerial> warehousematerials = wMService.seclectByCategory(category);
        if(warehousematerials == null){
            return null;
        }
        return warehousematerials;
    }


    @CrossOrigin
    @ApiOperation(value = "添加入库单", notes = "添加入库单", httpMethod = "POST")
    @ApiImplicitParam(name = "warehousematerial", value = "Warehousematerial对象", required = true, dataType = "Warehousematerial")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody WarehouseEnca warehouseEnca) {


        Warehousematerial warehousematerial = new Warehousematerial();
        Warehousemdetail warehousemdetail = new Warehousemdetail();

        warehousematerial.setId(UUIDUtils.getUUID());
        warehousematerial.setCreateTime(new Date());
        /**设置入库单默认是未审核 未提交 未入库状态*/
        warehousematerial.setAuditStatus("sh02");
        warehousematerial.setSubmitStatus("tj02");
        warehousematerial.setWarehouseStatus("ru02");


        if(selectMaxCreateTime() == null){
            warehousematerial.setOddNumber(ODDNumberUtil.CreateDate()+"00001");
        }else if(selectMaxCreateTime().getOddNumber() != null){
            /**采购单号 根据采购单号查询采购单相关商品详细信息*/
            warehousematerial.setOddNumber(ODDNumberUtil.CreatePNumber(selectMaxCreateTime().getOddNumber()));
        }

        if(warehouseEnca.getCategory() != null){
            warehousematerial.setCategory(warehouseEnca.getCategory());
        }
        if(warehouseEnca.getIntroduceNumber() != null){
            warehousematerial.setIntroduceNumber(warehouseEnca.getIntroduceNumber());
        }
        if(warehouseEnca.getFactoryName() != null){
            warehousematerial.setFactoryName(warehouseEnca.getFactoryName());
        }
        if(warehouseEnca.getSupplier() != null){
            warehousematerial.setSupplier(warehouseEnca.getSupplier());
        }
        if(warehouseEnca.getCompany() != null){
            warehousematerial.setCompany(warehouseEnca.getCompany());
        }
        if(warehouseEnca.getLogisticsNumber() != null){
            warehousematerial.setLogisticsNumber(warehouseEnca.getLogisticsNumber());
        }
        if(warehouseEnca.getFreight() != null){
            warehousematerial.setFreight(warehouseEnca.getFreight());
        }
        if(warehouseEnca.getExpenses() != null){
            warehousematerial.setExpenses(warehouseEnca.getExpenses());
        }
        if(warehouseEnca.getExpensesMode() != null){
            warehousematerial.setExpensesMode(warehouseEnca.getExpensesMode());
        }

        int Numbers = 0;/**入库总数量*/
        int wNumber = 0;/**已入库数量*/

        for (int j=0;j<warehouseEnca.getGoodsList().size();j++){
            if(warehouseEnca.getGoodsList().get(j).getNumber() != null){
                Numbers += warehouseEnca.getGoodsList().get(j).getNumber();
            }
            if(warehouseEnca.getGoodsList().get(j).getWarehouseNumber() != null){
                wNumber += warehouseEnca.getGoodsList().get(j).getWarehouseNumber();
            }
        }

        warehousematerial.setWarehouseNumber(Numbers);
        warehousematerial.setWarehouseNumber1(wNumber);
        warehousematerial.setWarehouseNumber2(Numbers - wNumber);

        if(warehouseEnca.getWarehouseAmount() != null){
            warehousematerial.setWarehouseAmount(warehouseEnca.getWarehouseAmount());
        }
        if(warehouseEnca.getWarehouseTaxamount() != null){
            warehousematerial.setWarehouseTaxamount(warehouseEnca.getWarehouseTaxamount());
        }
        if(warehouseEnca.getMode() != null){
            warehousematerial.setMode(warehouseEnca.getMode());
        }
        if(warehouseEnca.getFreightShare() != null){
            warehousematerial.setFreightShare(warehouseEnca.getFreightShare());
        }
        if(warehouseEnca.getRemark() != null){
            warehousematerial.setRemark(warehouseEnca.getRemark());
        }

        wMService.insert(warehousematerial);

        for (int k=0;k<warehouseEnca.getGoodsList().size();k++){

            warehousemdetail.setId(UUIDUtils.getUUID());
            warehousemdetail.setMaterialId(warehouseEnca.getGoodsList().get(k).getMaterialId());
            warehousemdetail.setCreateTime(new Date());

            if(warehouseEnca.getGoodsList().get(k).getName() != null ){
                warehousemdetail.setName(warehouseEnca.getGoodsList().get(k).getName());
            }
            if(warehouseEnca.getGoodsList().get(k).getMaterialCode() != null){
                warehousemdetail.setMaterialCode(warehouseEnca.getGoodsList().get(k).getMaterialCode());
            }
            if(warehouseEnca.getGoodsList().get(k).getItemCode() != null){
                warehousemdetail.setItemCode(warehouseEnca.getGoodsList().get(k).getItemCode());
            }
            if(warehouseEnca.getGoodsList().get(k).getType() != null){
                warehousemdetail.setType(warehouseEnca.getGoodsList().get(k).getType());
            }
            if(warehouseEnca.getGoodsList().get(k).getBrand() != null){
                warehousemdetail.setBrand(warehouseEnca.getGoodsList().get(k).getBrand());
            }
            if(warehouseEnca.getGoodsList().get(k).getUnit() != null){
                warehousemdetail.setUnit(warehouseEnca.getGoodsList().get(k).getUnit());
            }
            if(warehouseEnca.getGoodsList().get(k).getDefaultLoss() != null){
                warehousemdetail.setDefaultLoss(warehouseEnca.getGoodsList().get(k).getDefaultLoss());
            }
            if(warehouseEnca.getGoodsList().get(k).getManufacturer() != null){
                warehousemdetail.setManufacturer(warehouseEnca.getGoodsList().get(k).getManufacturer());
            }
            if(warehouseEnca.getGoodsList().get(k).getCostPrice() != null){
                warehousemdetail.setCostPrice(warehouseEnca.getGoodsList().get(k).getCostPrice());
            }
            if(warehouseEnca.getGoodsList().get(k).getIngredients() != null){
                warehousemdetail.setIngredients(warehouseEnca.getGoodsList().get(k).getIngredients());
            }
            if(warehouseEnca.getGoodsList().get(k).getNumber() != null){
                warehousemdetail.setNumber(warehouseEnca.getGoodsList().get(k).getNumber());
            }
            if(warehouseEnca.getGoodsList().get(k).getUnitPrice() != null){
                warehousemdetail.setUnitPrice(warehouseEnca.getGoodsList().get(k).getUnitPrice());
            }
            if(warehouseEnca.getGoodsList().get(k).getTaxPrice() != null){
                warehousemdetail.setTaxPrice(warehouseEnca.getGoodsList().get(k).getTaxPrice());
            }
            if(warehouseEnca.getGoodsList().get(k).getTotalPrice() != null){
                warehousemdetail.setTaxPrice(warehouseEnca.getGoodsList().get(k).getTotalPrice());
            }
            if(warehouseEnca.getGoodsList().get(k).getTaxTotalPrice() != null){
                warehousemdetail.setTaxTotalPrice(warehouseEnca.getGoodsList().get(k).getTaxTotalPrice());
            }

            if(warehousematerial.getOddNumber() != null){
                warehousemdetail.setOddNumber(warehousematerial.getOddNumber());
            }
            if(warehouseEnca.getGoodsList().get(k).getPurchaseNumber() != null){
                warehousemdetail.setPurchaseNumber(warehouseEnca.getGoodsList().get(k).getPurchaseNumber());
            }
            if(warehouseEnca.getGoodsList().get(k).getWarehousePrice() != null){
                warehousemdetail.setWarehousePrice(warehouseEnca.getGoodsList().get(k).getWarehousePrice());
            }
            if(warehouseEnca.getGoodsList().get(k).getWarehouseTaxprice() != null){
                warehousemdetail.setWarehouseTaxprice(warehouseEnca.getGoodsList().get(k).getWarehouseTaxprice());
            }
            if(warehouseEnca.getGoodsList().get(k).getWarehouseAmount() != null){
                warehousemdetail.setWarehouseAmount(warehouseEnca.getGoodsList().get(k).getWarehouseAmount());
            }
            if(warehouseEnca.getGoodsList().get(k).getWarehouseTaxamount() != null){
                warehousemdetail.setWarehouseTaxamount(warehouseEnca.getGoodsList().get(k).getWarehouseTaxamount());
            }
            if(warehouseEnca.getGoodsList().get(k).getWarehouseNumber() != null){
                warehousemdetail.setWarehouseNumber(warehouseEnca.getGoodsList().get(k).getWarehouseNumber());
            }
            if(warehouseEnca.getGoodsList().get(k).getFreightShare() != null){
                warehousemdetail.setFreightShare(warehouseEnca.getGoodsList().get(k).getFreightShare());
            }
            if(warehouseEnca.getGoodsList().get(k).getExpenses() != null){
                warehousemdetail.setExpenses(warehouseEnca.getGoodsList().get(k).getExpenses());
            }
            if(warehouseEnca.getGoodsList().get(k).getBatch() != null){
                warehousemdetail.setBatch(warehouseEnca.getGoodsList().get(k).getBatch());
            }
            if(warehouseEnca.getGoodsList().get(k).getSpare() != null){
                warehousemdetail.setSpare(warehouseEnca.getGoodsList().get(k).getSpare());
            }

            wMDService.insert(warehousemdetail);
            //selectNumber(warehouseEnca.getGoodsList().get(k).getMaterialId());
        }
        return ResultSet.getSuccess(warehouseEnca);

    }

    @ResponseBody
    @GetMapping("/selectNumber")
    public void selectNumber(String id){
        Purchasemdetail purchasemdetail = pmdetailService.selectById(id);
        purchasemdetail.setNumber(purchasemdetail.getNumber() + 1);
        pmdetailService.updateById(purchasemdetail.getId(),purchasemdetail);
    }


    @CrossOrigin
    @ApiOperation(value = "入库单分页查询", notes = "入库单分页查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factoryName", value = "仓库(工厂)", dataType = "String"),
            @ApiImplicitParam(name = "category", value = "入库类别", dataType = "String"),
            @ApiImplicitParam(name = "oddNumber", value = "入库单号", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @GetMapping("/queryPage")
    public PageBean queryPage(
            @RequestParam(required = false) String factoryName,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String oddNumber,
            @RequestParam(required = false, defaultValue = "1") int pageNum,
            @RequestParam(required = false, defaultValue = "10") int pageSize)  {

        List<Warehousematerial> warehousematerials = null;
        List<WarehouseEnca> warehouseEncas = null;

        if(StringUtils.isBlank(factoryName) && StringUtils.isBlank(category)
                && StringUtils.isBlank(oddNumber)){
            /**查询所有数据*/
            warehousematerials = wMService.select();
            warehouseEncas = ObtainWarehouseEnca(warehousematerials);
        }else if(StringUtils.isNotBlank(factoryName)){
            warehousematerials = wMService.selectByFName(factoryName);
            warehouseEncas = ObtainWarehouseEnca(warehousematerials);
            if(StringUtils.isNotBlank(category)){
                warehousematerials = wMService.selectByFNameAndCategory(factoryName,category);
                warehouseEncas = ObtainWarehouseEnca(warehousematerials);
                if(StringUtils.isNotBlank(oddNumber)){
                    warehousematerials = wMService.selectByFNameAndCategoryAndOddNumber(factoryName,category,oddNumber);
                    warehouseEncas = ObtainWarehouseEnca(warehousematerials);
                }
            }
        }else if(StringUtils.isNotBlank(oddNumber)){
            warehousematerials = wMService.selectByOddNumber(oddNumber);
            warehouseEncas = ObtainWarehouseEnca(warehousematerials);
            if(StringUtils.isNotBlank(category)){
                warehousematerials = wMService.selectByOddNumberAndCategory(oddNumber,category);
                warehouseEncas = ObtainWarehouseEnca(warehousematerials);
            }
        }else if(StringUtils.isNotBlank(category)){
            warehousematerials = wMService.seclectByCategory(category);
            warehouseEncas = ObtainWarehouseEnca(warehousematerials);
        }

        int totalRecord = warehouseEncas.size();
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<PurchaseEnca> pageMaterials = PageResult.ListSplit(warehouseEncas, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;

    }

    @CrossOrigin
    @ApiOperation(value = "查询入库单", notes = "查询入库单", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select(){
        List<Warehousematerial> warehousematerials = wMService.select();
        /**对list集合进行判空*/
        if(warehousematerials.isEmpty() ){
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(warehousematerials);
    }


    public List<WarehouseEnca> ObtainWarehouseEnca(List<Warehousematerial> wmaterials){

        List<WarehouseEnca> warehouseEncas =  new ArrayList<WarehouseEnca>();

        for(int w=0;w<wmaterials.size();w++){

            /**一定要在for循环里面创建对象，不然会出现后面数据覆盖前面数据的问题*/
            WarehouseEnca warehouseEnca = new WarehouseEnca();

            if(wmaterials.get(w).getId() != null){
                warehouseEnca.setId(wmaterials.get(w).getId());
            }
            if(wmaterials.get(w).getCreateTime() != null){
                warehouseEnca.setCreateTime(wmaterials.get(w).getCreateTime());
            }
            if(wmaterials.get(w).getWarehouseTime() != null){
                warehouseEnca.setWarehouseTime(new Date());
            }
            if(wmaterials.get(w).getAuditTime() != null){
                warehouseEnca.setAuditTime(new Date());
            }
            if(wmaterials.get(w).getCategory() != null){
                warehouseEnca.setCategory(wmaterials.get(w).getCategory());
            }
            if(wmaterials.get(w).getIntroduceNumber() != null){
                warehouseEnca.setIntroduceNumber(wmaterials.get(w).getIntroduceNumber());
            }
            if(wmaterials.get(w).getFactoryName() != null){
                warehouseEnca.setFactoryName(wmaterials.get(w).getFactoryName());
            }
            if(wmaterials.get(w).getSupplier() != null){
                warehouseEnca.setSupplier(wmaterials.get(w).getSupplier());
            }
            if(wmaterials.get(w).getCompany() != null){
                warehouseEnca.setCompany(wmaterials.get(w).getCompany());
            }
            if(wmaterials.get(w).getLogisticsNumber() != null){
                warehouseEnca.setLogisticsNumber(wmaterials.get(w).getLogisticsNumber());
            }
            if(wmaterials.get(w).getFreight() != null){
                warehouseEnca.setFreight(wmaterials.get(w).getFreight());
            }
            if(wmaterials.get(w).getExpenses() != null){
                warehouseEnca.setExpenses(wmaterials.get(w).getExpenses());
            }
            if(wmaterials.get(w).getWarehouseNumber() != null){
                warehouseEnca.setWarehouseNumber(wmaterials.get(w).getWarehouseNumber());
            }
            if(wmaterials.get(w).getWarehouseNumber1() != null){
                warehouseEnca.setWarehouseNumber1(wmaterials.get(w).getWarehouseNumber1());
            }
            if(wmaterials.get(w).getWarehouseNumber2() != null){
                warehouseEnca.setWarehouseNumber2(wmaterials.get(w).getWarehouseNumber2());
            }
            if(wmaterials.get(w).getWarehouseAmount() != null){
                warehouseEnca.setWarehouseAmount(wmaterials.get(w).getWarehouseAmount());
            }
            if(wmaterials.get(w).getWarehouseTaxamount() != null){
                warehouseEnca.setWarehouseTaxamount(wmaterials.get(w).getWarehouseTaxamount());
            }
            if(wmaterials.get(w).getMode() != null){
                warehouseEnca.setMode(wmaterials.get(w).getMode());
            }
            if(wmaterials.get(w).getFreightShare() != null){
                warehouseEnca.setFreightShare(wmaterials.get(w).getFreightShare());
            }
            if(wmaterials.get(w).getGoodQuality() != null){
                warehouseEnca.setGoodQuality(wmaterials.get(w).getGoodQuality());
            }
            if(wmaterials.get(w).getOddNumber() != null){
                warehouseEnca.setOddNumber(wmaterials.get(w).getOddNumber());
            }
            if(wmaterials.get(w).getWarehouseStatus() != null){
                warehouseEnca.setWarehouseStatus(wmaterials.get(w).getWarehouseStatus());
            }
            if(wmaterials.get(w).getAuditStatus() != null){
                warehouseEnca.setAuditStatus(wmaterials.get(w).getAuditStatus());
            }
            if(wmaterials.get(w).getSubmitStatus() != null){
                warehouseEnca.setSubmitStatus(wmaterials.get(w).getSubmitStatus());
            }
            if(wmaterials.get(w).getPersonCharge() != null){
                warehouseEnca.setPersonCharge(wmaterials.get(w).getPersonCharge());
            }
            if(wmaterials.get(w).getRemark() != null){
                warehouseEnca.setRemark(wmaterials.get(w).getRemark());
            }


            List<Warehousemdetail> warehousemdetails = wMDService.selectByOddNumber(wmaterials.get(w).getOddNumber());

            if(warehousemdetails != null){
                warehouseEnca.setGoodsList(warehousemdetails);
            }

            warehouseEncas.add(w,warehouseEnca);

        }
        return warehouseEncas;

    }



    public Warehousematerial ObtainWarehousematerial(WarehouseEnca warehouseEnca){

        Warehousematerial warehousematerial = new Warehousematerial();

        if(warehouseEnca.getId() != null){
            warehousematerial.setId(warehouseEnca.getId());
        }
        if(warehouseEnca.getCreateTime() != null){
            warehousematerial.setCreateTime(warehouseEnca.getCreateTime());
        }
        if(warehouseEnca.getUpdateTime() != null){
            warehousematerial.setUpdateTime(warehouseEnca.getUpdateTime());
        }
        if(warehouseEnca.getWarehouseTime() != null){
            warehousematerial.setWarehouseTime(warehouseEnca.getWarehouseTime());
        }
        if(warehouseEnca.getAuditTime() != null){
            warehousematerial.setAuditTime(warehouseEnca.getAuditTime());
        }
        if(warehouseEnca.getWarehouseStatus() != null){
            warehousematerial.setWarehouseStatus(warehouseEnca.getWarehouseStatus());
        }
        if(warehouseEnca.getSubmitStatus() != null){
            warehousematerial.setSubmitStatus(warehouseEnca.getSubmitStatus());
        }
        if(warehouseEnca.getAuditStatus() != null){
            warehousematerial.setAuditStatus(warehouseEnca.getAuditStatus());
        }
        if(warehouseEnca.getCategory() != null){
            warehousematerial.setCategory(warehouseEnca.getCategory());
        }
        if(warehouseEnca.getIntroduceNumber() != null){
            warehousematerial.setIntroduceNumber(warehouseEnca.getIntroduceNumber());
        }
        if(warehouseEnca.getFactoryName() != null){
            warehousematerial.setFactoryName(warehouseEnca.getFactoryName());
        }
        if(warehouseEnca.getSupplier() != null){
            warehousematerial.setSupplier(warehouseEnca.getSupplier());
        }
        if(warehouseEnca.getCompany() != null){
            warehousematerial.setCompany(warehouseEnca.getCompany());
        }
        if(warehouseEnca.getLogisticsNumber() != null){
            warehousematerial.setLogisticsNumber(warehouseEnca.getLogisticsNumber());
        }
        if(warehouseEnca.getFreight() != null){
            warehousematerial.setFreight(warehouseEnca.getFreight());
        }
        if(warehouseEnca.getExpenses() != null){
            warehousematerial.setExpenses(warehouseEnca.getExpenses());
        }
        if(warehouseEnca.getExpensesShare() != null){
            warehousematerial.setExpensesShare(warehouseEnca.getExpensesShare());
        }
        if(warehouseEnca.getExpensesMode() != null){
            warehousematerial.setExpensesMode(warehouseEnca.getExpensesMode());
        }
        if(warehouseEnca.getWarehouseNumber() != null){
            warehousematerial.setWarehouseNumber(warehouseEnca.getWarehouseNumber());
        }
        if(warehouseEnca.getWarehouseNumber1() != null){
            warehousematerial.setWarehouseNumber1(warehouseEnca.getWarehouseNumber1());
        }
        if(warehouseEnca.getWarehouseNumber2() != null){
            warehousematerial.setWarehouseNumber2(warehouseEnca.getWarehouseNumber2());
        }
        if(warehouseEnca.getWarehouseAmount() != null){
            warehousematerial.setWarehouseAmount(warehouseEnca.getWarehouseAmount());
        }
        if(warehouseEnca.getWarehouseTaxamount() != null){
            warehousematerial.setWarehouseTaxamount(warehouseEnca.getWarehouseTaxamount());
        }
        if(warehouseEnca.getGoodQuality() != null){
            warehousematerial.setGoodQuality(warehouseEnca.getGoodQuality());
        }
        if(warehouseEnca.getMode() != null){
            warehousematerial.setMode(warehouseEnca.getMode());
        }
        if(warehouseEnca.getFreightShare() != null){
            warehousematerial.setFreightShare(warehouseEnca.getFreightShare());
        }
        if(warehouseEnca.getOddNumber() != null){
            warehousematerial.setOddNumber(warehouseEnca.getOddNumber());
        }
        if(warehouseEnca.getPersonCharge() != null){
            warehousematerial.setPersonCharge(warehouseEnca.getPersonCharge());
        }
        if(warehouseEnca.getRemark() != null){
            warehousematerial.setRemark(warehouseEnca.getRemark());
        }
        return warehousematerial;

    }




}





