Rem
Rem ndsdemo.sql
Rem
Rem Copyright (c) 1998, 1999 By Oracle Corporation
Rem
Rem NAME
Rem    ndsdemo.sql - Demo Program For Native Dynamic SQL in PL/SQL
Rem
Rem The Demo Program demonstrates Native Dynamic SQL in PL/SQL feature.
Rem
Rem FUNCTION.
Rem 
Rem In Pre 8.1, support for Dynamic SQL in PL/SQL is available through the 
Rem DBMS_SQL package's programmatic interfaces. The DBMS_SQL approach is 
Rem cumbersome to use and is much slower than static SQL in PL/SQL.
Rem
Rem Native Dynamic SQL in PL/SQL makes dynamic SQL processing in PL/SQL
Rem extremely simple and easy to use. Also it improves the performance of
Rem Dynamic SQL execution in PL/SQL.
Rem
Rem To demonstrate the feature, the demo program builds a simple employee 
Rem search tool.  
Rem
Rem NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem    1) Use svrmgrl for running this demo program.
Rem   
Rem    2) Connect to oracle and run ndsdemo.sql
Rem        @ndsdemo.sql
Rem
Rem    3) Result of the test is printed in file ndsdemo.lis
Rem

/*
** ##########################################################################
**
**         DESCRIPTION  OF  DEMO  EXAMPLE
**
** ##########################################################################
**
** The following example illustrates the Native Dynamic SQL in PL/SQL 
** feature.
**
** In the demo example, a general purpose employee search tool is built using
** Native Dynamic SQL in PL/SQL feature.
**
** Details of all employees is recorded in a table called Employee_desc.  
** The columns of Employee_Desc table are
**
**  a) Name       VARCHAR2(40)  # Name Of Employee #
**  b) Email_Id   VARCHAR2(40)  # Email address    #
**  c) Gender     VARCHAR2(10)  # Gender 'MALE','FEMALE' #
**  d) Job        VARCHAR2(30)  # Job              #
**  e) City       VARCHAR2(30)  # City belongs to  #
**  f) Remarks    VARCHAR2(100) # Remarks          #
**
** The demo program takes as an input, a simple English statement with 
** predefined keywords like Name, Job(all column names of Employee_desc table)
** ,'IS', and ','. 
**
** For example, the input may be a string 'Name is John, State Is Newyork'.
**
** In the demo example, package employee_pack has two main procedures namely 
**
**     a) add_entry(ename Varchar2, emailid Varchar2, gender Varchar2, 
**        job Varchar2, City Varchar2, remarks Varchar2 ) and
**     b) search(input_string VARCHAR2).
** 
** a) Procedure add_entry expects as input, following six variables.
**          i) ename           - Employee Name
**         ii) emailid         - Email Id of the Employee
**        iii) Gender          - Gender of Employee 
**         iv) Job             - Job of Employee
**          v) City            - City 
**         vi) Remarks         - Special Remarks for Employee
**
**    The procedure then inserts the corresponding employee record into the 
**    Employee_Desc table.  
**
** b) Procedure search expects as input, an English Statement for ex. 
**    'Name is John, Gender is Male, City is New York'.
**    The procedure then parses the statement and displays the records of
**    all employees which satisfy the criteria given in input English 
**    Statement.
**
** Search procedure make use of a procedure parse which parses the input
** statement and extracts the inputed values for each keyword(Name, job etc).
**
*/

/*
** ###########################################################################
**
**     CODING  STYLE  USED
**
** ##########################################################################
**
**    1. Uppercase is used for PL/SQL keywords and lower case for defined
**       items.
**
**    2. Naming conventions followed for user defined types  :
**   ---------------------------------------------------------------------
**   Data Structure Name                          Prefixed with
**   ---------------------------------------------------------------------
**      Nested Table Types                           nt_
**      Local Variables                              l_
**      Reference Cursor Types                       rct_
**      Reference Cursors                            rc_
*/

SET ECHO OFF;
SET SERVEROUTPUT ON;
SPOOL dm031.dbg

