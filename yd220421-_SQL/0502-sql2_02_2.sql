--Create a Table For Test
--테이블 복사하면 not null만 복사되고, 다른 제약조건은 안 됨
drop table emp2 purge;
create table emp2
as
select * from employees;

select table_name, constraint_name, constraint_type, status, search_condition
from user_constraints
where table_name = 'EMP2';

--Adding a Constraints
alter table emp2
add primary key(employee_id);

alter table emp2
add constraint emp2_email_uk unique (email);

select table_name, constraint_name, constraint_type, status,search_condition
from user_constraints
where table_name = 'EMP2';

--Disable a Constraints(PRIMARY KEY)
alter table emp2
disable primary key;

--제약조건에 위반(유일성위반)하도록 데이터 수정(PRIMARY KEY 열에 중복데이터생성)
update emp2
set employee_id = 102
where employee_id = 101;

commit;

SELECT employee_id
FROM emp2
WHERE employee_id = 102;

--Disable a Constraints(Non Primary Key)
alter table emp2
disable constraint emp2_email_uk;

--제약조건 상태확인
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

--Enabling a Constraints 활성화
alter table emp2
enable constraint emp2_email_uk;

--잘못된 데이터(위에서 PK꺼놓고 유일성위반)로 인해 제약조건 활성화에 실패
alter table emp2
enable primary key; 

------해결방법(Exception처리): 뭐가 잘못됐는지 찾기!!------
create table exceptions(row_id rowid,
	                owner varchar2(128),
	                table_name varchar2(128),
		        constraint varchar2(128));
alter table emp2
enable primary key
exceptions into exceptions;

SELECT * FROM exceptions;

SELECT *
FROM emp2;

SELECT employee_id, rowid
FROM emp2;

--rowid 값 복사 
UPDATE emp2
SET employee_id = 101
WHERE rowid='AAAE9jAAEAAAAJrAAB';

--복사한 rowid 값 사용
SELECT *
FROM emp2
WHERE employee_id IN (101,102);
COMMIT;
-----------------------------------------------------

--다시 PK켜기
ALTER TABLE emp2
ENABLE primary key;

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

TRUNCATE TABLE exceptions;

-----------------------------------------------------

--Dropping a Constraints 제약조건 삭제
alter table emp2 
drop primary key;

alter table emp2
drop constraint emp2_email_uk;

select table_name, constraint_name, constraint_type, status, search_condition
from user_constraints
where table_name = 'EMP2';

--Cascading Constraints
--Column Drop 시 추가 옵션
CREATE TABLE test1(
a NUMBER PRIMARY KEY,
b NUMBER,
c NUMBER,
d NUMBER,
CONSTRAINT test1_b_fk FOREIGN KEY (b) REFERENCES test1,
CONSTRAINT ck1 CHECK (a > 0 and c > 0),
CONSTRAINT ck2 CHECK (d > 0));

desc test1

select table_name, constraint_name, constraint_type, status, search_condition
from user_constraints
where table_name = 'TEST1';

alter table test1
drop column d;

DESC test1

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';

alter table test1
drop column c;

alter table test1
drop column a;

--a와 관련된 제약조건 싹 다 제거
alter table test1
drop column a cascade constraints;

desc test1

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';

alter table test1 
drop column c;

desc test1

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';

DESC test1

--Renaming Table Columns and Contraints
DESC emp2

alter table emp2
rename column employee_id to empid;

desc emp2

alter table emp2
add constraint emp2_pk primary key(empid);

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

alter table emp2
rename constraint emp2_pk to emp2_empid_pk;

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

--FOREIGN KEY 추가(on delete 옵션 안쓴 경우)
ALTER TABLE emp2
ADD CONSTRAINT emp2_deptid_fk FOREIGN KEY(department_id)
REFERENCES departments(department_id);

--on delete 옵션 안쓴 경우 지우고 새로 생성해야함
ALTER TABLE emp2
DROP CONSTRAINT emp2_deptid_fk;

ALTER TABLE emp2
ADD CONSTRAINT emp2_deptid_fk FOREIGN KEY(department_id)
REFERENCES departments(department_id)
ON DELETE CASCADE;

--Clean Test
drop table emp2 purge;
drop table test1 purge;