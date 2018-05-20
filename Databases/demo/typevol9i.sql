Rem
Rem $Header: typevol9i.sql 30-apr-2001.18:20:55 rdani Exp $
Rem
Rem typevol9i.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      typevol9i.sql - Simple type evolution demo for 9i (9.0.1)
Rem
Rem    DESCRIPTION
Rem      This file contains simple examples for type evolution feature.
Rem
Rem    O Can be run in any schema. All objects created are destroyed
Rem      at the end of the demo.
Rem
Rem    NOTES
Rem    O The interaction between type evolution and type inheritance
Rem      is demonstrated to very minimal extent.  
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    rdani       04/30/01 - Merged rdani_demo9i
Rem    rdani       04/30/01 - Cleanup
Rem    rdani       04/27/01 - Created
Rem
/*
** ##############################################################
**
**                  DESCRIPTION OF DEMO EXAMPLE
**
** ##############################################################
** The following example demonstrates use of type evolution in PLSQL
** 9.0.1 (9i).
**
** Following are demonstrated
**
**  ADDING METHODS
**  DROPPING METHODS
**  ADDING ATTRIBUTES
**  MODIFYING ATTRIBUTES
**
** ##############################################################
**
**                OBJECT TYPES AND THEIR RELATIONSHIP 
**
** ##############################################################
**
**                o_employee 
** 
*/

/*
** ##############################################################
**
**                       CODING STYLE USED 
**
** ##############################################################
**
**      1. Uppercase is used for PL/SQL keywords and lower case for user 
**         defined items.
**      2. Naming convention followed for user defined types:
**         Data Structure Name       Prefixed With
**         ---------------------------------------------
**         Object Type names           o_ 
**         Varray Names                v_ 
**         Nested Table Types          n_ 
**         Object Tables               ot_
**         Relational Tables           rt_
**         Nested Table                nt_ 
**         Local Variables             l_
*/

SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 80
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO ON
SET SERVEROUTPUT ON

/*
** -----------------------------------------------------------------------
**     DROP EVERYTHING FIRST
*/

DROP PROCEDURE PrtAllEmp;
DROP TABLE ot_employees;
DROP TYPE o_employee;

/*
** -----------------------------------------------------------------------
**   Create an employee type.
**   The employee type is final, which means you can not create subtypes
**   from it.
**   The attributes are,
**     l_empname    Name of the employee. We assume it is stored as first
**                  name, middle name if any followed by last name with
**                  each name separated by a period.
**     l_gender     Gender of the employee.
**     l_salary     Salary of the employee.
**     l_jobid      Job identification number for employee's job/position.
**     l_zipcode    Zip code for employee's home address.
**     l_startdate  Hire date for employee.
**     l_empid      Employee's identification number.
** -----------------------------------------------------------------------
*/

CREATE OR REPLACE TYPE o_employee AS OBJECT
(
  l_empname   VARCHAR2(80),
  l_gender    VARCHAR2(6),
  l_salary    NUMBER(8,2),
  l_jobid     NUMBER(3),
  l_zipcode   VARCHAR2(5),
  l_startdate DATE,
  l_empid     NUMBER(5,0)
);
/
show errors

Rem ----- Describe the type.

DESCRIBE o_employee;

/*
** -----------------------------------------------------------------------
**   Create a table of employees and polpulate it with some data.
** -----------------------------------------------------------------------
*/

CREATE TABLE ot_employees OF o_employee;

INSERT INTO ot_employees VALUES (o_employee
                                  ('Mary.Ann.Gumb',
                                   'FEMALE',
                                    55000.00,
                                    005,
                                   '93015',
                                   '01-FEB-96',
                                    00001
                                  )
                                 );

INSERT INTO ot_employees VALUES (o_employee
                                  ('John.Ford',
                                   'MALE',
                                    45000.00,
                                    005,
                                   '93024',
                                   '01-FEB-96',
                                    00002
                                  )
                                 );

INSERT INTO ot_employees VALUES (o_employee
                                  ('Lany.Fiddler',
                                   'FEMALE',
                                    65000.00,
                                    003,
                                   '93027',
                                   '03-FEB-96',
                                    00003
                                  )
                                 );

Rem  ----- View the table entries.

SELECT * FROM ot_employees;

