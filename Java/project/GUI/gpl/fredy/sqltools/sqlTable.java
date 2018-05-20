package gpl.fredy.sqltools;

/** 
    sqlTable is the Grid you often meet in Admin, it was in fact the
    first stuff I wrote to learn more about meta-data.


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

import javax.swing.event.*;
//import java.awt.print.*;
import java.util.*;
import java.awt.Dimension;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;


public class sqlTable extends JPanel implements WindowListener, ActionListener, ListSelectionListener {

public JTable tableView;
public JScrollPane scrollpane;

    public JButton editQuery;    


    boolean exportQueryEditable = true;
    
    /**
     * Get the value of exportQueryEditable.
     * @return value of exportQueryEditable.
     */
    public boolean isExportQueryEditable() {
	return exportQueryEditable;
    }
    
    /**
     * Set the value of exportQueryEditable.
     * @param v  Value to assign to exportQueryEditable.
     */
    public void setExportQueryEditable(boolean  v) {
	this.exportQueryEditable = v;
    }
    
    boolean exportQueryKeepConnectionOpen=true;
    
    /**
     * Get the value of exportQueryKeepConnectionOpen.
     * @return value of exportQueryKeepConnectionOpen.
     */
    public boolean isExportQueryKeepConnectionOpen() {
	return exportQueryKeepConnectionOpen;
    }
    
    /**
     * Set the value of exportQueryKeepConnectionOpen.
     * @param v  Value to assign to exportQueryKeepConnectionOpen.
     */
    public void setExportQueryKeepConnectionOpen(boolean  v) {
	this.exportQueryKeepConnectionOpen = v;
    }
    

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
       




    String query;
    
    /**
       * Get the value of query.
       * @return Value of query.
       */
    public String getQuery() {return query;}
    
    /**
       * Set the value of query.
       * @param v  Value to assign to query.
       */
    public void setQuery(String  v) {this.query = v;}
    

  public sqlTable (String host, 
		   String user,
		   String password,
		   String database, 
		   String query) {
    setHost(host);
    setUser(user);
    setPassword(password);
    setDatabase(database);
    setQuery(query);

    doIt();
 
  }

  public sqlTable(t_connect con, String query) {
    setCon(con);
    setQuery(query);
    doIt();
  }

  public sqlTable(t_connect con, 
		  String query,
		  boolean exportQueryEditable,
		  boolean exportQueryKeepConnectionOpen) {
    setCon(con);
    setExportQueryEditable(exportQueryEditable);
    setExportQueryKeepConnectionOpen(exportQueryKeepConnectionOpen);
    setQuery(query);
    doIt();
  }




 private void doIt() {
     this.removeAll();
     if ( getQuery().indexOf("@") > 0 ) {

		final SqlParser sqp = new SqlParser(getQuery());
		sqp.cancel.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		       sqp.close();
		  }});

		sqp.ok.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		       setQuery(sqp.getParsed());
		       sqp.close();
		       doIt();
		  }});
    } else {

	JDBCAdapter dt = new JDBCAdapter(getCon());
	dt.executeQuery(getQuery());
	tableView = new JTable(dt);
	tableView.getSelectionModel().addListSelectionListener(this);
	tableView.getTableHeader().setReorderingAllowed(false);
	tableView.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	scrollpane = new JScrollPane();
	scrollpane.getViewport().add(tableView);
	
	JPanel panel = new JPanel();
	BorderLayout layout = new BorderLayout();
	panel.setLayout(layout); 
	panel.add("Center",scrollpane);
    

	RepaintManager.currentManager(this).setDoubleBufferingEnabled(true);
	
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	final JButton exportButton = new JButton("Export");
	
	exportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {                    
		    DataExportGui eq = new DataExportGui(getCon().con,
							 getQuery(),
							 isExportQueryEditable(),
							 isExportQueryKeepConnectionOpen()); 
		    eq.setLocationRelativeTo(exportButton);
		}});
	
	editQuery = new JButton("Edit Query");
	editQuery.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    final JDialog dialog = new JDialog();
		    dialog.setTitle("Edit Query");
		    dialog.getContentPane().setLayout(new BorderLayout());
		    final gpl.fredy.ui.TextEditor te = new gpl.fredy.ui.TextEditor();
		    dialog.getContentPane().add(BorderLayout.CENTER,te);
		    te.setText(getQuery());
		    te.ok.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				setQuery(te.getText());
				doIt();
				dialog.dispose();
			    }
			});
		    
		    te.cancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			    }
			});	
		    dialog.setLocationRelativeTo(editQuery);
		    dialog.pack();
		    dialog.setVisible(true);
		}
	    });
	



	buttonPanel.add(new JLabel(Integer.toString(dt.getNumRows()) + " Number of Rows"));
	buttonPanel.add(exportButton);
	buttonPanel.add(editQuery);
	panel.add("South",buttonPanel);
	
	BorderLayout layout1 = new BorderLayout();
	this.setLayout(layout1);   
	this.add("Center",panel);
	this.updateUI();
    }

}





  // this handles Window-Events
  public void windowClosing(WindowEvent evt) {
   
  }  
  public void windowActivated(WindowEvent evt) {;}  
  public void windowDeactivated(WindowEvent evt) {;}  
  public void windowIconified(WindowEvent evt) {;}  
  public void windowDeiconified(WindowEvent evt) {;}  
  public void windowOpened(WindowEvent evt) {;}  
  public void windowClosed(WindowEvent evt) {;}  
     
 

  //Handling List Events
  public void valueChanged(ListSelectionEvent e) {;}

  // handling AWT-Events
  public void actionPerformed(ActionEvent evt) {;}

  
  public static  void main(String args[]) {
    if (args.length != 5 ) {
     System.out.println("Syntax: java sqlTable host user password database query");
     }
  else {
    //sqlTable f = new sqlTable(args[0], args[1], args[2], args[3], args[4]);

    t_connect con = new t_connect(args[0], args[1], args[2], args[3]);
    sqlTable f = new sqlTable(con, args[4]);
    final JFrame frame = new JFrame("Query");
    frame.getContentPane().add(f);
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
