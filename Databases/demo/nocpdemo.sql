Rem
Rem
Rem Copyright (c) 1998, 1999 By Oracle Corporation
Rem
Rem NAME
Rem   nocpdemo.sql - Demo program for the NOCOPY modifier to the IN OUT and
Rem   OUT parameter modes in PL/SQL 8.1.
Rem
Rem   Also demonstrates the performance improvement achieved with use of the
Rem   NOCOPY modifier.
Rem
Rem FUNCTION
Rem
Rem    This Demo program illustrates the use of the NOCOPY modifier by
Rem    passing following data structures as parameters
Rem               a) Nested table  and
Rem               b) Record
Rem
Rem    Releases of PL/SQL before 8.1 provided three parameter passing
Rem    modes namely : IN, OUT and IN OUT. PL/SQL passes IN parameter by 
Rem    reference, IN OUT parameters by copy-in & copy-out mechanism and
Rem    OUT parameters by copy-out mechanism. 
Rem
Rem    The copy-in (for IN OUT) and copy-out (for IN OUT & OUT) imposes
Rem    significant CPU and memory overhead particularly when the parameters
Rem    involved are large data structures like nested tables, varrays,
Rem    records etc.
Rem
Rem    The NOCOPY feature allows you to pass parameters to a procedure or
Rem    function by reference avoiding CPU and memory overheads.
Rem
Rem    The following tables illustrate the performance improvement acheived by
Rem    by using the NOCOPY modifier, for this demo:
Rem
Rem    Note:
Rem    These figures are representative of the gains that might be had by
Rem    using the NOCOPY mechanism. Actual timings may vary depending on the
Rem    machine type and load etc.
Rem 
Rem   ---------------------------------------------------------------------
Rem   |  Parameter Passed ----> Nested table (Employee nested Table)      |
Rem   |                           ( Time Taken In Seconds )               |
Rem   ---------------------------------------------------------------------
Rem   | Task                WITHOUT NOCOPY         WITH NOCOPY            |
Rem   |                     ( Seconds )            ( Seconds )            |
Rem   ---------------------------------------------------------------------
Rem   |  Incrementing            13                     1                 |
Rem   |  Salary                                                           |
Rem   ---------------------------------------------------------------------
Rem
Rem
Rem   ---------------------------------------------------------------------
Rem   |  Parameter Passed ----> User Defined Record (All Departments Rec) |
Rem   |                          ( Time Taken In Seconds )                |
Rem   ---------------------------------------------------------------------
Rem   | Task                WITHOUT NOCOPY         WITH NOCOPY            |
Rem   |                     ( Seconds )            ( Seconds )            |
Rem   ---------------------------------------------------------------------
Rem   |  Changing location        8                     0                 |
Rem   |  of department                                                    |
Rem   ---------------------------------------------------------------------
Rem
Rem
Rem
Rem NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem   1) Use  svrmgrl for running this demo program
Rem  
Rem   2) Connect as SCOTT/TIGER and run nocpdemo.sql
Rem
Rem      CONNECT SCOTT/TIGER
Rem      @nocpdemo.sql
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem       rchennoi 08/18/99 -
Rem    ukulkarn.in 07/07/98 - Created
Rem

/*
** ##########################################################################
**
**           DESCRIPTION  OF  DEMO  EXAMPLE 
** ##########################################################################
**
** The following examples demonstrates use of the NOCOPY modifier to the IN OUT
** and OUT parameter modes in PL/SQL 8.1.
**
** 1)Procedure increment_salary_withnocopy (nested table parameter)
**   demonstrates use of NOCOPY feature when large collection is passed as 
**   a parameter. The procedure increments the Salary for all employees in 
**   an organization by "X" percent.
**
** 2)Procedure change_deptloc_withnocopy (record parameter) demonstrates use 
**   of NOCOPY feature when large PL/SQL User Defined record is passed as a 
**   parameter. The procedure changes the location of given department with 
**   the given new address. The parameters to this procedure are the list of
**   all departments encapsulated in a record, the index of the department 
**   whose address need to be changed and new address.
**
** To demonstrate the performance improvement achieved by using the NOCOPY
** modifer, we define two additional procedures:
**   increment_salary_withoutnocopy and
**   change_deptloc_withoutnocopy
** These procedures are identical to their _withnocopy counterparts except
** that they do not use the NOCOPY modifer.
**
** In this example, Employee Object Type has the following attributes.
**
**                 a)Name
**                 b)Employee_Id
**                 c)Address
**                 d)Gender
**                 e)Marital_Status
**                 f)Date_of_Joining
**                 g)Grade
**                 h)Dept
**                 i)and Salary
**
** For storing records of all the employees in an organization, a nested 
** table of Employee object type is created.
**
** The all Departments Record have following attributes.
**
** a) all_deptnos  - varray of varchar2(10) - Store dept numbers of all depts
** b) all_deptlocs - varray of varchar2(100)- Store dept locations of all depts
** c) dept_mgrs    - varray of varchar2(20) - Store emp nos of managers for all
**                                            depts
** d) total_strength - Total Strength of the Organization
** e) total_budget   - Total financial budget for the Organization
**
**
*/

