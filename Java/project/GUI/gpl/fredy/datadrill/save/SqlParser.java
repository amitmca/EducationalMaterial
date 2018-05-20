package osec.crm;

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

    HAS BEEN ADAPTED FOR OSEC to be a JPanel  

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
import java.util.logging.*;
import applications.basics.*;
import java.net.*;
import java.io.*;

public class SqlParser extends JPanel {

    private Logger logger=Logger.getLogger("osec.crm");
    private Vector v;
    private String[] entry;
    private JPanel askPanel;
    private String query;
    private String shadowQuery;
    public JButton ok, cancel;
    public void setQuery(String s) { query=s;}
    public String getQuery() { return query; }
    public String getData() {
	parseIt();
	return getQuery(); 
    }
  
    String dateiName;
    /**
     * Get the value of dateiName, der zu ladenden Datei
     * @return value of dateiName.
     */
    public String getDateiName() {
	return dateiName;
    }
    
    /**
     * Set the value of dateiName, der zu ladenden Datei
     * @param v  Value to assign to dateiName.
     */
    public void setDateiName(String  v) {
	this.dateiName = getPath() + v;
	ReadFile rf = new ReadFile(getDateiName());
	setQuery(rf.getText());
    }
    

    private String getPath() {
	URL resource = SqlParser.class.getResource("." + java.io.File.separator + "resources");
        String top = resource.getFile().toString() + java.io.File.separator;
	try {
	    top = URLDecoder.decode(top,"UTF-8");
	} catch (UnsupportedEncodingException use) { 
	    logger.log(Level.WARNING,"Can not read directory");
	    logger.log(Level.INFO,"Error: " + use.getMessage());
	    top = "";
	}

	return top;

    }

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
    



  public SqlParser(String fileName) {
 
    v = new Vector();
    setDateiName(fileName);
    generateElements();
    this.setLayout(new BorderLayout());
    this.add("Center",ask());

  }


  private JPanel ask() {


    askPanel = new JPanel();
    askPanel.setLayout(new GridBagLayout());

    GridBagConstraints gbc;
    Insets insets = new Insets(2,2,2,2);
    gbc = new GridBagConstraints();
    gbc.weightx = 1.0;     
    gbc.insets = insets;
    
    int m = v.size();
    entry = new String[m];

    SqlParserObject s = new SqlParserObject();
    gbc.gridx = 0;
    gbc.gridy = -1;

    for (int i=0; i< v.size() ; i++ ) {
       s = (SqlParserObject) v.elementAt(i);
       gbc.gridy++;
       gbc.gridx = 0;
       gbc.anchor= GridBagConstraints.WEST;
       gbc.fill  = GridBagConstraints.HORIZONTAL;

       askPanel.add(s.getComponent(),gbc);
    }
    return askPanel;
  }


  private void generateElements() {
    
     StringTokenizer st = new StringTokenizer(getQuery(),"@@");

     while (st.hasMoreTokens()) {
       try {
          st.nextToken();
	  SqlParserObject spo = new SqlParserObject();
	  String s = st.nextToken();
	  spo.setOrigText(s);
	  logger.log(Level.FINEST,"Pattern: " + s);
	  StringTokenizer sto = new StringTokenizer(s,";");
	  String typ = sto.nextToken();
	  spo.parameter = sto.nextToken();  // Label
	  String query = "";
	  if (typ.toLowerCase().equals("combo") ) query = sto.nextToken();
	  if (typ.toLowerCase().equals("twin")  ) query = sto.nextToken();

	  spo.setTyp(typ);
	  spo.setQuery(query);
	  spo.setComponent();


          v.addElement(spo);
       } catch (NoSuchElementException excp) { ; }
           
     }

  }


  public void parseIt() {

    SqlParserObject s = new SqlParserObject();
    for (int i=0; i< v.size() ; i++ ) {
       s = (SqlParserObject) v.elementAt(i);
       parse("@"+s.getOrigText()+"@",s.getText());
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
	logger.log(Level.FINEST,"Parsed line: " + line);
	setQuery(line);
	setParsed(line);
   }

  public static void main(String args[] ) {

    SqlParser s = new SqlParser(args[0]);
  }
}
