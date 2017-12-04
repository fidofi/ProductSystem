package com.fidofi.controller;

import com.fidofi.constant.PageConstant;
import com.fidofi.model.Page;
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
 * Created by fido on 2017/11/7.
 * 实现区间查询
 */
public class OrderServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //      request.setCharacterEncoding("UTF-8");
         String categoryName=request.getParameter("categoryName");
         Integer role=Integer.parseInt(request.getParameter("role"));
         //获得价格区间
        String startMoney=request.getParameter("start");
        String endMoney=request.getParameter("end");
        Float start=null;
        Float end=null;
        if((startMoney!=null&&!startMoney.trim().equals(""))&&(endMoney!=null&&!endMoney.trim().equals(""))){
             start=Float.parseFloat(startMoney);
             end=Float.parseFloat(endMoney);
        }
         List<ProductVO> productVOList=productService.readOrderBy(role,new String(categoryName.getBytes("ISO-8859-1"), "UTF-8"),start,end);
         //当前选中的类别
         request.setAttribute("currentName",new String(categoryName.getBytes("ISO-8859-1"), "UTF-8"));
         request.setAttribute("productList",productVOList);
         request.setAttribute("categoryName", CategoryCodeUtils.categoryName());
         request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
