CREATE TABLE product(
num NUMBER PRIMARY KEY,
photo CLOB NOT NULL, 
title VARCHAR2(100) NOT NULL, 
price VARCHAR2(100) NOT NULL,
quantity NUMBER NOT NULL,
content CLOB,
regdate DATE
);

CREATE SEQUENCE product_seq;