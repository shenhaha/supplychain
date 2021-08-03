package com.luer.purchase.service.impl;


import com.luer.comm.utils.UUIDUtils;
import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.PurchaseExample;
import com.luer.purchase.bean.Purchasematerial;
import com.luer.purchase.bean.PurchasematerialExample;
import com.luer.purchase.dao.PurchasematerialMapper;
import com.luer.purchase.service.PurchasematerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class PurchasematerialServiceImpl implements PurchasematerialService {

    @Autowired
    PurchasematerialMapper materialMapper;

    @Override
    public int insert(Purchasematerial purchasematerial) {
        purchasematerial.setId(UUIDUtils.getUUID());
        purchasematerial.setCreateTime(new Date());
        return materialMapper.insert(purchasematerial);
    }

    @Override
    public List<Purchasematerial> select() {
        return materialMapper.select();
    }

    @Override
    public List<Purchasematerial> selectCreate(String startTime, String spare03) {
        return materialMapper.selectCreate(startTime, spare03);
    }

    @Override
    public List<Purchasematerial> selectCByAuditStatus(String startTime, String spare03, String auditStatus) {
        return materialMapper.selectCByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchasematerial> selectCByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return materialMapper.selectCByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectCByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return materialMapper.selectCByAuditStatusAndPurchaseNumber(startTime, spare03, auditStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return materialMapper.selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectCByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return materialMapper.selectCByReceiveStatus(startTime, spare03, receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectCByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return materialMapper.selectCByReceiveStatusAndPurchaseNumber(startTime, spare03, receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectCByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return materialMapper.selectCByPurchaseNumber(startTime, spare03, purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectSubmit(String startTime, String spare03) {
        return materialMapper.selectSubmit(startTime, spare03);
    }

    @Override
    public List<Purchasematerial> selectSByAuditStatus(String startTime,String spare03,String auditStatus){
        return materialMapper.selectSByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchasematerial> selectSByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return materialMapper.selectSByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectSByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return materialMapper.selectSByAuditStatusAndPurchaseNumber(startTime, spare03,auditStatus, purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return materialMapper.selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectSByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return materialMapper.selectSByReceiveStatus(startTime, spare03,receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectSByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return materialMapper.selectSByReceiveStatusAndPurchaseNumber(startTime, spare03,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectSByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return materialMapper.selectSByPurchaseNumber(startTime, spare03,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectAudit(String startTime, String spare03) {
        return materialMapper.selectAudit(startTime, spare03);
    }

    @Override
    public List<Purchasematerial> selectAByAuditStatus(String startTime,String spare03,String auditStatus){
        return materialMapper.selectAByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchasematerial> selectAByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return materialMapper.selectAByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectAByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return materialMapper.selectAByAuditStatusAndPurchaseNumber(startTime, spare03,auditStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return materialMapper.selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectAByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return materialMapper.selectAByReceiveStatus(startTime, spare03,receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectAByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return materialMapper.selectAByReceiveStatusAndPurchaseNumber(startTime, spare03,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectAByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return materialMapper.selectAByPurchaseNumber(startTime, spare03,purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectByAuditStatus(String auditStatus) {
        return materialMapper.selectByAuditStatus(auditStatus);
    }

    @Override
    public List<Purchasematerial> selectByAuditStatusAndReceiveStatus(String auditStatus, String receiveStatus) {
        return materialMapper.selectByAuditStatusAndReceiveStatus(auditStatus, receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectByAuditStatusAndPurchaseNumber(String auditStatus,String purchaseNumber){
        return materialMapper.selectByAuditStatusAndPurchaseNumber(auditStatus, purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(String auditStatus, String receiveStatus, String purchaseNumber) {
        return materialMapper.selectByAuditStatusAndReceiveStatusAndPurchaseNumber(auditStatus, receiveStatus, purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectByReceiveStatus(String receiveStatus) {
        return materialMapper.selectByReceiveStatus(receiveStatus);
    }

    @Override
    public List<Purchasematerial> selectByReceiveStatusAndPurchaseNumber(String receiveStatus, String purchaseNumber) {
        return materialMapper.selectByReceiveStatusAndPurchaseNumber(receiveStatus, purchaseNumber);
    }

    @Override
    public List<Purchasematerial> selectByPurchaseNumber(String purchaseNumber) {
        return materialMapper.selectByPurchaseNumber(purchaseNumber);
    }

    @Override
    public Purchasematerial selectMaxCreateTime(){
        return materialMapper.selectMaxCreateTime();
    }


    @Override
    public String selectPNumberById(String id){
        return materialMapper.selectPNumberById(id);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (materialMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Purchasematerial purchasematerial) {
        purchasematerial.setUpdateTime(new Date());
        PurchasematerialExample purchasematerialExample = new PurchasematerialExample();
        PurchasematerialExample.Criteria criteria = purchasematerialExample.createCriteria();
        criteria.andIdEqualTo(id);
        return materialMapper.updateByExampleSelective(purchasematerial, purchasematerialExample);
    }

    @Override
    public List<Purchasematerial> selectById(String id) {
        return materialMapper.selectById(id);
    }




}
