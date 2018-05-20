package gpl.fredy.ui;


/**  
 * this is a JComboBox with all tables of a rdbms-schema
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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import gpl.fredy.metadata.*;
import gpl.fredy.share.*;

public class TableComboBox extends JComboBox {


// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002 ";

public String getVersion() {return fredysVersion; }

    String host;
	
    /**
       * Get the value of host.
       * @return Value of host.
       */
    public String getHost() {return host;}
    
    /**
       * Set the value of host.
       * @param v  Value to assign to host.
       */
    public void setHost(String  v) {this.host = v;}
    
    String user;
    
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
    
    String password;
    
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
    
    
    String database;
    
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
       

    
    String schema;
    
    /**
       * Get the value of schema.
       * @return Value of schema.
       */
    public String getSchema() {return schema;}
    
    /**
       * Set the value of schema.
       * @param v  Value to assign to schema.
       */
    public void setSchema(String  v) {this.schema = v;}
    

    public TableComboBox(String host, String user, String password, String database, String schema) {

  	setHost(host);
	setUser(user);
	setPassword(password);
	setDatabase(database);
	setSchema(schema);
	DbInfo dbi = new DbInfo(getHost(),getUser(),getPassword(),getDatabase());
	Vector v = new Vector();
	v = dbi.getTables(getDatabase(),getSchema());
	for (int i=0;i < v.size();i++)
		  this.addItem((String)v.elementAt(i));
        this.setSelectedIndex(0);
        dbi.close();
    }

    public static void main(String args[]) {

	if (args.length !=5 ) {
	    System.out.println("TableCombox\n" +
			       "------------\n" +
			       "Syntax: java gpl.fredy.admin.TableComboBox host user password database schema\nWhere schema is a valid schema-name or %");
	} else {
	    TableComboBox tbc = new TableComboBox(args[0], args[1], args[2], args[3],args[4]);
	    JFrame frame = new JFrame("TableCombo");
	    frame.getContentPane().add(tbc);
	    frame.pack();
	    frame.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {System.exit(0);}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	    frame.setVisible(true); 
	}


    }

}