/*
** ########################################################################
**
**                 CODING STYLE USED                                     
**
** ########################################################################
**
**     1. Uppercase is used for keywords and lower case for defined items.
**
**     2. Naming convention followed for user defined types :
**    ------------------------------------------------------------------
**    Data Structure Name                  Prefixed with
**    ------------------------------------------------------------------
**      Object Type names                     ot_
**      Nested Table Types names              nt_
**      Varray Type names                     vt_
**      Record Type names                     rt_
**      Varray                                v_
**      Record                                r_
**      Local variables                       l_
**
*/

CONNECT SCOTT/TIGER;

SET ECHO OFF;
SET SERVEROUTPUT ON

SPOOL dm027.dbg

/*-------------------------------------------------------------------*/
/*  Creating Employee Object Type with required attributes.          */
/*-------------------------------------------------------------------*/

CREATE OR REPLACE TYPE ot_employee AS OBJECT
(
  Name                 VARCHAR2(100),
  Employee_Id          VARCHAR2(20),
  Address              VARCHAR2(200),
  Gender               CHAR(1),
  Marital_Status       CHAR(1),
  Date_Of_Joining      DATE,
  Grade                VARCHAR2(2),
  Dept                 VARCHAR2(10),
  Salary               NUMBER(10,2)
);
/
SHOW ERRORS

/*--------------------------------------------------------------------*/
/*   Creating a  nested table type of Employee Object Type            */
/*--------------------------------------------------------------------*/

CREATE OR REPLACE TYPE nt_all_employees AS TABLE OF ot_employee;
/
SHOW ERRORS

/*----------------------------------------------------------------------*/
/* Creating Type Definition To Store All Department Numbers             */  
/*----------------------------------------------------------------------*/

CREATE OR REPLACE  TYPE vt_deptnos IS VARRAY(7000) OF VARCHAR2(10); 
/
SHOW ERRORS

/*----------------------------------------------------------------------*/
/* Creating Type Definition To Store All Department Locations           */  
/*----------------------------------------------------------------------*/

CREATE OR REPLACE  TYPE vt_deptlocs IS VARRAY(7000) OF VARCHAR2(100);
/
SHOW ERRORS

/*----------------------------------------------------------------------*/
/* Creating Type Definition To Store Manager's Emp Ids for all Depts    */  
/*----------------------------------------------------------------------*/

CREATE OR REPLACE  TYPE vt_deptmgrs IS VARRAY(7000) OF VARCHAR2(20);
/
SHOW ERRORS

/*-------------------------------------------------------------------------*/
/*  Declaring a package specification where procedures for incrementing    */
/*  salary and changing department locations resides.                      */
/*-------------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE emp_dept_pack AS

  /* -----Type Definition of all Departments Record ---------------*/  
  TYPE rt_alldepts IS RECORD
  (
    all_deptnos  vt_deptnos,
    all_deptlocs vt_deptlocs,
    dept_mgrs    vt_deptmgrs,
    total_strength  NUMBER(6),
    total_budget   NUMBER(12,2)
  );

  PROCEDURE increment_salary_withoutnocopy(emp_tab IN OUT nt_all_employees,
                                           pcnt    IN     NUMBER);

  PROCEDURE increment_salary_withnocopy(emp_tab IN OUT NOCOPY nt_all_employees,
                                        pcnt    IN            NUMBER);

  PROCEDURE change_deptloc_withoutnocopy(all_depts IN OUT rt_alldepts,
                                         dept_cnt  IN     NUMBER,
                                         new_loc   IN     VARCHAR2);

  PROCEDURE change_deptloc_withnocopy(all_depts IN OUT NOCOPY rt_alldepts,
                                      dept_cnt  IN            NUMBER,
                                      new_loc   IN            VARCHAR2);
  PROCEDURE print_preamble;

  PROCEDURE print_results(str1 IN VARCHAR2, str2 IN VARCHAR2,
                          nocopy_start_time IN NUMBER,
                          nocopy_end_time IN NUMBER,
                          copy_start_time IN NUMBER,
                          copy_end_time IN NUMBER);
END emp_dept_pack;
/
SHOW ERRORS

