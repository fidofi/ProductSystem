package com.fidofi.enums;

/**
 * Created by fido on 2017/9/30.
 * 商品类目枚举
 */
public enum CategoryEnum {
    FOOD(1, "食品"),
    FRUIT(2,"生鲜"),
    BAG(3,"箱包"),
    WASH(4,"洗护"),
    MEDICINE(5,"医药"),
    BOOK(6,"图书"),
    PHONE(7,"手机"),
    HOUSEHOLD(8,"家电");
    private Integer code;//类目编号
    private String categoryName;//类目名称

    CategoryEnum(Integer code, String categoryName) {
        this.code = code;
        this.categoryName = categoryName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
