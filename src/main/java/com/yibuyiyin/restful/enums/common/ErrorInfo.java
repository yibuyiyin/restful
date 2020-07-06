package com.yibuyiyin.restful.enums.common;

/**
 * 错误信息枚举
 * 
 * @author admin
 *
 */
public enum ErrorInfo {
	FIELD_ERROR(100, "字段传值错误"),
	PARAM_ERROR(101, "参数错误"),
	DATA_ERROR(102, "数据错误"),
	EXPIRE(103, "登录过期"),
	AUTH_ERROR(104, "认证错误"),
	;

	private Integer errorCode;
	private String errorMessage;

	private ErrorInfo(final Integer errorCode, final String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorName() {
		return this.name();
    }

	public Integer getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(final Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
