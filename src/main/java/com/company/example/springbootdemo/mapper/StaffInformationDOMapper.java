package com.company.example.springbootdemo.mapper;

import com.company.example.springbootdemo.entity.StaffInformationDO;
import com.company.example.springbootdemo.entity.StaffInformationDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffInformationDOMapper {
    long countByExample(StaffInformationDOExample example);

    int deleteByExample(StaffInformationDOExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(StaffInformationDO record);

    int insertSelective(StaffInformationDO record);

    List<StaffInformationDO> selectByExample(StaffInformationDOExample example);

    StaffInformationDO selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") StaffInformationDO record, @Param("example") StaffInformationDOExample example);

    int updateByExample(@Param("record") StaffInformationDO record, @Param("example") StaffInformationDOExample example);

    int updateByPrimaryKeySelective(StaffInformationDO record);

    int updateByPrimaryKey(StaffInformationDO record);
}