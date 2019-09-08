package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author GEEX616
 * @create 2019-09-04 11:14
 * @desc
 **/
@Configuration(value = "myPasswordEncorder")
public class MyPasswordEncorder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
