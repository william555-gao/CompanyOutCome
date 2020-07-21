package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.IndustryVO;

import java.util.List;

/**
 * @ClassName:IndustryService
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 10:16
 * @Version: 1.0
 */
public interface IndustryService {

    List<IndustryVO> searchAllIndustry();

}
