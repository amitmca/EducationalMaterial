package applications.basics;

/** 
    HTMLcombo  creates a HTML-Form Selection  out of the 1st Field a SQL-Query
    returns.


    Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
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

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.net.*;
import java.sql.*;

public class HTMLcombo {

    private ResultSet sqlresult;
    private ResultSetMetaData metaData;

    Logger logger = Logger.getLogger("applications.basics");
   
    t_connect con;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
	return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(t_connect  v) {
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
    String name;
    
    /**
     * Get the value of name.
     * @return value of name.
     */
    public String getName() {
	return name;
    }
    
    /**
     * Set the value of name.
     * @param v  Value to assign to name.
     */
    public void setName(String  v) {
	this.name = v;
    }
    

    public HTMLcombo (String name,t_connect con, String query ) {
        setName(name);
	setCon(con);
	setQuery(query);
    }
    public HTMLcombo() {
	// Standard Constructor
    }

    public String getCombo(String name,t_connect con, String query,String defValue) {
        setName(name);
	setCon(con);
	setQuery(query);
        return getHTML(defValue);
    }
    public String getHTML(String defValue) {
	StringBuffer s =  new StringBuffer();
        s.append("<select name=\"" + getName() + "\">");
		// execute this query
	try {
	    sqlresult = con.stmt.executeQuery(getQuery());
	    metaData = sqlresult.getMetaData();
	} catch (Exception e) {  logger.log(Level.SEVERE,"Query-Error: " +e.getMessage().toString()); }
	try {
	while ( sqlresult.next() ) {
	    String v="";
	    switch (metaData.getColumnType(1) ) {
	    case java.sql.Types.INTEGER:
		v = Integer.toString(sqlresult.getInt(1));
		break;
	    case java.sql.Types.FLOAT:	
		v = Float.toString(sqlresult.getFloat(1));
		break;
	    case java.sql.Types.DOUBLE:
		v = Double.toString(sqlresult.getDouble(1));
		break;
	    case java.sql.Types.DATE:
		v = sqlresult.getDate(1).toString();
		break;
	    default:
		v =  sqlresult.getString(1);
		break;
	    }
	    s.append("<option");
	    if ( v.startsWith(defValue) ) s.append(" selected");
            s.append(">" + v );           
	    s.append("</option>\n");
          
	}
	} catch (Exception sqle) { 
	    logger.log(Level.SEVERE,"HTMLcombo Error: " +sqle.getMessage());
	}
	s.append("</select>");
	return s.toString();
    }
}
