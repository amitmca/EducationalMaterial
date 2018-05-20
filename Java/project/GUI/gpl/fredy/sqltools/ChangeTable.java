package gpl.fredy.sqltools;


/** Admin is a Tool around JDBC-enabled SQL-RDBMS to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena


    Change Table is a generator around the alter-Table command





    Admin  (Version see below)
    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland


    The icons used in this application are from Dean S.  Jones 
   
    Icons Copyright(C) 1998 by Dean S.  Jones dean@gallant.com
    www.gallant.com/icons.htm    


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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.datatransfer.*;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;

public class ChangeTable extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.6  2. Jan. 2003";

public String getVersion() {return fredysVersion; }


    private Logger logger;

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
    
       
    private TableComboBox tbc;
    private TableColumns tCols;
    private JTable rows;
    private ChangeTableModel ctm;
    private Vector orig,origParam;
    private JTextArea sqlCmd, msg;
    private JCheckBox showCmd;
    private JTabbedPane tp;
    public ImageButton exit;


    public ChangeTable(String host, 
		       String user, 
		       String password, 
		       String database, 
		       String schema) {

	this.host     = host;
	this.user     = user;
	this.password = password;
	this.database = database;
	setSchema(schema);
	init();
    }


    public ChangeTable(t_connect con,String schema) {
	setCon(con);
	setSchema(schema);
	init();
    }
    public ChangeTable(t_connect con) {
	setCon(con);
	setSchema("%");
	init();
    }


    private void init() {
	
	logger = Logger.getLogger("gpl.fredy.admin");

	orig = new Vector();
        origParam = new Vector();
	sqlCmd = new JTextArea();
      

	this.setLayout(new GridBagLayout());
	GridBagConstraints gbc;
	Insets insets = new Insets(1,1,1,1);
	gbc = new GridBagConstraints();

	gbc.anchor= GridBagConstraints.CENTER;
        gbc.fill  = GridBagConstraints.NONE;
	gbc.insets = insets;
	gbc.gridx = 0;
	gbc.gridy = 0;

	//this.add(BorderLayout.CENTER,selectPanel());
	//this.add(BorderLayout.SOUTH,listPanel());

	this.add(selectPanel(),gbc);

	gbc.anchor= GridBagConstraints.CENTER;
        gbc.fill  = GridBagConstraints.BOTH;
	gbc.insets = insets;
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.weightx = 1.0;
	gbc.weighty = 1.0;
	this.add(listPanel(),gbc);
    }

    private JPanel selectPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	panel.add(new JLabel("Table:"));
	ImageButton add = new ImageButton(null,"newrow.gif","Add a Row to this table");
	ImageButton drop = new ImageButton(null,"delete.gif","Delete this row from the table");
        final ImageButton ok   = new ImageButton(null,"check.gif","generate SQL");
	exit = new ImageButton(null,"exit.gif","Exit");

	add.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        addRow();
		}});

	ok.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		alterTable();
		}});
	
	
	tbc = new TableComboBox(getHost(),getUser(),getPassword(),getDatabase(),getSchema());
	tbc.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setListContent((String)tbc.getSelectedItem());
		}});
	

	showCmd = new JCheckBox("Editor");
	showCmd.setToolTipText("To enable SQL-Command editing before executing");
	showCmd.setSelected(true);
	showCmd.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (showCmd.isSelected() ) {
		    ok.setToolTipText("generate SQL"); }
		else {  ok.setToolTipText("update Table"); }
		}});
	

	panel.add(tbc);
	panel.add(add);
	panel.add(ok);
	//panel.add(drop);
	panel.add(exit);
	panel.add(showCmd);

	return panel;

    }


    private void alterTable() {
        sqlCmd.setText("");
	String cmd = "";
	for (int i = 0; i < orig.size();i++) {
	    SingleColumnInfo sci = new SingleColumnInfo();
	    sci = (SingleColumnInfo)orig.elementAt(i);
   
	    String  param = (String)ctm.getValueAt(i,3);
            int colSize=0;
	    try {
		colSize = Integer.parseInt(param);
	    } catch (NumberFormatException nfe) { colSize=0; }

            boolean bool1 = true;
	    Boolean bool2 = new Boolean(bool1);
	    bool2 = (Boolean)ctm.getValueAt(i,ctm.NULL_FIELD);
    
	    String colName = (String)ctm.getValueAt(i,ctm.NAME_FIELD);
	    String typName = (String)ctm.getValueAt(i,ctm.TYP_FIELD);
	    String keyPara = (String)ctm.getValueAt(i,ctm.ADD_FIELD);
            

	    if ( ( sci.getColumn_name() !=colName  )  ||
		 ( sci.getType_name().toLowerCase()!= typName.toLowerCase() )  ||
		 (  (boolean)sci.isNullable()      != bool2.booleanValue() )   ||
		 (  keyPara   != (String)origParam.elementAt(i) ) ||     // a change because AutoIncr etc
		 (  (int)sci.getColumn_size()      != colSize ) ) {
		 cmd = "alter table " + tbc.getSelectedItem() + 
		        " modify " + sci.getColumn_name() + " " + typName;
		
                 if ( (param.length() > 0) && (Character.isDigit(param.trim().charAt(0))) ) {
		     cmd = cmd +  "(" + param +") ";
		 } else {
		     cmd = cmd + " " + param + " ";
		 }
		      
                 
		 if ( ! bool2.booleanValue() ) cmd = cmd + " not null";	
       
		 cmd = cmd + " " + (String)ctm.getValueAt(i,ctm.ADD_FIELD);

		sqlCmd.append(cmd +  ";\n");
	    }
	}

	for (int j = orig.size();j < ctm.getRowCount(); j++) {
	    String  param = (String)ctm.getValueAt(j,3);
            int colSize=0;
	    try {
		colSize = Integer.parseInt(param);
	    } catch (NumberFormatException nfe) { colSize=0; }

            boolean bool1 = true;
	    Boolean bool2 = new Boolean(bool1);
	    bool2 = (Boolean)ctm.getValueAt(j,2);
    
	    String colName = (String)ctm.getValueAt(j,0);
	    String typName = (String)ctm.getValueAt(j,1);

	    if ( colName.length() > 0 ) {
		cmd = "alter table " + tbc.getSelectedItem() + 
	          " add " +
		    colName + " " + typName ;
	            if ( param.length() > 0 ) {
			if (Character.isDigit(param.trim().charAt(0)) ) {
			    cmd = cmd + "(" + param + ")";
			} else {
			    cmd = cmd + " " + param + " ";
			}
		    }		
                 
		    if ( ! bool2.booleanValue() ) cmd = cmd + " not null ";
		    cmd = cmd + " " + (String)ctm.getValueAt(j,ctm.ADD_FIELD);
		    sqlCmd.append(cmd + ";\n");
	    }
	}
	if ( ! showCmd.isSelected()) executeCmd();


    }


  private void executeCmd() {
    StringTokenizer st = new StringTokenizer(sqlCmd.getText(),";");
    while (st.hasMoreTokens()) {
       execSQL(st.nextToken());
    }   
  }



  private void execSQL(String sqlQuery) {
      sqlQuery.replaceAll(System.getProperty("line.separator")," ");
      if ( sqlQuery.length() > 4) {
	  getCon();
	  try
	      {
		  int records = con.stmt.executeUpdate(sqlQuery);
		  message(Integer.toString(records)+" rows affected");
		  logger.log(Level.INFO,"User " + getUser() + ": " +
			     Integer.toString(records)+" rows affected " +
			     "with SQL-cmd: " + sqlQuery);

	      } catch (Exception excpt) {
		  logger.log(Level.WARNING,"User " + getUser() + ": " +
			     "throws exception " + excpt.getMessage().toString() +
			     " with: " + sqlQuery);
		  message(excpt.getMessage().toString());
	      } 
      }
  }

  private void message(String m) {

    msg.append("\n");
    msg.append(m);


  }


    private void addRow() {

       Vector v = new Vector();
       v.addElement((String)"");
       v.addElement((String)"varchar");
       v.addElement((Boolean)new Boolean(true));
       v.addElement((String)"20");
       v.addElement((String)" ");
       ctm.addRow(v);
       doCellEditors();

    }


    private void setListContent(String tableName) {
	ctm.clearData();
	orig.clear();
	origParam.clear();
	tCols = new TableColumns(getCon(),tableName );
        IsAutoIncrement isa = new IsAutoIncrement(getCon(),tableName );
	for (int i = 0; i <= tCols.getNumberOfColumns();i++) {
	    Vector v = new Vector();
	    SingleColumnInfo sci = new SingleColumnInfo();
	    sci = tCols.getColumn(i);
	    orig.addElement((SingleColumnInfo) sci); // this saves the original Layout
	    v.addElement((String)sci.getColumn_name());
	    v.addElement((String)sci.getType_name().toLowerCase());
	    Boolean bool = new Boolean(sci.isNullable());
	    v.addElement((Boolean)bool);
	    v.addElement((String)Integer.toString(sci.getColumn_size()));

	    // additonal Parameters
	    String ap="";
	    isa.setColumn(sci.getColumn_name());

            if  ( ( sci.isPrimaryKey()   )   && ( isa.autoIncrement() ) )  
		ap = " AUTO_INCREMENT PRIMARY KEY ";
	    if  ( ( sci.isPrimaryKey()   )   && ( ! isa.autoIncrement() ) )
		ap = " PRIMARY KEY ";
            if  ( ( ! sci.isPrimaryKey() ) && ( isa.autoIncrement() ) )   
		ap = " AUTO_INCREMENT ";

	    origParam.add((String) ap);
	    v.addElement((String)ap);

	    ctm.addRow(v);	  
	}
	doCellEditors();
    }

    private void doCellEditors() {

	JComboBox typ = new JComboBox();
        String[] items = {
	     "char",
	     "VARCHAR",
	     "BLOB",
	     "INT",
	     "FLOAT",
	     "DOUBLE",
	     "ENUM",
	     "SET",
	     "DATE",
	     "DATETIME",
	     "TIMESTAMP"
	};

        JComboBox paras = new JComboBox(new String[]  {"","PRIMARY KEY","AUTO_INCREMENT","AUTO_INCREMENT PRIMARY KEY" } );
	paras.setEditable(true);

	//for (int i = 0; i < items.length;i++) typ.addItem(items[i].toLowerCase());
	for (int i = 0; i < items.length;i++) typ.addItem(items[i]);

	TableColumn      typColumn   = rows.getColumnModel().getColumn(ctm.TYP_FIELD);
	typColumn.setCellEditor(new DefaultCellEditor(typ));

	TableColumn      paraColumn   = rows.getColumnModel().getColumn(ctm.ADD_FIELD);
	paraColumn.setCellEditor(new DefaultCellEditor(paras));
    }


    private JTabbedPane listPanel() {

        tp = new JTabbedPane();

	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	
	ctm = new ChangeTableModel();
	rows = new JTable(ctm);

	rows.getTableHeader().setReorderingAllowed(false);
	rows.setPreferredScrollableViewportSize(new Dimension(400,150));

	JScrollPane scrollpane = new JScrollPane(rows);
	GridBagConstraints gbc;
	Insets insets = new Insets(1,1,1,1);
	gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;
	gbc.insets = insets;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1.0;
	gbc.weighty = 1.0;
	panel.add(scrollpane,gbc);
	setListContent((String)tbc.getSelectedItem());

	tp.add("Table",panel);


        JPanel p2 = new JPanel();
	p2.setLayout(new BorderLayout());
	sqlCmd = new JTextArea();
	p2.add(BorderLayout.CENTER,new JScrollPane(sqlCmd));

	JPanel p3 = new JPanel();
	p3.setLayout(new FlowLayout());
	
	
	final Toolkit tk = this.getToolkit();
	ImageButton copy = new ImageButton(null,"copy.gif","Copies selection to the clipboard");
	copy.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		sqlCmd.selectAll();
		String s = sqlCmd.getSelectedText();
		StringSelection ss = new StringSelection(s);
		tk.getSystemClipboard().setContents(ss,ss);
		}});

	p3.add(copy);
	
	ImageButton selectAll = new ImageButton(null,"select.gif","select all Text");
	selectAll.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		sqlCmd.selectAll();
		}});
	p3.add(selectAll);


	ImageButton clear = new ImageButton(null,"clear.gif","Clears content");
	clear.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        sqlCmd.setText("");
		}});
	
	p3.add(clear);


	ImageButton exc = new ImageButton(null,"database.gif","Commit changes");
	exc.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        executeCmd();;
		}});
	p3.add(exc);
	p2.add(BorderLayout.SOUTH,p3);

	tp.add("SQL",p2);

	msg = new JTextArea();
	msg.setEditable(false);
        msg.setLineWrap(true);
	tp.add("Message",new JScrollPane(msg));


	return tp;
    }


    public static void main(String args[]){

	String host     = "localhost";
	String user     = System.getProperty("user.name");
        String schema   = "%";
        String database = null;
        String password = null;

	System.out.println("ChangeTable\n" +
			   "------------\n" +
			   "Syntax: java gpl.fredy.sqltools.ChangeTable\n" +
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
		

	   
	ChangeTable ct = new ChangeTable(con,schema);
	JFrame frame = new JFrame("Fredy's Change Table");
	frame.getContentPane().add(ct);
	frame.pack();
	frame.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {System.exit(0);}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	ct.exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    System.exit(0);
		}});
	    
	frame.setVisible(true); 
    }

}



	

	
