package com.luer.weixin.dao;

import com.luer.weixin.bean.Openid;
import com.luer.weixin.bean.OpenidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenidMapper {
    int countByExample(OpenidExample example);

    int deleteByExample(OpenidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Openid record);

    int insertSelective(Openid record);

    List<Openid> selectByExample(OpenidExample example);

    Openid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Openid record, @Param("example") OpenidExample example);

    int updateByExample(@Param("record") Openid record, @Param("example") OpenidExample example);

    int updateByPrimaryKeySelective(Openid record);

    int updateByPrimaryKey(Openid record);

    List<String> selectOpenidList();

    int getAllSubscribeAmount();

}