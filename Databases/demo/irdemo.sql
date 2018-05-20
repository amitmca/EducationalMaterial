Rem
Rem Copyright (c) 1998, 1999 By Oracle Corporation
Rem
Rem NAME
Rem   irdemo.sql - Demo Program For Invoker-Rights Programs
Rem
Rem
Rem FUNCTION
Rem 
Rem   The Demo Program illustrates the use of Invoker-Rights Programs.  
Rem
Rem   In Pre 8.1, all programs executes with the privileges of its definer.
Rem   Invoker-Rights programs executes with the privileges of the user 
Rem   invoking the program.
Rem
Rem NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem    1) Use svrmgrl for running this demo program.
Rem
Rem    2) Run irdemo.sql as
Rem       @irdemo.sql
Rem
Rem
Rem MODIFIED 
Rem    rchennoi      08/18/99 -
Rem    jmuller       05/28/99 - Fix bug 708690: TAB -> blank
Rem    nmantrav      05/05/99 - fix hangs.
Rem    gviswana      09/30/98 - Add to demo directory
Rem    ukulkarn.in   07/30/98 - Creation.
Rem
Rem

/*
** ##########################################################################
**
**            DESCRIPTION  OF  DEMO  EXAMPLE
**
** ##########################################################################
**
** The Demo Example illustrates the use of Invoker-Rights Programs introduced 
** in 8.1
**
** In the Demo Example, there are two departments
**           a) Finance Department
**           b) Manufacturing Department
**
** Each of the above Department have its own schema for recording Employee 
** Details. 
**     a) Finance Schema and 
**     b) Manufacturing Schema respectively.  
** 
** Whenever a new employee joins the organization, his/her details are stored 
** in Employee_table in the corresponding department's schema. 
** 
** For example, employee joining Finance Department has his/her record stored  
** in Employee Table in Finance Schema. 
** 
** There is a global schema called Company Schema. In company schema, all 
** company related information like all the departments and their 
** corresponding total strength is stored. Whenever a new employee joins 
** the company, the strength of the corresponding department is incremented 
** by one and updated in departments table in Company Schema. 
** 
** Currently each department has its own module(functions/procedures) for 
** performing the following actions. 
**    1) Recording Employee Details when a Employee joins. 
**    2) Deleting Employee Details when a Employee resigns. 
** 
** These modules functionally do pretty much the similar operations.The 
** disadvantage of such a mechanism is that every time a new department is 
** added, a corresponding new module for Employee Joining/resigning process
** needs to be developed/added. 
** 
** Since the process of joining/resigning is same throughout the company, the 
** above scenario leads to duplication of code and maintenance of application 
** becomes difficult. 
** 
** It would be nice to group the Employee Joining/Resigning process in single 
** module (package) at one place 
** i.e in Company Schema and all departments reuse the code residing in Company 
** Schema. 
** 
** Deploying reusable code allows the maintenance of the application to be  
** handled easily. 
** 
** Using Invoker-rights Programs this can be achieved easily as illustrated in 
** the example below. 
**
** How Invoker-Rights programs helps ? 
** -----------------------------------
** Invoker-Rights programs executes with the privileges of the user invoking
** the program. This can be effectively used in above scenario.    
** 
** The Employee Joining/Resigning Module can reside at Company schema/user as  
** Invoker-Rights program. Different departments can invoke the Employee 
** Joining/Resigning module and update corresponding Employee Tables in 
** respective Department Schemas/users.  
** 
** After updating Employee tables, the procedure which updates the total 
** strength of department can be invoked which resides in Company Schema.
** This procedure is not Invoker-rights program and it updates 
** departments_table in Company Schema/user.  
** 
** This can be shown pictorially as follows : 
** 
**
**  Schema Finance             Schema Company           Schema Manufacturing 
** ---------------------      ----------------------|   ----------------- 
** |                   |      |  ______________     |   |               | 
** |      Invoke ______|______|_\|             |/___|___|___Invoke      | 
** |                   |      | /|Emp Join App |\   |   |               | 
** |                   |      |  |_____________|    |   |               | 
** |                   |    __|___|    | (IR) |_____|__ |               | 
** |                   |   /  |        |            |  \| Employee_table| 
** | Employee_table    |  /   |       \|/           |   \    __________ | 
** |    ___________    | /    |Incr_dept_strength   |   |\__\|        | | 
** |    |          |/__|/     |         |  (DR)     |   |   /|        | |  
** |    |          |\  |      |        \|/          |   |    |        | |  
** |    |__________|   |      |Departments_table    |   |    |________| | 
** |                   |      |   ______________    |   |               | 
** |                   |      |   |            |    |   |               | 
** |                   |      |   |____________|    |   |               | 
** ---------------------      -----------------------   ------------------ 
**
**   IR : Invoker-Rights Program 
**   DR : Definer-Rights Program 
**
** Assumptions : 
**
** 1)There are 3 Users  
**     a) Finance 
**     b) Manufacturing 
**     c) Company 
** 
** 2) Each user Finance and Manufacturing have a Employee_table.  
**   The columns of Employee_table are  
**   
**       a) Employee_Id   Varchar2(5)      # Identification Number # 
**       b) Employee_name Varchar2(50)     # Employee Name         # 
**       c) Employee_Address Varchar2(100) # Employee Address      # 
**       c) Dept_code     Varchar2(4)      # Department Code       # 
**       d) Grade         Varchar2(3)      # Grade Of Employee     # 
**       e) Date_Of_Joining Date           # Date Of joining       # 
** 
** 3) A prototype of Employee_table is also created in Company User. 
** 
** 4) Company User has a Departments_Table which keeps track of total 
**    strength of each department. 
**   The columns of Departments_table are 
**       
**      a) Department_code   varchar2(4)    # Department Code   # 
**      b) Department_name   varchar2(30)   # Name of the department # 
**      c) Department_strength Number(4)    # Total Strength Of Dept # 
** 
**
*/

