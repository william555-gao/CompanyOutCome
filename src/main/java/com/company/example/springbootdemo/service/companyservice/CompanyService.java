package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.OutcomeBO;
import com.company.example.springbootdemo.entity.OutcomeVO;

import java.util.List;

/**
 * @ClassName:CompanyService
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 9:12
 * @Version: 1.0
 */
public interface CompanyService {

    OutcomeVO saveOutcomeInformation(OutcomeBO outcomeBO);

    List<OutcomeVO> searchAllOutcomeInformation(OutcomeBO outcomeBO);


}
