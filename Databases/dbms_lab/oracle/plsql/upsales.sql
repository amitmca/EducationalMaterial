declare
	sno number;
	comm salespeople.comm%type;	
begin
	sno:=&sno;

	update salespeople set comm=comm+200 where snum=sno;

	select snum,comm into sno,comm from salespeople where sno=snum;

	dbms_output.put_line(' ' || sno || ' '|| comm);
end;