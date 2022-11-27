package com.tuanmhoang.springsec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppUser {
    USER("userpg","user"),
    ADMIN("adminpg","admin");

    private String user;

    private String authority;
}
