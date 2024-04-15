create table user_tbl(
	user_id varchar2(50) primary key,
	user_password varchar2(50),
	user_name varchar2(10),
	user_major varchar2(50)
	
--	CONSTRAINT fk_id FOREIGN KEY(user_id)
--    REFERENCES geul_tbl(geul_id) ON DELETE CASCADE
);

insert into user_tbl values('yuhee','cyh1234','최유희','앱서비스과');
insert into user_tbl values('jiho','jiho5678','심지호','패션산업디자인과');
insert into user_tbl values('dydals','dydals9123','김용민','마케팅경영과');
insert into user_tbl values('hogi','hogi4567','윤호기','베이커리카페과');
insert into user_tbl values('tkdgns','tkdgns8912','김상훈','앱서비스과');
insert into user_tbl values('dmstj','dmstj3456','박은서','앱서비스과');

select * from user_tbl;
select * from geul_tbl;
drop table geul_tbl;
drop table user_tbl;

create table geul_tbl(
	geul_num number(5) primary key,
	geul_id varchar2(50),
	geul_content varchar2(100),
	geul_post varchar2(300),
	start_date date,
	modify_date date
);

insert into geul_tbl values(10001,'yuhee','안녕하세요 앱서비스과입니다.','저는 최유희입니다.','20240401','20240402');
insert into geul_tbl values(10002,'jiho','안녕하세요 패션과입니다.','저는 심지호입니다.','20240402','20240403');
insert into geul_tbl values(10003,'dydals','안녕하세요 마케팅과입니다.','저는 김용민입니다.','20240403','20240404');
insert into geul_tbl values(10004,'hogi','안녕하세요 베이커리과입니다.','저는 윤호기입니다.','20240404','20240406');
insert into geul_tbl values(10005,'tkdgns','안녕하세요 앱서비스과입니다.','저는 김상훈입니다.','20240405','20240404');
insert into geul_tbl values(10006,'dmstj','안녕하세요 앱서비스과입니다.','저는 박은서입니다.','20240406','20240406');

select * from geul_tbl;

select geul_num, geul_id,geul_content,substr(start_date,1,2)||'년'||substr(start_date,4,2)||'월'||substr(start_date,7,2)||'일' start_date,
substr(modify_date,1,2)||'년'||substr(modify_date,4,2)||'월'||substr(modify_date,7,2)||'일' modify_date
from geul_tbl;


update geul_tbl 
set geul_id=?, geul_content=?, start_date=?, modify_date=?
where geul_num=?;
	
					
select geul_num, geul_id, geul_content, start_date, modify_date
from geul_tbl 
where geul_num=1;	

Delete from geul_tbl where geul_num=10001;
