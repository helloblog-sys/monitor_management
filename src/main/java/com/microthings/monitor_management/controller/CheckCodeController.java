package com.microthings.monitor_management.controller;

import com.microthings.monitor_management.util.CheckCode;
import com.microthings.monitor_management.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName CheckCodeController
 * Description 验证码
 * @Author hms
 * @Date 2019/11/6 20:03
 * @Version 1.0
 **/
@Controller
@RequestMapping("/checkCode")
public class CheckCodeController {

    /**
     * 生成验证码
     */
    @GetMapping
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckCode checkCode=new CheckCode();
        String code=checkCode.getRandomCodeStr();
        BufferedImage buffImg= checkCode.getImgCode(code);
        System.out.println("Code is " +code);
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute(Const.CODE_SESSION_NAME,code);
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }
}
