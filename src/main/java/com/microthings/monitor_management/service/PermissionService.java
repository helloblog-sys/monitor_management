package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.PermissionMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapperCustom;
import com.microthings.monitor_management.pojo.Permission;
import com.microthings.monitor_management.pojo.PermissionExample;
import com.microthings.monitor_management.pojo.RolePermission;
import com.microthings.monitor_management.pojo.RolePermissionExample;
import com.microthings.monitor_management.util.AjaxResponse;
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
    @Resource
    private RolePermissionMapper rolePermissionMapper;


    /**
    * @Description: 添加权限
    * @Param: [permission]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public AjaxResponse addPermission(Permission permission){

        PermissionExample permissionExample = new PermissionExample();

        permissionExample.or().andPermissionNameEqualTo(permission.getPermissionName());

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        if(!permissionList.isEmpty()){
            return AjaxResponse.ADD_PERMISSION_EXIST;
        } else {
            permissionMapper.insert(permission);
            return AjaxResponse.OK;
        }
    }

    /**
    * @Description: 删除权限
    * @Param: [id]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public void deletePermission(int id) {
        //删除角色权限表中该权限的相关记录
        RolePermissionExample rolePermissionExample=new RolePermissionExample();
        rolePermissionExample.createCriteria().andPermissionIdEqualTo(id);
        List<RolePermission> rolePermissionList=rolePermissionMapper.selectByExample(rolePermissionExample);
        for (RolePermission rolePermission:
             rolePermissionList) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getRpId());
        }
        //删除权限
        permissionMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Description: 修改权限
    * @Param: [permission]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/25 10:07
    */
    public AjaxResponse updatePermission(Permission permission){
        PermissionExample permissionExample = new PermissionExample();

        permissionExample.or().andPermissionNameEqualTo(permission.getPermissionName());

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        if(!permissionList.isEmpty() && (!permissionList.get(0).getPermissionId().equals(permission.getPermissionId()))){
            return AjaxResponse.ADD_PERMISSION_EXIST;
        } else {
            permissionMapper.updateByPrimaryKeySelective(permission);
            return AjaxResponse.OK;
        }
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
