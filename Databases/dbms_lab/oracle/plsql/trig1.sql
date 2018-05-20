create or replace trigger trig1
after insert on dept 
for each row
when(new.deptno > 40)
begin

	dbms_output.put_line('After Insert Trigger fired");
		
end;