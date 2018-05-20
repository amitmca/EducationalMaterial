Rem
Rem $Header: bulkdemo.sql 25-sep-2000.17:20:59 nle Exp $
Rem
Rem bulkdemo.sql
Rem
Rem  Copyright (c) Oracle Corporation 1998, 2000. All Rights Reserved.
Rem
Rem    NAME
Rem      bulkdemo.sql - <one-line expansion of the name>
Rem
Rem    DESCRIPTION
Rem      <short description of component this file declares/defines>
Rem
Rem    NOTES
Rem      <other useful comments, qualifications, etc.>
Rem
Rem    MODIFIED   (MM/DD/YY)
Rem    nle         09/25/00 - add dynamic statements
Rem    rchennoi    08/18/99 -
Rem    jmuller     05/28/99 - Fix bug 708690: TAB -> blank
Rem    smkrishn    10/14/98 - Bulk bind demo program
Rem    smkrishn    10/14/98 - Created
Rem
Rem NAME
Rem   bulkdemo.sql  - Demo Program For Bulk Binds in PL/SQL 8.1
Rem   
Rem  The Demo Program does the following tasks :
Rem
Rem  1) Shows the performance improvement between executing DMLs (insert and
Rem     select queries ) WITHOUT BULK BINDS and WITH BULK BINDS.
Rem
Rem  2) Demonstrates usage of SQL%BULK_ROWCOUNT attribute.
Rem
Rem  3) Demonstrates usage of ROWNUM.
Rem
Rem FUNCTION
Rem
Rem   The Demo Program illustrates the use of Bulk-Binds feature in PL/SQL 8.1
Rem
Rem   In Pre 8.1, execution of every SQL statement embedded in the PL/SQL 
Rem   programs involves context switch between the PL/SQL engine and SQL 
Rem   engine. This results in performace penalty.
Rem 
Rem   Bulk Binds feature in PL/SQL 8.1 allows us to operate on multiple rows
Rem   in a single DML statement.
Rem 
Rem   Performance Improvement achieved by WITH BULK BINDS feature vs WITHOUT
Rem   BULK BINDS are listed below :
Rem
Rem   Note :
Rem
Rem   The following figures are representative of the gains that might be had
Rem   by passing parameters WITH BULK BINDS mechanism Vs WITHOUT BULK BINDS
Rem   mechanism. Actual timings can vary depending on the machine type and 
Rem   load etc.
Rem
Rem   ---------------------------------------------------------------------
Rem   |  Task                 WITHOUT BULK BINDS    WITH BULK BINDS       |
Rem   |                        ( Secs )                ( Secs )           |
Rem   ---------------------------------------------------------------------
Rem   |                                                                   |
Rem   | Inserting 10000             77                    8               |
Rem   | Records                                                           |
Rem   ---------------------------------------------------------------------
Rem   | Querying 10000                                                    |
Rem   | Records                     19                    12              |
Rem   ---------------------------------------------------------------------
Rem
Rem
Rem NOTES ON EXECUTING THIS DEMO PROGRAM
Rem
Rem   1) Use svrmgrl for running this demo program
Rem  
Rem   2) Connect as SCOTT/TIGER and run bulkdemo.sql
Rem   
Rem      CONNECT SCOTT/TIGER
Rem      @bulkdemo.sql
Rem
Rem

