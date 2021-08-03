package com.luer.basicsetup.dao;

import java.util.List;

import com.luer.basicsetup.bean.Goodsmessage;
import com.luer.basicsetup.bean.GoodsmessageExample;
import org.apache.ibatis.annotations.Param;

public interface GoodsmessageMapper {
    int countByExample(GoodsmessageExample example);

    int deleteByExample(GoodsmessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsmessage record);

    int insertSelective(Goodsmessage record);

    List<Goodsmessage> selectByExample(GoodsmessageExample example);

    Goodsmessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsmessage record, @Param("example") GoodsmessageExample example);

    int updateByExample(@Param("record") Goodsmessage record, @Param("example") GoodsmessageExample example);

    int updateByPrimaryKeySelective(Goodsmessage record);

    int updateByPrimaryKey(Goodsmessage record);

    Goodsmessage selectById(@Param("id")String id);

    boolean deleteByIds(String[] arr);

    List<Goodsmessage> select();

    List<Goodsmessage> selectRecycle();

    boolean updateBySpare01Open(String[] arr);

    boolean updateBySpare01Out(String[] arr);

    List<Goodsmessage> selectByMaterialCode(@Param("merchantCode") String merchantCode);

    List<Goodsmessage> selectByMaterialCodeAndName(@Param("merchantCode")String merchantCode,@Param("name")String name);

    List<Goodsmessage> selectByMaterialCodeAndNameAndItemCode(@Param("merchantCode")String merchantCode,@Param("name")String name,@Param("itemCode")String itemCode);

    List<Goodsmessage> selectByMaterialCodeAndNameAndSku(@Param("merchantCode")String merchantCode,@Param("name")String name,@Param("sku")String sku);

    List<Goodsmessage> selectByMaterialCodeAndItemcode(@Param("merchantCode")String merchantCode,@Param("itemCode")String itemCode);

    List<Goodsmessage> selectByMaterialCodeAndItemCodeAndSku(@Param("merchantCode")String merchantCode,@Param("itemCode")String itemCode,@Param("sku")String sku);

    List<Goodsmessage> selectByMaterialCodeAndSku(@Param("merchantCode")String merchantCode,@Param("sku")String sku);

    List<Goodsmessage> selectByMaterialCodeAndNameAndItemCodeAndSku(@Param("merchantCode")String merchantCode,@Param("name")String name,@Param("itemCode")String itemCode,@Param("sku")String sku);

    List<Goodsmessage> selectByName(@Param("name")String name);

    List<Goodsmessage> selectByNameAndItemCode(@Param("name")String name,@Param("itemCode")String itemCode);

    List<Goodsmessage> selectByNameAndSku(@Param("name")String name,@Param("sku")String sku);

    List<Goodsmessage> selectByNameAndItemCodeAndSku(@Param("name")String name,@Param("itemCode")String itemCode,@Param("sku")String sku);

    List<Goodsmessage> selectByItemCode(@Param("itemCode")String itemCode);

    List<Goodsmessage> selectByItemCodeAndSku(@Param("itemCode")String itemCode,@Param("sku")String sku);

    List<Goodsmessage> selectBySku(@Param("sku")String sku);

    List<Goodsmessage> selectByOther(@Param("other")String other);

    List<Goodsmessage> selectByMerchantCodeR(@Param("merchantCode")String merchantCode);


    List<Goodsmessage> selectByNameR(@Param("name")String name);

    List<Goodsmessage> selectByOtherR(@Param("other")String other);

    List<Goodsmessage> selectByMerchantCode(@Param("merchantCode")String merchantCode);

    List<Goodsmessage> selectByBarCode(@Param("barCode")String barCode);

}