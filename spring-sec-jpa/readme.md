## Problem
`java: class file has wrong version 61.0, should be 55.0`

Reference: 

- https://stackoverflow.com/questions/74648576/java-class-file-has-wrong-version-61-0-should-be-55-0
- https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html

>You're using Spring Framework 6, and since Spring 6, the minimum supported Java version is Java 17 (the class version 61 is the class version of Java 17).
>
>As documented in the Spring Framework Overview for Spring 6:
>
>As of Spring Framework 6.0, Spring requires Java 17+.
>So, if you want to use Spring 6, you need to upgrade to Java 17. If you want to continue using Java 11, you need to downgrade to Spring 5.3.


---

http.~~authorizeRequests()~~ is deprecated

Reference: https://stackoverflow.com/questions/74609057/how-to-fix-spring-authorizerequests-is-deprecated

>You can use authorizeHttpRequests instead of authorizeRequests and requestMatchers instead of antMatchers

---

`.map(a -> new SimpleGrantedAuthority("ROLE_"+ a.getAuthority()))`

Need the `ROLE_` because that is the default behavior of spring security

Reference: https://stackoverflow.com/questions/33205236/spring-security-added-prefix-role-to-all-roles-name

