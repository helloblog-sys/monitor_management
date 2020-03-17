package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.util.MD5Util;
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
    public void addUser(User user){
        user.setUserPassword(MD5Util.encodePassword(user.getUserPassword()));
        userMapper.insert(user);
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
    public void updateUser(User user){
        user.setUserPassword(MD5Util.encodePassword(user.getUserPassword()));
        userMapper.updateByPrimaryKeySelective(user);
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
