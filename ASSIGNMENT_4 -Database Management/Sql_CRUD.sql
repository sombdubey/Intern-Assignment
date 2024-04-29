#Create
CREATE TABLE customers (
    id varchar(100) PRIMARY KEY ,
    name varchar(100),
    email varchar(100) UNIQUE, #ensures unique email address
    phone varchar(100),
    address varchar(100),
    CHECK (phone REGEXP '^[0-9]+$') #data validation
);

insert into customers values(101,'Som','abc@gmail.com','1001000001','pune');
insert into customers values(102,'Tina','xyz@gmail.com','1002000001','mumbai');
insert into customers values(103,'John','def@gmail.com','1003000003','kalyan');

#Read
select * from customers;

#Update
update customers set phone = '0987654321' where id = '101';

#Delete
delete from customers where address = 'kalyan';

#Indexing
CREATE INDEX idx_email ON customers (email);
CREATE INDEX idx_phone ON customers (phone);





