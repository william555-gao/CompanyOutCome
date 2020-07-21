package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.IndustryDO;
import com.company.example.springbootdemo.entity.IndustryDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryDOMapper {
    long countByExample(IndustryDOExample example);

    int deleteByExample(IndustryDOExample example);

    int deleteByPrimaryKey(Integer industryId);

    int insert(IndustryDO record);

    int insertSelective(IndustryDO record);

    List<IndustryDO> selectByExample(IndustryDOExample example);

    IndustryDO selectByPrimaryKey(Integer industryId);

    int updateByExampleSelective(@Param("record") IndustryDO record, @Param("example") IndustryDOExample example);

    int updateByExample(@Param("record") IndustryDO record, @Param("example") IndustryDOExample example);

    int updateByPrimaryKeySelective(IndustryDO record);

    int updateByPrimaryKey(IndustryDO record);
}