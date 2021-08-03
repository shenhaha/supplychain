package com.luer.warehouse.dao;

import java.util.List;

import com.luer.warehouse.bean.Warehousematerial;
import com.luer.warehouse.bean.WarehousematerialExample;
import org.apache.ibatis.annotations.Param;

public interface WarehousematerialMapper {

    int countByExample(WarehousematerialExample example);

    int deleteByExample(WarehousematerialExample example);

    int deleteByPrimaryKey(String id);

    int insert(Warehousematerial record);

    int insertSelective(Warehousematerial record);

    List<Warehousematerial> selectByExample(WarehousematerialExample example);

    Warehousematerial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Warehousematerial record, @Param("example") WarehousematerialExample example);

    int updateByExample(@Param("record") Warehousematerial record, @Param("example") WarehousematerialExample example);

    int updateByPrimaryKeySelective(Warehousematerial record);

    int updateByPrimaryKey(Warehousematerial record);

    List<Warehousematerial> select();

    String selectIntroduceNumberById(String id);

    boolean deleteByIds(String[] arr);

    Warehousematerial selectMaxCreateTime();

    List<Warehousematerial> selectById(@Param("id")String id);

    List<Warehousematerial> selectByFName(@Param("factoryName")String factoryName);

    List<Warehousematerial> selectByFNameAndCategory(@Param("factoryName")String factoryName,@Param("category")String category);

    List<Warehousematerial> selectByFNameAndCategoryAndOddNumber(@Param("factoryName")String factoryName,@Param("category")String category,@Param("oddNumber")String oddNumber);

    List<Warehousematerial> selectByOddNumber(@Param("oddNumber")String oddNumber);

    List<Warehousematerial> selectByOddNumberAndCategory(@Param("oddNumber")String oddNumber,@Param("category")String category);

    List<Warehousematerial> seclectByCategory(@Param("category")String category);

}