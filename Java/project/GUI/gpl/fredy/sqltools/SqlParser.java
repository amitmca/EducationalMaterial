package gpl.fredy.sqltools;

/** this is a SQL-Parser for Fredy's Admin-Tool
    This parser replaces the content of a String,
    mostly a SQL-Statement, that contains values
    like @Name@ by the text it has been asked in a
    Grid.
    Example: select * from customer where name='@Name@'
             will open a window that asks for Name and
             feed this Info back to the SQl-Statement:
             select * from customer where name='fredy'

    (hope it will work)

    Version 1.0, 28. Dec. 1999
    Fredy Fischer

  
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
 *
 *
  **/


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SqlParser extends JFrame {


  private Vector v;
  private String[] entry;
  private JPanel askPanel;
  private String query;
  private String shadowQuery;
  public JButton ok, cancel;
  public void setQuery(String s) { query=s;}
  public String getQuery() { return query; }

  
    String parsed;
    
    /**
       * Get the value of parsed.
       * @return Value of parsed.
       */
    public String getParsed() {return parsed;}
    
    /**
       * Set the value of parsed.
       * @param v  Value to assign to parsed.
       */
    public void setParsed(String  v) {this.parsed = v;}
    



  public SqlParser(String q) {

    super("Fredy's SQL-Parser");
 
    v = new Vector();
    setQuery(q);
    generateElements();
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add("Center",ask());
    this.getContentPane().add("South",buttonPanel());
 
    this.pack();
    this.setVisible(true);
  }


  private JPanel ask() {


    askPanel = new JPanel();
    askPanel.setLayout(new GridLayout(v.size(),2));
    
    int m = v.size();
    entry = new String[m];

    SqlParserObject s = new SqlParserObject();
    for (int i=0; i< v.size() ; i++ ) {
       s = (SqlParserObject) v.elementAt(i);
       askPanel.add(new JLabel(s.parameter));
       askPanel.add(new JTextField("",15));
      
    }
    return askPanel;
  }


  private JPanel buttonPanel() {

    JPanel panel = new JPanel();
    ok = new JButton("ok");
    ok.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
	   parseIt() ;
         
    }});
    cancel = new JButton("Cancel");

    panel.add(ok);
    panel.add(cancel);
    return panel;

  }

  public void close() { this.dispose();}


  private void generateElements() {
    
     StringTokenizer st = new StringTokenizer(getQuery(),"@@");

     while (st.hasMoreTokens()) {
       try {
          st.nextToken();
	  SqlParserObject s = new SqlParserObject();
          s.parameter=st.nextToken();
	  s.value="";
          v.addElement(s);
       } catch (NoSuchElementException excp) { ; }
           
     }

  }


  public void parseIt() {

    int m=0;
   
    for (int n=1; n < askPanel.getComponentCount(); n=n+2) {
   
        SqlParserObject s = new SqlParserObject();
        s = (SqlParserObject) v.elementAt(m);
	JTextField jtf = (JTextField)askPanel.getComponent(n);
	s.value = jtf.getText();
        v.setElementAt((SqlParserObject)s,m);
        m++;
    }


    SqlParserObject s = new SqlParserObject();
    for (int i=0; i< v.size() ; i++ ) {
       s = (SqlParserObject) v.elementAt(i);
       parse("@"+s.parameter+"@",s.value);
    }

  }

   public void parse(String e, String element) {
	String r1, r2;
        String line = getQuery();
	int i;
	i = line.indexOf(e);
        if ( i > 0 ) {
	  r1 = line.substring(0,i);
	  r2 = line.substring(i+e.length());
          line=r1+element+r2;
	}
	setQuery(line);
	setParsed(line);
   }

  public static void main(String args[] ) {

    SqlParser s = new SqlParser(args[0]);
  }
}
