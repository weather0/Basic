--220715
SET SERVEROUTPUT ON;

--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■ 패키지 ■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

/* 
패키지: 변수, 커서, 프로시저 등을 논리단위로 묶음
    1. 패키지 명세: 선언 -> 패키지 바디 없을 수 있음
    2. 패키지 바디: 정의 -> 필수적으로 패키지 명세를 요구
*/

--패키지 예제1
    --명세
CREATE OR REPLACE PACKAGE comm_package
IS
    g_comm NUMBER; --초기화되지 않을 경우 NULL을 가짐
    g_num CONSTANT NUMBER := 100;
    
    PROCEDURE reset_comm (v_comm IN NUMBER);
    -- 명세에는 매개변수까지만 정의
END;
/

EXECUTE dbms_output.put_line(comm_package.g_num);


    --바디
CREATE OR REPLACE PACKAGE BODY comm_package
IS
    FUNCTION validate_comm
        (v_comm IN NUMBER)
        RETURN BOOLEAN
    IS
        v_max_comm NUMBER;
    BEGIN
        SELECT MAX(commission_pct)
        INTO v_max_comm
        FROM employees2;
        
        IF v_comm > v_max_comm THEN
            RETURN FALSE;
        ELSE
            RETURN TRUE;
        END IF;
        
    END validate_comm;
    
    PROCEDURE reset_comm
        (v_comm IN NUMBER)
    IS
        v_valid BOOLEAN;
    BEGIN
        v_valid := validate_comm(v_comm);
        IF v_valid THEN
            g_comm := v_comm;
        ELSE
            raise_application_error(-20210, 'Invalid commission!!!!');
        END IF;
    END reset_comm;
    
END;
/

EXECUTE comm_package.reset_comm(0.5);

--바디만 따로 삭제 가능
DROP PACKAGE BODY comm_package;


--USER_SOURCE: 현재 계정의 패키지, 패키지 명세, 프로시저, 함수 등을 확인 가능
--ALL_SOURCE: 현재 계정이 접근 권한 있는 패키지, 패키지 명세, 프로시저, 함수 등을 확인 가능
DESC user_source;
SELECT * FROM user_source;

DESC all_source;
SELECT * FROM all_source;


--패키지 예제2
CREATE OR REPLACE PACKAGE global_consts
IS
    mile_2_kilo CONSTANT NUMBER := 1.6093;
    kilo_2_mile CONSTANT NUMBER := 0.6214;
    yard_2_meter CONSTANT NUMBER := 0.9144;
    meter_2_yard CONSTANT NUMBER := 1.0936;
END global_consts;
/

EXECUTE dbms_output.put_line('20 miles = ' || 20*global_consts.mile_2_kilo || 'km');

CREATE OR REPLACE PROCEDURE meter_to_yard
    (p_meter IN NUMBER, p_yard OUT NUMBER)
IS
BEGIN 
    p_yard := p_meter*global_consts.meter_2_yard;
END;
/

VARIABLE yard NUMBER;
EXECUTE meter_to_yard(1, :yard);
PRINT yard;





--패키지 예제3: 오버로드
CREATE TABLE dept
AS
    SELECT department_id, department_name, location_id
    FROM departments
    WHERE department_id = 0;


CREATE OR REPLACE PACKAGE over_pack
IS
    PROCEDURE add_dept
        (v_deptno IN departments.department_id%TYPE,
        v_name IN departments.department_name%TYPE DEFAULT 'unknown',
        v_loc IN departments.location_id%TYPE DEFAULT 'unknown');
    PROCEDURE add_dept
        (v_name IN departments.department_name%TYPE DEFAULT 'unknown',
        v_loc IN departments.location_id%TYPE DEFAULT 'unknown');
END over_pack;
/

CREATE OR REPLACE PACKAGE BODY over_pack
IS
    PROCEDURE add_dept
        (v_deptno IN departments.department_id%TYPE,
        v_name IN departments.department_name%TYPE DEFAULT 'unknown',
        v_loc IN departments.location_id%TYPE DEFAULT 'unknown')
    IS
    BEGIN
        INSERT INTO dept
        VALUES (v_deptno, v_name, v_loc);
    END add_dept;

    PROCEDURE add_dept
        (v_name IN departments.department_name%TYPE DEFAULT 'unknown',
        v_loc IN departments.location_id%TYPE DEFAULT 'unknown')
    IS
        v_max_no departments.department_id%TYPE;
    BEGIN
        SELECT MAX(department_id)+1
        INTO v_max_no
        FROM dept;
        
        INSERT INTO dept
        VALUES (v_max_no, v_name, v_loc);
    END add_dept;
