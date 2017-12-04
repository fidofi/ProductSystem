package com.fidofi.controller.front;

import com.fidofi.constant.PageConstant;
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
 * Created by fido on 2017/11/28.
 * 首页展示
 */
public class IndexServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page=new Page();
        page.setIndex(1);
        Integer count=productService.count();//总记录数
        String pageIndex = request.getParameter("pageIndex");//第几页
        if (pageIndex != null && !(pageIndex.trim().equals(""))) {
            page.setIndex(Integer.parseInt(pageIndex));
        }

        Integer i = count % PageConstant.size;//余数
        Integer j=count/PageConstant.size;//除数
        page.setTotal(i > 0 ? (j + 1) : j);//处理总页数
        List<ProductVO> productList=productService.selectAll(page);
        List<ProductVO> newProduct=productService.getNew();
        List<ProductVO> discountProduct=productService.getDiscount();
        //将分页信息传过去
        request.setAttribute("page", page);
        request.setAttribute("productList",productList);
        //传递分类列表过去
        request.setAttribute("categoryName", CategoryCodeUtils.categoryName());
        //新品
        request.setAttribute("newProduct",newProduct);
        //特价品
        request.setAttribute("discountProduct",discountProduct);
        request.getRequestDispatcher("/WEB-INF/front/user_index.jsp").forward(request,response);
    }
}
