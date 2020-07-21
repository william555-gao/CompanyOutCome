package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.TechnosphereDO;
import com.company.example.springbootdemo.entity.TechnosphereDOExample;
import com.company.example.springbootdemo.entity.TechnosphereVO;
import com.company.example.springbootdemo.mapper.TechnosphereDOMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:TechnosphereServiceImpl
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 10:17
 * @Version: 1.0
 */

@Service
@Log4j2
public class TechnosphereServiceImpl implements TechnosphereService {
    @Resource
    private TechnosphereDOMapper technosphereDOMapper;

    @Override
    public List<TechnosphereVO> searchAllTechnosphere() {
        TechnosphereDOExample technosphereDOExample = new TechnosphereDOExample();
        List<TechnosphereDO> technosphereDOS = technosphereDOMapper.selectByExample(technosphereDOExample);
        List<TechnosphereVO> technosphereVOS = new ArrayList<>();
        for (TechnosphereDO tech : technosphereDOS) {
            technosphereVOS.add(transformToVO(tech));
        }
        return technosphereVOS;
    }

    private TechnosphereVO transformToVO(TechnosphereDO technosphereDO) {
        TechnosphereVO technosphereVO = new TechnosphereVO();
        technosphereVO.setTechnosphereName(technosphereDO.getTechnosphereName());
        technosphereVO.setTechnosphereDescription(technosphereDO.getTechnosphereDescription());
        return technosphereVO;
    }
}
