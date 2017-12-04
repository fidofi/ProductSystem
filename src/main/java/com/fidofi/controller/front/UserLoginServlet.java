package com.fidofi.controller.front;

import com.fidofi.model.User;
import com.fidofi.service.UserService;
import com.fidofi.service.impl.UserServiceImpl;
import com.fidofi.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by fido on 2017/11/28.
 * 用户登录
 */
public class UserLoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        ResultVO<User> resultVO = userService.login(userName, userPassword);
        //登录成功
        if(resultVO.getData()!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",resultVO.getData());
            response.sendRedirect("/user/index");
        }
        else{
            request.setAttribute("loginMesg", resultVO.getMessage());
            request.getRequestDispatcher("/WEB-INF/front/user_login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
