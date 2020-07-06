package com.yibuyiyin.restful.exception;

import com.yibuyiyin.restful.enums.common.ErrorInfo;

/**
 * API 调用异常类
 */
public class ApiInvokeException extends RuntimeException {

    private static final long serialVersionUID = -7071599441063832218L;

    public ApiInvokeException() {
    }
    
    public ApiInvokeException(final ErrorInfo errorInfo, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(errorInfo, cause, enableSuppression, writableStackTrace);
    }
    
    public ApiInvokeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public ApiInvokeException(final String message) {
        super(message);
    }
    
    public ApiInvokeException(final Throwable cause) {
        super(cause);
    }
}

