package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.IndustryDO;
import com.company.example.springbootdemo.entity.IndustryDOExample;
import com.company.example.springbootdemo.entity.IndustryVO;
import com.company.example.springbootdemo.mapper.IndustryDOMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:IndustryServiceImpl
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 10:17
 * @Version: 1.0
 */
@Service
@Log4j2
public class IndustryServiceImpl implements IndustryService {

    @Resource
    private IndustryDOMapper industryDOMapper;

    @Override
    public List<IndustryVO> searchAllIndustry() {
        IndustryDOExample industryDOExample = new IndustryDOExample();
        List<IndustryDO> industryDOS = industryDOMapper.selectByExample(industryDOExample);
        ArrayList<IndustryVO> industryVOS = new ArrayList<>();
        for (IndustryDO industry : industryDOS) {
            industryVOS.add(transformToVO(industry));
        }
        return industryVOS;
    }

    private IndustryVO transformToVO(IndustryDO industryDO) {
        IndustryVO industryVO = new IndustryVO();
        industryVO.setIndustryName(industryDO.getIndustryName());
        industryVO.setIndustryDescription(industryDO.getIndustryDescription());

        return industryVO;

    }
}
