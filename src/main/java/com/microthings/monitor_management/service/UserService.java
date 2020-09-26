package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.pojo.UserExample;
import com.microthings.monitor_management.util.AjaxResponse;
import com.microthings.monitor_management.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * Description 用户管理service
 * @Author hms
 * @Date 2019/10/22 15:44
 * @Version 1.0
 **/


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
    * @Description: 添加用户
    * @Param: [user]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/22 15:58
    */
    public AjaxResponse addUser(User user){

        UserExample example = new UserExample();
        example.or().andUserNameEqualTo(user.getUserName());
        List<User> userList = userMapper.selectByExample(example);

        if(!userList.isEmpty()){
            return AjaxResponse.ADD_ACCOUNT_EXIST;
        }
        else {
            user.setUserPassword(MD5Util.encodePassword(user.getUserPassword()));
            userMapper.insert(user);
            return AjaxResponse.OK;
        }
    }

    /**
    * @Description: 根据userID删除用户
    * @Param: [userId]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/22 15:59
    */
    public void deleteUser(int userId){
        userMapper.deleteByPrimaryKey(userId);
    }

    /**
    * @Description: 更新用户信息
    * @Param: [user]
    * @return: void
    * @Author: hms
    * @Date: 2019/10/22 16:02
    */
    public AjaxResponse updateUser(User user){

        UserExample example = new UserExample();
        example.or().andUserNameEqualTo(user.getUserName());
        List<User> userList = userMapper.selectByExample(example);

        //要修改的用户名存在(不包括自身)
        if((!userList.isEmpty()) && (!userList.get(0).getUserId().equals(user.getUserId()))){
            return AjaxResponse.ADD_ACCOUNT_EXIST;
        }
        //要修改的用户名不存在
        else {
            //修改前后密码
            String oldPassword = userMapper.selectByPrimaryKey(user.getUserId()).getUserPassword();
            user.setUserPassword(MD5Util.encodePassword(user.getUserPassword()));
            String newPassword = user.getUserPassword();
            //进行修改
            userMapper.updateByPrimaryKeySelective(user);
            //获取当前登录的用户Id
            Integer loginUserId = (Integer) SecurityUtils.getSubject().getPrincipals().asList().get(1);
            //当前登录用户的密码是否修改，修改需要重新登录
            if((!oldPassword.equals(newPassword)) && (loginUserId.equals(user.getUserId()))){
                return AjaxResponse.UPDATE_PASSWORD_SUCCESS;
            }
            return AjaxResponse.OK;
        }
    }

    /**
    * @Description: 获取所有用户信息
    * @Param: []
    * @return: java.util.List<com.microthings.monitor_management.pojo.User>
    * @Author: hms
    * @Date: 2019/10/22 20:15
    */
    public List<User> getUserList(){
        return userMapper.selectByExample(null);
    }
}