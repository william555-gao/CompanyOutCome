package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.CompanyInformationDO;
import com.company.example.springbootdemo.entity.CompanyInformationDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInformationDOMapper {
    long countByExample(CompanyInformationDOExample example);

    int deleteByExample(CompanyInformationDOExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(CompanyInformationDO record);

    int insertSelective(CompanyInformationDO record);

    List<CompanyInformationDO> selectByExample(CompanyInformationDOExample example);

    CompanyInformationDO selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") CompanyInformationDO record, @Param("example") CompanyInformationDOExample example);

    int updateByExample(@Param("record") CompanyInformationDO record, @Param("example") CompanyInformationDOExample example);

    int updateByPrimaryKeySelective(CompanyInformationDO record);

    int updateByPrimaryKey(CompanyInformationDO record);
}