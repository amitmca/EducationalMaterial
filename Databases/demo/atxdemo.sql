Rem
Rem atxdemo.sql
Rem
Rem  Copyright (c) Oracle Corporation 1998, 1999. All Rights Reserved.
Rem
Rem  NAME
Rem    atxdemo.sql - Demo program for Autonomous Transactions, RDBMS, 8.1
Rem
Rem
Rem  FUNCTION
Rem     
Rem     The Demo Program illustrates the use of Autonomous Transactions.
Rem
Rem     An Autonomous Transaction allows you to step out of the context of the
Rem     calling transaction (which is main transaction) , perform some SQL
Rem     operations (in new context which is autonomous transaction's context),
Rem     commit or rollback those operations and then return to the calling
Rem     transaction's (main transaction's) context without losing the work 
Rem     done earlier in the main transaction.
Rem    
Rem
Rem  NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem    1) Use svrmgrl for running this demo program
Rem  
Rem    2) Connect to oracle and run atxdemo.sql
Rem
Rem    3) The result is printed in file atxdemo.lis
Rem

/*
** ##########################################################################
**
**          DESCRIPTION OF DEMO EXAMPLE
**
** ##########################################################################
**
** The Demo Example illustrates the use of Autonomous Transactions introduced
** in 8.1 
**
** Assumptions made :
** ------------------
** 1) In a bank, a customer can initiate a withdrawal request.
**
** 2) Withdrawal is allowed, only if balance  > $500, after withdrawal.
**
** Scenario :
** ----------
** 1) A customer issues a transaction request(withdrawal). Before the request
**    is processed, the request gets a unique transaction_id.
**
** 2) The status of each transaction is recorded alongwith appropriate message.
**    The Status can be one of the following.
**       a) 'S' - Processing of transaction started
**       b) 'W' - Withdrawal Successful
**       c) 'R' - Request Rejected
**
** 3) Depending on the Balance conditions, the customer initiated transaction
**    gets completed successfully or aborted.
**
** Main Transaction :
** --------------------
** 1. Update Balance in account_info table .
**
** 2. Initiate the autonomous transaction C1. C1 in turn calls another  
**    autonomous transaction C2.
**
** 3. Check validity of the transaction request.
**
** 4. Initiate the autonomous transaction C3. 
**
** 5. Depending on the validity/correctness of request, commit or rollback the
**    main transaction.
**
** Procedure process_withdrawal is executed as main transaction.
**
** Autonomous Transactions :
** -------------------------
** C1.  Insert the request details like Account_no, Cheque_no, amount and 
**      Unique Transaction id into transaction_log table and commit.
**      Also set status of the transaction to 'S' which represents that 
**      processing of the request has started.
**      Procedure log_transaction is executed as Autonomous Transaction to 
**      perform above mentioned operations .
**
** C2. To Generate Unique Transaction Id, this Autonomous Transaction is 
**     called from C1. C2 uses trans_counter table for generating Unique 
**     Transaction Id. Function get_next_trans_id in Package generate_next_id
**     is used to generate next unique transaction id. This also demonstrates
**     calling Autonomous Blocks from SQL contexts.
**
** C3. Update status and message in transaction_log table and commit. The 
**     procedure update_transaction_status is invoked as an Autonomous 
**     Transaction to perform above task.
*/

/*
** #########################################################################
**
**               CODING  STYLE  USED
**
** #########################################################################
**
**    1. Uppercase is used for PL/SQL keywords and lower case for defined 
**       items.
**
**    2. Names for local variables are Prefixed with l_ 
**
*
*/


SET SERVEROUTPUT ON
SPOOL dm029.dbg

/*--------------------------------------------------------------------------*/
/*         Table for storing information about all accounts in a bank       */
/*--------------------------------------------------------------------------*/

CREATE TABLE account_info (
         Customer_Id    Varchar2(10),
         Account_no     Varchar2(10),
         Balance        Number(10,2)
            )
