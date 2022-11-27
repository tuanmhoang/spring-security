## URLs to test

- default: http://localhost:8080/
- user: http://localhost:8080/user
- admin: http://localhost:8080/admin

---

## Problems and solutions

`docker: 'compose' is not a docker command.`

Run `brew install docker-compose`

In case there is still error, try:

```
$ mkdir -p ~/.docker/cli-plugins
$ ln -sfn /opt/homebrew/opt/docker-compose/bin/docker-compose ~/.docker/cli-plugins/docker-compose
```

Reference: 
- https://stackoverflow.com/questions/36685980/why-is-docker-installed-but-not-docker-compose
- https://github.com/docker/compose/issues/8630#issuecomment-1169537632

---

`schema.sql` is not executed

- https://stackoverflow.com/questions/49438517/why-spring-boot-2-0-application-does-not-run-schema-sql

Use `spring.sql.init.mode=always` in properties

> As of Spring Boot Version 2.7
> 
> the property spring.datasource.initialization-mode has been removed.
>
> You should from this version and onwards use the replacement property spring.sql.init.mode
> 
> Example: `spring.sql.init.mode:always`
> 
> https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.7.0-Configuration-Changelog

---

```
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
```

Reference: 
- https://stackoverflow.com/questions/49654143/spring-security-5-there-is-no-passwordencoder-mapped-for-the-id-null
- https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-storage-format

Also need to change from db data using `{noop}`
```
insert into users (username, "password", enabled)
values
    ('userpg', '{noop}password', true),
    ('adminpg', '{noop}password', true);
```