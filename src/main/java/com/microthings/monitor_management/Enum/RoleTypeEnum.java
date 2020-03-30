package com.microthings.monitor_management.Enum;

public enum RoleTypeEnum implements IEnum {
    SUPER_ADMINISTRATOR(1,"超级管理员"),
    ORDINARY_UsER(2,"普通用户"),
    COFFEE_ADMIN(3,"咖啡街管理员");
    private Integer roleId;
    private String message;

    RoleTypeEnum(Integer roleId, String message){
        this.roleId=roleId;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return roleId;
    }
}
