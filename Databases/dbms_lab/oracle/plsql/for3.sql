declare
	n number;
	i number;
	j number;
	k number;	

	begin

	n:=&n;
	k:=0;
	
	for i in 1 .. n 

  	  loop
		
	    for j in 1 .. i	
	   	
	     loop
	
		dbms_output.put(j+k);
		
	     end loop;
	
	  k:=k+1;	
	
	  dbms_output.put_line(' ');	
  	
	  end loop;	
	
	end;