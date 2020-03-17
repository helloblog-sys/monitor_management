package com.microthings.monitor_management.controller;

import com.microthings.monitor_management.pojo.RolePermissionVo;
import com.microthings.monitor_management.pojo.Role;
import com.microthings.monitor_management.pojo.RolePermission;
import com.microthings.monitor_management.service.RolePermissionService;
import com.microthings.monitor_management.service.RoleService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RolePermissionController
 * Description TODO
 * @Author hms
 * @Date 2019/10/26 15:15
 * @Version 1.0
 **/
@RequestMapping("rolePermission")
@Controller
public class RolePermissionController {

    @Resource
    RolePermissionService rolePermissionService;

    @Resource
    RoleService roleService;

    /**
     * @Description: 添加角色权限
     * @Param: [rolePermission]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/26 15:31
     */
    @PostMapping
    @ResponseBody
    public AjaxResponse addRolePermission(RolePermission rolePermission) {
        try {
            rolePermissionService.addRolePermission(rolePermission);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败！请稍后重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 删除角色权限
     * @Param: [rpId]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/26 15:37
     */
    @DeleteMapping("{rpIds}")
    @ResponseBody
    public AjaxResponse deleteRolePermission(@PathVariable() int[] rpIds) {
        try {
            for (int rpId : rpIds) {
                rolePermissionService.deleteRolePemission(rpId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请稍后重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 根据roleId查询角色权限
     * @Param: [roleId, model]
     * @return: java.lang.String
     * @Author: hms
     * @Date: 2019/10/26 17:31
     */
    @GetMapping("{roleId}")
    public String listRolePermission(@PathVariable int roleId, ModelMap model) {
        List<RolePermissionVo> rolePermissionVoList = rolePermissionService.listRolePermission(roleId);
        Role role = roleService.selectRole(roleId);
        model.put("rolePermissionVoList", rolePermissionVoList);
        model.put("roleId", roleId);
        model.put("roleName", role.getRoleName());
        return "/rolePermission";
    }
}
