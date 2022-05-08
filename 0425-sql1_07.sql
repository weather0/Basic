--Subquery의 기본 사용. 서브쿼리를 못쓰는 유일한 절: GROUP BY
SELECT salary 
FROM employees
WHERE last_name = 'Abel';

SELECT *
FROM employees
WHERE salary > 11000;

SELECT *
FROM employees
WHERE salary > (SELECT salary 
                             FROM employees
                            WHERE last_name = 'Abel');

--단일행 서브쿼리(Single Row Subquery)
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =  
                             (SELECT job_id
                              FROM   employees
                              WHERE  last_name = 'Matos')
AND    salary >
                             (SELECT salary
                              FROM   employees
                              WHERE  last_name = 'Matos');

SELECT MAX(salary) 
FROM employees;

SELECT last_name, job_id, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) 
                              FROM employees);

SELECT   department_id, COUNT(*)
FROM     employees
GROUP BY department_id
HAVING  COUNT(*) > (SELECT COUNT(*)
                                         FROM   employees
                                         WHERE  department_id = 20);                

SELECT last_name, job_id, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) 
                              FROM employees
                             WHERE department_id = 60);              

--다중행 서브쿼리(Multiple Row Subquery)
SELECT MAX(salary) 
FROM employees
GROUP BY department_id;

--다중행이라 =><이런 비교연산자 사용못함(당연)
SELECT last_name, job_id, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) 
                              FROM employees
                              GROUP BY department_id);    
--대신 IN 사용
SELECT last_name, job_id, salary
FROM   employees
WHERE salary IN (SELECT MAX(salary) 
                               FROM employees
                              GROUP BY department_id);  

SELECT salary 
FROM employees
WHERE department_id = 60;              

SELECT last_name, job_id, salary
FROM   employees
WHERE salary > (SELECT salary 
                              FROM employees
                             WHERE department_id = 60)
AND department_id <> 60;      
--ANY사용 (OR) → 결과적으로 4200보다 크기만 하면 됨
SELECT last_name, job_id, salary
FROM   employees
WHERE salary >ANY (SELECT salary 
                                      FROM employees
                                      WHERE department_id = 60)
AND department_id <> 60; 
--ALL사용 → 9000보다 커야 함
SELECT last_name, job_id, salary
FROM   employees
WHERE salary >ALL (SELECT salary 
                                    FROM employees
                                    WHERE department_id = 60)
AND department_id <> 60;


--Subquery 사용 시 주의사항
SELECT last_name, job_id, salary
FROM   employees
WHERE salary > (SELECT salary
                              FROM employees
                              WHERE last_name = 'Mark');

SELECT employee_id, last_name
FROM employees 
WHERE employee_id IN (SELECT manager_id
                                           FROM employees);

--IN(A or B or C..)→NOT IN(A and B and C... and Null) 이 Null 때문에 결과값이 아무것도 안나오게 됨(논리적으로 생각)   
SELECT employee_id, last_name
FROM employees 
WHERE employee_id NOT IN (SELECT manager_id
                                                    FROM employees);    
--그래서 NOT NULL 구문 넣어줘야 의미있는 결과 도출됨
SELECT employee_id, last_name
FROM employees 
WHERE employee_id NOT IN (SELECT manager_id
                                                    FROM employees
                                                     WHERE manager_id IS NOT NULL);    