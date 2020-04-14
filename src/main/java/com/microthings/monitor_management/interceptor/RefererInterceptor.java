package com.microthings.monitor_management.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;

@Component
public class RefererInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String referer = req.getHeader("referer");
        String host = req.getServerName();
        // 验证非get请求
        if (!"GET".equals(req.getMethod())) {
            if (referer == null) {
                // 状态置为404
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return false;
            }
            java.net.URL url = null;
            try {
                url = new java.net.URL(referer);
            } catch (MalformedURLException e) {
                // URL解析异常，也置为404
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return false;
            }
            // 判断请求域名和referer域名是否相同
            if (!host.equals(url.getHost())) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return false;
            }
        }
        return true;
    }
}


