package com.microthings.monitor_management.controller;

import com.alibaba.druid.util.StringUtils;
import com.microthings.monitor_management.mapper.UserMapper;
import com.microthings.monitor_management.pojo.User;
import com.microthings.monitor_management.pojo.UserExample;
import com.microthings.monitor_management.util.AjaxResponse;
import com.microthings.monitor_management.util.Const;
import com.microthings.monitor_management.util.MD5Util;
import com.microthings.monitor_management.util.RSAUtils;
import org.apache.ibatis.javassist.runtime.Desc;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import static com.microthings.monitor_management.util.AjaxResponse.*;


@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private UserMapper userMapper;

    //给前端返回公钥
    @PostMapping("/getPublicKey")
    @ResponseBody
    public String getKey(){
        String publicKey = RSAUtils.generateBase64PublicKey();
        return publicKey;
    }

    @PostMapping("login")
    @ResponseBody
    public AjaxResponse login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "checkcode") String checkcode,
                              HttpSession session) throws Exception {

        logger.debug("loging username [{}] password [{}] checkcode", username, password, checkcode);
        //解密前端传入的密码
        password = RSAUtils.decryptBase64(password.trim());
        // 先检查验证码
        String sessionCode = (String) session.getAttribute(Const.CODE_SESSION_NAME);
        String code = checkcode.toUpperCase();
        if (!code.equals(sessionCode)) {
            return CHECKCODE_NOT_CHECKED;
        }
        // 封装令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                MD5Util.encodePassword(password));
        Subject subject = null;
        try {
            // 得到当前执行的用户
            subject = SecurityUtils.getSubject();
            // 用令牌登陆,如果登陆失败，则抛出异常
            subject.login(token);
            token.clear();
        } catch (UnknownAccountException ex) {
            return ACCOUNT_NOT_EXIST;
        } catch (IncorrectCredentialsException ex) {
            return PASSWORD_NOT_PASSED;
        } catch (Exception ex) {
            logger.error("login error happend.", ex);
            return AjaxResponse.SYSTEM_BUSY;
        }
        session.removeAttribute(Const.SESSION_USER_KEY);
        session.removeAttribute(Const.SESSION_SUBJECT);
        session.setAttribute(Const.SESSION_SUBJECT, subject);
        session.setAttribute(Const.SESSION_USER_PASSWORD, MD5Util.encodePassword(password));

        SecurityUtils.getSubject().getSession().setTimeout(-2000);
        return AjaxResponse.OK;
    }

    @GetMapping("welcome")
    public String welcome(){
        return "/index";
    }

}