/*
** ########################################################################
** 
**                   CODING  STYLE  USED
**
** #########################################################################
**
**    1.  Uppercase is used for PL/SQL keywords and lower case for defined
**        items.
**
**    2.  Names for local variables are Prefixed with l_
**
**
*/

CONNECT SYSTEM/MANAGER;
SET ECHO OFF;
SET SERVEROUTPUT ON;
SPOOL dm026.dbg

/*------------------------------------------------------------------------*/
/*     Create user Finance For Storing Information Related To Finance     */
/*------------------------------------------------------------------------*/

CREATE USER FINANCE IDENTIFIED BY FINANCE;
/

GRANT ALL PRIVILEGES TO FINANCE;

/*------------------------------------------------------------------------*/
/*     Create user Mfg For Storing Information Related To Manufacturing   */
/*------------------------------------------------------------------------*/

CREATE USER MFG IDENTIFIED BY MFG;
/

GRANT ALL PRIVILEGES TO MFG;

/*------------------------------------------------------------------------*/
/*     Create user Company For Storing company related information        */
/*------------------------------------------------------------------------*/

CREATE USER COMPANY IDENTIFIED BY COMPANY;
/

GRANT ALL PRIVILEGES TO COMPANY;

CONNECT MFG/MFG;

/*------------------------------------------------------------------------*/
/*     Table for storing Employee Related Information (In Mfg User)       */
/*------------------------------------------------------------------------*/

CREATE TABLE Employee_Table (
    Employee_Id      VARCHAR2(5),
    Employee_Name    VARCHAR2(30),
    Employee_Address VARCHAR2(50),
    Dept_Code        VARCHAR2(5),
    Grade            VARCHAR2(3),
    Joining_Date     DATE );
/

CONNECT FINANCE/FINANCE;

/*------------------------------------------------------------------------*/
/*     Table for storing Employee Related Information (In Finance user )  */
/*------------------------------------------------------------------------*/

CREATE TABLE Employee_Table (
    Employee_Id      VARCHAR2(5),
    Employee_Name    VARCHAR2(30),
    Employee_Address VARCHAR2(50),
    Dept_Code        VARCHAR2(5),
    Grade            VARCHAR2(3),
    Joining_Date     DATE );
