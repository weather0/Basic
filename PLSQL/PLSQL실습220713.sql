--220713
SET SERVEROUTPUT ON;

--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■ 테이블 ■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

--동음이의어 주의! (DB테이블 vs PLSQL테이블)
--테이블구조: 기본키&열(마치 배열의 idx,val같은. 단, 순서정보X for문 돌리려면 first,last메서드 활용)
--기본키의 타입: binary_integer 또는 pls_integer
--테이블 예제1
DECLARE
    TYPE dept_table_type IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
    dept_table dept_table_type;
    v_total NUMBER;
BEGIN
    FOR v_counter IN 1..50 LOOP
        dept_table(v_counter) := v_counter;
    END LOOP;
    v_total := dept_table.COUNT;
    dbms_output.put_line(v_total);
END;
/


--테이블 예제2
DECLARE
    TYPE test_table_type IS TABLE OF VARCHAR2(10) INDEX BY BINARY_INTEGER;
    test_table test_table_type;
BEGIN
    test_table(1) := 'One';
    test_table(3) := 'Three';
    test_table(-2) := 'Minus Two';
    test_table(0) := 'Zero';
    test_table(100) := 'Hundred';
    dbms_output.put_line(test_table(1));
    dbms_output.put_line(test_table(3));
    dbms_output.put_line(test_table(-2));
    dbms_output.put_line(test_table(0));
    dbms_output.put_line(test_table(100));
    test_table.DELETE(100);
    test_table.DELETE(1,3); --범위(1~3)
    test_table.DELETE;
    dbms_output.put_line('===========');
    dbms_output.put_line(test_table.COUNT);
END;
/


--테이블&레코드 예제3 (테이블&레코드 조합 유용! DB테이블 전체를 하나의 변수로 담기도 가능!)
DECLARE
    TYPE emp_table_type IS TABLE OF employees%rowtype INDEX BY PLS_INTEGER;
    my_emp_table emp_table_type;
    max_count NUMBER(3) := 104;
BEGIN
    FOR I IN 100..max_count LOOP
        SELECT * INTO my_emp_table(I) FROM employees
        WHERE employee_id = I;
    END LOOP;
    FOR I IN my_emp_table.FIRST..my_emp_table.LAST LOOP
        dbms_output.put_line(my_emp_table(I).last_name);
    END LOOP;
END;
/



--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■ 커서 ■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

--커서 예제1
DECLARE
    CURSOR c_emp_cursor IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = 50;
    v_empid employees.employee_id%TYPE;
    v_empname employees.last_name%TYPE;
BEGIN
    IF NOT c_emp_cursor%isopen THEN
        OPEN c_emp_cursor;
    END IF;
    LOOP --fetch는 필연적으로 loop~exit when %notfound를 써야 유의미 함(fetch자체는 반복기능이 없어서)
        FETCH c_emp_cursor INTO v_empid, v_empname;
        EXIT WHEN c_emp_cursor%NOTFOUND;
        dbms_output.put_line(v_empid || ' ' || v_empname);
    END LOOP;
    CLOSE c_emp_cursor;
END;
/

SELECT employee_id, last_name
FROM employees
WHERE department_id = 50;



--커서 예제2
CREATE TABLE temp_list (empid, empname) AS 
    SELECT employee_id, last_name
    FROM employees
    WHERE employee_id = 0;
        
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = 50;
    emp_record emp_cursor%rowtype;
BEGIN
    IF NOT emp_cursor%isopen THEN
        OPEN emp_cursor;
    END IF;
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%notfound;
        INSERT INTO temp_list (empid, empname)
        VALUES (emp_record.employee_id, emp_record.last_name);
    END LOOP;
    COMMIT;
    CLOSE emp_cursor;
END;
/

SELECT * FROM temp_list;


/* 공식1: CURSOR 커서 IS 셀렉트문; 레코드 커서%rowtype -> 
OPEN 커서; -> LOOP FETCH 커서 into 레코드; EXIT WHEN 커서%notfound; -> CLOSE 커서; */
/* 공식2(개꿀!): CURSOR 커서 IS 셀렉트문; ->
FOR 레코드 IN 커서 LOOP --끝. 개꿀. 오픈, 페치, 클로즈, 심지어 레코드 변수선언조차 필요X */

--커서 예제3
DECLARE
    CURSOR emp_cursor IS
        SELECT last_name, department_id
        FROM employees;
BEGIN
    FOR emp_record IN emp_cursor LOOP
    dbms_output.put_line(emp_record.last_name || ' : ' || emp_record.department_id);
    END LOOP;
END;
/

--공식2에서 더 축약: 심지어 declare 조차 필요없다! 미친
BEGIN
    FOR emp_record IN (
        SELECT last_name, department_id
        FROM employees
    ) LOOP
    dbms_output.put_line(emp_record.last_name || ' : ' || emp_record.department_id);
    END LOOP;
END;
/


--커서 문제1(FOR방식->test01, 정석->test02)
--for식
CREATE TABLE test01 AS
    SELECT employee_id, last_name, hire_date
    FROM employees
    WHERE employee_id = 0;

