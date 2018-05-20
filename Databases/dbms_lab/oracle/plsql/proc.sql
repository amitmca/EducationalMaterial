	

create or replace procedure fact(n in number) return number as


declare

	
	f number;
	i number;

begin

	
	f:=1;	

	for i in 1..n

	 loop

	   f:=f*i;		

	 end loop;	
	
	dbms_output.put_line('Factorial is: ' || f);	
end;
