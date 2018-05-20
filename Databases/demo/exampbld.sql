rem 
rem $Header: exampbld.sql 30-apr-2001.18:43:37 cbarclay Exp $ 
rem 
Rem  Copyright (c) 1991, 1997, 1998, 1999, 2000 by Oracle Corporation 
Rem    NAME
Rem      exampbld.sql - <one-line expansion of the name>
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem    RETURNS
Rem 
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem    MODIFIED   (MM/DD/YY)
Rem     cbarclay   04/30/01  - 
Rem     cbarclay   04/28/01  - add timestamp with time zone and student subtype
Rem     nmantrav   05/02/00 -  Use order by clause
Rem     jmuller    05/28/99 -  Fix bug 708690: TAB -> blank
Rem     nle        10/22/98 -  fix merging problem
Rem     nmantrav   08/10/98 -  dropping tables before types.
Rem     sabburi    06/15/98 -  create types for objects demo
Rem     sabburi    07/09/97 -  Updating compatibility flag.
Rem     gclossma   12/02/92 -  Creation 

spool exampbld.dbg

set compatibility V7
/
ALTER session SET time_zone = 'US/Pacific';
/
drop table accounts
/
create table accounts(
    account_id  number(4) not null,
    bal         number(11,2))
/
create unique index accounts_index on accounts (account_id)
/
drop table action
/
create table action(
    account_id  number(4) not null,
    oper_type   char(1) not null,
    new_value   number(11,2),
    status      char(45),
    time_tag    date not null)
/
drop table bins
/
create table bins(
    bin_num     number(2) not null,
    part_num    number(4),
    amt_in_bin  number(4))
/
drop table data_table
/
create table data_table(
    exper_num  number(2),
    n1         number(5),
    n2         number(5),
    n3         number(5))
/
drop table emp
/
create table emp(
    empno      number(4) not null,
    ename      varchar2(10),
    job        varchar2(9),
    mgr        number(4),
    hiredate   date,
    sal        number(7,2),
    comm       number(7,2),
    deptno     number(2))
/
drop table inventory
/
create table inventory(
    prod_id     number(5) not null,
    product     char(15),
    quantity    number(5))
/
drop table journal
/
create table journal(
    account_id   number(4) not null,
    action       char(45) not null,
    amount       number(11,2),
    date_tag     date not null)
/
drop table num1_tab
/
create table num1_tab(
    sequence   number(3) not null,
    num        number(4))
/
drop table num2_tab
/
create table num2_tab(
    sequence   number(3) not null,
    num        number(4))
/
drop table purchase_record
/
create table purchase_record(
    mesg        char(45),
    purch_date  date)
/
drop table ratio
/
create table ratio(
    sample_id  number(3) not null,
    ratio      number)
/
drop table result_table
/
create table result_table(
    sample_id  number(3) not null,
    x          number,
    y          number)
/
drop table sum_tab
/
create table sum_tab(
    sequence   number(3) not null,
    sum        number(5))
/
drop table temp
/
create table temp(
    num_col1   number(9,4),
    num_col2   number(9,4),
    char_col   char(55))
/
create or replace package personnel as
    type charArrayTyp is table of varchar2(10)
        index by binary_integer;
    type numArrayTyp is table of float
        index by binary_integer;
    procedure get_employees(
        dept_number in     integer,
        batch_size  in     integer,
        found       in out integer,
        done_fetch  out    integer,
        emp_name    out    charArrayTyp,
        job_title   out    charArrayTyp,
        salary      out    numArrayTyp);
end personnel;
/
create or replace package body personnel as
    cursor get_emp (dept_number integer) is
        select ename, job, sal from emp
            where deptno = dept_number order by ename;
    procedure get_employees(
        dept_number in     integer,
        batch_size  in     integer,
        found       in out integer,
        done_fetch  out    integer,
        emp_name    out    charArrayTyp,
        job_title   out    charArrayTyp,
        salary      out    numArrayTyp) is
    begin
        if not get_emp%isopen then
            open get_emp(dept_number);
        end if;
        done_fetch := 0;
        found := 0;
        for i in 1..batch_size loop
            fetch get_emp into emp_name(i),
                    job_title(i), salary(i);
            if get_emp%notfound then
                close get_emp;
                done_fetch := 1;
                exit;
            else
                found := found + 1;
            end if;
        end loop;
    end get_employees;
end personnel;
/

DROP TABLE ot_customer
/
DROP TABLE ot_account
/
DROP TABLE ot_account_type_1
/
DROP TABLE ot_account_type_2
/
DROP TABLE ot_account_type_3
/
DROP TABLE ot_person
/
DROP TABLE transaction_tab
/
DROP SEQUENCE acct_sequence
/

