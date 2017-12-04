package com.fidofi.service.impl;

import com.fidofi.model.Page;
import com.fidofi.model.Product;
import com.fidofi.repository.ProductRepository;
import com.fidofi.repository.impl.ProductRepositoryImpl;
import com.fidofi.service.ProductService;
import com.fidofi.utils.CategoryCodeUtils;
import com.fidofi.utils.ProductVOUtils;
import com.fidofi.vo.ProductVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/10/2.
 */
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    /**
     * 增加商品
     *
     * @param product
     * @return 是否增加成功
     */
    public Product create(Product product) {
        productRepository.create(product);
        return productRepository.readByCategoryCode(product.getProductBarCode());
    }

    /**
     * 更新商品
     *
     * @param productVO
     * @return
     */
    public ProductVO update(ProductVO productVO) {
        Product product = ProductVOUtils.getProduct(productVO);
        product.setProductId(productRepository.readByCategoryCode(product.getProductBarCode()).getProductId());
        productRepository.update(product);
        return ProductVOUtils.getProductVO(product);
    }

    public void delete(String productBarCode) {
        productRepository.delete(productBarCode);
    }

    public void delete(List<String> productBarCodeList) {
        productRepository.deleteByList(productBarCodeList);
    }

    public List<ProductVO> selectByProductBarCode(String productBarCode) {
        List<Product> productList = null;
        Product product = productRepository.readByCategoryCode(productBarCode);
        if (product != null) {
            productList = new ArrayList<Product>();
            productList.add(product);
        }
        return ProductVOUtils.getProductVOList(productList);
    }

    public List<ProductVO> selectByProductName(String productName, Page page) {
        return ProductVOUtils.getProductVOList(productRepository.readByProductName(productName, page));
    }

    public List<ProductVO> select(String productBarCode, String productName) {
        List<Product> productList = null;
        Product product = productRepository.read(productBarCode, productName);
        if (product != null) {
            productList = new ArrayList<Product>();
            productList.add(product);
        }
        return ProductVOUtils.getProductVOList(productList);

    }

    public List<ProductVO> selectAll(Page page) {
        return ProductVOUtils.getProductVOList(productRepository.readAll(page));
    }

    public Integer count() {
        return productRepository.count();
    }

    public void increase(String productBarCode) {
        productRepository.increaseStock(productBarCode);
    }

    public void decrease(String productBarCode) {
        productRepository.decreaseStock(productBarCode);
    }

    public List<ProductVO> readOrderBy(Integer role, String categoryName, Float start, Float end) {
        Integer categoryCode = CategoryCodeUtils.getCode(categoryName);
        return ProductVOUtils.getProductVOList(productRepository.readOrderBy(role, categoryCode, start, end));
    }

    public void increaseByCount(String productBarCode, Integer count) {
        productRepository.increaseByCount(productBarCode, count);
    }

    public List<ProductVO> getNew() {
        return ProductVOUtils.getProductVOList(productRepository.getNew());
    }

    public List<ProductVO> getDiscount() {
        return ProductVOUtils.getProductVOList(productRepository.getDiscount());
    }
}
