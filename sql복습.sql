select * from employees;
alter table employees add birthday date;

--6
create table dep0711(
deptid number(10) not null,
deptname VARCHAR2(10),
location VARCHAR2(10),
tel VARCHAR2(15)
);

desc dep0711;

create table employee0711(
empid number(10) not null,
empname VARCHAR2(10),
hiredate date,
addr VARCHAR2(12),
tel VARCHAR2(15),
deptid number(10)
);

desc employee0711;

--7
alter table employee0711 add birthday date;

--8
insert into dep0711 values(1001, '총무팀', '본101호', '053-777-8777');
insert into dep0711 values(1002, '회계팀', '본102호', '053-888-9999');
insert into dep0711 values(1003, '영업팀', '본103호', '053-222-3333');
commit;

insert into employee0711 values(20121945, '박민수', '20120302', '대구', '010-1111-1234',1001, null);
Insert into employee0711 values (20101817,'박준식','20100901','경산','010-2222-1234',1003,null);
Insert into employee0711 values (20122245,'선아라','20120302','대구','010-3333-1222',1002,null);
Insert into employee0711 values (20121729,'이범수','20110302','서울','010-3333-4444',1001,null);
Insert into employee0711 values (20121646,'이용희','20120901','부산','010-1234-2222',1003,null);
commit;

--9
alter table employee0711 modify empname not null;

--10
select empname, hiredate, deptname 
from employee0711 join dep0711 
using (deptid) 
where deptname = '총무팀';
    --교수님ed
    select e.empname, e.hiredate, d.deptname 
    from employee0711 e, dep0711 d 
    where e.deptid=d.deptid and deptname = '총무팀';

--11
delete from employee0711
where addr = '대구';
commit;


--12
update employee0711 
set deptid = (
select deptid from dep0711
where deptname = '회계팀'
)
where deptid = (
select deptid from dep0711
where deptname = '영업팀'
);


--13
select empid, empname, birthday, deptname
from employee0711 join dep0711
using (deptid)
where hiredate > (select hiredate from employee0711 where empid = '20121729');

--14
create view emp0711 as
select empname, addr, deptname
from employee0711 join dep0711 
using (deptid)
where deptname like '총무팀';


--2페이지
--1
select * from employees
where upper(job_id) = 'ST_CLERK' 
AND hire_date > '2002/01/01';
--다른방법
--AND to_char(hire_date,'yyyy')>'2002';

--2
select last_name, job_id, salary, commission_pct 
from employees
where commission_pct is not null
order by 3 desc;

--3
select 'The salary of ' || last_name || ' after a 10% raise is ' || round(salary*1.1) as "new salary" 
from employees
where commission_pct is null;

--4
select last_name, 
round((sysdate - hire_date)/365) years, 
round(((sysdate - hire_date)/365-trunc((sysdate - hire_date)/365))*12) months
from employees;
    --교수님ed.
    select last_name, 
    trunc(months_between(sysdate, hire_date)/12) as years, 
    trunc(mod(months_between(sysdate, hire_date),12))
    as months from employees;



--5
select last_name from employees
where last_name like 'J%' or
 last_name like 'K%' or
  last_name like 'L%' or
   last_name like 'M%';
    --교수님ed.
    select last_name from employees
    where upper(substr(last_name,1,1)) in ('J','K','L','M');


--6
select last_name, salary, nvl2(commission_pct, 'Yes','No') as COM from employees;
    --교수님ed2
    select last_name, salary,
    case
        when commission_pct is null then 'no'
        else 'yes'
    end as COM
    from employees;


--7
select department_name, location_id, last_name, job_id, salary
from employees join departments 
using(department_id)
where location_id = 1800;
    --교수님ed(다른방법)
    select d.department_name, d.location_id, e.last_name, e.job_id, e.salary
    from employees e, departments d
    where e.department_id = d.department_id
    and d.location_id = 1800;

--8
select count(*) from employees
where lower(last_name) like '%n';

--9(교수님ed)
select d.department_id, d.department_name, d.location_id, count(e.employee_id)
from departments d left outer join employees e
on(e.department_id = d.department_id)
group by d.department_id, d.department_name, d.location_id;
    --오라클조인방법
    select d.department_id, d.department_name, count(e.employee_id)
    from departments d, employees e
    where d.department_id = e.department_id(+)
    group by d.department_id, d.department_name, d.location_id;


--10(교수님ed)
--distinct: 중복제거
select distinct job_id from employees
where department_id in (10,20);

--11
select job_id, count(*) frequency
from employees join departments
using (department_id)
where departments.department_name in ('Administration','Executive')
group by job_id
order by 2 desc;
    --서브쿼리이용
    select job_id, count(job_id) frequency
    from employees
    where departement_id in 
        (select department_id from departments
        where lower(department_name) in ('administration','executive'))
    group by job_id
    order by 2 desc;


--12
select last_name, hire_date from employees
where extract(day from hire_date) < 16;
    --교수님ed
    --where to_char(hire_date,'DD')<'16';

--13(교수님ed)
select last_name, salary, trunc(salary,-3)/1000 as thousands
from employees;

--14
select e.last_name, m.last_name manager, m.salary, j.grade_level GRADE
from employees e join employees m
on (e.manager_id = m.employee_id)
join job_grades j
on (m.salary between j.lowest_sal and j.highest_sal)
where m.salary > 15000;
    --오라클조인
    select e.last_name, m.last_name manager, m.salary, j.grade_level grade
    from employees e, employees m, job_grades j
    where e.manager_id = m.employee_id
    and m.salary between j.lowest_sal and j.highest_sal
    and m.salary > 15000;


--15(교수님ed)
select department_id, min(salary)
from employees
group by department_id
having avg(salary) = (
    select max(avg(salary)) from employees
    group by department_id
    );