package com.fidofi.controller;

import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by fido on 2017/10/2.
 * 删除
 */
public class DeleteServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String productBarCode=request.getParameter("productBarCode");
             File file=new File(productService.selectByProductBarCode(productBarCode).get(0).getProductPhoto());
             productService.delete(productBarCode);
             if(file.exists()){
                 file.delete();
             }
             response.sendRedirect("/product");
    }
}
