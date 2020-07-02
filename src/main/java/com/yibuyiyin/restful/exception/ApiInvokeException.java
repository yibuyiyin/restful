package com.yibuyiyin.restful.exception;

/**
 * API 调用异常类
 * 
 * @author admin
 *
 */
public class ApiInvokeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ApiInvokeException() {
    }
    
    public ApiInvokeException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
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

