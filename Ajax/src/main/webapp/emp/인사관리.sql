select d.department_name, count(1) as cnt
from employees e, departments d
where e.department_id = d.department_id
group by d.department_name;

-- title, state_date, end_date
create table schedules (
title varchar2(100),
start_date varchar2(19),
end_date varchar2(19)
);
select * from schedules;
insert into schedules(title, start_date) values('meeting1','2022-06-01');
insert into schedules(title, start_date, end_date) values('meeting3','2022-06-09','2022-06-11');
delete from schedules where title='meeting1';

commit;