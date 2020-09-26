package com.microthings.monitor_management.mapper;

import com.microthings.monitor_management.pojo.Alarm;
import com.microthings.monitor_management.pojo.AlarmExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmMapper {
    long countByExample(AlarmExample example);

    int deleteByExample(AlarmExample example);

    int deleteByPrimaryKey(Integer alarmid);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    List<Alarm> selectByExample(AlarmExample example);

    Alarm selectByPrimaryKey(Integer alarmid);

    int updateByExampleSelective(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByExample(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);
}