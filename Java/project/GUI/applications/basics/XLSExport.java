package applications.basics;


/**
   XLSExport exports the result of a query into
   a XLS-file. To do this it is using HSSF from the 
   Apache POI Project: http://jakarta.apache.org/poi
   you have to put the latest POI into your CLASSPATH

   Version 1.0
   Date    7. aug. 2003
   Author  Fredy Fischer

   XLSExport is part of the Admin-Suite and under GPL

   Once instantiated there are the following steps to go
   to get a XLS-file out of a query

   XLSExport xe = new XLSExport(java.sql.Connection con)

   xe.setQuery(java.lang.String query) please set herewith the
                                       the query to get its results
				       as XLS-file

   int xe.createXLS(java.lang.String fileName) this will then create
                                           the XLS-File. If this
					   file already exists, it will
					   be overwritten!

    it returns the number of rows written to the File

**/
   

/** 
    Admin is a Tool around SQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

 
    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/




import java.io.InputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.sql.*;
import java.util.logging.*;
import java.util.Date;

import org.apache.poi.hssf.record.*;
import org.apache.poi.hssf.model.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;

import gpl.fredy.share.*;

public class XLSExport {

    private Logger logger;

    Connection con = null;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public Connection getCon() {
	return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(Connection  v) {
	this.con = v;
    }
    
    String query;
    
    /**
     * Get the value of query.
     * @return value of query.
     */
    public String getQuery() {
	return query;
    }
    
    /**
     * Set the value of query.
     * @param v  Value to assign to query.
     */
    public void setQuery(String  v) {
	this.query = v;
    }
    

    java.sql.SQLException exception;
    
    /**
     * Get the value of exception.
     * @return value of exception.
     */
    public java.sql.SQLException getException() {
	return exception;
    }
    
    /**
     * Set the value of exception.
     * @param v  Value to assign to exception.
     */
    public void setException(java.sql.SQLException  v) {
	this.exception = v;
    }
    

    /**
       Create the XLS-File  named fileName
       @param fileName is the Name (incl. Path) of the XLS-file to create

    **/
    public int createXLS(String fileName) {

	// I need to have a query to process
	if ( getQuery() == null  ) {
	    logger.log(Level.WARNING,"Need to have a query to process");
	    return 0;
	}	    

	// I also need to have a file to write into
	if (fileName == null ) {
	    logger.log(Level.WARNING,"Need to know where to write into");
	    return 0;
	}


	// I need to have a connection to the RDBMS
	if ( getCon() == null  ) {
	    logger.log(Level.WARNING,"Need to have a connection to process");
	    return 0;
	}

	Statement stmt      = null;
	ResultSet resultSet = null;
	ResultSetMetaData rsmd	= null;
	try {

	    // first we have to create the Statement
	    stmt = getCon().createStatement();

	}  catch (SQLException sqle1 ) {
	    setException(sqle1);
	    logger.log(Level.WARNING,"Can not create Statement. Message: " +
		       sqle1.getMessage().toString());
	    return 0;
	}

	logger.log(Level.FINE,"FileName: " + fileName);
	logger.log(Level.FINE,"Query   : " + getQuery());
	
	logger.log(Level.FINE,"Starting export...");


	// create an empty sheet

	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet("Data Export");
	HSSFRow r       = null;
	
	short row = 0;  // row    number
	short col = 0;  // column number
	int columnCount = 0;



	try {
	    resultSet = stmt.executeQuery(getQuery());
	    logger.log(Level.FINE,"query executed");
	} catch (SQLException sqle2) {
	    setException(sqle2);
	    logger.log(Level.WARNING,"Can not execute query. Message: " +
		       sqle2.getMessage().toString());
	    return 0;
	}

	// create Header in XLS-file
	try {
	    rsmd = resultSet.getMetaData();
	    logger.log(Level.FINE,"Got MetaData of the resultset");

	    columnCount = rsmd.getColumnCount();
	    logger.log(Level.FINE,Integer.toString(columnCount) + 
		       " Columns in this resultset");

	    r = sheet.createRow((short)row);  // titlerow
	    for (int i = 0; i < columnCount; i++) {

		// we create the cell
		HSSFCell cell = r.createCell(col);

		// set the value of the cell
		cell.setCellValue(rsmd.getColumnName(i+1));


		// then we align center
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// now we make it bold
		HSSFFont f = wb.createFont();
		f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		cellStyle.setFont(f);

		// adapt this font to the cell
		cell.setCellStyle(cellStyle);

		col++;
	    }
	} catch (SQLException sqle3 ) {
	    setException(sqle3);
	    logger.log(Level.WARNING,"Can not create XLS-Header. Message: " +
		       sqle3.getMessage().toString());
	    return 0;
	}



	// looping the resultSet
	try {
	    while ( resultSet.next() ) {

		// this is the next row
		col = 0; // put column counter back to 0 to start at the next row
		row++;  // next row

		r = sheet.createRow((short)row);
		logger.log(Level.FINE,"Created Line " + Short.toString(row));
		
		for (int i = 0; i < columnCount; i++) {	
		    try {

			
			// depending on the type, create the cell
			switch (rsmd.getColumnType(i+1) ) {
			case java.sql.Types.INTEGER:
			    r.createCell((short)col).setCellValue(resultSet.getInt(i+1));
			    break;
			case java.sql.Types.FLOAT:
			    r.createCell((short)col).setCellValue(resultSet.getFloat(i+1));
			    break;
			case java.sql.Types.DOUBLE:
			    r.createCell((short)col).setCellValue(resultSet.getDouble(i+1));
			    break;
			case java.sql.Types.DECIMAL:
			    r.createCell((short)col).setCellValue(resultSet.getFloat(i+1));
			    break;
			case java.sql.Types.NUMERIC:
			    r.createCell((short)col).setCellValue(resultSet.getFloat(i+1));
			    break;
			case java.sql.Types.BIGINT:
			    r.createCell((short)col).setCellValue(resultSet.getInt(i+1));
			    break;
			case java.sql.Types.TINYINT:
			    r.createCell((short)col).setCellValue(resultSet.getInt(i+1));
			    break;
			case java.sql.Types.SMALLINT:
			    r.createCell((short)col).setCellValue(resultSet.getInt(i+1));
			    break;

			case java.sql.Types.DATE:
			    // first we get the date
			    java.sql.Date  dat = resultSet.getDate(i+1);
			    java.util.Date date = new java.util.Date(dat.getTime());   
			    r.createCell((short)col).setCellValue(date);
			    break;
			default:
			    r.createCell((short)col).setCellValue(resultSet.getString(i+1));
			    break;
			}
		    } catch (Exception e) {
			logger.log(Level.WARNING,"unknown type,filling up with blank");
			r.createCell((short)col).setCellValue(" ");
		    }
		    col++;
		}
	    }				    
	    stmt.close();
	}  catch (SQLException sqle3 ) {
	    setException(sqle3);
	    logger.log(Level.WARNING,"Exception while writing data into sheet. Message: " +
		       sqle3.getMessage().toString());
	}


	try {
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    wb.write(fileOut);
	    fileOut.close();
	
	    logger.log(Level.INFO,"File created");
	    logger.log(Level.INFO,"Wrote: " + Integer.toString(row -1) + " lines into XLS-File");
	} catch (Exception e) {
	    logger.log(Level.WARNING,"Exception while writing xls-File: " + e.getMessage().toString());
	}
	return row - 1;
	
    }

    public XLSExport(Connection con) {
	logger = Logger.getLogger("gpl.fredy.sqltools");
	setCon(con);
    }
    public XLSExport() {
	logger = Logger.getLogger("gpl.fredy.sqltools");

    }

    public static void main(String args[] ) {

	String host = "localhost";
        String user = System.getProperty("user.name");
	String schema   = "%";
        String database = null;
        String password = null;
	String query    = null;
	String file     = null;

	System.out.println("XLSExport\n" +
			   "----------\n" +
			   "Syntax: java gpl.fredy.sqltools.XLSExport\n" +
			   "        Parameters: -h Host (default: localhost)\n" +
			   "                    -u User (default: " +
			   System.getProperty("user.name") + ")\n" +
			   "                    -p Password\n" +
			   "                    -q Query\n" +
			   "                    -d database\n" +
			   "                    -f File to write into (.xls)\n");


	int i = 0;
	while ( i < args.length) {
            if (args[i].equals("-h")) {
                i++;
                host = args[i];
            }
            if (args[i].equals("-u")) {
                i++;
                user = args[i];
            }
            if (args[i].equals("-p")) {
                i++;
                password = args[i];
            }
            if (args[i].equals("-d")) {
                i++;
                database = args[i];
            }

            if (args[i].equals("-q")) {
                i++;
                query = args[i];
            }

            if (args[i].equals("-f")) {
                i++;
                file = args[i];
            }
	    i++;

	};

	t_connect tc = new t_connect(host,user,password,database);
	XLSExport xe = new XLSExport(tc.con);
        xe.setQuery(query);
        xe.createXLS(file);
        tc.close();
    }
}


