package com.gong.securitydemosecond.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GEEX616
 * @create 2019-09-09 15:06
 * @desc
 **/
@RestController
public class TestController {

    private static Logger logger= LoggerFactory.getLogger(TestController.class);


    @GetMapping("/get")
    public String get(){
        return "hello world3";
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        logger.info("用户登陆了.....");
        return new ModelAndView("login");
    }

    @GetMapping("/me1")
    public Object getCurrentUser1() {
        //方式1，直接从SecurityContextHolder中拿到Authentication对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal();
    }

    @GetMapping("/me2")
    public Object getCurrentUser2(Authentication authentication) {
        //方式2---方式1的简写版
        return authentication;
    }

    @GetMapping("/me3")
    public Object getCurrentUser3(@AuthenticationPrincipal UserDetails user) {
        //方式3，只获取User对象
        return user;
    }


}