/
 
/*--------------------------------------------------------------------------*/
/*Table for storing information related to customer initiated transactions */
/*-------------------------------------------------------------------------*/

CREATE TABLE transaction_log (
         Transaction_Id      Varchar2(10),
         Account_no          Varchar2(10),
         Cheque_no           Varchar2(10),
         Amount              Number(10,2),
         Transaction_type    Char(1),
         Transaction_Date    Date,
         Transaction_Status  Char(1),
         Message             Varchar2(50) 
                       )
/

/*-------------------------------------------------------------------------*/
/*Table storing number which is equal to latest transaction_id generated + 1*/ 
/*         Note that this table is one row, one column table                */
/*-------------------------------------------------------------------------*/

CREATE TABLE trans_counter (
        trans_id     NUMBER(8)
            )
/

/*------------------------------------------------------------------------*/
/*    Create a package where function to get next transaction id resides   */
/*    This function namely, get_next_trans_id demonstrates calling         */
/*    Autonomous Transactions From SQL Context                             */
/*    Even though the Package specifies WNDS and RNDS restrictions on      */
/*    function get_next_txn_id, because the function is executed as        */
/*    Autonomous Transaction, the update and commit  is allowed within     */
/*    the function.                                                        */
/* ----------------------------------------------------------------------- */

CREATE OR REPLACE PACKAGE generate_next_id IS
    FUNCTION  get_next_txn_id   RETURN NUMBER;
      PRAGMA RESTRICT_REFERENCES(get_next_txn_id, WNDS, RNDS);
END generate_next_id;
/
SHOW ERRORS


/*------------------------------------------------------------------------*/
/*        Define Body Of the package                                     */
/*------------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE BODY generate_next_id IS

  FUNCTION get_next_txn_id
  RETURN NUMBER
  IS
         PRAGMA AUTONOMOUS_TRANSACTION;-- Specifying Autonomous Transaction
         l_trans_id NUMBER(8);
  BEGIN
         SELECT trans_id INTO l_trans_id FROM trans_counter;
         UPDATE trans_counter SET trans_id = trans_id + 1;
         COMMIT;
         RETURN (l_trans_id);
  EXCEPTION
    /* If no data present in trans_counter then initialize counter */

    WHEN NO_DATA_FOUND THEN
          INSERT INTO trans_counter VALUES(2);
          COMMIT;
          RETURN(1);
  END get_next_txn_id;

END generate_next_id;
/
SHOW ERRORS
   

/*--------------------------------------------------------------------------*/
/*   Procedure which logs details for each and every transaction into       */
/*   Transaction_log table. The parameters to this procedure are Account_no */
/*   Cheque_no, transaction amount and type of transaction.                 */
/*   The Transaction type can be 'W' - For Withdrawal.                      */
/*   The Procedure executes as an Autonomous Transaction and hence the      */
/*   Commit operation does not the commit the work done in Main             */
/*   Transaction. Also the autonomous transaction is totally independent of */
/*   main Transaction.                                                      */
/*--------------------------------------------------------------------------*/
CREATE OR REPLACE PROCEDURE log_transaction(Account_Id  Varchar2,
    Cheque_no  Varchar2, Amount Number,Trans_type Char)
IS
   pragma AUTONOMOUS_TRANSACTION;-- Specifying Autonomous Transaction
Begin
   INSERT INTO transaction_log VALUES(generate_next_id.get_next_txn_id,
       Account_id, Cheque_no, Amount, Trans_type,SYSDATE,'S',
        'Started Processing Transaction');
   COMMIT;
End log_transaction;
/
SHOW ERRORS


