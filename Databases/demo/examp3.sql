rem 
rem $Header: examp3.sql 21-sep-99.18:19:09 gviswana Exp $ 
rem 
Rem  Copyright (c) 1991, 1999 by Oracle Corporation 
Rem    NAME
Rem      examp3.sql - <one-line expansion of the name>
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem    RETURNS
Rem 
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem    MODIFIED   (MM/DD/YY)
Rem     gviswana   09/21/99  - Updates from Tom Portfolio                      
Rem     rvasired   05/12/92 -  Creation 
/*
** This block finds the first employee who has a salary over $2500
** and is higher in the chain of command than employee 7499.
**
** Copyright (c) 1989,1992, 1999 Oracle Corporation
*/

DECLARE
   salary         emp.sal%TYPE := 0;
   mgr_num        emp.mgr%TYPE;
   last_name      emp.ename%TYPE;
   starting_empno emp.empno%TYPE := 7499;
BEGIN
   SELECT mgr INTO mgr_num FROM emp 
      WHERE empno = starting_empno;
   WHILE salary <= 2500 LOOP
      SELECT sal, mgr, ename INTO salary, mgr_num, last_name
         FROM emp WHERE empno = mgr_num;
   END LOOP;
   INSERT INTO temp VALUES (NULL, salary, last_name);
   COMMIT;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      INSERT INTO temp VALUES (NULL, NULL, 'Not found');
      COMMIT;
END;
/
