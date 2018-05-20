
--to create a table for application developer
create table scheduleforexam_app_devp_tb(userid varchar(30)primary key,user_pwd varchar(6))

--to create a table for adminstrator for login 
create table scheduleforexam_admin_login_tb(admin_id varchar(30)primary key,admin_pwd varchar(6))

--to create a table for registration 
create table scheduleforexam_reg_tb(examinee_name varchar(30),D_O_B smalldatetime, ph_no numeric(10), address varchar(50), qualification varchar(10), technology varchar(10), work_exp numeric(3),pk_reg_examinee_id varchar(25)primary key, examinee_pwd varchar(6))

--to create a table for schedule
--create table scheduleforexam_exam_schedule_tb(halltkt numeric identity(13800,1),certification_exam varchar(10),exam_center varchar(15), exam_date datetime,exam_time numeric(8), duration numeric(8), exam_city varchar(15), fk_scheduleforexam_exam_schedule_tb_scheduleforexam_reg_tb_examinee_id varchar (10) references scheduleforexam_reg_tb(pk_reg_examinee_id))
--to create a table for adminstration to allocate the dates
create table scheduleforexam_admin_tb(fk_scheduleforexam_admin_tb_exam_tb_cert_id varchar(10)references scheduleforexam_exam_tb(pk_exam_tb_cert_id),certification_exam varchar(25),exam_dates datetime,exam_time numeric(8),total_seats numeric(4),city varchar(25),center varchar(25);)
create table scheduleforexam_exam_tb(pk_exam_tb_cert_id varchar(10)primary key,exam_name varchar(20))
create table scheduleforexam_city_tb(city_code varchar(50),pk_city_name varchar(50) primary key,num_centers numeric(5))
create table scheduleforexam_center_tb(center_code varchar(10),center_name varchar(10),fk_scheduleforexam_center_tb_scheduleforexam_city_tb_city varchar(10)references scheduleforexam_city_tb(pk_city_name),total_seats numeric (2),address varchar(30))
/*Here we are inserting the data for the adminstrator
   by using which we able to login*/
insert into scheduleforexam_admin_login_tb values ('venugopal','123456')
--Here we are checking whether the values are inserted or not 
select *from scheduleforexam_admin_login_tb
/*Here we are insertng the multiple data for the application developer 
  so that the application developers will login*/
insert into scheduleforexam_app_devp_tb values ('abc123','abc123')
insert into scheduleforexam_app_devp_tb values ('def123','def123')
insert into scheduleforexam_app_devp_tb values ('pqr123','pqr123')
insert into scheduleforexam_app_devp_tb values ('xyz123','xyz123')
insert into scheduleforexam_app_devp_tb values ('mno123','mno123')
--Here we are checking whether the values are inserted into the table or not. 
select *from scheduleforexam_exam_schedule_tb 
drop table scheduleforexam_reg_tb
insert into scheduleforexam_exam_tb values('1','MS.net')
insert into scheduleforexam_exam_tb values('2','Java')
select *from scheduleforexam_reg_tb
select * from scheduleforexam_admin_tb
select * from scheduleforexam_exam_tb
select * from scheduleforexam_admin_login_tb
select * from scheduleforexam_admin_tb
select center.center_name from scheduleforexam_city_tb as city,scheduleforexam_center_tb as center where center.fk_scheduleforexam_center_tb_scheduleforexam_city_tb_city=city.pk_city_name



select distinct pk_city_name from scheduleforexam_city_tb
insert into scheduleforexam_center_tb values('101','db','vzg',10,'madhapur')
select center.center_name from scheduleforexam_city_tb as city,scheduleforexam_center_tb as center where center.fk_scheduleforexam_center_tb_scheduleforexam_city_tb_city=city.pk_city_name
select *  from scheduleforexam_center_tb
insert into   scheduleforexam_admin_tb values('1','MS.net','2/10/2005 12:00:00 AM',15,5,'vjw','kb')
insert  into scheduleforexam_reg_tb values('name','01/01/2000',34124124,'sadfasd','sdfs','sdfa',0,'sadf','sadfsd')

