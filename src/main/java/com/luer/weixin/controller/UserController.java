package com.luer.weixin.controller;


import com.luer.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getAllSubscribeAmount")
    public int getAllSubscribeAmount(){
        return userService.getAllSubscribeAmount();
    }


}
