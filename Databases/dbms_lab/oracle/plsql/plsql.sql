declare

	id number;
	name employee.ename%type;
	pt employee.post%type;
	sal employee.sal%type;
begin
	id:=&id;

	select eno,ename,post,sal into id,name,pt,sal from employee where eno=id;
	
	dbms_output.put_line(' ' || id || ' ' || name || ' ' || pt || ' ' || sal);

end;