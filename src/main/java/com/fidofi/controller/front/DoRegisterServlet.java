package com.fidofi.controller.front;

import com.fidofi.constant.ResponseCode;
import com.fidofi.model.User;
import com.fidofi.service.UserService;
import com.fidofi.service.impl.UserServiceImpl;
import com.fidofi.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fido on 2017/11/30.
 * 处理用户注册提交的表单信息，并转回登录界面
 */
public class DoRegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String userName=request.getParameter("userName");
            String userPassword=request.getParameter("userPassword");
            String userEmail=request.getParameter("userEmail");
            User user=new User(userName,userPassword,userEmail,true);
             ResultVO<String> resultVO=userService.register(user);
             //注册未成功
             if(resultVO.getCode()== ResponseCode.ERROR.getCode()){
                 request.setAttribute("registerMesg",resultVO.getMessage());
                 request.getRequestDispatcher("/WEB-INF/front/user_register.jsp").forward(request,response);
             }
             //注册成功
             else{
                request.setAttribute("userName",resultVO.getMessage());
                request.getRequestDispatcher("/WEB-INF/front/user_login.jsp").forward(request,response);
             }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
