declare

	n number;
	i number;
	j number;

begin
	n:=&n;
	
	for i in reverse 1..n
	loop
	   for j in 1..i
 	   loop	
	     dbms_output.put(j);	
	   end loop; 
        dbms_output.put_line(' ');	
	end loop;	
	 
end;	