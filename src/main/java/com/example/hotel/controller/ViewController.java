package com.example.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("user");
    }
    @RequestMapping("/employee")
    public ModelAndView employee(){
        return new ModelAndView("employee");
    }
    @RequestMapping("/client")
    public ModelAndView client(){
        return new ModelAndView("client");
    }
    @RequestMapping("/room")
    public ModelAndView room(){
        return new ModelAndView("room");
    }
    @RequestMapping("/check")
    public ModelAndView check(){
        return new ModelAndView("check");
    }
    @RequestMapping("/unAuthor")
    public ModelAndView unAuthor(){
        return new ModelAndView("unAuthor");
    }
}
