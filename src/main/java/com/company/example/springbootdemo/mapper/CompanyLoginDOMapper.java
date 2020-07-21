package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.CompanyLoginDO;
import com.company.example.springbootdemo.entity.CompanyLoginDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyLoginDOMapper {
    long countByExample(CompanyLoginDOExample example);

    int deleteByExample(CompanyLoginDOExample example);

    int deleteByPrimaryKey(Integer loginUserId);

    int insert(CompanyLoginDO record);

    int insertSelective(CompanyLoginDO record);

    List<CompanyLoginDO> selectByExample(CompanyLoginDOExample example);

    CompanyLoginDO selectByPrimaryKey(Integer loginUserId);

    int updateByExampleSelective(@Param("record") CompanyLoginDO record, @Param("example") CompanyLoginDOExample example);

    int updateByExample(@Param("record") CompanyLoginDO record, @Param("example") CompanyLoginDOExample example);

    int updateByPrimaryKeySelective(CompanyLoginDO record);

    int updateByPrimaryKey(CompanyLoginDO record);
}