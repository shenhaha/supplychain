package com.luer.operator.service.impl;

import com.luer.comm.utils.UUIDUtils;
import com.luer.operator.bean.Operator;
import com.luer.operator.dao.OperatorMapper;
import com.luer.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public Operator selectOperatorById(String id){
        return operatorMapper.selectOperatorById(id);
    }

    @Override
    public int insert(Operator operator){
        operator.setId(UUIDUtils.getUUID());
        operator.setCreateTime(new Date());
        return operatorMapper.insert(operator);
    }

    @Override
    public void insertSelective(Operator operator){
        operatorMapper.insertOperator(operator);
    }

    @Override
    public String selectPasswordByUsername(String id){
        return operatorMapper.selectPasswordByUsername(id);
    }

    @Override
    public void deleteById(String id){
        operatorMapper.deleteById(id);
    }

    @Override
    public Operator selectOperatorByUsername(String username){
        return operatorMapper.selectOperatorByUsername(username);

    }

    @Override
    public int count(){
        return operatorMapper.count();
    }

    @Override
    public List<Operator> findListDataPage(int pageNum,int pageSize){
        return operatorMapper.findListDataPage(pageNum,pageSize);
    }

    @Override
    public List<Operator> select(){
        return operatorMapper.select();
    }




}
