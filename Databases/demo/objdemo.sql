REM
REM header: objdemo.sql
REM
Rem Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation
Rem NAME
Rem    OBJDEMO.SQL
Rem  FUNCTION
Rem    Demo program based on the banking application which explains
Rem    PL/SQL Object Types,Collections and Records features.
Rem
Rem  REQUIREMENTS
Rem
Rem   o ORACLE database user SCOTT exists with required demo tables  
Rem   
Rem   o Run exampbld.sql before running this for creating the schema.
Rem
Rem   o Package DBMS_OUTPUT is installed for the database.
Rem
Rem  NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem   o Use SVRMGRL for running this demo program
Rem       (o   It won't work with SQLPLUS)
Rem   o Connect as SCOTT/TIGER and run objdemo.sql 
Rem   
Rem     CONNECT SCOTT/TIGER 
Rem     @objdemo.sql
Rem
Rem  MODIFIED
Rem     jmuller    06/01/99 - Fix bug 708690: TAB -> blank
Rem     nmantrav   04/19/99 - to fix buffer overflow.
Rem     sabburi    06/15/98 - create schema -> exampbld.sql
Rem     anataraj   12/19/97 - merging from 804
Rem     mahsubra.in    09/19/97 - CREATION
Rem
/*
** ##############################################################
**
**                  DESCRIPTION OF DEMO EXAMPLE
**
** ##############################################################
** This following banking example illustrates the PL/SQL object features in 
** 8.0 PL/SQL. 
**  
** In this example, the following services are available, namely,
**    - Account opening.
**    - Deposit.
**    - Withdrawal.
**    - Account closing.
**    - Current Balance Query
**    - Verify Account
**  
** In this example we make the following assumptions: 
** 
** 1) A customer can have the following types of accounts: 
**    a) Account_Type_1
**    b) Account_Type_2
**    c) Account_Type_3
** 
**    The facilities offered by each account is given below:
**  
** 2) The customer can have a single account or multiple accounts.  
**    For e.g  
**    A customer can have a account of Account_type_1 only  
**    or  
**    an account of Account_type_1 and an account of Account_type_2 
**    or  
**    an account of Account_type_1,account of Account_type_2 ,account of 
**    Account_type_3. 
**  
**  
** 3) The account number for each type of account will be different. i.e, 
**    If a customer has an account of Account_type_1 and an account of type
**    Account_type_2, the account number for the Account_type_1 account 
**    will be different from the account number of the Account_type_2. 
**  
** 4) Description of account types 
**    a) Account_Type_1 
**       1) Minimum balance is 250. While opening the account, the customer 
**          has to deposit this amount. 
**       2) Withdrawals will not be allowed if the minimum balance goes  
**          below 250. 
**       3) At the time of closing the account, the balance 
**          will be paid to the customer. 
**     
**    b) Account_Type_2 
**       1) No restrictions on minimum balance.  But it should not go below  
**          0 or -ve.
**
**    c) Account_Type_3
**
**       1) At the time OF Closing the account, the customer will pay 
**          the balance
**     
**  
** ##############################################################
**
**                OBJECT TYPES AND THEIR RELATIONSHIP 
**
** ##############################################################
**
**                customer   
**                 /   \     
**                /     \    
**               /       |
**           person    account
**            /        || | | 
**           /        /  \ \ \___________________________
**        address    /    \ \                            \
**                  |      \ \_______________             \
**                  |       \                \             \
**                  |        \                \             \
**                  |         \                \             \
**                  |          \                \             \
**          v_account_type  account_type_1  account_type_2  account_type_3
**                              (REF)          (REF)          (REF)
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
         
set echo off

CREATE OR REPLACE PROCEDURE run_objdemo is
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

  -- opening procedure.

  DBMS_OUTPUT.PUT_LINE('--- Opening an account for James ---');

  l_o_account := o_account(NULL,v_account_type(NULL),NULL,NULL,NULL);
  l_name := 'James';
  l_date := to_date('20-AUG-77','dd-MON-yy');
  l_gender := 'M';
  l_address := o_address('A1234','SanthomeStreet','Redwood Shores','California',
        '94065'); 
  
  l_ssn := 'A1234';
  l_account_type := 'AT1';
  l_amount := 500;
  

  DBMS_OUTPUT.PUT_LINE('--- Opening an account of type AT1 for James ---'); 

  l_actnum1 := l_o_account.open_account(l_ssn,l_account_type,l_amount,
            l_name,l_date,l_gender,l_address); 
  DBMS_OUTPUT.PUT_LINE('');
    
  l_ssn := 'A1234';
  l_account_type := 'AT2';
  l_amount := 500;

  DBMS_OUTPUT.PUT_LINE('--- Opening an account of type AT2 for James --- '); 

  l_actnum2 := l_o_account.open_account(l_ssn,l_account_type,l_amount,
                null,null,null,null); 
 
  DBMS_OUTPUT.PUT_LINE('');

  l_ssn := 'A1234';
  l_account_type := 'AT3';
  l_amount := 500;

  DBMS_OUTPUT.PUT_LINE('---  Opening an account of type AT3 for James ---'); 

  l_actnum3 := l_o_account.open_account(l_ssn,l_account_type,l_amount,
            null,null,null,null); 
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Deposit 1000 to James account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,1000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Deposit 4000 to James account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,4000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Deposit 2000 to James account- AT2 ----'); 

  l_o_account.deposit_amount(l_actnum2,2000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Withdraw 500 from James account- in AT2 ---');

  l_o_account.withdraw_amount(l_actnum2,500);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Withdraw 1500 from James account- in AT1 ---');

  l_o_account.withdraw_amount(l_actnum1,1500);
  DBMS_OUTPUT.PUT_LINE('');
 

  DBMS_OUTPUT.PUT_LINE('---  Deposit 2500 to James account- AT1 ----'); 

  l_o_account.deposit_amount(l_actnum1,2500);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Withdraw 1500 from James account- in AT3 ---');

  l_o_account.withdraw_amount(l_actnum3,1500);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Withdraw 1750 from James account- in AT1 ---');

  l_o_account.withdraw_amount(l_actnum1,1750);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---Query for the current balance in James account---'); 
  l_o_account.current_balance(l_actnum1);

  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--Query the transaction details of James-----');

  l_o_account.trans_details(l_ssn);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('--- Closing the account for James ---'); 
  l_o_account.close_account(l_actnum1);
  DBMS_OUTPUT.PUT_LINE('');

  l_name := 'John';
  l_date := to_date('20-AUG-78','dd-MON-yy');
  l_gender := 'M';
  l_address := o_address('B7896','Concurse Drive','Belmont','California',
                 '94065'); 
  
  l_ssn := 'B7896';
  l_account_type := 'AT2';
  l_amount := 2000;

  DBMS_OUTPUT.PUT_LINE('--- Opening an account of type AT1 for John ---'); 

  l_actnum1 := l_o_account.open_account(l_ssn,l_account_type,l_amount,
                  l_name,l_date,l_gender,l_address); 

  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Withdrawing from John account ---'); 

  l_o_account.withdraw_amount(l_actnum1,1000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('---  Depositing 3000 in John account ---'); 

  l_o_account.deposit_amount(l_actnum1,3000);
  DBMS_OUTPUT.PUT_LINE('');

  DBMS_OUTPUT.PUT_LINE('----Details for John----');
  l_o_account.trans_details('B7896');

END;
/
show errors

spool dm024.lis

set serveroutput on size 10000

EXECUTE run_objdemo;

spool off
