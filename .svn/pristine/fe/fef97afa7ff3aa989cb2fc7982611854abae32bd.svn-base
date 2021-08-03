package com.luer.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @author：EVEA
 * @date：2018/8/22 15:03
 * 国际化配置
 **/

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class LanguageConfig  extends WebMvcConfigurerAdapter {
    @Bean
    public LocaleResolver localeResolver(){
        //使用session解析
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //设置默认区域语言
        slr.setDefaultLocale(Locale.CHINESE);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        //根据参数改变默认语言
        lci.setParamName("language");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册改变语言的拦截器
        registry.addInterceptor(this.localeChangeInterceptor());
    }
}
