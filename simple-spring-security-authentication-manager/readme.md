Spring Security without the WebSecurityConfigurerAdapter: 
- https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
- https://stackoverflow.com/questions/72381114/spring-security-upgrading-the-deprecated-websecurityconfigureradapter-in-spring

Simple in memory user:
- https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html

Add
```
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
```

To set the authentication path, define bean to overwrite the filterChain

```
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
```

with this, all request need credentials
```
                .anyRequest()
                .authenticated()
```

When using the `antMatchers`, the default login page is not there and causes 404

https://github.com/spring-projects/spring-security/issues/4505

To start using the login page, simply add

```
                .formLogin();
```

Custom login page:
- https://stackoverflow.com/questions/50054993/spring-security-login-404
