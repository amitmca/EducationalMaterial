Rem
Rem extproc.sql
Rem
Rem
Rem  Copyright (c) Oracle Corporation 1997, 1998, 1999. All Rights Reserved.
Rem
Rem    NAME
Rem
Rem      extproc.sql -  Demo program for external procedures.
Rem
Rem    DESCRIPTION
Rem
Rem      This is a sample program to demostrate the creation and usage of 
Rem      external procedures feature of PL/SQL.
Rem
Rem    REQUIREMENTS
Rem
Rem      o ORACLE database user SCOTT exists with demo tables
Rem        EMP and DEPT.
Rem
Rem      o User SCOTT has CREATE LIBRARY privileges.
Rem
Rem      o Package DBMS_OUTPUT is installed for the database.
Rem
Rem
Rem    NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem      o This External Procedures demo program consists of two files
Rem
Rem          extproc.sql & extproc.c
Rem
Rem        extproc.c contains the C functions that are referenced in
Rem        extproc.sql (this file)
Rem
Rem      o Compile extproc.c to generate a shared library extproc.so
Rem        (or extproc.dll on NT).
Rem        Assume you create /tmp/extproc.so 
Rem        (or ORACLE_HOME\plsql81\extproc.dll on NT).   
Rem  
Rem      o Since this demo program requires the EMP and DEPT tables
Rem        which are installed under ORACLE database user SCOTT, 
Rem        request the ORACLE System Administrator to grant 
Rem        'CREATE LIBRARY' privilege to ORACLE database user SCOTT.
Rem
Rem      o Create a PL/SQL library named 'demolib' for user SCOTT.
Rem
Rem        CONNECT SCOTT/TIGER
Rem        CREATE OR REPLACE LIBRARY demolib IS '/tmp/extproc.so';
Rem        /
Rem
Rem        or on an NT system
Rem       
Rem        CONNECT SCOTT/TIGER
Rem        CREATE OR REPLACE LIBRARY demolib IS
Rem        'ORACLE_HOME\plsql81\extproc.dll';
Rem        /
Rem
Rem        Note that the full path name of the shared library is 
Rem        used.
Rem
Rem      o Connect as SCOTT/TIGER and run extproc.sql
Rem
Rem        CONNECT SCOTT/TIGER
Rem        @extproc.sql
Rem
Rem


CREATE OR REPLACE PACKAGE demopack IS
  
  --
  -- Update the salary using the rowid. 
  --
  PROCEDURE UpdateSalary(row_id IN CHAR);


  
  --
  -- Calculate % commission with respect to the salary.
  --
  FUNCTION PercentComm(sal IN FLOAT, comm IN FLOAT) RETURN FLOAT;
  PRAGMA RESTRICT_REFERENCES(PercentComm, WNDS);


  
  --
  -- Calculate %commission with respect to the salary.
  -- This function is similar to function PercentComm but
  -- uses the BY REFERENCE qualifier to pass C parameters
  --
  FUNCTION PercentComm_byref(sal IN DOUBLE PRECISION, comm IN DOUBLE PRECISION)
                              RETURN double precision;
  PRAGMA RESTRICT_REFERENCES(PercentComm_byref, WNDS);


  
  --
  -- Get the experience of the employee. 
  --
  PROCEDURE EmployeeExperience(hiredate IN DATE, 
                               num_experience OUT BINARY_INTEGER);


  
  --
  -- Copy the new_name to old_name only if the new_name can fit.
  -- To ensure this, we pass the MAXLEN of old_name and check if
  -- LENGTH of new_name is <= MAXLEN of old_name. If the check
  -- fails, the C calout will raise an exception.
  -- This function cannot be called from SQL since by default 
  -- this function is considered impure.
  --
  FUNCTION CheckEmpName(old_ename IN OUT VARCHAR2,
                        new_ename IN VARCHAR2) RETURN BINARY_INTEGER;
  


  --
  -- demo_procedure calls the external functions 
  --
  PROCEDURE Demo_Procedure;
  
end demopack;
/
show errors

