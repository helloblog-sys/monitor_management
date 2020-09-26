package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.AlarmMapper;
import com.microthings.monitor_management.pojo.Alarm;
import com.microthings.monitor_management.pojo.AlarmExample;
import com.microthings.monitor_management.util.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**告警信息Service
 * @author ThreeStone
 * @date 2020/9/21 - 15:30
 **/
@Service
public class AlarmService {

    private static Logger logger = LoggerFactory.getLogger(AlarmService.class);

    @Resource
    private AlarmMapper alarmMapper;

    //获取所有告警信息
    public List<Alarm> getAlarmList(){
        return  alarmMapper.selectByExample(null);
    }

    //删除告警信息
    public void deleteAlarm(Integer alarmId){
        alarmMapper.deleteByPrimaryKey(alarmId);
    }

    //修改告警信息
    public AjaxResponse updateAlarm(Alarm alarm){
        AlarmExample alarmExample = new AlarmExample();
        alarmExample.or().andAlarmidEqualTo(alarm.getAlarmid());
        List<Alarm> alarmList = alarmMapper.selectByExample(alarmExample);
        if(!alarmList.isEmpty() && (!alarmList.get(0).getAlarmid().equals(alarm.getAlarmid()))){
            return AjaxResponse.ADD_ALARM_EXIST;
        } else {
            alarmMapper.updateByPrimaryKeySelective(alarm);
            return AjaxResponse.OK;
        }
    }

    //添加告警信息
    public AjaxResponse addAlarm(Alarm alarm){
        AlarmExample alarmExample = new AlarmExample();
        alarmExample.or().andAlarmcontentEqualTo(alarm.getAlarmcontent());
        List<Alarm> alarmList = alarmMapper.selectByExample(alarmExample);
        if(!alarmList.isEmpty()){
            return AjaxResponse.ADD_ALARM_EXIST;
        }
        else {
            alarmMapper.insert(alarm);
            return AjaxResponse.OK;
        }
    }
}