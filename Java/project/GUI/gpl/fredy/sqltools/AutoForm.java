package gpl.fredy.sqltools;

/** AutoForm:
 *  Version 1.0 21. February 1999
 *  is a part of Admin
 *
 *  this has been created to query mySQL-Databases
 *  it only returns a JPanel, so it can easily be
 *  used in different kind of windows
 */


/** Admin is a Tool around JDBC-enabled SQL-RDBMS to do basic jobs
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

       Copyright (C) 1999  Fredy Fischer

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/

/**

   Latest Changes: 
   27. March 2000       Delete-Function has been extended to tind primary keys
                        and if there are no primary keys it will generate a long
			where clause over all fields

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

import java.util.logging.*;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;

public class AutoForm extends JPanel {

    private Tables tableList;
    private String[] columnName;
    private String[] columnType;
    private int[] columnLength;
    private JTextField[] fieldEdit;
    private JTextArea[]  fieldArea;
    private boolean[] fieldIsArea;
    private String host;
    private JPanel mainpanel,formpanel,findPanel;
    private sqlTable sqlt;
    public Dimension vSize;

    private JScrollPane scrollFpane;

    private Logger logger;


// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002";

public String getVersion() {return fredysVersion; }


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
	return dbTable;
    }
    private String spaceFixer(String s) {
        s = s.trim();
        if (s.indexOf(' ') >= 0 ) s = "'" + s + "'";
        return s;
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
    
     

    public AutoForm  (String host,String user, String password, String database, String schema) {
	setHost(host);
	setUser(user);
	setPassword(password);
	setDatabase(database);
	setSchema(schema);

	init();
    }

  public AutoForm(t_connect con,String schema) {
    setCon(con);
    setSchema(schema);
    init();
  }

  public AutoForm(t_connect con) {
    setCon(con);
    setSchema("%");
    init();
  }


  private void init() {

      logger = Logger.getLogger("gpl.fredy.admin");

      vSize = new Dimension(400,150);
      
      
      this.setLayout(new BorderLayout());
      this.add("West",selectTable());
      this.add("South",buttonPanel());
      this.add("Center",mainPanel());
  }

    private JPanel mainPanel() {

	mainpanel = new JPanel();
	mainpanel.setLayout(new BorderLayout());
	formpanel = formPanel();
	mainpanel.add("Center",formpanel);
  
	return mainpanel;
    }


    /** this is the List that contains the available tables in
     *  the Database
     */

    private JPanel selectTable() {
       String[] table;	

       tableList = new Tables(getCon(),getSchema());
       tableList.setSelectedIndex(0);

       // set the Listener onto the table-List
       MouseListener mouseListener = new MouseAdapter() {
       public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 2) {
	     doUpdate();
	 }
       }};
       tableList.addMouseListener(mouseListener);
        
       JScrollPane listPane = new JScrollPane();
       listPane.getViewport().add(tableList);
       tableList.setSelectedIndex(0);

       JPanel panel = new JPanel();
       panel.add(listPane);
       return panel;
    }


    private void doUpdate() {
	mainpanel.remove(formpanel);
	try {
	    mainpanel.remove(findPanel);
	} catch (Exception e) { ; }
	formpanel = formPanel();
	mainpanel.add("Center",formpanel);
	mainpanel.updateUI();
    }

    private JPanel buttonPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	panel.setBorder(BorderFactory.createEtchedBorder());

	ImageButton find = new ImageButton("Find","binocular.gif","list all records");
	find.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		listTable();
	}});
 


	ImageButton insert = new ImageButton("Insert","insert.gif","Insert");
	insert.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		execQuery(createInsertQuery());
	}});
 
	ImageButton modify = new ImageButton("Update","update.gif","Update this row");
	modify.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		execQuery(createModifyQuery());
	}});
 
	ImageButton delete = new ImageButton("Delete","delete.gif","Delete this row");
	delete.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String string1 = "Yes";
		String string2 = "No";
		Object[] options = {string1, string2};
		int n = JOptionPane.showOptionDialog(null,
                              "You are about to delete " + getNumberOfRecords() + " Record(s)",
                              "Delete  ?",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,     //don't use a custom Icon
                              options,  //the titles of buttons
                              string2); //the title of the default button
		if (n == JOptionPane.YES_OPTION) {
		    execQuery(createDeleteQuery());
		    doUpdate();
		}
		}});
	
	cancel = new JButton("Cancel");
	ImageButton imb = new ImageButton();
	ImageIcon i1 = imb.getImageIcon("exit.gif");
	ImageIcon i2 = imb.grayed(i1.getImage());
	cancel.setIcon(i2);
	cancel.setRolloverIcon(i1);
	cancel.setRolloverEnabled(true);
	cancel.setToolTipText("Exit");

	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {		    
		    close();
		    }});
	


	panel.add(find);
	panel.add(insert);
	panel.add(modify);
	panel.add(delete);
	panel.add(cancel);
	
	return panel;

    }

    private void openConnection() {
	con = new t_connect(getHost(), getUser(), getPassword(),getDatabase());
	if (con.getError() != null) {
           message(con.getError());
	   con  = null;
	}
    }
	  
    protected void finalize() {
	close();
    }


    public void close() { 
	try {
	    con.close(); 
	} catch (Exception forPostgres) { ; }
    }


    /** this fills the columns with the actual selected table
     **/
    private void setColumns() {
       String[] columns;	
       int i = 0;
       if ( con == null ) openConnection();
       try {
	   
	   // this is to count the columns to create the array...
	   DatabaseMetaData md = con.con.getMetaData();
	   ResultSet cc = md.getColumns(null,null,getDbTable(),"%");
	   while (cc.next()) { i++;}
	   
	   
	   ResultSet cols = md.getColumns(null,null,getDbTable(),"%");
	   columnName     = new String[i];
	   columnType     = new String[i];
	   columnLength   = new int[i];
	   fieldEdit      = new JTextField[i];
	   fieldArea      = new JTextArea[i];
	   fieldIsArea    = new boolean[i];
	   
	   i = 0;
	   while (cols.next()) {
	       columnName[i]   = cols.getString(4);
	       columnType[i]   = cols.getString(5);
	       columnLength[i] = cols.getInt(7);
	       i++;
	   }  
       } catch (Exception exception) {
	   exception.printStackTrace();
	   message(exception.getMessage().toString());
       }
    } 



    private JPanel formPanel() {

	setColumns();
	fieldEditor();
	Insets insets = new Insets(1,1,1,1);
	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());

	GridBagConstraints gridBagConstraints1;
	for (int i = 0; i < columnName.length; i++) {
	    gridBagConstraints1 = new GridBagConstraints ();
	    gridBagConstraints1.anchor=GridBagConstraints.NORTHEAST;
	    gridBagConstraints1.insets = insets;
	    panel.add((JLabel) new JLabel(columnName[i]),gridBagConstraints1);	    
	    gridBagConstraints1 = new GridBagConstraints ();
	    gridBagConstraints1.gridwidth = 0;
	    gridBagConstraints1.anchor=GridBagConstraints.WEST;
	    gridBagConstraints1.insets = insets;

	    if (fieldIsArea[i] ) {
		panel.add(renderer(i),gridBagConstraints1);
		//panel.add(fieldArea[i],gridBagConstraints1 );
	    } else {
		fieldEdit[i].setAlignmentY(Component.LEFT_ALIGNMENT);
		panel.add(fieldEdit[i],gridBagConstraints1);
	    }
	}

	scrollFpane = new JScrollPane(panel);
	//scrollpane.getViewport().setExtentSize(getVSize());
	//scrollpane.getViewport().add(panel);
	scrollFpane.setPreferredSize(getVSize());

	JPanel panel2 = new JPanel();
	panel2.setLayout(new FlowLayout());
	//panel2.setSize(getVSize());
	panel2.add(scrollFpane);

	return panel2;
    }

    public void setVSize(int x, int y) { vSize.setSize(x,y); }
    public Dimension getVSize() { return vSize; }
    public void setFormSize() { scrollFpane.setPreferredSize(getVSize());}

    private JPanel renderer(int i) {
	    fieldArea[i].setWrapStyleWord(true);
	    fieldArea[i].setLineWrap(false);
	    JScrollPane scrollpane = new JScrollPane();
	    scrollpane.getViewport().add(fieldArea[i]);
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout());
	    panel.add(scrollpane);
	    panel.setAlignmentY(Component.LEFT_ALIGNMENT);
	    return panel;
    }

    private void fieldEditor() {

      //System.err.println("Number of columns: " + columnName.length);
	for (int i=0; i < columnName.length; i++ ) {
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.CHAR ) {
	       setField(i);
		   fieldIsArea[i]  = false;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.VARCHAR ) {
	       setField(i);
	       fieldIsArea[i]  = false;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.LONGVARCHAR ) {
	       setArea(i);
	       fieldIsArea[i]  = true;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.BINARY ) {
	       setArea(i);
	       fieldIsArea[i]  = true;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.LONGVARBINARY ) {
	       setArea(i);
	       fieldIsArea[i]  = true;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.VARBINARY ) {
	       setArea(i);
	       fieldIsArea[i]  = true;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.DATE ) {
	       setField(i);
	       fieldIsArea[i]  = false;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.TIME )  {
	       setField(i);
	       fieldIsArea[i]  = false;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.TIMESTAMP ) {
	       setField(i);
	       fieldIsArea[i]  = false;
	   }
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.OTHER ) {
	       setField(i);
	       fieldIsArea[i]  = false;
	   }       
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.INTEGER ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }       
	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.BIGINT ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.DECIMAL ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }      
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.DOUBLE ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }      
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.FLOAT ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }      
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.NUMERIC ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }    
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.REAL ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }       
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.SMALLINT ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }    
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.TINYINT ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }   
       	   if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.BIT ) {
	       setNumber(i);
	       fieldIsArea[i]  = false;
	   }     
	   if ( columnLength[i] > 25) {
	      setArea(i);
	      fieldIsArea[i]  = true;
	   }
    }

    }


    private void setField(int i) {
	fieldEdit[i] = new JTextField();
	int k = columnLength[i];
	if ( k >40 ) k = 40;
	fieldEdit[i].setColumns(k); 
    }
    private void setArea(int i) {
	fieldArea[i] = new JTextArea();
	fieldArea[i].setColumns(20);
	fieldArea[i].setRows(5);
    }
    private void setNumber(int i)  { 
	fieldEdit[i] = new JTextField();
	fieldEdit[i].setColumns(10); 
    }

    private void message(String msg) {
        JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.WARNING_MESSAGE);
    }


    private void execQuery(String query) {
	if ( con == null ) getCon();
	try {
	    int records = con.stmt.executeUpdate(query);
	    logger.log(Level.INFO,"User " + getUser() + " exec. SQL-cmd effected " + 
		       Integer.toString(records) + " Rows with this: " + query);
            	    	   
	} catch (Exception excpt) {
	    logger.log(Level.WARNING,"User " + getUser() + " throws exception: " + excpt.toString() + 
		       " with this " + query);
	    message(excpt.getMessage().toString());
	}
    }




    public String createInsertQuery() {
	String query;
	query = "insert into " + spaceFixer(getDbTable()) + " (";
	for (int i =0; i < columnName.length; i++ ) {
	    if (i > 0) query = query + ", ";
	    query = query + spaceFixer(columnName[i]);
	}
	query = query + ") values (";

	for (int j =0; j < columnName.length;j++) {
	    if (j > 0 ) query = query + ", ";
	    query = query + fieldType(j);
	    if (fieldIsArea[j]) {
		query = query + fieldArea[j].getText();
	    } else {
		query = query + fieldEdit[j].getText();
	    }
	    query = query + fieldType(j);
	}
	query = query + ")";
	return query;

    }


    public String createModifyQuery() {
	String query;
	query = "update " + spaceFixer(getDbTable()) + " set ";
	for (int i =0; i < columnName.length; i++) {
	    if (i > 0) query = query + ",";
	    query = query + "\n" + spaceFixer(columnName[i]) + "=" + fieldType(i);
	    if (fieldIsArea[i]) {
		query = query + fieldArea[i].getText();
	    } else {
		query = query + fieldEdit[i].getText();
	    }
	    query = query + fieldType(i);	    
	}

	query = query + "\n" + getWhereClause();
	return query;
    }

    public String createDeleteQuery() {
	String query;

	query = "delete from " + spaceFixer(getDbTable()) + "\n" + getWhereClause();

	return query;	

    }

    public String getWhereClause() {

	String query = getPrimaryKey();
	if ( query.length() < 5 ) {
	    query =" where \n";
	    for (int i =0; i < columnName.length; i++) {
		if ( i > 0) query = query + " \nand ";
		query = query + spaceFixer(columnName[i]) + "=" + fieldType(i);
		if (fieldIsArea[i]) {
		    query = query + fieldArea[i].getText();
		} else {
		    query = query + fieldEdit[i].getText();
		}
		query = query + fieldType(i);
	    }
	}
	return query;

    }
    public String getNumberOfRecords() {
	ResultSet sqlresult;
	String s="";
	String query = "select count(*) from " + spaceFixer(getDbTable()) + getWhereClause();

	if (con == null ) openConnection();
	try {
            sqlresult = con.stmt.executeQuery(query);
	    sqlresult.next();
	    s = Integer.toString(sqlresult.getInt(1));
	} catch (Exception e) {
	    logger.log(Level.WARNING,"User " + getUser() + 
		       " throws exception " + e.getMessage().toString() + " with this cmd: " + query);
	    s = "0";
	}
	return s;

    }


    public String  getPrimaryKey() {
       String query="";
       int ind=0;
       if (con  == null ) openConnection();

       try {
	   DatabaseMetaData db = con.con.getMetaData();	
	   ResultSet keys = db.getPrimaryKeys(getDatabase(),getDatabase(),getDbTable());
	   boolean notFirst = false;
	   while (keys.next() ) {   
	       if (notFirst) query = query + "\nand\n";
	       notFirst = true;
	       int i = getTableIndex(keys.getString(4));
	       query = query + keys.getString(4) + "=" + fieldType(i);
	       if (fieldIsArea[i]) {
		   query = query + fieldArea[i].getText();
	       } else {
		   query = query + fieldEdit[i].getText();
	       }
	       query = query + fieldType(i);
	   }
	   if (query.length() > 1 )  query = " where\n" + query;
       }  catch (Exception exception) {
           logger.log(Level.WARNING,"User: " + getUser() + " can not get primary key on " + 
		      getDatabase() + "." + getDbTable() + " Exception: " +
		      exception.getMessage().toString());
	   query = "";
       }       
       return query;
    }

    private int getTableIndex(String name) {
	int ind=0;
	for (int i=0;i < columnName.length; i++) {
	    if (columnName[i].compareTo(name) == 0) ind = i;
	}
	return ind;
    }

    private String fieldType(int i) {

       String ft=" ";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.CHAR ) ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.VARCHAR ) ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.LONGVARCHAR )    ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.BINARY )  ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.LONGVARBINARY )   ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.VARBINARY ) ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.DATE ) ft="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.TIME ) ft ="'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.TIMESTAMP ) ft = "'";
       if ( Integer.parseInt(columnType[i]) ==  java.sql.Types.OTHER ) ft = "'";
       return ft;

    }

    private void listTable() {
	findPanel = new JPanel();
	findPanel.setLayout(new FlowLayout());

	sqlt = new sqlTable(getCon(),"select * from " + spaceFixer(getDbTable()));
	sqlt.tableView.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent e) {
		String text=" ";
		for (int i = 0; i < columnName.length; i++) {
		    try {
			text = sqlt.tableView.getValueAt(sqlt.tableView.getSelectedRow(),i).toString();
		    } catch (Exception aException) { text = " "; }
		    if ( fieldIsArea[i] ) {
			fieldArea[i].setText(text);
		    } else {
			fieldEdit[i].setText(text);
		    }
		}
		//sqlt.dispose();
		mainpanel.remove(findPanel);
		mainpanel.updateUI();
	    }});


	 JScrollPane scrollpane = new JScrollPane(sqlt.tableView);
         Dimension d = new Dimension(400,80);
         sqlt.tableView.setPreferredScrollableViewportSize(d);
	 
	 findPanel.add(scrollpane);
	 mainpanel.add("South",findPanel);
	 mainpanel.updateUI();
    }

    private void setPanelReserved(boolean b) { 	this.setEnabled(b); }

    public static void main(String args[]) {

	if ( args.length != 5) {
	    System.out.println("Fredy's AutoForm ist a part of Admin\n" +
			       "its Syntax is as ususal\n" +
			       "java gpl.fredy.sqltools.AutoForm host user password db schema\nwhere schema can be a valid schema or %");
	    System.exit(0);
	}
	t_connect con = new t_connect(args[0],args[1],args[2],args[3]);
	final AutoForm af = new AutoForm(con,args[4]);
	JFrame frame = new JFrame("AutoForm");
	frame.getContentPane().add(af);
	frame.pack();
	frame.setVisible(true);
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {
	
		System.exit(0);
	    }
            public void windowDeactivated(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowOpened(WindowEvent e) {}});
	af.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	
	


    }

}

    
