package com.luer.purchase.service.impl;


import com.luer.comm.utils.UUIDUtils;
import com.luer.purchase.bean.Purchasedetail;
import com.luer.purchase.bean.PurchasedetailExample;
import com.luer.purchase.dao.PurchasedetailMapper;
import com.luer.purchase.service.PurchasedetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchasedetailServiceImpl implements PurchasedetailService {


    @Autowired
    PurchasedetailMapper detailMapper;

    @Override
    public int insert(Purchasedetail purchasedetail){
        purchasedetail.setId(UUIDUtils.getUUID());
        purchasedetail.setCreateTime(new Date());
        return detailMapper.insert(purchasedetail);
    }

    @Override
   public List<Purchasedetail> select(){
        return detailMapper.select();
   }

    @Override
    public boolean deleteByIds(String[] arr) {
        if (detailMapper.deleteByIds(arr)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int updateById(String id, Purchasedetail purchasedetail) {
        purchasedetail.setUpdateTime(new Date());
        PurchasedetailExample purchasedetailExample = new PurchasedetailExample();
        PurchasedetailExample.Criteria criteria = purchasedetailExample.createCriteria();
        criteria.andIdEqualTo(id);
        return detailMapper.updateByExampleSelective(purchasedetail, purchasedetailExample);
    }

    @Override
    public Purchasedetail selectById(String id){
        return detailMapper.selectById(id);
    }

    @Override
    public List<Purchasedetail> selectByPurchaseNumber(String purchaseNumber){
        return detailMapper.selectByPurchaseNumber(purchaseNumber);
    }


    @Override
    public int deleteByPNumber(String purchaseNumber){
        return detailMapper.deleteByPNumber(purchaseNumber);
    }





}
