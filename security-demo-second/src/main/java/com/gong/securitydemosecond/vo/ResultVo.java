package com.gong.securitydemosecond.vo;


import java.io.Serializable;

/**
 * @author GEEX616
 * @create 2019-09-09 17:00
 * @desc
 **/
public class ResultVo<T> implements Serializable{
    private static final long serialVersionUID = -2512067269292159149L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
