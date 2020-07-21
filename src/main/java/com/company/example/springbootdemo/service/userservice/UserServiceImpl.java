package com.company.example.springbootdemo.service.userservice;

import com.company.example.springbootdemo.entity.*;
import com.company.example.springbootdemo.mapper.CompanyInformationDOMapper;
import com.company.example.springbootdemo.mapper.CompanyLoginDOMapper;
import com.company.example.springbootdemo.mapper.StaffInformationDOMapper;
import com.company.example.springbootdemo.util.AESEncryptUtil;
import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/6 15:15
 * @Version: 1.0
 */
@Service("userServiceImpl")
@Log4j2
public class UserServiceImpl implements UserService {

    public static final String LOGIN_USER_EMPTY = "A0201";
    public static final String LOING_USER_PASSWORD_FAILED = "A0210";
    public static final String CREATE_DATAUSER_ERROR = "A2004";

    @Resource
    private CompanyLoginDOMapper loginDOMapper;

    @Resource
    private CompanyInformationDOMapper companyInformationDOMapper;

    @Resource
    private StaffInformationDOMapper staffInformationDOMapper;


    @Override
    public LoginVO login(LoginBO loginBO) {
        CompanyLoginDOExample loginDOExample = new CompanyLoginDOExample();
        CompanyLoginDOExample.Criteria criteria = loginDOExample.createCriteria();
        CompanyLoginDOExample.Criteria or = loginDOExample.or();
        criteria.andUserEmailEqualTo(loginBO.getLoginName());
        or.andUserPhoneEqualTo(loginBO.getLoginName());
        LoginVO loginVO = new LoginVO();
        List<CompanyLoginDO> companyLoginDOS = loginDOMapper.selectByExample(loginDOExample);
        if (companyLoginDOS.isEmpty()) {
            loginVO.setResultStatusCode(LOGIN_USER_EMPTY);
            loginVO.setUsername(loginBO.getLoginName());
            return loginVO;
        } else {
            String reqPass = loginBO.getPassword();
            String dataPass = AESEncryptUtil.decrptionStr(companyLoginDOS.get(0).getUserPassword());
            if (!reqPass.equals(dataPass)) {
                loginVO.setResultStatusCode(LOING_USER_PASSWORD_FAILED);
                loginVO.setUsername(loginBO.getLoginName());
                return loginVO;
            }
        }
        loginVO.setUsername(loginBO.getLoginName());
        if (CommonConstant.COMPANY_USER.equals(loginBO.getUserTypeCode())) {
            String companyName = companyInformationDOMapper.selectByPrimaryKey(companyLoginDOS.get(0).getUserId()).getCompanyName();
            loginVO.setCompanyName(companyName);
        }
        loginVO.setResultStatusCode(CommonConstant.RETURN_KEY_SUCCESS);
        loginVO.setUsertype(companyLoginDOS.get(0).getUserType());
        return loginVO;
    }

    @Override
    public String registerLoginUser(LoginBO loginBO) {
        CompanyInformationDO companyInformationDO = new CompanyInformationDO();
        StaffInformationDO staffInformationDO = new StaffInformationDO();
        CompanyLoginDO companyLoginDO = new CompanyLoginDO();
        int companyId = 0;
        int staffId = 0;
        //获取并判断用户类型
        if (CommonConstant.COMPANY_USER.equals(loginBO.getUserTypeCode())) {
            //创建企业信息实例
            companyInformationDO.setCompanyCreditCode(Integer.valueOf(loginBO.getCompanyCreditCode()));
            companyInformationDO.setCompanyLegalPerson(loginBO.getCompanyLegalPerson());
            companyInformationDO.setCompanyName(loginBO.getCompanyName());
            companyInformationDO.setCompanyPhoneNum(loginBO.getCompanyPhonenNumber());
            companyInformationDO.setCompanyImageUrl(loginBO.getCompanyImageUrl());
            companyId = companyInformationDOMapper.insertSelective(companyInformationDO);
            if (companyId <= 0) {
                return CREATE_DATAUSER_ERROR;
            }
        } else {
            //创建员工信息实例
            staffInformationDO.setStaffProfilePhotoUrl(loginBO.getStaffProfilePhotoUrl());
            staffInformationDO.setStaffName(loginBO.getStaffName());
            staffInformationDO.setStaffDepartment(loginBO.getStaffDepartment());
            staffInformationDO.setStaffSex(loginBO.getStaffSex());
            staffInformationDO.setStaffBirthDay(Utils.getCnDateNew(loginBO.getStaffBirthday()));
            staffInformationDO.setStaffPhone(loginBO.getStaffPhone());
            staffInformationDO.setStaffEmail(loginBO.getStaffEmail());
            staffInformationDO.setStaffIdCard(loginBO.getStaffIDCard());
            staffInformationDO.setStaffLocation(loginBO.getStaffLocation());
            staffInformationDO.setStaffDomain(loginBO.getStaffDomain());
            staffInformationDO.setStaffCertifficareUrl(loginBO.getStaffCertifficareUrl());
            staffInformationDO.setStaffDescription(loginBO.getStaffDescription());
            staffId = staffInformationDOMapper.insertSelective(staffInformationDO);
            if (staffId <= 0) {
                return CREATE_DATAUSER_ERROR;
            }
        }
        //用户状态默认设置为 1 (1可用 0 不可用)
        companyLoginDO.setUserType("1");
        companyLoginDO.setUserStatus(loginBO.getUserTypeCode());
        companyLoginDO.setUserPassword(AESEncryptUtil.encryptionStr(loginBO.getPassword()));
        if (!CommonConstant.COMPANY_USER.equals(loginBO.getUserTypeCode())) {
            companyLoginDO.setUserPhone(loginBO.getStaffPhone());
            companyLoginDO.setUserEmail(loginBO.getStaffEmail());
            companyLoginDO.setUserId(staffId);
        } else {
            companyLoginDO.setUserPhone(loginBO.getCompanyPhonenNumber());
            companyLoginDO.setUserId(companyId);
        }
        int num = loginDOMapper.insertSelective(companyLoginDO);
        if (num <= 0) {
            return CREATE_DATAUSER_ERROR;
        }

        return CommonConstant.RETURN_KEY_SUCCESS;
    }

    @Override
    public LoginVO selectByCondition(LoginBO loginBO) {
        CompanyLoginDOExample loginDOExample = new CompanyLoginDOExample();
        CompanyLoginDOExample.Criteria criteria = loginDOExample.createCriteria();
        if (Utils.isNull(loginBO.getPhoneNumber())) {
            criteria.andUserEmailEqualTo(loginBO.getEmail());
        } else {
            criteria.andUserPhoneEqualTo(loginBO.getPhoneNumber());
        }
        List<CompanyLoginDO> companyLoginDOS = loginDOMapper.selectByExample(loginDOExample);
        LoginVO loginVO = new LoginVO();
        if (companyLoginDOS.isEmpty()) {
            loginVO.setResultStatusCode(CommonConstant.RETURN_KEY_SUCCESS);
        } else {
            loginVO.setUsername(Utils.isNull(companyLoginDOS.get(0).getUserPhone()) ? companyLoginDOS.get(0).getUserPhone() : companyLoginDOS.get(0).getUserEmail());
            loginVO.setUsertype(companyLoginDOS.get(0).getUserType());
        }
        return loginVO;
    }


}
