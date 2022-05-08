--Creating a Temporary Table
--임시테이블은 세션전용: 쿼리입력시 그 세션(창)에서만 유효함
--로컬 vs 글로벌: 로컬은 세션나갔다 들어오면 테이블까지 사라짐(찐 임시)
create global temporary table emp_temp1
on commit delete rows
as
select employee_id, last_name,salary from employees;

create global temporary table emp_temp2
on commit preserve rows
as
select employee_id, last_name, salary from employees;

--SQL Developer 종료 후 재실행
--Using a Temporary Table
select * from emp_temp1;
select * from emp_temp2;

insert into emp_temp1
select employee_id, last_name, salary
from employees
where department_id = 50;

insert into emp_temp2
select employee_id, last_name, salary
from employees
where department_id in (80,90);

select * from emp_temp1;
select * from emp_temp2;
commit;
select * from emp_temp1; --데이터 사라짐
select * from emp_temp2; --그대로 있음

--SQL Developer 추가 실행 후 인사관리로 접속 
select * from emp_temp2;
insert into emp_temp2
select employee_id, last_name, salary
from employees
where department_id=60;
commit;
select * from emp_temp2;
--두 번째 SQL Developer 종료

--Clear Test
drop table emp_temp1;
drop table emp_temp2;

