package com.fidofi.service;

import com.fidofi.enums.ResultEnums;
import com.fidofi.model.Page;
import com.fidofi.model.Product;
import com.fidofi.repository.ProductRepository;
import com.fidofi.repository.impl.ProductRepositoryImpl;
import com.fidofi.vo.ProductVO;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fido on 2017/10/2.
 * 商品的业务逻辑
 */
public interface ProductService {
    Product create(Product product);

    void delete(String productBarCode);

    void delete(List<String> productBarCodeList);

    ProductVO update(ProductVO productVO);

    List<ProductVO> selectByProductBarCode(String productBarCode);

    List<ProductVO> selectByProductName(String productName, Page page);

    List<ProductVO> select(String productBarCode, String productName);

    List<ProductVO> selectAll(Page page);

    Integer count();

    void increase(String productBarCode);

    void decrease(String productBarCode);

    List<ProductVO> readOrderBy(Integer role, String categoryName, Float start, Float end);

    void increaseByCount(String productBarCode, Integer count);

    List<ProductVO> getNew();

    List<ProductVO> getDiscount();
}
