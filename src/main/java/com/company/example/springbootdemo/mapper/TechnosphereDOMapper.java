package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.TechnosphereDO;
import com.company.example.springbootdemo.entity.TechnosphereDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnosphereDOMapper {
    long countByExample(TechnosphereDOExample example);

    int deleteByExample(TechnosphereDOExample example);

    int deleteByPrimaryKey(Integer technosphereId);

    int insert(TechnosphereDO record);

    int insertSelective(TechnosphereDO record);

    List<TechnosphereDO> selectByExample(TechnosphereDOExample example);

    TechnosphereDO selectByPrimaryKey(Integer technosphereId);

    int updateByExampleSelective(@Param("record") TechnosphereDO record, @Param("example") TechnosphereDOExample example);

    int updateByExample(@Param("record") TechnosphereDO record, @Param("example") TechnosphereDOExample example);

    int updateByPrimaryKeySelective(TechnosphereDO record);

    int updateByPrimaryKey(TechnosphereDO record);
}