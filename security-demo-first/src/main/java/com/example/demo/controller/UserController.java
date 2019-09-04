package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @RequestMapping("index")
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("index/error")
    public ModelAndView getIndexError(){
        return new ModelAndView("error");
    }

}