DROP TYPE o_customer
/
DROP TYPE o_account
/
DROP TYPE v_account_type
/
DROP TYPE o_account_type_1
/
DROP TYPE o_account_type_2
/
DROP TYPE o_account_type_3
/
DROP TYPE o_person
/
DROP TYPE o_address
/

/*
** ##############################################################
**
**                CREATION OF OBJECT TYPES and TABLES 
**
** ##############################################################
*/

/* Sequence is created to get unique account numbers for the
   different account types.
*/

CREATE SEQUENCE acct_sequence START WITH 123456 INCREMENT BY 1
/

/* A function to return blank spaces */
/* This is used in the generation of statement */

CREATE OR REPLACE FUNCTION sp(n IN INTEGER) RETURN VARCHAR2
AS
num INTEGER;
space VARCHAR2(80);
BEGIN
  space := '';
  FOR num IN 1..n 
  LOOP
    space := space||' ';
  END LOOP;
  RETURN space;
END;
/
show errors

/*
  Transaction table
  -----------------
  Table for maintaining the transactions.
*/

CREATE TABLE transaction_tab
(
  account_num INTEGER,
  transaction_date TIMESTAMP WITH TIME ZONE,
  transaction_amount NUMBER,
  balance NUMBER,
  transaction_type CHAR
)
/


/*
  Address type
  ------------
   This type is for storing the address of the customers
*/

CREATE OR REPLACE TYPE o_address AS OBJECT
(
  housenum VARCHAR2(10),
  street   VARCHAR2(15),
  city     VARCHAR2(20),
  country  VARCHAR2(20),
  zipcode  VARCHAR2(10),
  MEMBER procedure display
)
/
  
  
CREATE OR REPLACE TYPE BODY o_address AS 
  MEMBER procedure display IS
  BEGIN 
    -- Display the address details
    DBMS_OUTPUT.PUT_LINE('Address ');
    DBMS_OUTPUT.PUT_LINE('------- ');
    DBMS_OUTPUT.PUT_LINE('Housenum : '|| housenum);
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Street   : '|| street);
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('City     : '|| city);
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Country  : '|| country);
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Zipcode  : '|| zipcode);
    DBMS_OUTPUT.PUT_LINE('');
  END;
END;
/
  
/*
 Person type:
 -----------
   This type is for storing the person information.
*/


CREATE OR REPLACE TYPE o_person AS OBJECT
(
  ssn       VARCHAR2(15),
  name      VARCHAR2(50),
  birthdate DATE,
  gender    CHAR,
  address   o_address,
  MEMBER procedure display
) NOT FINAL
/
  
  
CREATE OR REPLACE TYPE BODY o_person AS 
  MEMBER procedure display IS 
  BEGIN 
    -- Display the persons details
    DBMS_OUTPUT.PUT_LINE('SSN      : '|| ssn);
    DBMS_OUTPUT.PUT_LINE('Name     : '|| name);
    DBMS_OUTPUT.PUT_LINE('Birthdate: '|| birthdate);
    DBMS_OUTPUT.PUT_LINE('');
    -- Display the address details 
    address.display;
  END;
  
END;
/

show errors;



/*
 Student type:
 -----------
   This type is for storing the extra student information.
*/


CREATE OR REPLACE TYPE o_student UNDER o_person
(
  school       VARCHAR2(50),
  length_of_enrollment INTERVAL YEAR TO MONTH,
  overriding MEMBER procedure display
)
/
  
  
CREATE OR REPLACE TYPE BODY o_student AS 
  overriding MEMBER procedure display IS 
  BEGIN 
    -- Display the persons details (from person class)
    DBMS_OUTPUT.PUT_LINE('SSN      : '|| ssn);
    DBMS_OUTPUT.PUT_LINE('Name     : '|| name);
    DBMS_OUTPUT.PUT_LINE('Birthdate: '|| birthdate);
    DBMS_OUTPUT.PUT_LINE('');
    -- Display the address details 
    address.display;
    -- Now output the student information
    DBMS_OUTPUT.PUT_LINE(
            name || ' enrolled for YEAR ' || 
            to_char(extract(year FROM length_of_enrollment)+1) ||
            ' of ' || school); 
  END;
  
END;
/

/* --------- Creating PERSON TABLE(ot_person) of o_person type -------- */

CREATE TABLE ot_person OF o_person
/

/*
 Account_type_1
  --------------
    This type has the information if the customer opens a account_type_1.
 */


CREATE or REPLACE TYPE o_account_type_1 AS OBJECT
(
  accountnum INTEGER,
  balance    NUMBER,

  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_1, amount IN NUMBER)
    RETURN o_account_type_1
)
/

