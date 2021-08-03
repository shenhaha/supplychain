package com.luer.weixin.service;

import com.luer.weixin.bean.User;

public interface UserService {

    int insert(User user);
    int getAllSubscribeAmount();

}
