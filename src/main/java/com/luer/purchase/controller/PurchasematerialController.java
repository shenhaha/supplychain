package com.luer.purchase.controller;

import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.service.FactoryService;
import com.luer.basicsetup.service.SupplierService;
import com.luer.comm.utils.*;
import com.luer.purchase.bean.*;
import com.luer.purchase.service.PurchasematerialService;
import com.luer.purchase.service.PurchasemdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/purchase/material")
@Api(description = "原材料采购单接口")
public class PurchasematerialController {


    @Autowired
    PurchasematerialService materialService;
    @Autowired
    PurchasemdetailService mdetailService;
    @Autowired
    FactoryService factoryService;
    @Autowired
    SupplierService supplierService;


    @CrossOrigin
    @ApiOperation(value = "根据ids批量删除采购单信息", notes = "根据ids批量删除采购单信息", httpMethod = "POST")
    @ApiImplicitParam(name = "vo(ids)", value = "采购单信息id数组对象", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/delete")
    public ResultSet delete(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        /**删除采购单详细信息*/
        for(int k=0;k<list.size();k++){
            String purchaseNumber = materialService.selectPNumberById(list.get(k));
            mdetailService.deleteByPNumber(purchaseNumber);
        }
        /**批量删除采购单*/
        String[] arr = list.toArray(new String[list.size()]);
        materialService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }


    @CrossOrigin
    @ApiOperation(value = "修改采购单信息", notes = "修改采购单信息 传入一个Purchase对象", httpMethod = "POST")
    @ApiImplicitParam(name = "purchase", value = "Purchase对象", required = true, dataType = "Purchase")
    @ResponseBody
    @PostMapping(value = "/update")
    public ResultSet update(@RequestBody PurchaseMEnca purchaseMEnca) {

        /**获得Purchase对象*/
        Purchasematerial purchasematerial = ObtainPurchasematerial(purchaseMEnca);
        /**修改Purchase对象*/
        materialService.updateById(purchasematerial.getId(),purchasematerial);

        for(int m=0;m<purchaseMEnca.getGoodsList().size();m++){
            Purchasemdetail purchasemdetail = purchaseMEnca.getGoodsList().get(m);
            mdetailService.updateById(purchasemdetail.getId(),purchasemdetail);
        }

        /**获得修改后的数据*/
        List<PurchaseMEnca> purchaseMEnca1 = selectById(purchasematerial.getId());
        return ResultSet.getSuccess(purchaseMEnca1);


    }

    @CrossOrigin
    @ApiOperation(value = "根据id查询全部信息", notes = "根据id查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectById")
    public List<PurchaseMEnca> selectById(String id) {
        List<Purchasematerial> purchasematerials = materialService.selectById(id);
        /**获得PurchaseMEnca对象数据*/
        List<PurchaseMEnca> purchaseMEnca =  ObtainPurchaseMEnca(purchasematerials);
        return purchaseMEnca;
    }


    @CrossOrigin
    @ApiOperation(value = "采购单信息分页查询", notes = "采购单信息分页查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeTime", value = "时间类型", dataType = "String"),
            @ApiImplicitParam(name = "startTime", value = "开始查询时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束查询时间", dataType = "String"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", dataType = "String"),
            @ApiImplicitParam(name = "receiveStatus", value = "收货状态", dataType = "String"),
            @ApiImplicitParam(name = "purchaseNumber", value = "采购单号", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "int")
    })
    @GetMapping("/queryPage")
    public PageBean queryPage(@RequestParam(required = false) String typeTime,
                              @RequestParam(required = false) String startTime,
                              @RequestParam(required = false) String endTime,
                              @RequestParam(required = false) String auditStatus,
                              @RequestParam(required = false) String receiveStatus,
                              @RequestParam(required = false) String purchaseNumber,
                              @RequestParam(required = false, defaultValue = "1") int pageNum,
                              @RequestParam(required = false, defaultValue = "10") int pageSize, HttpServletResponse response) throws Exception {
        if (pageNum < 0 || pageSize < 0) {
            /**判断pageNum pageSize参数传值是否正确，不正确返回相应错误码*/
            ResponseUtil.response(response, ResponseUtil.PRAAMETER_ERROR);
        }
        List<Purchasematerial> purchasematerials = null;
        List<PurchaseMEnca> purchaseMEncas = null;

        if (StringUtils.isBlank(auditStatus) && StringUtils.isBlank(receiveStatus)
                && StringUtils.isBlank(purchaseNumber) && StringUtils.isBlank(typeTime)
                && StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            /**查询所有数据*/
            purchasematerials = materialService.select();
            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
        }

        if (StringUtils.isNotBlank(typeTime)) {
            /**判断时间类型为createTime*/
            if (typeTime.equals("createTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    /**根据createTime时间区间查询数据*/
                    purchasematerials = materialService.selectCreate(startTime, endTime);
                    purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        /**根据createTime时间区间和auditStatus查询数据*/
                        purchasematerials = materialService.selectCByAuditStatus(startTime, endTime, auditStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            /**根据createTime时间区间,auditStatus,receiveStatus查询数据*/
                            purchasematerials = materialService.selectCByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,auditStatus,purchaseNumber查询数据**/
                            purchasematerials = materialService.selectCByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,auditStatus,receiveStatus,purchaseNumber查询数据**/
                            purchasematerials = materialService.selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        /**根据createTime时间区间,receiveStatus查询数据**/
                        purchasematerials = materialService.selectCByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,receiveStatus,purchaseNumber查询数据**/
                            purchasematerials = materialService.selectCByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        /**根据createTime时间区间,purchaseNumber查询数据**/
                        purchasematerials = materialService.selectCByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    }
                }
            } else if (typeTime.equals("submitTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    purchasematerials = materialService.selectSubmit(startTime, endTime);
                    purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        purchasematerials = materialService.selectSByAuditStatus(startTime, endTime, auditStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            purchasematerials = materialService.selectSByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectSByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        purchasematerials = materialService.selectSByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectSByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        purchasematerials = materialService.selectSByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    }
                }
            } else if (typeTime.equals("auditTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    purchasematerials = materialService.selectAudit(startTime, endTime);
                    purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        purchasematerials = materialService.selectAByAuditStatus(startTime, endTime, auditStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            purchasematerials = materialService.selectAByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectAByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        purchasematerials = materialService.selectAByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchasematerials = materialService.selectAByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        purchasematerials = materialService.selectAByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
                    }
                }
            }
        } else if (StringUtils.isNotBlank(auditStatus)) {
            purchasematerials = materialService.selectByAuditStatus(auditStatus);
            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            if (StringUtils.isNotBlank(receiveStatus)) {
                purchasematerials = materialService.selectByAuditStatusAndReceiveStatus(auditStatus, receiveStatus);
                purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            } else if (StringUtils.isNotBlank(purchaseNumber)) {
                purchasematerials = materialService.selectByAuditStatusAndPurchaseNumber(auditStatus, purchaseNumber);
                purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            }
            if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                purchasematerials = materialService.selectByAuditStatusAndReceiveStatusAndPurchaseNumber(auditStatus, receiveStatus, purchaseNumber);
                purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            }
        } else if (StringUtils.isNotBlank(receiveStatus)) {
            purchasematerials = materialService.selectByReceiveStatus(receiveStatus);
            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            if (StringUtils.isNotBlank(purchaseNumber)) {
                purchasematerials = materialService.selectByReceiveStatusAndPurchaseNumber(receiveStatus, purchaseNumber);
               purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);
            }
        } else if (StringUtils.isNotBlank(purchaseNumber)) {
            purchasematerials = materialService.selectByPurchaseNumber(purchaseNumber);
            purchaseMEncas = ObtainPurchaseMEnca(purchasematerials);

        }
        /**判空*/
        if (purchaseMEncas.isEmpty()) {
            ResponseUtil.response(response, ResponseUtil.DATA_NULL);
        }

        int totalRecord = purchaseMEncas.size();
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<PurchaseEnca> pageMaterials = PageResult.ListSplit(purchaseMEncas, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;

    }


    @CrossOrigin
    @ApiOperation(value = "查询时间最大的那条记录", notes = "查询时间最大的那条记录", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectMaxCreateTime")
    public Purchasematerial selectMaxCreateTime() {
        Purchasematerial purchasematerial = materialService.selectMaxCreateTime();
        if(purchasematerial == null){
            return null;
        }
        return purchasematerial;
    }




    @CrossOrigin
    @ApiOperation(value = "保存采购单记录", notes = "保存采购单记录", httpMethod = "POST")
    @ApiImplicitParam(name = "purchaseEnca", value = "PurchaseEncae对象", required = true, dataType = "PurchaseEnca")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody PurchaseMEnca purchaseMEnca) {
        Purchasematerial purchasematerial = new Purchasematerial();
        Purchasemdetail purchasemdetail = new Purchasemdetail();

        if(selectMaxCreateTime() == null){
            purchasematerial.setPurchaseNumber(PNumberUtil.CreateDate()+"00001");
        }else if(selectMaxCreateTime().getPurchaseNumber() != null){
            /**采购单号 根据采购单号查询采购单相关商品详细信息*/
            purchasematerial.setPurchaseNumber(PNumberUtil.CreatePNumber(selectMaxCreateTime().getPurchaseNumber()));
        }

        /**设置采购单初始状态为未审核状态*/
        purchasematerial.setAuditStatus("sh02");
        /**设置采购单初始状态为未提交状态*/
        purchasematerial.setSubmitStatus("tj02");

        /**货品编码*/
        if (purchaseMEnca.getItemCode() != null) {
            purchasematerial.setItemCode(purchaseMEnca.getItemCode());
        }
        if (purchaseMEnca.getNumber() != null) {
            purchasematerial.setNumber(purchaseMEnca.getNumber());
        }
        if (purchaseMEnca.getSupplier() != null) {
            /**根据单位编码查询供应商名字保存到采购单*/
            purchasematerial.setSupplier(supplierService.selectUNameByUcode(purchaseMEnca.getSupplier()));
        }
        if (purchaseMEnca.getPurchaseSource() != null) {
            purchasematerial.setPurchaseSource(purchaseMEnca.getPurchaseSource());
        }
        if (purchaseMEnca.getReceiveStatus() != null) {
            purchasematerial.setReceiveStatus(purchaseMEnca.getReceiveStatus());
        }
        if (purchaseMEnca.getFrequency() != null) {
            purchasematerial.setFrequency(purchaseMEnca.getFrequency());
        }
        if (purchaseMEnca.getType() != null) {
            purchasematerial.setType(purchaseMEnca.getType());
        }
        if (purchaseMEnca.getCommodityType() != null) {
            purchasematerial.setCommodityType(purchaseMEnca.getCommodityType());
        }

        if (purchaseMEnca.getContractTerm() != null) {
            purchasematerial.setContractTerm(purchaseMEnca.getContractTerm());
        }
        if (purchaseMEnca.getSinglePerson() != null) {
            purchasematerial.setSinglePerson(purchaseMEnca.getSinglePerson());
        }
        if (purchaseMEnca.getSubmitter() != null) {
            purchasematerial.setSubmitter(purchaseMEnca.getSubmitter());
        }
        if (purchaseMEnca.getFinancialJudge() != null) {
            purchasematerial.setFinancialJudge(purchaseMEnca.getFinancialJudge());
        }
        if (purchaseMEnca.getAuditor() != null) {
            purchasematerial.setAuditor(purchaseMEnca.getAuditor());
        }

/********采购单 总金额 总数量 计算*/
        Integer totalQuantitys = 0;
        Double totalSums = 0.0000;
        Double taxTotalSums = 0.0000;

        for (int j = 0; j < purchaseMEnca.getGoodsList().size(); j++) {
            if (purchaseMEnca.getGoodsList().get(j).getNumber() != null
                    && purchaseMEnca.getGoodsList().get(j).getUnitPrice() != null
                    && purchaseMEnca.getGoodsList().get(j).getTaxPrice() != null) {
                /**总数量*/
                totalQuantitys += purchaseMEnca.getGoodsList().get(j).getNumber();
                /**不含税总金额*/
                totalSums += (purchaseMEnca.getGoodsList().get(j).getNumber())* (purchaseMEnca.getGoodsList().get(j).getUnitPrice());
                /**含税总金额*/
                taxTotalSums += (purchaseMEnca.getGoodsList().get(j).getNumber()) * (purchaseMEnca.getGoodsList().get(j).getTaxPrice());
            }
        }

        if(totalQuantitys != null){
            purchasematerial.setTotalQuantity(totalQuantitys);
        }
        if(totalSums != null){
            purchasematerial.setTotalSum(totalSums);
        }
        if(taxTotalSums != null){
            purchasematerial.setTaxTotalSum(taxTotalSums);
        }

/************************/

        if (purchaseMEnca.getCompleteStatus() != null) {
            purchasematerial.setCompleteStatus(purchaseMEnca.getCompleteStatus());
        }
        if (purchaseMEnca.getInvoiceAmount() != null) {
            purchasematerial.setInvoiceAmount(purchaseMEnca.getInvoiceAmount());
        }
        if (purchaseMEnca.getNonInvoice() != null) {
            purchasematerial.setNonInvoice(purchaseMEnca.getNonInvoice());
        }
        if (purchaseMEnca.getTaxAmount() != null) {
            purchasematerial.setTaxAmount(purchaseMEnca.getTaxAmount());
        }
        if (purchaseMEnca.getTaxRate() != null) {
            purchasematerial.setTaxRate(purchaseMEnca.getTaxRate());
        }
        if (purchaseMEnca.getUnit() != null) {
            purchasematerial.setUnit(purchaseMEnca.getUnit());
        }
        if (purchaseMEnca.getContacts() != null) {
            purchasematerial.setContacts(purchaseMEnca.getContacts());
        }
        if (purchaseMEnca.getInvoice() != null) {
            purchasematerial.setInvoice(purchaseMEnca.getInvoice());
        }
        if (purchaseMEnca.getFactoryName() != null) {
            purchasematerial.setFactoryName(purchaseMEnca.getFactoryName());
            /**根据工厂名查询相应收货地址 保存到采购单*/
            purchasematerial.setReceiveAddress(factoryService.selectAddressByCode(purchaseMEnca.getFactoryName())+factoryService.selectDAddressByCode(purchaseMEnca.getFactoryName()));
        }


        if (purchaseMEnca.getFreight() != null) {
            purchasematerial.setFreight(purchaseMEnca.getFreight());
        }
        if (purchaseMEnca.getFreightTransportation() != null) {
            purchasematerial.setFreightTransportation(purchaseMEnca.getFreightTransportation());
        }
        if (purchaseMEnca.getRemark() != null) {
            purchasematerial.setRemark(purchaseMEnca.getRemark());
        }
        /**保存对象数据*/
        materialService.insert(purchasematerial);

        for (int i = 0; i < purchaseMEnca.getGoodsList().size(); i++) {

            purchasemdetail.setId(UUIDUtils.getUUID());

            purchasemdetail.setCreateTime(new Date());

            purchasemdetail.setPurchaseNumber(purchasematerial.getPurchaseNumber());

            if (purchaseMEnca.getGoodsList().get(i).getId() != null) {
                purchasemdetail.setMaterialId(purchaseMEnca.getGoodsList().get(i).getId());
            }
            if (purchaseMEnca.getGoodsList().get(i).getMaterialCode() != null) {
                purchasemdetail.setMaterialCode(purchaseMEnca.getGoodsList().get(i).getMaterialCode());
            }
            if (purchaseMEnca.getGoodsList().get(i).getName() != null) {
                purchasemdetail.setName(purchaseMEnca.getGoodsList().get(i).getName());
            }

            if (purchaseMEnca.getGoodsList().get(i).getType() != null) {
                purchasemdetail.setType(purchaseMEnca.getGoodsList().get(i).getType());
            }
            if(purchaseMEnca.getGoodsList().get(i).getBrand() != null){
                purchasemdetail.setBrand(purchaseMEnca.getGoodsList().get(i).getBrand());
            }
            if (purchaseMEnca.getGoodsList().get(i).getUnit() != null) {
                purchasemdetail.setUnit(purchaseMEnca.getGoodsList().get(i).getUnit());
            }
            if(purchaseMEnca.getGoodsList().get(i).getDefaultLoss() != null){
                purchasemdetail.setDefaultLoss(purchaseMEnca.getGoodsList().get(i).getDefaultLoss());
            }
            if(purchaseMEnca.getGoodsList().get(i).getManufacturer() != null){
                purchasemdetail.setManufacturer(purchaseMEnca.getGoodsList().get(i).getManufacturer());
            }
            if (purchaseMEnca.getGoodsList().get(i).getCostPrice() != null) {
                purchasemdetail.setCostPrice(purchaseMEnca.getGoodsList().get(i).getCostPrice());
            }
            if (purchaseMEnca.getGoodsList().get(i).getIngredients() != null) {
                purchasemdetail.setIngredients(purchaseMEnca.getGoodsList().get(i).getIngredients());
            }
            if (purchaseMEnca.getGoodsList().get(i).getNumber() != null) {
                purchasemdetail.setNumber(purchaseMEnca.getGoodsList().get(i).getNumber());
            }
            if (purchaseMEnca.getGoodsList().get(i).getDataState() != null) {
                purchasemdetail.setDataState(purchaseMEnca.getGoodsList().get(i).getDataState());
            }
            if (purchaseMEnca.getGoodsList().get(i).getWarehouseTime() != null) {
                    purchasemdetail.setWarehouseTime(purchaseMEnca.getGoodsList().get(i).getWarehouseTime());
            }
            if (purchaseMEnca.getGoodsList().get(i).getUnitPrice() != null) {
                purchasemdetail.setUnitPrice(purchaseMEnca.getGoodsList().get(i).getUnitPrice());
            }
            if (purchaseMEnca.getGoodsList().get(i).getTaxPrice() != null) {
                purchasemdetail.setTaxPrice(purchaseMEnca.getGoodsList().get(i).getTaxPrice());
            }

            /**计算不含税总价和含税总价*/

            /**不含税总价*/
            if(purchaseMEnca.getGoodsList().get(i).getNumber() != null
                    && purchaseMEnca.getGoodsList().get(i).getUnitPrice() != null){
                purchasemdetail.setTotalPrice((purchaseMEnca.getGoodsList().get(i).getNumber()) * (purchaseMEnca.getGoodsList().get(i).getUnitPrice()));
            }
            /**含税总价*/
            if(purchaseMEnca.getGoodsList().get(i).getNumber() != null
                    && purchaseMEnca.getGoodsList().get(i).getTaxPrice() != null){
                purchasemdetail.setTaxTotalPrice((purchaseMEnca.getGoodsList().get(i).getNumber()) * (purchaseMEnca.getGoodsList().get(i).getTaxPrice()));
            }

            /***/

            /*********************入库单相关信息*/
            if(purchaseMEnca.getGoodsList().get(i).getWarehousePrice() != null){
                purchasemdetail.setWarehousePrice(purchaseMEnca.getGoodsList().get(i).getWarehousePrice());
            }

            if(purchaseMEnca.getGoodsList().get(i).getWarehouseTaxprice() != null){
                purchasemdetail.setWarehouseTaxprice(purchaseMEnca.getGoodsList().get(i).getWarehouseTaxprice());
            }

            if(purchaseMEnca.getGoodsList().get(i).getWarehouseAmount() != null){
                purchasemdetail.setWarehouseAmount(purchaseMEnca.getGoodsList().get(i).getWarehouseAmount());
            }

            if(purchaseMEnca.getGoodsList().get(i).getWarehouseTaxamount() != null){
                purchasemdetail.setWarehouseTaxamount(purchaseMEnca.getGoodsList().get(i).getWarehouseTaxamount());
            }
            if(purchaseMEnca.getGoodsList().get(i).getFreightShare() != null){
                purchasemdetail.setFreightShare(purchaseMEnca.getGoodsList().get(i).getFreightShare());
            }
            if(purchaseMEnca.getGoodsList().get(i).getExpenses() != null){
                purchasemdetail.setExpenses(purchaseMEnca.getGoodsList().get(i).getExpenses());
            }
            if(purchaseMEnca.getGoodsList().get(i).getBatch() != null){
                purchasemdetail.setBatch(purchaseMEnca.getGoodsList().get(i).getBatch());
            }
/*******************/

            if (purchaseMEnca.getGoodsList().get(i).getRemark() != null) {
                purchasemdetail.setRemark(purchaseMEnca.getGoodsList().get(i).getRemark());
            }

            mdetailService.insert(purchasemdetail);

        }

        return ResultSet.getSuccess(purchaseMEnca);

    }



    /**封装PurchaseMEnca数据*/
    public List<PurchaseMEnca> ObtainPurchaseMEnca(List<Purchasematerial> purchasematerials){

        List<PurchaseMEnca> purchaseMEncas =  new ArrayList<PurchaseMEnca>();

        for(int pe=0;pe<purchasematerials.size();pe++){

            /**一定要在for循环里面创建对象，不然会出现后面数据覆盖前面数据的问题*/
            PurchaseMEnca purchaseMEnca = new PurchaseMEnca();

            if(purchasematerials.get(pe).getId() != null){
                purchaseMEnca.setId(purchasematerials.get(pe).getId());
            }
            if(purchasematerials.get(pe).getCreateTime() != null){
                purchaseMEnca.setCreateTime(purchasematerials.get(pe).getCreateTime());
            }
            if(purchasematerials.get(pe).getPurchaseTime() != null){
                purchaseMEnca.setUpdateTime(purchasematerials.get(pe).getPurchaseTime());
            }
            if(purchasematerials.get(pe).getFinancialTime() != null){
                purchaseMEnca.setFinancialTime(purchasematerials.get(pe).getFinancialTime());
            }
            if(purchasematerials.get(pe).getSubmitTime() != null){
                purchaseMEnca.setSubmitTime(purchasematerials.get(pe).getSubmitTime());
            }
            if(purchasematerials.get(pe).getAuditTime() != null){
                purchaseMEnca.setAuditTime(purchasematerials.get(pe).getAuditTime());
            }
            if(purchasematerials.get(pe).getCloseTime() != null){
                purchaseMEnca.setCloseTime(purchasematerials.get(pe).getCloseTime());
            }
            if(purchasematerials.get(pe).getItemCode() != null){
                purchaseMEnca.setItemCode(purchasematerials.get(pe).getItemCode());
            }
            if(purchasematerials.get(pe).getNumber() != null){
                purchaseMEnca.setNumber(purchasematerials.get(pe).getNumber());
            }
            if(purchasematerials.get(pe).getSupplier() != null){
                purchaseMEnca.setSupplier(purchasematerials.get(pe).getSupplier());
            }
            if(purchasematerials.get(pe).getPurchaseNumber() != null){
                purchaseMEnca.setPurchaseNumber(purchasematerials.get(pe).getPurchaseNumber());
            }
            if(purchasematerials.get(pe).getPurchaseSource() != null){
                purchaseMEnca.setPurchaseSource(purchasematerials.get(pe).getPurchaseSource());
            }
            if(purchasematerials.get(pe).getAuditStatus() != null){
                purchaseMEnca.setAuditStatus(purchasematerials.get(pe).getAuditStatus());
            }
            if(purchasematerials.get(pe).getSubmitStatus() != null){
                purchaseMEnca.setSubmitStatus(purchasematerials.get(pe).getSubmitStatus());
            }
            if(purchasematerials.get(pe).getReceiveStatus() != null){
                purchaseMEnca.setReceiveStatus(purchasematerials.get(pe).getReceiveStatus());
            }
            if(purchasematerials.get(pe).getFrequency() != null){
                purchaseMEnca.setFrequency(purchasematerials.get(pe).getFrequency());
            }
            if(purchasematerials.get(pe).getType() != null){
                purchaseMEnca.setType(purchasematerials.get(pe).getType());
            }
            if(purchasematerials.get(pe).getCommodityType() != null){
                purchaseMEnca.setCommodityType(purchasematerials.get(pe).getCommodityType());
            }
            if(purchasematerials.get(pe).getReceiveAddress() != null){
                purchaseMEnca.setReceiveAddress(purchasematerials.get(pe).getReceiveAddress());
            }
            if(purchasematerials.get(pe).getSinglePerson() != null){
                purchaseMEnca.setSinglePerson(purchasematerials.get(pe).getSinglePerson());
            }
            if(purchasematerials.get(pe).getSubmitter() != null){
                purchaseMEnca.setSubmitter(purchasematerials.get(pe).getSubmitter());
            }
            if(purchasematerials.get(pe).getContractTerm() != null){
                purchaseMEnca.setContractTerm(purchasematerials.get(pe).getContractTerm());
            }
            if(purchasematerials.get(pe).getFinancialJudge() != null){
                purchaseMEnca.setFinancialJudge(purchasematerials.get(pe).getFinancialJudge());
            }
            if(purchasematerials.get(pe).getAuditor() != null){
                purchaseMEnca.setAuditor(purchasematerials.get(pe).getAuditor());
            }
            if(purchasematerials.get(pe).getTotalSum() != null){
                purchaseMEnca.setTotalSum(purchasematerials.get(pe).getTotalSum());
            }
            if(purchasematerials.get(pe).getTaxTotalSum() != null){
                purchaseMEnca.setTaxTotalSum(purchasematerials.get(pe).getTaxTotalSum());
            }
            if(purchasematerials.get(pe).getTotalQuantity() != null){
                purchaseMEnca.setTotalQuantity(purchasematerials.get(pe).getTotalQuantity());
            }
            if(purchasematerials.get(pe).getCompleteStatus() != null){
                purchaseMEnca.setCompleteStatus(purchasematerials.get(pe).getCompleteStatus());
            }
            if(purchasematerials.get(pe).getInvoiceAmount() != null){
                purchaseMEnca.setInvoiceAmount(purchasematerials.get(pe).getInvoiceAmount());
            }
            if(purchasematerials.get(pe).getNonInvoice() != null){
                purchaseMEnca.setNonInvoice(purchasematerials.get(pe).getNonInvoice());
            }
            if(purchasematerials.get(pe).getTaxAmount() != null){
                purchaseMEnca.setTaxAmount(purchasematerials.get(pe).getTaxAmount());
            }
            if(purchasematerials.get(pe).getTaxRate() != null){
                purchaseMEnca.setTaxRate(purchasematerials.get(pe).getTaxRate());
            }
            if(purchasematerials.get(pe).getUnit() != null){
                purchaseMEnca.setContacts(purchasematerials.get(pe).getContacts());
            }

            if(purchasematerials.get(pe).getInvoice() != null){
                purchaseMEnca.setInvoice(purchasematerials.get(pe).getInvoice());
            }
            if(purchasematerials.get(pe).getFreight() != null){
                purchaseMEnca.setFreight(purchasematerials.get(pe).getFreight());
            }


            if(purchasematerials.get(pe).getFreightTransportation() != null){
                purchaseMEnca.setFreightTransportation(purchasematerials.get(pe).getFreightTransportation());
            }
            if(purchasematerials.get(pe).getRemark() != null){
                purchaseMEnca.setRemark(purchasematerials.get(pe).getRemark());
            }
            if(purchasematerials.get(pe).getFactoryName() != null){
                purchaseMEnca.setFactoryName(purchasematerials.get(pe).getFactoryName());
            }

            List<Purchasemdetail> purchasemdetails = mdetailService.selectByPurchaseNumber(purchasematerials.get(pe).getPurchaseNumber());
            if(purchasemdetails != null){
                purchaseMEnca.setGoodsList(purchasemdetails);
            }

            purchaseMEncas.add(pe,purchaseMEnca);

        }
        return purchaseMEncas;
    }


    /**封装Purchasematerial 对象*/
    public Purchasematerial ObtainPurchasematerial(PurchaseMEnca purchaseMEnca){

        Purchasematerial purchasematerial = new Purchasematerial();
        if(purchaseMEnca.getId() != null){
            purchasematerial.setId(purchaseMEnca.getId());
        }
        if(purchaseMEnca.getCreateTime() != null){
            purchasematerial.setCreateTime(purchaseMEnca.getCreateTime());
        }
        if(purchaseMEnca.getUpdateTime() != null){
            purchasematerial.setUpdateTime(purchaseMEnca.getUpdateTime());
        }
        if(purchaseMEnca.getPurchaseTime() != null){
            purchasematerial.setPurchaseTime(purchaseMEnca.getPurchaseTime());
        }
        if(purchaseMEnca.getFinancialTime() != null){
            purchasematerial.setFinancialTime(purchaseMEnca.getFinancialTime());
        }
        if(purchaseMEnca.getSubmitTime() != null){
            purchasematerial.setSubmitTime(purchaseMEnca.getSubmitTime());
        }
        if(purchaseMEnca.getAuditTime() != null){
            purchasematerial.setAuditTime(purchaseMEnca.getAuditTime());
        }
        if(purchaseMEnca.getCloseTime() != null){
            purchasematerial.setCloseTime(purchaseMEnca.getCloseTime());
        }
        if(purchaseMEnca.getItemCode() != null){
            purchasematerial.setItemCode(purchaseMEnca.getItemCode());
        }
        if(purchaseMEnca.getNumber() != null){
            purchasematerial.setNumber(purchaseMEnca.getNumber());
        }
        if(purchaseMEnca.getSupplier() != null){
            purchasematerial.setSupplier(purchaseMEnca.getSupplier());
        }
        if(purchaseMEnca.getPurchaseNumber() != null){
            purchasematerial.setPurchaseNumber(purchaseMEnca.getPurchaseNumber());
        }
        if(purchaseMEnca.getPurchaseSource() != null){
            purchasematerial.setPurchaseSource(purchaseMEnca.getPurchaseSource());
        }
        if(purchaseMEnca.getAuditStatus() != null){
            purchasematerial.setAuditStatus(purchaseMEnca.getAuditStatus());
        }
        if(purchaseMEnca.getSubmitStatus() != null){
            purchasematerial.setSubmitStatus(purchaseMEnca.getSubmitStatus());
        }
        if(purchaseMEnca.getReceiveStatus() != null){
            purchasematerial.setReceiveStatus(purchaseMEnca.getReceiveStatus());
        }
        if(purchaseMEnca.getFrequency() != null){
            purchasematerial.setFrequency(purchaseMEnca.getFrequency());
        }
        if(purchaseMEnca.getType() != null){
            purchasematerial.setType(purchaseMEnca.getType());
        }
        if(purchaseMEnca.getCommodityType() != null){
            purchasematerial.setCommodityType(purchaseMEnca.getCommodityType());
        }
        if(purchaseMEnca.getReceiveAddress() != null){
            purchasematerial.setReceiveAddress(purchaseMEnca.getReceiveAddress());
        }
        if(purchaseMEnca.getSinglePerson() != null){
            purchasematerial.setSinglePerson(purchaseMEnca.getSinglePerson());
        }
        if(purchaseMEnca.getSubmitter() != null){
            purchasematerial.setSubmitter(purchaseMEnca.getSubmitter());
        }
        if(purchaseMEnca.getContractTerm() != null){
            purchasematerial.setContractTerm(purchaseMEnca.getContractTerm());
        }
        if(purchaseMEnca.getFinancialJudge() != null){
            purchasematerial.setFinancialJudge(purchaseMEnca.getFinancialJudge());
        }
        if(purchaseMEnca.getAuditor() != null){
            purchasematerial.setAuditor(purchaseMEnca.getAuditor());
        }
        if(String.valueOf(purchaseMEnca.getTotalSum()) != null){
            purchasematerial.setTotalSum(purchaseMEnca.getTotalSum());
        }
        if(String.valueOf(purchaseMEnca.getTaxTotalSum()) != null){
            purchasematerial.setTaxTotalSum(purchaseMEnca.getTaxTotalSum());
        }
        if(purchaseMEnca.getTotalQuantity() != null){
            purchasematerial.setTotalQuantity(purchaseMEnca.getTotalQuantity());
        }
        if(purchaseMEnca.getCompleteStatus() != null){
            purchasematerial.setCompleteStatus(purchaseMEnca.getCompleteStatus());
        }
        if(purchaseMEnca.getInvoiceAmount() != null){
            purchasematerial.setInvoiceAmount(purchaseMEnca.getInvoiceAmount());
        }
        if(purchaseMEnca.getNonInvoice() != null){
            purchasematerial.setNonInvoice(purchaseMEnca.getNonInvoice());
        }
        if(purchaseMEnca.getTaxAmount() != null){
            purchasematerial.setTaxAmount(purchaseMEnca.getTaxAmount());
        }
        if(purchaseMEnca.getTaxRate() != null){
            purchasematerial.setTaxRate(purchaseMEnca.getTaxRate());
        }
        if(purchaseMEnca.getUnit() != null){
            purchasematerial.setUnit(purchaseMEnca.getUnit());
        }
        if(purchaseMEnca.getContacts() != null){
            purchasematerial.setContacts(purchaseMEnca.getContacts());
        }
        if(purchaseMEnca.getInvoice() != null){
            purchasematerial.setInvoice(purchaseMEnca.getInvoice());
        }
        if(purchaseMEnca.getFreight() != null){
            purchasematerial.setFreight(purchaseMEnca.getFreight());
        }
        if(purchaseMEnca.getFreightTransportation() != null){
            purchasematerial.setFreightTransportation(purchaseMEnca.getFreightTransportation());
        }
        if(purchaseMEnca.getRemark() != null){
            purchasematerial.setRemark(purchaseMEnca.getRemark());
        }
        if(purchaseMEnca.getFactoryName() != null){
            purchasematerial.setFactoryName(purchaseMEnca.getFactoryName());
        }

        return purchasematerial;

    }





}



