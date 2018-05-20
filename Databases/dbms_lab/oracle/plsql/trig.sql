create or replace trigger trig1 
before insert on dept
declare
	x number(10);
begin
	dbms_output.put_line('Before Insert Trigger fired');
end;
