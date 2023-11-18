create database RailwayCrossing;
use RailwayCrossing;

drop database RailwayCrossing;

create table railwayCrossingData (
crossingId int auto_increment,
crossingName varchar(50),
address varchar(50),
landmark varchar(50),
trainSchedule time,
personInCharge varchar(50),
statusCrossing varchar(20),
primary key(crossingId));

desc railwayCrossingData ;

create table user(
userId int auto_increment,
userName varchar(50),
userEmail varchar(50),
userPassword varchar(50),
primary key(userId));

create table admin(
adminId int auto_increment,
adminEmail varchar(50),
adminPassword varchar(50),
primary key(adminId));

create table favouriteCrossing(
favId int auto_increment,
crossingId int,
primary key(favId),
foreign key(crossingId ) References railwayCrossingData(crossingId ));

select * from favouriteCrossing;

insert into favouriteCrossing(crossingId ) values(1);

insert into user (userName, userEmail, userPassword) values
("abc ", " abc@email.com" ,"abc123"),
("xyz ", "xyz@email.com " , "xyz456");

insert into admin (adminEmail, adminPassword) values
("admin@email.com" ,"admin123");

insert into railwayCrossingData(crossingName, address , landmark, trainSchedule, personInCharge , statusCrossing) values
( "Ishmeet Chowk Crossing ", " Ishmeet Singh near Party People" , "Ishmeet Singh near Party People ", "10:33:00"  ," David" , "OPEN "),
(" Midha Chowk Crossing" , " Midha Crossing", "Midha Crossing ", "10:40:00 ", "Robin ", "CLOSED" ),
("ABC", "ABC Crossing", "ABC Crossing", "11:40:00", "John", "OPEN");

select * from railwayCrossingData;

select * from user;

select * from admin;

delete from admin where adminId = 1;

select userName from user where userEmail = 'abc@email.com';

drop table admin;
drop table user;
drop table railwayCrossingData;
drop table favouriteCrossing;

select * from favouriteCrossing;

SELECT * FROM railwayCrossingData where crossingName LIKE '%owk%'; 

create table searchCrossing(crossingId int auto_increment,
crossingName varchar(50),
address varchar(50),
landmark varchar(50),
trainSchedule time,
personInCharge varchar(50),
statusCrossing varchar(20),
primary key(crossingId));
