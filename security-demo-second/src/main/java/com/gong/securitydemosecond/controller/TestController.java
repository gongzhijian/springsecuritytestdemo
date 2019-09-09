package com.gong.securitydemosecond.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}
