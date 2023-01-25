package com.tuanmhoang.springsec.config;

import com.tuanmhoang.springsec.model.AppUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/user")
                                .hasAnyRole(AppUser.USER.getRole(), AppUser.ADMIN.getRole())
                                .requestMatchers("/admin")
                                .hasAnyRole(AppUser.ADMIN.getRole())
                                .anyRequest()
                                .authenticated()
                )
                .formLogin()
                .and()
                .build();
    }

//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username(AppUser.USER.getUser())
//                .password("password")
//                .roles(AppUser.USER.getRole())
//                .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username(AppUser.ADMIN.getUser())
//                .password("password")
//                .roles(AppUser.ADMIN.getRole(), AppUser.USER.getRole())
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }
}
