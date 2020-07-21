package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.OutcomeInformationDO;
import com.company.example.springbootdemo.entity.OutcomeInformationDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutcomeInformationDOMapper {
    long countByExample(OutcomeInformationDOExample example);

    int deleteByExample(OutcomeInformationDOExample example);

    int deleteByPrimaryKey(Integer outcomeId);

    int insert(OutcomeInformationDO record);

    int insertSelective(OutcomeInformationDO record);

    List<OutcomeInformationDO> selectByExample(OutcomeInformationDOExample example);

    OutcomeInformationDO selectByPrimaryKey(Integer outcomeId);

    int updateByExampleSelective(@Param("record") OutcomeInformationDO record, @Param("example") OutcomeInformationDOExample example);

    int updateByExample(@Param("record") OutcomeInformationDO record, @Param("example") OutcomeInformationDOExample example);

    int updateByPrimaryKeySelective(OutcomeInformationDO record);

    int updateByPrimaryKey(OutcomeInformationDO record);
}