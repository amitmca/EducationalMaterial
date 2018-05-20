declare
	str varchar2(20);
	revstr varchar2(20);
	l number;	
	
	begin

	str:='&str';
	l:=length(str);

	for i in reverse 1 .. l 

  	  loop
		revstr:=revstr || substr(str,i,1);
	    
	  end loop;	

	 dbms_output.put_line(revstr);	
	
	end;