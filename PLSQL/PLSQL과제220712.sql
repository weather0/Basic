CREATE TABLE aaa
(A NUMBER(3));

CREATE TABLE bbb
(B NUMBER(3));

SET SERVEROUTPUT ON;

/* 1. 
aaa 테이블에 1부터10까지 입력되도록 PL/SQL 블록을 작성하시오.
단, insert 문은 1번에 사용 */
BEGIN
    FOR I IN 1..10 LOOP
        INSERT INTO aaa VALUES (I);
    END LOOP;
END;
/


/* 2.
bbb 테이블에 1부터 10까지 최종 합계 값을 PL/SQL 블록으로 작성하여 입력하시오.*/
DECLARE
    v_sum NUMBER := 0;
BEGIN
    FOR I IN 1..10 LOOP
        v_sum := v_sum + I;
    END LOOP;
    dbms_output.put_line(v_sum);
    INSERT INTO bbb VALUES (v_sum);
END;
/


/* 3
aaa 테이블에 1부터 10까지 짝수만 입력되도록 PL/SQL 블록을 작성하시오.
단, insert 문은 한번 사용, if문 사용*/
BEGIN
    FOR I IN 1..10 LOOP
        IF MOD(I,2) <> 0 THEN
            CONTINUE;
        END IF;
        INSERT INTO aaa VALUES (I);
    END LOOP;
END;
/


/* 4.
bbb 테이블에 1부터 10까지 짝수 최종 합계 값을 PL/SQL 블록으로 작성하여 입력하시오.
단, if문 사용*/
DECLARE
    v_sum NUMBER := 0;
BEGIN
    FOR I IN 1..10 LOOP
        IF MOD(I,2) <> 0 THEN
            CONTINUE;
        END IF;
        v_sum := v_sum + I;
    END LOOP;
    dbms_output.put_line(v_sum);
    INSERT INTO bbb VALUES (v_sum);
END;
/


/* 5.
1부터 10까지에서 짝수의 합계는 aaa 테이블에, 홀수의 합계는 bbb 테이블에 
입력되도록 PL/SQL 블록을 작성하시오. (단, if 문 사용)*/
DECLARE
    v_sum_even NUMBER := 0;
    v_sum_odd NUMBER := 0;
BEGIN
    FOR I IN 1..10 LOOP
        IF MOD(I,2) = 0 THEN
            v_sum_even := v_sum_even + I;
        ELSE
            v_sum_odd := v_sum_odd + I;
        END IF;
    END LOOP;
    dbms_output.put_line(v_sum_even);
    dbms_output.put_line(v_sum_odd);
    INSERT INTO aaa VALUES (v_sum_even);
    INSERT INTO bbb VALUES (v_sum_odd);
END;
/