insert into scheduleforexam_admin_tb values('102C','ffff','1/29/2007 12:00:00 AM',12,2,'','')
select * from scheduleforexam_admin_tb
select *from scheduleforexam_exam_schedule_tb
create table scheduleforexam_exam_schedule_tb(halltkt numeric identity(13800,1),certification_exam varchar(10),exam_center varchar(15), exam_date datetime,exam_time numeric(8), duration numeric(8), exam_city varchar(15), fk_scheduleforexam_exam_schedule_tb_scheduleforexam_reg_tb_examinee_id varchar (10) references scheduleforexam_reg_tb(pk_reg_examinee_id))
create table examschedule(halltkt numeric identity(14800,1),certification_exam varchar(25),city varchar (25),center varchar(25),avbdate datetime,extime numeric(2),pk_examid varchar(20))
select * from examschedule
select * from scheduleforexam_center_tb

drop table examschedule
select *from scheduleforexam_city_tb


select distinct address from scheduleforexam_center_tb as c where center_name=(select center from examschedule where halltkt=14838)


delete from  scheduleforexam_city_tb where city_code='ap101'

select * from scheduleforexam_reg_tb


insert into scheduleforexam_admin_tb values('cpp',


insert into   scheduleforexam_admin_tb values('2000','vb.net','2/10/2005 12:00:00 AM',1500,5,'vjw','kb')


select address from  scheduleforexam_center_tb as center,examschedule as sch where sch.center=center.center_name




________________________________________________________________________________


drop table scheduleforexam_app_devp_tb--
drop table scheduleforexam_admin_login_tb--
drop table scheduleforexam_reg_tb--
drop table scheduleforexam_admin_tb--
drop table scheduleforexam_exam_tb--
drop table scheduleforexam_center_tb--
drop table scheduleforexam_city_tb--
drop table examschedule

--creation
create table scheduleforexam_app_devp_tb(userid varchar(30)primary key,user_pwd varchar(6))
create table scheduleforexam_admin_login_tb(admin_id varchar(30)primary key,admin_pwd varchar(6))
create table scheduleforexam_admin_tb(fk_scheduleforexam_admin_tb_exam_tb_cert_id varchar(10)references scheduleforexam_exam_tb(pk_exam_tb_cert_id),certification_exam varchar(25),exam_dates datetime,exam_time numeric(8),total_seats numeric(4),city varchar(25),center varchar(25))
create table scheduleforexam_exam_tb(pk_exam_tb_cert_id varchar(10)primary key,exam_name varchar(20))
create table scheduleforexam_reg_tb(examinee_name varchar(30),D_O_B smalldatetime, ph_no numeric(10), address varchar(50), qualification varchar(10), technology varchar(10), work_exp numeric(3),pk_reg_examinee_id varchar(25)primary key, examinee_pwd varchar(6))
create table scheduleforexam_city_tb(city_code varchar(50),pk_city_name varchar(50) primary key,num_centers numeric(5))
create table scheduleforexam_center_tb(center_code varchar(10),center_name varchar(10),fk_scheduleforexam_center_tb_scheduleforexam_city_tb_city varchar(50)references scheduleforexam_city_tb(pk_city_name),total_seats numeric (2),address varchar(75))
create table examschedule(halltkt numeric identity(14800,1),certification_exam varchar(25),city varchar (25),center varchar(25),avbdate datetime,extime numeric(2),pk_examid varchar(20))

--insertion
--insertion into application developer
insert into scheduleforexam_app_devp_tb values ('abc123','abc123')
insert into scheduleforexam_app_devp_tb values ('def123','def123')
insert into scheduleforexam_app_devp_tb values ('pqr123','pqr123')
insert into scheduleforexam_app_devp_tb values ('xyz123','xyz123')
insert into scheduleforexam_app_devp_tb values ('mno123','mno123')
--insert into administrator login table
insert into scheduleforexam_admin_login_tb values ('venugopal','123456')

select *from scheduleforexam_city_tb
select *from scheduleforexam_admin_tb
select *from scheduleforexam_center_tb
select *from examschedule