/*  ---------- Create object table for account_type_1 --------- */

CREATE TABLE ot_account_type_1 OF o_account_type_1
/

CREATE or REPLACE TYPE BODY o_account_type_1 as
  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_1,amount IN NUMBER) 
    RETURN o_account_type_1 AS

  -- open account with initial deposit in account_type_1  account
  BEGIN
    IF NOT amount > 0 THEN  
      DBMS_OUTPUT.PUT_LINE('Bad amount entered');
      RETURN o_account_type_1(0,0);
    END IF;

    IF amount < 250 THEN
       DBMS_OUTPUT.PUT_line
         ('The minimum amount for accounttype1 should be 250');
      RETURN o_account_type_1(0,0);
      
    ELSE

     -- Generate account number
      SELECT acct_sequence.NEXTVAL INTO accountnum FROM DUAL;

     -- Insert customer details into account_type_1 table 
      INSERT INTO ot_account_type_1 VALUES(accountnum,amount);

      return o_account_type_1(accountnum,amount);

    END IF;

  END open_account;
END;
/
show errors

/*
 
Account_type_2 type:
---------------------
   This type has the information if the customer has a account_type_2.
*/


CREATE or REPLACE TYPE o_account_type_2 AS OBJECT
(
  accountnum INTEGER,
  balance    NUMBER,

  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_2, amount IN NUMBER) 
    RETURN INTEGER
)
/

/*  ---------- Create object table for account_type_2 --------- */

CREATE TABLE ot_account_type_2 OF o_account_type_2
/

CREATE or REPLACE TYPE BODY o_account_type_2 AS
  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_2, amount IN NUMBER) 
    RETURN INTEGER AS
  -- open account with initial deposit in account_type_2
  BEGIN
    IF amount <= 0 THEN  
      DBMS_OUTPUT.PUT_LINE('Bad amount entered');
      RETURN 0;
    END IF;

    -- Generate account number
    SELECT acct_sequence.NEXTVAL INTO accountnum FROM DUAL;

    -- Inserts customer details.
    INSERT INTO ot_account_type_2 VALUES(accountnum,amount);

    RETURN accountnum;
  END open_account;
END;
/
show errors

/*
 
Account_type_3 type:
--------------------
  This type has the information if the customer has a account_type_3.
*/

CREATE or REPLACE TYPE o_account_type_3 AS OBJECT
(
  accountnum INTEGER,
  balance NUMBER,

  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_3, amount IN NUMBER) 
    RETURN INTEGER
)
/

/*  ---------- Create object table for account_type_3 --------- */

CREATE TABLE ot_account_type_3 OF o_account_type_3
/

CREATE or REPLACE TYPE BODY o_account_type_3 AS
  MEMBER FUNCTION open_account(SELF IN OUT o_account_type_3, amount IN NUMBER)
    RETURN INTEGER AS
  BEGIN
    IF NOT amount > 0 THEN
     DBMS_OUTPUT.PUT_LINE('Bad amount entered');
     RETURN 0;
    END IF;
  
    IF (amount > 25000) THEN
       DBMS_OUTPUT.PUT_line
         ('Amount greater the specified cannot be withdrawn');
      RETURN 0;
    ELSE
     SELECT acct_sequence.NEXTVAL INTO accountnum FROM DUAL;
     INSERT INTO ot_account_type_3 VALUES(accountnum,amount);
     RETURN accountnum;
    END IF;
  END open_account;
END;
/
show errors

/*
 
  Accounts type:
  -------------
    This has the information about the types of accounts a customer has
    in the bank.

   Attributes:
      SSN is the ssn of the customer.
      (A customer can have multiple accounts but ssn remains the same)
      ACCOUNT_TYPE Stores the name of the account types as the elements of
      varray.
      ACCOUNTTYPE1 points to an object of type Account_type_1. 
      ACCOUNTTYPE2 points to an object of type Account_type_2. 
      ACCOUNTTYPE3 points to an object of type Account_type_3. 
 
   Methods:
      Open_account()     - Opens new accounts for the customers.
      Verify_account()   - Verifies if the account number exists
                           for any transaction to be done.
      Deposit_amount()   - Deposit amount to the corresponding account.
      withdraw_amount()  - Withdraws amount from the corresponding account.
      Close_account()    - Closes account .
      Current_balance()  - Returns the current balance 
                         - for the given account no.
 
*/
 
-- Store the account types as elements of VARRAY

CREATE or REPLACE TYPE v_account_type AS VARRAY(5) OF VARCHAR2(5)
/

