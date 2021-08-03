package com.luer.basicsetup.service.impl;


import com.luer.basicsetup.bean.Materialmessage;
import com.luer.basicsetup.bean.MaterialmessageExample;
import com.luer.basicsetup.dao.MaterialmessageMapper;
import com.luer.basicsetup.service.MaterialmessageService;
import com.luer.comm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MaterialmessageServiceImpl implements MaterialmessageService {

    @Autowired
    private MaterialmessageMapper materialmessageMapper;

    @Override
    public int insert(Materialmessage materialmessage){
        materialmessage.setId(UUIDUtils.getUUID());
        materialmessage.setCreateTime(new Date());
        /**设置新建数据为可用数据*/
        materialmessage.setDataState("001");
        /**设置新建数据为未启用*/
        materialmessage.setSpare("02");
        return materialmessageMapper.insert(materialmessage);
    }

    @Override
    public int insertSelective(Materialmessage materialmessage){
        materialmessage.setId(UUIDUtils.getUUID());
        materialmessage.setCreateTime(new Date());
        return materialmessageMapper.insert(materialmessage);
    }

    @Override
    public int deleteByPrimaryKey(String id){
        return materialmessageMapper.deleteByPrimaryKey(id);
    }



    @Override
    public boolean deleteByIds(String[] arr) {
        if (materialmessageMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Materialmessage materialmessage) {
        materialmessage.setUpdateTime(new Date());
        MaterialmessageExample materialmessageExample = new MaterialmessageExample();
        MaterialmessageExample.Criteria criteria = materialmessageExample.createCriteria();
        criteria.andIdEqualTo(id);
        return materialmessageMapper.updateByExampleSelective(materialmessage,materialmessageExample);
    }

    @Override
    public boolean updateByIdOpen(String[] arr){
        if (materialmessageMapper.updateByIdOpen(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateByIdOut(String[] arr){
        if (materialmessageMapper.updateByIdOut(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateByDataStateOpen(String[] arr){
        if (materialmessageMapper.updateByDataStateOpen(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateByDataStateOut(String[] arr){
        if (materialmessageMapper.updateByDataStateOut(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int count(){
        return materialmessageMapper.count();
    }



    @Override
    public Materialmessage selectById(String id){
        return materialmessageMapper.selectById(id);
    }

    @Override
    public List<Materialmessage> selectByName(String name){
        return materialmessageMapper.selectByName(name);
    }

    @Override
    public List<Materialmessage> selectYFByName(String name){
        return materialmessageMapper.selectYFByName(name);
    }

    @Override
    public List<Materialmessage> selectBByName(String name){
        return materialmessageMapper.selectBByName(name);
    }


    @Override
    public List<Materialmessage> selectYByName(String name){
        return materialmessageMapper.selectYByName(name);
    }

    @Override
    public List<Materialmessage> selectByType(String type){
        return materialmessageMapper.selectByType(type);
    }

    @Override
    public List<Materialmessage> selectByTypeAnd(String type){
        return materialmessageMapper.selectByTypeAnd(type);
    }

    @Override
    public List<Materialmessage> selectByMaterialCode(String materialCode){
        return materialmessageMapper.selectByMaterialCode(materialCode);
    }

    @Override
    public List<Materialmessage> selectYFByMaterialCode(String materialCode){
        return materialmessageMapper.selectYFByMaterialCode(materialCode);
    }

    @Override
    public List<Materialmessage> selectYByMaterialCode(String materialCode){
        return materialmessageMapper.selectYByMaterialCode(materialCode);
    }

    @Override
    public List<Materialmessage> selectBByMaterialCode(String materialCode){
        return materialmessageMapper.selectBByMaterialCode(materialCode);
    }

    @Override
    public List<Materialmessage> selectByMaterialCodeAll(String materialCode){
        return materialmessageMapper.selectByMaterialCodeAll(materialCode);
    }

    @Override
    public List<Materialmessage> selectByManufacturer(String manufacturer){
        return materialmessageMapper.selectByManufacturer(manufacturer);
    }

    @Override
    public List<Materialmessage> selectYFByManufacturer(String manufacturer){
        return materialmessageMapper.selectYFByManufacturer(manufacturer);
    }


    @Override
    public List<Materialmessage> selectBByManufacturer(String manufacturer){
        return materialmessageMapper.selectBByManufacturer(manufacturer);
    }

    @Override
    public List<Materialmessage> selectYByManufacturer(String manufacturer){
        return materialmessageMapper.selectYByManufacturer(manufacturer);
    }


    @Override
    public List<Materialmessage> selectByTypeAndName(String type,String name){
        return  materialmessageMapper.selectByTypeAndName(type,name);
    }

    @Override
    public List<Materialmessage> selectByTypeAndManufacturer(String type,String manufacturer){
        return materialmessageMapper.selectByTypeAndManufacturer(type,manufacturer);
    }

    @Override
    public List<Materialmessage> select(){
        return materialmessageMapper.select();
    }

    @Override
    public List<Materialmessage> selectByTypeAndSpare(String type,String spare){
        return materialmessageMapper.selectByTypeAndSpare(type,spare);
    }

    @Override
    public List<Materialmessage> selectBySpare(String spare){
        return materialmessageMapper.selectBySpare(spare);
    }

    @Override
    public List<Materialmessage> selectfuByName(String name){
        return materialmessageMapper.selectfuByName(name);
    }

    @Override
    public List<Materialmessage> selectfuByManufacturer(String manufacturer){
        return materialmessageMapper.selectfuByManufacturer(manufacturer);
    }

    @Override
    public List<Materialmessage> selectfuBySpare(String spare){
        return materialmessageMapper.selectfuBySpare(spare);
    }

    @Override
    public List<Materialmessage> selectRecycle(){
        return materialmessageMapper.selectRecycle();
    }

    @Override
    public List<Materialmessage> selectByMaterialCodeAndName(String materialCode,String name){
        return materialmessageMapper.selectByMaterialCodeAndName(materialCode,name);
    }

    @Override
    public List<Materialmessage> selectYFByMaterialCodeAndName(String materialCode,String name){
        return materialmessageMapper.selectYFByMaterialCodeAndName(materialCode,name);
    }

    @Override
    public List<Materialmessage> selectBByMaterialCodeAndName(String materialCode,String name){
        return materialmessageMapper.selectBByMaterialCodeAndName(materialCode,name);
    }

    @Override
    public List<Materialmessage> selectYByMaterialCodeAndName(String materialCode,String name){
        return materialmessageMapper.selectYByMaterialCodeAndName(materialCode,name);
    }

    @Override
    public List<Materialmessage> selectBymaterialCodeAndManufacturer(String materialCode,String manufacturer){
        return materialmessageMapper.selectBymaterialCodeAndManufacturer(materialCode,manufacturer);
    }

    @Override
    public List<Materialmessage> selectYFBymaterialCodeAndManufacturer(String materialCode,String manufacturer){
        return materialmessageMapper.selectYFBymaterialCodeAndManufacturer(materialCode,manufacturer);
    }

    @Override
    public List<Materialmessage> selectBBymaterialCodeAndManufacturer(String materialCode,String manufacturer){
        return materialmessageMapper.selectBBymaterialCodeAndManufacturer(materialCode,manufacturer);
    }

    @Override
    public List<Materialmessage> selectYBymaterialCodeAndManufacturer(String materialCode,String manufacturer){
        return materialmessageMapper.selectYBymaterialCodeAndManufacturer(materialCode,manufacturer);
    }

    @Override
    public List<Materialmessage> selectByManufacturerAndName(String manufacturer,String name){
        return materialmessageMapper.selectByManufacturerAndName(manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectYFByManufacturerAndName(String manufacturer,String name){
        return materialmessageMapper.selectYFByManufacturerAndName(manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectBByManufacturerAndName(String manufacturer,String name){
        return materialmessageMapper.selectBByManufacturerAndName(manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectYByManufacturerAndName(String manufacturer,String name){
        return materialmessageMapper.selectYByManufacturerAndName(manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name){
        return materialmessageMapper.selectByMaterialCodeAndManufacturerAndName(materialCode,manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectYFByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name){
        return materialmessageMapper.selectYFByMaterialCodeAndManufacturerAndName(materialCode,manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectBByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name){
        return materialmessageMapper.selectBByMaterialCodeAndManufacturerAndName(materialCode,manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectYByMaterialCodeAndManufacturerAndName(String materialCode,String manufacturer,String name){
        return materialmessageMapper.selectYByMaterialCodeAndManufacturerAndName(materialCode,manufacturer,name);
    }

    @Override
    public List<Materialmessage> selectByMaterialCodeR(String materialCode){
        return materialmessageMapper.selectByMaterialCodeR(materialCode);
    }

    @Override
    public List<Materialmessage> selectByMaterialCodeAndNameR(String materialCode,String name){
        return materialmessageMapper.selectByMaterialCodeAndNameR(materialCode,name);
    }

    @Override
    public List<Materialmessage> selectByNameR(String name){
        return materialmessageMapper.selectByNameR(name);
    }

}
