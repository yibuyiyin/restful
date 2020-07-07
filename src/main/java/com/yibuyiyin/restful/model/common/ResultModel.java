package com.yibuyiyin.restful.model.common;

import com.yibuyiyin.restful.enums.common.error.ErrorInfo;
import io.netty.util.internal.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.var;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 返回结果Model
 *
 * @author peng.yu
 */
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = -4981931472107313393L;

    @Getter
    @Setter
    private HttpStatus status;

    @Getter
    @Setter
    private Integer errorCode;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Object data;

    @Getter
    @Setter
    private List<Map<String, String>> errorList;

    public ResultModel() {
        this.setMessage("success");
        this.setErrorCode(0);
        this.setStatus(HttpStatus.OK);
    }

    /**
     * 设置异常错误提示
     *
     * @param e
     */
    public void failure(Throwable e) {
        var message = e.getMessage();
        this.failure(message);
    }

    /**
     * 设置异常错误提示
     *
     * @param message
     */
    public void failure(String message) {
        if (!StringUtil.isNullOrEmpty(message)
                && EnumUtils.isValidEnum(ErrorInfo.class, message)) {
            this.failure(ErrorInfo.getEnum(message));
        } else {
            this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            this.setErrorCode(ErrorInfo.INTERNAL_SERVER_ERROR.getErrorCode());
            this.setMessage(message);
        }
    }

    /**
     * 设置错误提示
     *
     * @param errorInfo
     */
    public void failure(ErrorInfo errorInfo) {
        if (this.getStatus().equals(HttpStatus.OK)) {
            this.setStatus(HttpStatus.BAD_REQUEST);
        }
        this.setErrorCode(errorInfo.getErrorCode());
        this.setMessage(errorInfo.getErrorMessage());
    }

    /**
     * response
     *
     * @param resultModel
     * @return
     */
    public ResponseEntity response(ResultModel resultModel) {
        return new ResponseEntity(resultModel, resultModel.getStatus());
    }
}