BEGIN
    FOR emp_record IN (
        SELECT employee_id, last_name, hire_date
        FROM employees
        WHERE EXTRACT(YEAR FROM hire_date) <= 2000
    ) LOOP
    INSERT INTO test01 VALUES emp_record; --걍 괄호 빼고 레코드 변수 하나 통으로 넣자
    END LOOP;
END;
/
SELECT * FROM test01;

--정석
DECLARE
    CURSOR emp_cursor IS 
        SELECT employee_id, last_name, hire_date
        FROM employees
        WHERE EXTRACT(YEAR FROM hire_date) > 2000;
    emp_record emp_cursor%rowtype;
BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%notfound;
        --위 처럼 걍 괄호 빼고 레코드 변수 하나 통으로 넣어도 됨
        INSERT INTO test02 VALUES (emp_record.employee_id, emp_record.last_name, emp_record.hire_date);
    END LOOP;
END;
/
SELECT * FROM test02;


--교수님ed
--for식
DECLARE
    CURSOR emp_cursor IS 
        SELECT employee_id, last_name, hire_date
        FROM employees;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        --IF to_char(emp_record.hire_date,'yyyy') <= '2000' THEN
        IF emp_record.hire_date <= to_date('2000/12/31','yyyy/mm/dd') THEN
             INSERT INTO test01 VALUES emp_record;
        ELSE
             INSERT INTO test02 VALUES emp_record;
        END IF;
    END LOOP;
END;
/
DELETE FROM test01;
DELETE FROM test02;
SELECT * FROM test01;
SELECT * FROM test02;

--정석
DECLARE
    CURSOR emp_cursor IS 
        SELECT employee_id, last_name, hire_date
        FROM employees;
    emp_record emp_cursor%rowtype;
BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%notfound;
        IF to_char(emp_record.hire_date,'yyyy') <= '2000' THEN
            INSERT INTO test01 VALUES emp_record;
        ELSE
            INSERT INTO test02 VALUES emp_record;
        END IF;
    END LOOP;
END;
/



--커서 예제4: 커서 매개변수 활용
DECLARE
    CURSOR emp_cursor(v_deptno NUMBER, v_job VARCHAR2) IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = v_deptno AND job_id = v_job;
BEGIN
    FOR emp_record IN emp_cursor (90, 'AD_VP') LOOP
        dbms_output.put_line(emp_record.employee_id || ' : ' || emp_record.last_name);
    END LOOP;
    dbms_output.put_line('=====================');
    FOR emp_record IN emp_cursor (60, 'IT_PROG') LOOP
        dbms_output.put_line(emp_record.employee_id || ' : ' || emp_record.last_name);
    END LOOP;
END;
/
        

--커서 문제3
DECLARE
    CURSOR emp_cursor(v_deptno NUMBER) IS
        SELECT * FROM employees JOIN departments
        USING (department_id)
        WHERE department_id = v_deptno;
BEGIN
    FOR emp_record IN emp_cursor(&부서번호) LOOP
        dbms_output.put_line(emp_record.last_name || ' : ' || emp_record.hire_date || ' : ' || emp_record.department_name);
    END LOOP;
END;
/


--커서 문제4
DECLARE
    CURSOR emp_cursor(v_deptno NUMBER) IS
        SELECT * FROM employees JOIN departments
        USING (department_id)
        WHERE department_id = v_deptno;
BEGIN
    FOR emp_record IN emp_cursor(&부서번호) LOOP
        dbms_output.put_line(emp_record.employee_id || ' : ' || emp_record.last_name || ' : ' || emp_record.department_id);
    END LOOP;
END;
/


--커서 문제5
DECLARE
    CURSOR emp_cursor IS
        SELECT * FROM employees JOIN departments
        USING (department_id)
        WHERE department_id = &부서번호;
    v_annual_sal NUMBER := 0;
BEGIN
    FOR emp_record IN emp_cursor LOOP
    v_annual_sal := emp_record.salary*12+emp_record.salary*nvl(emp_record.commission_pct,0)*12;
        dbms_output.put_line(emp_record.employee_id || ' : ' || 
                                    emp_record.salary || ' : ' || 
                                    v_annual_sal);
    END LOOP;
END;
/




--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■ 예외처리 ■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/* 예외처리 예제1: 예외명과 발생환경이 모두 Oracle에서 미리 정의된 경우 
    -> Handling만 처리 */
DECLARE
    v_lname varchar2(15);
BEGIN
    SELECT last_name INTO v_lname
    FROM employees
    WHERE first_name = 'John';
    dbms_output.put_line('John''s last name is : ' || v_lname);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('데이터가 없습니다');
END;
/



/* 예외처리 예제2: 발생환경만 Oracle에서 미리 정의된 경우 
    -> 예외명 직접 정의(DECLARE) 및 해당 발생환경(Oracle에 기정의)과 연결 */
DECLARE
    e_insert_excep EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_insert_excep, -01400);
BEGIN
    INSERT INTO departments(department_id, department_name)
    VALUES (280, NULL);
    
