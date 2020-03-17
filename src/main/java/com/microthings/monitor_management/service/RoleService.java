package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.RoleMapper;
import com.microthings.monitor_management.pojo.Role;
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
    /**
    * @Description: 添加角色
    * @Param: [role]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/24 22:16
    */
    public void addRole(Role role){
        roleMapper.insert(role);
    }

    /**
    * @Description: 根据ID删除角色
    * @Param: [id]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/24 22:17
    */
    public void deleteRole(int id){
        roleMapper.deleteByPrimaryKey(id);
    }
    /**
    * @Description: 更新角色信息
    * @Param: [role]
    * @return:
    * @Author: hms
    * @Date: 2019/10/24 22:19
    */
    public void updateRole(Role role){
        roleMapper.updateByPrimaryKeySelective(role);
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
    public Role selectRole(int roleId){return roleMapper.selectByPrimaryKey(roleId);}
}