/

CONNECT COMPANY/COMPANY;

/*------------------------------------------------------------------------*/
/*          Prototype Of Employee table In company user.                  */
/*          Required for Invoker-Rights Programs to compile.              */
/*------------------------------------------------------------------------*/

CREATE TABLE Employee_Table (
    Employee_Id      VARCHAR2(5),
    Employee_Name    VARCHAR2(30),
    Employee_Address VARCHAR2(50),
    Dept_Code        VARCHAR2(5),
    Grade            VARCHAR2(3),
    Joining_Date     DATE );
/

/*------------------------------------------------------------------------*/
/*  Table for storing department wise Employee Strength                   */
/*------------------------------------------------------------------------*/

CREATE TABLE Departments_Table (
    Department_Code  VARCHAR2(5),
    Department_Name  VARCHAR2(30),
    Department_Strength NUMBER(6) );
/


/*------------------------------------------------------------------------*/
/*   Procedure which increments employee strength by one. This Procedure  */
/*   expects department_code as a parameter.                              */
/*   This procedure is Definer-Rights program and is called when a new    */
/*   Employee joins any Department. The Department Strength Of that Dept  */
/*   is incremented by one.                                               */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PROCEDURE Increment_Dept_Strength(Deptcd VARCHAR2)
IS
BEGIN
       UPDATE Departments_Table
        SET Department_strength = Department_Strength + 1
       WHERE Department_code = Deptcd;
END Increment_Dept_Strength;
/
SHOW ERRORS


/*------------------------------------------------------------------------*/
/*   Procedure which decrements employee strength by one. This Procedure  */
/*   expects department_code as a parameter.                              */
/*   This procedure is Definer-Rights program and is called when a        */
/*   Employee resigns from any Department. The Department Strength Of     */
/*   that Dept is decremented by one.                                     */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PROCEDURE Decrement_Dept_Strength(Deptcd VARCHAR2)
IS
BEGIN
       UPDATE Departments_Table
        SET Department_strength = Department_Strength - 1
       WHERE Department_code = Deptcd;
END Decrement_Dept_Strength;
/
SHOW ERRORS


/*------------------------------------------------------------------------*/
/*              Procedure to Initialize Departments_table.                */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PROCEDURE Initialize_Departments
IS
BEGIN
      INSERT INTO Departments_Table 
         VALUES('FIN','Finance and Accounting ',0);
       INSERT INTO Departments_Table 
         VALUES('MFG','Manufacturing        ',0);
END Initialize_Departments;
/
SHOW ERRORS



/*------------------------------------------------------------------------*/
/* Package which consists of Procedures for                               */
/*      a) Inserting Employee Details - when a new Employee Joins         */
/*      b) Deleting Employee Details - When a employee Resigns            */
/* Note that the procedures are Invoker-Rights Program. This means that   */
/* the procedures executes with the privileges of the invoker and not     */
/* definer.        In this case Definer is Company user.                  */
/* This allows us to reuse the code. Different departments can invoke the */
/* procedures when a new employee joins or a employee resigns the dept.   */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE Emp_Pack AUTHID CURRENT_USER IS
    PROCEDURE Insert_Emp_Details(Empid Varchar2, Empname Varchar2, 
      Empadd Varchar2, Deptcd Varchar2, Grade Varchar2);
    PROCEDURE Delete_Emp_Details(EmpId Varchar2, Deptcd Varchar2);
END Emp_Pack;
/
SHOW ERRORS