CREATE OR REPLACE PACKAGE BODY demopack IS


  
  PROCEDURE UpdateSalary(row_id IN CHAR)
  IS EXTERNAL 
    NAME "UpdateSalary"
    LIBRARY demolib 
    WITH CONTEXT
    PARAMETERS (CONTEXT, 
                row_id        STRING, 
                row_id LENGTH SB4);   


  
  FUNCTION PercentComm(sal IN FLOAT, comm IN FLOAT) RETURN FLOAT 
  IS EXTERNAL 
    NAME "PercentComm" 
    LIBRARY demolib 
    PARAMETERS (sal              FLOAT,
                sal    INDICATOR SHORT,
                comm             FLOAT,
                comm   INDICATOR SHORT, 
                RETURN INDICATOR SHORT,
                RETURN           FLOAT); 
  
  FUNCTION PercentComm_ByRef(sal IN DOUBLE PRECISION, 
                             comm IN DOUBLE PRECISION) RETURN double precision 
  IS EXTERNAL 
    NAME "PercentComm_ByRef"
    LIBRARY demolib
    WITH CONTEXT
    PARAMETERS (CONTEXT,
                sal              BY REFERENCE DOUBLE,
                sal    INDICATOR              SHORT,
                comm             BY REFERENCE DOUBLE,
                comm   INDICATOR BY REFERENCE SHORT,
                RETURN INDICATOR              SHORT,
                RETURN           BY REFERENCE DOUBLE);


  
  PROCEDURE EmpExp(hiredate IN VARCHAR2, num_experience OUT BINARY_INTEGER)
  IS EXTERNAL 
    NAME "EmpExp"  
    LIBRARY demolib 
    PARAMETERS (hiredate                 STRING, 
                hiredate       LENGTH    INT,
                hiredate       INDICATOR SHORT,
                num_experience           LONG,
                num_experience INDICATOR INT);
  


  PROCEDURE EmployeeExperience(hiredate IN DATE, 
                               num_experience OUT BINARY_INTEGER) IS
  BEGIN
    --
    -- Call EmpExp by wrapping a to_char with a format mask on the hiredate
    --
    EmpExp(to_char(hiredate, 'DD-MM-YY'), num_experience);
  END EmployeeExperience;


  FUNCTION CheckEmpName(old_ename IN OUT VARCHAR2,
                        new_ename IN VARCHAR2) RETURN BINARY_INTEGER 
  IS EXTERNAL
    NAME "CheckEmpName" LIBRARY demolib 
    WITH CONTEXT
    PARAMETERS (old_ename        STRING,
                old_ename MAXLEN SB4,
                new_ename        STRING, 
                new_ename LENGTH SB4,
                CONTEXT,
                RETURN           INT);
  

  PROCEDURE Demo_Procedure is
    rowid_t       CHAR(18);
    ename_t       VARCHAR2(20);
    job_t         VARCHAR2(20);
    sal_t         NUMBER;
    comm_t        FLOAT;
    PreComm_t     FLOAT;
    PreComm_tmp   DOUBLE PRECISION;
    eno_t         NUMBER;
    hire_date     DATE;
    num_exp_c     BINARY_INTEGER;
    num_exp_plsql BINARY_INTEGER;
  
    old_ename     emp.ename%TYPE; 
    retval        number;
  
  begin

    -- Get rowid for SMITH.
    SELECT rowid 
      INTO rowid_t 
    FROM emp
    WHERE ename = 'SMITH' FOR UPDATE;

    -- Update the salary by passing the rowid.
    demopack.UpdateSalary(rowid_t);
    
    -- Calculate the Percent Commission for ALLEN. 
    SELECT ename, job, sal, comm, demopack.PercentComm(sal, comm) 
      INTO ename_t, job_t, sal_t, comm_t, PreComm_t 
    FROM emp 
    WHERE ename = 'ALLEN';

    dbms_output.new_line;
    dbms_output.put_line ('  ENAME      : ' || ename_t);
    dbms_output.put_line ('  JOB        : ' || job_t);
    dbms_output.put_line ('  SALARY     : ' || sal_t);
    dbms_output.put_line ('  COMMISSION : ' || comm_t);
    dbms_output.put_line ('  Percent Commission : ' || PreComm_t);
    
    -- Calculate the Percent Commission for MARTIN. 
    SELECT ename, job, sal, comm, demopack.PercentComm_ByRef(sal, comm) 
      INTO ename_t, job_t, sal_t, comm_t, PreComm_tmp
    FROM emp 
    WHERE ename = 'MARTIN';

    dbms_output.new_line;
    dbms_output.put_line ('  ENAME      : ' || ename_t);
    dbms_output.put_line ('  JOB        : ' || job_t);
    dbms_output.put_line ('  SALARY     : ' || sal_t);
    dbms_output.put_line ('  COMMISSION : ' || comm_t);
    dbms_output.put_line ('  Percent Commission : ' || PreComm_tmp);
    

    -- Check if the employee name fits in the ENAME column.
    SELECT ename 
      INTO old_ename 
    FROM emp 
    WHERE ename = 'SMITH';

    retval := CheckEmpName(old_ename, 'ANIL');

    dbms_output.new_line;
    dbms_output.put_line ('  Return value from CheckEmpName : ' || retval);
    dbms_output.put_line ('  old_ename value on return      : ' || old_ename);
    
    -- Find the number of years of experience of an employee.
    SELECT empno, hiredate 
      INTO eno_t, hire_date
    FROM emp 
    WHERE ename ='SMITH';

    EmployeeExperience(hire_date, num_exp_c);

    SELECT (sysdate-hire_date) 
      INTO num_exp_plsql
    FROM emp
    WHERE ename = 'SMITH';

    dbms_output.new_line;
    dbms_output.put_line ('  ENAME      : ' || eno_t);
    dbms_output.put_line ('  HIREDATE   : ' || hire_date);
    if num_exp_c != num_exp_plsql then
        dbms_output.put_line ('  Employee Experience Test Passed.');
    else
        dbms_output.put_line ('  Employee Experience Test Failed.');
    end if;

    dbms_output.new_line;
    dbms_output.put_line('***************************************');
    dbms_output.new_line;
    
    rollback;  -- Rolling back the changes made to the demo tables.

  END Demo_Procedure;