CREATE or REPLACE TYPE o_account AS OBJECT
(
  ssn        varchar2(15), 
  account_type    v_account_type, 
  accounttype1 REF   o_account_type_1,
  accounttype2 REF   o_account_type_2,
  accounttype3 REF   o_account_type_3,

  MEMBER FUNCTION open_account(SELF IN OUT o_account, ssn_num IN VARCHAR2,
                               accounttype IN VARCHAR2, amount IN NUMBER, 
                               name IN VARCHAR2, bday IN DATE,
                               gender IN CHAR, addr o_address,
                               p_school IN VARCHAR2 := NULL) 
    RETURN INTEGER,

  MEMBER PROCEDURE insert_person(p_ssn IN VARCHAR2,p_name IN VARCHAR2,
                                 p_bday IN DATE,p_gender IN CHAR,
                                 p_addr o_address,
                                 p_school IN VARCHAR2 := NULL),

  MEMBER FUNCTION verify_account(SELF IN OUT o_account, acctnum IN INTEGER) 
    RETURN INTEGER,

  MEMBER PROCEDURE deposit_amount(acctnum IN INTEGER,amount IN NUMBER),

  MEMBER PROCEDURE withdraw_amount(acctnum IN INTEGER,amount IN NUMBER),

  MEMBER PROCEDURE current_balance(acctnum IN INTEGER),

  MEMBER PROCEDURE person_details(ssn_num IN VARCHAR2),

  MEMBER PROCEDURE report_form(actnum IN INTEGER),

  MEMBER PROCEDURE trans_details(ssn_num IN VARCHAR2),

  MEMBER PROCEDURE close_account(acctnum IN INTEGER)
)
/


/* ---------------- Create object table of o_account type ----------------- */ 

CREATE TABLE ot_account of o_account
/
 
/* 
 Private customer type:
 ---------------------
 
    Information about the private customers. It stores the information of
    another person if a customer has a joint account.
*/

CREATE or REPLACE TYPE o_customer AS OBJECT
(
  owner REF o_person,
  ref_o_account REF o_account
)
/

/*  ---------- Create object table for Customer Type --------- */
CREATE TABLE ot_customer OF o_customer
/

CREATE or REPLACE TYPE BODY o_account AS

  MEMBER PROCEDURE insert_person(p_ssn IN VARCHAR2,p_name IN VARCHAR2,
                                 p_bday IN DATE,p_gender IN CHAR,
                                 p_addr o_address,
                                 p_school IN VARCHAR2 := NULL) AS

    l_o_person o_person;
BEGIN
   IF  (p_school IS NOT NULL)
   THEN
      DBMS_OUTPUT.PUT_LINE('Inserting student');
      l_o_person
        := o_student(p_ssn,p_name,p_bday,p_gender,
                     o_address(p_addr.housenum,p_addr.street,
                               p_addr.city,p_addr.country,
                               p_addr.zipcode),
                     p_school,
                     interval '0' year -- Can be updated independently
                    );
   ELSE
      DBMS_OUTPUT.PUT_LINE('Inserting person');
      l_o_person
        := o_person(p_ssn,p_name,p_bday,p_gender,
                    o_address(p_addr.housenum,p_addr.street,
                    p_addr.city,p_addr.country,
                    p_addr.zipcode));
      

   END IF; 
   INSERT INTO ot_person VALUES(l_o_person);

END insert_person;

