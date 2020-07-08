package com.yibuyiyin.restful.enums.common.error;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 错误信息枚举
 */
public enum ErrorInfo {
	// 客户端造成的错误
	BAD_REQUEST(400, "用户端错误请求"),
	UNAUTHORIZED(401, "用户未被认证"),
	FORBIDDEN(403, "用户无访问权限"),
	NOT_FOUND(404, "服务端无此资源"),

	// 服务端造成的错误
	INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
	NOT_IMPLEMENTED(501, "服务器暂不支持该功能"),
	SERVICE_UNAVAILABLE(503, "服务器正在维护中"),

	// 业务错误编码
	DEMO_UPDATE_FAIL(5000001, "DEMO更新失败「数据不存在」"),
	DEMO_DELETE_FAIL(5000002, "DEMO删除失败「数据不存在」"),
	;

	@Getter
	@Setter
	private Integer errorCode;

	@Getter
	@Setter
	private String errorMessage;

	private ErrorInfo(final Integer errorCode, final String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public static ErrorInfo getEnum(String name){
	    return ErrorInfo.valueOf(name);
	}
}
