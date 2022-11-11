package com.tuanmhoang.springstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String getSimpleDefaultPage(){
        return "Hello there!";
    }
}
