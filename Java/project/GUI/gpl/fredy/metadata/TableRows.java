package gpl.fredy.metadata;


/** 

    TableRows is the one that creates a list out of the columns
    inside a specified table. It is one of the Meta-Data-things I did
    for Admin


 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C)     2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
**/


import java.awt.*;
import javax.swing.JList;    
import java.util.*;
import java.sql.*;
import gpl.fredy.share.t_connect;

public class TableRows extends JList {

// Fredy's make Version
private static String fredysVersion = "Version 1.4   2. Jan.2002";

public String getVersion() {return fredysVersion; }

    Vector rows;

    String dbTable;
    
    /**
       * Get the value of the Table.
       * @return Value of the Table.
       */
    public String getDbTable() {return dbTable;}
    
    /**
       * Set the value of dbTable.
       * @param v  Value to assign to dbTable.
       */
    public void setDbTable(String  v) {this.dbTable = v;}
    

    /**
     * TableRow need the following:
     * @con = a object of type t_connect
     * @dbTable = the Table to read Meta-Data from
     */

    public TableRows (t_connect con, String dbTable) {

	setDbTable(dbTable);
      
	rows = new Vector();

        try {
	       DatabaseMetaData md = con.con.getMetaData();
	       ResultSet cols = md.getColumns(null,null,getDbTable(),"%");
	       while (cols.next()) {
		   rows.addElement(cols.getString(4));
	       }
	       this.setListData(rows);
	       this.setSelectedIndex(0);
	 } catch (Exception exception) {
	      
        }
     
    }

    public void removeElement(int i) {
	rows.removeElementAt(i);
	this.updateUI();
    }

}