END demopack;
/
show errors

set serveroutput on

execute demopack.demo_procedure;
/

Rem    --------------------------------------------------
Rem
Rem  Example using Lobs in External Procedures.
Rem

Rem Create table to hold lob data.
DROP TABLE lobtab;
CREATE TABLE lobtab (
       id       number,
       clobcol  clob,
       blobcol  blob,
       nclobcol nclob
);

Rem Insert some rows into lobtab table.
INSERT INTO lobtab VALUES (
               1,
               'Just trying to insert some data into a CLOB column',
               'AAAABBBBCCCCDDDDEEEEFFFF111122223333444455556666',
               N'Just trying to insert some data into a NCLOB column'
);

INSERT INTO lobtab VALUES (
               2,
               empty_clob(),
               empty_blob(),
               empty_clob()
);

INSERT INTO lobtab VALUES (
               3,
               NULL,
               NULL,
               NULL
);
COMMIT;

Rem Create external procedure for CLOB demo.
CREATE OR REPLACE FUNCTION clob_demo
  ( lob_in IN CLOB, 
    lob_inout IN OUT CLOB, 
    lob_out OUT CLOB
  ) RETURN CLOB
IS EXTERNAL
NAME "LobDemo"
LIBRARY demolib
WITH CONTEXT
PARAMETERS
(
  context,
  lob_in,
  lob_inout,
  lob_out,
  lob_in    INDICATOR SB4,
  lob_inout INDICATOR SB4,
  lob_out   INDICATOR SB4,
  RETURN    INDICATOR SB4
);
/
show errors;


Rem Create external procedure for BLOB demo.
CREATE OR REPLACE FUNCTION blob_demo
  ( lob_in IN BLOB, 
    lob_inout IN OUT BLOB, 
    lob_out OUT BLOB
  ) RETURN BLOB
IS EXTERNAL
NAME "LobDemo"
LIBRARY demolib
WITH CONTEXT
PARAMETERS
(
  context,
  lob_in,
  lob_inout,
  lob_out,
  lob_in    INDICATOR SB4,
  lob_inout INDICATOR SB4,
  lob_out   INDICATOR SB4,
  RETURN    INDICATOR SB4
);
/
show errors;

Rem Create external procedure for NCLOB demo.
CREATE OR REPLACE FUNCTION nclob_demo
  ( lob_in IN NCLOB, 
    lob_inout IN OUT NCLOB, 
    lob_out OUT NCLOB
  ) RETURN NCLOB
IS EXTERNAL
NAME "LobDemo"
LIBRARY demolib
WITH CONTEXT
PARAMETERS
(
  context,
  lob_in,
  lob_inout,
  lob_out,
  lob_in    INDICATOR SB4,
  lob_inout INDICATOR SB4,
  lob_out   INDICATOR SB4,
  RETURN    INDICATOR SB4
);
/
show errors;

CREATE OR REPLACE PROCEDURE run_lob_demo IS
  clob_in  CLOB;   clob_inout  CLOB;   clob_out  CLOB;   clob_ret  CLOB;
  blob_in  BLOB;   blob_inout  BLOB;   blob_out  BLOB;   blob_ret  BLOB;
  nclob_in NCLOB;  nclob_inout NCLOB;  nclob_out NCLOB;  nclob_ret NCLOB;
