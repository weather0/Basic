--220714
SET SERVEROUTPUT ON;

--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■ 프로시저 ■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

--프로시저 예제1
                        --매개변수(없어도 됨): 변수명, 모드(IN), 타입
CREATE PROCEDURE raise_salary(v_id IN employees2.employee_id%TYPE)
IS
    --선언부
    v_result NUMBER;
BEGIN
    UPDATE employees2
    SET salary = salary*1.1
    WHERE employee_id = v_id;
    
    v_result := SQL%rowcount;
    
    dbms_output.put_line(v_result || '건이 실행되었습니다.');
END;
/

EXECUTE raise_salary(173);



--프로시저 예제2
--생성,수정 한번에(create or replace): 무지성 편하긴 한데 현업에서 함부로 쓰다 기존 프로시저 잘못 건드렸다간 바로 뚝배기
CREATE OR REPLACE PROCEDURE calculator(v_num IN NUMBER)
IS
    v_sum NUMBER := 0;
BEGIN
    FOR i IN 1..v_num LOOP
        v_sum := v_sum + i;
    END LOOP;
    dbms_output.put_line(v_sum);
END;
/

EXECUTE calculator(10);



--프로시저 예제3: OUT
CREATE OR REPLACE PROCEDURE query_emp(
    v_id IN employees2.employee_id%TYPE,
    v_name OUT employees2.last_name%TYPE,
    v_salary OUT employees2.salary%TYPE,
    v_comm OUT employees2.commission_pct%TYPE
) IS
BEGIN
    SELECT last_name, salary, commission_pct
    INTO v_name, v_salary, v_comm
    FROM employees2
    WHERE employee_id = v_id;
END;
/
    --out받을 전역변수
VARIABLE g_name VARCHAR2(15);
VARIABLE g_salary NUMBER;
VARIABLE g_comm NUMBER;

EXECUTE query_emp(173, :g_name, :g_salary, :g_comm);

PRINT g_name;
PRINT g_salary;
PRINT g_comm;

SELECT * FROM employees2 WHERE commission_pct IS NOT NULL;


--프로시저 예제4: OUT
CREATE OR REPLACE PROCEDURE calculator(
    v_num IN NUMBER, v_sum OUT NUMBER
) IS
    --v_sum은 OUT으로서 초기화 안 되므로 별도 초기화 변수를 활용해야 함
    v_temp NUMBER := 0;
BEGIN
    FOR i IN 1..v_num LOOP
        v_temp := v_temp + i;
    END LOOP;
    v_sum := v_temp;
    dbms_output.put_line(v_sum);
END;
/

VARIABLE g_sum NUMBER;

EXECUTE calculator(10, :g_sum);

PRINT g_sum;


--프로시저 예제5: IN OUT
CREATE OR REPLACE PROCEDURE format_phone(
    v_phone_no IN OUT VARCHAR2
) IS
BEGIN
    v_phone_no := '(' || substr(v_phone_no, 1, 3) ||
                        ')' || substr(v_phone_no, 4, 3) ||
                        '-' || substr(v_phone_no, 7);
END;
/

DECLARE
    phone_no VARCHAR2(100) := '0531234567';
BEGIN
    format_phone(phone_no);
    dbms_output.put_line(phone_no);
END;
/


--프로시저 예제6: 재사용
CREATE OR REPLACE PROCEDURE raise_salary(
    v_id IN employees.employee_id%TYPE
)IS
BEGIN
    UPDATE employees2
    SET salary = salary*20
    WHERE employee_id = v_id;
END;
/

CREATE OR REPLACE PROCEDURE process_emps
IS
    CURSOR emp_cursor IS
        SELECT employee_id
        FROM employees2;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        raise_salary(emp_record.employee_id);
    END LOOP;
END;
/

EXECUTE process_emps;

--프로시저 삭제
DROP PROCEDURE calculator;



--프로시저 문제1: 주민번호 출력
CREATE OR REPLACE PROCEDURE yedam_ju(v_birth IN VARCHAR2) --00년생때문에 varchar타입으로
IS
BEGIN
    dbms_output.put_line(substr(v_birth,0,6) || '-' || substr(v_birth,7,1) || '******');
    dbms_output.put_line(substr(v_birth,0,6) || '-' || rpad(substr(v_birth,7,1),7,'*')); --교수님ed
END;
/

EXECUTE yedam_ju(9501011667777);


--프로시저 문제2: 사원번호 입력 -> 삭제
CREATE OR REPLACE PROCEDURE test_pro (v_id IN employees2.employee_id%TYPE)
IS
BEGIN
    DELETE FROM employees2
    WHERE employee_id = v_id;
    
    IF SQL%notfound THEN
    dbms_output.put_line('해당사원이 없습니다');
    END IF;
    
END;
/

EXECUTE test_pro(102);


--프로시저 문제3: 사원번호 입력 -> last_name 첫글자 체외 *출력
CREATE OR REPLACE PROCEDURE yedam_emp (v_id IN employees2.employee_id%TYPE)
IS
    v_rec employees2%rowtype;
    v_star VARCHAR2(100) := '';
BEGIN
    SELECT * 
    INTO v_rec
    FROM employees2
    WHERE employee_id = v_id;
    
    FOR I IN 1..LENGTH(v_rec.last_name)-1 LOOP
        v_star := v_star || '*';
    END LOOP;
    dbms_output.put_line(v_rec.last_name || ' -> ' || substr(v_rec.last_name,0,1) || v_star);
    dbms_output.put_line(v_rec.last_name || ' -> ' || rpad(substr(v_rec.last_name,0,1),length(v_rec.last_name),'*')); --교수님ed
