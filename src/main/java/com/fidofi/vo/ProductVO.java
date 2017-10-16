package com.fidofi.vo;

/**
 * Created by fido on 2017/10/4.
 * 给展示层用的
 */
public class ProductVO {
    private String productName;//商品名称
    private String productDescription;//商品描述
    private Float productPrice;//商品价格
    private String productPhoto;//商品图片
    private String productBarCode;//商品条形码
    private String categoryCode;//商品类目名称
    private Integer productStock;//商品库存
    private Integer originStock;//商品初始数量

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getOriginStock() {
        return originStock;
    }

    public void setOriginStock(Integer originStock) {
        this.originStock = originStock;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productPhoto='" + productPhoto + '\'' +
                ", productBarCode='" + productBarCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", productStock=" + productStock +
                ", originStock=" + originStock +
                '}';
    }
}
