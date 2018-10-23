##Please run the below DDL query before you execute this application.  

CREATE TABLE address
(address_id NUMBER(6) PRIMARY KEY,
address_street VARCHAR2(30),
address_city VARCHAR2(30),
address_state VARCHAR2(20),
address_zipcode VARCHAR2(6));

CREATE TABLE students
(studentId NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
address_id NUMBER(6) REFERENCES address(address_id));
