SET SERVEROUTPUT ON;

--2
DECLARE
    v_deptname departments.department_name%TYPE;
    v_jobid employees.job_id%TYPE;
    v_sal employees.salary%TYPE;
    v_annual_sal NUMBER;
BEGIN
    SELECT department_name, job_id, nvl(salary,0), nvl(salary,0)*12+salary*nvl(commission_pct,0)*12
    INTO v_deptname, v_jobid, v_sal, v_annual_sal
    FROM employees JOIN departments
    USING (department_id)
    WHERE employee_id = &사원번호;
    
    dbms_output.put_line(
        v_deptname || ' : ' ||
        v_jobid || ' : ' ||
        v_sal || ' : ' ||
        v_annual_sal
    );
END;
/


--3
DECLARE
    v_year NUMBER;
BEGIN
    SELECT EXTRACT(YEAR FROM hire_date) 
    INTO v_year
    FROM employees
    WHERE employee_id = &사원번호;
    
    IF v_year >= 1998 THEN
        dbms_output.put_line('New employee');
    ELSE
        dbms_output.put_line('Career employee');
    END IF;
END;
/


--4
BEGIN
    FOR I IN 1..9 LOOP
        IF MOD(I,2) = 0 THEN
            CONTINUE;
        END IF;
        
        dbms_output.put_line('===== ' || I || '단 =====');
        
        FOR J IN 1..9 LOOP
            dbms_output.put_line(I || ' * ' || J || ' = ' || I*J);
        END LOOP;

    END LOOP;
END;
/


--5
DECLARE
    CURSOR emp_cursor(v_deptno NUMBER) IS
        SELECT * FROM employees JOIN departments
        USING (department_id)
        WHERE department_id = v_deptno;
BEGIN
    FOR emp_record IN emp_cursor(&부서번호) LOOP
        dbms_output.put_line(emp_record.employee_id || ' : ' || emp_record.last_name || ' : ' || emp_record.salary);
    END LOOP;
END;
/


--6
CREATE OR REPLACE PROCEDURE p_upsal (
    v_id IN employees.employee_id%TYPE, 
    v_up IN NUMBER)
IS
    e_nodata EXCEPTION;
BEGIN
    UPDATE employees
    SET salary = salary*(1 + (v_up/100))
    WHERE employee_id = v_id;
    
    IF SQL%notfound THEN
        RAISE e_nodata;
    END IF;
EXCEPTION
    WHEN e_nodata THEN
        dbms_output.put_line('No search employee!!');
END;
/
EXECUTE p_upsal(141, 10);



--7
CREATE OR REPLACE PROCEDURE f_age_sex(v_num IN VARCHAR2)
IS
    v_year NUMBER;
    v_sex VARCHAR2(100);
    v_now NUMBER := EXTRACT(year from sysdate);
BEGIN
    v_year := to_number(substr(v_num,1,2));
    IF v_year <= 22 THEN
        dbms_output.put_line('나이: ' || v_now - (v_year+2000));
    ELSE
        dbms_output.put_line('나이: ' || v_now - (v_year+1900));
    END IF;
    
    IF substr(v_num,7,1) IN ('1','3') THEN
        v_sex := '남자';
    ELSE
        v_sex := '여자';
    END IF;
    
    dbms_output.put_line(v_sex);
END;
/

EXECUTE f_age_sex(8911021234567);



--8
CREATE OR REPLACE FUNCTION f_wyear (v_id IN NUMBER)
    RETURN NUMBER
IS
    v_wyear NUMBER;
BEGIN
    SELECT EXTRACT(YEAR FROM sysdate) - EXTRACT(YEAR FROM hire_date)
    INTO v_wyear
    FROM employees
    WHERE employee_id = v_id;
    
    RETURN v_wyear;
END;
/
SELECT last_name, hire_date, f_wyear(employee_id)
FROM employees;





--9
CREATE OR REPLACE FUNCTION f_mgr_name (v_depname IN VARCHAR2)
    RETURN VARCHAR2
IS
    CURSOR v_cur IS
        SELECT M.last_name
        FROM employees E JOIN employees M
        ON (E.manager_id = M.employee_id)
        JOIN departments D
        ON (M.department_id = D.department_id)
        WHERE D.department_name = v_depname;
BEGIN
    FOR v_rec IN v_cur LOOP
    RETURN v_rec.last_name;
    END LOOP;

END;
/
EXECUTE dbms_output.put_line(f_mgr_name('Executive'));



--10
SELECT * FROM user_source;


--11
DECLARE
v_star VARCHAR2(100);
BEGIN
    FOR J IN 1..9 LOOP
        v_star := v_star || '*';
        dbms_output.put_line(lpad(v_star, 10, '-'));
    END LOOP;
END;
/