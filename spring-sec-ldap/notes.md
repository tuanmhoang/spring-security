Reference:
- https://spring.io/guides/gs/authenticating-ldap/

Steps to do:

1. Add dependencies

If we add this one, it is not working...

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-ldap</artifactId>
		</dependency>
```

Add these dependencies as the document mentions

```
		<dependency>
			<groupId>org.springframework.ldap</groupId>
			<artifactId>spring-ldap-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-ldap</artifactId>
		</dependency>
		<dependency>
			<groupId>com.unboundid</groupId>
			<artifactId>unboundid-ldapsdk</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```

2. Setup LDAP in properties

```
spring.ldap.embedded.port=8389
spring.ldap.embedded.ldif=classpath:ldap-data.ldif
spring.ldap.embedded.base-dn=dc=springframework,dc=org
```

3. Get LDAP file setup

Can refer this step in Spring tutorial

4. Setup configuration

```
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize ->
                        authorize
                                .anyRequest()
                                .fullyAuthenticated()
                )
                .formLogin()
                .and()
                .build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword");
    }
}
```