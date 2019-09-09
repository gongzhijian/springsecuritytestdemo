package com.gong.securitydemosecond.Enums;


public enum ResultEnum {
    SUCCESS(0, "成功"),
    UNAUTHORIZED(800, "访问的服务需要身份认证，请引导用户到登录页"),
    LOGINFAILURE(801,"认证失败")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}