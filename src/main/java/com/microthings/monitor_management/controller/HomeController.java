package com.microthings.monitor_management.controller;

import com.alibaba.druid.util.StringUtils;
import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.pojo.UserExample;
import com.microthings.monitor_management.util.AjaxResponse;
import com.microthings.monitor_management.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private UserMapper userMapper;

    @PostMapping("login")
    @ResponseBody
    public AjaxResponse login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              HttpSession session) throws Exception {
        logger.debug("loging username [{}] password [{}]", username, password);
        //验证用户名和密码是否为空
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
           return AjaxResponse.FAILED("账号密码不能为空！");
        }
        //验证用户名和密码是否正确
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        //当账号密码不存在
        if (userList.isEmpty()) {
            logger.debug("account not exist.");
        }
        User user = userList.get(0);
        // 当密码错误
        if (MD5Util.encodePassword(password) != user.getUserPassword()) {
            logger.debug("password not correct.");
        }
        return AjaxResponse.OK;
    }

    @GetMapping("welcome")
    public String welcome(){
        return "/index";
    }

}
