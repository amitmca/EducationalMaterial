declare

cursor mycur is select count(snum) c from salespeople group by city;



	n number;

begin
	dbms_output.put_line(' ');

	dbms_output.put('OUTPUT');

	dbms_output.put_line(' ');

	open mycur;

	loop

	fetch mycur into n;

	exit when mycur%notfound;

	dbms_output.put_line(n);

	end loop;

	close mycur;

end;