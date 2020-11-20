package com.keyt.test_1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping(value = "/")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "index")
    public String toIndex(){
        return "index";
    }
}
