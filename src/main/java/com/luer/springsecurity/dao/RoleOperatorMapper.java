package com.luer.springsecurity.dao;

import com.luer.springsecurity.bean.RoleOperator;
import com.luer.springsecurity.bean.RoleOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleOperatorMapper {
    int countByExample(RoleOperatorExample example);

    int deleteByExample(RoleOperatorExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleOperator record);

    int insertSelective(RoleOperator record);

    List<RoleOperator> selectByExample(RoleOperatorExample example);

    RoleOperator selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleOperator record, @Param("example") RoleOperatorExample example);

    int updateByExample(@Param("record") RoleOperator record, @Param("example") RoleOperatorExample example);

    int updateByPrimaryKeySelective(RoleOperator record);

    int updateByPrimaryKey(RoleOperator record);
}