/*------------------------------------------------------------------------- */
/* For new customers(who do not have an account in the bank)
    1) insert customer details into PERSON table
    2) create a new account 

   For existing customers who want to open another 
   account(different account type), 
    1) Create a new account 

   To create a new account following operations are done
     1. Call open_account method in the corresponding account type.
     2. Make an entry of the account type in the ACCOUNT_TYPE varray
     3. Update the corresponding REF to point to the corresponding 
  account type object

     For e.g to open an ACCOUNT_TYPE1 account,
     1. Call open_account in accounttype1 
     2. Extend VARRAY(v_account_type) and initialise the new element to AT1
     3. Point the REF in ot_account object table to accounttype1 object
*/

  MEMBER FUNCTION open_account(SELF IN OUT o_account,ssn_num IN VARCHAR2,
                               accounttype IN VARCHAR2,
                               amount IN NUMBER, name IN VARCHAR2,
                               bday IN DATE,gender IN CHAR,
                               addr o_address,p_school IN VARCHAR2 := NULL)
     RETURN INTEGER AS

  /* 
     l_accounttype1,2,3 need to be defined before the corresponding
     OPEN_ACCOUNT method can be called
  */
  l_accounttype1 o_account_type_1 := o_account_type_1(null,null);
  l_accounttype2 o_account_type_2 := o_account_type_2(null,null);
  l_accounttype3 o_account_type_3 := o_account_type_3(null,null);
  l_amount NUMBER;
  account_type_exists EXCEPTION;
  no_account_type_exists EXCEPTION;
  l_accountnum INTEGER;
  l_count  INTEGER;
  l_account_type v_account_type := v_account_type(NULL);
  l_stat INTEGER := 0;
  n INTEGER;
  first_time VARCHAR2(6) := 'TRUE';
  ref_to_at1 REF o_account_type_1;
  ref_to_at2 REF o_account_type_2;
  ref_to_at3 REF o_account_type_3;

  BEGIN
    -- Check if the person has an account by checking if the ssn exists in
    -- the ot_account table.
    -- If the select returns an exception "NO_DATA_FOUND" the person does
    -- not have an account. Create a new account.
    -- If the select returns does not raise NO_DATA_FOUND exception then
    -- the existence of the account of the accounttype passed is checked.
    -- If the person has an account of the given accounttype then it raises
    -- an exception account_type_exists.
    -- If the person has an account in the bank but not of the given type then
    -- an exception no_account_type_exists is raised.

    SELECT account_type,accounttype1,accounttype2,accounttype3 INTO
      l_account_type,ref_to_at1,ref_to_at2,ref_to_at3 FROM ot_account
      WHERE ssn=ssn_num;
    -- loop through all the elements in the VARRAY to check if the 
    -- accounttype exists.
    
    first_time := 'FALSE'; 
    FOR n IN 1..l_account_type.COUNT
    LOOP
      -- Check if the user has an account of the accounttype passed.
      IF (l_account_type(n) = accounttype) THEN
        RAISE account_type_exists;
      ELSE
        RAISE no_account_type_exists;
      END IF;
    END LOOP;

  EXCEPTION
    WHEN NO_DATA_FOUND OR no_account_type_exists THEN

      IF (accounttype = 'AT1') THEN
        -- Create a new account of the type accounttype
        l_accounttype1 := l_accounttype1.open_account(amount);
        l_accountnum := l_accounttype1.accountnum;
        IF (l_accountnum != 0) THEN
          SELECT REF(at1) INTO ref_to_at1 FROM ot_account_type_1 at1
             WHERE at1.accountnum = l_accountnum;
        END IF;
      ELSIF (accounttype = 'AT2') THEN
        l_accountnum := l_accounttype2.open_account(amount);
        IF (l_accountnum != 0) THEN
          SELECT REF(at2) INTO ref_to_at2 FROM ot_account_type_2 at2
            WHERE at2.accountnum = l_accountnum;
        END IF;
      ELSIF (accounttype = 'AT3') THEN
        l_accountnum := l_accounttype3.open_account(amount);
        IF (l_accountnum != 0) THEN
          SELECT REF(at3) INTO ref_to_at3 FROM ot_account_type_3 at3
            WHERE at3.accountnum = l_accountnum;
        END IF;
      END IF;

     IF(l_accountnum != 0) THEN
       -- Valid account details , next check new or old customer.
       -- If new customer insert details to the person table and account table.
        INSERT INTO transaction_tab
          VALUES(l_accountnum,current_timestamp,amount,amount,'O');
       IF (first_time = 'TRUE') THEN
        -- The personal details of the customer is entered for a new customer.
         l_account_type(1) := accounttype;
          INSERT INTO ot_account
            VALUES(ssn_num,l_account_type, NULL,NULL,NULL);
         INSERT INTO ot_customer VALUES(NULL,NULL);
         insert_person(ssn_num,name,bday,gender,addr,p_school);
         UPDATE ot_customer t SET t.owner=(SELECT REF(x) FROM ot_person x
             WHERE x.ssn=ssn_num); 
       ELSE
          -- Entry for a old customer but 
          -- opening an account of a different type.
         n := l_account_type.COUNT;
         l_account_type.EXTEND(1);
         l_account_type(n+1) := accounttype;
       END IF;
       -- Update the attributes in ot_account table to point to the 
       -- corresponding account types.

       UPDATE ot_account t SET t.account_type = l_account_type,
         t.accounttype1=ref_to_at1,t.accounttype2=ref_to_at2,
         t.accounttype3=ref_to_at3 WHERE t.ssn=ssn_num;
       UPDATE ot_customer t SET t.ref_o_account=(SELECT REF(x) FROM ot_account
         x WHERE x.ssn = ssn_num);
       DBMS_OUTPUT.PUT_LINE('Accountnumber assigned is '|| l_accountnum);
     END IF;

    RETURN l_accountnum;

     WHEN account_type_exists THEN
       DBMS_OUTPUT.PUT_LINE('Account already exists, so cannot open');
       RETURN l_accountnum;


  END open_account; 
      

/*-------------------------------------------------------------------- */

