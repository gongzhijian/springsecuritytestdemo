package com.example.demo.controller;

import com.example.demo.dao.alpha.UserMapper;
import com.example.demo.dao.beta.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private StudentMapper studentMapper;


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


    @RequestMapping("/test")
    public Object test(){
    return studentMapper.selectAll();
    }

}
