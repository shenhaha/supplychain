package com.luer.basicsetup.dao;

import java.util.List;

import com.luer.basicsetup.bean.Materialmessage;
import com.luer.basicsetup.bean.MaterialmessageExample;
import org.apache.ibatis.annotations.Param;

public interface MaterialmessageMapper {

    int countByExample(MaterialmessageExample example);

    int deleteByExample(MaterialmessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Materialmessage record);

    int insertSelective(Materialmessage record);

    List<Materialmessage> selectByExample(MaterialmessageExample example);

    Materialmessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record")Materialmessage record, @Param("example") MaterialmessageExample example);

    int updateByExample( Materialmessage record, @Param("example") MaterialmessageExample example);

    int updateByPrimaryKeySelective(Materialmessage record);

    int updateByPrimaryKey(Materialmessage record);

    boolean updateByIdOpen(String[] arr);

    boolean updateByIdOut(String[] arr);

    boolean deleteByIds(String[] arr);

    boolean updateByDataStateOpen(String[] arr);

    boolean updateByDataStateOut(String[] arr);

    int count();


    Materialmessage selectById(@Param("id")String id);

    List<Materialmessage> selectByName(@Param("name")String name);

    List<Materialmessage> selectYFByName(@Param("name")String name);

    List<Materialmessage> selectBByName(@Param("name")String name);

    List<Materialmessage> selectYByName(@Param("name")String name);

    List<Materialmessage> selectByType(@Param("type")String type);

    List<Materialmessage> selectByTypeAnd(@Param("type")String type);

    List<Materialmessage> selectByMaterialCode(@Param("materialCode")String materialCode);

    List<Materialmessage> selectYFByMaterialCode(@Param("materialCode")String materialCode);

    List<Materialmessage> selectBByMaterialCode(@Param("materialCode")String materialCode);

    List<Materialmessage> selectYByMaterialCode(@Param("materialCode")String materialCode);

    List<Materialmessage> selectByMaterialCodeAll(@Param("materialCode")String materialCode);

    List<Materialmessage> selectByManufacturer(@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectYFByManufacturer(@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectBByManufacturer(@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectYByManufacturer(@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectByTypeAndName(@Param("type")String type, @Param("name")String name);

    List<Materialmessage> selectByTypeAndManufacturer(@Param("type")String type, @Param("manufacturer")String manufacturer);

    List<Materialmessage> select();

    List<Materialmessage> selectByTypeAndSpare(@Param("type")String type, @Param("spare")String spare);

    List<Materialmessage> selectBySpare(@Param("spare")String spare);

    List<Materialmessage> selectfuByName(@Param("name")String name);

    List<Materialmessage> selectfuByManufacturer(@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectfuBySpare(@Param("spare")String spare);

    List<Materialmessage> selectRecycle();

    List<Materialmessage> selectByMaterialCodeAndName(@Param("materialCode")String materialCode,@Param("name")String name);

    List<Materialmessage> selectYFByMaterialCodeAndName(@Param("materialCode")String materialCode,@Param("name")String name);

    List<Materialmessage> selectBByMaterialCodeAndName(@Param("materialCode")String materialCode,@Param("name")String name);

    List<Materialmessage> selectYByMaterialCodeAndName(@Param("materialCode")String materialCode,@Param("name")String name);

    List<Materialmessage> selectBymaterialCodeAndManufacturer(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectYFBymaterialCodeAndManufacturer(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectBBymaterialCodeAndManufacturer(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectYBymaterialCodeAndManufacturer(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer);

    List<Materialmessage> selectByManufacturerAndName(@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectYFByManufacturerAndName(@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectBByManufacturerAndName(@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectYByManufacturerAndName(@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectByMaterialCodeAndManufacturerAndName(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectYFByMaterialCodeAndManufacturerAndName(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectBByMaterialCodeAndManufacturerAndName(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectYByMaterialCodeAndManufacturerAndName(@Param("materialCode")String materialCode,@Param("manufacturer")String manufacturer,@Param("name")String name);

    List<Materialmessage> selectByMaterialCodeR(@Param("materialCode")String materialCode);

    List<Materialmessage> selectByMaterialCodeAndNameR(@Param("materialCode")String materialCode,@Param("name")String name);

    List<Materialmessage> selectByNameR(@Param("name")String name);


}