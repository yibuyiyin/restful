package com.yibuyiyin.restful.model.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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
    private Integer retcode;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private Object data;

    public ResultModel() {
        this.setMsg("success");
        this.setRetcode(2000000);
    }

    public void failure(Throwable e) {
        this.setRetcode(0);
        if (e != null) {
            this.setMsg(e.getMessage());
        } else {
            this.setMsg("failure");
        }
    }

    public void failure(String errMessage) {
        this.setRetcode(0);
        if (StringUtils.isNotBlank(errMessage)) {
            this.setMsg(errMessage);
        } else {
            this.setMsg("failure");
        }
    }

    public void failure() {
        this.setRetcode(0);
        this.setMsg("failure");
    }

    public String toString() {
        return "JsonModel [retcode=" + this.getRetcode()
                + ", data=" + this.getData()
                + ", msg=" + this.getMsg() + "]";
    }
}

