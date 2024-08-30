--INSERT 문장 작성과 Transaction
--1번 HR. 테이블순서 그대로 insert시 칼럼명 생략가능
INSERT INTO departments
VALUES (70, 'Public Relations', 100, 1700);
SELECT * FROM departments;

--2번 HR
SELECT * FROM departments;
INSERT INTO	departments (department_id, department_name)
VALUES		(30, 'Purchasing');
INSERT INTO	departments
VALUES		(100, 'Finance', NULL, NULL);
SELECT * FROM departments;
COMMIT;

--1번 HR
ROLLBACK;
SELECT * FROM departments;
--2번 HR 
SELECT * FROM departments;
--1번 HR
INSERT INTO departments
VALUES (70, 'Public Relations', 100, 1700);
SELECT * FROM departments;
COMMIT;
--특별한 값 입력
--SYSDATE 입력
INSERT INTO employees 
VALUES		   (113,  'Louis', 'Popp', 'LPOPP', '515.124.4567', 
                        SYSDATE, 'AC_ACCOUNT', 6900,  NULL, 205, 110);
--TO_DATE 함수 사용
INSERT INTO employees
VALUES      (114, 'Den', 'Raphealy', 'DRAPHEAL', '515.127.4561',
                      TO_DATE('02 03, 99', 'MM DD, YY'), 'SA_REP', 11000, 0.2, 100, 60);
INSERT INTO employees
VALUES      (115, 'Mark', 'Kim', 'MKIM', '515.127.4562',
                      TO_DATE('02 03, 99', 'MM DD, RR'),
                      'SA_REP', 13000, 0.25, 100, 60);             
SELECT * FROM employees;
SELECT employee_id, last_name, TO_CHAR(hire_date, 'yyyy/mm/dd') AS hire_date
FROM employees;

--다른 테이블로 행 복사. DDL이라 자동커밋됨(앞에거 커밋안했어도 이거 실행시 자동반영)
CREATE TABLE sales_reps
AS
SELECT employee_id id, last_name name, salary, commission_pct
FROM employees
WHERE 1=2; --빈테이블로 새테이블 생성하는 꼼수(열만 만들기)

--2번 HR
SELECT * FROM employees;
SELECT * FROM sales_reps;
INSERT INTO sales_reps
SELECT employee_id, last_name, salary, commission_pct
FROM   employees
WHERE  job_id LIKE '%REP%';
SELECT * FROM sales_reps;
COMMIT;
--치환변수 사용(40, Human Resource, 2500 입력)
INSERT INTO departments(department_id, department_name, location_id)
VALUES     (&department_id, '&department_name',&location);
COMMIT;

--UPDATE
--1번 HR
--WHERE 안쓰면 전체가 업뎃됨. WHERE조건 제대로 지정 안해주면 0개 업뎃
UPDATE employees
SET salary= 7000;
SELECT * FROM employees;

ROLLBACK;

UPDATE employees
SET salary= 7000
WHERE employee_id = 104;
--2번 HR (위에 1번HR에서 104번 레코드 실행하고 커밋안한 상태에서 2번HR실행불가(락걸린 상태. 동시성제어,병행제어))
UPDATE employees
SET salary= salary*1.1
WHERE employee_id = 104;

--1번 HR
ROLLBACK;
--2번 HR
ROLLBACK;

--1번 HR
--서브쿼리를 사용한 UPDATE
UPDATE   employees
SET      job_id  = (SELECT  job_id 
                              FROM    employees 
                              WHERE   employee_id = 205), 
             salary  = (SELECT  salary 
                             FROM    employees 
                              WHERE   employee_id = 205) 
WHERE    employee_id    =  113;

UPDATE employees
SET  department_id =
                                      (SELECT department_id
                                       FROM   departments
                                       WHERE  department_name LIKE '%Public%')
WHERE employee_id = 115;
COMMIT;

--DELETE
DELETE FROM departments
WHERE  department_name = 'Finance';

DELETE FROM employees
WHERE  department_id =
                                             (SELECT department_id
                                              FROM   departments
                                              WHERE  department_name LIKE '%Public%');
COMMIT;

--DELETE 와 TRUNCATE
DELETE FROM sales_reps;

ROLLBACK;

--DDL이라 실행순간 커밋처럼 바로 반영됨. 롤백 안 됨
TRUNCATE TABLE sales_reps;

ROLLBACK;

INSERT INTO sales_reps
SELECT employee_id, last_name, salary, commission_pct
FROM   employees
WHERE  job_id LIKE '%REP%';

COMMIT;