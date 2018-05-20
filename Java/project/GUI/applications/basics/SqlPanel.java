package applications.basics;


/** 
    sqlTable is the Grid you often meet in Admin, it was in fact the
    first stuff I wrote to learn more about meta-data.


    Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin V1.0 
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

    This has been contributed by David Good

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

public class SqlPanel extends JPanel implements  ActionListener, ListSelectionListener,SqlTab {

private String host, user, password, query;
public JTable tableView;
public JScrollPane scrollpane;
private int iRows;
private String SQLError;


public SqlPanel (String host, String user, String password,String db, String query) {
  
 this.host = host;
 this.user = user;
 this.password = password;
 this.query = query;
 this.setLayout(new FlowLayout());    

 JDBCAdapter dt = new JDBCAdapter(host, user,password,db);
 dt.executeQuery(query);
 iRows = dt.getNumRows();
 SQLError = dt.getSQLError();
 tableView = new JTable(dt);
 tableView.getSelectionModel().addListSelectionListener(this);
 tableView.getTableHeader().setReorderingAllowed(false);
 tableView.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
 scrollpane = new JScrollPane(tableView);
 // scrollpane.getViewport().add(tableView);

  this.add(scrollpane);

  // this.pack();
  //this.show();
 
}
 
	public int getNumRows()
	{
		return iRows;
	}
	
	public String getQuery()
	{
		return query;
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