/*
** ##########################################################################
**
**       DESCRIPTION  OF  DEMO  EXAMPLE
**
** ##########################################################################
**
** The following example illustrates the Bulk Binds Feature introduced in 8.1
** PL/SQL.
**
** In the demo program, the daily summary data for each listed stock is 
** recorded in a table called Stock_history_table. The data in stock history 
** table is used for applications such as price and volume charting and
** technical analysis.
**
** In this example, the stock_track_pack module does the following tasks with
** and without bulk binds.
**
**    1) Insert the per day basis stock summary data for each of the listed 
**       stock into Stock_history_table, at the end of each day.
**
**    2) Query the Stock_history_table to answer queries like        
**       'Give average volume traded for each stock '
**
** The stock_track_pack module also consists procedures which perform 
** following tasks :
**
**    3) Function Update_stock_group, updates the stock group to 'L' if the
**       volume of stock traded on a particular day is less than 50.
**       This function demonstrates the usage of SQL%BULK_ROWCOUNT.
**
**    4) Procedure qry_lowest_volume_stocks, fetches only first 5 stock names
**       having lowest volume traded on a the day and demonstrates the 
**       fetching of limited records using ROWNUM clause. 
**       Using ROWID and ROWNUM, user can fetch block by block of data and 
**       perform some processing on the block of data.
**
** In the Demo Program, the columns of Stock_History_Table are
**    
**  a) Stock_name     VARCHAR2(30)  # Stock Name #
**  b) Opening_Value  NUMBER(8,2)   # Opening Value of Stock #
**  c) High_Value     NUMBER(8,2)   # High Value reached on a particular day #
**  d) Closing_value  NUMBER(8,2)   # Closing Value of stock #
**  e) Volume         NUMBER(6,2)   # Total volume of trading occured on the 
**                                    day for that stock #
**  f) Stock_group    CHAR(1)       # Group Of Stock L- Low volume group etc#
**  g) Trade_Date     DATE          # Date Of Trading #
**
*/

/*
** ##########################################################################
**
**             CODING  STYLE  USED
**
** ##########################################################################
**
**     1. Uppercase is used for PL/SQL keywords and lower case for defined
**        items.
**
**     2. Naming convention followed for user defined types :
**    -----------------------------------------------------------------
**    Data Structure Name                     Prefixed with
**    -----------------------------------------------------------------
**     Nested Table Types                      nt_
**     Local variables                         l_
**
**
*/

CONNECT SCOTT/TIGER;

SET ECHO OFF;
SET SERVEROUTPUT ON;
SPOOL dm030.dbg

/*--------------------------------------------------------------------*/
/*   Table for storing Stock Summary Data                             */
/*--------------------------------------------------------------------*/

CREATE TABLE stock_history (
              Stock_Name        VARCHAR2(30),
              Opening_Value     NUMBER(8,2),
              High_Value        NUMBER(8,2),
              Closing_Value     NUMBER(8,2),
              Volume            NUMBER(12),
              Stock_Group       CHAR(1),
              Trade_Date        DATE );
/


/*--------------------------------------------------------------------*/
/*  Nested Table type for storing opening,closing and high values     */
/*--------------------------------------------------------------------*/

CREATE TYPE nt_values AS TABLE OF NUMBER(8,2)
/

/*--------------------------------------------------------------------*/
/*  Nested Table type for storing volume                              */
/*--------------------------------------------------------------------*/

CREATE TYPE nt_volume AS TABLE OF NUMBER(12)
/

/*--------------------------------------------------------------------*/
/*  Nested Table type for storing stock names                         */
/*--------------------------------------------------------------------*/

CREATE TYPE nt_stknames AS TABLE OF VARCHAR2(30)
/


/*--------------------------------------------------------------------*/
/* Declaring a package specification where procedures for inserting   */
/* daily stock summary data into stock_history_table and querying     */
/* summary data resides. Here to compare the performance of BULK      */
/* BINDS vs WITHOUT BULK BINDS, four different procedures are defined */
/* namely                                                             */
/*   1) ins_summary_data_withoutbulk -insert data without bulk binds  */
/*   2) ins_summary_data_withbulk - insert data with bulk binds       */
/*   3) qry_summary_data_withoutbulk -query data without bulk binds   */
/*   4) qry_summary_data_withbulk -query data with bulk binds         */
/*                                                                    */
/* The package also defines                                           */
/*                                                                    */
/*   5) update_stock_group - Function to demonstrate usage of         */
/*                                       SQL%BULK_ROWCOUNT attribute  */
/*   6) qry_lowest_volume_stocks - Procedure to demonstrate usage of  */
/*                    ROWNUM to fetch a limited number of rows.       */
/*--------------------------------------------------------------------*/

