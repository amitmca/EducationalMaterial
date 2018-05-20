declare

	cursor cur is select * from employee;
	eno employee.eno%type;
	ename employee.ename%type;

begin
	open cur;

	loop

	fetch cur into eno,ename;

	exit when cur%notfound;

	dbms_output.put_line(' '|| eno || ' '||ename);

	end loop;
	
	close cur;	
end;