/*---------------------------------------------------------------------------*/
/* Define body of package.                                                   */
/*                                                                           */
/* Procedures increment_salary_withoutnocopy and increment_salary_withnocopy */
/* take a nested table of employee objects and the percentage by which the   */
/* salary is to be incremented as parameter.                                 */
/* Procedure increment_salary_withnocopy makes use of the NOCOPY modifier    */
/* whereas increment_salary_withoutnocopy makes use of the IN OUT mode.      */
/* Both procedures increment the salary of all employees by "X" percent.     */
/*                                                                           */
/* Procedures change_deptloc_withoutnocopy and change_deptloc_withnocopy     */
/* take a list of all departments encapsulated in a record & a new address   */
/* as parameter.                                                             */
/* Procedure change_deptloc_withnocopy makes use of the NOCOPY modifier      */
/* whereas change_deptloc_withoutnocopy makes use of the IN OUT mode.        */
/* Both above procedures changes the location of department with the new     */
/* address passed as parameter.                                              */
/*---------------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE BODY emp_dept_pack AS

  /* Procedure to increment salary of all employess by "X" percent */

  /* Without NOCOPY modifier, using IN OUT mode of passing parameters */
  PROCEDURE increment_salary_withoutnocopy(emp_tab IN OUT nt_all_employees,
                                           pcnt    IN     NUMBER)
  IS
    l_no_of_employees  INTEGER;
  BEGIN
    -- Get total number of employees
    l_no_of_employees := emp_tab.COUNT;

    -- For each employee increase salary by "pcnt" percent 
    FOR i IN 1..l_no_of_employees
    LOOP
      emp_tab(i).Salary := emp_tab(i).salary * (1 + pcnt/100) ;
    END LOOP;

  END increment_salary_withoutnocopy;

  /* With NOCOPY modifier to IN OUT mode of passing parameters */
  PROCEDURE increment_salary_withnocopy(emp_tab IN OUT NOCOPY nt_all_employees,
                                        pcnt    IN            NUMBER)
  IS
    l_no_of_employees  INTEGER;
  BEGIN
    -- Get total number of employees
    l_no_of_employees := emp_tab.COUNT;

    -- For each employee increase salary by "pcnt" percent 
    FOR i IN 1..l_no_of_employees
    LOOP
      emp_tab(i).Salary := emp_tab(i).salary * (1 + pcnt/100) ;
    END LOOP;

  END increment_salary_withnocopy;

  /* Procedure to change the department location */

  /* Without NOCOPY modifier, using IN OUT mode of passing parameters */
  PROCEDURE change_deptloc_withoutnocopy(all_depts IN OUT rt_alldepts,
                                         dept_cnt  IN     NUMBER,
                                         new_loc   IN     VARCHAR2)
  IS
  BEGIN
     all_depts.all_deptlocs(dept_cnt) := new_loc;
  END change_deptloc_withoutnocopy;


  /* With NOCOPY modifier to IN OUT mode of passing parameters */
  PROCEDURE change_deptloc_withnocopy(all_depts IN OUT NOCOPY rt_alldepts,
                                      dept_cnt  IN            NUMBER,
                                      new_loc   IN            VARCHAR2)
  IS
  BEGIN
     all_depts.all_deptlocs(dept_cnt) := new_loc;
  END change_deptloc_withnocopy;


  PROCEDURE print_preamble IS
  BEGIN
    /* Display The Call Duration Statistics */
    DBMS_OUTPUT.PUT(' ** Performance improvement with NOCOPY');
    DBMS_OUTPUT.NEW_LINE;
    DBMS_OUTPUT.NEW_LINE;
  
    DBMS_OUTPUT.PUT(' ** Note : Following Figures are representative of ');
    DBMS_OUTPUT.PUT_LINE('the expected gains. ');
    DBMS_OUTPUT.PUT(' ** Actual timings can vary depending on machine ');
    DBMS_OUTPUT.PUT_LINE('type, load etc');
    DBMS_OUTPUT.NEW_LINE;
  END print_preamble;


  PROCEDURE print_results(str1 IN VARCHAR2, str2 IN VARCHAR2,
                          nocopy_start_time IN NUMBER, 
                          nocopy_end_time IN NUMBER, 
                          copy_start_time IN NUMBER,
                          copy_end_time IN NUMBER) IS
  BEGIN
    DBMS_OUTPUT.PUT(' ** Parameter Passed --> ');
    DBMS_OUTPUT.PUT_LINE(str1);
    DBMS_OUTPUT.PUT_LINE(' ** (All Units in Seconds ) ');
    DBMS_OUTPUT.NEW_LINE;
    DBMS_OUTPUT.PUT('---------------------------------------------------');
    DBMS_OUTPUT.PUT('----------------');
    DBMS_OUTPUT.NEW_LINE;
    DBMS_OUTPUT.PUT_LINE('   Task                  WITHOUT NOCOPY   ' ||
                         '       WITH NOCOPY  ');
    DBMS_OUTPUT.PUT('---------------------------------------------------');
    DBMS_OUTPUT.PUT('----------------');
    DBMS_OUTPUT.NEW_LINE;
    DBMS_OUTPUT.PUT_LINE(str2 ||
                         TO_CHAR(copy_end_time - copy_start_time)        || 
                         '                           ' ||
                         TO_CHAR(nocopy_end_time - nocopy_start_time)
                        );
    DBMS_OUTPUT.PUT('---------------------------------------------------');
    DBMS_OUTPUT.PUT('----------------');
    DBMS_OUTPUT.NEW_LINE;
  END print_results;

