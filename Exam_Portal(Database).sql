create database Exam_Portal;

use Exam_Portal;
create table Marks (M_Id int primary key ,M_Score varchar (255),M_Desc text);
insert into Marks values (1,80,"Paper was return really good and still he can improve");
insert into Marks values (2,70,"Needs to  improve");
insert into Marks values (3,45,"Needs to study hard and do more practice");
insert into Marks values (4,65,"AVerage score need more practice");
select * from Marks;

create table Students (S_Id int primary key ,S_Name varchar(255) not null,S_Class varchar(255) not null,S_Age int,S_Password varchar(255),S_MarksId int ,foreign key (S_MarksId) references Marks (M_Id)) ;
insert into Students values (101,"kiran","12-th",18,"Kiran123",2);
insert into Students values (102,"Rahul","12-th",19,"Rahul123",4);
insert into Students values (103,"Viraj","12-th",18,"Viraj123",1);
insert into STudents values (104,"Sam","12-th",17,"Sam123",3);
select * from Students;

create table Paper(P_Id int primary key,P_Name varchar(255) not null,P_Subject varchar(255) not null,P_Type  varchar(255) );
insert into paper values (1001,"1st Unit test","Maths","MCQ");
insert into paper values (1002,"1st Unit test","English","MCQ");
insert into paper values (1003,"1st Unit test","Science","MCQ");
insert into paper values (1004,"1st Unit test","Geography","MCQ");
insert into paper values (1005,"Fial Exam","Java","Written");
select * from Paper;

create table Teachers (T_Id int primary key ,T_Name varchar(255),T_Age int ,T_Password varchar(255),T_PaperId int not null ,foreign key (T_PaperId)  references Paper (P_Id));
insert into Teachers values (1,"Manoj",18,"Manoj123",1002);
insert into Teachers values (2,"Vasant",45,"Vasant123",1001);
insert into Teachers values (3,"Shubham",35,"Shubham123",1003);
select * from Teachers;

create table Admin (A_Id int primary key ,A_Name varchar(255), A_Password varchar(255));
insert into Admin  values (1,"Yogesh","Yogesh123");
insert into Admin  values (2,"Varsha","Varsha123");
select * from Admin;