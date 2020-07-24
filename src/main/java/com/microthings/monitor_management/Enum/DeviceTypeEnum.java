package com.microthings.monitor_management.Enum;

import java.io.Serializable;

public enum  DeviceTypeEnum implements ILongEnum , Serializable {
    RADAR((long)1,"雷达"),
    CAMERA((long)2,"摄像头"),
    SMOKE_SENSING((long)3,"烟感设备"),
    FIRE_ALARM((long)4,"火灾报警设备"),
    BULB((long)5,"灯泡"),
    FACE_RECOGNITION((long)6,"人脸识别设备"),
    ;
    private Long deviceType;
    private String message;

    DeviceTypeEnum(Long deviceType, String message){
        this.deviceType=deviceType;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public Long getCode() {
        return deviceType;
    }
}
