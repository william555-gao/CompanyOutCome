package com.company.example.springbootdemo.service.companyservice;

import com.company.example.springbootdemo.entity.OutcomeBO;
import com.company.example.springbootdemo.entity.OutcomeInformationDO;
import com.company.example.springbootdemo.entity.OutcomeInformationDOExample;
import com.company.example.springbootdemo.entity.OutcomeVO;
import com.company.example.springbootdemo.mapper.OutcomeInformationDOMapper;
import com.company.example.springbootdemo.util.CommonConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:CompanyServiceImpl
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/9 9:12
 * @Version: 1.0
 */
@Service
@Log4j2
public class CompanyServiceImpl implements CompanyService {
    public static final String SAVE_OUTCOME_FAILED = "B0001";

    @Resource
    public OutcomeInformationDOMapper outcomeInformationDOMapper;


    @Override
    public OutcomeVO saveOutcomeInformation(OutcomeBO outcomeBO) {
        OutcomeVO outcomeVO = new OutcomeVO();
        OutcomeInformationDO outcomeInformationDO = new OutcomeInformationDO();
        outcomeInformationDO.setOutcomeName(outcomeBO.getOutcomeName());
        outcomeInformationDO.setBelongDomain(outcomeBO.getBelongDomain());
        outcomeInformationDO.setCooperationType(outcomeBO.getCooperationType());
        outcomeInformationDO.setTransactionPrice(outcomeBO.getTrandsactionPrice());
        outcomeInformationDO.setUseType(outcomeBO.getUseType());
        outcomeInformationDO.setMaturity(outcomeBO.getMaturity());
        outcomeInformationDO.setCompanyName(outcomeBO.getCompanyName());
        int result = outcomeInformationDOMapper.insertSelective(outcomeInformationDO);
        if (result > 0) {
            outcomeVO.setResultStatusCode(CommonConstant.RETURN_KEY_SUCCESS);
        } else {
            outcomeVO.setResultStatusCode(SAVE_OUTCOME_FAILED);
        }
        return outcomeVO;
    }

    @Override
    public List<OutcomeVO> searchAllOutcomeInformation(OutcomeBO outcomeBO) {
        OutcomeInformationDOExample outcomeInformationDOExample = new OutcomeInformationDOExample();
        OutcomeInformationDOExample.Criteria criteria = outcomeInformationDOExample.createCriteria();
        criteria.andCompanyNameEqualTo(outcomeBO.getCompanyName());
        List<OutcomeInformationDO> outcomeInformationDOS = outcomeInformationDOMapper.selectByExample(outcomeInformationDOExample);


        return null;
    }

    private OutcomeVO transformToVo(OutcomeInformationDO outcomeInformationDO) {
        OutcomeVO outcomeVO = new OutcomeVO();
        outcomeVO.setOutcomeName(outcomeInformationDO.getOutcomeName());
        outcomeVO.setBelongDomain(outcomeInformationDO.getBelongDomain());

        return outcomeVO;
    }
}
