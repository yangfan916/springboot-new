package com.yf.config;

import com.yf.interception.MyInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterception myInterception;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加我们的拦截器配置
        //new MyInterception() 他不属于 spring 管理
        registry.addInterceptor(myInterception).addPathPatterns("/**");
    }
}
