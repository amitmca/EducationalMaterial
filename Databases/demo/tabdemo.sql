Rem 
Rem Copyright (c) 1998, 1999 By Oracle Corporation
Rem
Rem NAME
Rem   tabdemo.sql  - Demo Program For Table Operator 
Rem
Rem The demo program does the following tasks :
Rem
Rem  1) Shows unnesting of nested tables using TABLE operator.
Rem
Rem  2) Shows converting a local PL/SQL collection variable into a relational
Rem     table using TABLE operator.
Rem
Rem
Rem  FUNCTION
Rem
Rem    The demo program illustrates the use of TABLE operator for unnesting 
Rem    collections  as well as converting a local PL/SQL collection variable
Rem    into a relational table.
Rem
Rem    Unnesting here refers to iterating over all collection values of 
Rem    collection column of a table.
Rem    In Pre 8.1, unnesting can be done using local PL/SQL variables and 
Rem    cursors but this process is quite cumbersome.
Rem
Rem    TABLE operator in RDBMS 8.1 allows us to unnest collection columns 
Rem    easily as well as convert local PL/SQL collection variables into 
Rem    relational tables.
Rem
Rem NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem   1) Use svrmgrl for running this demo program
Rem
Rem   2) Connect as SCOTT/TIGER and run tabdemo.sql
Rem     
Rem       CONNECT SCOTT/TIGER
Rem       @tabdemo.sql
Rem
Rem
Rem  MODIFIED
Rem     rchennoi    08/18/99 -
Rem     jmuller     05/28/99 - Fix bug 708690: TAB -> blank
Rem     nmantrav    05/05/99 - fix hang.
Rem     gviswana    09/30/98 - Add to demo directory
Rem     ukulkarn.in 08/27/98 - Creation

/*
** ##########################################################################
**
**         DESCRIPTION  OF  DEMO  EXAMPLE
**
** ##########################################################################
** 
** In the Demo example, there is one module namely proj_emp_track module.
**
** This module keeps track of the following information for all departments in
** an organization.
**
**   1) Current projects being executed.
**   2) Details of current employees.
**   3) Which employee is working on which project
**
** Frequently there is a need to query the above information to form different
** reports required by the Middle and Top Management.
** 
** The module proj_emp_track module gives functionality to answer queries of
** above mentioned type and prepare different reports.
**
** In this demo example, the table dept_info (Described in details in following
** sections) has two columns namely
**   a) Projects :- For storing projects related information
**   b) Employee :- For Storing Employees related information
**
** These two columns are of collection(table) type and hence dept_info table
** becomes a nested table.
**
** Frequently asked queries/reports, For Example
**  'List all projects currently handled by all departments '
** require to iterate over all collection values of collection column(s).
**
** Using TABLE operator this can be done very easily as demonstrated in
** the demo example.
**
** 1) Each project information is captured as an object 'project' with 
**    following attributes :
**  
**         a) Project_Id      VARCHAR2(10)  # Project Id #
**         b) Project_name    VARCHAR2(20)  # Name       #
**         c) Budget          NUMBER(10,2)  # Budget     #
**
** 2) Each employee currently works on a single project and no employee can 
**    work on two different projects at the same time.
**
** 3) Each Employee information is captured as an object 'employee' with the
**    following attributes :
**
**        a) Employee_Id     VARCHAR2(10)   # Employee Id #
**        b) Employee_Name   VARCHAR2(30)   # Name        #
**        c) Current_Project_id VARCHAR2(10) # Current project on which 
**
** 4) To record all projects currently being carried out in the organization
**    a nested table type of 'project' object is created.
**
**       Create Type nt_project as table of project;
**
** 5) To record employee information for all employees in the organization
**    a nested table type of 'employee' is created.
**
** 6) To record department wise information which includes current projects
**    carried in the department and the employees working on those projects,
**    a table dept_info is created.
**  
**      Create Table Dept_info (
**              Dept_no   VARCHAR2(10),
**              Dept_Name VARCHAR2(20),
**              Dept_Location VARCHAR2(20),
**              Projects  nt_project,
**              Employees nt_employee ) Nested table Projects Store as p_j,
**              Nested Table Employees Store as e_j;
**
*/

