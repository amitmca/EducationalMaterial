Rem
Rem $Header: tab_func.sql 15-may-2001.19:09:43 rchennoj Exp $
Rem
Rem tab_func.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      tab_func.sql - This is a simple demo for table functions.
Rem                          The script will work with scott/tiger
Rem
Rem    DESCRIPTION
Rem      A very simple demostration of table functions
Rem
Rem    NOTES
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    rchennoj    05/15/01 - Merged rchennoj_shiphome_driver_fix_main
Rem    rchennoj    05/15/01 - 
Rem    sagrawal    04/27/01 - Merged sagrawal_tfdemo
Rem    sagrawal    04/27/01 - Table Function Demo
Rem    sagrawal    04/27/01 - Created
Rem


create or replace type NUMSTRUCT as object (val number);
/

create or replace type NUMARRAY as table of NUMSTRUCT;
/

create or replace package ROW_CURSOR_PKG as
  type EMP_REC is record (empno number, ename varchar2(20));
  type EMP_REC_CUR is ref cursor return EMP_REC;
end;
/

create or replace function ROWSOURCE2(R in ROW_CURSOR_PKG.EMP_REC_CUR)
return NUMARRAY
       parallel_enable(partition R by hash(EMPNO))
       pipelined is
  REC ROW_CURSOR_PKG.EMP_REC;
begin
  loop
    fetch R into REC;
    exit when R%notfound;
    pipe row(NUMSTRUCT(REC.empno));
  end loop;
  return;
end ROWSOURCE2;
/


select * from table(rowsource2(cursor(select empno, ename from emp)));

