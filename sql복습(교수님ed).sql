-- 1. ��ĺ�����
/* 2. HAVING ��

SELECT        -- (5)
FROM         -- (1)
WHERE        -- (2)
GROUP BY   -- (3)
HAVING       -- (4)
ORDER BY    -- (6)

*/

-- 3. ���������� �߿��� �ι�° ���ڰ� A�� ������
-- 4. 3(n-1)��
-- 5. Inline View
-- 6. 
CREATE TABLE department
(deptid    NUMBER(10) PRIMARY KEY,
 deptname  VARCHAR2(10),
 location  VARCHAR2(10),
 tel       VARCHAR2(15)
);

CREATE TABLE employee
(empid    NUMBER(10) PRIMARY KEY,
 empname  VARCHAR2(10),
 hiredate DATE,
 addr     VARCHAR2(12),
 tel      VARCHAR2(15),
 deptid   NUMBER(10) REFERENCES department(deptid)
 /*
 deptid   NUMBER(10),
 FOREIGN KEY(deptid) REFERENCES department(deptid)
 */
);

--7. 
ALTER TABLE employee
ADD birthday DATE;

--8.
INSERT INTO department
VALUES(1001, '�ѹ���', '��101ȣ', '053-777-8777');
INSERT INTO department
VALUES(1002, 'ȸ����', '��102ȣ', '053-888-9999');
INSERT INTO department
VALUES(1003, '������', '��103ȣ', '053-222-3333');

INSERT INTO employee(EMPID, EMPNAME, HIREDATE, ADDR, TEL, DEPTID)
VALUES(20121945, '�ڹμ�', TO_DATE('12/03/02', 'YY/MM/DD'), '�뱸','010-1111-1234',1001);
INSERT INTO employee(EMPID, EMPNAME, HIREDATE, ADDR, TEL, DEPTID)
VALUES(20101817, '���ؽ�', TO_DATE('10/09/01', 'YY/MM/DD'), '���','010-2222-1234',1003);
INSERT INTO employee(EMPID, EMPNAME, HIREDATE, ADDR, TEL, DEPTID)
VALUES(20122245, '���ƶ�', TO_DATE('12/03/02', 'YY/MM/DD'), '�뱸','010-3333-1222',1002);
INSERT INTO employees1(EMPID, EMPNAME, HIREDATE, ADDR, TEL, DEPTID)
VALUES(20121729, '�̹���', TO_DATE('11/03/02', 'YY/MM/DD'), '����','010-3333-4444',1001);
INSERT INTO employee(EMPID, EMPNAME, HIREDATE, ADDR, TEL, DEPTID)
VALUES(20121646, '������', TO_DATE('12/09/01', 'YY/MM/DD'), '�λ�','010-1234-2222',1003);

SELECT * FROM department;
SELECT * FROM employee;

-- 9.
ALTER TABLE employee
MODIFY empname NOT NULL;

--10.
SELECT e.empname, e.hiredate, d.deptname
FROM employee e JOIN department d
         ON e.deptId = d.deptId
WHERE deptname = '�ѹ���';

SELECT e.empname, e.hiredate, d.deptname
FROM employee e, department d
WHERE e.deptId = d.dpetId AND deptname = '�Ѻ���';

-- 11.
DELETE FROM employee
WHERE addr = '�뱸';

-- 12.
UPDATE employee
SET deptid = (SELECT deptid FROM department WHERE deptname='ȸ����')
WHERE deptid = (SELECT deptid FROM department WHERE deptname = '������');

-- 13.
SELECT e.empid, e.empname, e.birthday, d.deptname
FROM employee e JOIN department d
         ON e.deptid = d.deptid
WHERE e.hiredate > (SELECT hiredate FROM employee WHERE empid=20121729);


SELECT e.empid, e.empname, e.birthday, (SELECT deptname FROM department WHERE deptid = e.deptid)
FROM employee e
WHERE e.hiredate > (SELECT hiredate FROM employee WHERE empid=20121729);

-- 14
CREATE VIEW emp_vu
AS
  SELECT e.empname, e.addr, d.deptname
  FROM employee e JOIN department d
            ON e.deptid = d.deptid
  WHERE d.deptname = '�ѹ���';
  
SELECT * FROM emp_vu;




--1.
SELECT  * 
FROM employees
--WHERE hire_date > TO_DATE('1980/01/01','YYYY/MM/DD')
WHERE TO_CHAR(hire_date,'YYYY') > '1980'
AND UPPER(job_id)='ST_CLERK';

--2.
SELECT last_name, job_id, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC;

--3.
SELECT 'The salary of ' || last_name || ' after a 10% raise is ' || ROUND(salary * 1.1) as "new salary"
FROM employees
WHERE commission_pct IS NULL;

