package com.fidofi.repository.impl;

import com.fidofi.constant.PageConstant;
import com.fidofi.model.Page;
import com.fidofi.model.Product;
import com.fidofi.repository.ProductRepository;
import com.fidofi.utils.BarCodeUtils;
import com.fidofi.utils.DB.impl.BeanHandler;
import com.fidofi.utils.DB.impl.BeanListHandler;
import com.fidofi.utils.DBUtils;
import com.fidofi.utils.KeyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fido on 2017/10/1.
 * 商品的dao操作
 */
public class ProductRepositoryImpl implements ProductRepository {
    private static final String field = "productId,productName,productDescription,productPrice,productPhoto,productBarCode,categoryCode,originStock,productStock,discount,isNew";

    public void create(Product product) {
        String sql = "insert into product(" + field + ")" + "values(?,?,?,?,?,?,?,?,?,?,?)";
        String productId = KeyUtils.getKey();
        String productBarCode = BarCodeUtils.getBarCode(productId, product.getCategoryCode());
        Object[] args = {productId, product.getProductName(), product.getProductDescription(), product.getProductPrice()
                , product.getProductPhoto(), productBarCode, product.getCategoryCode(), product.getOriginStock(), product.getOriginStock()
                , product.getDiscount(), product.getNew()};
        DBUtils.update(sql, args);

    }

    public void delete(String productBarCode) {
        String sql = "delete from product where productBarCode = ?";
        Object[] args = {productBarCode};
        DBUtils.update(sql, args);
    }

    public void update(Product product) {

        String sql = "update product set productName=? ,productDescription=?,productPrice=?," +
                "productPhoto=?,categoryCode=?,productStock=?,originStock=?,discount=?,isNew=? where productBarCode=?";
        Object[] args = {product.getProductName(), product.getProductDescription(),
                product.getProductPrice(), product.getProductPhoto(), product.getCategoryCode(), product.getProductStock(), product.getOriginStock(), product.getDiscount(), product.getNew(),product.getProductBarCode()
        };
        DBUtils.update(sql, args);
    }

    /**
     * 根据用户输入条形码和商品名字查询
     * 只有一条记录或没有记录
     *
     * @param productBarCode
     * @param productName
     * @return
     */
    public Product read(String productBarCode, String productName) {
        String sql = "select " + field + " from product where productBarCode=? and productName= ?";
        Object[] args = {productBarCode, "%" + productName + "%"};
        return (Product) DBUtils.select(new BeanHandler(Product.class), sql, args);
    }

    /**
     * 根据商品名字查询
     * 可查询多个结果
     *
     * @param productName
     * @return
     */
    public List<Product> readByProductName(String productName, Page page) {
        String sql = "select " + field + " from product where productName like ? limit ?,?";
        Integer startIndex = ((page.getIndex() - 1) * PageConstant.size);
        Object[] args = {"%" + productName + "%", startIndex, PageConstant.size};
        return (List<Product>) DBUtils.select(new BeanListHandler(Product.class), sql, args);
    }

    /**
     * 根据条形码来查询商品
     * 只有一条记录或没有记录
     *
     * @param productBarCode
     * @return
     */
    public Product readByCategoryCode(String productBarCode) {
        String sql = "select " + field + " from product where productBarCode=? ";
        Object[] args = {productBarCode};
        return (Product) DBUtils.select(new BeanHandler((Product.class)), sql, args);
    }

    /**
     * 批量删除
     *
     * @param productBarCode
     */
    public void deleteByList(List<String> productBarCode) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < productBarCode.size(); i++) {
            if (i == productBarCode.size() - 1) {
                buffer.append("?");
                break;
            }
            buffer.append("?" + ", ");
        }
        String sql = "delete from product where productBarCode in (" + buffer.toString() + ")";
        Object[] args = new Object[productBarCode.size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = productBarCode.get(i);
        }
        DBUtils.update(sql, args);
    }

    public List<Product> readAll(Page page) {
        String sql = "select " + field + " from product limit ?,?";
        Integer startIndex = ((page.getIndex() - 1) * PageConstant.size);
        Object[] args = {startIndex, PageConstant.size};
        return (List<Product>) DBUtils.select(new BeanListHandler(Product.class), sql, args);
    }

    //查一共几条记录
    public Integer count() {
        String sql = "select count(productBarCode) from product";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, ps, rs);
        }
        return count;

    }

    /**
     * 增加库存
     *
     * @param productBarCode
     */
    public synchronized void increaseStock(String productBarCode) {
        Product product = this.readByCategoryCode(productBarCode);
        Integer productStock = product.getProductStock();
        product.setProductStock(productStock + 1);
        this.update(product);
    }

    /**
     * 减少库存
     *
     * @param productBarCode
     */
    public synchronized void decreaseStock(String productBarCode) {
        Product product = this.readByCategoryCode(productBarCode);
        Integer productStock = product.getProductStock();
        product.setProductStock(productStock - 1);
        this.update(product);
    }

    /**
     * 根据类别和价格排序
     *
     * @param role
     * @param categoryCode
     * @return
     */
    public List<Product> readOrderBy(Integer role, Integer categoryCode, Float start, Float end) {
        String sql = null;
        //默认是升序
        String orderRole = "ASC";
        //降序
        if (role == 1) {
            orderRole = "DESC";
        }
        //升序
        if (role == 2) {
            orderRole = "ASC";
        }
        if (start == null || end == null) {
            sql = "SELECT " + field + " FROM product WHERE categoryCode=? ORDER BY productPrice " + orderRole;
            Object[] args = {categoryCode};
            return (List<Product>) DBUtils.select(new BeanListHandler(Product.class), sql, args);
        } else {
            sql = "SELECT " + field + " FROM product WHERE categoryCode=? and productPrice between ? and ? ORDER BY productPrice " + orderRole;
            Object[] args = {categoryCode, start, end};
            return (List<Product>) DBUtils.select(new BeanListHandler(Product.class), sql, args);
        }
    }

    public void increaseByCount(String productBarCode, Integer count) {
        String sql = "update product set productStock=productStock+? where productBarCode=?";
        Object[] args = {count, productBarCode};
        DBUtils.update(sql, args);

    }

    public List<Product> getNew() {
        String sql = "select " + field + " from product where isNew=true";
        Object[] args={};
        List<Product> productList=(List<Product>)DBUtils.select(new BeanListHandler(Product.class),sql,args);
        return productList;
    }

    public List<Product> getDiscount() {
        String sql = "select " + field + " from product where discount=true";
        Object[] args={};
        List<Product> productList=(List<Product>)DBUtils.select(new BeanListHandler(Product.class),sql,args);
        return productList;
    }
}
