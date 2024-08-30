--220712
SET SERVEROUTPUT ON;

DECLARE
    v_weight  NUMBER(3) := 600;
    v_message VARCHAR2(255) := 'Product 10012';
BEGIN
    DECLARE
        v_weight   NUMBER(7, 2) := 50000;
        v_message  VARCHAR2(255) := 'Product 11001';
        v_new_locn VARCHAR2(50) := 'Europe';
    BEGIN
        v_weight := v_weight + 1;
        v_new_locn := 'Western ' || v_new_locn;
        dbms_output.put_line(v_new_locn);
        dbms_output.put_line('inner data: ' || v_message);
    END;

    v_weight := v_weight + 1;
    v_message := v_message || ' is in stock';
    --v_new_locn := 'Western' || v_new_locn;
    dbms_output.put_line(v_message);
    --중첩블록시 변수명은 다르게 하는 게 좋음(이처럼 같으면 오류발생 가능성)
END;
/


--SELECT문 예제 (SELECT 와 INTO 반드시 한 쌍!)
DECLARE
    --그냥 임의로 대충 varchar2(100)이런식으로 타입 정하는 거 보다 실제 테이블의 타입과 일치시켜주는게 좋음(%TYPE)
    v_sum_sal employees.salary%TYPE;
    v_deptno NUMBER NOT NULL := 10;
BEGIN
    SELECT SUM(salary)
    INTO v_sum_sal
    FROM employees
    WHERE department_id = v_deptno;
    
    dbms_output.put_line(v_sum_sal);
END;
/

--커서 
DECLARE
    v_deptno NUMBER := 30;
    v_rows_deleted VARCHAR2(100);
BEGIN
    DELETE FROM employees
    WHERE department_id = v_deptno;
    -- 커서속성 SQL%rowcount
    v_rows_deleted := SQL%rowcount || 'rows deleted';
    
    dbms_output.put_line(v_rows_deleted);
END;
/


--문제1
DECLARE
    v_empid employees.employee_id%TYPE;
    v_empname employees.last_name%TYPE;
    v_deptname departments.department_name%TYPE;
BEGIN
    SELECT employee_id, last_name, department_name
    INTO v_empid, v_empname, v_deptname
    FROM employees JOIN departments
    USING (department_id)
    --위에서 변수 따로 선언 안 하고 쿼리에 바로 입력기능(&)넣어도 됨
    WHERE employee_id = &사원번호;
    dbms_output.put_line('사원번호: ' || v_empid || CHR(10) || 
                                '이름: ' || v_empname || CHR(10) || 
                                '부서명: ' || v_deptname);
    
END;
/




--문제2
DECLARE
    v_empname employees.last_name%TYPE;
    v_sal NUMBER;
    v_annual_sal NUMBER;
BEGIN
    SELECT last_name, salary, salary*12+nvl(salary,0)*nvl(commission_pct,0)*12
    INTO v_empname, v_sal, v_annual_sal
    FROM employees
    WHERE employee_id = &사원번호;
    dbms_output.put_line('이름: ' || v_empname || CHR(10) || 
                                '급여: ' || v_sal || CHR(10) || 
                                '연봉: ' || v_annual_sal);
    
END;
/

--IF문 예제
DECLARE
    v_age NUMBER := &age;
BEGIN
    IF v_age < 20 THEN
        dbms_output.put_line('미성년자입니다.');
    ELSE
        dbms_output.put_line('성인입니다.');
    END IF;
END;
/


--IF문 실습
DECLARE
    v_myage number := &나이;
