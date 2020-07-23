package com.microthings.monitor_management.Enum;

import java.io.Serializable;

public enum DeviceStatusEnum implements ILongEnum , Serializable {
    OFFLINE((long)0,"离线"),
    ONLINE((long)1,"在线"),
    BREAKDOWN((long)2,"故障")
    ;
    private Long deviceStatus;
    private String message;

    DeviceStatusEnum(Long deviceStatus,String message){
        this.deviceStatus=deviceStatus;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Long getCode() {
        return deviceStatus;
    }
}
