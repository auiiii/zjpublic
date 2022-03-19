package com.zj.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String path = req.getRequestURI();
        System.out.println("filter read path:"+path);
        if(path.contains("upload"))
        {
            String token = req.getHeader("token");
            if(!"1234".equals(token))
            {
                System.out.println("token auth failed");
                HttpServletResponse response = (HttpServletResponse)servletResponse;
                response.sendError(400, "token auth failed!");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy here");
    }
}