CREATE OR REPLACE PACKAGE stock_track_pack IS
     PROCEDURE ins_summary_data_withoutbulk(stock_name nt_stknames, 
       stk_open_vals nt_values, high nt_values, stk_close_vals nt_values,
       vol nt_volume, time_required OUT NUMBER);
     PROCEDURE ins_summary_data_withbulk(stock_name nt_stknames, 
       stk_open_vals nt_values, high nt_values, stk_close_vals nt_values,
       vol nt_volume, time_required OUT NUMBER);
     PROCEDURE ins_summary_data_withdynbulk(stock_name nt_stknames, 
       stk_open_vals nt_values, high nt_values, stk_close_vals nt_values,
       vol nt_volume, time_required OUT NUMBER);
     PROCEDURE qry_summary_data_withoutbulk(time_required OUT NUMBER);
     PROCEDURE qry_summary_data_withbulk(time_required OUT NUMBER);
     PROCEDURE qry_summary_data_withdynbulk(time_required OUT NUMBER);
     FUNCTION  update_stock_group(all_stock_names nt_stknames) RETURN NUMBER;
     FUNCTION dynupdate_stock_group(all_stock_names nt_stknames) RETURN NUMBER;
     PROCEDURE qry_lowest_volume_stocks;
END stock_track_pack;
/
SHOW ERRORS

/*--------------------------------------------------------------------*/
/* Define Body of the package. Procedures ins_summary_data_withbulk & */
/* ins_summary_data_withoutbulk, insert daily stock summary data into */
/* the stock_history_table.                                           */
/* For demonstrating performance improvement of BULK BINDS vs WITHOUT */
/* BULK BINDS, time required to insert some fixed number of records is*/
/* measured in both the procedures.                                   */
/*                                                                    */
/* Procedures qry_summary_data_withoutbulk & qry_summary_data_withbulk*/
/* query stock summary data from stock_history_table.                 */
/* For demonstrating performance improvement of WITH BULK BINDS vs    */
/* WITHOUT BULK BINDS, time required to query records is measured in  */
/* both the procedures.                                               */
/*                                                                    */
/* Function  update_stock_group demonstrates the use of implicit      */
/* cursor attribute SQL%BULK_ROWCOUNT. In the context of BULK DMLs    */
/* the i th element of SQL%BULK_ROWCOUNT attribute corresponds to the */
/* rows operated on by the ith execution.                             */
/* If ith execution of a DML does not operate on any row, then        */
/* SQL%BULK_ROWCOUNT(i) will be set to zero.                          */
/*                                                                    */
/* Procedure qry_lowest_volume_stocks demonstrates the use of ROWNUM  */
/* to fetch limited amount of data.                                   */
/* This procedure lists the first 5 lowest volume stocks traded today.*/
/* Using ROWID & ROWNUM, user can fetch block by block data and       */
/* perform required processing.                                       */
/*--------------------------------------------------------------------*/


