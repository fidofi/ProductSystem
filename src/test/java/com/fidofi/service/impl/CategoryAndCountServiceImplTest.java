package com.fidofi.service.impl;

import com.fidofi.model.CategoryAndCount;
import com.fidofi.model.Product;
import com.fidofi.service.CategoryAndCountService;
import com.fidofi.service.ProductService;
import com.fidofi.vo.ProductVO;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fido on 2017/10/14.
 * 关于商品类目相关信息封装
 */
public class CategoryAndCountServiceImplTest {
    private CategoryAndCountService categoryAndCountService = new CategoryAndCountServiceImpl();
    private ProductService productService=new ProductServiceImpl();

//    @Test
//        public void testReadOrderBy(){
//            List<ProductVO> list=productService.readOrderBy(2,"食品");
//            for(ProductVO producVO:list){
//                System.out.println(producVO);
//            }
//        }

}