package com.yf.controller;

import com.yf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("hello")
    public String hello(Model model){

        int a = 1/0;

        model.addAttribute("name", "杨帆");
        model.addAttribute("age", 18);

        List<User> list = new ArrayList<>();
        list.add(new User(1, "zhangsan", new Date()));
        list.add(new User(2, "lisi", new Date()));
        model.addAttribute("list", list);

        model.addAttribute("now", new Date());
        return "hello";
    }
}
