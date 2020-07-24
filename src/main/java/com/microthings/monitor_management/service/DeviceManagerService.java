package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.DeviceMapper;
import com.microthings.monitor_management.pojo.Device;
import com.microthings.monitor_management.pojo.DeviceExample;
import com.microthings.monitor_management.util.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DeviceManagerService
 * Description 设备管理service
 * @Author hms
 * @Data 2019/10/29 21:55
 * @Version 1.0
 **/
@Service
public class DeviceManagerService {

    private static Logger logger = LoggerFactory.getLogger(DeviceManagerService.class);

    @Resource
    private DeviceMapper deviceMapper;

    /***
    * @Description: 获取所有设备信息
    * @Param: []
    * @return: java.util.List<com.microthings.monitor.pojo.Device>
    * @Author: hms
    * @Date: 2019/8/28 21:51
    */
    public List<Device> getDeviceList(){
        return  deviceMapper.selectByExample(null);
    }
    /**
    * @Description: 根据 buildingId 查询楼栋中的设备
    * @Param: [buildingId]
    * @return: java.util.List<com.microthings.monitor_management.pojo.Device>
    * @Author: hms
    * @Date: 2019/11/13 21:35
    */
    public List<Device> getBuildingDeviceList(int buildingId){
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return deviceMapper.selectByExample(deviceExample);
    }
    /**
    * @Description: 添加设备
    * @Param: [device]
    * @return: void
    * @Author: hms
    * @Date: 2019/8/28 22:52
    */
    public AjaxResponse addDevice(Device device){

        DeviceExample deviceExample = new DeviceExample();
        deviceExample.or().andDeviceSnEqualTo(device.getDeviceSn());

        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        if(!deviceList.isEmpty()){
            return AjaxResponse.ADD_DEVICE_EXIST;
        } else {
            deviceMapper.insert(device);
            return AjaxResponse.OK;
        }
    }
    /**
    * @Description: 删除设备
    * @Param: [deviceId]
    * @return: void
    * @Author: hms
    * @Date: 2019/8/28 22:54
    */
    public void deleteDevice(int deviceId){
        deviceMapper.deleteByPrimaryKey(deviceId);
    }
    /**
    * @Description: 修改设备信息
    * @Param: [device]
    * @return: void
    * @Author: hms
    * @Date: 2019/8/29 10:09
    */
    public AjaxResponse updateDevice(Device device){

        DeviceExample deviceExample = new DeviceExample();
        deviceExample.or().andDeviceSnEqualTo(device.getDeviceSn());

        List<Device> deviceList = deviceMapper.selectByExample(deviceExample);
        if(!deviceList.isEmpty() && (!deviceList.get(0).getDeviceId().equals(device.getDeviceId()))){
            return AjaxResponse.ADD_DEVICE_EXIST;
        } else {
            deviceMapper.updateByPrimaryKeySelective(device);
            return AjaxResponse.OK;
        }
    }
}