CREATE OR REPLACE PACKAGE BODY stock_track_pack IS

   today DATE := SYSDATE;

   /*---------------------------------------------------------------*/
   /* Procedure to insert daily summary data WITHOUT USING BULK     */
   /* BINDS. This procedure takes following nested table parameters */
   /*            1) Stock_names                                     */
   /*            2) Opening Stock values                            */ 
   /*            3) High Values   reached on a particular day.      */ 
   /*            4) Closing Stock Values and                        */
   /*            5) Volume of Transactions.                         */
   /*---------------------------------------------------------------*/

    PROCEDURE ins_summary_data_withoutbulk(stock_name nt_stknames,
      stk_open_vals nt_values,high nt_values, stk_close_vals nt_values,
      vol nt_volume, time_required OUT NUMBER)
    IS
       l_start_time   NUMBER; -- Capture Start Time
       l_end_time     NUMBER; -- Capture End Time
       yesterday      DATE := today - 1;
    BEGIN
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;
       FOR l_i IN 1..stk_open_vals.COUNT
       LOOP
         INSERT INTO Stock_History VALUES (stock_name(l_i),stk_open_vals(l_i),
              high(l_i), stk_close_vals(l_i), vol(l_i),NULL, yesterday);
       END LOOP;
       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       /*  Time Required To Insert Data      */
       time_required := l_end_time - l_start_time;

    END ins_summary_data_withoutbulk;

   /*----------------------------------------------------------------*/
   /* Procedure to insert daily summary data WITH USING BULK         */
   /* BINDS. This procedure takes following nested table parameters  */
   /*          1) Stock_names                                        */ 
   /*          2) Opening Stock values                               */ 
   /*          3) High Values reached on a particular day.           */ 
   /*          4) Closing Stock Values and                           */
   /*          5) Volume of Transactions.                            */
   /*----------------------------------------------------------------*/

    PROCEDURE ins_summary_data_withbulk(stock_name nt_stknames, 
        stk_open_vals nt_values, high nt_values, stk_close_vals nt_values,
        vol nt_volume, time_required OUT NUMBER)
    IS
       l_start_time   NUMBER;-- Capture Start Time
       l_end_time     NUMBER;-- Capture End Time
       localday       DATE := today;
    BEGIN
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;
       FORALL l_i IN 1..stk_open_vals.COUNT
         INSERT INTO Stock_History VALUES (stock_name(l_i),stk_open_vals(l_i),
                 high(l_i), stk_close_vals(l_i), vol(l_i),NULL, localday);
       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       /*   Time Required To Insert Data      */
       time_required := l_end_time - l_start_time;

    END ins_summary_data_withbulk;

   /*----------------------------------------------------------------*/
   /* Procedure to insert daily summary data using DYNAMIC BULK      */
   /* BINDS. This procedure takes following nested table parameters  */
   /*          1) Stock_names                                        */ 
   /*          2) Opening Stock values                               */ 
   /*          3) High Values reached on a particular day.           */ 
   /*          4) Closing Stock Values and                           */
   /*          5) Volume of Transactions.                            */
   /*----------------------------------------------------------------*/

    PROCEDURE ins_summary_data_withdynbulk(stock_name nt_stknames, 
	stk_open_vals nt_values, high nt_values, stk_close_vals nt_values,
	vol nt_volume, time_required OUT NUMBER)
    IS
       l_start_time   NUMBER; -- Capture Start Time
       l_end_time     NUMBER; -- Capture End Time
       null_char      CHAR(1);
       pastday        DATE := today - 2;
    BEGIN
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;

       FORALL l_i IN 1..stk_open_vals.COUNT
	 EXECUTE IMMEDIATE
           'INSERT INTO Stock_History VALUES (:1, :2, :3, :4, :5, :6, :7)'
           USING stock_name(l_i), stk_open_vals(l_i), high(l_i),
                 stk_close_vals(l_i), vol(l_i), null_char, pastday;

       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       /*   Time Required To Insert Data      */
       time_required := l_end_time - l_start_time;

    END ins_summary_data_withdynbulk;
	
   /*------------------------------------------------------------*/
   /* Procedure to query summary data WITHOUT USING BULK BINDS   */
   /* The procedure queries the Stock_History_Table and displays */
   /* Stock Name and Average volume of transactions occured upto */
   /* now. Only selected Stock Names and their average volumes   */
   /* are displayed.                                             */
   /*------------------------------------------------------------*/

    PROCEDURE qry_summary_data_withoutbulk(time_required OUT NUMBER)
    IS
       l_start_time   NUMBER; -- Capture Start Time
       l_end_time     NUMBER; -- Capture End Time
       l_i              NUMBER := 1;
       l_averages     nt_volume := nt_volume();-- Fetch Averages here
       l_stock_names  nt_stknames := nt_stknames();-- Fetch Stock Names here

       -- Cursor for querying Stock_Names and Average volumes from
       -- Stock_History_table.

       CURSOR l_c1 IS 
            SELECT stock_name,AVG(VOLUME) FROM Stock_History 
            GROUP BY stock_name
             ORDER BY stock_name;
    BEGIN
       OPEN l_c1; 
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;
       LOOP
           l_averages.EXTEND;
           l_stock_names.EXTEND;
           FETCH l_c1 INTO l_stock_names(l_i),l_averages(l_i);
           EXIT WHEN l_c1%NOTFOUND;
           l_i := l_i + 1;
       END LOOP;
       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       CLOSE l_c1;

       time_required := l_end_time - l_start_time;

    END qry_summary_data_withoutbulk;
      
   /*------------------------------------------------------------*/
   /* Procedure to query summary data WITH USING BULK BINDS      */
   /* The procedure queries the Stock_History_Table and displays */
   /* Stock Name and Average volume of transactions occured upto */
   /* now. Only selected Stock Names and their average volumes  */
   /* are displayed.                                            */
   /*------------------------------------------------------------*/

    PROCEDURE qry_summary_data_withbulk(time_required OUT NUMBER)
    IS
       l_start_time   NUMBER; -- Capture start time
       l_end_time     NUMBER; -- Capture end time
       l_averages     nt_volume := nt_volume();-- Fetch Averages here
       l_stock_names  nt_stknames := nt_stknames();-- Fetch Stock Names Here

       -- Cursor for querying Stock_Names and Average volumes from
       -- Stock_History_table.

       CURSOR l_c1 IS 
            SELECT stock_name,AVG(VOLUME) FROM Stock_History 
            GROUP BY stock_name
            ORDER BY stock_name;
    BEGIN
       /* Use BULK FETCHING  */
       OPEN l_c1; 
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;
       FETCH l_c1 BULK COLLECT INTO l_stock_names,l_averages;
       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       CLOSE l_c1;

       /*  Time Required To Query Data      */

       time_required := l_end_time - l_start_time;

    END qry_summary_data_withbulk;

   /*------------------------------------------------------------*/
   /* Procedure to query summary data using DYNAMIC BULK BINDS   */
   /* The procedure queries the Stock_History_Table and displays */
   /* Stock Name and Average volume of transactions occured upto */
   /* now. Only selected Stock Names and their average volumes  */
   /* are displayed.                                            */
   /*------------------------------------------------------------*/

    PROCEDURE qry_summary_data_withdynbulk(time_required OUT NUMBER)
    IS
       type trc is ref cursor;
       l_start_time   NUMBER; -- Capture start time
       l_end_time     NUMBER; -- Capture end time
       l_averages     nt_volume := nt_volume();-- Fetch Averages here
       l_stock_names  nt_stknames := nt_stknames();-- Fetch Stock Names Here
       l_c1 trc;

       -- Cursor for querying Stock_Names and Average volumes from
       -- Stock_History_table.

       stmt_str varchar(200) :=
	 'SELECT stock_name, AVG(VOLUME) FROM Stock_History 
	    GROUP BY stock_name
	    ORDER BY stock_name';
    BEGIN
       /* Use BULK FETCHING  */
       OPEN l_c1 for stmt_str;
       SELECT to_char(SYSDATE,'SSSSS') INTO l_start_time FROM dual;
       FETCH l_c1 BULK COLLECT INTO l_stock_names,l_averages;
       SELECT to_char(SYSDATE,'SSSSS') INTO l_end_time FROM dual;
       CLOSE l_c1;

       /*  Time Required To Query Data      */

       time_required := l_end_time - l_start_time;

    END qry_summary_data_withdynbulk;

   /*------------------------------------------------------------*/
   /* Function demonstrating usage of SQL%BULK_ROWCOUNT          */
   /* This function updates the stock_group of those Stocks      */
   /* having volume of transactions <= 50,to value 'L'           */
   /* Now if ith execution of DML resulted in update of k rows   */
   /* then SQL%BULK_ROWCOUNT(i) is set to k.                     */
   /* The attribute SQL%BULK_ROWCOUNT is used to return total no */
   /* of stocks updated to LOW Volume Group back to main program.*/
   /*------------------------------------------------------------*/

    FUNCTION update_stock_group(all_stock_names nt_stknames)
    RETURN NUMBER
    IS
       l_total_updated_rows NUMBER := 0;
    BEGIN

       /* This function just demonstrates the usage of implicit attribute */
       /* SQL%BULK_ROWCOUNT. Here 100 is  used to represent the sample of */
       /* stocks among all Stocks.                                        */
       /* If we use all_stock_names.COUNT instead of 100, it takes more   */
       /* time. Clearly this is not the purpose of this function.         */

       /* Bulk Update Statement */
        FORALL l_j IN 1..100
           UPDATE stock_history
           SET stock_group = 'L'
           WHERE volume <= 500 AND stock_name = all_stock_names(l_j) AND
           to_char(Trade_Date,'DD-MON-YYYY') = to_char(today,'DD-MON-YYYY');

        DBMS_OUTPUT.NEW_LINE();
  
        FOR l_j IN 1..100
        LOOP
          l_total_updated_rows := l_total_updated_rows+ SQL%BULK_ROWCOUNT(l_j);
        END LOOP;

        RETURN (l_total_updated_rows);
    END update_stock_group;

   /*------------------------------------------------------------*/
   /* Function demonstrating usage of Dynamic SQL%BULK_ROWCOUNT  */
   /* This function updates the stock_group of those Stocks      */
   /* having volume of transactions <= 50,to value 'L'           */
   /* Now if ith execution of DML resulted in update of k rows   */
   /* then SQL%BULK_ROWCOUNT(i) is set to k.                     */
   /* The attribute SQL%BULK_ROWCOUNT is used to return total no */
   /* of stocks updated to LOW Volume Group back to main program.*/
   /*------------------------------------------------------------*/

    FUNCTION dynupdate_stock_group(all_stock_names nt_stknames)
    RETURN NUMBER
    IS
       l_total_updated_rows NUMBER := 0;
       yesterday            DATE := today - 1;
    BEGIN

       /* This function just demonstrates the usage of implicit attribute */
       /* SQL%BULK_ROWCOUNT. Here 100 is  used to represent the sample of */
       /* stocks among all Stocks.                                        */
       /* If we use all_stock_names.COUNT instead of 100, it takes more   */
       /* time. Clearly this is not the purpose of this function.         */

       /* Bulk Update Statement */
        FORALL l_j IN 1..100
           EXECUTE IMMEDIATE
             'UPDATE stock_history
               SET stock_group = ''L''
               WHERE
                volume <= 500 AND stock_name = :1 AND
                to_char(trade_date,''DD-MON-YYYY'') =
                  to_char(:2,''DD-MON-YYYY'')'
             USING all_stock_names(l_j), yesterday;

        DBMS_OUTPUT.NEW_LINE();

	FOR l_j IN 1..100
	LOOP
	  l_total_updated_rows := l_total_updated_rows+ SQL%BULK_ROWCOUNT(l_j);
        END LOOP;

        RETURN (l_total_updated_rows);
    END dynupdate_stock_group;

   /*--------------------------------------------------------------*/
   /* Procedure demonstrating usage of ROWNUM to limit the amount  */
   /* of fetched data.                                             */
   /* Procedure lists first 5 lowest traded stocks today           */
   /* Note : This procedure first creates index ind_volume on table*/
   /*        stock_history which is used in select clause in cursor*/
   /*        Creating this index and using volume >= 0 clause in   */
   /*        WHERE clause in cursor l_c1 allows us to fetch first 5*/
   /*        lowest traded stocks.                                 */
   /*--------------------------------------------------------------*/


    PROCEDURE qry_lowest_volume_stocks 
    IS

     /* Cursor For Fetching Limited Rows */
     /* Cursor fetches 5 stocks having lowest volume traded today */
     CURSOR l_c1 IS 
          SELECT stock_name,volume
          FROM   Stock_History
          WHERE
          to_char(trade_date,'DD-MON-YYYY') = to_char(today,'DD-MON-YYYY')
          AND ROWNUM <= 5 AND VOLUME >= 0;

      l_stock_name   nt_stknames := nt_stknames();-- Fetch Stock Names Here
      l_volume       nt_volume := nt_volume();-- Fetch Volume Of Trading Txns
      l_i              NUMBER := 1;
    BEGIN
       DBMS_OUTPUT.NEW_LINE();
       DBMS_OUTPUT.PUT_LINE('** Fetching 5 Lowest Traded Stocks From '||
          'History Table');
       DBMS_OUTPUT.NEW_LINE();

       /* Create Index which is used for fetching first 5 lowest volume  */
       /* stocks                                                         */
       /* This index is explicitly used in where clause of cursor.       */
       /* In where clause, volume >= 0 forces SQL Engine to use the index*/
       /* created. This helps is getting first 5 lowest volume stocks.   */

       EXECUTE IMMEDIATE 
          'CREATE INDEX ind_volume ON stock_history(volume,trade_date)';

       /* Fetch Data */
       OPEN l_c1;
       LOOP
          l_stock_name.EXTEND;
          l_volume.EXTEND;
          FETCH l_c1 INTO l_stock_name(l_i),l_volume(l_i);
          EXIT WHEN l_c1%NOTFOUND;
          l_i := l_i + 1;
       END LOOP;
       l_stock_name.TRIM;
       l_volume.TRIM;
       CLOSE l_c1;

       /* Display Stocks and Volume of stocks traded */
       DBMS_OUTPUT.NEW_LINE();
       DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
       DBMS_OUTPUT.PUT_LINE(' Stock Name          Volume of stock traded ');
       DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
       FOR l_i IN 1..l_stock_name.COUNT
       LOOP
         DBMS_OUTPUT.PUT_LINE(RTRIM(l_stock_name(l_i))||'                  '||
           l_volume(l_i));
       END LOOP;
       DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
    END qry_lowest_volume_stocks;

