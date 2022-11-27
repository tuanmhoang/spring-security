insert into users (username, "password", enabled)
values
    ('userpg', 'password', true),
    ('adminpg', 'password', true);

insert into authorities (username, authority)
values
    ('userpg', 'user'),
    ('adminpg', 'admin');