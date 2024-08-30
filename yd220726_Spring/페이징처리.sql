--페이징처리 방법1
select * from (
    select rownum rn, a.*
        from (
            select * from board order by 1 desc
        ) a 
    --where rownum <=20 and rownum >10 이렇게 안 먹힘
    where rownum <= 20
)
where rn >10;

--페이징처리 방법2(힌트 활용) 교재297p
select * from (
    select /*+ INDEX_DESC(board pk_board) */ rownum rn, a.*
    from board a
    where rownum <= 20
    order by bno desc
    )
where rn > 10;