/* 
   Verifies if the account number exists and returns 0,1,2,3.

   Return Value      What it means
   ------------------------------------------------------------
        0            Account is closed/does not exist
        1            Valid account_type_1 Account
        2            Valid account_type_2 Account
        3            Valid account_type_3 Account

*/

  MEMBER FUNCTION verify_account(SELF IN OUT o_account,acctnum IN INTEGER) 
    RETURN INTEGER IS
  l_count1 INTEGER;
  l_count2 INTEGER;
  l_count3 INTEGER;
  l_closecount INTEGER;
  BEGIN

    -- Check if the account is closed
    SELECT COUNT(*) INTO l_closecount FROM transaction_tab WHERE
      account_num=acctnum AND transaction_type='C';
 
    IF (l_closecount = 1) THEN
      DBMS_OUTPUT.PUT_LINE('Account is already closed. Cannot do any' || 
          'transaction');
      RETURN 0;
 
    END IF;
 
    -- Valid account - check if it is of account_type_1
    SELECT COUNT(*) INTO l_count1 FROM ot_account_type_1 WHERE 
     accountnum = acctnum; 
 
    IF (l_count1=1 AND l_closecount = 0) THEN
      RETURN 1;
    END IF;
 
    -- Valid account - check if it is of account_type_2
    SELECT COUNT(*) INTO l_count2 FROM ot_account_type_2 WHERE 
      accountnum = acctnum; 
 
    IF (l_count2=1 AND l_closecount = 0) THEN
      RETURN 2;
    END IF;
 
    -- Valid account - check if it is of account_type_3
    SELECT COUNT(*) INTO l_count3 FROM ot_account_type_3 WHERE 
      accountnum = acctnum; 
 
    IF (l_count3=1 AND l_closecount = 0) THEN
      RETURN 3;
    END IF;
 
    -- Seems like Account No. does not exist
    IF(l_count1 = 0 OR l_count2 = 0 OR l_count3 = 0) THEN
      DBMS_OUTPUT.PUT_LINE('Account number does not exist');
      RETURN 0;
    END IF;

  END verify_account;

/*----------------------------------------------------------------------- */
/* 
    Deposit amount after checking if the account exists. Update
    the transaction table accordingly.

    To verify if the account exists call the method, verify_account
    If the return value is,

     1 - Update the balance in account_type_1 table
     2 - Update the balance in account_type_2 table
     3 - Update the balance in account_type_3 table
*/

  MEMBER PROCEDURE deposit_amount(acctnum IN INTEGER,amount IN NUMBER) AS
  l_exists INTEGER;
  l_balance NUMBER;

  BEGIN

    l_exists := self.verify_account(acctnum);
  
    IF (l_exists = 1) THEN
      
      UPDATE ot_account_type_1 SET balance=balance+amount WHERE
        accountnum = acctnum;

      SELECT balance INTO l_balance FROM ot_account_type_1 WHERE
        accountnum = acctnum;

    ELSIF (l_exists = 2) THEN

      UPDATE ot_account_type_2 SET balance=balance+amount WHERE
        accountnum = acctnum;

      SELECT balance INTO l_balance FROM ot_account_type_2 WHERE
        accountnum = acctnum;

    ELSIF (l_exists = 3 ) THEN

      UPDATE ot_account_type_3 SET balance = balance - amount WHERE
        accountnum=acctnum;

      SELECT balance INTO l_balance FROM ot_account_type_3 WHERE
        accountnum = acctnum;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Balance in the account is ' || l_balance);

    INSERT INTO transaction_tab 
      VALUES(acctnum, current_timestamp,amount,l_balance, 'D');

    DBMS_OUTPUT.PUT_LINE('Deposited the amount for the given person');
    
  END deposit_amount;

/* ---------------------------------------------------------------------- */

