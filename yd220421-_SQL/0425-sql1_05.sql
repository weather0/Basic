--GROUP 함수의 기본 사용(Null값은 제외)
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM   employees;

SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM   employees
WHERE  department_id = 60;

SELECT MIN(last_name), MAX(last_name)
FROM employees;

SELECT MIN(hire_date), MAX(hire_date)
FROM employees;

--COUNT(*)은 Null 포함
SELECT COUNT(*), COUNT(department_id), COUNT(DISTINCT department_id)
FROM employees;

--null데이터는 모수에서 제외되어 평균이 과대계상됨
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

--GROUP BY 절의 사용
SELECT department_id, SUM(salary), COUNT(*)
FROM employees; --오류남

SELECT department_id, SUM(salary), COUNT(*), ROUND(AVG(salary)) 평균급여
FROM employees
GROUP BY department_id;

SELECT department_id, SUM(salary), COUNT(*)
FROM employees
GROUP BY department_id
ORDER BY 1;

SELECT department_id, job_id,  SUM(salary), COUNT(*)
FROM employees
GROUP BY department_id, job_id
ORDER BY 1,2;

SELECT department_id, job_id,  SUM(salary), COUNT(*)
FROM employees
WHERE department_id >= 50
GROUP BY department_id, job_id
ORDER BY 1,2;

--HAVING 절의 사용: GROUP BY절의 옵션임
SELECT department_id,job_id,  SUM(salary), COUNT(*)
FROM employees
WHERE COUNT(*) <> 1 
GROUP BY department_id, job_id
ORDER BY 1,2;
--COUNT는 만들어진 그룹을 선택하여 수를 세는 의미지만, 
--WHERE은 그룹을 선택하는 기능이 없어 이 경우에 논리상 WEHRE절은 GROUP BY 뒤로 가야한다. 
--근데 WEHRE절은 순서가 그런식으로는 불가능하다.
--그래서 HAVING절을 사용

SELECT department_id,job_id,  SUM(salary), COUNT(*)
FROM employees
GROUP BY department_id, job_id
HAVING COUNT(*) <> 1
ORDER BY 1,2;

--GROUP 함수의 중첩
SELECT MAX(SUM(salary))
FROM employees
GROUP BY department_id;
--아래는 오류사례
SELECT department_id, MAX(SUM(salary))
FROM employees
GROUP BY department_id;