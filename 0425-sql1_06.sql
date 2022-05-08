--NATURAL JOIN
SELECT * 
FROM departments;

SELECT * 
FROM locations;

SELECT department_id, department_name, location_id, city
FROM departments NATURAL JOIN locations;

--열이름이 같은게 여러개 존재해서 레코드 누락 발생(근데 사실 열이름 동일 유무 자체는 JOIN과 무관함. JOIN은 '값'으로 판단)
SELECT employee_id, last_name, department_id, department_name
FROM employees NATURAL JOIN departments;

--USING 절을 사용하는 JOIN(필수조건: 컬럼명이 같아야 함). 누락된1명은? 애초에 부서가 없음→"아우터행"
SELECT employee_id, last_name, department_id, department_name
FROM employees JOIN departments
USING (department_id);

SELECT department_id, department_name, location_id, city
FROM departments JOIN locations
USING (location_id);

--ON절을 사용하는 JOIN(컬럼명 달라도 됨)
SELECT employee_id, last_name, department_id, department_name
FROM employees JOIN departments
ON (employees.department_id = departments.department_id);
--단, 결과칼럼은 출처테이블을 명시해줘야함(위 코드는 오류남)
SELECT employee_id, last_name, employees.department_id, department_name
FROM employees JOIN departments
ON (employees.department_id = departments.department_id);

--테이블 이름 별칭 사용
SELECT employees.employee_id, employees.last_name, 
               employees.department_id, departments.department_name
FROM employees JOIN departments
ON (employees.department_id = departments.department_id);

SELECT e.employee_id, e.last_name, 
       e.department_id, d.department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);


--WHERE 절 추가
SELECT e.employee_id, e.last_name, e.salary,
               e.department_id, d.department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
WHERE e.salary > 9000;

SELECT e.employee_id, e.last_name, e.salary,
               e.department_id, d.department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
AND e.salary > 9000;


--INNER JOIN과 OUTER JOIN
SELECT e.employee_id, e.last_name, 
               e.department_id, d.department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);

SELECT e.employee_id, e.last_name, 
               e.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON (e.department_id = d.department_id);

SELECT e.employee_id, e.last_name, 
               e.department_id, d.department_name
FROM employees e RIGHT OUTER JOIN departments d
ON (e.department_id = d.department_id);

SELECT e.employee_id, e.last_name, 
               e.department_id, d.department_name
FROM employees e FULL OUTER JOIN departments d
ON (e.department_id = d.department_id);


--USING절에 OUTER 조인하기
SELECT employee_id, last_name, department_id, department_name
FROM employees LEFT OUTER JOIN departments
USING (department_id);


--SELF JOIN: 편법. 테이블별칭 필수. ex)추천인ID입력(한테이블에 기존고객,신규고객 다 있으니깐)
SELECT e.employee_id, e.last_name, e.manager_id, m.last_name
FROM employees e JOIN employees m
ON (e.manager_id = m.employee_id);

SELECT e.employee_id, e.last_name, e.manager_id, m.last_name
FROM employees e LEFT OUTER JOIN employees m
ON (e.manager_id = m.employee_id);


--NON-EQUI JOIN ex)등급에따른 급여관리
SELECT * 
FROM job_grades;

SELECT e.employee_id, e.last_name, e.salary, j.grade_level
FROM employees e JOIN job_grades j
ON (e.salary BETWEEN j.lowest_sal AND j.highest_sal);


--3Way JOIN(테이블3개 사용)
SELECT e.employee_id, e.last_name, d.department_id, l.city
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
JOIN locations l
ON (d.location_id = l.location_id);

SELECT e.employee_id, e.last_name, d.department_id, l.city
FROM employees e FULL OUTER JOIN departments d
ON (e.department_id = d.department_id)
JOIN locations l
ON (d.location_id = l.location_id);


--Cartesian Products 자연스럽게 발생(조인 안되는 두 개를 조인했을때)
SELECT employee_id, city
FROM employees NATURAL JOIN locations;
--일부러 Cartesian Product 실행
SELECT employee_id, department_name
FROM employees CROSS JOIN departments;


--GROUP함수와 JOIN 응용
SELECT   d.department_name, MIN(e.salary), 
                MAX(e.salary),TRUNC(AVG(e.salary))
FROM     employees e JOIN departments d
ON       (e.department_id = d.department_id)
GROUP BY d.department_name;