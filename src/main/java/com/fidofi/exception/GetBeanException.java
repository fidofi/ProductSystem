package com.fidofi.exception;

import com.fidofi.enums.ResultEnums;

/**
 * Created by fido on 2017/10/1.
 * 获取bean异常
 */
public class GetBeanException extends  RuntimeException {
    private Integer code;

    public GetBeanException(ResultEnums resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
