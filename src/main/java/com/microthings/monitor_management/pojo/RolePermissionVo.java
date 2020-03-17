package com.microthings.monitor_management.pojo;

/**
 * @ClassName 角色-权限扩展类
 * Description TODO
 * @Author hms
 * @Date 2019/10/26 20:04
 * @Version 1.0
 **/
public class RolePermissionVo {

    private Permission permission;

    private int rpId;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public int getRpId() {
        return rpId;
    }

    public void setRpId(int rpId) {
        this.rpId = rpId;
    }

}
