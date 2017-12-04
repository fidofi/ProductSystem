package com.fidofi.controller.front;

import com.fidofi.model.Page;
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
 * Created by fido on 2017/11/30.
 * 根据商品名称模糊查询
 */
public class SelectByNameServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page = new Page();
        page.setIndex(1);
        String productName = new String(request.getParameter("productName").getBytes("ISO-8859-1"), "UTF-8");
        List<ProductVO> productList=productService.selectByProductName(productName, page);
        List<ProductVO> newProduct=productService.getNew();
        List<ProductVO> discountProduct=productService.getDiscount();
        //新品
        request.setAttribute("newProduct",newProduct);
        //特价品
        request.setAttribute("discountProduct",discountProduct);
        request.setAttribute("productList",productList);
        request.setAttribute("categoryName", CategoryCodeUtils.categoryName());
        request.getRequestDispatcher("/WEB-INF/front/user_index.jsp").forward(request,response);

    }
}
