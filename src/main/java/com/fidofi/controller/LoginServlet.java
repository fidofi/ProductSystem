package com.fidofi.controller;

import com.fidofi.model.Manager;

import com.fidofi.service.ManagerService;

import com.fidofi.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fido on 2017/10/12.
 * 登录
 */
public class LoginServlet extends HttpServlet {
    private ManagerService managerService =new ManagerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String userName=request.getParameter("userName");
         String userPassword=request.getParameter("userPassword");
         String remember=request.getParameter("remember");
         Manager manager=new Manager(userName,userPassword);
         boolean login= managerService.findUser(manager);
         //选择了记住我，下次打开页面自动补充用户名和密码
         if(remember!=null){
                Cookie cookieName=new Cookie("name",userName);
                //设置过期时间
                cookieName.setMaxAge(60*60*24*7);
                Cookie cookiePassword=new Cookie("password",userPassword);
                response.addCookie(cookieName);
                response.addCookie(cookiePassword);
         }
         if(login){//登录成功跳转
             HttpSession session=request.getSession();
             Cookie[]cookies=request.getCookies();
             for(int i=0;i<cookies.length;i++){
                 if(cookies[i].getName().equals("lastTime")){
                     session.setAttribute("lasttime",cookies[i].getValue());
                   break;
                 }

             }
             //生成登录时间
             String currenttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
             Cookie cookie=new Cookie("lastTime",currenttime);
             cookie.setMaxAge(60*60*24*7);
             response.addCookie(cookie);
             session.setAttribute("manager",manager);
             response.sendRedirect("/product");//请求转发
         }
         else {
             request.setAttribute("loginMesg", "用户名或密码错误，请检查!");
             request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
