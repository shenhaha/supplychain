package com.luer.basicsetup.service.impl;


import com.luer.basicsetup.bean.Factorymanage;
import com.luer.basicsetup.bean.FactorymanageExample;
import com.luer.basicsetup.dao.FactorymanageMapper;
import com.luer.basicsetup.service.FactoryService;
import com.luer.comm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    FactorymanageMapper factoryMapper;

    @Override
    public int insert(Factorymanage factorymanage){
        factorymanage.setId(UUIDUtils.getUUID());
        factorymanage.setCreateTime(new Date());
        return factoryMapper.insert(factorymanage);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (factoryMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Factorymanage factorymanage) {
        factorymanage.setUpdateTime(new Date());
        FactorymanageExample factorymanageExample = new FactorymanageExample();
        FactorymanageExample.Criteria criteria = factorymanageExample.createCriteria();
        criteria.andIdEqualTo(id);
        return factoryMapper.updateByExampleSelective(factorymanage,factorymanageExample);
    }

    @Override
    public Factorymanage selectById(String id){
        return factoryMapper.selectById(id);
    }

    @Override
    public List<Factorymanage> select(){
        return factoryMapper.select();
    }

    @Override
    public List<Factorymanage> selectByName(String name){
        return factoryMapper.selectByName(name);
    }

    @Override
    public List<Factorymanage> selectByNameAndCompany(String name,String company){
        return factoryMapper.selectByNameAndCompany(name,company);
    }

    @Override
    public List<Factorymanage> selectByCompany(String company){
        return factoryMapper.selectByCompany(company);
    }

    @Override
    public List<Factorymanage> selectOtherBySpare01(String spare01){
        return factoryMapper.selectOtherBySpare01(spare01);
    }

    @Override
    public String selectAddressByCode(String code){
        return factoryMapper.selectAddressByCode(code);
    }

    @Override
    public Factorymanage selectByCode(String code){
        return factoryMapper.selectByCode(code);
    }

    @Override
    public String selectDAddressByCode(String code){
        return factoryMapper.selectDAddressByCode(code);
    }



}
