/*
 * ForeignKeys.java
 *
 * Created on September 7, 2003, 10:55 AM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) September 7, 2003, Fredy Fischer
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

package gpl.fredy.metadata;

import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author  afs
 */
public class ForeignKeys {
    private Connection con;
    
    private Logger logger = Logger.getLogger("gpl.fredy.metadata");
    private String table=null;
    public void setTable(String v) {
        this.table = v;
    }
    public String getTable() {
        return this.table;
    }
    private String schema=null;
    public void setSchema(String v) {
        if ( v.equals("%")) v = null;
        this.schema = v;
    }
    public String getSchema() {
        return this.schema;
    }
    
    /** Creates a new instance of ForeignKeys */
    public ForeignKeys() {
    }
    
    private DatabaseMetaData dmd = null;
    public void setDmd(DatabaseMetaData v) { dmd = v; }
    public DatabaseMetaData getDmd() { return dmd; }
    
    public ForeignKeys(java.sql.Connection con, java.lang.String schema,java.lang.String table) {
        setCon(con);
        setTable(table);
        setSchema(schema);
    }
    
    public void setCon(java.sql.Connection v) {
        this.con = v;
    }
    public java.sql.Connection getCon() {
        return this.con;
    }
    
    public String getImportedKeys(String tableName,String columnName) {
        StringBuffer sb = new StringBuffer();
        try {
            if ( getDmd() == null ) dmd = getCon().getMetaData();
            ResultSet resultSet = dmd.getImportedKeys(getCon().getCatalog(),getSchema(),getTable());
            while (resultSet.next()) {
                if ( (resultSet.getString(7).equalsIgnoreCase(tableName) ) && ( resultSet.getString(8).equalsIgnoreCase(columnName)) ){
                    if (sb.length() > 2) sb.append(" , ");
                    sb.append(resultSet.getString(3));
                    sb.append(".");
                    sb.append(resultSet.getString(4));
                }
            }
        } catch (SQLException sqle) {
            logger.log(Level.WARNING,"Exception while fetching Foreignkeys of Table " + getTable());
            logger.log(Level.FINE,"Exception is: " + sqle.getMessage().toString());
            logger.log(Level.FINE,"SQL-State is: " + sqle.getSQLState());
            logger.log(Level.FINE,"Error-Code is  : " + sqle.getErrorCode());
        }
        return sb.toString();
    }
    public String getExportedKeys(String tableName,String columnName) {
        StringBuffer sb = new StringBuffer();
        try {
            if (getDmd() == null) dmd = getCon().getMetaData();
            ResultSet resultSet = dmd.getExportedKeys(getCon().getCatalog(),getSchema(),getTable());
            while (resultSet.next()) {
                if ( (resultSet.getString(3).equalsIgnoreCase(tableName) ) && ( resultSet.getString(4).equalsIgnoreCase(columnName)) ){
                    if (sb.length() > 2) sb.append(" , ");
                    sb.append(resultSet.getString(7));
                    sb.append(".");
                    sb.append(resultSet.getString(8));
                }
            }
        } catch (SQLException sqle) {
            logger.log(Level.WARNING,"Exception while fetching Foreignkeys of Table " + getTable());
            logger.log(Level.FINE,"Exception is: " + sqle.getMessage().toString());
            logger.log(Level.FINE,"SQL-State is: " + sqle.getSQLState());
            logger.log(Level.FINE,"Error-Code is  : " + sqle.getErrorCode());
        }
        return sb.toString();
    }
        
