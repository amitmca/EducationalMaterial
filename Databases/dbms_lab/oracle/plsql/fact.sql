set serveroutput on
declare
	n number;
	f number;
	i number;

	begin

	n:=&n;
	f:=1;	

	for i in 1..n

	 loop

	   f:=f*i;		

	 end loop;	
	
	dbms_output.put_line('Factorial is: ' || f);	
	
	end;
	/