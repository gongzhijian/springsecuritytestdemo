package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add");
    }

    @RequestMapping("/update")
    public ModelAndView update(){
        return new ModelAndView("update");
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("list") ;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(){
        return new  ModelAndView("delete");
    }
}
