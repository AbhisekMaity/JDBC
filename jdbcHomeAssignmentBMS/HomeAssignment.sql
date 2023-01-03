use abhiseklabdb;

create table bank 
(account_no integer unique,
account_holder varchar(20),
ifsc_code varchar(20) unique,
branch varchar(10),
account_type varchar(10),
balance numeric(12,2),
pin numeric(4));

select * from bank;
