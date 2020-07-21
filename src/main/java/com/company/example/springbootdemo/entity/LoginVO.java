package com.company.example.springbootdemo.entity;

import lombok.Data;

/**
 * @ClassName:LoginVO
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/6 15:21
 * @Version: 1.0
 */
@Data
public class LoginVO extends BaseResponse {

    /**
     * @Author:Gaoww
     * @Description: 用户登录名
     * @Date 15:35 2020/7/7
     * @Param
     * @return
     **/
    private String username;
    /**
     * @Author:Gaoww
     * @Description: 用户类型
     * @Date 15:35 2020/7/7
     * @Param
     * @return
     **/
    private String usertype;
    /**
     * @Author:Gaoww
     * @Description:用户状态
     * @Date 15:35 2020/7/7
     * @Param
     * @return
     **/
    private String status;

    private String companyName;


}
