package com.tuanmhoang.springsec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppUser {
    USER("user"),
    ADMIN("admin");

    private String role;
}
