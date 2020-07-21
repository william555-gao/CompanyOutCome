package com.company.example.springbootdemo.service.userservice;

import com.company.example.springbootdemo.entity.LoginBO;
import com.company.example.springbootdemo.entity.LoginVO;

/**
 * @ClassName:UserManager
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/6 15:13
 * @Version: 1.0
 */
public interface UserService {

    LoginVO login(LoginBO loginBO);

    String registerLoginUser(LoginBO loginBO);

    LoginVO selectByCondition(LoginBO loginBO);
}
