package com.fidofi.controller;

import com.fidofi.model.Product;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;
import com.fidofi.vo.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fido on 2017/10/9.
 * 显示详情
 */
public class DetailServlet extends HttpServlet {

    private ProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
          String productBarCode =request.getParameter("productBarCode");
          List<ProductVO> productVOList= productService.selectByProductBarCode(productBarCode);
          request.setAttribute("productVO",productVOList.get(0));
          request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request,response);
    }
}
