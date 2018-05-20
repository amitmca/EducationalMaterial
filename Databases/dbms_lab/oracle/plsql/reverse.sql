declare

	l number;
	i number;
	str varchar2(20);
	rstr varchar2(20);
begin
	str:='&str';
	l:=length(str);

	for i in reverse 1..l

	loop

	   rstr:=rstr || substr(str,i,1);

	end loop;	

        dbms_output.put_line(rstr);	
end;	