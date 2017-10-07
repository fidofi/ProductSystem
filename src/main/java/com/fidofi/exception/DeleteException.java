package com.fidofi.exception;

import com.fidofi.enums.ResultEnums;

/**
 * Created by fido on 2017/10/2.
 */
public class DeleteException extends RuntimeException  {
        private Integer code;

        public DeleteException(ResultEnums resultEnum) {
            super(resultEnum.getMessage());
            this.code = resultEnum.getCode();
        }
}
