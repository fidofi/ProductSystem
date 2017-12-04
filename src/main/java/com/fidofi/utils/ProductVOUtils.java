package com.fidofi.utils;

import com.fidofi.model.Product;
import com.fidofi.vo.ProductVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/10/4.
 * 数据库模型与展示层模型转换
 */
public class ProductVOUtils {

    public static ProductVO getProductVO(Product product) {
        if (product == null) {
            return null;
        }
        ProductVO productVO = new ProductVO();
        productVO.setProductPrice(product.getProductPrice());
        productVO.setProductName(product.getProductName());
        productVO.setCategoryCode(CategoryCodeUtils.getStr(product.getCategoryCode()));
        productVO.setProductDescription(product.getProductDescription());
        productVO.setProductBarCode(product.getProductBarCode());
        productVO.setProductPhoto(product.getProductPhoto());
        productVO.setProductStock(product.getProductStock());
        productVO.setOriginStock(product.getOriginStock());
        productVO.setIsNew(product.getNew());
        productVO.setDiscount(product.getDiscount());
        return productVO;
    }

    public static List<ProductVO> getProductVOList(List<Product> productList) {
        if (productList == null || productList.size() == 0) {
            return null;
        }
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (int i = 0; i < productList.size(); i++) {
            productVOList.add(getProductVO(productList.get(i)));
        }
        return productVOList;
    }

    public static Product getProduct(ProductVO productVO) {
        Product product = new Product();
        product.setCategoryCode(CategoryCodeUtils.getCode(productVO.getCategoryCode()));
        product.setProductName(productVO.getProductName());
        product.setProductBarCode(productVO.getProductBarCode());
        product.setProductPhoto(productVO.getProductPhoto());
        product.setProductPrice(productVO.getProductPrice());
        product.setProductDescription(productVO.getProductDescription());
        product.setProductStock(productVO.getProductStock());
        product.setOriginStock(productVO.getOriginStock());
        product.setDiscount(productVO.getDiscount());
        product.setNew(productVO.getIsNew());
        return product;
    }
}
