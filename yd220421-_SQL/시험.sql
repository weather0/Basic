--1
SELECT employee_id, last_name, salary*12 ANN_SAL, department_id
FROM employees
WHERE commission_pct is not null
ORDER BY 3 DESC;

--2
SELECT employee_id, last_name, to_char(hire_date, 'yyyy-mm-dd'), to_char(salary, '$999,999')
FROM employees;

--3
SELECT e.employee_id, e.last_name, 
               e.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON (e.department_id = d.department_id);

--4
SELECT   department_id, COUNT(*), TRUNC(AVG(salary))
FROM     employees
GROUP BY department_id;

--5
SELECT employee_id, last_name, job_id
FROM employees
WHERE department_id = (SELECT department_id 
                                  from departments 
                                  where department_name = 'IT');

--6
CREATE TABLE prof
(profno NUMBER(4) PRIMARY KEY,
name VARCHAR2(15) NOT NULL,
id VARCHAR2(15) NOT NULL,
hiredate DATE,
pay NUMBER(4));


--7-1
INSERT INTO prof
VALUES (1001, 'Mark', 'm1001', '07/03/01', 800);
INSERT INTO prof
VALUES (1003, 'Adam', 'a1003', '11/03/02', null);
COMMIT;

--7-2
UPDATE prof
SET pay = 1100
WHERE profno = 1001;
COMMIT;


--8-1
CREATE INDEX prof_name_idx ON prof(name);

--8-2
alter table prof
add constraint PROF_ID_UK unique (id);

--8-3
alter table prof
add gender char(3);

--8-4
alter table prof
modify name varchar2(20);



--9-1
CREATE VIEW 	PROF_VU
AS SELECT  profno PNO, name PNAME, id
FROM prof;

--9-2
CREATE OR REPLACE VIEW PROF_VU
AS SELECT profno PNO, name PNAME, id, hiredate
FROM prof;

--9-3
CREATE SYNONYM P_VU
FOR PROF_VU;



--10-1
drop table prof purge;

--10-2
--인덱스 삭제됨
SELECT *
FROM user_indexes;

--뷰 존재함
SELECT *
FROM user_views;

--동의어 존재함
SELECT *
FROM user_synonyms;
