declare

	id number;
	sal employee.sal%type;
begin
	id:=&id;

	update employee set sal=sal+sal*0.15 where eno=id;
	
	dbms_output.put_line('Record Updated Successfully');

end;