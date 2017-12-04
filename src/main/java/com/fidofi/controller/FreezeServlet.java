package com.fidofi.controller;

import com.fidofi.service.UserService;
import com.fidofi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fido on 2017/11/30.
 * 处理用户冻结与解冻
 */
public class FreezeServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doFreeze = request.getParameter("dofreeze");
        String id = request.getParameter("userId");
        Integer userId = Integer.valueOf(id);//得到要处理的用户id
        if (doFreeze.equals("freeze")) {
            userService.freezeUser(userId);
        } else if (doFreeze.equals("unfreeze")) {
            userService.releaseUser(userId);
        }
        request.getRequestDispatcher("/product/managerUser").forward(request, response);
    }
}
