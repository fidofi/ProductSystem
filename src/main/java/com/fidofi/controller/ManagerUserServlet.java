package com.fidofi.controller;

import com.fidofi.constant.PageConstant;
import com.fidofi.model.Page;
import com.fidofi.model.User;
import com.fidofi.service.UserService;
import com.fidofi.service.impl.UserServiceImpl;
import com.fidofi.vo.ProductVO;
import com.fidofi.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fido on 2017/11/29.
 * 管理员后台的用户管理模块
 */
public class ManagerUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page=new Page();
        page.setIndex(1);
        Integer count=userService.userCount();//总记录数
        String pageIndex = request.getParameter("pageIndex");//第几页
        if (pageIndex != null && !(pageIndex.trim().equals(""))) {
            page.setIndex(Integer.parseInt(pageIndex));
        }

        Integer i = count % PageConstant.size;//余数
        Integer j=count/PageConstant.size;//除数
        page.setTotal(i > 0 ? (j + 1) : j);//处理总页数
        ResultVO<List<User>> resultVO=userService.findAllUser(page);
        //将分页信息传过去
        request.setAttribute("page", page);
        request.setAttribute("userList",resultVO.getData());
        request.getRequestDispatcher("/WEB-INF/managerUser.jsp").forward(request,response);
    }
}
