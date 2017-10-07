package com.fidofi.controller;

import com.fidofi.model.Product;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;
import com.fidofi.utils.CategoryCodeUtils;
import com.fidofi.vo.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fido on 2017/10/2.
 */
public class UpdateServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
    //更新操作
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             List<ProductVO> productList= productService.selectByProductBarCode(request.getParameter("productBarCode"));
             request.setAttribute("product",productList.get(0));
             request.setAttribute("categoryName", CategoryCodeUtils.categoryName());
             request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
