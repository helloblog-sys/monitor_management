package com.microthings.monitor_management.service;


import com.microthings.monitor_management.exception.CanntDeleteException;
import com.microthings.monitor_management.mapper.RoleMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapper;
import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.*;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleService
 * Description TODO
 * @Author hms
 * @Date 2019/10/24 22:14
 * @Version 1.0
 **/
@Service
public class RoleService {

    @Resource
    RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private UserMapper userMapper;
    /**
    * @Description: 添加角色
    * @Param: [role]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/24 22:16
    */
    public AjaxResponse addRole(Role role){
        RoleExample roleExample = new RoleExample();

        roleExample.or().andRoleNameEqualTo(role.getRoleName());

        List<Role> roleList = roleMapper.selectByExample(roleExample);

        if(!roleList.isEmpty()){
            return AjaxResponse.ADD_ROLE_EXIST;
        } else{
            roleMapper.insert(role);
            return AjaxResponse.OK;
        }
    }

    /**
    * @Description: 根据ID删除角色
    * @Param: [id]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/24 22:17
    */
    public void deleteRole(int id) throws Exception {
        //如果角色无关联用户，删除角色权限表中记录，删除角色
        UserExample userExample = new UserExample();
        userExample.createCriteria().andRoleIdEqualTo(id);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.isEmpty()){
            //删除角色权限表中该角色的相关记录
            RolePermissionExample rolePermissionExample=new RolePermissionExample();
            rolePermissionExample.createCriteria().andRoleIdEqualTo(id);
            List<RolePermission> rolePermissionList=rolePermissionMapper.selectByExample(rolePermissionExample);
            for (RolePermission rolePermission:
                    rolePermissionList) {
                rolePermissionMapper.deleteByPrimaryKey(rolePermission.getRpId());
            }
            //删除角色
            roleMapper.deleteByPrimaryKey(id);
        }
        else{
            //如果角色有关联用户，则无法删除
            throw new CanntDeleteException();
        }

    }
    /**
    * @Description: 更新角色信息
    * @Param: [role]
    * @return:
    * @Author: hms
    * @Date: 2019/10/24 22:19
    */
    public AjaxResponse updateRole(Role role){
        RoleExample roleExample = new RoleExample();

        roleExample.or().andRoleNameEqualTo(role.getRoleName());

        List<Role> roleList = roleMapper.selectByExample(roleExample);

        if(!roleList.isEmpty() && (!roleList.get(0).getRoleId().equals(role.getRoleId()))){
            return AjaxResponse.ADD_ROLE_EXIST;
        } else{
            roleMapper.updateByPrimaryKeySelective(role);
            return AjaxResponse.OK;
        }
    }

    /**
    * @Description: 查看所有角色信息
    * @Param: []
    * @return: java.util.List<com.microthings.monitor_management.pojo.Role>
    * @Author: hms
    * @Date: 2019/10/25 10:03
    */
    public List<Role> listRole(){
        return roleMapper.selectByExample(null);
    }

    /**
    * @Description: 根据角色ID查询角色
    * @Param: [roleId]
    * @return: com.microthings.monitor_management.pojo.Role
    * @Author: hms
    * @Date: 2019/10/26 19:35
    */
    public Role selectRole(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
