create table student(
  studentid VARCHAR2(20) not null primary key,
  name VARCHAR2(50) not null,
  birthday date not null,
  major VARCHAR2(100) not null,
  address VARCHAR2(200), 
  tel VARCHAR2(14)
);

commit;

select * from student;

insert into student values('micol@abc.com','마이콜',to_date('2000-04-01'),'컴퓨터공학',null,'010-1111-2222');
insert into student values('park@abc.com','박기자',to_date('2000-03-01'),'산업공학',null,'010-4444-2222');

