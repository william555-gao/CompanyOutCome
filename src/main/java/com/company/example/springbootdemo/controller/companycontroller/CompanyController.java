package com.company.example.springbootdemo.controller.companycontroller;

import com.company.example.springbootdemo.entity.LoginVO;
import com.company.example.springbootdemo.entity.OutcomeBO;
import com.company.example.springbootdemo.entity.OutcomeVO;
import com.company.example.springbootdemo.service.companyservice.CompanyService;
import com.company.example.springbootdemo.service.companyservice.CompanyServiceImpl;
import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:CompanyController
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 9:06
 * @Version: 1.0
 */
@Controller
@RequestMapping("/companymanager")
@Log4j2
public class CompanyController {

    @Resource
    private CompanyService companyServiceImpl;


    @RequestMapping(value = "/savecompanyoutcomeinformation", method = RequestMethod.POST)
    public ModelAndView saveOutcomeInformation(HttpServletRequest request, HttpServletResponse response) {
        LoginVO loginVO = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
        String outcomeName = Utils.getParameterFromRequest(request, "outcomeName");
        String trandsactionPrice = Utils.getParameterFromRequest(request, "trandsactionPrice");
        String maturity = Utils.getParameterFromRequest(request, "maturity");
        String domain = Utils.getParameterFromRequest(request, "domain");
        String cooperation = Utils.getParameterFromRequest(request, "cooperation");
        String useType = Utils.getParameterFromRequest(request, "useType");
        //创建业务层传输对象
        OutcomeBO outcomeBO = new OutcomeBO();
        outcomeBO.setOutcomeName(outcomeName);
        outcomeBO.setTrandsactionPrice(trandsactionPrice);
        outcomeBO.setMaturity(maturity);
        outcomeBO.setBelongDomain(domain);
        outcomeBO.setCooperationType(cooperation);
        outcomeBO.setCompanyName(loginVO.getCompanyName());
        OutcomeVO outcomeVO = companyServiceImpl.saveOutcomeInformation(outcomeBO);
        ModelAndView mav = Utils.getMav("/company/addcompanyoutcomeinformation.jsp");
        if (CompanyServiceImpl.SAVE_OUTCOME_FAILED.equals(outcomeVO.getResultStatusCode())) {
            mav.addObject("saveOutcomeFailed", "保存企业成果信息失败");
            log.info("保存企业成果信息失败");
        } else {
            mav.addObject("saveOutcomeSuccess", "保存企业成果信息成功");
            log.info("保存企业成果信息成功");
        }
        return mav;

    }

    @RequestMapping(value = "/searchoutcomeinfomation", method = RequestMethod.POST)
    public ModelAndView searchOutcomeInformation(HttpServletRequest request, HttpServletResponse response) {
        LoginVO loginVO = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);

        ModelAndView mav = Utils.getMav("");
        return mav;
    }
}
