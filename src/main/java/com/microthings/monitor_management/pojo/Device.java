package com.microthings.monitor_management.pojo;

import com.microthings.monitor_management.Enum.DeviceStatusEnum;
import com.microthings.monitor_management.Enum.DeviceTypeEnum;
import com.microthings.monitor_management.util.EnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    private Integer deviceId;

    private String deviceName;

    private Long deviceType;

    private String deviceSn;

    private Long deviceStatus;

    private Integer buildingId;

    private String devicePosition;

    private Long deviceFloor;

    private Double deviceScaling;

    private Double deviceAngle;

    private Double mapPositionX;

    private Double mapPositionY;

    private Double monitorAhead;

    private Double monitorLeft;

    private Double monitorRight;

    private String ip;

    private String port;

    private String associationMmwaveSn;

    private Date createTime;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Long getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public Long getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Long deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getDevicePosition() {
        return devicePosition;
    }

    public void setDevicePosition(String devicePosition) {
        this.devicePosition = devicePosition == null ? null : devicePosition.trim();
    }

    public Long getDeviceFloor() {
        return deviceFloor;
    }

    public void setDeviceFloor(Long deviceFloor) {
        this.deviceFloor = deviceFloor;
    }

    public Double getDeviceScaling() {
        return deviceScaling;
    }

    public void setDeviceScaling(Double deviceScaling) {
        this.deviceScaling = deviceScaling;
    }

    public Double getDeviceAngle() {
        return deviceAngle;
    }

    public void setDeviceAngle(Double deviceAngle) {
        this.deviceAngle = deviceAngle;
    }

    public Double getMapPositionX() {
        return mapPositionX;
    }

    public void setMapPositionX(Double mapPositionX) {
        this.mapPositionX = mapPositionX;
    }

    public Double getMapPositionY() {
        return mapPositionY;
    }

    public void setMapPositionY(Double mapPositionY) {
        this.mapPositionY = mapPositionY;
    }

    public Double getMonitorAhead() {
        return monitorAhead;
    }

    public void setMonitorAhead(Double monitorAhead) {
        this.monitorAhead = monitorAhead;
    }

    public Double getMonitorLeft() {
        return monitorLeft;
    }

    public void setMonitorLeft(Double monitorLeft) {
        this.monitorLeft = monitorLeft;
    }

    public Double getMonitorRight() {
        return monitorRight;
    }

    public void setMonitorRight(Double monitorRight) {
        this.monitorRight = monitorRight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getAssociationMmwaveSn() {
        return associationMmwaveSn;
    }

    public void setAssociationMmwaveSn(String associationMmwaveSn) {
        this.associationMmwaveSn = associationMmwaveSn == null ? null : associationMmwaveSn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设备类型枚举方法
     * @return
     */
    @JsonIgnore
    public DeviceTypeEnum getDeviceTypeEnum(){
        return EnumUtil.getLongByCode(deviceType,DeviceTypeEnum.class);
    }

    /**
     * 设备状态枚举方法
     * @return
     */
    @JsonIgnore
    public DeviceStatusEnum getDeviceStatusEnum(){
        return EnumUtil.getLongByCode(deviceStatus,DeviceStatusEnum.class);
    }
}