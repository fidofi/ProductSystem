package com.fidofi.controller;

import com.fidofi.service.CategoryAndCountService;
import com.fidofi.service.impl.CategoryAndCountServiceImpl;
import com.fidofi.vo.CategoryAndCountVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fido on 2017/10/14.
 */
public class ShowChartServlet extends HttpServlet {
    private CategoryAndCountService categoryAndCountService = new CategoryAndCountServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryAndCountVO> categoryAndCountVOList = categoryAndCountService.getAllCategoryAndCount();
        request.setAttribute("categoryList", categoryAndCountVOList);
        request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request, response);
    }
}