/*------------------------------------------------------------------------  */
/*   Procedure which updates the status and message details of the          */
/*   transaction. Parameters to this procedure are Account_no, Status       */
/*   of transaction and message to be updated.                              */
/*   Account_no is passed to uniquely identify the transaction log record.  */ 
/*    The Procedure executes as an Autonomous Transaction and hence the     */
/*   Commit operation doesnot the commit the work done in Main              */
/*   Transaction. Also the autonomous transaction is totally independent of */
/*   main Transaction.                                                      */
/*--------------------------------------------------------------------------*/
CREATE OR REPLACE PROCEDURE update_transaction_status(Account_Id  Varchar2,
    Status Char, Mesg VARCHAR2)
IS
   pragma AUTONOMOUS_TRANSACTION;-- Specify Autonomous Transaction
Begin
   UPDATE transaction_log SET Transaction_status = status, Message = mesg
   WHERE ( Account_no = Account_Id ) AND ( Transaction_Status = 'S');
   COMMIT;
End update_transaction_status;
/     
SHOW ERRORS

/*------------------------------------------------------------------------ */
/*    Procedure which processes a particular withdrawal.                   */
/*    Parameters to this procedure are Account Number, Cheque Number &     */
/*    amount of transaction.                                               */
/*    This procedure in turn calls two Autonomous Transactions to          */
/*    perform logging transaction details and status,message updating      */
/*    Main Transaction is rolled back if the initiated request             */
/*    can not be executed.This happens if Balance after withdrawal         */
/*    goes below $500. But the log record for this transaction gets        */
/*    commited into Transaction_log table with appropriate message         */
/*    This procedure assumes that account_id exists and amount is positive.*/
/* ---------------------------------------------------------------------- */

CREATE OR REPLACE PROCEDURE process_withdrawal(Account_Id Varchar2,
    Cheque_No Varchar2, Amount Number)
IS
    l_balance  NUMBER(10,2);
BEGIN

    /* ----------- Update Balance -------------------------------------*/
    UPDATE Account_Info SET BALANCE = BALANCE - Amount
    WHERE Account_no = Account_Id;

    /* Call Autonomous Transaction to record transaction details ------*/
    log_transaction(Account_Id, Cheque_no, Amount,'W');

    /* Check Validity of initiated Transaction ------------------------*/
    SELECT BALANCE INTO l_balance FROM Account_Info WHERE 
    Account_no = Account_Id;

    If l_Balance < 500 Then
        /* Not Valid Request. Call Autonomous Transaction to Update ----*/
        /* transaction log record And Rollback Main Transaction --------*/

        update_transaction_status(Account_Id,'R',
           'Balance Goes Below $500.Txn Rejected');
        ROLLBACK;
    Else
        /* Valid Request. Call Autonomous Transaction to Update ----*/
        /* transaction log record And Commit Main Transaction ------*/

        update_transaction_status(Account_Id,'W','Withdrawal Successful');
        COMMIT;
    End If;
END process_withdrawal;
/
SHOW ERRORS

/*------------------------------------------------------------------------ */
/*       Display Cust Id,Account and Balance Information                   */
/*------------------------------------------------------------------------ */

CREATE OR REPLACE PROCEDURE print_acct_balance 
IS
    CURSOR l_c1 IS 
         SELECT customer_id,account_no,balance 
         FROM account_info;
    l_customer_id  VARCHAR2(10);
    l_account_no   VARCHAR2(10);
    l_balance      NUMBER(10,2);
BEGIN
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
     DBMS_OUTPUT.PUT_LINE('  Account No        Cust Id           Balance');
     DBMS_OUTPUT.PUT_LINE('                                    ( Dollars )');
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
     OPEN l_c1;
     LOOP
         FETCH l_c1 INTO l_customer_id,l_account_no,l_balance;
         If (l_c1%NOTFOUND) Then
            EXIT;
         End if;
         DBMS_OUTPUT.PUT_LINE('  '||l_account_no||'            '||
            l_customer_id || '              ' || l_balance);
     END LOOP;
     CLOSE l_c1;
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
END print_acct_balance;
/
SHOW ERRORS

