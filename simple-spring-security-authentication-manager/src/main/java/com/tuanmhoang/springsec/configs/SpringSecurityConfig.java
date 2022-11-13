package com.tuanmhoang.springsec.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        var userBuilder = User.withDefaultPasswordEncoder();
        var user = userBuilder
                .username("user")
                .password("123")
                .roles(UserRole.USER.name())
                .build();
        var admin = userBuilder
                .username("admin")
                .password("123")
                .roles(UserRole.USER.name(), UserRole.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user")
                .hasAnyRole(UserRole.ADMIN.name(), UserRole.USER.name())
                .antMatchers("/admin")
                .hasRole(UserRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return http.build();
    }

}