/*--------------------------------------------------------------------*/
/*             Table for Storing Employee related Data                */
/*--------------------------------------------------------------------*/

CREATE TABLE employee_desc (
           Name         VARCHAR2(40),
           Email_Id     VARCHAR2(40),
           Gender       VARCHAR2(10),
           Job          VARCHAR2(30),
           City         VARCHAR2(30),
           Remarks      VARCHAR2(100));
/

/*------------------------------------------------------------------------*/
/* Declaring a package specification where procedures for adding employee */
/* record and searching employee records resides.                         */
/* The procedures declared are namely                                     */
/*       a) Initialize_Keywords - Initialize nested table of all keywords */
/*       b) parse               - Parsing the input string and extracting */
/*                                keyword values                          */
/*       c) Add_entry           - Procedure for adding Employee records   */
/*       d) Search              - Procedure for searching employee records*/
/*                                                                        */
/* The package also defines two nested table types for the purpose of     */
/* parsing input statement.                                               */
/*       a) nt_keywords  - To record all column names of Employee_desc    */
/*       b) nt_keywords_values - To record values of each Column provided */
/*                               in input_string                          */
/*------------------------------------------------------------------------*/
CREATE OR REPLACE PACKAGE employee_pack IS
        TYPE nt_keywords IS TABLE OF VARCHAR2(20);
        TYPE nt_keywords_values IS TABLE OF VARCHAR2(50);
        keywords   nt_keywords; -- All keywords are stored here.
        PROCEDURE initialize_keywords; -- Initialize keywords nested table 
        PROCEDURE parse(input_string VARCHAR2, 
              keyword_values  OUT nt_keywords_values);
        PROCEDURE add_entry(ename VARCHAR2, emailid VARCHAR2, gender VARCHAR2,
            job VARCHAR2, city VARCHAR2, remarks VARCHAR2);
        PROCEDURE search(input_string VARCHAR2);
END employee_pack;
/
SHOW ERRORS