END emp_dept_pack;
/
SHOW ERRORS

SPOOL OFF;
SET ECHO OFF

SET SERVEROUTPUT ON 
SPOOL dm027.lis

/*-------------------------- Execution Begins Here --------------------------*/
DECLARE

  /* store personal details of employee */
  l_all_emp_recs nt_all_employees :=
      nt_all_employees(ot_Employee('James','E001',
                                   'Santhom St Redwood Shores California',
                                   'M','S','01-JAN-1997','A1','DP01', 3500.00));

  /* Variables to store time before and after procedure call */
  nocopy_start_time  NUMBER;
  nocopy_end_time    NUMBER;
  copy_start_time    NUMBER;
  copy_end_time      NUMBER;

  l_r_all_depts    emp_dept_pack.rt_alldepts;

BEGIN

  /* Populate the employee nested table with 7000 records */
  l_all_emp_recs.EXTEND(6999,1);

  /* Populate the all departments record */
  l_r_all_depts.all_deptnos.EXTEND;
  l_r_all_depts.all_deptlocs.EXTEND;
  l_r_all_depts.dept_mgrs.EXTEND;

  l_r_all_depts.all_deptnos(1)  := 'DP01';
  l_r_all_depts.all_deptlocs(1) := 'Washington';
  l_r_all_depts.dept_mgrs(1)    := 'E006';
  l_r_all_depts.total_strength  := 27000;
  l_r_all_depts.total_budget    := 5000000;

  /* Populate deptnos, deptlocs and dept_mgrs with 7000 elements */
  l_r_all_depts.all_deptnos.EXTEND(6999,1);
  l_r_all_depts.all_deptlocs.EXTEND(6999,1);
  l_r_all_depts.dept_mgrs.EXTEND(6999,1);


  /* Time increment_salary_withnocopy */
  DBMS_OUTPUT.NEW_LINE;
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO nocopy_start_time FROM DUAL;
  emp_dept_pack.increment_salary_withnocopy(l_all_emp_recs, 20);
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO nocopy_end_time FROM DUAL;

  /* Time increment_salary_withoutnocopy */
  DBMS_OUTPUT.NEW_LINE();
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO copy_start_time FROM DUAL;
  emp_dept_pack.increment_salary_withoutnocopy(l_all_emp_recs, 20);
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO copy_end_time FROM DUAL;

  emp_dept_pack.print_preamble;
  emp_dept_pack.print_results(' Collection (Nested table)',
                              ' Incrementing Salary      ',
                              nocopy_start_time, nocopy_end_time,
                              copy_start_time, copy_end_time);


  /* Time change_deptloc_withnocopy */
  DBMS_OUTPUT.NEW_LINE;
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO nocopy_start_time FROM DUAL; 
  emp_dept_pack.change_deptloc_withnocopy(l_r_all_depts, 1, 'New York');
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO nocopy_end_time FROM DUAL;

  /* Time change_deptloc_withoutnocopy */
  DBMS_OUTPUT.NEW_LINE;
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO copy_start_time FROM DUAL;
  emp_dept_pack.change_deptloc_withoutnocopy(l_r_all_depts, 1, 'Chicago');
  SELECT TO_CHAR(SYSDATE, 'SSSSS') INTO copy_end_time FROM DUAL;
  DBMS_OUTPUT.NEW_LINE;

  emp_dept_pack.print_results(' User Defined Record Type',
                              ' Changing location of dept  ',
                              nocopy_start_time, nocopy_end_time,
                              copy_start_time, copy_end_time);

END;
/
SPOOL OFF;

DROP TYPE nt_all_employees;
DROP TYPE ot_employee;
DROP TYPE vt_deptlocs;
DROP TYPE vt_deptmgrs;
DROP TYPE vt_deptnos;
DROP PACKAGE emp_dept_pack;
/

