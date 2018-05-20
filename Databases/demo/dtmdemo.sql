Rem
Rem $Header: dtmdemo.sql 09-jul-2001.13:14:54 cbarclay Exp $
Rem
Rem dtmdemo.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      dtmdemo.sql - <one-line expansion of the name>
Rem
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    cbarclay    07/09/01 - 9.0.1.1_backport_of_dm033_nt_lrg_test_fix
Rem    cbarclay    04/30/01 - Merged cbarclay_demos_for_datetime_and_overriding
Rem    cbarclay    04/30/01 - 
Rem    cbarclay    04/30/01 - 
Rem    cbarclay    04/26/01 - Created
REM    
REM    
REM   
REM    To run this first run exampbld.sql then objdemo.sql
REM    These are required for this simple datetime demo.
REM    Other examples of expressions are in exampbld.sql

SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 80
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
  
ALTER session SET time_zone = 'US/Pacific';  
  
REM Create a few useful cursors and a function using datetime features.
  
CREATE OR replace FUNCTION 
    last_week(t TIMESTAMP WITH TIME zone) RETURN VARCHAR2
IS 
BEGIN
   IF ( t > ( current_timestamp  - interval '7' day ) AND 
        t <= current_timestamp )  
   THEN RETURN 'TRUE';
   ELSE RETURN 'FALSE';
   END IF;
END;
/

show errors;
/


CREATE OR replace PACKAGE toolbox IS 
   -- Tells us which accounts were accessed locally
   cursor accounts_accessed_locally IS 
     SELECT DISTINCT(account_num) 
       FROM transaction_tab 
       WHERE extract(timezone_region FROM transaction_date) = 'US/Pacific';
          
   cursor last_weeks_opened_accounts IS 
     SELECT extract(day FROM transaction_date) day,
            extract(month FROM transaction_date) month, 
            account_num
       FROM transaction_tab 
       WHERE transaction_type = 'O' AND 
             last_week(transaction_date) = 'TRUE';
     
END;
/

show errors;

SET ECHO ON
  
SELECT DISTINCT(account_num) 
       FROM transaction_tab 
       WHERE extract(timezone_region FROM transaction_date) = 'US/Pacific';
     
     
SELECT extract(day FROM transaction_date) day,
       extract(month FROM transaction_date) month, 
       account_num
  FROM transaction_tab 
  WHERE transaction_type = 'O' AND 
        last_week(transaction_date) = 'TRUE';