/*------------------------------------------------------------------------*/
/* Define Body of the package.                                            */
/* Procedure parse expects as input a Englist statement. After parsing the*/
/* Statement, it returns all the keyword's values provided in the input   */
/* stmt as a nested table.                                                */
/* Procedure add_entry expects as input the following six variables       */
/*       i) ename ii) emailid iii) gender iv) job v) city vi) remarks     */
/* and adds the corresponding Employee Record into Employee_Desc table.   */
/* Procedure search expects as input a English Statement and displays the */
/* Employee records satisfying the provided criteria.                     */ 
/*------------------------------------------------------------------------*/
CREATE OR REPLACE PACKAGE BODY employee_pack IS

        /* Store Keywords in a nested table */
        PROCEDURE initialize_keywords 
        IS
        BEGIN
          keywords.EXTEND(6);
          keywords(1) := 'Name';
          keywords(2) := 'Email_id';
          keywords(3) := 'gender';
          keywords(4) := 'job';
          keywords(5) := 'city';
          keywords(6) := 'Remarks';
        END initialize_keywords;

        /* Procedure to parse the input statement. */
        /* keyword_values is a nested table containing values of keywords */
        /* provided in input_string. This nested table is returned back to*/
        /* the calling procedure for further processing */
        PROCEDURE parse(input_string VARCHAR2,
            keyword_values  OUT nt_keywords_values)
        IS
           l_position  NUMBER;
           l_next_position  NUMBER;
           l_clause    VARCHAR2(200);
           l_kwd_value VARCHAR2(50);
           l_keyword_values nt_keywords_values := nt_keywords_values();
        BEGIN
           FOR l_i IN 1..keywords.COUNT
           LOOP
             l_keyword_values.EXTEND;
             /* Check if the Keyword exists in the input string and get its */
             /* position in the input string    */
             l_position := INSTR(UPPER(input_string),UPPER(keywords(l_i)));
             IF l_position != 0 THEN
                /* If Keyword Exists then get the next position of ',' */
                l_next_position := INSTR(UPPER(input_string),',',l_position);
                IF l_next_position = 0 THEN
                     l_next_position := LENGTH(input_string);
                ELSE
                     l_next_position := l_next_position - 1;
                END IF;
                /* Pick up a particular clause for e.g Name is John etc */
                l_clause := SUBSTR(UPPER(input_string),l_position,
                     l_next_position - l_position + 1);
                /* Get the position of IS in the clause */
                l_position := INSTR(UPPER(l_clause),'IS');
                /* Get the Keyword value */
                l_kwd_value := RTRIM(LTRIM(SUBSTR(UPPER(l_clause), 
                    l_position + 3, LENGTH(l_clause) - l_position -2)));
                /* Store the keyword value in nested table */
                l_keyword_values(l_i) := l_kwd_value;
             ELSE 
                /* Keyword doesnot exist in the input clause. So the keyword */
                /* value is set as NULL */
                l_keyword_values(l_i) := NULL;
             END IF;
           END LOOP;
           keyword_values := l_keyword_values;
        END parse; 

        /* Procedure to add Employee Record Into Employee_Desc */
        PROCEDURE add_entry(ename VARCHAR2, emailid VARCHAR2, gender VARCHAR2,
                            job VARCHAR2, city VARCHAR2, remarks VARCHAR2)
        IS
        BEGIN
             /* Using Static SQL To insert Employee Record */
             INSERT INTO employee_desc 
                      VALUES(ename, emailid, gender, job, city, remarks);
        END add_entry; 

        /* Procedure to display Employee Records matching given criteria*/
        PROCEDURE search(input_string VARCHAR2)
        IS
          /* Declare a weak type cursor for fetching records matching */
          /* given criteria.                                          */
          TYPE rct_cursor IS REF CURSOR; 
          l_rc_c1       rct_cursor;

          /* A nested table to hold keyword values after parsing */
          l_kwd_vals  nt_keywords_values;
          l_whereclause VARCHAR2(500);
          l_andclause   VARCHAR2(10) := ' ';
          l_name      VARCHAR2(30);
          l_email_id  VARCHAR2(30);
          l_job       VARCHAR2(30);
          l_remarks   VARCHAR2(100);
          l_i         NUMBER := 1;
          l_match_records NUMBER;
          l_sql_stmt    VARCHAR2(500);
        BEGIN
          parse(input_string,l_kwd_vals);-- Parse given input 

          /* Prepare dynamic SQL whereclause  */
          FOR l_i IN 1..l_kwd_vals.COUNT
          LOOP
             /* Prepare where clause */
             If  (l_kwd_vals(l_i) IS NOT NULL ) THEN
                 l_whereclause := l_whereclause || l_andclause ||
                    'UPPER('||keywords(l_i);
                 l_whereclause := l_whereclause ||') = '||'''';
                 l_whereclause := l_whereclause ||l_kwd_vals(l_i)||'''';
                 l_andclause   := ' AND ';
             END IF;
          END LOOP;

          /* Get the number of records matching given criteria */
          l_sql_stmt := 'SELECT COUNT(*) FROM employee_desc WHERE '||
            l_whereclause;
          EXECUTE IMMEDIATE l_sql_stmt INTO l_match_records;
          DBMS_OUTPUT.NEW_LINE();

          DBMS_OUTPUT.PUT_LINE('You Searched For Following Criteria ---> ');
          DBMS_OUTPUT.PUT('------------------------------------------');
          DBMS_OUTPUT.PUT_LINE('------------');
          DBMS_OUTPUT.PUT_LINE('******* '||RTRIM(input_string));
          DBMS_OUTPUT.PUT('------------------------------------------');
          DBMS_OUTPUT.PUT_LINE('------------');
          DBMS_OUTPUT.PUT_LINE('Number of Records Matching Input Criteria ='||
               ' '||l_match_records);
          DBMS_OUTPUT.NEW_LINE();
          DBMS_OUTPUT.PUT_LINE('Your Employee Search Result Follows :');

          /* Open Dynamic Cursor */ 
          /* For a given criteria, the number of records satisfying criteria */
          /* can be more than one. Hence the need of a dynamic cursor */

          /* Fetch and Display Records */
          OPEN l_rc_c1 FOR 'SELECT name, email_id, job, remarks FROM 
             employee_desc WHERE '||l_whereclause;
          LOOP
             FETCH l_rc_c1 INTO l_name,l_email_id,l_job,l_remarks;
             EXIT WHEN l_rc_c1%NOTFOUND;
             DBMS_OUTPUT.PUT_LINE('  Record Number : '||l_i);
             DBMS_OUTPUT.PUT_LINE('  Name -->       '||NVL(l_name, 'N.A'));
             DBMS_OUTPUT.PUT_LINE('  Email -->      '||NVL(l_email_id,'N.A'));
             DBMS_OUTPUT.PUT_LINE('  Job -->        '||NVL(l_job,'N.A'));
             DBMS_OUTPUT.PUT_LINE('  Remarks -->    '||NVL(l_remarks,'N.A'));
             DBMS_OUTPUT.NEW_LINE();
             l_i := l_i + 1;
          END LOOP;
         END search;
