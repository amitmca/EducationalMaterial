package gpl.fredy.sqltools;

/** 

    DropTable is the friendly person deleting tables inside Admin,
    so it is a part of Fredy's Admin

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
**/
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

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;

public class DropTable extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.4.2  16. May 2007";
LoadImage loadImage = new LoadImage();

public String getVersion() {return fredysVersion; }

    private JPanel mainPanel;
    private Tables tableList;

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
        setHost(con.getHost());
	setUser(con.getUser());
	setPassword(con.getPassword());
	setDatabase(con.getDatabase());
    }
    




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
    
    public JButton cancel;

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
    
    private String dbTable;
    
    /**
       * Get the value of dbTable.
       * @return Value of dbTable.
       */
    public String getDbTable() {
    
	dbTable = tableList.getSelectedValue().toString();
        System.out.println("DropTable: Table to Drop is: " + dbTable);
	return dbTable;
    }
    
    /**
       * Set the value of dbTable.
       * @param v  Value to assign to dbTable.
       */
    public void setDbTable(String  v) {this.dbTable = v;}


    
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
    

    public DropTable  (String host,
		       String user, 
		       String password, 
		       String database,
		       String schema) {
	setHost(host);
	setUser(user);
	setPassword(password);
	setDatabase(database);
	setSchema(schema);
	init();
    }

    public DropTable(t_connect con,
		     String schema) {
	setCon(con);
	setSchema(schema);
	init();
    }


    private void init() {


	this.setLayout(new BorderLayout());    
	this.add("Center",tablePanel());
	this.add("South",buttonPanel());

    }


    private JPanel tablePanel() {

	tableList = new Tables(getCon(),getSchema());
	JScrollPane scrollpane = new JScrollPane(tableList);
	JPanel mainPanel = new JPanel();
	mainPanel.add(scrollpane);
	return mainPanel;
    }
	
    private JPanel buttonPanel() {

	JPanel panel = new JPanel();
	ImageButton delete = new ImageButton(null,"delete.gif","Delete this table");
	delete.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		dropTable();
		}});
	
	cancel = new JButton(loadImage.getImage("exit.gif"));
	cancel.setToolTipText("Cancel operation and close GUI");
	
	panel.add(delete);
	panel.add(cancel);
	panel.setBorder(new EtchedBorder());
	return panel;

    }


    private void dropTable() {
      	String string1 = "Yes";
	String string2 = "No";
	Object[] options = {string1, string2};
	int n = JOptionPane.showOptionDialog(null,
                              "Do you really want to delete " + getDbTable()+"?",
                              "Delete Table ",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,     //don't use a custom Icon
                              options,  //the titles of buttons
                              string2); //the title of the default button
	if (n == JOptionPane.YES_OPTION) {		 
	     try {
		 
		 int records = con.stmt.executeUpdate("drop table "+ getDbTable());
		 tableList.table.remove(getDbTable());
		 tableList.updateUI();               
		 
		 message(Integer.toString(records)+" rows affected");
	     } catch (Exception excpt) {
		 System.out.println("DropTable:\n" + excpt);  
		 message(excpt.getMessage().toString());
	     } 
	}
	try {
	    this.remove(mainPanel);
	    mainPanel = tablePanel();
	    this.add("Center",mainPanel);
	    this.updateUI();
	} catch (Exception a_damned_stupid_exception) {;}

    }

    private void message(String msg) {
        JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.WARNING_MESSAGE);
    }


    public static void main(String args[]){

	String host     = "localhost";
	String user     = System.getProperty("user.name");
        String schema   = "%";
        String database = null;
        String password = null;

	System.out.println("DropTable\n" +
			   "------------\n" +
			   "Syntax: java gpl.fredy.sqltools.DropTable\n" +
			   "        Parameters: -h Host (default: localhost)\n" +
			   "                    -u User (default: " + System.getProperty("user.name") + ")\n" +
			   "                    -p Password\n" +
			   "                    -d database\n" +
			   "                    -s Schema (default: %)\n");

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

            if (args[i].equals("-s")) {
                i++;
                schema = args[i];
            }
	    i++;
	};

	if ( database == null) {
	    System.out.println("No database provided. Program stopped!");
	    System.exit(0);
	}


	t_connect con = new t_connect(host,user,password,database);
	if ( ! con.acceptsConnection() ) {
	    System.out.println("I'm not able to connect. Error:\n" + con.getError());
	    System.exit(0);
	}
		

	   
	DropTable dt = new DropTable(con,schema);
	JFrame frame = new JFrame("Fredy's Change Table");
	frame.getContentPane().add(dt);
	frame.pack();
	frame.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {System.exit(0);}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	dt.cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    System.exit(0);
		}});
	    
	frame.setVisible(true); 
    }


}
