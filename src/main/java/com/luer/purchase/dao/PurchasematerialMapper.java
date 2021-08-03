package com.luer.purchase.dao;


import com.luer.purchase.bean.Purchasematerial;
import com.luer.purchase.bean.PurchasematerialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchasematerialMapper {

    int countByExample(PurchasematerialExample example);

    int deleteByExample(PurchasematerialExample example);

    int deleteByPrimaryKey(String id);

    int insert(Purchasematerial record);

    int insertSelective(Purchasematerial record);

    List<Purchasematerial> selectByExample(PurchasematerialExample example);

    Purchasematerial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Purchasematerial record, @Param("example") PurchasematerialExample example);

    int updateByExample(@Param("record") Purchasematerial record, @Param("example") PurchasematerialExample example);

    int updateByPrimaryKeySelective(Purchasematerial record);

    int updateByPrimaryKey(Purchasematerial record);

    List<Purchasematerial> select();

    List<Purchasematerial> selectCreate(String startTime, String spare03);

    List<Purchasematerial> selectCByAuditStatus(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("auditStatus")String auditStatus);

    List<Purchasematerial> selectCByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectCByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectCByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectCByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectCByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectSubmit(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Purchasematerial> selectSByAuditStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus);

    List<Purchasematerial> selectSByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectSByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectSByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectSByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectSByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectAudit(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Purchasematerial> selectAByAuditStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus);

    List<Purchasematerial> selectAByAuditStatusAndReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectAByAuditStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectAByReceiveStatus(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectAByReceiveStatusAndPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectAByPurchaseNumber(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectByAuditStatus(@Param("auditStatus")String auditStatus);

    List<Purchasematerial> selectByAuditStatusAndReceiveStatus(@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectByAuditStatusAndPurchaseNumber(@Param("auditStatus")String auditStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(@Param("auditStatus")String auditStatus,@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectByReceiveStatus(@Param("receiveStatus")String receiveStatus);

    List<Purchasematerial> selectByReceiveStatusAndPurchaseNumber(@Param("receiveStatus")String receiveStatus,@Param("purchaseNumber")String purchaseNumber);

    List<Purchasematerial> selectByPurchaseNumber(@Param("purchaseNumber")String purchaseNumber);

    Purchasematerial selectMaxCreateTime();

    String selectPNumberById(@Param("id")String id);

    boolean deleteByIds(String[] arr);

    List<Purchasematerial> selectById(@Param("id") String id);




}