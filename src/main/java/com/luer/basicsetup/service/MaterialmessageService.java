package com.luer.basicsetup.service;

import com.luer.basicsetup.bean.Materialmessage;

import java.util.List;

public interface MaterialmessageService {

    int insert(Materialmessage materialmessage);

    int insertSelective(Materialmessage materialmessage);

    int deleteByPrimaryKey(String id);

    boolean deleteByIds(String[] arr);

    int updateById(String id,Materialmessage materialmessage);

    boolean updateByIdOpen(String[] arr);

    boolean updateByIdOut(String[] arr);

    boolean updateByDataStateOpen(String[] arr);

    boolean updateByDataStateOut(String[] arr);

    int count();


    Materialmessage selectById(String id);

    List<Materialmessage> selectByName(String name);

    List<Materialmessage> selectYFByName(String name);

    List<Materialmessage> selectBByName(String name);

    List<Materialmessage> selectYByName(String name);

    List<Materialmessage> selectByType(String type);

    List<Materialmessage> selectByTypeAnd(String type);

    List<Materialmessage> selectByMaterialCode(String materialCode);

    List<Materialmessage> selectYFByMaterialCode(String materialCode);

    List<Materialmessage> selectBByMaterialCode(String materialCode);

    List<Materialmessage> selectYByMaterialCode(String materialCode);



    List<Materialmessage> selectByMaterialCodeAll(String materialCode);

    List<Materialmessage> selectByManufacturer(String manufacturer);

    List<Materialmessage> selectYFByManufacturer(String manufacturer);

    List<Materialmessage> selectBByManufacturer(String manufacturer);

    List<Materialmessage> selectYByManufacturer(String manufacturer);



    List<Materialmessage> selectByTypeAndName(String type,String name);

    List<Materialmessage> selectByTypeAndManufacturer(String type,String manufacturer);

    List<Materialmessage> select();

    List<Materialmessage> selectByTypeAndSpare(String type,String spare);

    List<Materialmessage> selectBySpare(String spare);

    List<Materialmessage> selectfuByName(String name);

    List<Materialmessage> selectfuByManufacturer(String manufacturer);

    List<Materialmessage> selectfuBySpare(String spare);

    List<Materialmessage> selectRecycle();

    List<Materialmessage> selectByMaterialCodeAndName(String materialCode,String name);

    List<Materialmessage> selectYFByMaterialCodeAndName(String materialCode,String name);

    List<Materialmessage> selectBByMaterialCodeAndName(String materialCode,String name);

    List<Materialmessage> selectYByMaterialCodeAndName(String materialCode,String name);

    List<Materialmessage> selectBymaterialCodeAndManufacturer(String materialCode,String manufacturer);

    List<Materialmessage> selectYFBymaterialCodeAndManufacturer(String materialCode,String manufacturer);

    List<Materialmessage> selectBBymaterialCodeAndManufacturer(String materialCode,String manufacturer);

    List<Materialmessage> selectYBymaterialCodeAndManufacturer(String materialCode,String manufacturer);

    List<Materialmessage> selectByManufacturerAndName(String manufacturer,String name);

    List<Materialmessage> selectYFByManufacturerAndName(String manufacturer,String name);

    List<Materialmessage> selectBByManufacturerAndName(String manufacturer,String name);

    List<Materialmessage> selectYByManufacturerAndName(String manufacturer,String name);


    List<Materialmessage> selectByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name);

    List<Materialmessage> selectYFByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name);

    List<Materialmessage> selectBByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name);

    List<Materialmessage> selectYByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name);

    List<Materialmessage> selectByMaterialCodeR(String materialCode);

    List<Materialmessage> selectByMaterialCodeAndNameR(String materialCode,String name);

    List<Materialmessage> selectByNameR(String name);





}