    public void printForeignKeys() {
        System.out.println("....getImportedKeys....");
        try {
            DatabaseMetaData dmd = getCon().getMetaData();
            ResultSet resultSet = dmd.getImportedKeys(getCon().getCatalog(),getSchema(),getTable());
            while (resultSet.next()) {
                System.out.println("Primary key table catalog       : " + resultSet.getString(1));
                System.out.println("Primary key table schema        : " + resultSet.getString(2));
                System.out.println("Imported primary key table name : " + resultSet.getString(3));
                System.out.println("Primary key column name         : " + resultSet.getString(4));
                System.out.println("Foreign key table catalog       : " + resultSet.getString(5));
                System.out.println("Foreign key table schema        : " + resultSet.getString(6));
                System.out.println("Foreign key table name          : " + resultSet.getString(7));
                System.out.println("Foreign key column name         : " + resultSet.getString(8));
                System.out.println("Seqence number in a foreign key : " + resultSet.getShort(9));
                System.out.println("Update rule                     : " + resultSet.getShort(10));
                System.out.println("Delete rule                     : " + resultSet.getShort(11));
                System.out.println("Foreign key name                : " + resultSet.getString(12));
                System.out.println("Primary key name                : " + resultSet.getString(13));
                System.out.println("Deferability                    : " + resultSet.getShort(14));
            }
        } catch (SQLException sqle) {
            logger.log(Level.WARNING,"Exception while fetching Foreignkeys of Table " + getTable());
            logger.log(Level.FINE,"Exception is: " + sqle.getMessage().toString());
            logger.log(Level.FINE,"SQL-State is: " + sqle.getSQLState());
            logger.log(Level.FINE,"Error-Code is  : " + sqle.getErrorCode());
        }
        System.out.println("....getExportedKeys....");
        try {
            DatabaseMetaData dmd = getCon().getMetaData();
            ResultSet resultSet = dmd.getExportedKeys(getCon().getCatalog(),getSchema(),getTable());
            while (resultSet.next()) {
                System.out.println("Primary key table catalog       : " + resultSet.getString(1));
                System.out.println("Primary key table schema        : " + resultSet.getString(2));
                System.out.println("Imported primary key table name : " + resultSet.getString(3));
                System.out.println("Primary key column name         : " + resultSet.getString(4));
                System.out.println("Foreign key table catalog       : " + resultSet.getString(5));
                System.out.println("Foreign key table schema        : " + resultSet.getString(6));
                System.out.println("Foreign key table name          : " + resultSet.getString(7));
                System.out.println("Foreign key column name         : " + resultSet.getString(8));
                System.out.println("Seqence number in a foreign key : " + resultSet.getShort(9));
                System.out.println("Update rule                     : " + resultSet.getShort(10));
                System.out.println("Delete rule                     : " + resultSet.getShort(11));
                System.out.println("Foreign key name                : " + resultSet.getString(12));
                System.out.println("Primary key name                : " + resultSet.getString(13));
                System.out.println("Deferability                    : " + resultSet.getShort(14));
            }
        } catch (SQLException sqle) {
            logger.log(Level.WARNING,"Exception while fetching Foreignkeys of Table " + getTable());
            logger.log(Level.FINE,"Exception is: " + sqle.getMessage().toString());
            logger.log(Level.FINE,"SQL-State is: " + sqle.getSQLState());
            logger.log(Level.FINE,"Error-Code is  : " + sqle.getErrorCode());
        }
    }
    public static void main(String args[]) {
        int i = 0;
        String host = "localhost";
        String user = System.getProperty("user.name");
        String password = null;
        String database = null;
        String schema   = null;
        String table    = "%";
        
        System.out.println("\nFredy's Foreign Key info\n" +
        "------------------------\n" +
        "this lists the ForeignKeys of a given table\n" +
        "Syntax: java gpl.fredy.metadata.ForeignKeys -h host         [default: localhost]\n" +
        "                                            -u user         [default: " + System.getProperty("user.name") + "]\n" +
        "                                            -p password\n" +
        "                                            -s schema       [default: null]\n" +
        "                                            -d database\n" +
        "                                            -t table        [default: %]\n");
        
        while ( i < args.length) {
            
            if ((args[i].equals("-h") ) || (args[i].equals("-host")) ) {
                i++;
                host=args[i];
            }
            
            if  ((args[i].equals("-u")) || (args[i].equals("-user")) ) {
                i++;
                user=args[i];
            }
            if ((args[i].equals("-p")) || (args[i].equals("-password")) ) {
                i++;
                password=args[i];
            }
            if ((args[i].equals("-d")) || (args[i].equals("-db")) ) {
                i++;
                database=args[i];
            }
            if ((args[i].equals("-t"))  || (args[i].equals("-table")) ) {
                i++;
                table=args[i];
            }
            if ((args[i].equals("-s"))  || (args[i].equals("-schema")) ) {
                i++;
                schema=args[i];
            }
            i++;
        }
        
        gpl.fredy.share.t_connect tc = new gpl.fredy.share.t_connect(host,user,password, database);
        ForeignKeys fk = new ForeignKeys(tc.getCon(),schema,table);
        fk.printForeignKeys();
        tc.close();
    }
    
}
