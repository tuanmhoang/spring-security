package com.tuanmhoang.springsec.config;

import com.tuanmhoang.springsec.model.AppUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user")
                .hasAnyAuthority(AppUser.USER.getAuthority(), AppUser.ADMIN.getAuthority())
                .antMatchers("/admin")
                .hasAnyAuthority(AppUser.ADMIN.getAuthority())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }
}