/*------------------------------------------------------------------------*/
/*    Define body of the Package                                          */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE BODY Emp_pack IS

    /* ---------------------------------------------------------*/
    /*       Procedure to Insert Employee Details.              */
    /* As the procedure is invoker-rights program, it executes  */
    /* with the privileges of the invoker. For example, if the  */
    /* procedure is called by finance department then all the  */
    /* external names in DML statements are resolved in finance */
    /* user. Here "Employee_Table" is resolved in Invoker's Schema*/
    /* But external name "Increment_Dept_Strength" resolves to  */
    /* company schema because it is Definer-right Program.       */
    /* --------------------------------------------------------*/

    PROCEDURE Insert_Emp_Details(Empid Varchar2, Empname Varchar2, 
      Empadd Varchar2, Deptcd Varchar2, Grade Varchar2)
    IS
      /* Variable declared to get current user name and print */
      l_current_user  VARCHAR2(30);
    BEGIN
        /* Get Current User Name */
        SELECT username INTO l_current_user FROM USER_USERS;   
        DBMS_OUTPUT.NEW_LINE();
        DBMS_OUTPUT.PUT('Connect As '||l_current_user);
        DBMS_OUTPUT.PUT(' And Add Details For '||RTRIM(Empname));
        DBMS_OUTPUT.PUT_LINE(' having Id '||RTRIM(empid));

        INSERT INTO Employee_table VALUES(Empid, Empname, Empadd, Deptcd,
          Grade, SYSDATE);

        /* Increment Department strength */
        Increment_Dept_Strength(Deptcd);
    END Insert_Emp_Details;


    /* ---------------------------------------------------------*/
    /*       Procedure to Delete Employee Details.              */
    /* This procedure is also Invoker-Rights program.Same comments*/
    /* as for Insert_emp_details apply to this procedure        */
    /* ---------------------------------------------------------*/

    PROCEDURE Delete_Emp_Details(EmpId Varchar2, Deptcd Varchar2)
    IS
      /* Variable declared to get current user name and print */
      l_current_user  VARCHAR2(30);
    BEGIN
        /* Get Current User Name */
        SELECT username INTO l_current_user FROM USER_USERS;   
        DBMS_OUTPUT.NEW_LINE();
        DBMS_OUTPUT.PUT('Connect As '||l_current_user);
        DBMS_OUTPUT.PUT_LINE(' And Delete Details Of Employee Having Id '
         ||RTRIM(EmpId));

       DELETE Employee_Table
        WHERE Employee_id = EmpId;

        /* Decrement Department strength */
       Decrement_Dept_Strength(Deptcd);
    END Delete_Emp_Details;

END Emp_Pack;
/
SHOW ERRORS

/*-----------------------------------------------------------------------*/
/* Grant Execute privileges On Emp_Pack to users Mfg and Finance         */
/*-----------------------------------------------------------------------*/

GRANT EXECUTE ON Emp_Pack TO MFG;
/

GRANT EXECUTE ON Emp_Pack TO FINANCE;
/

/*-----------------------------------------------------------------------*/
/* Initialize the Departments_table                                      */
/*-----------------------------------------------------------------------*/

BEGIN
   Initialize_Departments;
END;
/


/*-----------------------------------------------------------------------*/
/* Simulate that few Employee Joins Manufacturing Department.            */
/*-----------------------------------------------------------------------*/

CONNECT MFG/MFG;
SPOOL OFF;
SET ECHO OFF;

SET SERVEROUTPUT ON
SPOOL dm026.lis

DECLARE

   /* Declare cursor to display Names and Empids of Employee Joined */  
   /* Note that the Table "Employee_table" in Cursor l_c1 refers to */
   /* Employee_table in MFG user.                                   */

   l_emp_id  VARCHAR2(5);
   l_emp_name VARCHAR2(30);
   CURSOR l_c1 IS  SELECT Employee_id, Employee_Name
                  FROM Employee_Table;
BEGIN

   /* Insert Employee Details For new Employees */

   Company.Emp_Pack.Insert_Emp_Details('M001','John Miller','New York','MFG',
      'A1');

   Company.Emp_Pack.Insert_Emp_Details('M002','Kings','California','MFG',
      'B1');

   Company.Emp_Pack.Insert_Emp_Details('M003','Martin','Texas','MFG',
      'A2');

   Company.Emp_Pack.Insert_Emp_Details('M004','James','New York','MFG',
      'A1');

   Company.Emp_Pack.Insert_Emp_Details('M005','Ford','New York','MFG',
      'A1');

   /* Display the Employee Ids and Names of the Employees Joined */
   /* Note that this also checks that the Employee records are inserted */
   /* into Employee_table of MFG user(the invoker).              */

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE(); 
   DBMS_OUTPUT.PUT('*** List Details Of Employees in MFG User ***');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('   Employee Id               Employee Name'); 
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   OPEN l_c1;
   LOOP
        FETCH l_c1 INTO l_emp_id, l_emp_name;
        EXIT WHEN l_c1%NOTFOUND;
        DBMS_OUTPUT.NEW_LINE();
        DBMS_OUTPUT.PUT_LINE('     '||l_emp_id||'                    '||
        RTRIM(l_emp_name));
   END LOOP;
   CLOSE l_c1;
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
END;
/

