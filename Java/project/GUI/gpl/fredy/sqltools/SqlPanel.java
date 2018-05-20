package gpl.fredy.sqltools;


/** 
 * SqlPanel is part of David Good's contribution to Admin
 *
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

**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
//import javax.swing.SwingUtilities;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;import javax.swing.event.*;




public class SqlPanel extends JPanel implements  ActionListener, ListSelectionListener,SqlTab {

public JTable tableView;
public JScrollPane scrollpane;
private int iRows;
private String SQLError;

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


    String host="localhost";

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
    
    private String query;
    
    /**
       * Get the value of query.
       * @return Value of query.
       */
    public String getQuery() {
        return query;
    }
    
    /**
       * Set the value of dbTable.
       * @param v  Value to assign to dbTable.
       */
    public void setQuery(String  v) {this.query = v;}
  
    
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
    
     


  public SqlPanel (String host, String user, String password,String db, String query) {
   
    setHost(host);
    setUser(user);
    setPassword(password);
    setDatabase(db);
    setQuery(query);
    init();
  }

  public SqlPanel(t_connect con, String query) {
    setCon(con);
    setQuery(query);
    init();
  }


  private void init() {
    this.setLayout(new GridBagLayout());    

    JDBCAdapter dt = new JDBCAdapter(getCon());
    dt.executeQuery(getQuery());
    iRows = dt.getNumRows();
    SQLError = dt.getSQLError();
    tableView = new JTable(dt);
    tableView.getSelectionModel().addListSelectionListener(this);
    tableView.getTableHeader().setReorderingAllowed(false);
    tableView.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    scrollpane = new JScrollPane(tableView);
    // scrollpane.getViewport().add(tableView);
    
    
    GridBagConstraints gbc;
    Insets insets = new Insets(1,1,1,1);
    gbc = new GridBagConstraints();
    gbc.insets = insets;
    
    gbc.anchor= GridBagConstraints.CENTER;
    gbc.fill  = GridBagConstraints.BOTH;
    gbc.weightx = 1.0; 
    gbc.weighty = 1.0;
    gbc.gridx = 0;
    gbc.gridy = 0;		  
    
    this.add(scrollpane,gbc);
    
    // this.pack();
    //this.show();
 
  }
 
	public int getNumRows()
	{
		return iRows;
	}
	

	
	public String getSQLError()
	{
		return SQLError;
	}
	
	public void setViewPortSize(Dimension d)
	{
		tableView.setPreferredScrollableViewportSize(d);
	}
	
  //Handling List Events
  public void valueChanged(ListSelectionEvent e) {;}

  // handling AWT-Events
  public void actionPerformed(ActionEvent evt) {;}

  
  public static  void main(String args[]) {
    if (args.length != 5 ) {
     System.out.println("Syntax: java SqlPanel host user password database query");
     }
  else {
        
    SqlPanel f = new SqlPanel(args[0], args[1], args[2], args[3], args[4]);
    JFrame frame = new JFrame("Table");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center",f);
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
