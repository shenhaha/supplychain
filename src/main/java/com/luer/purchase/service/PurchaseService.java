package com.luer.purchase.service;

import com.luer.purchase.bean.Purchase;

import java.util.List;

public interface PurchaseService {

    int insert(Purchase purchase);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Purchase purchase);

    boolean updateAudit(String[] arr);

    boolean updateUnaudit(String[] arr);

    List<Purchase>  selectById(String id);

    List<Purchase> select();

    List<Purchase> selectByAuditStatus(String auditStatus);

    List<Purchase> selectByAuditStatusAndReceiveStatus(String auditStatus,String receiveStatus);

    List<Purchase> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchase> selectByReceiveStatus(String receiveStatus);

    List<Purchase> selectByPurchaseNumber(String purchaseNumber);

    List<Purchase> selectByReceiveStatusAndPurchaseNumber(String receiveStatus,String purchaseNumber);

    List<Purchase> selectCreate(String startTime,String endTime);

    List<Purchase> selectSubmit(String startTime,String endTime);

    List<Purchase> selectAudit(String startTime,String endTime);

    List<Purchase> selectByAuditStatusAndPurchaseNumber(String auditStatus,String purchaseNumber);

    List<Purchase> selectCByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchase> selectCByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchase> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchase> selectSByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchase> selectSByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchase> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchase> selectAByAuditStatus(String startTime,String endTime,String auditStatus);

    List<Purchase> selectAByAuditStatusAndReceiveStatus(String startTime,String endTime,String auditStatus,String receiveStatus);

    List<Purchase> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String receiveStatus,String purchaseNumber);

    List<Purchase> selectCByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchase> selectCByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchase> selectCByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchase> selectCByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    List<Purchase> selectSByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchase> selectSByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchase> selectSByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchase> selectSByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    List<Purchase> selectAByAuditStatusAndPurchaseNumber(String startTime,String endTime,String auditStatus,String purchaseNumber);

    List<Purchase> selectAByReceiveStatus(String startTime,String endTime,String receiveStatus);

    List<Purchase> selectAByReceiveStatusAndPurchaseNumber(String startTime,String endTime,String receiveStatus,String purchaseNumber);

    List<Purchase> selectAByPurchaseNumber(String startTime,String endTime,String purchaseNumber);

    String selectPNumberById(String id);

    Purchase selectMaxCreateTime();



}
