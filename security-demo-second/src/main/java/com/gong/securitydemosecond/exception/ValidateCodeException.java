package com.gong.securitydemosecond.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author GEEX616
 * @create 2019-09-11 13:09
 * @desc
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -75098325592950112L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
