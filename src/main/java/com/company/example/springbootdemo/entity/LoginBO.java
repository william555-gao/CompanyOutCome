package com.company.example.springbootdemo.entity;

import lombok.Data;

/**
 * @ClassName:LoginBO
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/6 15:19
 * @Version: 1.0
 */
@Data
public class LoginBO extends BaseResponse {

    private String verifyCode;
    /**
     * @Author:Gaoww
     * @Description: 登录名
     * @Date 15:23 2020/7/6
     * @Param
     * @return
     **/
    private String loginName;

    /**
     * @Author:Gaoww
     * @Description: 登录密码
     * @Date 15:23 2020/7/6
     * @Param
     * @return
     **/
    private String password;
    /**
     * @Author:Gaoww
     * @Description:用户联系号码
     * @Date 15:36 2020/7/7
     * @Param
     * @return
     **/
    private String phoneNumber;
    /**
     * @Author:Gaoww
     * @Description:用户邮箱
     * @Date 15:36 2020/7/7
     * @Param
     * @return
     **/
    private String email;

    private String userTypeCode;
    private String companyName;
    private String companyCreditCode;
    private String companyLegalPerson;
    private String companyPhonenNumber;
    private String staffDepartment;
    private String staffName;
    private String staffSex;
    private String staffBirthday;
    private String staffPhone;
    private String staffEmail;
    private String staffIDCard;
    private String staffLocation;
    private String staffDomain;
    private String staffDescription;
    private String companyImageUrl;
    private String staffProfilePhotoUrl;
    private String staffCertifficareUrl;
}
