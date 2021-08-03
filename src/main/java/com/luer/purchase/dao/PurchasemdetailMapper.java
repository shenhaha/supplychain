package com.luer.purchase.dao;

import java.util.List;

import com.luer.purchase.bean.Purchasemdetail;
import com.luer.purchase.bean.PurchasemdetailExample;
import org.apache.ibatis.annotations.Param;

public interface PurchasemdetailMapper {

    int countByExample(PurchasemdetailExample example);

    int deleteByExample(PurchasemdetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(Purchasemdetail record);

    int insertSelective(Purchasemdetail record);

    List<Purchasemdetail> selectByExample(PurchasemdetailExample example);

    Purchasemdetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Purchasemdetail record, @Param("example") PurchasemdetailExample example);

    int updateByExample(@Param("record") Purchasemdetail record, @Param("example") PurchasemdetailExample example);

    int updateByPrimaryKeySelective(Purchasemdetail record);

    int updateByPrimaryKey(Purchasemdetail record);

    List<Purchasemdetail> selectByPurchaseNumber(@Param("purchaseNumber")String purchaseNumber);

    Purchasemdetail selectMaxCreateTime();

    int deleteByPNumber(@Param("purchaseNumber")String purchaseNumber);

    Purchasemdetail selectById(@Param("id")String id);


    
}