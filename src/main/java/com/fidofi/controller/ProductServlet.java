package com.fidofi.controller;

import com.fidofi.constant.PageConstant;
import com.fidofi.model.Page;
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
 * Created by fido on 2017/10/2.
 * 商品的controller
 */
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //设置分页对象
        Page page = new Page();
        page.setIndex(1);
        Integer count=productService.count();//总记录数
        List<ProductVO> productVOList=null;
        String productBarCode = request.getParameter("productBarCode");
        String productName = request.getParameter("productName");
        String pageIndex = request.getParameter("pageIndex");//第几页
        if (pageIndex != null && !(pageIndex.trim().equals(""))) {
            page.setIndex(Integer.parseInt(pageIndex));
        }
        boolean barCodeAccess = (productBarCode == null || productBarCode.trim().equals(""));
        boolean nameAccess = (productName == null || productName.trim().equals(""));
        if (barCodeAccess && nameAccess) {
            request.setAttribute("productList", productService.selectAll(page));
        } else if (barCodeAccess) {
             productVOList=productService.selectByProductName(new String(productName.getBytes("ISO-8859-1"), "UTF-8"), page);
            //参数传过来会乱码,要做字符编码转换
            count=productVOList.size();
            request.setAttribute("productList",productVOList);
        } else if (nameAccess) {
            productVOList=productService.selectByProductBarCode(productBarCode);
            count=productVOList.size();
            request.setAttribute("productList",productVOList);
        } else {
            productVOList=productService.select(productBarCode, productName);
            count=productVOList.size();
            request.setAttribute("productList",productVOList);
        }
        Integer i = count % PageConstant.size;//余数
        Integer j=count/PageConstant.size;//除数
        page.setTotal(i > 0 ? (j + 1) : j);//处理总页数
        //将分页信息传过去
        request.setAttribute("page", page);
        request.setAttribute("productBarCode",productBarCode);
        request.setAttribute("productName",productName);

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