/*-----------------------------------------------------------------------*/
/* Simulate that few Employee Joins Finance Department.                  */
/* Also simulate few Employee Resign From Finance Department             */
/*-----------------------------------------------------------------------*/

CONNECT FINANCE/FINANCE;

SET SERVEROUTPUT ON

DECLARE

   /* Declare cursor to display Names and Empids of Employee Joined */  
   /* Note that the Table "Employee_table" in Cursor l_c1 refers to */
   /* Employee_table in FINANCE user.                               */

   l_emp_id  VARCHAR2(5);
   l_emp_name VARCHAR2(30);
   CURSOR l_c1 IS  SELECT Employee_id, Employee_Name
                  FROM Employee_Table;
BEGIN

   /* Insert Employee Details For new Employees */

   Company.Emp_Pack.Insert_Emp_Details('F001','James Martin','Washington','FIN',
      'A2');

   Company.Emp_Pack.Insert_Emp_Details('F002','Henry','California','FIN',
      'A1');

   Company.Emp_Pack.Insert_Emp_Details('F003','Bruce','California','FIN',
      'A1');

   Company.Emp_Pack.Insert_Emp_Details('F004','Clerk','Texas','FIN',
      'C1');

   /* Delet Employee Details For Employee 'F002' */

   Company.Emp_Pack.Delete_Emp_Details('F002','FIN');

   /* Display the Employee Ids and Names of the Employees Joined         */
   /* Note that this also checks that the Employee records are           */
   /* inserted/deleted into/from Employee_table of FINANCE user(invoker) */

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('*** List Details Of Employees In Finance User ***');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('   Employee Id               Employee Name'); 
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   OPEN l_c1;
   LOOP
        FETCH l_c1 INTO l_emp_id, l_emp_name;
        EXIT WHEN l_c1%NOTFOUND;
        DBMS_OUTPUT.NEW_LINE();
        DBMS_OUTPUT.PUT_LINE('     '||l_emp_id||'                    '||
        RTRIM(l_emp_name));
   END LOOP;
   CLOSE l_c1;
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
END;
/

CONNECT COMPANY/COMPANY;

SET SERVEROUTPUT ON

DECLARE

   /* Declare cursor to display Department Name and Employee Strength */  
   /* of the Department.                                              */

   l_dept_strength  NUMBER(4);
   l_dept_name  VARCHAR2(30);
   CURSOR l_c1 IS SELECT Department_Name, Department_Strength
                  FROM Departments_table;
BEGIN

   /* Display Department Name and Employee Strength Of the Department */
   /* This also checks that the procedure calls increment_dept_strength */
   /* and decrement_dept_strength are Definer-Rights Programs         */

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT('** List Department Wise Strength From Company User **');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE(' Department Name            Employee Strength');
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   OPEN l_c1;
   LOOP
       FETCH  l_c1 INTO l_dept_name, l_dept_strength;
       EXIT WHEN l_c1%NOTFOUND;
       DBMS_OUTPUT.NEW_LINE();
       DBMS_OUTPUT.PUT_LINE('  '||l_dept_name||'               ' ||
         RTRIM(l_dept_strength));
   END LOOP;
   CLOSE l_c1;
   DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.NEW_LINE();
END;
/

SPOOL OFF;

/*******  Clean Up **********************************/

CONNECT SYSTEM/MANAGER

DROP USER FINANCE CASCADE;
/

DROP USER MFG CASCADE;
/

DROP USER COMPANY CASCADE;
/
