package com.gong.securitydemosecond.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GEEX616
 * @create 2019-09-09 17:00
 * @desc
 **/
@Data
public class ResultVo<T> implements Serializable{
    private static final long serialVersionUID = -2512067269292159149L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