/* 
    Withdraw amount after checking if the account exists. Update
    the transaction table accordingly.

    To verify if the account exists call the method, verify_account
    If the return value is,
    
     1 - If the balance > 250,update the balance in account_type_1 table
     2 - If the balance > 0,  update the balance in account_type_2 table
     3 - If the balance > 25000, update the balance in account_type_3 table
*/

  MEMBER PROCEDURE withdraw_amount(acctnum IN INTEGER,amount IN NUMBER) AS
  l_exists INTEGER;
  l_balance NUMBER;

  BEGIN

    l_exists := verify_account(acctnum);
 
    IF (l_exists = 1) THEN
      SELECT balance INTO l_balance FROM ot_account_type_1 WHERE 
        accountnum = acctnum;
      l_balance := l_balance - amount;
 
      IF (l_balance < 250) THEN
        DBMS_OUTPUT.PUT_LINE('The minimum limit in the account should be 250');
      ELSE
        UPDATE ot_account_type_1 SET balance=l_balance WHERE
          accountnum=acctnum;
      END IF;
 
    ELSIF (l_exists = 2) THEN
      SELECT balance INTO l_balance FROM ot_account_type_2 WHERE 
        accountnum = acctnum;
      l_balance := l_balance - amount;
 
      IF (l_balance < 0) THEN
         DBMS_OUTPUT.PUT_LINE(
           'The minimum limit in the account should not be negative');
      ELSE
 
        UPDATE ot_account_type_2 SET balance=l_balance WHERE
          accountnum=acctnum;
      END IF;
 
    ELSIF (l_exists = 3) THEN
      SELECT balance INTO l_balance FROM ot_account_type_3 WHERE 
        accountnum = acctnum;
      l_balance := l_balance + amount;
 
      IF (l_balance > 25000) THEN
        DBMS_OUTPUT.PUT_LINE('The amount cannot be withdrawn beyond 25000'); 
      ELSE
        UPDATE ot_account_type_3 SET balance=l_balance WHERE
          accountnum=acctnum;
      END IF;
    END IF;
    INSERT INTO transaction_tab 
      VALUES(acctnum,current_timestamp,amount,l_balance, 'W');
    DBMS_OUTPUT.PUT_LINE('Balance in the account is ' || l_balance);
  END withdraw_amount;

/* ----------------------------------------------------------------------- */

/*
   Display the current balance after verifying for the existence of the
   account
*/
 
  MEMBER PROCEDURE current_balance(acctnum IN INTEGER) AS
  l_exists INTEGER;
  l_balance NUMBER;
  BEGIN
    l_exists := verify_account(acctnum);
 
    IF (l_exists = 1) THEN
 
      SELECT balance INTO l_balance FROM ot_account_type_1 WHERE
        accountnum = acctnum;
 
    ELSIF ( l_exists = 2) THEN

       SELECT balance INTO l_balance FROM ot_account_type_2 WHERE
         accountnum = acctnum;
 
    ELSIF (l_exists = 3) THEN
 
      SELECT balance INTO l_balance FROM ot_account_type_3 WHERE
        accountnum = acctnum;
    END IF;
 
    DBMS_OUTPUT.PUT_LINE('Current balance for the given account number ' ||
                          l_balance);
  END;
 
/* ------------------------------------------------------------------------ */

  MEMBER PROCEDURE person_details(ssn_num IN VARCHAR2) AS 
  l_o_person o_person;
  BEGIN
    SELECT VALUE(p) INTO l_o_person FROM
      ot_person p WHERE ssn=ssn_num;
    
    l_o_person.display; /* Dynamic Call to display */
  
  END;

/* ---------------------------------------------------------------------- */ 

  MEMBER PROCEDURE report_form(actnum IN INTEGER) AS
  var1 VARCHAR2(2000);
  head VARCHAR2(200);
  transaction_time TIMESTAMP(0);
  BEGIN
     DBMS_OUTPUT.PUT_LINE(
       '---------------------------------------------------'||
       '----------------------------');
     head := 
       '|Date and Time        | Opening amt. '
       ||'| Amt Deposited| Amt Withdrawn | Balance |';
    DBMS_OUTPUT.PUT_LINE(head);
    DBMS_OUTPUT.PUT_LINE(
      '---------------------------------------------------'||
      '----------------------------');
   
    FOR c1 IN(SELECT transaction_date,transaction_amount,balance,
              transaction_type FROM transaction_tab WHERE account_num=actnum)
    LOOP
      transaction_time := c1.transaction_date AT local;
      /* Print this out in local time */ 
      var1 := '|' || transaction_time  || '|';
      IF (c1.transaction_type = 'D') THEN
        var1 := var1 || sp(14)||'|'||sp(2) ||
                  to_char(c1.transaction_amount,'99999.99') ||
                  sp(3) || '|' || sp(15) || '|';
      ELSIF (c1.transaction_type = 'W') THEN
        var1 := var1 || sp(14) ||'|' || sp(14) ||'|' ||
           to_char(c1.transaction_amount,'99999.99') || sp(6) || '|';
      ELSIF (c1.transaction_type = 'O') THEN
        var1 := var1 || sp(2) || to_char(c1.transaction_amount,'99999.99')||
                sp(3)|| '|' || sp(14) ||'|' || sp(15) ||'|';
      END IF;
      var1 := var1 || to_char(c1.balance,'99999.99') || '|';
      DBMS_OUTPUT.PUT_LINE(var1);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(
      '---------------------------------------------------'||
      '----------------------------');
    DBMS_OUTPUT.PUT_LINE('');
  END;

