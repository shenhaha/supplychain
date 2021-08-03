package com.luer.warehouse.service.impl;


import com.luer.warehouse.bean.Warehousematerial;
import com.luer.warehouse.bean.WarehousematerialExample;
import com.luer.warehouse.dao.WarehousematerialMapper;
import com.luer.warehouse.service.WarehouseMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WarehouseMServiceImpl implements WarehouseMService {

    @Autowired
    WarehousematerialMapper materialMapper;

    @Override
    public List<Warehousematerial> select(){
        return materialMapper.select();
    }

    @Override
    public List<Warehousematerial> selectById(String id){
        return materialMapper.selectById(id);
    }

    @Override
    public int insert(Warehousematerial warehousematerial){

        return materialMapper.insert(warehousematerial);
    }

    @Override
    public int updateById(String id, Warehousematerial warehousematerial) {
        warehousematerial.setUpdateTime(new Date());
        WarehousematerialExample warehousematerialExample = new WarehousematerialExample();
        WarehousematerialExample.Criteria criteria = warehousematerialExample.createCriteria();
        criteria.andIdEqualTo(id);
        return materialMapper.updateByExampleSelective(warehousematerial, warehousematerialExample);
    }

    @Override
   public String  selectIntroduceNumberById(String id){
        return materialMapper.selectIntroduceNumberById(id);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (materialMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Warehousematerial selectMaxCreateTime(){
        return materialMapper.selectMaxCreateTime();
    }

    @Override
    public List<Warehousematerial> selectByFName(String factoryName){
        return materialMapper.selectByFName(factoryName);
    }

    @Override
    public List<Warehousematerial> selectByFNameAndCategory(String factoryName,String category){
        return materialMapper.selectByFNameAndCategory(factoryName,category);
    }

    @Override
    public List<Warehousematerial> selectByFNameAndCategoryAndOddNumber(String factoryName,String category,String oddNumber){
        return materialMapper.selectByFNameAndCategoryAndOddNumber(factoryName,category,oddNumber);
    }

    @Override
    public List<Warehousematerial> selectByOddNumber(String oddNumber){
        return materialMapper.selectByOddNumber(oddNumber);
    }

    @Override
    public List<Warehousematerial> selectByOddNumberAndCategory(String oddNumber,String category){
        return materialMapper.selectByOddNumberAndCategory(oddNumber,category);
    }

    @Override
    public List<Warehousematerial> seclectByCategory(String category){
        return materialMapper.seclectByCategory(category);
    }

}
