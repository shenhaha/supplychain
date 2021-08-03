package com.luer.basicsetup.service;

import com.luer.basicsetup.bean.Goodsmessage;

import java.util.List;

public interface GoodsmessageService {


    int insert(Goodsmessage goodsmessage);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Goodsmessage goodsmessage);

    Goodsmessage selectById(String id);

    List<Goodsmessage> select();

    List<Goodsmessage> selectRecycle();


    boolean updateBySpare01Open(String[] arr);

    boolean updateBySpare01Out(String[] arr);

    List<Goodsmessage> selectByMaterialCode(String merchantCode);

    List<Goodsmessage> selectByMaterialCodeAndName(String merchantCode,String name);

    List<Goodsmessage> selectByMaterialCodeAndNameAndItemCode(String merchantCode,String name,String itemCode);

    List<Goodsmessage> selectByMaterialCodeAndNameAndSku(String merchantCode,String name,String sku);

    List<Goodsmessage> selectByMaterialCodeAndItemcode(String merchantCode,String itemCode);

    List<Goodsmessage> selectByMaterialCodeAndItemCodeAndSku(String merchantCode,String itemCode,String sku);

    List<Goodsmessage> selectByMaterialCodeAndSku(String merchantCode,String sku);

    List<Goodsmessage> selectByMaterialCodeAndNameAndItemCodeAndSku(String merchantCode,String name,String itemCode,String sku);

    List<Goodsmessage> selectByName(String name);

    List<Goodsmessage> selectByNameAndItemCode(String name,String itemCode);

    List<Goodsmessage> selectByNameAndSku(String name,String sku);

    List<Goodsmessage> selectByNameAndItemCodeAndSku(String name,String itemCode,String sku);

    List<Goodsmessage> selectByItemCode(String itemCode);

    List<Goodsmessage> selectByItemCodeAndSku(String itemCode,String sku);

    List<Goodsmessage> selectBySku(String sku);

    List<Goodsmessage> selectByOther(String other);

    List<Goodsmessage> selectByMerchantCodeR(String merchantCode);

    List<Goodsmessage> selectByNameR(String name);

    List<Goodsmessage> selectByOtherR(String other);

    List<Goodsmessage> selectByMerchantCode(String merchantCode);

    List<Goodsmessage> selectByBarCode(String barCode);




}
