create database LearnerAcademy;

use LearnerAcademy;

create table teacher( teacherId int auto_increment , teacherName varchar(50) , teacherDesignation varchar(50), PRIMARY KEY(teacherId));
desc teacher;

create table subject( subjectId int auto_increment, subjectName varchar(50), primary key(subjectId));
desc subject;

create table classes (
classId int auto_increment, 
className varchar(50),
teacherId int ,
subjectId int ,
primary key(classId),
foreign key(teacherId) References teacher(teacherId),
foreign key(subjectId) References subject(subjectId)
);

create table student (
studentId int auto_increment,
studentName varchar(50) NOT NULL,
studentAddress varchar(50),
studentPhoneNo varchar(50),
studentDOB date NOT NULL,
classId int ,
primary key(studentId),
foreign key(classId) References classes(classId)
);

desc classes;

insert into classes(className, teacherId, subjectId) values
("BE-CSE", 2, 3),
("BE-ISE", 3, 4),
("BE-ECE" , 4, 2),
("BCA", 3, 5),
("MCA", 3, 1);

select * from classes;

insert into student( studentName, studentAddress, studentPhoneNo, studentDOB, classId) values
("A " , "Bangalore " , "9876345222 " , "2000-08-10" ,  1),
("S" , " Madurai" , " 9498755631" , "2000-07-23" , 3 ),
("C " , " Hyderabad" , "8866542322 " , "2001-06-01" ,  4),
("D " , "Bangalore " , "9669785258 " , " 2002-01-20" , 5 ),
("E " , "Pune " , "8869675252 " , "2001-02-04" , 2 ),
("F " , " Palakkad" , " 8644294562" , "2001-05-19" ,  4),
("G " , "Bangalore " , "9669488524 " , "1998-10-10" ,  2),
("H " , " Pune" , "9889634524" , "2000-03-11" ,  1),
("I" , " Chennai" , " 8866254542" , "1999-12-01" ,  3),
("J " , "Kozhikode " , "9889655425" , "2000-05-04 " ,  5);

select * from student;

desc student;
 
insert into teacher (teacherName, teacherDesignation) values
("Yejin", "Professor"),
("Suzy", "Assistant"),
("Kim Tan", "Associate"),
("Lee", "HOD"),
("Jaehyun", "Associate");

select * from teacher;

insert into subject (subjectName) values
( "Data Structures and Algorithms"),
( "Computer Networks"),
( "Core Java"),
( "Python"),
( "Web Development");

select * from subject;

update teacher set teacherName="Song Ye-jin", teacherDesignation="DSA"  where teacherId=1;

drop table teacher;
drop table subject;
drop table classes;
drop table student;

select c.classId, c.className, t.teacherName, s.subjectName
from classes c 
join teacher t ON c.teacherId = t.teacherId
Join subject s ON c.subjectId = s.subjectId 
where c.className ="BE-CSE" order by c.classId;


