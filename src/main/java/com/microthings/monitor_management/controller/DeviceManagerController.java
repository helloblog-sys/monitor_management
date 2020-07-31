package com.microthings.monitor_management.controller;

import com.alibaba.fastjson.JSON;
import com.microthings.monitor_management.pojo.Device;
import com.microthings.monitor_management.service.DeviceManagerService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DeviceManagerController
 * Description 设备管理controller
 * @Author hms
 * @Date 2019/8/28 21:19
 * @Version 1.0
 **/
@Controller
@RequestMapping("device")
public class DeviceManagerController {

    private static Logger logger = LoggerFactory.getLogger(DeviceManagerController.class);

    @Resource
    private DeviceManagerService deviceManagerService;

    /**
     * @Description: 获取所有设备信息，返回ajax请求
     * @Param: []
     * @return: java.util.List<com.microthings.monitor.pojo.Device>
     * @Author: hms
     * @Date: 2019/8/28 21:46
     */
    @GetMapping()
    @ResponseBody
    public AjaxResponse getDeviceList() {
        List<Device> list = deviceManagerService.getDeviceList();
        return AjaxResponse.OK(list);
    }

    /***
     * @Description: 获取所有设备信息，返回页面
     * @Param: [model]
     * @return: java.lang.String
     * @Author: hms
     * @Date: 2019/8/28 22:38
     */
    @GetMapping("/all")
    public String getDeviceList(ModelMap model) {
        List<Device> deviceList = deviceManagerService.getDeviceList();
        model.put("deviceList", deviceList);
        model.put("buildingId", "all");
        return "/device";
    }

    /**
    * @Description: 根据楼栋ID查询楼栋设备
    * @Param: [buildingId, model]
    * @return: java.lang.String
    * @Author: hms
    * @Date: 2019/12/6 11:49
    */
    @GetMapping("/{buildingId}")
    public String getBuildingDeviceList(@PathVariable int buildingId, ModelMap model){
        List<Device> deviceList = deviceManagerService.getBuildingDeviceList(buildingId);
        model.put("deviceList", deviceList);
        model.put("buildingId", buildingId);
        return  "/device";
    }

    /**
    * @Description: 获取所有设备信息，返回地图
    * @Param: [model]
    * @return: java.lang.String
    * @Author: hms
    * @Date: 2019/11/1 21:34
    */
    @GetMapping("/map/{buildingId}")
    public String getMapDeviceList(@PathVariable int buildingId,ModelMap model){
        List<Device> deviceList = deviceManagerService.getBuildingDeviceList(buildingId);
        model.put("deviceList", JSON.toJSONString(deviceList));
        model.put("buildingId", buildingId);
        return "/deviceManagement";
    }

    /**
     * @Description: 添加设备
     * @Param: [device]
     * @return: com.microthings.monitor.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/8/28 22:49
     */
    @PutMapping
    @ResponseBody
    private AjaxResponse addDevice(Device device) {
        try {
            return deviceManagerService.addDevice(device);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败，请稍后重试！");
        }
    }

    /**
     * @Description: 根据设备id删除设备
     * @Param: [deviceId]
     * @return: com.microthings.monitor.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/8/28 22:55
     */
    @DeleteMapping("{deviceIds}")
    @ResponseBody
    public AjaxResponse deleteDevice(@PathVariable int[] deviceIds) {
        try {
            for (int deviceId : deviceIds) {
                deviceManagerService.deleteDevice(deviceId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败，请稍后重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 修改设备信息
     * @Param: [device]
     * @return: com.microthings.monitor.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/8/29 10:11
     */
    @PostMapping
    @ResponseBody
    public AjaxResponse updateDevice(Device device) {
        try {
            return deviceManagerService.updateDevice(device);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("修改失败，请检查后重试！");
        }
    }
}
