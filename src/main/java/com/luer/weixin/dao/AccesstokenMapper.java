package com.luer.weixin.dao;

import com.luer.weixin.bean.Accesstoken;
import com.luer.weixin.bean.AccesstokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccesstokenMapper {
    int countByExample(AccesstokenExample example);

    int deleteByExample(AccesstokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accesstoken record);

    int insertSelective(Accesstoken record);

    List<Accesstoken> selectByExample(AccesstokenExample example);

    Accesstoken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accesstoken record, @Param("example") AccesstokenExample example);

    int updateByExample(@Param("record") Accesstoken record, @Param("example") AccesstokenExample example);

    int updateByPrimaryKeySelective(Accesstoken record);

    int updateByPrimaryKey(Accesstoken record);
}