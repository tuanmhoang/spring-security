package com.tuanmhoang.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/")
    public String getDefault(){
        return "Default";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Welcome admin!";
    }

    @GetMapping("/user")
    public String getUser(){
        return "Welcome user!";
    }
}
