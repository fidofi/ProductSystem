package com.fidofi.controller.front;

import com.fidofi.dto.Card;
import com.fidofi.model.Product;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by fido on 2017/11/29.
 * 清空购物车
 */
public class CleanCardServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Card card = (Card) request.getSession().getAttribute("card");
        if(card!=null){
            Map<String, Integer> map = card.getMap();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                productService.increaseByCount(entry.getKey(), entry.getValue());
            }
        }

        request.getSession().removeAttribute("card");
        request.getRequestDispatcher("/user/index").forward(request, response);
    }
}
