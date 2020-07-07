package com.yibuyiyin.restful.exception;

import com.yibuyiyin.restful.enums.common.error.ErrorInfo;

/**
 * API 调用异常类
 */
public class ApiInvokeException extends RuntimeException {

    private static final long serialVersionUID = -7071599441063832218L;

    public ApiInvokeException() {
    }
    
    public ApiInvokeException(final ErrorInfo errorInfo, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(errorInfo.name(), cause, enableSuppression, writableStackTrace);
    }
    
    public ApiInvokeException(final ErrorInfo errorInfo, final Throwable cause) {
        super(errorInfo.name(), cause);
    }

    public ApiInvokeException(final ErrorInfo errorInfo) {
        super(errorInfo.name());
    }
    
    public ApiInvokeException(final Throwable cause) {
        super(cause);
    }
}

