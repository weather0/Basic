--인덱스 자동생성: pk,uk → 제약조건명과 동일, drop index 불가, 제약조건 끄기/켜기에 따라 인덱스도 연동 삭제/생성
--인덱스 수동생성: create index → drop index 가능, 제약조건 끄기 여부 상관 없음 (인덱스 독립적)

--Create Index with the Create Table statement
create table emp2
(empid number(6) primary key,
empname varchar2(30),
salary number(6),
department_id number(3));

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';

--PK끄면
ALTER TABLE emp2 DISABLE primary key;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--인덱스도 사라짐
SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';
--PK켜면
ALTER TABLE emp2 ENABLE primary key;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--인덱스도 생김
SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';

------------------------------------
drop table emp2 purge;
--인덱스 수동 생성
create table emp2
(empid number(6) primary key using index
            (create index emp2_empid_idx on emp2(empid)),
empname varchar2(30),
salary number(6),
department_id number(3));

select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';

SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';

--PK꺼도
ALTER TABLE emp2 DISABLE primary key;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--인덱스는 그대로임
SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';
--인덱스 켜도
ALTER TABLE emp2 ENABLE primary key;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--인덱스는 원래 있었음
SELECT table_name, index_name
FROM user_indexes
WHERE table_name = 'EMP2';

-----------------------------------------------------
----Function Based Indexes 함수기반인덱스------
--인덱스 생성하고 모니터링하기
create index emp_sal_ix on employees(salary);
alter index emp_sal_ix monitoring usage;

--이 쿼리를 수행하는 데 인덱스를 사용할까?
select * from employees
where salary*12 > 80000;
--확인해보면 인덱스 사용 안 한 것을 알 수 있음
select * from v$object_usage;

drop index emp_sal_ix;

--함수넣고 인덱스를 만들어야
create index emp_annsal_ix on employees(salary*12);
alter index emp_annsal_ix monitoring usage;
--함수쿼리 쓸때
select * from employees
where salary*12 > 80000;
--인덱스 사용함
select * from v$object_usage;

drop index emp_annsal_ix;

--Drop Table with Recyclebin 휴지통기능
show recyclebin;
PURGE recyclebin;
show recyclebin;

drop table emp2;
desc emp2
select * from emp2;
show recyclebin;

flashback table emp2 to before drop;
desc emp2
select * from emp2;
show recyclebin;

drop table emp2 purge;
show recyclebin;
flashback table emp2 to before drop;
show recyclebin;