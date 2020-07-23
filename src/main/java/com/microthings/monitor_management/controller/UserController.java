package com.microthings.monitor_management.controller;


import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.service.UserService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * Description 用户管理controller
 * @Author hms
 * @Date 2019/10/22 15:43
 * @Version 1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @Description: 查看所有用户
     * @Param: [model]
     * @return: java.lang.String
     * @Author: hms
     * @Date: 2019/10/22 20:20
     */
    @GetMapping("/all")
    public String getUserList(ModelMap model) {
        List<User> userList = userService.getUserList();
        model.put("userList", userList);
        return "/user";
    }

    /**
     * @Description: 添加用户
     * @Param: [user]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/22 21:39
     */
    @PutMapping
    @ResponseBody
    public AjaxResponse addUser(User user) {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败！请重试！");
        }
    }

    /**
     * @Description: 删除用户
     * @Param: [userId]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/22 21:41
     */
    @DeleteMapping("{userId}")
    @ResponseBody
    public AjaxResponse deleteUser(@PathVariable int userId) {
        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }
    /**
    * @Description: 批量删除用户
    * @Param: [userIds]
    * @return: com.microthings.monitor_management.util.AjaxResponse
    * @Author: hms
    * @Date: 2019/10/23 21:44
    */
    @DeleteMapping("/batch/{userIds}")
    @ResponseBody
    public AjaxResponse batchDeleteUser(@PathVariable int[] userIds) {
        try {
            for(int userId:userIds){
                userService.deleteUser(userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("删除失败！请重试！");
        }
        return AjaxResponse.OK;
    }

    /**
     * @Description: 修改用户信息
     * @Param: [user]
     * @return: com.microthings.monitor_management.util.AjaxResponse
     * @Author: hms
     * @Date: 2019/10/23 14:41
     */
    @PostMapping
    @ResponseBody
    public AjaxResponse updateUser(User user) {
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("修改失败！请重试！");
        }
        return AjaxResponse.OK;
    }
}
