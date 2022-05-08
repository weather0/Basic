select *
from employees;
select job_id, last_name, salary
from employees;
select job_id eop_mu, last_name, salary, salary*12 AS "annual salary" 
--salary*12:표현식, AS(생략가능):별칭. 큰따옴표안: case sensitive, 띄어쓰기가능
from employees;
--산술연산자: +-*/
select last_name, hire_date, hire_date+1, hire_date-1
from employees;
select job_id eop_mu, last_name, salary, salary*12 AS "annual salary",
        salary+salary*commission_pct AS 월급여 --null끼인 표현식의 결과는 null
from employees;

SELECT employee_id, first_name || ' ' || last_name
FROM employees;
SELECT last_name || ' : ' || salary
FROM employees;
SELECT last_name || '''s salary : ' || salary
FROM employees;
SELECT last_name || q'('s salary : )' || salary --q'()'괄호종류무관{}[]
FROM employees;

SELECT department_id
FROM employees;

SELECT DISTINCT department_id
FROM employees;

SELECT DISTINCT department_id, job_id
FROM employees;

DESCRIBE employees;
DESC employees;

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE department_id = 60;

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE department_id >= 60;

SELECT employee_id, last_name, salary*12 연봉, hire_date, department_id
FROM employees
WHERE salary*12 > 150000;

SELECT employee_id, last_name, salary*12 연봉, hire_date, department_id
FROM employees
WHERE last_name = 'King'; --대소문자구분

SELECT employee_id, last_name, salary*12 연봉, hire_date, department_id
FROM employees
WHERE last_name > 'King';

SELECT employee_id, last_name, salary*12 연봉, hire_date, department_id
FROM employees
WHERE hire_date = '1997/09/17'; --97/09/17, 97-09-17 형식무관(연월일만 준수)

SELECT employee_id, last_name, salary*12 연봉, hire_date, department_id
FROM employees
WHERE hire_date = '97/09/17';


--비교연산자
--IN
SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE department_id IN (60,80);

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE last_name IN ('Hunold', 'Ernst');

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE salary BETWEEN 6000 AND 12000; --경계 포함. 상하한 순서주의

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE hire_date BETWEEN '97/09/17' AND '98/12/31';

--LIKE
SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE last_name LIKE 'K%'; --%는 0부터 카운트. 이름이'K'여도 검색됨

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE last_name LIKE '_a%'; 

SELECT employee_id, last_name, salary, hire_date, department_id
FROM employees
WHERE last_name LIKE '____'; 

SELECT employee_id, last_name, salary, hire_date, department_id, job_id
FROM employees
WHERE job_id LIKE 'SA\_%' ESCAPE '\'; --예외처리

--IS NULL
SELECT employee_id, last_name, salary, hire_date, department_id, job_id
FROM employees
WHERE department_id IS NULL;
 
--논리연산자(AND, OR, NOT) 우선순위: AND > OR
SELECT employee_id, last_name, salary, hire_date, department_id, job_id
FROM employees
WHERE department_id = 50
OR department_id = 80
AND salary > 8000;
---NOT은 각 연산자 앞에 무지성 붙이면 됨


--정렬(ORDER BY 절. 항상 막줄. ASC오름차순 생략가능. 컬럼포지션넘버 가능. ★별칭사용가능)
SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, job_id
FROM employees
WHERE department_id IS NOT NULL
ORDER BY department_id DESC, 연봉; --내림차순(부서명), 오름차순(연봉) 섞어가능

SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, job_id
FROM employees
WHERE department_id IS NOT NULL
ORDER BY 5 DESC, 3 DESC;


--치환변수(&)
SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, job_id
FROM employees
WHERE last_name = '&부서번호'; --따옴표처리 주의 

SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, job_id
FROM employees
WHERE hire_date > '&입사일';

SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, &열이름
FROM employees
ORDER BY &열이름;

SELECT employee_id, last_name, salary*12 AS 연봉, hire_date, department_id, &&열이름
FROM employees
ORDER BY &열이름;
--더블 && 특징: 앞전에 입력해서 변수에 들어간거 자동 재사용됨(DEFINE으로 확인 가능)
--UNDEFINE으로 변수내용 지워줘야함
DEFINE 열이름
UNDEFINE 열이름
