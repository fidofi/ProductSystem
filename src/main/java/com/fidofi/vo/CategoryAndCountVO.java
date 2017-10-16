package com.fidofi.vo;

/**
 * Created by fido on 2017/10/14.
 * 给前端用的VO对象
 */
public class CategoryAndCountVO {
    private String categoryCode;//类目名称
    private Integer originStock;//类目总的初始上架量
    private Integer productStock;//类目总库存
    private Integer sell;//总销量

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getOriginStock() {
        return originStock;
    }

    public void setOriginStock(Integer originStock) {
        this.originStock = originStock;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "CategoryAndCountVO{" +
                "categoryCode='" + categoryCode + '\'' +
                ", originStock=" + originStock +
                ", productStock=" + productStock +
                ", sell=" + sell +
                '}';
    }
}
