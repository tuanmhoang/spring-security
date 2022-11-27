package com.tuanmhoang.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String getDefaultUrl(){
        return "Default URL";
    }

    @GetMapping("/user")
    public String getUserUrl(){
        return "User URL";
    }

    @GetMapping("/admin")
    public String getAdminUrl(){
        return "Admin URL";
    }
}
