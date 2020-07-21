package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.TechnosphereVO;

import java.util.List;

/**
 * @ClassName:TechnosphereService
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 10:17
 * @Version: 1.0
 */
public interface TechnosphereService {

    List<TechnosphereVO> searchAllTechnosphere();
}
