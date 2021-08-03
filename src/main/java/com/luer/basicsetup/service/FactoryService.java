package com.luer.basicsetup.service;


import com.luer.basicsetup.bean.Factorymanage;

import java.util.List;

public interface FactoryService {


    int insert(Factorymanage factorymanage);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Factorymanage factorymanage);

    Factorymanage selectById(String id);

    List<Factorymanage> select();

    List<Factorymanage> selectByName(String name);

    List<Factorymanage> selectByNameAndCompany(String name,String company);

    List<Factorymanage> selectByCompany(String company);

    List<Factorymanage> selectOtherBySpare01(String spare01);

    String selectAddressByCode(String code);

    Factorymanage selectByCode(String code);

    String selectDAddressByCode(String code);

}
