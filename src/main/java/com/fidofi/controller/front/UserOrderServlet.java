package com.fidofi.controller.front;

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
 * 处理条件查询
 */
public class UserOrderServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        List<ProductVO> newProduct=productService.getNew();
        List<ProductVO> discountProduct=productService.getDiscount();
        //新品
        request.setAttribute("newProduct",newProduct);
        //特价品
        request.setAttribute("discountProduct",discountProduct);

        //当前选中的类别
        request.setAttribute("currentName",new String(categoryName.getBytes("ISO-8859-1"), "UTF-8"));
        request.setAttribute("productList",productVOList);
        request.setAttribute("categoryName", CategoryCodeUtils.categoryName());
        request.getRequestDispatcher("/WEB-INF/front/user_index.jsp").forward(request, response);
    }
}