/*
** #########################################################################
**
**           CODING  STYLE USED
**
** ##########################################################################
**
**    1.Uppercase is used for PL/SQL keywords and lower case for defined items.
**
**    2. Naming convention followed for user defined types :
**   ------------------------------------------------------------------
**    Data Structure Name                        Prefixed with
**   -----------------------------------------------------------------
**    Nested Table Types                          nt_
**    Object Types                                ot_
**    Local Variables                             l_
**    Reference Cursor                            rc_
**
*/

CONNECT SCOTT/TIGER;

SET ECHO  ON;
SET SERVEROUTPUT ON;
SPOOL dm028.dbg

/* -------------------------------------------------------------------- */
/* Define Object Type for storing project related information           */
/* -------------------------------------------------------------------- */


CREATE TYPE ot_project AS OBJECT
      ( Project_Id   VARCHAR2(10),
        Project_Name VARCHAR2(20),
        Budget       NUMBER(10,2) );
/
SHOW ERRORS


/* -------------------------------------------------------------------- */
/* Define Object Type for storing employee related information          */
/* -------------------------------------------------------------------- */

CREATE TYPE ot_employee AS OBJECT
     ( Emp_id      VARCHAR2(10),
       Emp_name    VARCHAR2(40),
       Current_Proj_Id VARCHAR2(10),
       Sal       NUMBER(8,2) )
/
SHOW ERRORS

/* -------------------------------------------------------------------- */
/* Define Nested Table Type of ot_project object type                   */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_project AS TABLE OF ot_project;
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type of ot_employee object type                  */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_employee AS TABLE OF ot_employee;
/

/* -------------------------------------------------------------------- */
/* Define Object Type for Storing Project Name and Employee Name        */ 
/* -------------------------------------------------------------------- */

CREATE TYPE ot_proj_emp AS OBJECT
      (  proj_name   VARCHAR2(20),
         emp_name    VARCHAR2(40) );
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type of ot_proj_emp object type                  */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_projemp AS TABLE OF ot_proj_emp;
/

/* -------------------------------------------------------------------- */
/* Table for storing Department related information                     */
/* -------------------------------------------------------------------- */

CREATE TABLE dept_info(
    dept_no    VARCHAR2(10),
    dept_name  VARCHAR2(50),
    projects   nt_project,
    dept_loc   VARCHAR2(30),
    employees  nt_employee)
    NESTED TABLE projects STORE AS p_j,
    NESTED TABLE employees STORE AS e_m;
/
SHOW ERRORS

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_chr50 AS TABLE OF VARCHAR2(50);
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_chr20 AS TABLE OF VARCHAR2(20);
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_chr10 AS TABLE OF VARCHAR2(10);
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_num102 AS TABLE OF NUMBER(10,2);
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_chr40 AS TABLE OF VARCHAR2(40);
/

/* -------------------------------------------------------------------- */
/* Define Nested Table Type for local processing                       */
/* -------------------------------------------------------------------- */

CREATE TYPE nt_num82 AS TABLE OF NUMBER(8,2);
/

/* ----------------------------------------------------------------------- */
/* Declaring a package specification where procedures for querying         */
/* department wise project information and employee information resides.   */
/* The package defines following procedures                                */
/*      1) Display_dept_projs - Display Department Wise Project Info       */
/*      2) Display_dept_emp   - Display Department Wise Employee Info      */
/*      3) Display_proj_emp   - Display Employee and Corresponding Project */ 
/* The package defines a function get_emp_proj which expects two parameters*/
/*      a) Nested table of Project related information                     */
/*      b) Nested table of Employee related information                    */
/* The function returns nested table of ot_emp_proj object which tells     */
/* who is working on which project.                                        */
/* ----------------------------------------------------------------------- */

