package com.luer.purchase.dao;

import java.util.List;

import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.PurchaseExample;
import org.apache.ibatis.annotations.Param;

public interface PurchaseMapper {
    int countByExample(PurchaseExample example);

    int deleteByExample(PurchaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    List<Purchase> selectByExample(PurchaseExample example);

    Purchase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByExample(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    boolean updateAudit(String[] arr);

    boolean updateUnaudit(String[] arr);

    boolean deleteByIds(String[] arr);

    List<Purchase> selectById(@Param("id") String id);

    List<Purchase> select();

    List<Purchase> selectByAuditStatus(@Param("auditStatus")String auditStatus);

    List<Purchase> selectByAuditStatusAndReceiveStatus(@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectByReceiveStatus(@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectByPurchaseNumber(@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectByReceiveStatusAndPurchaseNumber(@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectCreate(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Purchase> selectSubmit(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Purchase> selectAudit(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Purchase> selectByAuditStatusAndPurchaseNumber(@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectCByAuditStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus);

    List<Purchase> selectCByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectSByAuditStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus);

    List<Purchase> selectSByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectAByAuditStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus);

    List<Purchase> selectAByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectCByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectCByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectCByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectCByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectSByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectSByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectSByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectSByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectAByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectAByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchase> selectAByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchase> selectAByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    String selectPNumberById(@Param("id")String id);

    Purchase selectMaxCreateTime();





}