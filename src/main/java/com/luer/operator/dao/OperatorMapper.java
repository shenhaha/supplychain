package com.luer.operator.dao;

import com.luer.operator.bean.Operator;
import com.luer.operator.bean.OperatorExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OperatorMapper {
    int countByExample(OperatorExample example);

    int deleteByExample(OperatorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Operator record);

    int insertSelective(Operator record);

    List<Operator> selectByExample(OperatorExample example);

    Operator selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByExample(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByPrimaryKeySelective(Operator record);

    int updateByPrimaryKey(Operator record);

    Operator selectOperatorById(String id);

    void insertOperator(Operator operator);

    String selectPasswordByUsername(String id);

    void deleteById(String id);

    Operator selectOperatorByUsername(String username);

    int count();

    List<Operator> findListDataPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<Operator> select();

}