CREATE OR REPLACE PACKAGE proj_emp_pack AS
    PROCEDURE display_dept_projs;
    PROCEDURE display_dept_emp;
    PROCEDURE display_proj_emp;
    FUNCTION get_emp_proj(p1 nt_project, p2 nt_employee) RETURN nt_projemp;
    PRAGMA RESTRICT_REFERENCES(get_emp_proj,RNDS,WNDS,RNPS,WNPS);
END proj_emp_pack;
/
SHOW ERRORS

/* ----------------------------------------------------------------------- */
/* Define Body of the package.                                             */
/* ----------------------------------------------------------------------- */

CREATE OR REPLACE PACKAGE BODY proj_emp_pack AS
   
   /* -------------------------------------------------------------------- */
   /* Procedure to display Department Names and the current Projects       */
   /* being executed currently by the department.                          */
   /* -------------------------------------------------------------------- */

   PROCEDURE display_dept_projs
   IS
      -- Define weakly typed reference cursor 
      TYPE rc_c IS REF CURSOR;
      l_c1   rc_c;
      l_v1 nt_chr50 := nt_chr50(NULL);
      l_v2 nt_chr10 := nt_chr10(NULL);
      l_v3 nt_chr20 := nt_chr20(NULL);
      l_v4 nt_num102 := nt_num102(NULL);
      l_i  NUMBER := 1;
      l_total_projects NUMBER := 0;
   BEGIN
      -- Using TABLE Operator to unnest projects column of dept_info table

      OPEN l_c1 FOR 'SELECT p1.dept_name,p2.* 
         FROM dept_info p1, TABLE(p1.projects)p2';
      LOOP
          FETCH l_c1 INTO l_v1(l_i),l_v2(l_i),l_v3(l_i),l_v4(l_i); 
          EXIT WHEN l_c1%NOTFOUND;
          l_v1.EXTEND;
          l_v2.EXTEND;
          l_v3.EXTEND;
          l_v4.EXTEND;
          l_i := l_i + 1;
      END LOOP;
      CLOSE l_c1;
      l_v1.TRIM;
      l_v2.TRIM;
      l_v3.TRIM;
      l_v4.TRIM;

      -- Demonstrating converting local PL/SQL collection variable into a 
      -- relational table.

      SELECT COUNT(*) INTO l_total_projects FROM TABLE(CAST(l_v2 as nt_chr10));
    
      -- Displaying the Department Name and Corresponding Project Info 

      DBMS_OUTPUT.PUT_LINE(' Listing Of Department Wise Current Projects  :'); 
      DBMS_OUTPUT.NEW_LINE();
      DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
      '----------------');
      DBMS_OUTPUT.PUT_LINE(' Department     Project Id     Project Name  '||
       '  Budget($)');
     DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
     '----------------');
      FOR l_i IN 1..l_v1.COUNT
      LOOP
         DBMS_OUTPUT.PUT_LINE(l_v1(l_i)||'      '||l_v2(l_i)||'            '||
           l_v3(l_i)||'       '|| l_v4(l_i));
      END LOOP;
      DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
      '----------------');
      DBMS_OUTPUT.NEW_LINE();
      DBMS_OUTPUT.PUT_LINE('** Total Number Of Projects ---> '||
        l_total_projects);
   END display_dept_projs;

   /* -------------------------------------------------------------------- */
   /* Procedure to display Department Names and the current Employees      */
   /* employed by the department.                                          */
   /* -------------------------------------------------------------------- */
   PROCEDURE display_dept_emp
   IS
      -- Define weakly typed reference cursor 
      TYPE rc_c1 IS REF CURSOR;
      l_c1 rc_c1;
      l_v1 nt_chr10 := nt_chr10(NULL);
      l_v3 nt_chr50 := nt_chr50(NULL);
      l_v5 nt_chr40 := nt_chr40(NULL);
      l_v6 nt_chr10 := nt_chr10(NULL);
      l_v7 nt_num82 := nt_num82(NULL);
      l_i NUMBER := 1;
      l_total_employees NUMBER := 0;
   BEGIN
     -- Using TABLE Operator to unnest employees column of dept_info table

     OPEN l_c1 FOR 'SELECT p1.dept_name, p3.* 
      FROM dept_info p1, TABLE(p1.employees) p3';
     LOOP
        FETCH l_c1 INTO l_v3(l_i),l_v1(l_i),l_v5(l_i),l_v6(l_i),l_v7(l_i);
        EXIT WHEN l_c1%NOTFOUND;
        l_v1.EXTEND;
        l_v3.EXTEND;
        l_v5.EXTEND;
        l_v6.EXTEND;
        l_v7.EXTEND;
        l_i := l_i + 1;
     END LOOP;
     CLOSE l_c1;
     l_v1.TRIM;
     l_v3.TRIM;
     l_v5.TRIM;
     l_v6.TRIM;
     l_v7.TRIM;

     -- Demonstrating converting local PL/SQL collection variable into a 
     -- relational table.

     SELECT COUNT(*) INTO l_total_employees FROM TABLE(CAST(l_v1 as nt_chr10));
    
     -- Displaying the Department Name and Corresponding Employee Info 

     DBMS_OUTPUT.NEW_LINE();
     DBMS_OUTPUT.NEW_LINE();
     DBMS_OUTPUT.PUT_LINE(' Listing Of Department Wise Current Employees : '); 
     DBMS_OUTPUT.NEW_LINE();
     DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
     '----------------');
     DBMS_OUTPUT.PUT_LINE(' Department     Employee Name         Project   '||
      '  Salary($)');
     DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
     '----------------');
     FOR l_i IN 1..l_v1.COUNT
     LOOP
         DBMS_OUTPUT.PUT_LINE(l_v3(l_i)||'    '||l_v5(l_i)||'              '||
           l_v6(l_i)|| '         '|| l_v7(l_i));
     END LOOP;
     DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
     '----------------');
     DBMS_OUTPUT.NEW_LINE();
     DBMS_OUTPUT.PUT_LINE('** Total Number Of Employees ---> '||
        l_total_employees);
     DBMS_OUTPUT.NEW_LINE();
   END display_dept_emp;

   /* -------------------------------------------------------------------- */
   /* Procedure to display Employee Names and the current Project on       */
   /* which the employee is working.                                       */
   /* -------------------------------------------------------------------- */

   PROCEDURE display_proj_emp 
   IS
      TYPE rc_c1 IS REF CURSOR;
      l_c1 rc_c1;
      l_v2 nt_chr20 := nt_chr20(NULL);
      l_v3 nt_chr50 := nt_chr50(NULL);
      l_v5 nt_chr40 := nt_chr40(NULL);
      l_i NUMBER := 1;
   BEGIN
      -- Using TABLE Operator to unnest collections 

      -- Demonstrating converting local PL/SQL collection variable into a 
      -- relational table.

      OPEN l_c1 FOR 
      'SELECT p1.dept_name, p2.*  FROM dept_info p1,
       TABLE(CAST(proj_emp_pack.get_emp_proj(p1.projects,p1.employees)
       AS nt_projemp))p2 ';
      LOOP
         FETCH l_c1 INTO l_v3(l_i),l_v2(l_i),l_v5(l_i);
         EXIT WHEN l_c1%notfound;
         l_v2.EXTEND;
         l_v3.EXTEND;
         l_v5.EXTEND;
         l_i := l_i + 1;
      END LOOP;
      CLOSE l_c1;
      l_v2.TRIM;
      l_v3.TRIM;
      l_v5.TRIM;

      -- Displaying the Employee Name and Corresponding Project Info 

      DBMS_OUTPUT.NEW_LINE();
      DBMS_OUTPUT.NEW_LINE();
      DBMS_OUTPUT.PUT_LINE(' Listing Of Employees and Current Projects : '); 
      DBMS_OUTPUT.NEW_LINE();
      DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
      '----------------');
      DBMS_OUTPUT.PUT_LINE(' Employee Name    '|| '        Project Name');
      DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
      '----------------');
      FOR l_i IN 1..l_v2.COUNT
      LOOP
          DBMS_OUTPUT.PUT_LINE('  '||l_v5(l_i)|| '              '||l_v2(l_i));
      END LOOP;
      DBMS_OUTPUT.PUT_LINE('--------------------------------------------' ||
      '----------------');
      DBMS_OUTPUT.NEW_LINE();
   END display_proj_emp;

   /* ------------------------------------------------------------------ */
   /* Function which returns the nested table having project name and    */
   /* Employee Name. The input parameters to this function are           */
   /*               a) nested table of projects                          */
   /*               b) and nested table of employees                       */
   /* ------------------------------------------------------------------ */ 

   FUNCTION get_emp_proj(p1 nt_project,p2 nt_employee)
   RETURN nt_projemp
   IS
      l_v1 VARCHAR2(10);
      l_v2 VARCHAR2(10);
      l_i  NUMBER := 1;
      l_j  NUMBER;
      l_k  NUMBER;
      l_l  NUMBER;
      l_n  nt_projemp := nt_projemp(ot_proj_emp(' ',' '));
   BEGIN
      l_j := p1.COUNT; 
      l_k := p2.COUNT;
      l_n.Extend(l_j-1);
      FOR l_i IN 1..l_j
      LOOP
         l_v1 := p1(l_i).project_id;
         FOR l_l in 1..l_k
         LOOP
            l_v2 := p2(l_l).Current_Proj_Id;
         IF l_v1 = l_v2 THEN
           l_n(l_i) := ot_proj_emp(p1(l_i).project_name,p2(l_l).emp_name); 
           EXIT;
         END IF;
        END LOOP;
      END LOOP;
      RETURN (l_n);
   END get_emp_proj;