/**
 {
 "id": "52eb5b5b91fe4532a345c4487184331a",
 "createTime": "2019-03-21 10:52:04",
 "updateTime": null,
 "purchaseTime": null,
 "financialTime": null,
 "submitTime": null,
 "auditTime": null,
 "closeTime": null,
 "itemCode": null,
 "number": null,
 "supplier": "03",
 "purchaseNumber": "CGD2019032100001",
 "purchaseSource": null,
 "auditStatus": "sh02",
 "submitStatus": "tj02",
 "receiveStatus": null,
 "frequency": null,
 "type": null,
 "commodityType": null,
 "receiveAddress": null,
 "contractTerm": null,
 "singlePerson": null,
 "submitter": null,
 "financialJudge": null,
 "auditor": null,
 "totalSum": 19.14,
 "taxTotalSum": 22,
 "totalQuantity": 7,
 "completeStatus": null,
 "invoiceAmount": null,
 "nonInvoice": null,
 "taxAmount": null,
 "taxRate": null,
 "unit": null,
 "contacts": null,
 "invoice": "增值税普通发票",
 "freight": 99,
 "freightTransportation": "99",
 "factoryName": "6666",
 "remark": "99",
 "goodsList": [
 {
 "id": "1425d319199340869c3667fb1045f0ef",
 "materialId": null,
 "createTime": "2019-02-21 15:35:49",
 "updateTime": "2019-02-28 09:20:55",
 "warehouseTime": null,
 "name": "yyy",
 "materialCode": "1786",
 "type": "包装",
 "brand": null,
 "unit": "unit",
 "defaultLoss": "2",
 "manufacturer": "01",
 "costPrice": 1,
 "ingredients": "ingredients",
 "number": 1,
 "unitPrice": null,
 "taxPrice": null,
 "totalPrice": null,
 "taxTotalPrice": null,
 "purchaseNumber": "CGD2019032100001",
 "spare": "01",
 "dataState": "001",
 "spare02": null,
 "spare03": null,
 "spare04": null,




 以何眼观世界 观到何种世界

 为什么孩子可以无知而快乐的生活 因为他们拥有为其承担烦恼的人

                                            -----------复旦陈果










  */