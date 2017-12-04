package com.fidofi.vo;

import com.fidofi.constant.ResponseCode;

/**
 * Created by fido on 2017/11/28.
 */
public class ResultVO<T> {
    private Integer code;//状态码
    private String message;//消息
    private T data;//数据

    public ResultVO() {
    }

    public ResultVO(Integer code) {
        this.code = code;
    }

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(Integer code, T data) {
        this.code = code;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //判断返回的结果是否成功
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ResultVO<T> createBySuccess() {
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResultVO<T> createBySuccess(String message) {
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ResultVO<T> createBySuccess(T data) {
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResultVO<T> createBySuccess(String message, T data) {
        return new ResultVO<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultVO<T> createByError() {
        return new ResultVO<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ResultVO<T> createByError(String message) {
        return new ResultVO<T>(ResponseCode.ERROR.getCode(), message);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
