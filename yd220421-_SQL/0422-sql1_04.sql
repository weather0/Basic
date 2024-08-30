--날짜데이터에 TO_CHAR 함수 사용
SELECT employee_id, last_name, hire_date
FROM employees;
SELECT employee_id, last_name, TO_CHAR(hire_date, 'dd-mm-yyyy')
FROM employees;

SELECT employee_id, last_name, 
       TO_CHAR(hire_date, 'yyyy-mm-dd day') AS hire_date, --day대신 dy하면 '요일'생략
       TO_CHAR(hire_date, 'q') AS 분기,
       TO_CHAR(hire_date, 'w')||'주차' AS 주수
FROM employees;
SELECT employee_id, last_name, TO_CHAR(hire_date, 'yyyy-mm-dd hh24:mi:ss')
FROM employees;
--날짜 연산에 응용
SELECT TO_CHAR(sysdate, 'yyyy/mm/dd hh24:mi:ss'),
       TO_CHAR(sysdate+3/24,'yyyy/mm/dd hh24:mi:ss'),
       TO_CHAR(sysdate+40/(24*60), 'yyyy/mm/dd hh24:mi:ss')
FROM dual;

--am적나 pm적나 결과 같음(표시일뿐)
SELECT TO_CHAR(sysdate, 'yyyy/mm/dd hh:mi:ss am')
FROM dual;

--숫자데이터에 TO_CHAR 사용하기 (9는 자릿수를 의미)
SELECT employee_id, last_name, salary, 
               TO_CHAR(salary, '$999,999')
FROM employees;
SELECT employee_id, last_name, salary, 
       TO_CHAR(salary, '$999,999.99'),
       TO_CHAR(salary, '$099,999.99')
FROM employees;

SELECT employee_id, last_name, salary, 
       TO_CHAR(salary, 'L999,999')
FROM employees;
ALTER SESSION SET nls_territory=germany;

SELECT employee_id, last_name, salary, 
       TO_CHAR(salary, 'L999,999')
FROM employees;
ALTER SESSION SET nls_territory=korea;

SELECT employee_id, last_name, salary, 
       TO_CHAR(salary, 'L999,999')
FROM employees;

--사원들이 입사한 연도만 사원번호와 함께 출력하시오
SELECT employee_id, TO_CHAR(hire_date, 'yyyy') AS 입사연도
FROM employees;

--TO_DATE 함수
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date > '12/31/1999';

SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date > TO_DATE('31/12/1999', 'dd/mm/yyyy');

SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date > TO_DATE('31/12/99', 'dd/mm/yy');

SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date > TO_DATE('31/12/99', 'dd/mm/rr');

--TO_NUMBER 함수
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary > $8,000;

SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary > '$8,000';

SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary > TO_NUMBER('$8,000','$9,999');

--함수중첩
SELECT last_name,
              UPPER(CONCAT(SUBSTR (LAST_NAME, 1, 8), '_US'))
FROM   employees
WHERE  department_id = 60;
--일반함수 NVL(컬럼,컬럼중에null을대체할값(단, 컬럼의 타입과 같아야 함)) 
SELECT employee_id, last_name, salary, commission_pct
FROM employees;

SELECT employee_id, last_name, salary, NVL(commission_pct, 0)
FROM employees;
--NVL을 안쓰면 null이 나와서 지저분
SELECT employee_id, last_name, salary+salary*commission_pct as monthly_sal
FROM employees;

SELECT employee_id, last_name, 
              salary+salary*NVL(commission_pct,0) as monthly_sal
FROM employees;
--일반함수 NVL2(컬럼,컬럼이null아니면,null이면)
SELECT employee_id, last_name, 
              salary+salary*NVL(commission_pct,0) as monthly_sal,
              NVL2(commission_pct, 'Y', 'N') AS comm_get
FROM employees;

SELECT last_name,  salary, commission_pct,
              NVL2(commission_pct, 'SAL+COMM', 'SAL') income
FROM   employees 
WHERE department_id IN (50, 80);
--일반함수 NULL IF
SELECT employee_id, last_name, 
               salary+salary*NVL(commission_pct,0) as monthly_sal,
               NVL2(commission_pct, 'Y', 'N') AS comm_get,
               NULLIF(salary,  salary+salary*NVL(commission_pct,0)) AS result
FROM employees;

SELECT first_name, LENGTH(first_name) "expr1", 
              last_name,  LENGTH(last_name)  "expr2",
             NULLIF(LENGTH(first_name), LENGTH(last_name)) result
FROM   employees;
--일반함수 COALESCE
SELECT employee_id, commission_pct, manager_id,
              COALESCE(commission_pct, manager_id, 1234) AS result
FROM employees;

SELECT last_name, employee_id, commission_pct, manager_id,
              COALESCE(TO_CHAR(commission_pct),TO_CHAR(manager_id), 'No commission and no manager') 
FROM employees;
--CASE 구문 사용     
SELECT last_name, job_id, salary,
              CASE job_id WHEN 'IT_PROG'  THEN  1.10*salary
                                    WHEN 'ST_CLERK' THEN  1.15*salary
                                    WHEN 'SA_REP'   THEN  1.20*salary
                                    ELSE      salary END     "REVISED_SALARY"
FROM   employees;

SELECT last_name, job_id, salary,
              CASE  WHEN job_id = 'IT_PROG'  THEN  1.10*salary
                          WHEN job_id = 'ST_CLERK' THEN  1.15*salary
                          WHEN job_id ='SA_REP'   THEN  1.20*salary
                          ELSE      salary END     "REVISED_SALARY"
FROM   employees;

SELECT employee_id, last_name, salary,
              CASE WHEN salary < 5000 THEN 'L'
                         WHEN salary BETWEEN 5000 AND 9000 THEN 'M'
                         ELSE 'H' END AS salary_grade
FROM employees;       
--NVL2 함수 결과를 CASE 문으로 대체 
SELECT employee_id, last_name, 
              salary+salary*NVL(commission_pct,0) as monthly_sal,
              CASE WHEN commission_pct IS NOT NULL THEN 'Y'
                         ELSE 'N' END AS comm_get
FROM employees;
--DECODE 함수(CASE구버전)
SELECT last_name, job_id, salary,
             DECODE(job_id, 'IT_PROG',  1.10*salary,
                                          'ST_CLERK', 1.15*salary,
                                          'SA_REP',   1.20*salary,
                                                                        salary)  AS  REVISED_SALARY
FROM   employees;

SELECT last_name, salary,
               DECODE (TRUNC(salary/2000, 0),
                         0, 0.00,
                         1, 0.09,
                         2, 0.20,
                         3, 0.30,
                         4, 0.40,
                         5, 0.42,
                         6, 0.44,
                            0.45) TAX_RATE
FROM   employees
WHERE  department_id = 80;