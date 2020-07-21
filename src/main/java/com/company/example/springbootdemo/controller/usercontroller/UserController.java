package com.company.example.springbootdemo.controller.usercontroller;

import com.company.example.springbootdemo.entity.LoginBO;
import com.company.example.springbootdemo.entity.LoginVO;
import com.company.example.springbootdemo.service.fileservice.FileUploadService;
import com.company.example.springbootdemo.service.fileservice.FileUploadServiceImpl;
import com.company.example.springbootdemo.service.userservice.UserService;
import com.company.example.springbootdemo.service.userservice.UserServiceImpl;
import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:UserController
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/5/29 17:15
 * @Version: 1.0
 */

@Controller
@Log4j2
@RequestMapping(value = "/usermanage")
public class UserController {

    @Resource
    private UserService userServiceImpl;
    @Resource
    private FileUploadService fileUploadServiceImpl;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveUser(LoginBO loginBO, @RequestParam("realpath") MultipartFile businessLicense, @RequestParam("realpath1") MultipartFile certificate, @RequestParam("realpath2") MultipartFile headPortraits) {
        ModelAndView mav = Utils.getMav("/register");
        LoginBO resultBO = null;
        //设置文件输出到服务器的路径(根据不同的用户创建不同的文件路径)
        if (CommonConstant.COMPANY_USER.equals(loginBO.getUserTypeCode())) {
            if (Utils.isNull(businessLicense.getOriginalFilename())) {
                mav.addObject("doesnotselectfile", "请选择营业执照图片");
                return mav;
            }
            //设置企业 营业执照文件夹 BusinessLicense
            String companyFloder = "\\BusinessLicense\\";
            resultBO = fileUploadServiceImpl.uploadFile(businessLicense, companyFloder, loginBO.getCompanyName());
        } else {
            if (Utils.isNull(headPortraits.getOriginalFilename())) {
                mav.addObject("doesnotselectfile", "请选择头像图片");
                return mav;
            }
            if (Utils.isNull(certificate.getOriginalFilename())) {
                mav.addObject("doesnotselectfile", "请选择营证书附件图片");
                return mav;
            }
            //设置技术经理/专家 头像文件夹 HeadPortraits
            String personFloderHead = "\\HeadPortraits\\";
            //设置技术经理/专家 证书附件文件夹 Certificate
            String personFloderCertificate = "\\Certificate\\";
            resultBO = fileUploadServiceImpl.uploadFiles(headPortraits, certificate, personFloderHead, personFloderCertificate, loginBO.getStaffName());

        }
        if (FileUploadServiceImpl.FILE_TYPE_ERROR.equals(resultBO.getResultStatusCode())) {
            mav.addObject("fileTypeError", "文件类型异常");
            return mav;
        } else if (FileUploadServiceImpl.INPUT_PARAM_ERROR.equals(resultBO.getResultStatusCode())) {
            mav.addObject("inputParamError", "传输文件异常");
            return mav;
        } else if (FileUploadServiceImpl.TRANSFORM_IMAGE_ERROR.equals(resultBO.getResultStatusCode())) {
            mav.addObject("transformImageError", "图片文件转换异常");
            return mav;
        }
        log.info("新用户注册功能开始");
        String registerResult = userServiceImpl.registerLoginUser(loginBO);
        String userName = CommonConstant.COMPANY_USER.equals(loginBO.getUserTypeCode()) ? loginBO.getCompanyName() : loginBO.getStaffName();
        if (CommonConstant.RETURN_KEY_SUCCESS.equals(registerResult)) {
            mav.addObject("registerUserSucesss", "注册信息成功");
            log.info("新用户: " + userName + " ; 注册信息成功");
        } else if (UserServiceImpl.CREATE_DATAUSER_ERROR.equals(registerResult)) {
            mav.addObject("registerUserFailed", "注册信息失败");
            log.info("新用户: " + userName + " ; 注册信息失败");
        }
        return mav;
    }

    @RequestMapping(value = "/checkphonenum", method = RequestMethod.POST)
    @ResponseBody
    public LoginVO selectLoginUserByPhoneNum(HttpServletRequest request, HttpServletResponse response) {
        String phonenum = Utils.getParameterFromRequest(request, "phonenum");
        LoginBO loginBO = new LoginBO();
        loginBO.setPhoneNumber(phonenum);
        LoginVO loginVO = userServiceImpl.selectByCondition(loginBO);
        if (CommonConstant.RETURN_KEY_SUCCESS.equals(loginVO.getResultStatusCode())) {
            log.info("当前手机号可用");
        }
        return loginVO;
    }

    @RequestMapping(value = "/checkemail", method = RequestMethod.POST)
    @ResponseBody
    public LoginVO selectLoginUserByEmail(HttpServletRequest request, HttpServletResponse response) {
        String email = Utils.getParameterFromRequest(request, "email");
        LoginBO loginBO = new LoginBO();
        loginBO.setEmail(email);
        LoginVO loginVO = userServiceImpl.selectByCondition(loginBO);
        if (CommonConstant.RETURN_KEY_SUCCESS.equals(loginVO.getResultStatusCode())) {
            log.info("当前邮件账号可用");
        }
        return loginVO;
    }


}
