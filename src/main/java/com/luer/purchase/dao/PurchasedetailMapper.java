package com.luer.purchase.dao;

import java.util.List;

import com.luer.purchase.bean.Purchasedetail;
import com.luer.purchase.bean.PurchasedetailExample;
import org.apache.ibatis.annotations.Param;

public interface PurchasedetailMapper {
    int countByExample(PurchasedetailExample example);

    int deleteByExample(PurchasedetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(Purchasedetail record);

    int insertSelective(Purchasedetail record);

    List<Purchasedetail> selectByExample(PurchasedetailExample example);

    Purchasedetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Purchasedetail record, @Param("example") PurchasedetailExample example);

    int updateByExample(@Param("record") Purchasedetail record, @Param("example") PurchasedetailExample example);

    int updateByPrimaryKeySelective(Purchasedetail record);

    int updateByPrimaryKey(Purchasedetail record);

    List<Purchasedetail> select();

    boolean deleteByIds(String[] arr);

    Purchasedetail selectById(@Param("id")String id);

    List<Purchasedetail> selectByPurchaseNumber(@Param("purchaseNumber")String purchaseNumber);

    int deleteByPNumber(@Param("purchaseNumber")String purchaseNumber);


}