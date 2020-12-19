CREATE DATABASE if not exists `employee_dir`;
USE `employee_dir`;

drop table if exists `employee`;

create table `employee`(
`id` int(11) not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`email` varchar(45) default null,
primary key(`id`)
)engine=InnoDB auto_increment=1 DEFAULT CHARSET=latin1;


insert into employee values 
(1,'Elif','Akgun','elif.akgun13@gmail.com'),
(2,'John','Simith','john.simith@jmail.com'),
(3,'Alissa','May','alissa@jmail.com');
