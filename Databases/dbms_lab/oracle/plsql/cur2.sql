declare

cursor cur1 is select * from salespeople;

	snum salespeople.snum%type;
	sname salespeople.sname%type;
	city salespeople.city%type;
	comm salespeople.comm%type;

begin
	update salespeople set comm=comm+400;

	dbms_output.put_line('Records are Updated Successfully');

	dbms_output.put_line(' SNUM '|| ' SNAME ' || ' CITY' || ' COMMISSION ');

	dbms_output.put_line('--------------------------------------');
	
	open cur1;

	loop
	
	fetch cur1 into snum,sname,city,comm;
	
	exit when cur1%notfound;

	dbms_output.put_line(' ' || snum || ' '|| sname || ' '|| city || ' ' || comm);

	end loop;

	dbms_output.put_line('--------------------------------------');
	
	close cur1;
end;
