package com.tuanmhoang.springsec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum AppUser {

    USER("user", "user"),
    ADMIN("admin", "admin");

    private String user;
    private String role;


}
