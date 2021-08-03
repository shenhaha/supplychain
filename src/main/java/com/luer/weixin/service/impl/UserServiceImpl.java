package com.luer.weixin.service.impl;

import com.luer.weixin.bean.User;
import com.luer.weixin.dao.UserMapper;
import com.luer.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user){
        userMapper.insert(user);
        return 1;
    }
    @Override
    public int getAllSubscribeAmount(){
        return userMapper.getAllSubscribeAmount();
    }

}
