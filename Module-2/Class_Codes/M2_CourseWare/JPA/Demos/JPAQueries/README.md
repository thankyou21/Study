##Please run the below DDL query before you execute this application.  

CREATE TABLE books
(id NUMBER(6) PRIMARY KEY,
title VARCHAR2(100),
author VARCHAR2(50),
price number(6,2));


insert into books
values(101,'Java Closures and Lambda','Robert Fischer',460);

insert into books
values(102,'Pro Java 8 Programming','Brett Spell',600);


insert into books
values(103,'Java for Android, Second Edition','Budi Kurniawan',680);

insert into books
values(105,'Java EE 7: The Big Picture','Danny Coward',340);


insert into books
values(104,'Java: The Complete Reference, Ninth Edition','Herbert Schildt',700);

insert into books
values(106,'Beginning Java with WebSphere','Robert W. Janson',550);

commit;