/*---------------------------------------------------------------------------*/

  MEMBER PROCEDURE trans_details(ssn_num IN VARCHAR2) AS
  l_name VARCHAR2(50);
  l_account_type v_account_type;
  l_ref1 REF o_account_type_1;
  l_ref2 REF o_account_type_2;
  l_ref3 REF o_account_type_3;
  l_accounttype1 o_account_type_1;
  l_accounttype2 o_account_type_2;
  l_accounttype3 o_account_type_3;
  l_count INTEGER;
  n INTEGER;
   
  BEGIN
    
    SELECT COUNT(*) INTO l_count FROM ot_account WHERE ssn=ssn_num;
     
    IF(l_count > 0) THEN
     -- Get all details of the customer from the person table and
     -- ot_account table.
      
      SELECT t.account_type,t.accounttype1,t.accounttype2,t.accounttype3 INTO
        l_account_type,l_ref1,l_ref2,l_ref3 FROM ot_account t 
        WHERE t.ssn=ssn_num;
      DBMS_OUTPUT.PUT_LINE('Details for the customer ');
      DBMS_OUTPUT.PUT_LINE('');
      person_details(ssn_num);
        
      FOR n IN 1..l_account_type.COUNT
      LOOP
        IF(l_account_type(n) = 'AT1') THEN
          -- Get the details for accounttype1.
          SELECT DEREF(l_ref1) INTO l_accounttype1 from dual;
          DBMS_OUTPUT.PUT_LINE('Transaction details for accountno. ' 
                               || l_accounttype1.accountnum);
          DBMS_OUTPUT.PUT_LINE('');
          DBMS_OUTPUT.PUT_LINE('Accounttype: '|| 'AT1');
          report_form(l_accounttype1.accountnum);
        ELSIF(l_account_type(n) = 'AT2') THEN
          -- Get the details for accounttype2.
          SELECT DEREF(l_ref2) INTO l_accounttype2 from dual;
          DBMS_OUTPUT.PUT_LINE('Transaction details for accountno. ' 
                               || l_accounttype2.accountnum);
          DBMS_OUTPUT.PUT_LINE('');
          DBMS_OUTPUT.PUT_LINE('Accounttype: '|| 'AT2');
          report_form(l_accounttype2.accountnum);
          -- Get the details for accounttype3.
        ELSIF(l_account_type(n) = 'AT3') THEN
          SELECT DEREF(l_ref3) INTO l_accounttype3 from dual;
          DBMS_OUTPUT.PUT_LINE('Transaction details for accountno. ' 
                                ||l_accounttype3.accountnum );
          DBMS_OUTPUT.PUT_LINE('');
          DBMS_OUTPUT.PUT_LINE('Accounttype: '|| 'AT3');
          report_form(l_accounttype3.accountnum);
        END IF;
      END LOOP;
     ELSE
       DBMS_OUTPUT.PUT_LINE('The given ssn does not exist');
     END IF;
  END;

/*---------------------------------------------------------------------------*/
 
   

/* 
    Close account after checking if the account exists. Update
    the transaction table accordingly.

    To verify if the account exists call the method, verify_account
    If the return value is,

     1 - Pay remaining balance in account_type_1 to the customer
     2 - Pay remaining balance in account_type_2 to the customer
     3 - Account will be closed after the customer pays the amount due
*/

  MEMBER PROCEDURE close_account(acctnum IN INTEGER) AS
  l_exists INTEGER;
  l_balance NUMBER;
  BEGIN

    l_exists := verify_account(acctnum);

    IF(l_exists = 1) THEN
      SELECT balance INTO l_balance FROM ot_account_type_1 WHERE
        accountnum = acctnum;

      DBMS_OUTPUT.PUT_LINE('Closing balance is ' || l_balance);

    ELSIF(l_exists = 2) THEN
      SELECT balance INTO l_balance FROM ot_account_type_2 WHERE
        accountnum = acctnum;
 
     DBMS_OUTPUT.PUT_LINE('Closing balance is ' || l_balance);
 
    ELSIF(l_exists = 3) THEN
      SELECT balance INTO l_balance FROM ot_account_type_3 WHERE
        accountnum = acctnum;
 
      IF ( l_balance > 0) THEN
        DBMS_OUTPUT.PUT_LINE('Pending amount to be paid by the customer is'
                         || l_balance);
      ELSE
        DBMS_OUTPUT.PUT_LINE('Account closed');
      END IF;
 
      INSERT INTO transaction_tab 
        VALUES(acctnum,current_timestamp, l_balance,0,'C');
    END IF; 
 
  END close_account;
END;
/
show errors

SPOOL OFF
  
  
 