END proj_emp_pack;
/
SHOW ERRORS;

SET ECHO OFF
SPOOL OFF
SPOOL dm028.lis

/******************** EXECUTION BEGINS HERE *******************************/

BEGIN

  /* Insert Some Sample Rows into Dept_Info Table */

  INSERT INTO dept_info VALUES('D1','Department 1',
      nt_project(ot_project('P1','Project 1',2000), 
         ot_project('P2','Project 2',4000)), 'NewYork', 
        nt_employee(ot_employee('E1','Employee 1','P1',1000),
        ot_employee('E2','Employee 2','P2',2000))
      );

  INSERT INTO dept_info VALUES('D2','Department 2',
      nt_project(ot_project('P3','Project 3',2000),
        ot_project('P4','Project 4',4000)),
      'Sanfrancisco', 
       nt_employee(ot_employee('E3','Employee 3','P3',1000),
       ot_employee('E4','Employee 4','P4',2000))
      );
 
  INSERT INTO dept_info VALUES('D3','Department 3',
      nt_project(ot_project('P5','Project 5',2000),
      ot_project('P6','Project 6',4000)),
      'Washington', 
        nt_employee(ot_employee('E5','Employee 5','P5',1000),
        ot_employee('E6','Employee 6','P6',2000))
      );
 
  /* Display Department Wise Employee Information */

  proj_emp_pack.display_dept_emp;

  /* Display Department Wise Project Information */

  proj_emp_pack.display_dept_projs;


  /* Display Employee Wise Project Information */

  proj_emp_pack.display_proj_emp;

END;
/
SPOOL OFF

/***************** Clean Up ****************************************/

DROP TABLE dept_info
/

DROP TYPE nt_project;
/

DROP TYPE nt_employee;
/

DROP TYPE nt_projemp;
/

DROP TYPE ot_project;
/

DROP TYPE ot_employee;
/

DROP TYPE ot_proj_emp;
/

DROP TYPE nt_chr50;
/

DROP TYPE nt_num102;
/

DROP TYPE nt_chr20;
/

DROP TYPE nt_chr10;
/

DROP TYPE nt_chr40;
/

DROP TYPE nt_num82;
/
