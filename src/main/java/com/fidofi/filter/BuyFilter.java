package com.fidofi.filter;

import com.fidofi.model.Manager;
import com.fidofi.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fido on 2017/11/28.
 */
public class BuyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        User user=(User) request.getSession().getAttribute("user");
        if(user!=null){
            chain.doFilter(request,response);
        }
        //如果没登录就要跳转到登录界面
        else{
            request.getRequestDispatcher("/WEB-INF/front/user_login.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
