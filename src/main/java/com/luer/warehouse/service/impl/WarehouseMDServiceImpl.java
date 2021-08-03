package com.luer.warehouse.service.impl;


import com.luer.warehouse.bean.Warehousemdetail;
import com.luer.warehouse.bean.WarehousemdetailExample;
import com.luer.warehouse.dao.WarehousemdetailMapper;
import com.luer.warehouse.service.WarehouseMDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WarehouseMDServiceImpl implements WarehouseMDService {

    @Autowired
    WarehousemdetailMapper wMDMapper;


    @Override
    public int insert(Warehousemdetail warehousemdetail){

        return wMDMapper.insert(warehousemdetail);
    }

    @Override
    public int updateById(String id, Warehousemdetail warehousemdetail) {
        warehousemdetail.setUpdateTime(new Date());
        WarehousemdetailExample warehousemdetailExample = new WarehousemdetailExample();
        WarehousemdetailExample.Criteria criteria = warehousemdetailExample.createCriteria();
        criteria.andIdEqualTo(id);
        return wMDMapper.updateByExampleSelective(warehousemdetail, warehousemdetailExample);
    }


    @Override
    public int deleteByPNumber(String purchaseNumber){
        return wMDMapper.deleteByPNumber(purchaseNumber);
    }


    @Override
    public List<Warehousemdetail> selectByPurchaseNumber(String purchaseNumber){

        return wMDMapper.selectByPurchaseNumber(purchaseNumber);

    }

    @Override
    public List<Warehousemdetail> selectByOddNumber(String oddNumber){

        return wMDMapper.selectByOddNumber(oddNumber);

    }


}
