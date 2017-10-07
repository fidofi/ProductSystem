package com.fidofi.exception;

import com.fidofi.enums.ResultEnums;

/**
 * Created by fido on 2017/10/1.
 */
public class GetListException extends  RuntimeException {
    private Integer code;

    public GetListException(ResultEnums resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}