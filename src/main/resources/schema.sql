create table User (
    id int not null,
    email varchar(50) not null PRIMARY KEY,
    password varchar(50) not null,
    username varchar(50) not null
);

create table Available_Categories (
    id int not null,
    email varchar(50) not null,
    name varchar(50) not null,
    available_Content int not null,
    price decimal(3,1) not null
);

create table Subscribed_Categories (
    id int not null AUTO_INCREMENT,
    email varchar(50) not null,
    name varchar(50) not null,
    remaining_Content int not null,
    price decimal(3,1) not null,
    start_Date date
);