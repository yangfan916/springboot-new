package com.yf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yf.config.Resource;
import com.yf.entity.TUser;
import com.yf.entity.User;
import com.yf.pojo.ResultBean;
import com.yf.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("user")
public class HelloController {

    @Value("${resource.imageServer}")
    private String imageServerPath;
    @Autowired
    private Resource resource;
    @Autowired
    private TUserService userService;

    @RequestMapping("hello")
    public String hello(){
        return "hello,springboot!11111111";
    }

    @GetMapping("{id}")
    public TUser getUserById(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        return userService.getUserById(id);
    }

    @PostMapping("add")
    public ResultBean add(@Valid User user) throws JsonProcessingException {
        //判断数据校验是否通过
        /*if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            //保存错误信息的map
            Map<String, String> map = new HashMap<>();
            for(FieldError fieldError : fieldErrors){
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                log.error("[{}] : [{}] ", field, message);
                map.put(field, message);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            //将对象转换为json
            String json = objectMapper.writeValueAsString(map);

            return new ResultBean("filed", json);
        }*/
        //AOP将核心业务逻辑和非核心业务逻辑做分离
        //数据检验就可以放到拦截器那边去做

        log.info("模拟实现了用户的添加");
        return new ResultBean("success", "ok");
    }

    @GetMapping("getImagePath")
    public String getImageServerPath(){
        String emailPath = resource.getEmailServer();
        return "图片服务器地址：" + imageServerPath + "邮箱服务器地址：" + emailPath;
    }
}
