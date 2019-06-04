package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
