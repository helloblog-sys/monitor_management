package com.microthings.monitor_management.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microthings.monitor_management.Enum.RoleTypeEnum;
import com.microthings.monitor_management.util.EnumUtil;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Integer roleId;

    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 角色枚举方法
     * @return
     */
    @JsonIgnore
    public RoleTypeEnum getRoleTypeEnum(){
        return EnumUtil.getByCode(roleId,RoleTypeEnum.class);
    }
}