END over_pack;
/

EXECUTE over_pack.add_dept(200,'영업',1000);
EXECUTE over_pack.add_dept('경영',1000);

SELECT * FROM dept;



--패키지 예제4: FUNCTION
CREATE OR REPLACE PACKAGE taxes_pack
IS
    FUNCTION tax
        (p_value IN NUMBER)
    RETURN NUMBER;
END taxes_pack;
/

CREATE OR REPLACE PACKAGE BODY taxes_pack
IS
    FUNCTION tax
        (p_value IN NUMBER)
    RETURN NUMBER
    IS
        v_rate NUMBER := 0.1;
    BEGIN
        RETURN (p_value * v_rate);
    END tax;
END taxes_pack;
/

SELECT last_name, salary, taxes_pack.tax(salary)
FROM employees2;



--패키지 예제5: CURSOR
CREATE OR REPLACE PACKAGE pack_cur
IS
    CURSOR emp_id_cursor IS
        SELECT employee_id
        FROM employees2
        ORDER BY employee_id DESC;
        
    PROCEDURE proc1_3rows;
    PROCEDURE proc4_6rows;
END pack_cur;
/

CREATE OR REPLACE PACKAGE BODY pack_cur
IS
    v_empid NUMBER;
    
    PROCEDURE proc1_3rows
    IS
    BEGIN
        --커서OPEN은 여기서
        OPEN emp_id_cursor;
        
        LOOP
            FETCH emp_id_cursor INTO v_empid;
            dbms_output.put_line('ID: ' || v_empid);
            EXIT WHEN emp_id_cursor%rowcount > 3;
        END LOOP;
    END proc1_3rows;
       
    PROCEDURE proc4_6rows
    IS
    BEGIN
        LOOP
            FETCH emp_id_cursor INTO v_empid;
            dbms_output.put_line('ID: ' || v_empid);
            EXIT WHEN emp_id_cursor%rowcount > 6;
        END LOOP;
        
        --커서CLOSE는 여기에
        CLOSE emp_id_cursor;
    END proc4_6rows;
    
END pack_cur;
/

EXECUTE pack_cur.proc1_3rows;
EXECUTE pack_cur.proc4_6rows;



--패키지 예제6: 테이블
CREATE OR REPLACE PACKAGE emp_package
IS
    TYPE emp_table_type IS TABLE OF employees2%rowtype
        INDEX BY BINARY_INTEGER;
    PROCEDURE read_emp_table
        (emp_table OUT emp_table_type);
END emp_package;
/

CREATE OR REPLACE PACKAGE BODY emp_package
IS
    PROCEDURE read_emp_table
        (emp_table OUT emp_table_type)
    IS
        i BINARY_INTEGER := 0;
    BEGIN
        FOR emp_record IN (SELECT * FROM employees2) LOOP
            emp_table(i) := emp_record;
            i := i+1;
        END LOOP;
    END read_emp_table;
END emp_package;
/

DECLARE
    emp_table emp_package.emp_table_type;
BEGIN
    emp_package.read_emp_table(emp_table);
    dbms_output.put_line('An example: ' || emp_table(4).last_name);
END;
/


--패키지 문제1: 주민번호 입력 -> 나이, 성별
CREATE OR REPLACE PACKAGE yd_pkg
IS     
    FUNCTION y_age(v_num IN NUMBER)
        RETURN NUMBER;
    PROCEDURE y_sex(v_num IN NUMBER);
END yd_pkg;
/

CREATE OR REPLACE PACKAGE BODY yd_pkg
IS     
    FUNCTION y_age(v_num IN NUMBER)
        RETURN NUMBER
    IS
        v_year NUMBER;
    BEGIN
        v_year := to_number(substr(v_num,1,2));
        IF v_year <= 22 THEN
            RETURN EXTRACT(YEAR FROM sysdate) - (v_year+2000);
        ELSE
            RETURN EXTRACT(YEAR FROM sysdate) - (v_year+1900);
        END IF;
    END y_age;
    
    PROCEDURE y_sex(v_num IN NUMBER)
    IS
        v_result VARCHAR2(100);
    BEGIN
        IF substr(v_num,7,1) IN ('1','3') THEN
            v_result := '남자';
        ELSE
            v_result := '여자';
        END IF;
        
        dbms_output.put_line(v_result);
    END y_sex;
    
END yd_pkg;
/

EXECUTE dbms_output.put_line(yd_pkg.y_age(8912012676666) || '짤');
EXECUTE yd_pkg.y_sex(8912011676666);