END stock_track_pack;
/
SHOW ERRORS

SPOOL OFF
SPOOL dm030.lis

/************* Execution Starts Here ***************************/

DECLARE
   l_open  nt_values := nt_values(); -- Store Opening Values here
   l_close  nt_values := nt_values(); -- Store Closing Values here
   l_high  nt_values := nt_values(); -- Store high values here
   l_volume  nt_volume := nt_volume(); -- Store Volume Of Transactions here
   l_stock_name nt_stknames := nt_stknames(); -- Store Stock Names here
   l_i    NUMBER;
   l_time_required1 NUMBER := 0;
   l_time_required2 NUMBER := 0;
   l_time_required3 NUMBER := 0;
   l_time_required4 NUMBER := 0;
   l_time_required5 NUMBER := 0;
   l_time_required6 NUMBER := 0;
   l_max_stocks     NUMBER := 10000;
   l_total_updated_rows NUMBER := 0;
BEGIN

   /* Store 10000 Records into l_stock_name, l_open, l_close */
   /* l_high and l_volume                                   */

   FOR l_i IN 1..l_max_stocks
   LOOP
        l_open.EXTEND;
        l_close.EXTEND;
        l_high.EXTEND;
        l_volume.EXTEND;
        l_stock_name.EXTEND;
        l_open(l_i) := l_i;
        l_close(l_i) := 2 * l_i;
        l_high(l_i)  := 3 * l_i;
        l_volume(l_i) := 10 * l_i;
        l_stock_name(l_i) := 'COMPANY'||to_char(l_i);
   END LOOP;

   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT('Note : The following figures are representative of ');
   DBMS_OUTPUT.PUT_LINE('the gains that ');
   DBMS_OUTPUT.PUT('might be had by USING BULK BINDS vs WITHOUT ');
   DBMS_OUTPUT.PUT_LINE('USING BULK BINDS mechanism.');
   DBMS_OUTPUT.PUT('Actual Timings can vary depending on ');
   DBMS_OUTPUT.PUT_LINE(' the machine type and load etc.');
   DBMS_OUTPUT.NEW_LINE();

  /* Insert stock summary data WITHOUT USING BULK BINDS   */

   stock_track_pack.ins_summary_data_withoutbulk(l_stock_name, l_open,
      l_close,l_high,l_volume,l_time_required1);

  /* Insert stock summary data USING BULK BINDS   */

   stock_track_pack.ins_summary_data_withbulk(l_stock_name, l_open,
      l_close,l_high,l_volume,l_time_required2);

  /* Insert stock summary data USING DYNAMIC BULK BINDS   */

   stock_track_pack.ins_summary_data_withdynbulk(l_stock_name, l_open,
      l_close,l_high,l_volume,l_time_required3);

  /* Query stock summary data WITHOUT USING BULK BINDS   */

   stock_track_pack.qry_summary_data_withoutbulk(l_time_required4);

  /* Query stock summary data USING BULK BINDS   */

   stock_track_pack.qry_summary_data_withbulk(l_time_required5);

  /* Query stock summary data USING BULK BINDS   */

   stock_track_pack.qry_summary_data_withdynbulk(l_time_required6);

   DBMS_OUTPUT.PUT('-------------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('------------------------');
   DBMS_OUTPUT.PUT_LINE('   Task                        WITH BULK     '||
       'WITHOUT  BULK    '||'WITH DYNAMIC BULK');
   DBMS_OUTPUT.PUT('                                BINDS            BINDS ');
   DBMS_OUTPUT.NEW_LINE();
   DBMS_OUTPUT.PUT('-------------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('------------------------');
   DBMS_OUTPUT.PUT_LINE('Inserting 10000 Records '|| '     '||
     to_char(l_time_required2)||' secs         '||
     to_char(l_time_required1)||' secs         '||
     to_char(l_time_required3)||' secs');
   DBMS_OUTPUT.PUT('-------------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('------------------------');
   DBMS_OUTPUT.PUT_LINE('Querying 10000 Records '|| '      '||
     to_char(l_time_required5) ||' secs         '||
     to_char(l_time_required4) ||' secs         '||
     to_char(l_time_required6) ||' secs ');
   DBMS_OUTPUT.PUT('-------------------------------------------------------');
   DBMS_OUTPUT.PUT_LINE('------------------------');
   DBMS_OUTPUT.NEW_LINE();

  /* Demonstrating Usage Of SQL%BULK_ROWCOUNT         */

   DBMS_OUTPUT.PUT_LINE('Demonstrating Usage OF SQL%BULK_ROWCOUNT : ');

   l_total_updated_rows := stock_track_pack.update_stock_group(l_stock_name);

   DBMS_OUTPUT.PUT('** Total Number Of Stocks Updated To Low Volume');
   DBMS_OUTPUT.PUT_LINE(' Group Today = '||l_total_updated_rows);
   DBMS_OUTPUT.NEW_LINE();

  /* Demonstrating Usage Of SQL%BULK_ROWCOUNT for DYNAMIC statement   */

   DBMS_OUTPUT.PUT_LINE('Demonstrating Usage OF SQL%BULK_ROWCOUNT : ');

   l_total_updated_rows := stock_track_pack.dynupdate_stock_group(l_stock_name);

   DBMS_OUTPUT.PUT('** Total Number Of Stocks Updated To Low Volume');
   DBMS_OUTPUT.PUT_LINE(' Group yesterday = '||l_total_updated_rows);
   DBMS_OUTPUT.NEW_LINE();

  /* Demonstrating Usage Of ROWNUM to fetch a limited number of rows */

   DBMS_OUTPUT.PUT_LINE('Demonstrating Usage OF ROWNUM : ');
   stock_track_pack.qry_lowest_volume_stocks;

END;
/
SPOOL OFF


/* ********** Clean Up *************************/

DROP TABLE stock_history
/
DROP TYPE nt_values;
/
DROP TYPE nt_volume;
/
DROP TYPE nt_stknames;
/
                                                                                                                             

