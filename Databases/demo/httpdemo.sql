Rem
Rem $Header: httpdemo.sql 05-jul-2001.11:06:21 rpang Exp $
Rem
Rem httpdemo.sql
Rem
Rem  Copyright (c) Oracle Corporation 2001. All Rights Reserved.
Rem
Rem    NAME
Rem      httpdemo.sql - Demo program for the UTL_HTTP package.
Rem
Rem    DESCRIPTION
Rem      This is a sample program to demonstrate the usage of the UTL_HTTP
Rem      package. It demonstrate the use of HTTP GET method.
Rem
Rem    NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem    Pre-requsite:
Rem
Rem      To execute this demo, you need access to the Internet, either directly
Rem      or indirectly (via a HTTP proxy server on a firewall). This demo
Rem      program retrieves the stock quotes from Yahoo!.
Rem
Rem    To execute this demo program:
Rem
Rem      Use SQL*Plus to run this demo.  Connect as SCOTT/TIGER.  Then
Rem      execute this demo program.  SQL*Plus will prompt you to enter the
Rem      values of the following variables:
Rem
Rem      a. http_proxy - the host where HTTP proxy server runs. If you
Rem         have direct access the Internet, just leave the value empty.
Rem      b. symbols - a list of sumbols separated by the '+' sign.
Rem
Rem    For example:
Rem
Rem    > sqlplus scott/tiger
Rem    
Rem    SQL*Plus: Release 9.0.1.0.0 - Production on Mon Apr 30 18:40:43 2001
Rem    
Rem    (c) Copyright 2001 Oracle Corporation.  All rights reserved.
Rem    
Rem    
Rem    Connected to:
Rem    Oracle9i Enterprise Edition Release 9.0.1.0.0 - Production
Rem    With the Partitioning option
Rem    JServer Release 9.0.1.0.0 - Production
Rem    
Rem    SQL> @httpdemo
Rem    Enter value for http_proxy: proxy.my-domain.com
Rem    Enter value for symbols: ORCL+CSCO+SUNW+EMC
Rem    "ORCL","2:13 PM",19.80,"+0.440000763","+2.28%",19.314,19.32
Rem    "CSCO","2:13 PM",17.918,"-1.27200127","-6.63%",17.90,17.919
Rem    "SUNW","2:13 PM",15.348,"-0.562001228","-3.53%",15.33,15.35
Rem    "EMC","2:12 PM",30.37,"-1.25","-3.95%",30.21,30.40
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    rpang       07/05/01 - Reworked this demo due to changes in Yahoo
Rem    rpang       04/30/01 - Created
Rem

SET ESCAPE \
SET SERVEROUTPUT ON
SET VERIFY OFF

DECLARE
  
  TYPE vc2_table IS TABLE OF VARCHAR2(1024) INDEX BY binary_integer;

  url  VARCHAR2(1024);

  -- A helper procedure that echoes a HTTP response.
  PROCEDURE show_response(resp         IN OUT NOCOPY utl_http.resp,
			  show_headers IN BOOLEAN DEFAULT FALSE) AS
    name    VARCHAR2(64);
    value   VARCHAR2(256);
  BEGIN
    IF (show_headers) THEN
       dbms_output.put_line(resp.http_version || ' ' || resp.status_code ||
	 ' ' || resp.reason_phrase);
       FOR i IN 1..(utl_http.get_header_count(resp)) LOOP
	  utl_http.get_header(resp, i, name, value);
	  dbms_output.put_line(name || ': ' || value);
       END LOOP;
    END IF;

    LOOP
       utl_http.read_line(resp, value, TRUE);
       dbms_output.put_line(value);
    END LOOP;
  EXCEPTION
     WHEN utl_http.end_of_body THEN
       utl_http.end_response(resp);
  END;
  
  -- A helper procedure that echoes a Web page
  PROCEDURE show_page(url IN VARCHAR2) AS
    req   utl_http.req;
    resp  utl_http.resp;
  BEGIN
    req  := utl_http.begin_request(url);
    resp := utl_http.get_response(req);
    show_response(resp);
  END;      
  
BEGIN

   -- Set up a HTTP proxy (if necessary)   
   utl_http.set_proxy('&http_proxy', NULL);

   -- Retrieve the stock quotes as comma-separated values via a
   -- HTTP GET request.
   show_page(' http://quote.yahoo.com/d/quotes.csv?'||
     's=' || '&symbols' || '\&f=st5l9c6p4b1a3\&e=.csv');
   
END;
/
