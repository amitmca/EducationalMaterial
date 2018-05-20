package gpl.fredy.metadata;


/** 
 * It lists the available DB's of a RDBMS
 *
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
 *   version 2.1 of the License, or  any later version.
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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import gpl.fredy.share.t_connect;

public class DBList  {


// Fredy's make Version
private static String fredysVersion = "Version 1.4   2. Jan.2002";

    t_connect con=null;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
        if ( con == null) {
	    con = new t_connect(getHost(),
				getUser(),
				getPassword(),
				getDatabase());
	    if ( ! con.acceptsConnection() ) con = null;
	}
	return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(t_connect  v) {
	this.con = v;
	setUser(con.getUser());
	setHost(con.getHost());
	setPassword(con.getPassword());
	setDatabase(con.getDatabase());
    }
 


    public Vector databases;

    /**
       * Get the value of host.
       * @return Value of host.
       */

    private String host;
    public String getHost() {return host;}
    
    /**
       * Set the value of host.
       * @param v  Value to assign to host.
       */
    public void setHost(String  v) {this.host = v;}
    

    /** to find out, when the user wants to close
     *  this application, set a listener onto (JButton)AutoForm.cancel 
     **/

    private String user;
    
    /**
       * Get the value of user.
       * @return Value of user.
       */
    public String getUser() {return user;}
    
    /**
       * Set the value of user.
       * @param v  Value to assign to user.
       */
    public void setUser(String  v) {this.user = v;}
    

    private String password;
    
    /**
       * Get the value of password.
       * @return Value of password.
       */
    public String getPassword() {return password;}
    
    /**
       * Set the value of password.
       * @param v  Value to assign to password.
       */
    public void setPassword(String  v) {this.password = v;}


    private String database;
    
    /**
       * Get the value of database.
       * @return Value of database.
       */
    public String getDatabase() {return database;}
    
    /**
       * Set the value of database.
       * @param v  Value to assign to database.
       */
    public void setDatabase(String  v) {this.database = v;}
    
    private DbInfo dbi;

    
    
    /**
       * Get the value of productName.
       * @return value of productName.
       */
    public String getProductName() {return dbi.getProductName();}
    
  


    public DBList (String host,String user, String password, String database) {

       setHost(host);
       setUser(user);
       setPassword(password);
       setDatabase(database);

       init();       
    }


    public DBList(t_connect con) {
	setCon(con);
	init();

    }

    private void init() {

       dbi = new DbInfo(getCon());


    }
    



    public JComboBox toComboBox() {
	JComboBox cb = new JComboBox();
	for (int i = 0; i < getDBs().size(); i++) {
	    cb.addItem((String)dbi.getCatalog().get(i));
	}
	cb.setSelectedIndex(0);
	return cb;
    }


    public JList toJList() {
	JList list = new JList();
	list.setListData(dbi.getCatalog());
	list.setSelectedIndex(0);
	return list;
    }

    public Vector getDBs() { return dbi.getCatalog(); }


    public Vector getSchemas() {
	return dbi.getSchemas();
       
    }



    public Vector getTables(String db,String schema, String type) {

	return dbi.getTables(db,schema,type);

    }



    public String toString() {
	
	String s = "";
        //System.out.println("Size: " + databases.size());
	try {
	for (int i = 0; i < dbi.getCatalog().size(); i++) {
	    s = s + (String)dbi.getCatalog() .get(i) + "\n";
	}
	} catch (Exception unexpectedException) { s="Empty"; }
	return s;
    }


    public static void main(String args[]) {


	if (args.length != 4 ) {
	    System.out.println("DB-List\n\nSyntax: java gpl.fredy.metadata.DBList host user password database");
	    System.exit(0);
	}
	DBList dbl = new DBList(args[0],args[1], args[2], args[3]);
	System.out.println(dbl.toString());

    }


}
