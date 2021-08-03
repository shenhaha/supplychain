package com.luer.purchase.service;


import com.luer.purchase.bean.Purchasemdetail;

import java.util.List;


public interface PurchasemdetailService {

    List<Purchasemdetail> selectByPurchaseNumber(String purchaseNumber);

    int insert(Purchasemdetail purchasemdetail);

    int deleteByPNumber(String purchaseNumber);
    
    int updateById(String id,Purchasemdetail purchasemdetail);

    Purchasemdetail selectById(String id);



}
