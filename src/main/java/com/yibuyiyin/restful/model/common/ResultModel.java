package com.yibuyiyin.restful.model.common;

import com.yibuyiyin.restful.enums.common.ErrorInfo;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

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

    public ResultModel() {
        this.setMessage("success");
        this.setErrorCode(0);
        this.setStatus(HttpStatus.OK);
    }

    public void failure(Throwable e) {
//        this.setRetcode(1);
//        if (e != null) {
//            this.setMsg(e.getMessage());
//        } else {
//            this.setMsg("failure");
//        }
    }

    /**
     * 返回错误提示
     *
     * @param errorInfo
     */
    public void failure(ErrorInfo errorInfo) {
        this.setStatus(HttpStatus.BAD_REQUEST);
        this.setErrorCode(errorInfo.getErrorCode());
        this.setMessage(errorInfo.getErrorMessage());
    }

    public void failure() {
    }

    public ResponseEntity response(ResultModel resultModel) {
        return new ResponseEntity(resultModel, resultModel.getStatus());
    }

    public String toString() {
        return "JsonModel [retcode=" + this.getErrorCode()
                + ", data=" + this.getData()
                + ", msg=" + this.getMessage() + "]";
    }
}

