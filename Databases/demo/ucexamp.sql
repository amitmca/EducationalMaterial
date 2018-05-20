Rem
Rem $Header: ucexamp.sql 30-apr-2001.19:22:39 wxli Exp $
Rem
Rem ucexamp1.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      ucexamp1.sql - <one-line expansion of the name>
Rem
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    wxli        04/30/01 - Merged wxli_logs
Rem    wxli        04/26/01 - Created
Rem

REM   This is demo for codepoint length semantics and implicit conversions
REM
REM   -------------------------------------------------------------------
REM   |   Best demostratration cases require the change of datadbase    |
REM   |   character set to multi-byte character sets such as UTF8 etc.  |
REM   |   Here is the simple and limit cases for codepoint length and   |
REM   |   implicit conversions between CHAR/VARCHAR2 and NCHAR/NVARCHAR2|
REM   |   Please see NLS demos for more cases for codepoint length      |
REM   |   and implicit conversions.                                     |
REM   |                                                                 |
REM   |   The following demo uses default database character sets:      |
REM   |     database character set (char/varchar2): W8DEC               |
REM   |     database national character set (nchar/nvarchar2): AL16UTF16|
REM   -------------------------------------------------------------------

set serveroutput on

-- the declaration such as varchar2(10)/char(10) are normally measured 
-- in bytes, they are OK for single byte chacteracter set like W8DEC.
-- Fro multiple type character sets such UTF8 and UTF16, we do not know how 
-- many characters they can hold.
-- the declarations : v varchar2(10 char), v char(10 char) will guarantee that
-- the variable v will have enough space to hold 10 chars regardless the 
-- character set used. 

-- nchar/nvarchar2 is always measured as codepoint lengths.
-- nchar(10)/nvarchar(10) is equivalent to nchar(10 char)/nvarchar(10 char)

declare
  nvar_in_char nvarchar2(3);
  var_in_char varchar2(3 char);
begin
  -- the string below contains 3 chars and 6 bytes in AL16TUF16, 
  -- unistr convert hex value to internal AL16TUF16 value here
  nvar_in_char := unistr('\ff41\ff42\ff43');

  -- 3 chars and also 3 bytes for W8DEC character set
  var_in_char := 'abc';
end;
/

set serveroutput on

-- char/varchar2 and nchar/nvarchar2 can now be freely assigned each other.
-- the implicit conversion between char/varchar2 and nchar/nvarchar2 will
-- occur on assignment, on parameter passing etc.
declare
  char_var varchar2(10 char);
  nchar_var nvarchar2(10);
  procedure proc(arg varchar2) is
  begin
    dbms_output.put_line(arg);
  end;
begin
  char_var := 'abcdefghij';
  nchar_var := char_var;  -- implicit conversions from char to nchar
                          -- in this case, from W8DEC to AL16UTF16
  proc(nchar_var);   -- implicit conversion on parameter
end;
/


-- implicit conversions may result in data loss in some cases when data can 
-- not be converted from one to another, e.g. some data from utf16 to w8dec.
-- The data loss can be captured by changing nls_nchar_conv_excp to be true
-- The first of following two examples will quietly occur the data loss
-- on implicit conversion.
-- the second will raise the data loss exception by setting nls_nchar_conv_excp
-- to be true.
declare
  nchar_utf18 nvarchar2(5);
  char_w8dec varchar2(5 char);
begin
  nchar_utf18 := unistr('\ff41\ff42\ff43\ff44\ff45');
  char_w8dec := nchar_utf18; -- data loss conversion;
  dbms_output.put_line(char_w8dec); -- some funny data printed out
end;
/


-- The data loss exception is raised
alter session set nls_nchar_conv_excp=true;

declare
  nchar_utf18 nvarchar2(5);
  char_w8dec varchar2(5 char);
begin
  nchar_utf18 := unistr('\ff41\ff42\ff43\ff44\ff45');
  char_w8dec := nchar_utf18; -- data loss conversion, exception raised;
  dbms_output.put_line(char_w8dec); 
end;
/
  