BEGIN
    IF v_myage < 11 THEN
        dbms_output.put_line('I am a child');
    ELSIF v_myage < 20 THEN
        dbms_output.put_line('I am a young');
    ELSIF v_myage < 30 THEN
        dbms_output.put_line('I am in my twenties');
    ELSIF v_myage < 40 THEN
        dbms_output.put_line('I am in my thirties');
    ELSE
        dbms_output.put_line('''청''춘은 ''바''로 ''지''금부터!');
    END IF;
END;
/




--if문제1 (부서번호10->emp10, 부서번호20->emp20, ...)
CREATE TABLE emp_80
AS SELECT * FROM employees WHERE employee_id = 0;

DECLARE
--    v_dept employees.department_id%type;
--    v_empid employees.employee_id%type;
--    v_name employees.last_name%type;

    --레코드 이용하면 노가다로 변수 따로 설정할 필요 없다! 한방에 가능!
    v_emp_record employees%rowtype;
--    v_table_no varchar2(100);
BEGIN
    SELECT *
    INTO v_emp_record
    FROM employees
    WHERE employee_id = &사원번호;
    
/*    v_table_no := 'emp_' || v_emp_record.department_id;
    dbms_output.put_line(v_table_no);*/
/*   insert into v_table_no
    values v_emp_record;*/
      
    IF v_emp_record.department_id = 10 THEN
        INSERT INTO emp_10
        VALUES v_emp_record;
    ELSIF v_emp_record.department_id = 50 THEN
        INSERT INTO emp_50
        VALUES v_emp_record;
    END IF;
END;
/


--if문제2
DECLARE
    v_emp_record employees%rowtype;
    v_newsal NUMBER;
BEGIN
    SELECT *
    INTO v_emp_record
    FROM employees
    WHERE employee_id = &사원번호;
    
    IF v_emp_record.salary <= 5000 THEN
        v_newsal := v_emp_record.salary*1.2;
    ELSIF v_emp_record.salary <= 10000 THEN
        v_newsal := v_emp_record.salary*1.15;
    ELSIF v_emp_record.salary <= 15000 THEN
        v_newsal := v_emp_record.salary*1.1;
    ELSIF v_emp_record.salary > 15000 THEN
        v_newsal := v_emp_record.salary;
    END IF;
    
    dbms_output.put_line('이름: ' || v_emp_record.last_name || CHR(10) || 
                            '급여: ' || v_emp_record.salary || CHR(10) || 
                            '인상급여: ' || v_newsal);
END;
/ 



--if문제3
BEGIN
    DELETE FROM emp_50
    WHERE employee_id = &사원번호;
    -- NOTFOUND가 true면(SQL문이 적용된 행이 없음이 true면)
    IF SQL%NOTFOUND THEN
        dbms_output.put_line('해당사원이 없습니다');
    END IF;
END;
/


--기본LOOP(EXIT WHEN)문, FOR LOOP문, WHILE LOOP문 예제
DECLARE
    v_countryid locations.country_id%TYPE := 'CA';
    v_loc_id locations.location_id%TYPE;
    v_new_city locations.city%TYPE := 'Montreal';
    v_counter NUMBER(2) := 1;
BEGIN
    SELECT MAX(location_id)
    INTO v_loc_id
    FROM locations
    WHERE country_id = v_countryid;
    
--    FOR i IN 1..3 
    WHILE v_counter <= 3
    LOOP
        INSERT INTO locations(location_id, city, country_id)
--        VALUES((v_loc_id + i), v_new_city, v_countryid);
        VALUES ((v_loc_id + v_counter), v_new_city, v_countryid);
        v_counter := v_counter + 1;
--        EXIT WHEN v_counter > 3;
    END LOOP;
END;
/

SELECT * FROM locations;


--loop문제1(별찍기) (3가지방법: 기본, for, while)
DECLARE
v_star VARCHAR2(100);
v_counter NUMBER := 1;
BEGIN
--    WHILE v_counter <= 5
--    FOR i IN 1..5
    LOOP
    v_star := v_star || '*';
    dbms_output.put_line(v_star);
    v_counter := v_counter + 1;
    EXIT WHEN v_counter > 5;
    END LOOP;
END;
/


--loop문제2(구구단) (3가지방법: 기본, for, while)
DECLARE
v_level NUMBER := &단수입력;
v_counter NUMBER := 0;
BEGIN
--    WHILE v_counter <= 8
--    FOR i IN 1..9
    LOOP
--    dbms_output.put_line(v_level || ' * ' || i || ' = ' || v_level*i);
    v_counter := v_counter + 1;
    dbms_output.put_line(v_level || ' * ' || v_counter || ' = ' || v_level*v_counter);
    EXIT WHEN v_counter >8;
    END LOOP;
END;
/

--loop문제3(구구단2~9단)
BEGIN
    FOR i IN 2..9 LOOP
        dbms_output.put_line('===== ' || I || '단 =====');
        FOR j IN 1..9 LOOP
        dbms_output.put_line(i || ' * ' || j || ' = ' || i*j);
        END LOOP;
    END LOOP;
END;
/


--loop문제4(구구단1~9중 홀수단)
BEGIN
    FOR I IN 1..9 LOOP
    -- 다른방법: continue 기능도 가능!!
        IF MOD(I,2) = 0 THEN
            CONTINUE;
        END IF;
        
--        IF MOD(I,2) <> 0 THEN -- <>대신 != 해도 됨
            dbms_output.put_line('===== ' || I || '단 =====');
            FOR J IN 1..9 LOOP
            dbms_output.put_line(I || ' * ' || J || ' = ' || I*J);
            END LOOP;
--        END IF;
    END LOOP;
END;
/


--문제5(생년월일 입력시 띠 출력)
DECLARE
--치환변수에 따옴표해줘야 스트링으로 받음(따옴표 없는 채로 000809을 입력하면 아예 809로 받아들임)
v_bchar VARCHAR(100) := '&생년월일';
v_birth NUMBER;
v_result NUMBER;
BEGIN
    -- v_birth가 넘버타입이라 굳이 v_char를 to_number처리 안 해줘도 되는 듯
    IF LENGTH(v_bchar) = 8 THEN
        v_birth := substr(v_bchar,1,4);
    ELSIF LENGTH(v_bchar) = 6 AND substr(v_bchar,1,2) >= 30 THEN
        v_birth := '19'||substr(v_bchar,1,2);
    ELSIF LENGTH(v_bchar) = 6 AND substr(v_bchar,1,2) < 30 THEN
        v_birth := '20'||substr(v_bchar,1,2);
    ELSE
        dbms_output.put_line('입력오류');
    END IF;
    
    dbms_output.put_line(v_birth);
    v_result := MOD(v_birth,12); --밑에 if에 mod 일일이 다 처넣으면 연산이 너무 많이 일어나므로 변수로 담아주자
    
    IF v_result = 9 THEN
        dbms_output.put_line('뱀띠');
    ELSIF v_result = 10 THEN
        dbms_output.put_line('말띠');
    ELSIF v_result = 11 THEN
        dbms_output.put_line('양띠');
    ELSIF v_result = 0 THEN
        dbms_output.put_line('원숭이띠');
    ELSIF v_result = 1 THEN
        dbms_output.put_line('닭띠');
    ELSIF v_result = 2 THEN
        dbms_output.put_line('개띠');
    ELSIF v_result = 3 THEN
        dbms_output.put_line('돼지띠');
    ELSIF v_result = 4 THEN
        dbms_output.put_line('쥐띠');
    ELSIF v_result = 5 THEN
        dbms_output.put_line('소띠');
    ELSIF v_result = 6 THEN
        dbms_output.put_line('호랑이띠');
    ELSIF v_result = 7 THEN
        dbms_output.put_line('토끼띠');
    ELSIF v_result = 8 THEN
        dbms_output.put_line('용띠');    
    END IF;
END;
/



--레코드 예제
DECLARE
    TYPE dept_record_type IS RECORD (
        --필드타입(조건or초기값)
        deptno departments.department_id%type,
        dname departments.department_name%type,
        loc departments.location_id%type
    );
    --변수 선언해줘야 함
    dept_record dept_record_type;
BEGIN
    SELECT department_id, department_name, location_id
    INTO dept_record
    FROM departments
    WHERE department_id = 40;
    
    dbms_output.put_line(dept_record.deptno);
    dbms_output.put_line(dept_record.dname);
    dbms_output.put_line(dept_record.loc);
END;
/


DECLARE
    dept_record departments%rowtype;
BEGIN
    SELECT department_id, department_name, location_id
    INTO dept_record.department_id, dept_record.department_name, dept_record.location_id
    FROM departments
    WHERE department_id = 50;
    
    dbms_output.put_line(dept_record.department_id);
    dbms_output.put_line(dept_record.department_name);
    dbms_output.put_line(dept_record.location_id);    
END;
/


