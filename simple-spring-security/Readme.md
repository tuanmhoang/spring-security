### Problem

IDE says

```
Process finished with exit code 0
```

Then shut down

### Solution

Add this dependency to start tomcat

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>
```

---

### Problem

To start the default login URL: http://localhost:8080/login

### Solution

Add this dependency

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

---

### Problem

Default password?

### Solution

Spring boot security auto generates password in the console

```
Using generated security password: 0e4cdd2e-8ec2-49e1-9d1d-8c011f1d59b0
```

And the default user is `user`

---

### Problem

To have a default page?

### Solution

Add a simple controller

```
@RestController
public class SimpleController {

    @GetMapping("/")
    public String getSimpleDefaultPage(){
        return "Hello there!";
    }
}
```

---
### Problem

Change username password quick way?

### Solution

Add to properties file

```
spring.security.user.name=tuan
spring.security.user.password=hoang
```