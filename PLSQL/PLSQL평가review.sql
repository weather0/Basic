SET SERVEROUTPUT ON;

--7
CREATE OR REPLACE PROCEDURE f_age_sex(v_num IN VARCHAR2)
IS
    v_year NUMBER;
    v_sex VARCHAR2(100);
    v_now NUMBER := EXTRACT(year from sysdate);
BEGIN
    v_year := to_number(substr(v_num,1,2));
    IF v_year <= 22 THEN
        dbms_output.put_line('나이: ' || (v_now - (v_year+2000))); 
        --괄호를 한번 더 크게 묶어줬어야 함!!!!! 이거 때문일 줄은 상상도 ㄴ('ㅇ')ㄱ
    ELSE
        dbms_output.put_line('나이: ' || (v_now - (v_year+1900)));
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



--9
--부서테이블에 매니저id열 따로 있는 줄 몰르고 내내 삽질함 서브쿼리로 조지면 개 쉬움
CREATE OR REPLACE FUNCTION f_mgr_name (v_depname IN VARCHAR2)
    RETURN VARCHAR2
IS
    v_result employees.last_name%TYPE;
BEGIN
    SELECT last_name
    INTO v_result
    FROM employees JOIN departments
    USING(department_id)
    WHERE employee_id = (
        SELECT manager_id
        FROM departments
        WHERE LOWER(department_name) = LOWER(v_depname)
    );
    RETURN v_result;
END;
/
EXECUTE dbms_output.put_line(f_mgr_name('ACcounTinG'));
EXECUTE dbms_output.put_line(f_mgr_name('eXEcutIvE'));
