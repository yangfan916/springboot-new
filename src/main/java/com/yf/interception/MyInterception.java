package com.yf.interception;

import com.yf.config.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterception implements HandlerInterceptor {

    @Autowired
    private Resource resource;

    //预处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterception preHandle ......");
        System.out.println(resource.getImageServer());
        //是否放行
        return true;
    }
}
