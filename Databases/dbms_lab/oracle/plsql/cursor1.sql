declare

	cursor mycur is select eno,ename,post,sal from employee;

	no employee.eno%type;
	name employee.ename%type;
	pt employee.post%type;
	sal employee.sal%type;
begin

	update employee set sal=sal+1000;

	dbms_output.put('Records are Updated Successfully');

	dbms_output.put_line(' ');

	open mycur;

	dbms_output.put_line(' ENo '|| ' EName ' || ' Post' || ' Sal ');

	dbms_output.put_line('--------------------------------------');
	
	loop

	fetch mycur into no,name,pt,sal;

	exit when mycur%notfound;
 
	dbms_output.put_line('  '|| no || '  ' || name || '  ' || pt || '  ' || sal);
	
	end loop;

	dbms_output.put_line('--------------------------------------');

	close mycur;
end;