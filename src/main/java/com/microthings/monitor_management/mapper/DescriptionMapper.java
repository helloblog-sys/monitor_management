package com.microthings.monitor_management.mapper;

import com.microthings.monitor_management.pojo.Description;
import com.microthings.monitor_management.pojo.DescriptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DescriptionMapper {
    long countByExample(DescriptionExample example);

    int deleteByExample(DescriptionExample example);

    int deleteByPrimaryKey(Integer descriptionId);

    int insert(Description record);

    int insertSelective(Description record);

    List<Description> selectByExampleWithBLOBs(DescriptionExample example);

    List<Description> selectByExample(DescriptionExample example);

    Description selectByPrimaryKey(Integer descriptionId);

    int updateByExampleSelective(@Param("record") Description record, @Param("example") DescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Description record, @Param("example") DescriptionExample example);

    int updateByExample(@Param("record") Description record, @Param("example") DescriptionExample example);

    int updateByPrimaryKeySelective(Description record);

    int updateByPrimaryKeyWithBLOBs(Description record);

    int updateByPrimaryKey(Description record);
}