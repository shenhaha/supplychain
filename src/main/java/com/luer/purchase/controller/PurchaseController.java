package com.luer.purchase.controller;

import com.luer.basicsetup.bean.ExampleVo;
import com.luer.basicsetup.service.FactoryService;
import com.luer.basicsetup.service.SupplierService;
import com.luer.comm.utils.*;
import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.PurchaseEnca;
import com.luer.purchase.bean.Purchasedetail;
import com.luer.purchase.service.PurchaseService;
import com.luer.purchase.service.PurchasedetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/purchase/goods")
@Api(description = "商品采购单接口")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    PurchasedetailService detailService;
    @Autowired
    FactoryService factoryService;
    @Autowired
    SupplierService supplierService;

    @CrossOrigin
    @ApiOperation(value = "根据id查询采购单号", notes = "根据id查询采购单号", httpMethod = "POST")
    @ResponseBody
    @PostMapping("/selectPNumberById")
    public String  selectPNumberById(String id) {
        return purchaseService.selectPNumberById(id);
    }

    @CrossOrigin
    @ApiOperation(value = "根据采购单号删除采购单详细信息", notes = "根据采购单号删除采购单详细信息", httpMethod = "POST")
    @ResponseBody
    @PostMapping("/deleteByPNumber")
    public int  deleteByPNumber(String phoneNumber) {
        return detailService.deleteByPNumber(phoneNumber);
    }

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
            String purchaseNumber = purchaseService.selectPNumberById(list.get(k));
            detailService.deleteByPNumber(purchaseNumber);
        }
        /**批量删除采购单*/
        String[] arr = list.toArray(new String[list.size()]);
        purchaseService.deleteByIds(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    @ApiOperation(value = "修改采购单信息", notes = "修改采购单信息 传入一个Purchase对象", httpMethod = "POST")
    @ApiImplicitParam(name = "purchase", value = "Purchase对象", required = true, dataType = "Purchase")
    @ResponseBody
    @PostMapping(value = "/update")
    public ResultSet update(@RequestBody PurchaseEnca purchaseEnca) {

        /**获得Purchase对象*/
        Purchase purchase = ObtainPurchase(purchaseEnca);
        /**修改Purchase对象*/
        purchaseService.updateById(purchase.getId(),purchase);

        for(int m=0;m<purchaseEnca.getGoodsList().size();m++){
            Purchasedetail purchasedetail = purchaseEnca.getGoodsList().get(m);
            detailService.updateById(purchasedetail.getId(),purchasedetail);
        }

        /**获得修改后的数据*/
        List<PurchaseEnca> purchaseEnca1 = selectById(purchase.getId());
        return ResultSet.getSuccess(purchaseEnca1);

    }

    @CrossOrigin
    @ApiOperation(value = "根据id查询全部信息", notes = "根据id查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectById")
    public List<PurchaseEnca> selectById(String id) {
        List<Purchase> purchase = purchaseService.selectById(id);
        /**获得PurchaseEnca对象数据*/
        List<PurchaseEnca> purchaseEnca =  ObtainPurchaseEnca(purchase);
        return purchaseEnca;
    }

    @CrossOrigin
    @ApiOperation(value = "查询时间最大的那条记录", notes = "查询时间最大的那条记录", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/selectMaxCreateTime")
    public Purchase selectMaxCreateTime() {
        Purchase purchase = purchaseService.selectMaxCreateTime();
        if(purchase == null){
            return null;
        }
        return purchase;
    }

    @CrossOrigin
    //@ApiOperation(value = "查询全部信息", notes = "查询全部信息", httpMethod = "GET")
    @ResponseBody
    @GetMapping("/select")
    public ResultSet select() {
        List<Purchase> purchases = purchaseService.select();
        /**对list集合进行判空*/
        if (purchases.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(purchases);
    }


    @CrossOrigin
    @ApiOperation(value = "修改采购单为已审核状态", notes = "sh01已审核状态 sh02未审核状态", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "采购单id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateAudit")
    public ResultSet updateAudit(@RequestBody ExampleVo vo) {
        /**sh01已审核状态 sh02未审核状态*/
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        purchaseService.updateAudit(arr);
        return ResultSet.getSuccess(arr);
    }

    @CrossOrigin
    //@ApiOperation(value = "修改采购单为未审核状态", notes = "sh01已审核状态 sh02未审核状态", httpMethod = "POST")
    @ApiImplicitParam(name = "vo", value = "采购单id集合对象 ", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/updateUnaudit")
    public ResultSet updateUnaudit(@RequestBody ExampleVo vo) {
        List<String> list = vo.getIds();
        if (list.isEmpty()) {
            return ResultSet.getFail();
        }
        String[] arr = list.toArray(new String[list.size()]);
        purchaseService.updateUnaudit(arr);
        return ResultSet.getSuccess(arr);
    }




    @CrossOrigin
    @ApiOperation(value = "查询时间区间数据", notes = "查询时间区间数据", httpMethod = "POST")
    @ResponseBody
    @PostMapping("/selectCreate")
    public ResultSet selectCreate(String startTime, String endTime) {
        List<Purchase> purchases = purchaseService.selectCreate(startTime, endTime);
        /**对list集合进行判空*/
        if (purchases.isEmpty()) {
            //为空
            return ResultSet.getFail();
        }
        return ResultSet.getSuccess(purchases);
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
                              @RequestParam(required = false, defaultValue = "10") int pageSize)  {

        List<Purchase> purchases = null;
        List<PurchaseEnca> purchaseEncas = null;

        if (StringUtils.isBlank(auditStatus) && StringUtils.isBlank(receiveStatus)
                && StringUtils.isBlank(purchaseNumber) && StringUtils.isBlank(typeTime)
                && StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            /**查询所有数据*/
            purchases = purchaseService.select();
            purchaseEncas = ObtainPurchaseEnca(purchases);
        }

        if (StringUtils.isNotBlank(typeTime)) {
            /**判断时间类型为createTime*/
            if (typeTime.equals("createTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    /**根据createTime时间区间查询数据*/
                    purchases = purchaseService.selectCreate(startTime, endTime);
                    purchaseEncas = ObtainPurchaseEnca(purchases);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        /**根据createTime时间区间和auditStatus查询数据*/
                        purchases = purchaseService.selectCByAuditStatus(startTime, endTime, auditStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            /**根据createTime时间区间,auditStatus,receiveStatus查询数据*/
                            purchases = purchaseService.selectCByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,auditStatus,purchaseNumber查询数据**/
                            purchases = purchaseService.selectCByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,auditStatus,receiveStatus,purchaseNumber查询数据**/
                            purchases = purchaseService.selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        /**根据createTime时间区间,receiveStatus查询数据**/
                        purchases = purchaseService.selectCByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            /**根据createTime时间区间,receiveStatus,purchaseNumber查询数据**/
                            purchases = purchaseService.selectCByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        /**根据createTime时间区间,purchaseNumber查询数据**/
                        purchases = purchaseService.selectCByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                    }
                }
            } else if (typeTime.equals("submitTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    purchases = purchaseService.selectSubmit(startTime, endTime);
                    purchaseEncas = ObtainPurchaseEnca(purchases);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        purchases = purchaseService.selectSByAuditStatus(startTime, endTime, auditStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            purchases = purchaseService.selectSByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectSByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        purchases = purchaseService.selectSByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectSByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        purchases = purchaseService.selectSByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                    }
                }
            } else if (typeTime.equals("auditTime")) {
                if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                    purchases = purchaseService.selectAudit(startTime, endTime);
                    purchaseEncas = ObtainPurchaseEnca(purchases);
                    if (StringUtils.isNotBlank(auditStatus)) {
                        purchases = purchaseService.selectAByAuditStatus(startTime, endTime, auditStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(receiveStatus)) {
                            purchases = purchaseService.selectAByAuditStatusAndReceiveStatus(startTime, endTime, auditStatus, receiveStatus);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        } else if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectAByAuditStatusAndPurchaseNumber(startTime, endTime, auditStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                        if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, endTime, auditStatus, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(receiveStatus)) {
                        purchases = purchaseService.selectAByReceiveStatus(startTime, endTime, receiveStatus);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                        if (StringUtils.isNotBlank(purchaseNumber)) {
                            purchases = purchaseService.selectAByReceiveStatusAndPurchaseNumber(startTime, endTime, receiveStatus, purchaseNumber);
                            purchaseEncas = ObtainPurchaseEnca(purchases);
                        }
                    } else if (StringUtils.isNotBlank(purchaseNumber)) {
                        purchases = purchaseService.selectAByPurchaseNumber(startTime, endTime, purchaseNumber);
                        purchaseEncas = ObtainPurchaseEnca(purchases);
                    }
                }
            }
        } else if (StringUtils.isNotBlank(auditStatus)) {
            purchases = purchaseService.selectByAuditStatus(auditStatus);
            purchaseEncas = ObtainPurchaseEnca(purchases);
            if (StringUtils.isNotBlank(receiveStatus)) {
                purchases = purchaseService.selectByAuditStatusAndReceiveStatus(auditStatus, receiveStatus);
                purchaseEncas = ObtainPurchaseEnca(purchases);
            } else if (StringUtils.isNotBlank(purchaseNumber)) {
                purchases = purchaseService.selectByAuditStatusAndPurchaseNumber(auditStatus, purchaseNumber);
                purchaseEncas = ObtainPurchaseEnca(purchases);
            }
            if (StringUtils.isNotBlank(auditStatus) && StringUtils.isNotBlank(receiveStatus) && StringUtils.isNotBlank(purchaseNumber)) {
                purchases = purchaseService.selectByAuditStatusAndReceiveStatusAndPurchaseNumber(auditStatus, receiveStatus, purchaseNumber);
                purchaseEncas = ObtainPurchaseEnca(purchases);
            }
        } else if (StringUtils.isNotBlank(receiveStatus)) {
            purchases = purchaseService.selectByReceiveStatus(receiveStatus);
            purchaseEncas = ObtainPurchaseEnca(purchases);
            if (StringUtils.isNotBlank(purchaseNumber)) {
                purchases = purchaseService.selectByReceiveStatusAndPurchaseNumber(receiveStatus, purchaseNumber);
                purchaseEncas = ObtainPurchaseEnca(purchases);
            }
        } else if (StringUtils.isNotBlank(purchaseNumber)) {
            purchases = purchaseService.selectByPurchaseNumber(purchaseNumber);
            purchaseEncas = ObtainPurchaseEnca(purchases);

        }

        int totalRecord = purchaseEncas.size();
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);
        /**对结果集进行分页 所有数据*/
        List<PurchaseEnca> pageMaterials = PageResult.ListSplit(purchaseEncas, pageSize, pageNum);
        pageBean.setList(pageMaterials);
        pageBean.setMsg("success");
        return pageBean;

    }


    @CrossOrigin
    @ApiOperation(value = "保存采购单记录", notes = "保存采购单记录", httpMethod = "POST")
    @ApiImplicitParam(name = "purchaseEnca", value = "PurchaseEncae对象", required = true, dataType = "PurchaseEnca")
    @ResponseBody
    @PostMapping("/save")
    public ResultSet save(@RequestBody PurchaseEnca purchaseEnca) {
        Purchase purchase = new Purchase();
        Purchasedetail purchasedetail = new Purchasedetail();

        if(selectMaxCreateTime() == null){
            purchase.setPurchaseNumber(PNumberUtil.CreateDate()+"00001");
        }else if(selectMaxCreateTime().getPurchaseNumber() != null){
            /**采购单号 根据采购单号查询采购单相关商品详细信息*/
            purchase.setPurchaseNumber(PNumberUtil.CreatePNumber(selectMaxCreateTime().getPurchaseNumber()));
        }


        /**设置采购单初始状态为未审核状态*/
        purchase.setAuditStatus("sh02");
        /**设置采购单初始状态为未提交状态*/
        purchase.setSubmitStatus("tj02");

        /**货品编码*/
        if (purchaseEnca.getItemCode() != null) {
            purchase.setItemCode(purchaseEnca.getItemCode());
        }
        if (purchaseEnca.getNumber() != null) {
            purchase.setNumber(purchaseEnca.getNumber());
        }
        if (purchaseEnca.getSupplier() != null) {
            /**根据单位编码查询供应商名字保存到采购单*/
            purchase.setSupplier(supplierService.selectUNameByUcode(purchaseEnca.getSupplier()));
        }
        if (purchaseEnca.getPurchaseSource() != null) {
            purchase.setPurchaseSource(purchaseEnca.getPurchaseSource());
        }
        if (purchaseEnca.getReceiveStatus() != null) {
            purchase.setReceiveStatus(purchaseEnca.getReceiveStatus());
        }
        if (purchaseEnca.getFrequency() != null) {
            purchase.setFrequency(purchaseEnca.getFrequency());
        }
        if (purchaseEnca.getType() != null) {
            purchase.setType(purchaseEnca.getType());
        }
        if (purchaseEnca.getCommodityType() != null) {
            purchase.setCommodityType(purchaseEnca.getCommodityType());
        }
        if (purchaseEnca.getReceiveAddress() != null) {
            purchase.setReceiveAddress(purchaseEnca.getReceiveAddress());
        }
        if (purchaseEnca.getContractTerm() != null) {
            purchase.setContractTerm(purchaseEnca.getContractTerm());
        }
        if (purchaseEnca.getSinglePerson() != null) {
            purchase.setSinglePerson(purchaseEnca.getSinglePerson());
        }
        if (purchaseEnca.getSubmitter() != null) {
            purchase.setSubmitter(purchaseEnca.getSubmitter());
        }
        if (purchaseEnca.getFinancialJudge() != null) {
            purchase.setFinancialJudge(purchaseEnca.getFinancialJudge());
        }
        if (purchaseEnca.getAuditor() != null) {
            purchase.setAuditor(purchaseEnca.getAuditor());
        }

/**采购单 总金额 总数量 计算*/
        Integer totalQuantitys = 0;
        Double totalSums = 0.0000;
        Double taxTotalSums = 0.0000;

        for (int j = 0; j < purchaseEnca.getGoodsList().size(); j++) {
            if (purchaseEnca.getGoodsList().get(j).getNumber() != null
                    && purchaseEnca.getGoodsList().get(j).getUnitPrice() != null
                        && purchaseEnca.getGoodsList().get(j).getTaxPrice() != null) {
                /**总数量*/
                totalQuantitys += purchaseEnca.getGoodsList().get(j).getNumber();
                /**不含税总金额*/
                totalSums += (purchaseEnca.getGoodsList().get(j).getNumber())* (purchaseEnca.getGoodsList().get(j).getUnitPrice());
                /**含税总金额*/
                taxTotalSums += (purchaseEnca.getGoodsList().get(j).getNumber()) * (purchaseEnca.getGoodsList().get(j).getTaxPrice());
            }
        }

        if(totalQuantitys != null){
            purchase.setTotalQuantity(totalQuantitys);
        }
        if(totalSums != null){
            purchase.setTotalSum(totalSums);
        }
        if(taxTotalSums != null){
            purchase.setTaxTotalSum(taxTotalSums);
        }

/************************/

        if (purchaseEnca.getCompleteStatus() != null) {
            purchase.setCompleteStatus(purchaseEnca.getCompleteStatus());
        }
        if (purchaseEnca.getInvoiceAmount() != null) {
            purchase.setInvoiceAmount(purchaseEnca.getInvoiceAmount());
        }
        if (purchaseEnca.getNonInvoice() != null) {
            purchase.setNonInvoice(purchaseEnca.getNonInvoice());
        }
        if (purchaseEnca.getTaxAmount() != null) {
            purchase.setTaxAmount(purchaseEnca.getTaxAmount());
        }
        if (purchaseEnca.getTaxRate() != null) {
            purchase.setTaxRate(purchaseEnca.getTaxRate());
        }
        if (purchaseEnca.getUnit() != null) {
            purchase.setUnit(purchaseEnca.getUnit());
        }
        if (purchaseEnca.getContacts() != null) {
            purchase.setContacts(purchaseEnca.getContacts());
        }
        if (purchaseEnca.getInvoice() != null) {
            purchase.setInvoice(purchaseEnca.getInvoice());
        }
        if (purchaseEnca.getFactoryName() != null) {
            purchase.setFactoryName(purchaseEnca.getFactoryName());
            /**根据工厂名查询相应收货地址 保存到采购单*/
            purchase.setReceiveAddress(factoryService.selectAddressByCode(purchaseEnca.getFactoryName())+factoryService.selectDAddressByCode(purchaseEnca.getFactoryName()));
        }
        if (purchaseEnca.getFreight() != null) {
            purchase.setFreight(purchaseEnca.getFreight());
        }
        if (purchaseEnca.getFreightTransportation() != null) {
            purchase.setFreightTransportation(purchaseEnca.getFreightTransportation());
        }
        if (purchaseEnca.getRemark() != null) {
            purchase.setRemark(purchaseEnca.getRemark());
        }
        /**保存对象数据*/
        purchaseService.insert(purchase);

        for (int i = 0; i < purchaseEnca.getGoodsList().size(); i++) {
            purchasedetail.setId(UUIDUtils.getUUID());

            purchasedetail.setCreateTime(new Date());

            purchasedetail.setPurchaseNumber(purchase.getPurchaseNumber());

            if (purchaseEnca.getGoodsList().get(i).getId() != null) {
                purchasedetail.setGoodsId(purchaseEnca.getGoodsList().get(i).getId());
            }
            if (purchaseEnca.getGoodsList().get(i).getMerchantCode() != null) {
                purchasedetail.setMerchantCode(purchaseEnca.getGoodsList().get(i).getMerchantCode());
            }
            if (purchaseEnca.getGoodsList().get(i).getName() != null) {
                purchasedetail.setName(purchaseEnca.getGoodsList().get(i).getName());
            }

            /**计算不含税总价和含税总价*/

            /**不含税总价*/
            if(purchaseEnca.getGoodsList().get(i).getNumber() != null
                    && purchaseEnca.getGoodsList().get(i).getUnitPrice() != null){
                purchasedetail.setTotalPrice((purchaseEnca.getGoodsList().get(i).getNumber()) * (purchaseEnca.getGoodsList().get(i).getUnitPrice()));
            }
            /**含税总价*/
            if(purchaseEnca.getGoodsList().get(i).getNumber() != null
                    && purchaseEnca.getGoodsList().get(i).getTaxPrice() != null){
                purchasedetail.setTaxTotalPrice((purchaseEnca.getGoodsList().get(i).getNumber()) * (purchaseEnca.getGoodsList().get(i).getTaxPrice()));
            }

            /***/



            /**货品编码*/
            if (purchaseEnca.getItemCode() != null) {
                purchasedetail.setItemCode(purchaseEnca.getItemCode());
            }
            if (purchaseEnca.getGoodsList().get(i).getType() != null) {
                purchasedetail.setType(purchaseEnca.getGoodsList().get(i).getType());
            }
            if (purchaseEnca.getGoodsList().get(i).getSku() != null) {
                purchasedetail.setSku(purchaseEnca.getGoodsList().get(i).getSku());
            }
            if (purchaseEnca.getGoodsList().get(i).getBrand() != null) {
                purchasedetail.setBrand(purchaseEnca.getGoodsList().get(i).getBrand());
            }
            if (purchaseEnca.getGoodsList().get(i).getProcess() != null) {
                purchasedetail.setProcess(purchaseEnca.getGoodsList().get(i).getProcess());
            }
            if (purchaseEnca.getGoodsList().get(i).getSeason() != null) {
                purchasedetail.setSeason(purchaseEnca.getGoodsList().get(i).getSeason());
            }
            if (purchaseEnca.getGoodsList().get(i).getCostPrice() != null) {
                purchasedetail.setCostPrice(purchaseEnca.getGoodsList().get(i).getCostPrice());
            }
            if (purchaseEnca.getGoodsList().get(i).getUnit() != null) {
                purchasedetail.setUnit(purchaseEnca.getGoodsList().get(i).getUnit());
            }
            if (purchaseEnca.getGoodsList().get(i).getPackag() != null) {
                purchasedetail.setPackag(purchaseEnca.getGoodsList().get(i).getPackag());
            }
            if (purchaseEnca.getGoodsList().get(i).getWeight() != null) {
                purchasedetail.setWeight(purchaseEnca.getGoodsList().get(i).getWeight());
            }
            if (purchaseEnca.getGoodsList().get(i).getBarCode() != null) {
                purchasedetail.setBarCode(purchaseEnca.getGoodsList().get(i).getBarCode());
            }
            if (purchaseEnca.getGoodsList().get(i).getIngredients() != null) {
                purchasedetail.setIngredients(purchaseEnca.getGoodsList().get(i).getIngredients());
            }
            if (purchaseEnca.getGoodsList().get(i).getStandard() != null) {
                purchasedetail.setStandard(purchaseEnca.getGoodsList().get(i).getStandard());
            }
            if (purchaseEnca.getGoodsList().get(i).getDataState() != null) {
                purchasedetail.setDataState(purchaseEnca.getGoodsList().get(i).getDataState());
            }
            if (purchaseEnca.getGoodsList().get(i).getAmountMoney() != null) {
                purchasedetail.setAmountMoney(purchaseEnca.getGoodsList().get(i).getAmountMoney());
            }
            if (purchaseEnca.getGoodsList().get(i).getNumber() != null) {
                purchasedetail.setNumber(purchaseEnca.getGoodsList().get(i).getNumber());
            }
            if (purchaseEnca.getGoodsList().get(i).getWarehouseNumber() != null) {
                purchasedetail.setWarehouseNumber(purchaseEnca.getGoodsList().get(i).getWarehouseNumber());
            }
            if (purchaseEnca.getGoodsList().get(i).getWarehouseTime() != null) {
                purchasedetail.setWarehouseTime(purchaseEnca.getGoodsList().get(i).getWarehouseTime());
            }
            if (purchaseEnca.getGoodsList().get(i).getUnitPrice() != null) {
                purchasedetail.setUnitPrice(purchaseEnca.getGoodsList().get(i).getUnitPrice());
            }
            if (purchaseEnca.getGoodsList().get(i).getTaxPrice() != null) {
                purchasedetail.setTaxPrice(purchaseEnca.getGoodsList().get(i).getTaxPrice());
            }
            if (purchaseEnca.getGoodsList().get(i).getPackag() != null) {
                purchasedetail.setPackag(purchaseEnca.getGoodsList().get(i).getPackag());
            }
            if (purchaseEnca.getGoodsList().get(i).getRemark() != null) {
                purchasedetail.setRemark(purchaseEnca.getGoodsList().get(i).getRemark());
            }

            detailService.insert(purchasedetail);

        }

        return ResultSet.getSuccess(purchaseEnca);

    }



    /**封装PurchaseEnca数据*/
    public List<PurchaseEnca> ObtainPurchaseEnca(List<Purchase> purchases){

        List<PurchaseEnca> purchaseEncas =  new ArrayList<PurchaseEnca>();

        for(int pe=0;pe<purchases.size();pe++){

            /**一定要在for循环里面创建对象，不然会出现后面数据覆盖前面数据的问题*/
            PurchaseEnca purchaseEnca = new PurchaseEnca();

            if(purchases.get(pe).getId() != null){
                purchaseEnca.setId(purchases.get(pe).getId());
            }
            if(purchases.get(pe).getCreateTime() != null){
                purchaseEnca.setCreateTime(purchases.get(pe).getCreateTime());
            }
            if(purchases.get(pe).getPurchaseTime() != null){
                purchaseEnca.setUpdateTime(purchases.get(pe).getPurchaseTime());
            }
            if(purchases.get(pe).getFinancialTime() != null){
                purchaseEnca.setFinancialTime(purchases.get(pe).getFinancialTime());
            }
            if(purchases.get(pe).getSubmitTime() != null){
                purchaseEnca.setSubmitTime(purchases.get(pe).getSubmitTime());
            }
            if(purchases.get(pe).getAuditTime() != null){
                purchaseEnca.setAuditTime(purchases.get(pe).getAuditTime());
            }
            if(purchases.get(pe).getCloseTime() != null){
                purchaseEnca.setCloseTime(purchases.get(pe).getCloseTime());
            }
            if(purchases.get(pe).getItemCode() != null){
                purchaseEnca.setItemCode(purchases.get(pe).getItemCode());
            }
            if(purchases.get(pe).getNumber() != null){
                purchaseEnca.setNumber(purchases.get(pe).getNumber());
            }
            if(purchases.get(pe).getSupplier() != null){
                purchaseEnca.setSupplier(purchases.get(pe).getSupplier());
            }
            if(purchases.get(pe).getPurchaseNumber() != null){
                purchaseEnca.setPurchaseNumber(purchases.get(pe).getPurchaseNumber());
            }
            if(purchases.get(pe).getPurchaseSource() != null){
                purchaseEnca.setPurchaseSource(purchases.get(pe).getPurchaseSource());
            }
            if(purchases.get(pe).getAuditStatus() != null){
                purchaseEnca.setAuditStatus(purchases.get(pe).getAuditStatus());
            }
            if(purchases.get(pe).getSubmitStatus() != null){
                purchaseEnca.setSubmitStatus(purchases.get(pe).getSubmitStatus());
            }
            if(purchases.get(pe).getReceiveStatus() != null){
                purchaseEnca.setReceiveStatus(purchases.get(pe).getReceiveStatus());
            }
            if(purchases.get(pe).getFrequency() != null){
                purchaseEnca.setFrequency(purchases.get(pe).getFrequency());
            }
            if(purchases.get(pe).getType() != null){
                purchaseEnca.setType(purchases.get(pe).getType());
            }
            if(purchases.get(pe).getCommodityType() != null){
                purchaseEnca.setCommodityType(purchases.get(pe).getCommodityType());
            }
            if(purchases.get(pe).getReceiveAddress() != null){
                purchaseEnca.setReceiveAddress(purchases.get(pe).getReceiveAddress());
            }
            if(purchases.get(pe).getSinglePerson() != null){
                purchaseEnca.setSinglePerson(purchases.get(pe).getSinglePerson());
            }
            if(purchases.get(pe).getSubmitter() != null){
                purchaseEnca.setSubmitter(purchases.get(pe).getSubmitter());
            }
            if(purchases.get(pe).getContractTerm() != null){
                purchaseEnca.setContractTerm(purchases.get(pe).getContractTerm());
            }
            if(purchases.get(pe).getFinancialJudge() != null){
                purchaseEnca.setFinancialJudge(purchases.get(pe).getFinancialJudge());
            }
            if(purchases.get(pe).getAuditor() != null){
                purchaseEnca.setAuditor(purchases.get(pe).getAuditor());
            }
            if(purchases.get(pe).getTotalSum() != null){
                purchaseEnca.setTotalSum(purchases.get(pe).getTotalSum());
            }
            if(purchases.get(pe).getTaxTotalSum() != null){
                purchaseEnca.setTaxTotalSum(purchases.get(pe).getTaxTotalSum());
            }
            if(purchases.get(pe).getTotalQuantity() != null){
                purchaseEnca.setTotalQuantity(purchases.get(pe).getTotalQuantity());
            }
            if(purchases.get(pe).getCompleteStatus() != null){
                purchaseEnca.setCompleteStatus(purchases.get(pe).getCompleteStatus());
            }
            if(purchases.get(pe).getInvoiceAmount() != null){
                purchaseEnca.setInvoiceAmount(purchases.get(pe).getInvoiceAmount());
            }
            if(purchases.get(pe).getNonInvoice() != null){
                purchaseEnca.setNonInvoice(purchases.get(pe).getNonInvoice());
            }
            if(purchases.get(pe).getTaxAmount() != null){
                purchaseEnca.setTaxAmount(purchases.get(pe).getTaxAmount());
            }
            if(purchases.get(pe).getTaxRate() != null){
                purchaseEnca.setTaxRate(purchases.get(pe).getTaxRate());
            }
            if(purchases.get(pe).getUnit() != null){
                purchaseEnca.setContacts(purchases.get(pe).getContacts());
            }

            if(purchases.get(pe).getInvoice() != null){
                purchaseEnca.setInvoice(purchases.get(pe).getInvoice());
            }
            if(purchases.get(pe).getFreight() != null){
                purchaseEnca.setFreight(purchases.get(pe).getFreight());
            }


            if(purchases.get(pe).getFreightTransportation() != null){
                purchaseEnca.setFreightTransportation(purchases.get(pe).getFreightTransportation());
            }
            if(purchases.get(pe).getRemark() != null){
                purchaseEnca.setRemark(purchases.get(pe).getRemark());
            }
            if(purchases.get(pe).getFactoryName() != null){
                purchaseEnca.setFactoryName(purchases.get(pe).getFactoryName());
            }

            List<Purchasedetail> purchasedetails = detailService.selectByPurchaseNumber(purchases.get(pe).getPurchaseNumber());
            if(purchasedetails != null){
                purchaseEnca.setGoodsList(purchasedetails);
            }

            purchaseEncas.add(pe,purchaseEnca);

        }
        return purchaseEncas;
    }


    /**封装Purchase 对象*/
    public Purchase ObtainPurchase(PurchaseEnca purchaseEnca){

        Purchase purchase = new Purchase();
        if(purchaseEnca.getId() != null){
            purchase.setId(purchaseEnca.getId());
        }
        if(purchaseEnca.getCreateTime() != null){
            purchase.setCreateTime(purchaseEnca.getCreateTime());
        }
       if(purchaseEnca.getUpdateTime() != null){
           purchase.setUpdateTime(purchaseEnca.getUpdateTime());
       }
       if(purchaseEnca.getPurchaseTime() != null){
           purchase.setPurchaseTime(purchaseEnca.getPurchaseTime());
       }
       if(purchaseEnca.getFinancialTime() != null){
           purchase.setFinancialTime(purchaseEnca.getFinancialTime());
       }
       if(purchaseEnca.getSubmitTime() != null){
           purchase.setSubmitTime(purchaseEnca.getSubmitTime());
       }
       if(purchaseEnca.getAuditTime() != null){
           purchase.setAuditTime(purchaseEnca.getAuditTime());
       }
       if(purchaseEnca.getCloseTime() != null){
           purchase.setCloseTime(purchaseEnca.getCloseTime());
       }
       if(purchaseEnca.getItemCode() != null){
           purchase.setItemCode(purchaseEnca.getItemCode());
       }
       if(purchaseEnca.getNumber() != null){
           purchase.setNumber(purchaseEnca.getNumber());
       }
       if(purchaseEnca.getSupplier() != null){
           purchase.setSupplier(purchaseEnca.getSupplier());
       }
       if(purchaseEnca.getPurchaseNumber() != null){
           purchase.setPurchaseNumber(purchaseEnca.getPurchaseNumber());
       }
       if(purchaseEnca.getPurchaseSource() != null){
            purchase.setPurchaseSource(purchaseEnca.getPurchaseSource());
       }
       if(purchaseEnca.getAuditStatus() != null){
           purchase.setAuditStatus(purchaseEnca.getAuditStatus());
       }
       if(purchaseEnca.getSubmitStatus() != null){
           purchase.setSubmitStatus(purchaseEnca.getSubmitStatus());
       }
       if(purchaseEnca.getReceiveStatus() != null){
           purchase.setReceiveStatus(purchaseEnca.getReceiveStatus());
       }
       if(purchaseEnca.getFrequency() != null){
           purchase.setFrequency(purchaseEnca.getFrequency());
       }
       if(purchaseEnca.getType() != null){
           purchase.setType(purchaseEnca.getType());
       }
       if(purchaseEnca.getCommodityType() != null){
           purchase.setCommodityType(purchaseEnca.getCommodityType());
       }
       if(purchaseEnca.getReceiveAddress() != null){
           purchase.setReceiveAddress(purchaseEnca.getReceiveAddress());
       }
       if(purchaseEnca.getSinglePerson() != null){
           purchase.setSinglePerson(purchaseEnca.getSinglePerson());
       }
       if(purchaseEnca.getSubmitter() != null){
           purchase.setSubmitter(purchaseEnca.getSubmitter());
       }
       if(purchaseEnca.getContractTerm() != null){
           purchase.setContractTerm(purchaseEnca.getContractTerm());
       }
       if(purchaseEnca.getFinancialJudge() != null){
           purchase.setFinancialJudge(purchaseEnca.getFinancialJudge());
       }
       if(purchaseEnca.getAuditor() != null){
           purchase.setAuditor(purchaseEnca.getAuditor());
       }
       if(String.valueOf(purchaseEnca.getTotalSum()) != null){
           purchase.setTotalSum(purchaseEnca.getTotalSum());
       }
       if(String.valueOf(purchaseEnca.getTaxTotalSum()) != null){
           purchase.setTaxTotalSum(purchaseEnca.getTaxTotalSum());
       }
       if(purchaseEnca.getTotalQuantity() != null){
           purchase.setTotalQuantity(purchaseEnca.getTotalQuantity());
       }
       if(purchaseEnca.getCompleteStatus() != null){
           purchase.setCompleteStatus(purchaseEnca.getCompleteStatus());
       }
       if(purchaseEnca.getInvoiceAmount() != null){
           purchase.setInvoiceAmount(purchaseEnca.getInvoiceAmount());
       }
       if(purchaseEnca.getNonInvoice() != null){
           purchase.setNonInvoice(purchaseEnca.getNonInvoice());
       }
       if(purchaseEnca.getTaxAmount() != null){
           purchase.setTaxAmount(purchaseEnca.getTaxAmount());
       }
       if(purchaseEnca.getTaxRate() != null){
           purchase.setTaxRate(purchaseEnca.getTaxRate());
       }
       if(purchaseEnca.getUnit() != null){
           purchase.setUnit(purchaseEnca.getUnit());
       }
       if(purchaseEnca.getContacts() != null){
            purchase.setContacts(purchaseEnca.getContacts());
       }
       if(purchaseEnca.getInvoice() != null){
           purchase.setInvoice(purchaseEnca.getInvoice());
       }
       if(purchaseEnca.getFreight() != null){
           purchase.setFreight(purchaseEnca.getFreight());
       }
       if(purchaseEnca.getFreightTransportation() != null){
           purchase.setFreightTransportation(purchaseEnca.getFreightTransportation());
       }
       if(purchaseEnca.getRemark() != null){
           purchase.setRemark(purchaseEnca.getRemark());
       }
       if(purchaseEnca.getFactoryName() != null){
           purchase.setFactoryName(purchaseEnca.getFactoryName());
       }

        return purchase;

    }




}





/*


数据例子



{
            "id": "4b156735f84f45b4ab3141805d818035",
            "createTime": "2019-03-18 16:54:08",
            "updateTime": null,
            "purchaseTime": null,
            "financialTime": null,
            "submitTime": null,
            "auditTime": null,
            "closeTime": null,
            "itemCode": null,
            "number": null,
            "supplier": "06",
            "purchaseNumber": "CGD20190318165407",
            "purchaseSource": null,
            "auditStatus": "sh01",
            "submitStatus": "tj02",
            "receiveStatus": "sh01",
            "frequency": null,
            "type": null,
            "commodityType": null,
            "receiveAddress": null,
            "contractTerm": null,
            "singlePerson": null,
            "submitter": null,
            "financialJudge": null,
            "auditor": null,
            "totalSum": 8,
            "taxTotalSum": 11,
            "totalQuantity": 2,
            "completeStatus": null,
            "invoiceAmount": null,
            "nonInvoice": null,
            "taxAmount": null,
            "taxRate": null,
            "unit": null,
            "contacts": null,
            "invoice": "增值税普通发票",
            "freight": 777,
            "freightTransportation": "777",
            "factoryName": "111",
            "remark": "777",
            "goodsList": [
                {
                    "id": "4a6dba048b3e450ca375c2a52e83b1bf",
                    "goodsId": "1c6f86bac76d402b9b98cc4e2005dd21",
                    "createTime": "2019-03-18 16:54:08",
                    "updateTime": null,
                    "merchantCode": "12",
                    "name": "test",
                    "itemCode": null,
                    "type": "test",
                    "sku": "test",
                    "brand": "test",
                    "process": "test",
                    "season": "test",
                    "costPrice": 0,
                    "unit": "test",
                    "packag": "test",
                    "weight": "test",
                    "barCode": "23",
                    "ingredients": "test",
                    "standard": "test",
                    "dataState": "001",
                    "number": 1,
                    "other": null,
                    "unitPrice": 5,
                    "taxPrice": 6,
                    "totalPrice": 5,
                    "taxTotalPrice": 6,
                    "warehouseTime": "",
                    "amountMoney": null,
                    "warehouseNumber": null,
                    "purchaseNumber": "CGD20190318165407",
                    "spare06": null,
                    "remark": "test"
                },
                {
                    "id": "52b43adbd558465cb01442d46084b460",
                    "goodsId": "007a0459c65848578eaf146450a23139",
                    "createTime": "2019-03-18 16:54:08",
                    "updateTime": null,
                    "merchantCode": "test",
                    "name": "test",
                    "itemCode": null,
                    "type": "test",
                    "sku": "test",
                    "brand": "test",
                    "process": "test",
                    "season": "test",
                    "costPrice": 0,
                    "unit": "test",
                    "packag": "test",
                    "weight": "test",
                    "barCode": "test",
                    "ingredients": "test",
                    "standard": "test",
                    "dataState": "001",
                    "number": 1,
                    "other": null,
                    "unitPrice": 3,
                    "taxPrice": 3,
                    "totalPrice": 3,
                    "taxTotalPrice": 3,
                    "warehouseTime": "",
                    "amountMoney": null,
                    "warehouseNumber": null,
                    "purchaseNumber": "CGD20190318165407",
                    "spare06": null,
                    "remark": "test"
                }
            ]
        }







*/











