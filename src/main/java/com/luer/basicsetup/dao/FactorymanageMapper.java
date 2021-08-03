package com.luer.basicsetup.dao;

import java.util.List;

import com.luer.basicsetup.bean.Factorymanage;
import com.luer.basicsetup.bean.FactorymanageExample;
import org.apache.ibatis.annotations.Param;

public interface FactorymanageMapper {

    int countByExample(FactorymanageExample example);

    int deleteByExample(FactorymanageExample example);

    int insert(Factorymanage record);

    int insertSelective(Factorymanage record);

    List<Factorymanage> selectByExample(FactorymanageExample example);

    int updateByExampleSelective(@Param("record") Factorymanage record, @Param("example") FactorymanageExample example);

    int updateByExample(@Param("record") Factorymanage record, @Param("example") FactorymanageExample example);


    boolean deleteByIds(String[] arr);

    Factorymanage selectById(@Param("id") String id);

    List<Factorymanage> select();

    List<Factorymanage> selectByName(@Param("name")String name);

    List<Factorymanage> selectByNameAndCompany(@Param("name")String name,@Param("company")String company);

    List<Factorymanage> selectByCompany(@Param("company")String company);

    List<Factorymanage> selectOtherBySpare01(@Param("spare01")String spare01);

    String selectAddressByCode(@Param("code")String code);

    Factorymanage  selectByCode(@Param("code")String code);

    String selectDAddressByCode(@Param("code")String code);


}