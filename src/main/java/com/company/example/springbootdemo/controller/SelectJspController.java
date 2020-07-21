package com.company.example.springbootdemo.controller;

import com.company.example.springbootdemo.entity.IndustryVO;
import com.company.example.springbootdemo.entity.TechnosphereVO;
import com.company.example.springbootdemo.service.companyservice.IndustryService;
import com.company.example.springbootdemo.service.companyservice.TechnosphereService;
import com.company.example.springbootdemo.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName:SelectJspController
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/7 8:21
 * @Version: 1.0
 */
@Controller
@RequestMapping("/forward")
public class SelectJspController {

    @Resource
    private IndustryService industryServiceImpl;

    @Resource
    private TechnosphereService technosphereServiceImpl;

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转用户注册页面
     * @Date 8:58 2020/7/9
     * @Param []
     **/
    @RequestMapping("/registerjsp")
    public String jumpRegiest() {
        return "/register";
    }

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转用户详情信息页面
     * @Date 8:59 2020/7/9
     * @Param []
     **/
    @RequestMapping("/personalDetails")
    public String jumpPersonalDetails() {
        return "/user/personalDetails";
    }

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转企业成果信息注册页面
     * @Date 8:59 2020/7/9
     * @Param []
     **/
    @RequestMapping(value = "/addcompanyoutcomeinformation", method = RequestMethod.GET)
    public ModelAndView jumpAddcompanyoutcomeinformation(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = Utils.getMav("/company/addcompanyoutcomeinformation");
        List<IndustryVO> industryVOS = industryServiceImpl.searchAllIndustry();
        List<TechnosphereVO> technosphereVOS = technosphereServiceImpl.searchAllTechnosphere();
        mav.addObject("industryList", industryVOS);
        mav.addObject("technosphereList", technosphereVOS);
        return mav;
    }

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转企业成果信息发布页面
     * @Date 8:59 2020/7/9
     * @Param []
     **/
    @RequestMapping("/companyoutcomepublish")
    public String jumpCompanyoutcomepublish() {
        return "/company/companyoutcomepublish";
    }

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转企业信息审核页面
     * @Date 9:00 2020/7/9
     * @Param []
     **/
    @RequestMapping("/check")
    public String jumpCheck() {
        return "/user/check";
    }

    /**
     * @return java.lang.String
     * @Author:Gaoww
     * @Description: 跳转企业信息评价页面
     * @Date 9:00 2020/7/9
     * @Param []
     **/
    @RequestMapping("/appraise")
    public String jumpAppraise() {
        return "/user/appraise";
    }
}
