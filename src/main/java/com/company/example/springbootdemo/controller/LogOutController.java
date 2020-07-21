package com.company.example.springbootdemo.controller;

import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName:LogOutController
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/8 16:54
 * @Version: 1.0
 */
@Controller
@Log4j2
public class LogOutController {

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author:Gaoww
     * @Description: 用户登出 并跳转到登录页面
     * @Date 9:01 2020/7/9
     * @Param [request, response]
     **/
    @RequestMapping(value = "/out_ls", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Object attribute = request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
        if (session != null && attribute != null) {
            request.getSession(false).removeAttribute(CommonConstant.SESSION_USER);
            log.info("clear session");
        }
        ModelAndView mav = Utils.getMav("redirect:/hello");
        return mav;
    }
}
