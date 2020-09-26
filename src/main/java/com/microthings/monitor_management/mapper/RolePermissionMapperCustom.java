package com.microthings.monitor_management.mapper;

import java.util.List;

/**
 * @ClassName 角色权限数据层接口扩展
 * Description TODO
 * @Author hms
 * @Date 2019/10/25 20:13
 * @Version 1.0
 **/
public interface RolePermissionMapperCustom {

    /**
    * @Description: 根据角色ID查看角色权限信息，及就是permission_name
    * @Param: [roleId]
    * @return: java.util.List<java.lang.String>
    * @Author: hms
    * @Date: 2019/10/25 20:15
    */
    List<String> selectPermissionStrByRoleId(int roleId);
}
