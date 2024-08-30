--Run SQL CommandLine 실행 후 권한 부여 후 실습 진행
conn / as sysdba
GRANT create view, create synonym TO hr;
--뷰 생성과 사용. 뷰는 필요한 데이터만 필터해서 보여주는 기능적 측면

CREATE VIEW 	empvu80
AS SELECT  employee_id, last_name, salary
FROM    employees
WHERE   department_id = 80;
--없는 열 생성시 표현식은 별칭 필수(ANN_SALARY)
CREATE VIEW 	salvu50
AS SELECT  employee_id ID_NUMBER, last_name NAME, salary*12 ANN_SALARY
FROM    employees
WHERE   department_id = 50;

DESC empvu80
SELECT * FROM empvu80;
DESC salvu50
SELECT * FROM salvu50;

--뷰와 복사된 테이블 비교
--뷰(외부스키마) 생성후 원본테이블(개념스키마) 쿼리하면 원본은 변동없어 보이고, 뷰가 반영되어 보임
--뷰를 쿼리하면 실제로는 원본테이블이 쿼리됨
SELECT * FROM dept80;
SELECT * FROM empvu80;
SELECT * FROM salvu50;

SELECT employee_id, last_name, salary*12, hire_date, department_id
FROM employees
WHERE department_ID IN (50, 80);

UPDATE employees
SET salary = salary*1.1;
COMMIT;

SELECT * FROM dept80;
SELECT * FROM empvu80;
SELECT * FROM salvu50;

--뷰 관련 데이터딕셔너리 정보 확인
SELECT view_name, text
FROM user_views;

--뷰수정하기
CREATE OR REPLACE VIEW 	salvu50
AS SELECT  employee_id ID_NUMBER, last_name NAME, salary*12 ANN_SALARY, hire_date           
FROM    employees
WHERE   department_id = 50;

SELECT view_name, text
FROM user_views;

--COMPLEX VIEW 생성
CREATE OR REPLACE VIEW dept_sum_vu
  (name, minsal, maxsal, avgsal)
AS SELECT   d.department_name, MIN(e.salary), 
            MAX(e.salary),TRUNC(AVG(e.salary))
   FROM     employees e JOIN departments d
   ON       (e.department_id = d.department_id)
   GROUP BY d.department_name;

SELECT * FROM dept_sum_vu;

--VIEW에 대한 DML
desc empvu80
INSERT INTO empvu80
VALUES(250, 'Test', 4000);
SELECT employee_id, salary
FROM employees
WHERE employee_id = 149;
SELECT * FROM empvu80;
UPDATE empvu80
SET salary=20000
WHERE employee_id = 149;
SELECT employee_id, salary
FROM employees
WHERE employee_id = 149;
SELECT * FROM empvu80;
ROLLBACK;

--WITH CHECK OPTION 사용
CREATE OR REPLACE VIEW empvu80
AS SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   department_id = 80;

SELECT * FROM empvu80;

UPDATE empvu80
SET salary = 9800
WHERE employee_id = 176;
SELECT * FROM empvu80;

ROLLBACK;

--WITH CHECK OPTION 안 걸어서 실행 안 됨
UPDATE empvu80
SET department_id = 60
WHERE employee_id = 176;

SELECT * FROM empvu80;

ROLLBACK;

--WITH CHECK OPTION: VIEW 생성시 WHERE절 관련 열은 수정 불가하게 제한거는 기능
CREATE OR REPLACE VIEW empvu80
AS SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   department_id = 80
WITH CHECK OPTION;

UPDATE empvu80
SET department_id = 60
WHERE employee_id = 176;

UPDATE empvu80
SET salary = 9800
WHERE employee_id = 176;

ROLLBACK;
--WITH READ ONLY 옵션
CREATE OR REPLACE VIEW empvu80
AS SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   department_id = 80
WITH READ ONLY;

UPDATE empvu80
SET salary = 9800
WHERE employee_id = 176;

--뷰의 삭제
SELECT view_name, text
FROM user_views;

DROP VIEW empvu80;

SELECT view_name, text
FROM user_views;

SELECT * FROM empvu80;