/*------------------------------------------------------------------------ */
/*     Display Transaction Log Records and Balance Information.            */
/*------------------------------------------------------------------------ */

CREATE OR REPLACE PROCEDURE print_transaction_log 
IS
    CURSOR l_c1 IS 
         SELECT account_no,amount,Transaction_status, 
         message FROM transaction_log order by account_no asc;
    l_account_no   VARCHAR2(10);
    l_amount      NUMBER(10,2);
    l_trans_status CHAR(1);
    l_message    VARCHAR2(50);
    l_customer_id    VARCHAR2(10);
    l_balance    NUMBER(10,2);
BEGIN
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
     DBMS_OUTPUT.PUT_LINE(' Account  Cust  Requested  Status  Balance'||
     '        Message  '); 
     DBMS_OUTPUT.PUT_LINE('  No      Id    Amount     Of Txn (Dollars)');
     DBMS_OUTPUT.PUT_LINE('                (Dollars)  ');
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
     OPEN l_c1;
     LOOP
         FETCH l_c1 INTO l_account_no,l_amount,l_trans_status,l_message;
         If (l_c1%NOTFOUND) Then
            EXIT;
         End if;
         SELECT customer_id,balance INTO l_customer_id,l_balance  
         FROM account_info WHERE account_no = l_account_no;
         DBMS_OUTPUT.PUT_LINE(RTRIM(l_account_no)||'  '||
            RTRIM(l_customer_id)||'   '||RTRIM(l_amount)||'       '|| 
            RTRIM(l_trans_status) ||'     '|| l_balance ||'    '||
            RTRIM(l_message));
     END LOOP;
     CLOSE l_c1;
     DBMS_OUTPUT.PUT('--------------------------------------------------');
     DBMS_OUTPUT.PUT_LINE('---------------------------');
END print_transaction_log;
/
SHOW ERRORS

/*------------------------------------------------------------------------ */
/*                            Create some accounts.                        */
/*------------------------------------------------------------------------ */

CREATE OR REPLACE PROCEDURE create_accounts
IS
BEGIN
      INSERT INTO account_info VALUES('CST001','ACT001',1200);
      INSERT INTO account_info VALUES('CST002','ACT002',5200);
      INSERT INTO account_info VALUES('CST003','ACT003',4750);
      INSERT INTO account_info VALUES('CST004','ACT004',1750);
      COMMIT;
END Create_accounts;   
/
SHOW ERRORS
SPOOL OFF

SPOOL dm029.lis

/* ------------- Main Execution Begins Here ------------------------------ */
BEGIN
  /* ------------------ Create Accounts ---------------------------------- */
  Create_accounts;

  /* ------ Display account information before withdrawal transactions ---*/
  DBMS_OUTPUT.NEW_LINE();
  DBMS_OUTPUT.PUT_LINE('Account Information Before WithDrawal Transactions :');
  print_acct_balance;

  /* ------ Process some withdrawal transactions ------------------------ */
  process_withdrawal('ACT001','CHQ001',1000);
  DBMS_OUTPUT.NEW_LINE();
  process_withdrawal('ACT003','CHQ002',3000);
  process_withdrawal('ACT004','CHQ003',1300);
  process_withdrawal('ACT002','CHQ004',1000);
  DBMS_OUTPUT.NEW_LINE();

  /* Display transaction log and Balance Information after withdrawal     */
  /* transactions                                                         */
  DBMS_OUTPUT.PUT_LINE('Transaction log and Balance Information after With'||
  'drawal Transactions :');

  print_transaction_log;
END;
/
SPOOL OFF

/*--- Clean Up ------- */
DROP TABLE account_info
/
DROP TABLE transaction_log 
/
DROP TABLE trans_counter 
/
DROP PACKAGE generate_next_id 
/
DROP PROCEDURE print_acct_balance
/
DROP PROCEDURE print_transaction_log
/