/*
** -----------------------------------------------------------------------
**   Try to compare two employees to see if they are the same. As there
**   is no MAP method defined for the type to compare the instances of
**   the type, this PLSQL block will FAIL with errors. PLS-00526
** -----------------------------------------------------------------------
*/ 

Rem  ----- Should FAIL with errors.

DECLARE
  l_maryann o_employee := o_employee
                                 ('Mary.Ann.Gumb',
                               	  'FEMALE',
                                   55000.00,
                                   005,
                                  '93015',
                                  '01-FEB-96',
                                   00001
                                 );

  l_johnford o_employee := o_employee
                                  ('John.Ford',
                                   'MALE',
                                    45000.00,
                                    005,
                                   '93024',
                                   '01-FEB-96',
                                    00002
                                  );
BEGIN

  IF (l_johnford = l_maryann)
  THEN
    DBMS_OUTPUT.PUT_LINE('Matched');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Unmatched');
  END IF;

END;
/
show errors

/*
** -----------------------------------------------------------------------
**                     ADDING A METHOD TO THE TYPE
**   Alter the type to add a map method and retry the anonymous block.
**   The MAP method will return the l_empid of the employee.
** -----------------------------------------------------------------------
*/

ALTER TYPE o_employee ADD
 MAP MEMBER FUNCTION l_mapempid RETURN NUMBER
CASCADE;

show errors

CREATE OR REPLACE TYPE BODY o_employee IS

 MAP MEMBER FUNCTION l_mapempid RETURN NUMBER IS
 BEGIN
  RETURN (self.l_empid);
 END l_mapempid;

END;
/
show errors

Rem  ----- Now retry the same block. Prints Unmatched.

DECLARE
  l_maryann o_employee := o_employee
                                 ('Mary.Ann.Gumb',
                               	  'FEMALE',
                                   55000.00,
                                   005,
                                  '93015',
                                  '01-FEB-96',
                                   00001
                                 );

  l_johnford o_employee := o_employee
                                  ('John.Ford',
                                   'MALE',
                                    45000.00,
                                    005,
                                   '93024',
                                   '01-FEB-96',
                                    00002
                                  );
BEGIN

  IF (l_johnford = l_maryann)
  THEN
    DBMS_OUTPUT.PUT_LINE('Matched');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Unmatched');
  END IF;

END;
/
show errors

/*
** -----------------------------------------------------------------------
**           ADD A METHOD TO PRINT SOME EMPLOYEE DATA
**
**   l_PrtSomeId  Member procedure to print name and emlpoyee id.
** -----------------------------------------------------------------------
*/

ALTER TYPE o_employee
ADD
  MEMBER PROCEDURE l_PrtSomeId
CASCADE;
show errors

DESCRIBE o_employee;

CREATE OR REPLACE TYPE BODY o_employee IS

 MAP MEMBER FUNCTION l_mapempid RETURN NUMBER IS
 BEGIN
  RETURN (self.l_empid);
 END l_mapempid;

 MEMBER PROCEDURE l_PrtSomeId IS
 BEGIN
   DBMS_OUTPUT.PUT_LINE(self.l_empname);
   DBMS_OUTPUT.PUT_LINE(self.l_empid);
 END l_PrtSomeId;

END;
/
show errors

/*
** -----------------------------------------------------------------------
**           CREATE PLSQL PROCEDURES THAT DEPEND ON THE TYPE
**
**    Procedure PrtAllEmp
**       This procedure prints out data for all employees in the
**       ot_employees table.
**       Inputs:
**          None
**       Calls:
**          l_PrtSomeId method of the o_employee type
** -----------------------------------------------------------------------
*/

CREATE OR REPLACE PROCEDURE PrtAllEmp IS

  l_anemp ot_employees%ROWTYPE;

  CURSOR l_empcur IS
   SELECT VALUE(ot_employees_alias)
   FROM   ot_employees ot_employees_alias;

BEGIN
  OPEN l_empcur;
  FETCH l_empcur INTO l_anemp;

  WHILE l_empcur%FOUND
  LOOP
    l_anemp.l_PrtSomeId;
    FETCH l_empcur INTO l_anemp;
  END LOOP;
END PrtAllEmp;
/
show errors

EXECUTE PrtAllEmp;

