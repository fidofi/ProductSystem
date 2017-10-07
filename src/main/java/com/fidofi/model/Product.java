package com.fidofi.model;

/**
 * Created by fido on 2017/9/30.
 * 商品类
 */
public class Product {
    private String productId; //商品ID
    private String productName;//商品名称
    private String productDescription;//商品描述
    private Float productPrice;//商品价格
    private String productPhoto;//商品图片
    private String productBarCode;//商品条形码
    private Integer categoryCode;//商品类目编号

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productPhoto='" + productPhoto + '\'' +
                ", productBarCode='" + productBarCode + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
