package com.luer.basicsetup.service.impl;

import com.luer.basicsetup.bean.*;
import com.luer.basicsetup.dao.SuppliermanageMapper;
import com.luer.basicsetup.service.SupplierService;
import com.luer.comm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SuppliermanageMapper supplierMapper;

    @Override
    public int insert(Suppliermanage suppliermanage){
        suppliermanage.setId(UUIDUtils.getUUID());
        suppliermanage.setCreateTime(new Date());
        return supplierMapper.insert(suppliermanage);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (supplierMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Suppliermanage suppliermanage) {
        suppliermanage.setUpdateTime(new Date());
        SuppliermanageExample suppliermanageExample = new SuppliermanageExample();
        SuppliermanageExample.Criteria criteria = suppliermanageExample.createCriteria();
        criteria.andIdEqualTo(id);
        return supplierMapper.updateByExampleSelective(suppliermanage,suppliermanageExample);
    }

    @Override
    public Suppliermanage selectById(String id){
        return supplierMapper.selectById(id);
    }

    @Override
    public List<Suppliermanage> select(){
        return supplierMapper.select();
    }

    @Override
    public List<Suppliermanage> selectByClassName(String className){
        return supplierMapper.selectByClassName(className);
    }

    @Override
    public List<Suppliermanage> selectByUnitName(String unitName){
        return supplierMapper.selectByUnitName(unitName);
    }

    @Override
    public List<Suppliermanage> selectByUnitNameAndPhoneNumber(String unitName, String phoneNumber){
        return supplierMapper.selectByUnitNameAndPhoneNumber(unitName,phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectByPhoneNumber(String phoneNumber){
        return supplierMapper.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectYByUnitName(String unitName){
        return supplierMapper.selectYByUnitName(unitName);
    }

    @Override
    public List<Suppliermanage> selectYByUnitNameAndPhoneNumber(String unitName, String phoneNumber){
        return supplierMapper.selectYByUnitNameAndPhoneNumber(unitName,phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectYByPhoneNumber(String phoneNumber){
        return supplierMapper.selectYByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectFByUnitName(String unitName){
        return supplierMapper.selectFByUnitName(unitName);
    }

    @Override
    public List<Suppliermanage> selectFByUnitNameAndPhoneNumber(String unitName,String phoneNumber){
        return supplierMapper.selectFByUnitNameAndPhoneNumber(unitName,phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectFByPhoneNumber(String phoneNumber){
        return supplierMapper.selectFByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Suppliermanage> selectOtherBySpare01(String spare01){
        return supplierMapper.selectOtherBySpare01(spare01);
    }

    @Override
    public List<Suppliermanage> selectOtherYBySpare01(String spare01){
        return supplierMapper.selectOtherYBySpare01(spare01);
    }

    @Override
    public List<Suppliermanage> selectOtherFBySpare01(String spare01){
        return supplierMapper.selectOtherFBySpare01(spare01);
    }



    @Override
    public List<Suppliermanage> selectByUnitCode(String unitCode){
        return supplierMapper.selectByUnitCode(unitCode);
    }

    @Override
    public String selectUNameByUcode(String unitCode){
       return  supplierMapper.selectUNameByUcode(unitCode);
    }

}
