create or replace trigger trig2
after insert
on orders 
for each row
begin
	DBMS_OUTPUT.put_line('After Insert Trigger Fired');
end;