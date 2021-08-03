package com.luer.purchase.service;

import com.luer.purchase.bean.Purchasedetail;

import java.util.List;

public interface PurchasedetailService {

    int insert(Purchasedetail purchasedetail);

    List<Purchasedetail> select();

    boolean deleteByIds(String[] arr);

    int updateById(String id,Purchasedetail purchasedetail);

    Purchasedetail selectById(String id);

    List<Purchasedetail> selectByPurchaseNumber(String purchaseNumer);

    int deleteByPNumber(String purchaseNumber);

}
