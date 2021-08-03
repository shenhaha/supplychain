package com.luer.warehouse.service;

import com.luer.purchase.bean.Purchase;
import com.luer.warehouse.bean.Warehousematerial;

import java.util.List;


public interface WarehouseMService {

    List<Warehousematerial> select();

    int updateById(String id,Warehousematerial warehousematerial);

    int insert(Warehousematerial warehousematerial);

    String  selectIntroduceNumberById(String id);

    boolean deleteByIds(String[] arr);

    Warehousematerial selectMaxCreateTime();

    List<Warehousematerial> selectById(String id);

    List<Warehousematerial> selectByFName(String factoryName);

    List<Warehousematerial> selectByFNameAndCategory(String factoryName,String category);

    List<Warehousematerial> selectByFNameAndCategoryAndOddNumber(String factoryName,String category,String oddNumber);

    List<Warehousematerial> selectByOddNumber(String oddNumber);

    List<Warehousematerial> selectByOddNumberAndCategory(String oddNumber,String category);

    List<Warehousematerial> seclectByCategory(String category);



}
