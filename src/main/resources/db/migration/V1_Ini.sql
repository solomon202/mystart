
    create table todo (
    id  bigserial not null,
    completed boolean, 
    description varchar(255),
    title varchar(255), 
    user_id int8,
    primary key (id))
    
    create table users 
    (
    id  bigserial not null, 
    password varchar(255), 
    username varchar(255),
    primary key (id))
);