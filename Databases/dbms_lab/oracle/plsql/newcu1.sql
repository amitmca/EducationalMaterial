declare
	cursor emp_cur is select * from employee;

	emp_rec emp_cur%rowtype;

begin
	open emp_cur;

	loop

	fetch emp_cur into emp_rec;

	exit when emp_cur%notfound;

	dbms_output.put_line(' '||emp_rec.eno || ' '||emp_rec.ename);

	fetch emp_cur into emp_rec;

	end loop;
	
	close emp_cur;	
end;