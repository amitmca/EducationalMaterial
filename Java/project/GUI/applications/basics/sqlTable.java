package applications.basics;

/** 
    sqlTable is the Grid you often meet in Admin, it was in fact the
    first stuff I wrote to learn more about meta-data.


    Admin is a Tool around mySQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin V1.1.1
    Copyright (c) 1999 Fredy Fischer
                       se-afs@dial.eunet.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

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


public class sqlTable extends JPanel implements WindowListener, ActionListener, ListSelectionListener {

private String host, user, password,db;
public JTable tableView;
public JScrollPane scrollpane;


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
    

public sqlTable (String hostE, String userE, String passwordE,String dbE, String queryE) {
  
 this.host = hostE;
 this.user = userE;
 this.password = passwordE;
 setQuery(queryE);
 this.db = dbE;

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
 } else { doIt(); }
 
}
 private void doIt() {


 JDBCAdapter dt = new JDBCAdapter(host, user,password,db);
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
  ImageButton exportButton = new ImageButton(null,"extractdata.gif","Export to csv");

  exportButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	  final ExportQuery eq = new ExportQuery(host, user, password,db,getQuery(),"file.csv",true);
	  //eq.setQuery(query);
	  eq.selectFile();
	  
	  eq.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		eq.frame.dispose();
		}});	  
	  eq.frame.addWindowListener(new WindowAdapter() {
	      public void windowActivated(WindowEvent e) {}
	      public void windowClosed(WindowEvent e) {}
	      public void windowClosing(WindowEvent e) {eq.frame.dispose();}
	      public void windowDeactivated(WindowEvent e) {}
	      public void windowDeiconified(WindowEvent e) {}
	      public void windowIconified(WindowEvent e) {}
	      public void windowOpened(WindowEvent e) {}});	  
      }});
   buttonPanel.add(exportButton);




  /**
  JButton printButton = new JButton("Print");
  printButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

          PrinterJob pj=PrinterJob.getPrinterJob();
          pj.setPrintable(sqlTable.this);
          pj.printDialog();
          try{ 
            pj.print();
          }catch (Exception PrintException ) {System.out.println("PrintException: " +PrintException); }
	  }});

  buttonPanel.add(printButton);
  
  **/  
  panel.add("South",buttonPanel);


  BorderLayout layout1 = new BorderLayout();
  this.setLayout(layout1);   
  this.add("Center",panel);

 
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
    sqlTable f = new sqlTable(args[0], args[1], args[2], args[3], args[4]);
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
