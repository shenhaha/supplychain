package com.luer.basicsetup.service.impl;

import com.luer.basicsetup.bean.Goodsmessage;
import com.luer.basicsetup.bean.GoodsmessageExample;
import com.luer.basicsetup.dao.GoodsmessageMapper;
import com.luer.basicsetup.service.GoodsmessageService;
import com.luer.comm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsmessageServiceImpl implements GoodsmessageService {

    @Autowired
    GoodsmessageMapper goodsmessageMapper;

    @Override
    public int insert(Goodsmessage goodsmessage){
        goodsmessage.setId(UUIDUtils.getUUID());
        goodsmessage.setCreateTime(new Date());
        /**设置数据为可用状态*/
        goodsmessage.setDataState("001");
        return goodsmessageMapper.insert(goodsmessage);
    }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (goodsmessageMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Goodsmessage goodsmessage) {
        goodsmessage.setUpdateTime(new Date());
        GoodsmessageExample goodsmessageExample = new GoodsmessageExample();
        GoodsmessageExample.Criteria criteria = goodsmessageExample.createCriteria();
        criteria.andIdEqualTo(id);
        return goodsmessageMapper.updateByExampleSelective(goodsmessage,goodsmessageExample);
    }


    @Override
    public List<Goodsmessage> select(){
        return goodsmessageMapper.select();
    }

    @Override
    public List<Goodsmessage> selectRecycle(){
        return goodsmessageMapper.selectRecycle();
    }

    @Override
    public Goodsmessage selectById(String id){
        return goodsmessageMapper.selectById(id);
    }



    @Override
    public boolean updateBySpare01Open(String[] arr){
        if (goodsmessageMapper.updateBySpare01Open(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateBySpare01Out(String[] arr){
        if (goodsmessageMapper.updateBySpare01Out(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Goodsmessage> selectByMaterialCode(String merchantCode){
        return goodsmessageMapper.selectByMaterialCode(merchantCode);
    }

    @Override
    public List<Goodsmessage> selectByMaterialCodeAndName(String merchantCode,String name){
        return goodsmessageMapper.selectByMaterialCodeAndName(merchantCode,name);
    }
    @Override
    public List<Goodsmessage> selectByMaterialCodeAndNameAndItemCode(String merchantCode,String name,String itemCode){
        return goodsmessageMapper.selectByMaterialCodeAndNameAndItemCode(merchantCode,name,itemCode);
    }


    @Override
    public List<Goodsmessage> selectByMaterialCodeAndNameAndSku(String merchantCode,String name,String sku){
        return goodsmessageMapper.selectByMaterialCodeAndNameAndSku(merchantCode,name,sku);
    }

    @Override
    public List<Goodsmessage> selectByMaterialCodeAndItemcode(String merchantCode,String itemCode){
        return goodsmessageMapper.selectByMaterialCodeAndItemcode(merchantCode,itemCode);
    }

    @Override
    public List<Goodsmessage> selectByMaterialCodeAndItemCodeAndSku(String merchantCode,String itemCode,String sku){
        return goodsmessageMapper.selectByMaterialCodeAndItemCodeAndSku(merchantCode,itemCode,sku);
    }

    @Override
    public List<Goodsmessage> selectByMaterialCodeAndSku(String merchantCode,String sku){
        return goodsmessageMapper.selectByMaterialCodeAndSku(merchantCode,sku);
    }

    @Override
    public List<Goodsmessage> selectByMaterialCodeAndNameAndItemCodeAndSku(String merchantCode,String name,String itemCode,String sku){
        return goodsmessageMapper.selectByMaterialCodeAndNameAndItemCodeAndSku(merchantCode,name,itemCode,sku);
    }

    @Override
    public List<Goodsmessage> selectByName(String name){
        return goodsmessageMapper.selectByName(name);
    }

    @Override
    public List<Goodsmessage> selectByNameAndItemCode(String name,String itemCode){
        return goodsmessageMapper.selectByNameAndItemCode(name,itemCode);
    }

    @Override
    public List<Goodsmessage> selectByNameAndSku(String name,String sku){
        return goodsmessageMapper.selectByNameAndSku(name,sku);
    }

    @Override
    public List<Goodsmessage> selectByNameAndItemCodeAndSku(String name,String itemCode,String sku) {
        return goodsmessageMapper.selectByNameAndItemCodeAndSku(name,itemCode,sku);
    }

    @Override
    public List<Goodsmessage> selectByItemCode(String itemCode){
        return goodsmessageMapper.selectByItemCode(itemCode);
    }

    @Override
    public List<Goodsmessage> selectByItemCodeAndSku(String itemCode,String sku){
        return goodsmessageMapper.selectByItemCodeAndSku(itemCode,sku);
    }

    @Override
    public List<Goodsmessage> selectBySku(String sku){
        return goodsmessageMapper.selectBySku(sku);
    }

    @Override
    public List<Goodsmessage> selectByOther(String other){
        return goodsmessageMapper.selectByOther(other);
    }

    @Override
    public List<Goodsmessage> selectByMerchantCodeR(String merchantCode){
        return goodsmessageMapper.selectByMerchantCodeR(merchantCode);
    }

    @Override
    public List<Goodsmessage> selectByNameR(String name){
        return goodsmessageMapper.selectByNameR(name);
    }

    @Override
    public List<Goodsmessage> selectByOtherR(String other){
        return goodsmessageMapper.selectByOtherR(other);
    }

    @Override
    public List<Goodsmessage> selectByMerchantCode(String merchantCode){
        return goodsmessageMapper.selectByMerchantCode(merchantCode);
    }

    @Override
    public List<Goodsmessage> selectByBarCode(String barCode){
        return goodsmessageMapper.selectByBarCode(barCode);
    }

}
