package com.fidofi.enums;

/**
 * Created by fido on 2017/10/1.
 * 返回结果的状态信息
 */
public enum ResultEnums {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    LIST_NOT_EXIST(11,"商品结果集不存在")
    ;
    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
