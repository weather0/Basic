--필수!! 무지성 맨 처음!
SET SERVEROUTPUT ON;

DECLARE
v_sal NUMBER(9,2) := &p_annual_sal;
BEGIN
v_sal := v_sal/12;
/* 자바의 syso, JS의 console.log 같은 거 */
DBMS_OUTPUT.PUT_LINE('The monthly salary is ' || v_sal);
END;
/* 실행은 슬래시로 */
/