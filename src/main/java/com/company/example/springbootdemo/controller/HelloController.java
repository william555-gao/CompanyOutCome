package com.company.example.springbootdemo.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Log4j2
public class HelloController {

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转到公司登录页面
     * @Date 9:01 2020/7/9
     * @Param []
     **/
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("欢迎进入公司成果展示登录页面");
        return "login";
    }
}