END employee_pack;
/
SHOW ERRORS

SPOOL OFF
SPOOL dm031.lis

/*********** Execution Starts Here *************************************/
DECLARE
   l_input_str VARCHAR2(500);-- Get user Input Here 
BEGIN

   /* Initialize Nested Table and Store all Keywords */
   employee_pack.keywords := employee_pack.nt_keywords();
   employee_pack.initialize_keywords;

   /* Set the default buffer size of DBMS_OUTPUT package to 100000 */
   DBMS_OUTPUT.ENABLE(100000);

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('**** Adding Few Sample Employee Records ');

   /* Add Employee Record For John */
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('** Adding Employee Record Of John ');
   employee_pack.add_entry('John','john@hotmail.com','Male','Programmer',
      'New York','CheerFul Helping');

   /* Add Employee Record For Mary Jones*/
   DBMS_OUTPUT.PUT_LINE('** Adding Employee Record Of Mary Jones ');
   employee_pack.add_entry('Mary Jones','maryj@us.oracle.com','Female',
          'Manager','Washington','Outgoing Kind');

   /* Add Employee Record For Ford */
   DBMS_OUTPUT.PUT_LINE('** Adding Employee Record Of Ford ');
   employee_pack.add_entry('Ford','ford@us.oracle.com','Male',
          'Manager','New York','Very Strict, sincere');

   /* Add Employee Record For Adams */
   DBMS_OUTPUT.PUT_LINE('** Adding Employee Record Of Adams ');
   employee_pack.add_entry('Adams','adams@hotmail.com','Male',
          'Manager','Seatle','Very Intelligent, Hard Working, Reliable');

   /* Add Employee Record For Scott */
   DBMS_OUTPUT.PUT_LINE('** Adding Employee Record Of Scott ');
   employee_pack.add_entry('Scott','scott@netscape.net','FeMale',
          'DBA','Seatle','Intelligent, Reliable, Cooperative');

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT_LINE('*** Searching Few Employee Records using Native '||
     'Dynamic SQL ***');

   /* Searching Record For Name is John and Gender Is male */
   l_input_str := 'Name is John, gender is male';
   employee_pack.search(l_input_str);

   /* Searching Record For job is manager */
   l_input_str := 'Job is Manager';
   employee_pack.search(l_input_str);

   /* Searching Record For city is New York and Gender is Male and Job is 
     Manager */
   l_input_str := 'City is New York, Gender is Male, Job IS Manager';
   employee_pack.search(l_input_str);

   /* Searching Record For city is New York and Gender is Male and Job is 
     Manager */
   l_input_str := 'Job IS Programmer, Gender is male';
   employee_pack.search(l_input_str);

END;
/
SPOOL OFF

/************ Clean Up ********************/
DROP TABLE employee_desc
/