EXCEPTION
    WHEN e_insert_excep THEN
        dbms_output.put_line('INSERT OPERATION FAILED');
        dbms_output.put_line(SQLERRM);
END;
/



/* 예외처리 예제3: 예외명과 발생환경이 모두 Oracle에서 미리 정의되지 않은 경우
    -> 1. 예외명 직접 정의(DECLARE)  2. 발생환경 정의(RAISE)  3. Handling 처리 */
DECLARE
    e_invalid_department EXCEPTION;
    v_deptno NUMBER := 500;
    v_name VARCHAR2(20) := 'Testing';
BEGIN
    UPDATE departments
    SET department_name = v_name
    WHERE department_id = v_deptno;
    
    IF SQL%NOTFOUND THEN
        RAISE e_invalid_department;
    END IF;
    COMMIT;
EXCEPTION
    WHEN e_invalid_department THEN
        dbms_output.put_line('No such department id.');
END;
/




--예외처리 예제4
CREATE TABLE log_table(
code NUMBER(10),
message VARCHAR2(200),
info VARCHAR2(200)
);

DECLARE
    e_toomanyemp EXCEPTION;
    v_empsal NUMBER(7);
    v_empcomm NUMBER(7);
    v_errorcode NUMBER;
    v_errortext VARCHAR2(200);
BEGIN
    SELECT salary, commission_pct*100000
    INTO v_empsal, v_empcomm
    FROM employees
    WHERE employee_id = 174;
    
    IF v_empcomm > v_empsal THEN
        RAISE e_toomanyemp;
    END IF;
EXCEPTION
    WHEN e_toomanyemp THEN
        INSERT INTO log_table(info)
        VALUES ('이 사원은 보너스가 ' || v_empcomm || '으로 월급여 ' || v_empsal || ' 보다 많다');
    WHEN OTHERS THEN
        v_errorcode := SQLCODE;
        v_errortext := substr(sqlerrm, 1, 200);
        INSERT INTO log_table
        VALUES (v_errorcode, v_errortext, 'Oracle error occurred');
END;
/
SELECT * FROM log_table;


--예외처리 예제5: RAISE_APPLICATION_ERROR(20000번대 사용 가능)
DECLARE
    v_num NUMBER := &num;
BEGIN
    IF v_num <= 0 THEN
        RAISE_APPLICATION_ERROR(-20100, '양수만 입력해주세요');
    END IF;
    dbms_output.put_line(v_num);

EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('데이터가 존재하지 않습니다');
    WHEN OTHERS THEN
        IF SQLCODE = -20100 THEN
            dbms_output.put_line(SQLERRM);
        ELSE
            dbms_output.put_line('의도하지 않은 예외사항입니다');
        END IF;
END;
/




--예외처리 문제1
CREATE TABLE emp_test AS
    SELECT employee_id, last_name
    FROM employees2
    WHERE employee_id <200;
SELECT * FROM emp_test;

DECLARE
    e_nodata EXCEPTION;
BEGIN
    DELETE FROM emp_test
    WHERE employee_id = &사원번호;
    
    IF SQL%notfound THEN
        RAISE e_nodata;
    END IF;
EXCEPTION
    WHEN e_nodata THEN
        dbms_output.put_line('해당 사원이 없습니다.');
END;
/


--예외처리 문제2
DECLARE
    e_over EXCEPTION;
    v_empid NUMBER := &사원번호;
    v_record employees2%rowtype;
BEGIN
    SELECT * 
    INTO v_record
    FROM employees2
    WHERE employee_id  = v_empid;
    
    IF EXTRACT(YEAR FROM v_record.hire_date) < 2000 THEN
        UPDATE employees2 
        SET salary = salary*1.1
        WHERE employee_id = v_empid;
    ELSIF EXTRACT(YEAR FROM v_record.hire_date) >= 2000 THEN
        RAISE e_over;
    END IF;
EXCEPTION
    WHEN e_over THEN
        dbms_output.put_line('2000년 이후 입사한 사원입니다.');
    WHEN no_data_found THEN
        dbms_output.put_line('데이터가 존재하지 않습니다');
END;
/
SELECT * FROM employees2;




--예외처리 문제3-1
DECLARE
    CURSOR v_cursor IS
        SELECT * FROM employees2
        WHERE department_id = &부서번호;    
    e_over EXCEPTION;
BEGIN
    FOR v_record IN v_cursor LOOP
    
    IF EXTRACT(YEAR FROM v_record.hire_date) < 2000 THEN
        UPDATE employees2 
        SET salary = salary*1.1
        WHERE department_id = v_record.department_id;
    ELSIF EXTRACT(YEAR FROM v_record.hire_date) >= 2000 THEN
        RAISE e_over;
    END IF;
    
    END LOOP;
EXCEPTION
    WHEN e_over THEN
        dbms_output.put_line('2000년 이후 입사한 사원입니다.');
    WHEN no_data_found THEN
        dbms_output.put_line('데이터가 존재하지 않습니다');
END;
/
SELECT * FROM employees2;


