package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.PermissionMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapperCustom;
import com.microthings.monitor_management.pojo.Permission;
import com.sun.corba.se.impl.interceptors.PICurrent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PermissionService
 * Description TODO
 * @Author hms
 * @Date 2019/10/24 22:15
 * @Version 1.0
 **/
@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RolePermissionMapperCustom permissionMapperCustom;


    /**
    * @Description: 添加权限
    * @Param: [permission]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public void addPermission(Permission permission){
        permissionMapper.insert(permission);
    }

    /**
    * @Description: 删除权限
    * @Param: [id]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public void deletePermission(int id){
        permissionMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Description: 修改权限
    * @Param: [permission]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public void updatePermission(Permission permission){
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    /**
    * @Description: 查看全部权限
    * @Param: []
    * @return: java.util.List<com.microthings.monitor_management.pojo.Permission>
    * @Author: hms
    * @Date: 2019/10/25 10:08
    */
    public List<Permission> listPermission(){
        return permissionMapper.selectByExample(null);
    }

    public List<String> getPermission(int roleId){
        return permissionMapperCustom.selectPermissionStrByRoleId(roleId);
    }
}
