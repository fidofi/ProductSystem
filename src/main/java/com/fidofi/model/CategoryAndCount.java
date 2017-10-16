package com.fidofi.model;

import java.math.BigDecimal;

/**
 * Created by fido on 2017/10/14.
 * 商品类目以及其销量和库存量封装
 */
public class CategoryAndCount {
    private Integer categoryCode;//商品类别
    private BigDecimal originStock;//该类别的所有初始上架数量
    private BigDecimal productStock;//该类别的所有剩余库存
    private BigDecimal sell;//销量

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    public BigDecimal getOriginStock() {
        return originStock;
    }

    public void setOriginStock(BigDecimal originStock) {
        this.originStock = originStock;
    }

    public BigDecimal getProductStock() {
        return productStock;
    }

    public void setProductStock(BigDecimal productStock) {
        this.productStock = productStock;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "CategoryAndCount{" +
                "categoryCode=" + categoryCode +
                ", originStock=" + originStock +
                ", productStock=" + productStock +
                ", sell=" + sell +
                '}';
    }
}
