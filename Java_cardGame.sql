create database card;
use card;

create table single(
	timer int,
    name varchar(20)
);
create table multi (
	score int ,
    name varchar(20)
);
alter table single modify timer varchar(10);


drop table multi;
insert into single values(1,'BaekHwaRang');
insert into single values(50,'Jangjuri');
insert into multi values(8,'BeakHwaRang');
insert into multi values(2,'Jangjuri');

select * from single
order by timer asc , name asc;

select * from multi
order by score desc , name asc;

INSERT INTO single VALUE(5,'abc')