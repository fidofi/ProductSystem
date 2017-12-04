package com.fidofi.repository;

import com.fidofi.model.Page;
import com.fidofi.model.Product;

import java.util.List;

/**
 * Created by fido on 2017/10/1.
 * 商品的数据访问操作
 */
public interface ProductRepository {
    /**
     * 增加商品
     *
     * @param product
     * @return
     */
    public void create(Product product);

    /**
     * 删除商品
     *
     * @param productBarCode
     */
    public void delete(String productBarCode);

    public void deleteByList(List<String> productBarCode);

    /**
     * 更新商品
     *
     * @param product
     * @return
     */
    public void update(Product product);

    /**
     * 查询商品
     *
     * @param productBarCode
     * @param productName
     * @return
     */
    public Product read(String productBarCode, String productName);

    public List<Product> readByProductName(String productName, Page page);

    public Product readByCategoryCode(String productBarCode);

    public List<Product> readAll(Page page);

    public Integer count();

    /**
     * 增加库存
     *
     * @param productBarCode
     */
    public void increaseStock(String productBarCode);

    /**
     * 减少库存
     *
     * @param productBarCode
     */
    public void decreaseStock(String productBarCode);


    /**
     * 根据传来的价格排序规则和类别排序显示的商品
     * @param role
     * @param categoryCode
     * @return
     */
    public List<Product> readOrderBy(Integer role,Integer categoryCode,Float start,Float end);

    /**
     * 根据传过来的数量增加对应的库存
     * @param productBarCode
     * @param count
     */
    public void increaseByCount(String productBarCode,Integer count);

    /**
     * 得到新品
     * @return
     */
    public List<Product> getNew();

    /**
     * 得到特价品
     * @return
     */
    public List<Product> getDiscount();
}