--4.
SELECT TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12) as years FROM employees;
SELECT TRUNC(MOD(MONTHS_BETWEEN(sysdate, hire_date), 12)) as months FROM employees;

SELECT last_name,
           TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12) as years,
           TRUNC(MOD(MONTHS_BETWEEN(sysdate, hire_date), 12)) as months
FROM employees;

--5.
SELECT last_name
FROM   employees
WHERE  UPPER(SUBSTR(last_name, 1, 1)) IN ('J','K','L','M');

SELECT last_name
FROM   employees
WHERE  UPPER(last_name) LIKE 'J%'
OR     UPPER(last_name) LIKE 'K%'
OR     UPPER(last_name) LIKE 'L%'
OR     UPPER(last_name) LIKE 'M%';


--6.
SELECT last_name, salary, NVL2(commission_pct, 'YES', 'No') as commission
FROM employees;

SELECT last_name, salary,
           CASE
            WHEN commission_pct IS NULL THEN 'NO'
            ELSE 'YES'
           END as commission
FROM employees;

SELECT CASE job_id
                WHEN 'ST_CLERK' THEN 1
                WHEN 'AAA' THEN 2
                ELSE 3
            END as job_id
FROM employees;

--7. 
SELECT d.department_name, d.location_id, e.last_name,
       e.salary, e.job_id
FROM   employees e, departments d
WHERE  e.department_id = d.department_id
AND    d.loction_id = 1800;

SELECT d.department_name, d.location_id, e.last_name,
       e.salary, e.job_id
FROM   employees e JOIN departments d
       ON (e.department_id = d.department_id)
WHERE  d.loction_id = 1800;

-- 8.
SELECT COUNT(*)
FROM   employees
WHERE  LOWER(last_name) LIKE '%n';

SELECT COUNT(*)
FROM   employees
WHERE  LOWER(SUBSTR(last_name,-1)) = 'n';

-- 9.
SELECT d.department_name, d.location_id, COUNT(e.employee_id)
FROM   departments d LEFT OUTER JOIN employees e 
                      ON(e.department_id = d.department_id)
GROUP BY d.department_name, d.location_id;

SELECT d.department_name, d.location_id, COUNT(e.employee_id)
FROM     employees e, departments d
WHERE    d.department_id = e.department_id(+)
GROUP BY d.department_name, d.location_id;

--10.
SELECT DISTINCT job_id
FROM   employees
WHERE  department_id IN (10, 20);

--11.
SELECT   e.job_id, count(e.job_id) AS frequency
FROM     employees e, departments d
WHERE    e.department_id = d.department_id
AND      LOWER(d.department_name) 
                        IN ('administration', 'executive')
GROUP BY e.job_id
ORDER BY 2 DESC;

SELECT   job_id, count(job_id) AS frequency
FROM     employees
WHERE    department_id  IN
        (SELECT department_id
         FROM   departments
         WHERE  LOWER(department_name) IN ('administration', 'executive')
GROUP BY job_id
ORDER BY 2 DESC;

SELECT   e.job_id, count(e.job_id) AS frequency
FROM     employees e JOIN departments d
               ON(e.department_id = d.department_id)
WHERE    LOWER(d.department_name) 
                        IN ('administration', 'executive')
GROUP BY e.job_id
ORDER BY 2 DESC;

--12.
SELECT last_name, hire_date
FROM   employees
WHERE  TO_CHAR(hire_date, 'DD') < '16';

--13.
SELECT 	last_name, salary, 
        TRUNC(salary, -3)/1000 thousands
FROM    employees;

--14.
SELECT e.last_name, m.last_name MANAGER, m.salary, 
       j.grade_level GRADE
FROM   employees e, employees m, job_grades j
WHERE  e.manager_id = m.employee_id
AND    m.salary BETWEEN j.lowest_sal AND j.highest_sal
AND    m.salary > 15000;

SELECT w.last_name, m.last_name manager, m.salary, 
       j.grade_level gra
FROM employees w JOIN employees m
                    ON (w.manager_id = m.employee_id)
                  JOIN job_grades j 
                    ON (m.salary BETWEEN j.lowest_sal AND j.highest_sal)
WHERE m.salary > 15000;

SELECT e.last_name, m.last_name MANAGER, m.salary, 
       j.grade_level GRADE
FROM   employees e JOIN employees m
             ON(e.manager_id = m.employee_id)
                   JOIN job_grades j
             ON(m.salary BETWEEN j.lowest_sal AND j.highest_sal)
AND    m.salary > 15000;

-- 15.
SELECT   department_id, MIN(salary)
FROM     employees
GROUP BY department_id
HAVING   AVG(salary) = (select   max(avg(salary))
                        from     employees
                        group by department_id);

