package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.PermissionMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapper;
import com.microthings.monitor_management.pojo.RolePermissionVo;
import com.microthings.monitor_management.pojo.Permission;
import com.microthings.monitor_management.pojo.RolePermission;
import com.microthings.monitor_management.pojo.RolePermissionExample;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RolePermissionService
 * Description TODO
 * @Author hms
 * @Date 2019/10/26 15:15
 * @Version 1.0
 **/
@Service
public class RolePermissionService {

    @Resource
    RolePermissionMapper rolePermissionMapper;
    @Resource
    PermissionMapper permissionMapper;

    /**
    * @Description: 增加角色权限
    * @Param: [rolePermission]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/26 15:17
    */
    public void addRolePermission(RolePermission rolePermission){
        rolePermissionMapper.insert(rolePermission);
    }

    /**
    * @Description: 根据rpid删除角色权限
    * @Param: [rpId]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/26 15:18
    */
    public void deleteRolePemission(int rpId){
        rolePermissionMapper.deleteByPrimaryKey(rpId);
    }

    /**
    * @Description: 根据roleId查看角色权限
    * @Param: [roleId]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/26 15:27
    */
    public List<RolePermissionVo> listRolePermission(int roleId){
        List<RolePermissionVo> rolePermissionVoList = new ArrayList<>();
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionExample);
        for(RolePermission rolePermission:rolePermissionList){
            RolePermissionVo rolePermissionVo = new RolePermissionVo();
            Permission tem = permissionMapper.selectByPrimaryKey(rolePermission.getPermissionId());
            rolePermissionVo.setPermission(tem);
            rolePermissionVo.setRpId(rolePermission.getRpId());
            rolePermissionVoList.add(rolePermissionVo);
        }
        return rolePermissionVoList;
    }
}
