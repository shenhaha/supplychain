package com.luer.config;


import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello/index").setViewName("/index");
        //registry.addViewController("/operator/selectOperatorById").setViewName("/index");
        //添加更多
    }

}

