package com.zj.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiyInterceptor implements HandlerInterceptor {

    //进controller之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor detecting here:" + request.getRequestURI());
        if(request.getRequestURI().contains("download"))
        {
            String token = request.getHeader("token");
            if(!"1234".equals(token))
            {
                System.out.println("token failed");
                return false;
            }
        }
        return true;
    }

    // controller之后和视图渲染之后的两个方法用到较少
}
