package com.company.example.springbootdemo.controller;

import com.company.example.springbootdemo.entity.LoginBO;
import com.company.example.springbootdemo.entity.LoginVO;
import com.company.example.springbootdemo.service.userservice.UserService;
import com.company.example.springbootdemo.service.userservice.UserServiceImpl;
import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:LoginController
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/5/29 16:45
 * @Version: 1.0
 */
@Controller
@Log4j2
@RequestMapping(value = "/usermanager")
public class LoginController {

    private static final String LOING_FAILD_CODE_NUM = "A0200";

    @Resource
    private UserService userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginBO loginBO, HttpServletRequest request) {
        ModelAndView mavlogin = Utils.getMav("/login");
        String verifyCode = loginBO.getVerifyCode();
        if (!Utils.isNull(verifyCode)) {
            if (!verifyCode.equalsIgnoreCase(request.getSession().getAttribute("code").toString())) {
                mavlogin.addObject("vcError", "验证码错误,请重新输入");
                return mavlogin;
            }
        } else {
            mavlogin.addObject("emptyVC", "请输入验证码");
            return mavlogin;
        }

        LoginVO loginVO = userServiceImpl.login(loginBO);
        if (UserServiceImpl.LOGIN_USER_EMPTY.equals(loginVO.getResultStatusCode())) {
            mavlogin.addObject("userEmpty", "用户不存在请前往注册!");
            log.info("用户不存在请前往注册!");
        } else if (UserServiceImpl.LOING_USER_PASSWORD_FAILED.equals(loginVO.getResultStatusCode())) {
            mavlogin.addObject("passwordFaild", "用户名或密码错误,请重新输入");
            log.info("用户名或密码错误,请重新输入");
        } else {
            ModelAndView loginSuccess = Utils.getMav("/index");
            loginSuccess.addObject("loginSuccess", "登录成功");
            request.getSession(false).setAttribute(CommonConstant.SESSION_USER, loginVO);
            log.info("登录执行成功");
            log.info("当前登录用户:" + loginBO.getLoginName() + "; 登录时间:" + Utils.getTimeString("yyyy-MM-dd HH:mm:ss") + "登录IP地址:" + Utils.getIpAddress(request));
            return loginSuccess;
        }
        return mavlogin;
    }


}
