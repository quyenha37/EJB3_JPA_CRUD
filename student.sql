/*Target to Oracle DB*/

CREATE TABLE student(
	id number(5,0) NOT NULL PRIMARY KEY,
	first_name VARCHAR2(50),
	last_name VARCHAR2(50),
	email VARCHAR2(100)
);

insert into student (id,first_name,last_name, email) values(studentID_seq.nextval,'Darvin','Johnson', 'djohnson@consoto.com'); 
insert into student (id,first_name,last_name, email) values(studentID_seq.nextval,'Mig','Andrews', 'mandrews@consoto.com');
insert into student (id,first_name,last_name, email) values(studentID_seq.nextval,'Alex','Martin', 'amartin@consoto.com');
insert into student (id,first_name,last_name, email) values(studentID_seq.nextval,'Jon','paul', 'jpaul@consoto.com');
insert into student (id,first_name,last_name, email) values(studentID_seq.nextval,'Yatin','Bones', 'ybones@consoto.com');


CREATE SEQUENCE studentID_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 100
  INCREMENT BY 1
  CACHE 20;
  