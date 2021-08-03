package com.luer.purchase.service.impl;

import com.luer.purchase.bean.Purchase;
import com.luer.purchase.bean.PurchaseExample;
import com.luer.purchase.dao.PurchaseMapper;
import com.luer.purchase.service.PurchaseService;
import com.luer.comm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public int insert(Purchase purchase) {
        purchase.setId(UUIDUtils.getUUID());
        purchase.setCreateTime(new Date());
        return purchaseMapper.insert(purchase);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (purchaseMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Purchase purchase) {
        purchase.setUpdateTime(new Date());
        PurchaseExample purchaseExample = new PurchaseExample();
        PurchaseExample.Criteria criteria = purchaseExample.createCriteria();
        criteria.andIdEqualTo(id);
        return purchaseMapper.updateByExampleSelective(purchase, purchaseExample);
    }

    @Override
    public boolean updateAudit(String[] arr){
        if (purchaseMapper.updateAudit(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUnaudit(String[] arr){
        if (purchaseMapper.updateUnaudit(arr)) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    public List<Purchase> selectById(String id) {
        return purchaseMapper.selectById(id);
    }

    @Override
    public List<Purchase> select() {
        return purchaseMapper.select();
    }

    @Override
    public List<Purchase> selectByAuditStatus(String auditStatus) {
        return purchaseMapper.selectByAuditStatus(auditStatus);
    }

    @Override
    public List<Purchase> selectByAuditStatusAndReceiveStatus(String auditStatus, String receiveStatus) {
        return purchaseMapper.selectByAuditStatusAndReceiveStatus(auditStatus, receiveStatus);
    }

    @Override
    public List<Purchase> selectByAuditStatusAndReceiveStatusAndPurchaseNumber(String auditStatus, String receiveStatus, String purchaseNumber) {
        return purchaseMapper.selectByAuditStatusAndReceiveStatusAndPurchaseNumber(auditStatus, receiveStatus, purchaseNumber);
    }

    @Override
    public List<Purchase> selectByReceiveStatus(String receiveStatus) {
        return purchaseMapper.selectByReceiveStatus(receiveStatus);
    }

    @Override
    public List<Purchase> selectByPurchaseNumber(String purchaseNumber) {
        return purchaseMapper.selectByPurchaseNumber(purchaseNumber);
    }

    @Override
    public List<Purchase> selectByReceiveStatusAndPurchaseNumber(String receiveStatus, String purchaseNumber) {
        return purchaseMapper.selectByReceiveStatusAndPurchaseNumber(receiveStatus, purchaseNumber);
    }

    @Override
    public List<Purchase> selectByAuditStatusAndPurchaseNumber(String auditStatus,String purchaseNumber){
        return purchaseMapper.selectByAuditStatusAndPurchaseNumber(auditStatus, purchaseNumber);
    }

    @Override
    public List<Purchase> selectCreate(String startTime, String endTime) {
        return purchaseMapper.selectCreate(startTime, endTime);
    }

    @Override
    public List<Purchase> selectSubmit(String startTime, String spare03) {
        return purchaseMapper.selectSubmit(startTime, spare03);
    }

    @Override
    public List<Purchase> selectAudit(String startTime, String spare03) {
        return purchaseMapper.selectAudit(startTime, spare03);
    }

    @Override
    public List<Purchase> selectCByAuditStatus(String startTime, String spare03, String auditStatus) {
        return purchaseMapper.selectCByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchase> selectCByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return purchaseMapper.selectCByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchase> selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectCByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectSByAuditStatus(String startTime,String spare03,String auditStatus){
        return purchaseMapper.selectSByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchase> selectSByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return purchaseMapper.selectSByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchase> selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectSByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectAByAuditStatus(String startTime,String spare03,String auditStatus){
        return purchaseMapper.selectAByAuditStatus(startTime, spare03, auditStatus);
    }

    @Override
    public List<Purchase> selectAByAuditStatusAndReceiveStatus(String startTime,String spare03,String auditStatus,String receiveStatus){
        return purchaseMapper.selectAByAuditStatusAndReceiveStatus(startTime, spare03, auditStatus,receiveStatus);
    }

    @Override
    public List<Purchase> selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectAByAuditStatusAndReceiveStatusAndPurchaseNumber(startTime, spare03, auditStatus,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectCByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return purchaseMapper.selectCByAuditStatusAndPurchaseNumber(startTime, spare03, auditStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectCByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return purchaseMapper.selectCByReceiveStatus(startTime, spare03, receiveStatus);
    }

    @Override
    public List<Purchase> selectCByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectCByReceiveStatusAndPurchaseNumber(startTime, spare03, receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectCByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return purchaseMapper.selectCByPurchaseNumber(startTime, spare03, purchaseNumber);
    }

    @Override
    public List<Purchase> selectSByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return purchaseMapper.selectSByAuditStatusAndPurchaseNumber(startTime, spare03,auditStatus, purchaseNumber);
    }

    @Override
    public List<Purchase> selectSByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return purchaseMapper.selectSByReceiveStatus(startTime, spare03,receiveStatus);
    }

    @Override
    public List<Purchase> selectSByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectSByReceiveStatusAndPurchaseNumber(startTime, spare03,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectSByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return purchaseMapper.selectSByPurchaseNumber(startTime, spare03,purchaseNumber);
    }

    @Override
    public List<Purchase> selectAByAuditStatusAndPurchaseNumber(String startTime,String spare03,String auditStatus,String purchaseNumber){
        return purchaseMapper.selectAByAuditStatusAndPurchaseNumber(startTime, spare03,auditStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectAByReceiveStatus(String startTime,String spare03,String receiveStatus){
        return purchaseMapper.selectAByReceiveStatus(startTime, spare03,receiveStatus);
    }

    @Override
    public List<Purchase> selectAByReceiveStatusAndPurchaseNumber(String startTime,String spare03,String receiveStatus,String purchaseNumber){
        return purchaseMapper.selectAByReceiveStatusAndPurchaseNumber(startTime, spare03,receiveStatus,purchaseNumber);
    }

    @Override
    public List<Purchase> selectAByPurchaseNumber(String startTime,String spare03,String purchaseNumber){
        return purchaseMapper.selectAByPurchaseNumber(startTime, spare03,purchaseNumber);
    }


    @Override
    public String selectPNumberById(String id){
        return purchaseMapper.selectPNumberById(id);
    }

    @Override
    public Purchase selectMaxCreateTime(){
        return purchaseMapper.selectMaxCreateTime();
    }


}