package com.luer.warehouse.dao;

import java.util.List;

import com.luer.warehouse.bean.Warehousemdetail;
import com.luer.warehouse.bean.WarehousemdetailExample;
import org.apache.ibatis.annotations.Param;

public interface WarehousemdetailMapper {

    int countByExample(WarehousemdetailExample example);

    int deleteByExample(WarehousemdetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(Warehousemdetail record);

    int insertSelective(Warehousemdetail record);

    List<Warehousemdetail> selectByExample(WarehousemdetailExample example);

    Warehousemdetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Warehousemdetail record, @Param("example") WarehousemdetailExample example);

    int updateByExample(@Param("record") Warehousemdetail record, @Param("example") WarehousemdetailExample example);

    int updateByPrimaryKeySelective(Warehousemdetail record);

    int updateByPrimaryKey(Warehousemdetail record);

    List<Warehousemdetail> selectByPurchaseNumber(@Param("purchaseNumber")String purchaseNumber);

    int deleteByPNumber(@Param("purchaseNumber")String purchaseNumber);

    List<Warehousemdetail> selectByOddNumber(@Param("oddNumber")String oddNumber);

}