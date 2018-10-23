##Please run the below DDL query before you execute this application.  

CREATE TABLE order_master
(id NUMBER(6) PRIMARY KEY,
order_date DATE);

CREATE TABLE product_master
(id NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
price NUMBER(6,2));

CREATE TABLE product_orders
(order_id NUMBER(6) REFERENCES order_master(id),
product_id NUMBER(6) REFERENCES product_master(id),
PRIMARY KEY(order_id,product_id));

