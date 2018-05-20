Rem $Header: methdisp.sql 15-may-2001.10:22:57 rchennoj Exp $
Rem
Rem methdisp.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      methdisp.sql - <one-line expansion of the name>
Rem
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    rchennoj    05/15/01 - Merged rchennoj_shiphome_driver_fix
Rem    cbarclay    04/30/01 - Merged cbarclay_demos_for_datetime_and_overriding
Rem    cbarclay    04/30/01 - 
Rem    cbarclay    04/30/01 - 
Rem    cbarclay    04/26/01 - Created
Rem
REM    To run this first run exampbld.sql.
REM    These are required for this simple inheritence demo.
REM    Examples of further definitions and calls are in exampbld.sql
Rem    in o_student, o_account. 

SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 80
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO ON


Rem ##############################################################
Rem
Rem                  DESCRIPTION OF DEMO EXAMPLE
Rem
Rem ##############################################################
Rem This following banking example illustrates PL/SQL object inheritance 
Rem and overriding in 9i PL/SQL. 
    
  
set echo off

REM Sandra opens account IN a New York Branch.    
  
ALTER session SET time_zone = 'US/Eastern';

  
CREATE OR REPLACE PROCEDURE run_methdisp is
  l_address o_address;
  l_account_type VARCHAR2(5);
  l_o_account o_account;
  l_limit NUMBER;
  l_ssn VARCHAR2(10);
  l_amount NUMBER;
  l_name VARCHAR2(50);
  l_gender CHAR;
  l_date DATE;
  l_actnum1 INTEGER;
  l_actnum2 INTEGER;
  l_actnum3 INTEGER;
  l_actnum4 INTEGER;
  l_actnum5 INTEGER;
  l_actnum6 INTEGER;


BEGIN

   -- We open account for Sandra who is a Student (as we pass a school)
   -- which is a subtype inheriting from Person with overiding method display.
 
  DBMS_OUTPUT.PUT_LINE('--- Opening an account for Sandra ---');

  l_o_account := o_account(NULL,v_account_type(NULL),NULL,NULL,NULL);
  l_name := 'Sandra';
  l_date := to_date('22-AUG-78','dd-MON-yy');
  l_gender := 'F';
  l_address := 
    o_address('A1234','SanthomeStreet',
              'Redwood Shores','California', '94065'); 
  
  l_ssn := 'A1345';
  l_account_type := 'AT1';
  l_amount := 1500;
  

  DBMS_OUTPUT.PUT_line
    ('--- Opening an account of type AT1 for Student Sandra ---'); 
 
  l_actnum1 := l_o_account.open_account(l_ssn,l_account_type,l_amount,
            l_name,l_date,l_gender,l_address,'Berkeley'); 
  DBMS_OUTPUT.PUT_LINE('');
    
  l_ssn := 'A1345';
  l_account_type := 'AT1';
  l_amount := 500;
  DBMS_OUTPUT.PUT_LINE('---  Deposit 1000 to Sandra account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,1000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Deposit 4000 to Sandra account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,4000);
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('--- Withdraw 1500 from Sandra account- in AT1 ---');

  l_o_account.withdraw_amount(l_actnum1,1500);
  DBMS_OUTPUT.PUT_LINE('');
 
  DBMS_OUTPUT.PUT_LINE('---  Deposit 2500 to Sandra account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,2500);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Withdraw 1750 from Sandra account- in AT1 ---');

  l_o_account.withdraw_amount(l_actnum1,1750);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_line
    ('---Query for the current balance in Sandra account---'); 
  l_o_account.current_balance(l_actnum1);

  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--Query the transaction details of Sandra-----');

  l_o_account.trans_details(l_ssn);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Closing the account for Sandra ---'); 
  l_o_account.close_account(l_actnum1);
  DBMS_OUTPUT.PUT_LINE('');

END;
/


show errors;

set serveroutput on size 10000
  
SET echo ON
  
EXECUTE run_methdisp;
  
SET echo off
  
