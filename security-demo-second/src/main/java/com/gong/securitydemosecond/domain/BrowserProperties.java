package com.gong.securitydemosecond.domain;

import lombok.Data;

/**
 * @author GEEX616
 * @create 2019-09-10 17:11
 * @desc
 **/
@Data
public class BrowserProperties {
    //指定默认的登陆页面
    private String loginPage = "/login.html";
    //记住我的时间3600秒即1小时
    private int rememberMeSeconds = 3600;
}
