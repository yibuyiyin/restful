package com.yibuyiyin.restful.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志工具类
 */
public class LogUtils {
    public static void error(final Logger logger, final Throwable t) {
        logger.error(ExceptionUtils.getStackTrace(t));
    }
    
    public static void controllerError(final Logger logger, final HttpServletRequest request, final Throwable t) {
        logger.error("请求url：{}, 请求参数：{}, 异常堆栈信息：{}", new Object[] { request.getRequestURL().toString(), request.getParameterMap().toString(), ExceptionUtils.getStackTrace(t) });
    }
}

