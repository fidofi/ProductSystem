package com.fidofi.controller.front;

import com.fidofi.dto.Card;
import com.fidofi.model.Product;
import com.fidofi.service.ProductService;
import com.fidofi.service.impl.ProductServiceImpl;
import com.fidofi.vo.ProductVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fido on 2017/11/28.
 * 购物车处理
 */
public class BuyServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获得操作
         String option=request.getParameter("type");
        //获得加入购物车的商品条形码
        String productBarCode = request.getParameter("productBarCode");
     if(option!=null&&productBarCode!=null){
         HttpSession session = request.getSession();
         //获得购物车
         Card card = (Card) session.getAttribute("card");
         if (card == null) {
             card = new Card();
         }
         Map<String, Integer> map = card.getMap();
         //如果之前已经存在的话，就数量+1
         if(option.equals("add")){
             if (map.containsKey(productBarCode)) {
                 map.put(productBarCode, map.get(productBarCode) + 1);
             } else {
                 map.put(productBarCode, 1);
             }
             productService.decrease(productBarCode);//调用减库存操作
         }
         //如果是减库存
         else if(option.equals("sub")){
             if((map.get(productBarCode))==1){
                 map.remove(productBarCode);
             }
             else {
                 map.put(productBarCode, map.get(productBarCode) - 1);
             }
             productService.increase(productBarCode);//调用加库存操作
         }
         Map<ProductVO,Integer> productMap=new HashMap<ProductVO, Integer>();
         Float moneyNum =new Float(0);//遍历map计算金额
         if(map.size()!=0){
             for (Map.Entry<String, Integer> entry : map.entrySet()) {
                 String barCode = entry.getKey();
                 ProductVO productVO = null;
                 List<ProductVO> list =productService.selectByProductBarCode(barCode);
                 if (list != null) {
                     productVO = list.get(0);
                     //存放对应商品及数量
                     productMap.put(productVO, entry.getValue());
                     moneyNum = moneyNum + productVO.getProductPrice() * entry.getValue();
                 }
             }
             card.setMoneyNum(moneyNum);
             card.setProductMap(productMap);
         }
         //如果购物车没东西就清空
         else
             card=null;
         session.setAttribute("card", card);
     }
        request.getRequestDispatcher("/WEB-INF/front/user_card.jsp").forward(request, response);
    }
}
