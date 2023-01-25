drop table if exists authorities;
drop table if exists users;
drop index if exists ix_auth_username;

create table users(
    id serial,
	username text not null primary key,
	password text not null,
	enabled boolean not null
);

create table authorities (
    id serial,
	username text not null,
	authority text not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);