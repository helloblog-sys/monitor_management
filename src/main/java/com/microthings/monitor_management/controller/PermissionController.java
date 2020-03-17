package com.microthings.monitor_management.controller;

import com.alibaba.fastjson.JSON;
import com.microthings.monitor_management.pojo.Permission;
import com.microthings.monitor_management.service.PermissionService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PermissionController
 * Description TODO
 * @Author hms
 * @Date 2019/10/24 22:13
 * @Version 1.0
 **/
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;


    /**
     * @Description: 添加权限信息
     * @Param: [permission]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/25 15:10
     */
    @ResponseBody
    @PutMapping()
    public AjaxResponse addPermission(Permission permission){
        try {
            permissionService.addPermission(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败!请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 删除权限信息
     * @Param: [permissionId]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/25 15:12
     */
    @ResponseBody
    @DeleteMapping("{permissionId}")
    public AjaxResponse deletePermission(@PathVariable int permissionId){
        try {
            permissionService.deletePermission(permissionId);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 批量删除权限信息
    * @Param: [permissionIds]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/25 16:24
    */
    @DeleteMapping("/batch/{permissionIds}")
    @ResponseBody
    public AjaxResponse batchDeletePermission(@PathVariable int[] permissionIds) {
        try {
            for(int permissionId:permissionIds){
                permissionService.deletePermission(permissionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 修改权限信息
     * @Param: [Permission]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/25 15:12
     */
    @ResponseBody
    @PostMapping
    public AjaxResponse updatePermission(Permission permission){
        try {
            permissionService.updatePermission(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("修改失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
    * @Description: 查看所有权限信息
    * @Param: [model]
    * @return: java.lang.String
    * @Author: hms
    * @Date: 2019/10/25 16:23
    */
    @GetMapping("all")
    public String listPermission(ModelMap model){
        List<Permission> permissionList = permissionService.listPermission();
        model.put("permissionList",permissionList);
        return "/permission";
    }

    @GetMapping("{roleId}")
    @ResponseBody
    public AjaxResponse getPermission(@PathVariable int roleId){
        List<String> permissionNameList= null;
        try {
            permissionNameList = permissionService.getPermission(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("查询失败！请稍后重试!");
        }
        return AjaxResponse.OK(permissionNameList);
    }
}
