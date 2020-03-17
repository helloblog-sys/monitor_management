package com.microthings.monitor_management.controller;

import com.microthings.monitor_management.pojo.Role;
import com.microthings.monitor_management.service.RoleService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleController
 * Description TODO
 * @Author hms
 * @Date 2019/10/24 22:12
 * @Version 1.0
 **/
@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
    * @Description: 添加角色信息
    * @Param: [role]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/25 15:10
    */
    @ResponseBody
    @PutMapping()
    public AjaxResponse addRole(Role role){
        try {
            roleService.addRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败!请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 删除角色信息
    * @Param: [id]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/25 15:12
    */
    @ResponseBody
    @DeleteMapping("{roleId}")
    public AjaxResponse deleteRole(@PathVariable int roleId){
        try {
            roleService.deleteRole(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 批量删除角色信息
    * @Param: [roleIds]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/25 16:24
    */
    @DeleteMapping("/batch/{roleIds}")
    @ResponseBody
    public AjaxResponse batchDeleteRole(@PathVariable int[] roleIds) {
        try {
            for(int roleId:roleIds){
                roleService.deleteRole(roleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 修改角色信息
    * @Param: [role]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/25 15:12
    */
    @ResponseBody
    @PostMapping
    public AjaxResponse updateRole(Role role){
        try {
            roleService.updateRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("修改失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 查看所有角色信息
    * @Param: [model]
    * @return: java.lang.String
    * @Author: hms
    * @Date: 2019/10/25 16:24
    */
    @GetMapping("all")
    public String ListRole(ModelMap model){
        List<Role> roleList = roleService.listRole();
        model.put("roleList",roleList);
        return "/role";
    }
}
