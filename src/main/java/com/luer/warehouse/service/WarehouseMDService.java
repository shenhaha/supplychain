package com.luer.warehouse.service;

import com.luer.warehouse.bean.Warehousemdetail;

import java.util.List;

public interface WarehouseMDService {


    List<Warehousemdetail> selectByPurchaseNumber(String purchaseNumber);

    int insert(Warehousemdetail warehousemdetail);

    int updateById(String id,Warehousemdetail warehousemdetail);

    int deleteByPNumber(String purchaseNumber);

   List<Warehousemdetail> selectByOddNumber(String oddNumber);


}
