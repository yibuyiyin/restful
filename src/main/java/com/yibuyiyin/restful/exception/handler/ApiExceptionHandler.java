package com.yibuyiyin.restful.exception.handler;

import com.yibuyiyin.restful.enums.common.error.ErrorInfo;
import com.yibuyiyin.restful.exception.ApiInvokeException;
import com.yibuyiyin.restful.model.common.ResultModel;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * API调用异常处理器
 */
@RestControllerAdvice
@Component
public class ApiExceptionHandler {
	private static final Logger logger;
	static {
		logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
	}

	@ExceptionHandler({ ApiInvokeException.class })
	public ResponseEntity apiInvokeException(final ApiInvokeException e, final HttpServletRequest request) {
		final Map<String, String[]> paramMap = (Map<String, String[]>) request.getParameterMap();
		final StringBuilder sb = new StringBuilder();
		for (final Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			sb.append(entry.getKey()).append(": ");
			final String[] values = entry.getValue();
			sb.append(String.join(",", (CharSequence[]) values)).append("; ");
		}

		ApiExceptionHandler.logger.error("调用api接口出错，接口路径->{}, 参数->{}, 异常信息->{}",
				new Object[] { request.getRequestURI(), sb.toString(), e.getMessage() });
		return this.processExceptionResponse(e, true);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity exception(final Exception e) {
		return this.processExceptionResponse(e, true);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity handleValidationError(final MethodArgumentNotValidException manve,
												final HttpServletRequest request) {
		final ResultModel resultModel = new ResultModel();
		final List<FieldError> fieldErrors = (List<FieldError>) manve.getBindingResult().getFieldErrors();
		final List<Map<Integer, String>> errorList = new ArrayList<Map<Integer, String>>();
		for (final FieldError fe : fieldErrors) {
			final Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(ErrorInfo.BAD_REQUEST.getErrorCode(), fe.getDefaultMessage());
			errorList.add(map);
		}
		resultModel.failure(ErrorInfo.BAD_REQUEST);
		resultModel.setErrorList(errorList);
		return resultModel.response(resultModel);
	}

	private ResponseEntity processExceptionResponse(final Exception e, final boolean doLog) {
		if (doLog) {
			ApiExceptionHandler.logger.error(ExceptionUtils.getStackTrace((Throwable) e));
		}
		String message = null;
		final Throwable rootException = e.getCause();
		if (rootException != null) {
			message = rootException.getMessage();
		} else {
			message = e.getMessage();
		}

		final ResultModel resultModel = new ResultModel();
		resultModel.failure(message);
		return resultModel.response(resultModel);
	}
}
