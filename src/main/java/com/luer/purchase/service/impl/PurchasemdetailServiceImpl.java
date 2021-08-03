package com.luer.purchase.service.impl;


import com.luer.comm.utils.UUIDUtils;
import com.luer.purchase.bean.*;
import com.luer.purchase.dao.PurchasemdetailMapper;
import com.luer.purchase.service.PurchasemdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchasemdetailServiceImpl implements PurchasemdetailService {

    @Autowired
    PurchasemdetailMapper mdetailMapper;

    @Override
    public List<Purchasemdetail> selectByPurchaseNumber(String purchaseNumber){
        return mdetailMapper.selectByPurchaseNumber(purchaseNumber);
    }

    @Override
    public int insert(Purchasemdetail purchasemdetail) {
        purchasemdetail.setId(UUIDUtils.getUUID());
        purchasemdetail.setCreateTime(new Date());
        return mdetailMapper.insert(purchasemdetail);
    }

    @Override
    public int deleteByPNumber(String purchaseNumber){
        return mdetailMapper.deleteByPNumber(purchaseNumber);
    }

    @Override
    public int updateById(String id, Purchasemdetail purchasemdetail) {
        purchasemdetail.setUpdateTime(new Date());
        PurchasemdetailExample purchasemdetailExample = new PurchasemdetailExample();
        PurchasemdetailExample.Criteria criteria = purchasemdetailExample.createCriteria();
        criteria.andIdEqualTo(id);
        return mdetailMapper.updateByExampleSelective(purchasemdetail, purchasemdetailExample);
    }

    @Override
    public Purchasemdetail selectById(String id){

        return mdetailMapper.selectById(id);

    }



}