begin

  -- Execute CLOB Demo.
  begin
     -- Fetch CLOB data from the database.
     select clobcol into clob_in from lobtab where id = 1 for update;
     select clobcol into clob_inout from lobtab where id = 2 for update;
     select clobcol into clob_out from lobtab where id = 3 for update;

     dbms_output.put_line('Before executing clob_demo.');
     dbms_output.put_line('clob_in : ' || dbms_lob.getlength(clob_in));
     dbms_output.put_line('clob_inout : ' || dbms_lob.getlength(clob_inout));
     dbms_output.put_line('clob_out : ' || dbms_lob.getlength(clob_out));
     dbms_output.put_line('clob_ret : ' || dbms_lob.getlength(clob_ret));

     -- Call external procedure clob_demo.
     clob_ret  :=  clob_demo(clob_in, clob_inout, clob_out);

     dbms_output.new_line;
     dbms_output.put_line('---------------------------------------');
     dbms_output.new_line;
     dbms_output.put_line('After executing clob_demo.');
     dbms_output.put_line('clob_in : ' || dbms_lob.getlength(clob_in));
     dbms_output.put_line('clob_inout : ' || dbms_lob.getlength(clob_inout));
     dbms_output.put_line('clob_out : ' || dbms_lob.getlength(clob_out));
     dbms_output.put_line('clob_ret : ' || dbms_lob.getlength(clob_ret));

     dbms_output.put_line('---------------------------------------');
     dbms_output.new_line;
  exception when others 
     then 
       dbms_output.put_line('SQL Error: ' || sqlerrm);
  end;

  -- Execute BLOB Demo.
  begin
     -- Fetch BLOB data from the database.
     select blobcol into blob_in from lobtab where id = 1;
     select blobcol into blob_inout from lobtab where id = 2 for update;
     select blobcol into blob_out from lobtab where id = 3 for update;

     dbms_output.put_line('Before executing blob_demo.');
     dbms_output.put_line('blob_in : ' || dbms_lob.getlength(blob_in));
     dbms_output.put_line('blob_inout : ' || dbms_lob.getlength(blob_inout));
     dbms_output.put_line('blob_out : ' || dbms_lob.getlength(blob_out));
     dbms_output.put_line('blob_ret : ' || dbms_lob.getlength(blob_ret));

     -- Call external procedure blob_demo.
     blob_ret  :=  blob_demo(blob_in, blob_inout, blob_out);

     dbms_output.put_line('After executing blob_demo.');
     dbms_output.put_line('blob_in : ' || dbms_lob.getlength(blob_in));
     dbms_output.put_line('blob_inout : ' || dbms_lob.getlength(blob_inout));
     dbms_output.put_line('blob_out : ' || dbms_lob.getlength(blob_out));
     dbms_output.put_line('blob_ret : ' || dbms_lob.getlength(blob_ret));

     dbms_output.put_line('---------------------------------------');
     dbms_output.new_line;
  exception when others 
     then 
       dbms_output.put_line('SQL Error: ' || sqlerrm);
  end;

  -- Execute NCLOB Demo.
  begin
     -- Fetch NCLOB data from the database.
     select nclobcol into nclob_in from lobtab where id = 1;
     select nclobcol into nclob_inout from lobtab where id = 2 for update;
     select nclobcol into nclob_out from lobtab where id = 3 for update;

     dbms_output.put_line('Before executing nclob_demo.');
     dbms_output.put_line('nclob_in : ' || dbms_lob.getlength(nclob_in));
     dbms_output.put_line('nclob_inout : ' || dbms_lob.getlength(nclob_inout));
     dbms_output.put_line('nclob_out : ' || dbms_lob.getlength(nclob_out));
     dbms_output.put_line('nclob_ret : ' || dbms_lob.getlength(nclob_ret));

     -- Call external procedure nclob_demo.
     nclob_ret  :=  nclob_demo(nclob_in, nclob_inout, nclob_out);

     dbms_output.put_line('After executing nclob_demo.');
     dbms_output.put_line('nclob_in : ' || dbms_lob.getlength(nclob_in));
     dbms_output.put_line('nclob_inout : ' || dbms_lob.getlength(nclob_inout));
     dbms_output.put_line('nclob_out : ' || dbms_lob.getlength(nclob_out));
     dbms_output.put_line('nclob_ret : ' || dbms_lob.getlength(nclob_ret));

     dbms_output.put_line('***************************************');
     dbms_output.new_line;
  exception when others 
     then 
       dbms_output.put_line('SQL Error: ' || sqlerrm);
  end;

exception when others 
     then dbms_output.put_line('SQL Error: ' || sqlerrm);
end;
/
show errors

execute run_lob_demo;
/
