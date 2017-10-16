package com.fidofi.filter;

import com.fidofi.model.User;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fido on 2017/10/12.
 * 登录拦截
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //登录了才放行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        User user=(User)request.getSession().getAttribute("user");
        if(user!=null){
            filterChain.doFilter(request,response);
        }
        else{
            return;
        }

    }

    public void destroy() {

    }
}
