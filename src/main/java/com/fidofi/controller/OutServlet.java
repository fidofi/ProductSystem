package com.fidofi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fido on 2017/10/13.
 */
public class OutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getSession().invalidate();//清除登录信息
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
}
