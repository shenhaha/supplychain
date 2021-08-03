package com.luer.basicsetup.service;

import com.luer.basicsetup.bean.Suppliermanage;

import java.util.List;


public interface SupplierService {

    int insert(Suppliermanage suppliermanage);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Suppliermanage suppliermanage);

    Suppliermanage selectById(String id);

    List<Suppliermanage> select();

    List<Suppliermanage> selectByClassName(String className);

    List<Suppliermanage> selectByUnitName(String unitName);

    List<Suppliermanage> selectByUnitNameAndPhoneNumber(String unitName, String phoneNumber);

    List<Suppliermanage> selectByPhoneNumber(String phoneNumber);

    List<Suppliermanage> selectYByUnitName(String unitName);

    List<Suppliermanage> selectYByUnitNameAndPhoneNumber(String unitName, String phoneNumber);

    List<Suppliermanage> selectYByPhoneNumber(String phoneNumber);

    List<Suppliermanage> selectFByUnitName(String unitName);

    List<Suppliermanage> selectFByUnitNameAndPhoneNumber(String unitName,String phoneNumber);

    List<Suppliermanage> selectFByPhoneNumber(String phoneNumber);

    List<Suppliermanage> selectOtherBySpare01(String spare01);

    List<Suppliermanage> selectOtherYBySpare01(String spare01);

    List<Suppliermanage> selectOtherFBySpare01(String spare01);

    List<Suppliermanage> selectByUnitCode(String unitCode);

    String selectUNameByUcode(String unitCode);


}
