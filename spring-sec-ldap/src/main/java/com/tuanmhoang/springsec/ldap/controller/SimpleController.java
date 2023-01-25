package com.tuanmhoang.springsec.ldap.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
