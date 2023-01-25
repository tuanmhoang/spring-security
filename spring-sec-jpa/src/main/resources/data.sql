insert into users (username, "password", enabled)
values
    ('userpg', '{noop}password', true),
    ('adminpg', '{noop}password', true);

insert into authorities (username, authority)
values
    ('userpg', 'user'),
    ('adminpg', 'admin');