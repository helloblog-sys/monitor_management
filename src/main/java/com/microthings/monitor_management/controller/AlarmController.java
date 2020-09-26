package com.microthings.monitor_management.controller;

import com.microthings.monitor_management.exception.CanntDeleteException;
import com.microthings.monitor_management.pojo.Alarm;
import com.microthings.monitor_management.service.AlarmService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**告警信息Controller
 * @author ThreeStone
 * @date 2020/9/21 - 15:23
 **/
@Component
@RequestMapping("alarm")
public class AlarmController {

    private static Logger logger = LoggerFactory.getLogger(AlarmController.class);

    @Resource
    private AlarmService alarmService;

    //添加告警信息
    @ResponseBody
    @PutMapping()
    public AjaxResponse addAlarm(Alarm alarm){
        try {
            return alarmService.addAlarm(alarm);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败!请重试！");
        }
    }
    //删除告警信息
    @ResponseBody
    @DeleteMapping("{alarmId}")
    public AjaxResponse deleteAlarm(@PathVariable int alarmId){
        try {
            alarmService.deleteAlarm(alarmId);
        } catch (CanntDeleteException e){
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败! 无法删除！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }
    //批量删除告警信息
    @DeleteMapping("/batch/{alarmIds}")
    @ResponseBody
    public AjaxResponse batchDeleteRole(@PathVariable int[] alarmIds) {
        try {
            for(int alarmId:alarmIds){
                alarmService.deleteAlarm(alarmId);
            }
        } catch (CanntDeleteException e){
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败! 无法删除！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }
    //修改告警信息
    @ResponseBody
    @PostMapping
    public AjaxResponse updateAlarm(Alarm alarm){
        try {
            return alarmService.updateAlarm(alarm);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("修改失败！请重试！");
        }
    }
    //获取所有告警信息
    @GetMapping("all")
    public String ListAlarm(ModelMap model){
        List<Alarm> alarmList = alarmService.getAlarmList();
        model.put("alarmList",alarmList);
        return "/alarm";
    }
}
