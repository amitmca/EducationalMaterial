create table BillMaster(billno integer primary key, custname varchar(20), billdate date);

create table BillDetails(itemid integer primary key,itemname varchar(20), qty integer, rate integer,billno integer references BillMaster(billno));