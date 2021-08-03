package com.luer.weixin.service;

import com.luer.weixin.bean.Openid;

import java.util.List;

public interface OpenidService {

    int insert(Openid record);
    List<String> selectOpenidList();
}
