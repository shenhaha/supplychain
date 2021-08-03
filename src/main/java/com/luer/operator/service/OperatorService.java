package com.luer.operator.service;

import com.luer.operator.bean.Operator;

import java.util.List;

public interface OperatorService {
     Operator selectOperatorById(String id);

     //void insertOperator(Operator operator);

     String selectPasswordByUsername(String id);

     void deleteById(String id);

     void insertSelective (Operator operator);

     Operator selectOperatorByUsername(String username);

     int count();

     List<Operator> findListDataPage(int pageNum, int pageSize);

     int insert(Operator operator);

     List<Operator> select();


}
