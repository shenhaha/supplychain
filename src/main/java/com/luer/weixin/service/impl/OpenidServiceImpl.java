package com.luer.weixin.service.impl;

import com.luer.comm.utils.ResultSet;
import com.luer.weixin.bean.Openid;
import com.luer.weixin.dao.OpenidMapper;
import com.luer.weixin.service.OpenidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenidServiceImpl implements OpenidService {

    @Autowired
    OpenidMapper openidMapper;

    @Override
    public int insert(Openid record){
        return openidMapper.insert(record);
    }

    @Override
    public List<String> selectOpenidList(){
        return openidMapper.selectOpenidList();
    }
}