END;
/
EXECUTE yedam_emp(119);


--프로시저 문제4: 부서번호 -> 사원번호, last_name 출력
CREATE OR REPLACE PROCEDURE get_emp (v_depid IN employees2.department_id%TYPE)
IS
    CURSOR v_cur IS
        SELECT * FROM employees2
        WHERE department_id = v_depid;
    e_nodata EXCEPTION;
    v_rec v_cur%rowtype;
BEGIN
    IF NOT v_cur%isopen THEN
        OPEN v_cur;
    END IF;
    
    LOOP
        FETCH v_cur INTO v_rec;
        EXIT WHEN v_cur%notfound;
        dbms_output.put_line(v_rec.employee_id || ' : ' || v_rec.last_name);
    END LOOP;
    
    --어제 예외처리문제2, 3 경우와 마찬가지로 이 예외처리시 쓸거면 for방식 커서는 안 먹힌다!! 반드시 정석 커서 사용!
    IF v_cur%rowcount = 0 THEN
        RAISE e_nodata;
    END IF;
    
    CLOSE v_cur;
    
EXCEPTION
    WHEN e_nodata THEN
        dbms_output.put_line('해당사원이 없습니다');

END;
/

EXECUTE get_emp(10);


--프로시저 문제5: 사번, 급여상승률 입력 -> 사원급여 갱신
CREATE OR REPLACE PROCEDURE y_update (
    v_id IN employees2.employee_id%TYPE, 
    v_up IN NUMBER)
IS
    e_nodata EXCEPTION;
BEGIN
    UPDATE employees2
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

EXECUTE y_update(202, 100);




--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■ 함수 ■■■■■■■■■■■■■■
--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

--함수(Function) 예제1
CREATE OR REPLACE FUNCTION get_sal
    --(선택사항) 매개변수: IN만 가능
    (v_id IN employees2.employee_id%TYPE)
    --(필수사항) 리턴 타입
    RETURN NUMBER
IS
    v_salary employees2.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_salary
    FROM employees2
    WHERE employee_id = v_id;
    
    --(필수사항) 리턴 값
    RETURN v_salary;
END;
/
    --결과표시방법1
EXECUTE dbms_output.put_line(get_sal(201));
    --결과표시방법2
VARIABLE g_salary NUMBER;
EXECUTE :g_salary := get_sal(201);
PRINT g_salary;
    --결과표시방법3
SELECT get_sal(201) FROM dual;


--함수 실습1
CREATE OR REPLACE FUNCTION check_sal RETURN BOOLEAN
IS
    v_dept_id employees2.department_id%TYPE;
    v_empno employees2.employee_id%TYPE;
    v_sal employees2.salary%TYPE;
    v_avg_sal employees2.salary%TYPE;
BEGIN
    v_empno := 192;
    SELECT salary, department_id
    INTO v_sal, v_dept_id
    FROM employees2
    WHERE employee_id = v_empno;
    
    SELECT AVG(salary)
    INTO v_avg_sal
    FROM employees2
    WHERE department_id = v_dept_id;
    
    IF v_sal > v_avg_sal THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN no_data_found THEN
        RETURN NULL;
END;
/

BEGIN
    IF (check_sal IS NULL) THEN
        dbms_output.put_line('참');
    ELSIF (check_sal) THEN
        dbms_output.put_line('v_sal > v_avg_sal');
    ELSE
        dbms_output.put_line('v_sal < v_avg_sal');
    END IF;
END;
/

--함수 문제1
--<작성중>

--함수 문제2
CREATE OR REPLACE FUNCTION ydinc (v_id IN employees2.employee_id%TYPE)
    RETURN NUMBER
IS
    v_sal employees2.salary%TYPE;
    v_newsal NUMBER;
BEGIN
    SELECT salary
    INTO v_sal
    FROM employees2
    WHERE employee_id = v_id;
    
    IF v_sal <= 5000 THEN
        v_newsal := v_sal*1.2;
    ELSIF v_sal <= 10000 THEN
        v_newsal := v_sal*1.15;
    ELSIF v_sal <= 20000 THEN
        v_newsal := v_sal*1.1;
    ELSE
        v_newsal := v_sal;
    END IF;
    
    RETURN v_newsal;
END;
/
--매개변수로 칼럼자체 넣기 가능
SELECT last_name, salary, ydinc(employee_id)
FROM employees2;


--함수 문제3: 사원번호 -> 연봉
CREATE OR REPLACE FUNCTION yd_func (v_id IN employees2.employee_id%TYPE)
    RETURN NUMBER
IS
    v_annual_sal NUMBER;
BEGIN
    SELECT (salary+(salary*nvl(commission_pct,0)))*12
    INTO v_annual_sal
    FROM employees2
    WHERE employee_id = v_id;
    
    RETURN v_annual_sal;
END;
/
SELECT last_name, salary, yd_func(employee_id)
FROM employees2;


--함수 문제4
CREATE OR REPLACE FUNCTION subname (v_name IN employees2.last_name%TYPE)
    RETURN VARCHAR2
IS
    v_result VARCHAR2(100);
BEGIN
    v_result := rpad(substr(v_name,0,1),LENGTH(v_name),'*');
    RETURN v_result;
END;
/
SELECT last_name, subname(last_name)
FROM employees2;

