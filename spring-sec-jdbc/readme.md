Spring security with H2 DB

Spring security db: https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/appendix-schema.html

General info:
- Default URL: http://localhost:8080/
- Login: http://localhost:8080/login
- Logout: http://localhost:8080/logout
- User: http://localhost:8080/user
- Admin: http://localhost:8080/admin
- h2: http://localhost:8080/h2-console/

Set `spring.h2.console.enabled=true` in `application.properties` to enable h2 db

By default, the url is `/h2-console` but this one can be overwritten by using `spring.h2.console.path=/h2-custom`

- https://stackoverflow.com/questions/24655684/spring-boot-default-h2-jdbc-connection-and-h2-console

To access to `h2-console`, need to ignore the web security:
- https://stackoverflow.com/questions/43794721/spring-boot-h2-console-throws-403-with-spring-security-1-5-2

> Since H2 has it's own authentication provider, you can skip the Spring Security for the path of h2 console entirely in the same way that you do for your static content.
>
> In order to do that, in your Spring security config, you have to override the configuration method which takes an instance of `org.springframework.security.config.annotation.web.builders.WebSecurity` as a parameter instead of the one which takes an instance of `org.springframework.security.config.annotation.web.builders.HttpSecurity`

To overwrite the `web security`, follow:
- https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

And apply this config

```
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**");
    }
```

Then the log shows

```
2022-11-20 11:42:17.700  WARN 1392 --- [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Ant [pattern='/h2-console/**']. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
2022-11-20 11:42:17.700  INFO 1392 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will not secure Ant [pattern='/h2-console/**']
```
