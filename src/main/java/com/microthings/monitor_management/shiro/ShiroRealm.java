package com.microthings.monitor_management.shiro;

import com.microthings.monitor_management.mapper.RoleMapper;
import com.microthings.monitor_management.mapper.RolePermissionMapperCustom;
import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.Role;
import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.pojo.UserExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroDbRealm
 * Description TODO
 * @Author hms
 * @Date 2019/10/17 10:52
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RolePermissionMapperCustom rolePermissionMapperCustom;

    /***
     * @Description: 认证方法
     * @Param: [authenticationToken]
     * @return: org.apache.shiro.authc.AuthenticationInfo
     * @Author: hms
     * @Date: 2019/10/17 20:53
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("do authentication ，token data [{}]", authenticationToken);
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (token.getUsername() == null) {
            return null;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(token.getUsername());
        List<User> userList = userMapper.selectByExample(userExample);
        //当账号密码不存在
        if (userList.isEmpty()) {
            log.debug("account not exist.");
            throw  new UnknownAccountException("用户名不存在");
        }
        User user = userList.get(0);
        // 当密码错误
        if (!StringUtils.equals(user.getUserPassword(),
                new String(token.getPassword()))) {
            log.debug("password not correct.");
            throw new IncorrectCredentialsException("密码错误");
        }
        List<Object> principal = new ArrayList<>();
        principal.add(user.getUserName());
        // 前端使用${subject.getPrincipals().asList()[1]}获取当前已认证用户userId
        principal.add(user.getUserId());
        principal.add(user.getUserPassword());
        return new SimpleAuthenticationInfo(principal,user.getUserPassword(), getName());
    }

    /**
     * @Description: 授权方法
     * @Param: [principalCollection]
     * @return: org.apache.shiro.authz.AuthorizationInfo
     * @Author: hms
     * @Date: 2019/10/18 14:45
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("do authortization , principals data [{}]", principalCollection);
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        User user;
        // 根据账户名获得账户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);

        if (userList.isEmpty()) {
            log.debug("account not exist.");
            throw new UnknownAccountException("用户名不存在");
        }
        //获取权限字符列表Z
        List<String> permissionStrList = rolePermissionMapperCustom
                .selectPermissionStrByRoleId(userList.get(0).getRoleId());
        // 封装授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 将用户的权限字符，进行授权
        info.addStringPermissions(permissionStrList);

        //获取角色字符
        Role role = roleMapper.selectByPrimaryKey(userList.get(0).getRoleId());
        Set<String> roleStrList = new HashSet<>();
        roleStrList.add(role.getRoleStr());
        info.addRoles(roleStrList);

        return info;
    }

}
