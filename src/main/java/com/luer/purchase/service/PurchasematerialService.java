package com.luer.purchase.service;

import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.Purchasematerial;

import java.util.List;

public interface PurchasematerialService {


    List<Purchasematerial> select();

    List<Purchasematerial> selectCreate(String startTime,String endTime);

    List<Purchasematerial> selectCByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchasematerial> selectCByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchasematerial> selectCByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchasematerial> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectCByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchasematerial> selectCByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectCByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    List<Purchasematerial> selectSubmit(String startTime,String endTime);

    List<Purchasematerial> selectSByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchasematerial> selectSByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchasematerial> selectSByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchasematerial> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectSByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchasematerial> selectSByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectSByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    List<Purchasematerial> selectAudit(String startTime,String endTime);

    List<Purchasematerial> selectAByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchasematerial> selectAByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchasematerial> selectAByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchasematerial> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectAByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchasematerial> selectAByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectAByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    List<Purchasematerial> selectByAuditStatus(String auditStatus);

    List<Purchasematerial> selectByAuditStatusAndReceiveStatus(String auditStatus,String receiveStatus);

    List<Purchasematerial> selectByAuditStatusAndPurchaseNumber(String auditStatus,String purchaseNumber);

    List<Purchasematerial> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectByReceiveStatus(String receiveStatus);

    List<Purchasematerial> selectByReceiveStatusAndPurchaseNumber(String receiveStatus,String purchaseNumber);

    List<Purchasematerial> selectByPurchaseNumber(String purchaseNumber);

    Purchasematerial selectMaxCreateTime();

    int insert(Purchasematerial purchasematerial);

    String selectPNumberById(String id);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Purchasematerial purchasematerial);

    List<Purchasematerial>  selectById(String id);



}
