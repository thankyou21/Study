##Please run the below DDL query before you execute this application.  

CREATE TABLE dept_master
(id NUMBER(6) PRIMARY KEY,
name VARCHAR2(30));

CREATE TABLE emp_master
(id NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
salary NUMBER(6,2),
dept_no NUMBER(6) REFERENCES dept_master(id));

