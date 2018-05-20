declare
	n number;
	i number;
	sum1 number;
begin
	n:=&n;
	sum1:=0;	
	
	for i in 1..n 

	 loop

	    sum1:=sum1+i;

	 end loop;  

	dbms_output.put_line('Sum is : ' || sum1);
end;