/*
 * DataExport.java
 *
 * Created on August 9, 2003, 2:46 PM
 *
 * DataExport exports result of a SQL-query into csv
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C) August 9, 2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package gpl.fredy.sqltools;

import java.sql.*;
import java.io.*;
import java.util.logging.*;

public class DataExport {
    
    /** this is the connection to the DB used for this class */
    private Connection con = null ;
    
    /** this is the SQL-query to be executed */
    private String query = null;
    
    private File fileName = null;
    
    private PrintWriter out = null;
    
    private Logger logger = Logger.getLogger("gpl.fredy.sqltools");
    
    private java.sql.Statement stmt = null;
    
    private String wordSeparator = ";";
    
    private String stringSeparator = "\"";
    
    /** Creates a new instance of DataExport */
    public DataExport() {
    }
    
    public DataExport(java.sql.Connection con, java.io.File file, java.lang.String query) {
        
        this.setCon(con);
        this.setFileName(file);
        this.setQuery(query);
        export();
    }
    
    /** get the connection to the DB to use for queries */
    public Connection getCon() {
        return con;
    }
    
    public void setCon(java.sql.Connection v) {
        try {
            // Test the connection
            DatabaseMetaData dmd = v.getMetaData();
            logger.log(Level.INFO,"Connection to " + dmd.getDatabaseProductName());
            this.con = v;
        } catch (SQLException sqle) {
            logger.log(Level.WARNING,"Connection not established");
            logger.log(Level.INFO,"resetting connection to null");
            this.con = null;
        }
    }
    
    public String getQuery() {
        return query;
    }
    
    public void setQuery(java.lang.String v) {
        logger.log(Level.INFO,"Query is : " + v );
        this.query = v;
    }
    
    public void setFileName(java.io.File v) {
        logger.log(Level.INFO,"Seeting Filename to : "  + v.getName());
        this.fileName = v;
    }
    
    public java.io.File getFileName() {
        return fileName;
    }
    
    
    
    public PrintWriter getOut() {
        if ( getFileName() != null ){
            try {
                out =  new PrintWriter(new FileOutputStream(getFileName()));
            } catch (FileNotFoundException fne) {
                logger.log(Level.WARNING,"Can not open file " + getFileName().getName());
                logger.log(Level.FINE,"Message: " + fne.getMessage().toString());
                out = null;
            }
        }
        return out;
    }
    
    public java.sql.Statement getStmt() {
        if (stmt == null ) {
            try {
                stmt = getCon().createStatement();
                logger.log(Level.FINE,"Statement created");
            } catch ( SQLException sqle ) {
                logger.log(Level.WARNING,"can not create Statement");
                logger.log(Level.FINE,"Message: " + sqle.getMessage().toString());
            }
        }
        return stmt;
    }
    
    /** */
    public void export() {
        
        if ( ( getCon() != null) &&
        ( getStmt()     != null) &&
        ( getQuery()    != null) &&
        ( getFileName() != null) ) {
            
            ResultSet rs = null;
            ResultSetMetaData rsmd = null;
            int lineCounter = 0;
            // execute the query and fetch metadata of the result
            try {
                rs = stmt.executeQuery(getQuery());
                rsmd = rs.getMetaData();
            } catch (SQLException sqle1) {
                logger.log(Level.WARNING,"can not execute query");
                logger.log(Level.FINE,"Message: " + sqle1.getMessage().toString());
            }
            
            // here we loop the result row by row
            getOut();
            try {
                while ( rs.next() ) {
                    // we have now to loop every single row to get its attributes
                    for (int i = 0; i < rsmd.getColumnCount(); i++ ) {
                        if ( i > 0) out.print(getWordSeparator());
                        try {
                            // depending on the type, export the data
                            switch (rsmd.getColumnType(i+1) ) {
                                case java.sql.Types.INTEGER:
                                    out.print(rs.getInt(i+1));
                                    break;
                                case java.sql.Types.FLOAT:
                                    out.print(rs.getFloat(i+1));
                                    break;
                                case java.sql.Types.DOUBLE:
                                    out.print(rs.getDouble(i+1));
                                    break;
                                case java.sql.Types.DECIMAL:
                                    out.print(rs.getFloat(i+1));
                                    break;
                                case java.sql.Types.NUMERIC:
                                    out.print(rs.getFloat(i+1));
                                    break;
                                case java.sql.Types.BIGINT:
                                    out.print(rs.getInt(i+1));
                                    break;
                                case java.sql.Types.TINYINT:
                                    out.print(rs.getInt(i+1));
                                    break;
                                case java.sql.Types.SMALLINT:
                                    out.print(rs.getInt(i+1));
                                    break;
                                case java.sql.Types.DATE:
                                    out.print(rs.getDate(i+1).toString());
                                    break;
                                default:
                                    out.print(getStringSeparator());
                                    out.print(rs.getString(i+1));                                 
                                    out.print(getStringSeparator());
                                    break;
                            }
                        } catch (Exception e) {
                            logger.log(Level.WARNING,"unknown type, ignoring attribute");
                            e.printStackTrace();
                            //logger.log(Level.FINE,"Message: " + e.getMessage().toString());
                        }
                    }
                    lineCounter++;
                    out.println();
                }
                out.flush();
                out.close();
                logger.log(Level.INFO,"Exported " + Integer.toString(lineCounter) + " Lines");
            }   catch (   SQLException sqle2) {
                logger.log(Level.WARNING,"can not loop  data");
                logger.log(Level.FINE,"Message: " + sqle2.getMessage().toString());
            }
        } else {
            logger.log(Level.WARNING,"Export not successfull");
        }
    }
    
    public void setStringSeparator(java.lang.String v) {
        this.stringSeparator = v;
    }
    public String getStringSeparator() {
        return this.stringSeparator;
    }
    public void setWordSeparator(java.lang.String v) {
        this.wordSeparator = v;
    }
    public String getWordSeparator() {
        return this.wordSeparator;
    }
    
    public String getInfo() {
        return "This is Fredy's Query-CSV-Exporter.\n" +
               "DataExport is under LGPL\n\n" +
               "Usage: 1) DataExport de = new DataExport();\n" +
               "          de.setCon(java.sql.Connection); // this is the connection to your DB\n" +
               "          de.setFileName(java.io.File);  // this is the target export file\n" +
               "          de.setQuery(java.lang.String); // this is your query to the DB\n" +
               "          de.export(); // this writes your File\n\n" +
               "       2) DataExport de = new DataExport(java.sql.Connection,\n" +
               "                                         java.io.File,\n" +
               "                                         java.lang.String); // does it in one step\n\n" +
               "Other values: setStringSeparator(java.lang.String) this sets the String, \n" +
               "                                                   a Text-Field is enclosed by (default \") \n\n" +
               "              setWordSeparator(java.lang.String)   this is the String, \n" +
               "                                                   every Field is terminated by (default ;)";
    }
    
}