/*
** -----------------------------------------------------------------------
**           ALTER O_EMPLOYEE TO ADD MANAGER's EMPLOYEE ID
**
**    To link the emlpoyee to his/her manager we will add an attribute to
**    the o_employee type.
**    Added attribute
**      l_managerid  Employee id for the employee's manager.
** -----------------------------------------------------------------------
*/

ALTER TYPE o_employee
ADD ATTRIBUTE
(
  l_managerid NUMBER(5,0)
)
CASCADE;
show errors

Rem  ----- Display dependencies on type o_employee

SELECT name, type, dependency_type
FROM   user_dependencies
WHERE  referenced_type='TYPE' AND referenced_name='O_EMPLOYEE';

Rem  ----- Display status of dependent objects after alter type
Rem  ----- PLSQL procedures are invalidated.

SELECT object_name, object_type, status
FROM   user_objects
WHERE  object_name
IN     (SELECT name
        FROM   user_dependencies
        WHERE  referenced_type='TYPE' AND referenced_name='O_EMPLOYEE');

Rem  ----- Describe the ot_employees table

DESCRIBE ot_employees;

Rem  ----- Update the ot_employees table to make Lany manager for John
Rem  ----- and Mary.

UPDATE ot_employees ot_employees_alias
SET    ot_employees_alias.l_managerid = 00003
WHERE  ot_employees_alias.l_empid <> 00003;

SELECT * FROM ot_employees;

/*
** -----------------------------------------------------------------------
**        DROP PrtSomeId METHOD AND ADD NEW ONE TO PRINT MANAGER ID
** -----------------------------------------------------------------------
*/


ALTER TYPE o_employee
DROP
  MEMBER PROCEDURE l_PrtSomeId
CASCADE;

show errors

ALTER TYPE o_employee
ADD
  MEMBER PROCEDURE l_PrtSomeId
CASCADE;

show errors

CREATE OR REPLACE TYPE BODY o_employee IS

 MAP MEMBER FUNCTION l_mapempid RETURN NUMBER IS
 BEGIN
  RETURN (self.l_empid);
 END l_mapempid;

 MEMBER PROCEDURE l_PrtSomeId IS
 BEGIN
   DBMS_OUTPUT.PUT_LINE(self.l_empname);
   DBMS_OUTPUT.PUT_LINE(self.l_empid);
   DBMS_OUTPUT.PUT_LINE('Manager Id');
   DBMS_OUTPUT.PUT_LINE(NVL(self.l_managerid, -1));
 END l_PrtSomeId;

END;
/
show errors

EXECUTE PrtAllEmp;

/*
** -----------------------------------------------------------------------
**     TRY USING 9 DIGIT ZIPCODE SHOULD FAIL
** -----------------------------------------------------------------------
*/

UPDATE ot_employees ot_employees_alias
SET    ot_employees_alias.l_zipcode = '93024-4365'
WHERE  ot_employees_alias.l_empid = 00002;

/*
** -----------------------------------------------------------------------
**        MODIFY THE ZIPCODE TO USE 9 DIGITS
** -----------------------------------------------------------------------
*/

ALTER TYPE o_employee
MODIFY ATTRIBUTE
(
  l_zipcode VARCHAR2(10)
)
CASCADE NOT INCLUDING TABLE DATA;

Rem  ----- Describe the ot_employees table

DESCRIBE ot_employees;

SELECT * FROM ot_employees;

/*
** -----------------------------------------------------------------------
**     VERIFY THAT 9 DIGIT ZIPCODE IS USABLE NOW
** -----------------------------------------------------------------------
*/

UPDATE ot_employees ot_employees_alias
SET    ot_employees_alias.l_zipcode = '93024-4365'
WHERE  ot_employees_alias.l_empid = 00002;

SELECT * FROM ot_employees;

/*
** -----------------------------------------------------------------------
**     DROP l_salary ATTRIBUTE
** -----------------------------------------------------------------------
*/

ALTER TYPE o_employee
DROP ATTRIBUTE
(
  l_salary
)
CASCADE;
show errors

SELECT * FROM ot_employees;

DROP PROCEDURE PrtAllEmp;
DROP TABLE ot_employees;
DROP TYPE o_employee;

/*
** -----------------------------------------------------------------------
**     END DEMO
** -----------------------------------------------------------------------
*/
