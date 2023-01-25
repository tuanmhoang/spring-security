package com.tuanmhoang.springsec.service;

import com.tuanmhoang.springsec.model.Authority;
import com.tuanmhoang.springsec.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class JpaUserDetails implements UserDetails {

    private String username;

    private String password;

    private List<SimpleGrantedAuthority> grantedAuthorities;

    public JpaUserDetails(User user, List<Authority> authorities){
        this.username =user.getUsername();
        this.password = user.getPassword();
        this.grantedAuthorities = authorities
                .stream()
                .map(a -> new SimpleGrantedAuthority("ROLE_"+ a.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
