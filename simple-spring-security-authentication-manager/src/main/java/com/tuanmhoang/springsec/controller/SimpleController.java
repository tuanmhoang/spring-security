package com.tuanmhoang.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String getDefaultPage(){
        return "Hello! This is default page";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "Hello Admin!";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "Hello User!";
    }
}
