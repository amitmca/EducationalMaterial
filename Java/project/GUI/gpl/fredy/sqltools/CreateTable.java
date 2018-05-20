package gpl.fredy.sqltools;

/** 

    CreateTable is a part of Admin

    Admin is a Tool around mySQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin is a Tool around JDBC-enabled SQL-RDBMS to do basic jobs
    for DB-Administrations, like:
    - SQL-Monitor to sned statements to the RDBMS
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    - create Java Code
    - export Data

    and other usefull things in DB-arena

    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

   
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


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.util.HashMap;
import java.util.logging.*;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.*;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;

public class CreateTable extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.6  07. Feb. 2003";

public String getVersion() {return fredysVersion; }

    private Logger logger;
    public ImageButton create, clear;
    public JButton cancel;
    private JTextField tableName;
    private JTextField fieldName;
    private JTextArea fieldParams;
    private JTextArea sqlStatement;
    private JCheckBox fieldNull;
    private JTabbedPane jt;

    private MsgDialog msgDialog;

    private JTable table;
    private CrTable cr;
    private JComboBox fieldType,primaryKey, additionalParameters;
    private Vector fName, fType,fNull,fParam,fAddParam;




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
       * Get the value of tableName.
       * @return Value of tableName.
       */
    public String getTableName() {return tableName.getText();}
    
    /**
       * Set the value of tableName.
       * @param v  Value to assign to tableName.
       */
    public void setTableName(String  v) {this.tableName.setText(v);}
    

    private void enterTableName() {
       String v = JOptionPane.showInputDialog(this, "Please enter Tablename");	
       if (  v == null ) { 
	   JOptionPane.showMessageDialog(this, "You have to enter a name");
	   enterTableName();
       }
       setTableName(v);
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
    


    public CreateTable(String host, String user, String password,  String database) {

	setHost(host);
	setUser(user);
	setDatabase(database);
	setPassword(password);

	init();
    }


    public CreateTable(t_connect con) {
	setCon(con);
	init();
    }

    private void init() {

        fName = new Vector();
	fType = new Vector();
	fNull = new Vector();
        fParam= new Vector();
        fAddParam = new Vector();

	logger = Logger.getLogger("gpl.fredy.admin");
	msgDialog = new MsgDialog();

	this.setLayout(new BorderLayout());
	this.add("Center",mainPanel());

    }

    private JPanel mainPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());


       jt = new JTabbedPane();

       JPanel panel2 = new JPanel();
       panel2.setLayout(new BorderLayout());
       panel2.add("North",upperPanel());
       panel2.add("Center",create());
       panel2.add("South",buttonPanel());
       

       jt.add("Table",panel2);

       panel.add("Center",jt);
       return panel;

    }

    private void execSQL(String sqlQuery) {
	getCon();
	if (con.getError() != null) {
	    logger.log(Level.SEVERE,"User " + getUser() +
		       " can not establish connection. " + con.getError());
	    message(con.getError());
	} else {
	    try
		{
		    int records = con.stmt.executeUpdate(sqlQuery.replaceAll("\n\r\t"," "));
		    logger.log(Level.INFO,"User " +
			       getUser() + 
			       " successful SQL-Cmd: " + sqlQuery);
		} catch (Exception excpt) {
		    logger.log(Level.SEVERE,"User " + getUser() + " Excption with: " + 
			       sqlQuery + excpt.getMessage().toString());
		    message(excpt.getMessage().toString());
		} 
	}
    }


    private JPanel indices() {

	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());	
	
	panel.add("West",indPanel());
	

	return panel;

    }


    private JPanel indPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());	
	
	FfAlignerLayoutPanel ffp = new FfAlignerLayoutPanel();
	ffp.setNumberOfRows(1);
	ffp.addComponent(new JLabel("Select Field for Primary Key"));
	setPrimaryKey();
	ffp.addComponent(primaryKey);

	panel.add("West",ffp);
	return panel;
    }


    private void setPrimaryKey() {

	primaryKey = new JComboBox();
	for (int i = 0; i < table.getRowCount(); i++) {
	    String s0 = (String)cr.getValueAt(i,0);
	    if ( s0.length() > 0 ) primaryKey.addItem(s0);
	}
	primaryKey.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		sqlStatement.setText(getSqlCommand());
		sqlStatement.updateUI();
		}});
	
    }



    private JPanel sql () {

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	
	sqlStatement = new JTextArea(10,30);
	sqlStatement.setWrapStyleWord(true);
	sqlStatement.setLineWrap(true);
	sqlStatement.setEditable(true);	
        JScrollPane sqlPane = new JScrollPane();
        sqlPane.getViewport().add(sqlStatement);

	panel.add(sqlPane);


	return panel;


    }



    private JPanel upperPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	panel.add("North",enterTable());
	panel.add("Center",fieldPanel());
	return panel;

    }

    private JPanel buttonPanel() {

	create = new ImageButton(null,"newsheet.gif","this will create the table");
	create.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		execSQL(getSqlCommand());
		}});
	

	cancel = new JButton();
	ImageButton imb = new ImageButton();
	ImageIcon i1 = imb.getImageIcon("exit.gif");
	ImageIcon i2 = imb.grayed(i1.getImage());
	cancel.setIcon(i2);
	cancel.setRolloverIcon(i1);
	cancel.setRolloverEnabled(true);
	cancel.setToolTipText("Exit");


	clear = new ImageButton(null,"clear.gif","Clear");
	clear.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		clearScreen();
		}});
	

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());

	panel.add(create);
	panel.add(clear);
	panel.add(cancel);
	return panel;
    }

    private JPanel enterTable() {

	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	GridBagConstraints gbc;
	gbc = new GridBagConstraints ();
	gbc.insets =  new Insets(2,2,2,2);
	gbc.fill=GridBagConstraints.HORIZONTAL;

	gbc.gridx = 0;
        gbc.gridy = 0;
	gbc.anchor=GridBagConstraints.EAST;	
	panel.add(new JLabel("Tablename:"),gbc);


	gbc.gridx = 1;
	gbc.anchor=GridBagConstraints.WEST;	
	tableName = new JTextField(20);
	panel.add(tableName,gbc);


	panel.setBorder(BorderFactory.createEtchedBorder());
	return panel;
    }



    private JPanel fieldPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());

	JPanel panel2 =  new JPanel();;
	panel2.setLayout(new BorderLayout());
	ImageButton addF = new ImageButton(null,"column.gif","add Field");
	addF.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		addRow();
		}});
	panel2.add(BorderLayout.NORTH,addF);

	ImageButton sqlCmd = new ImageButton(null,"plusplus.gif","press this Button, to perform additional creation tasks");

	sqlCmd.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		try {
		    jt.removeTabAt(1);
		    jt.removeTabAt(1);
		} catch (Exception ex) { ; }

		jt.add("Indexes",indices());
		jt.add("SQL-Statement",sql());
		sqlStatement.setText(getSqlCommand());
		sqlStatement.updateUI();
		jt.updateUI();
	}});
	panel2.add(BorderLayout.SOUTH,sqlCmd);

      
        ImageLabel l = new ImageLabel(null,"database.gif","Database");
        panel2.add(BorderLayout.CENTER,l);

	panel.add(BorderLayout.CENTER,fieldDefs());
	panel.add(BorderLayout.EAST,panel2);
	

	clearFieldEntry();

	return panel;
    }


    private JPanel fieldDefs() {
	JPanel panel = new JPanel();
	panel.setLayout (new GridBagLayout ());
	GridBagConstraints gbc;
	panel.setBorder(BorderFactory.createEtchedBorder());

	gbc = new GridBagConstraints ();
	gbc.insets =  new Insets(2,2,2,2);
	gbc.fill=GridBagConstraints.HORIZONTAL;

	gbc.gridx = 0;
        gbc.gridy = 0;
	gbc.anchor=GridBagConstraints.EAST;	
	panel.add (new JLabel("Field Name"), gbc);


	fieldName = new JTextField (20);
	gbc.anchor=GridBagConstraints.WEST;
	gbc.gridx = 1;
	panel.add (fieldName, gbc);

	gbc.anchor=GridBagConstraints.EAST;
	gbc.gridx = 0;
	gbc.gridy = 1;
	panel.add (new JLabel("Field Type"), gbc);
	

	fieldType = new JComboBox ();
	if (fieldType.getItemCount() < 1 ) {
	    String[] items = { "CHAR","VARCHAR","BLOB",
			   "INT","FLOAT","DOUBLE",
			   "ENUM","SET",
			   "DATE","DATETIME","TIMESTAMP"};
	    fieldType = new JComboBox (items);
	}
	// to allow the use of RDBMS specific types
	DbInfo dbi = new DbInfo(getCon());
	Vector v = dbi.getSQLWords();
        HashMap fieldTypes = new HashMap();
        if (v.size() > 0 ) {
            fieldType.addItem("--- DB-Specific below this ---");
            for (int i=0;i < v.size();i++) {
                FieldTypeInfo fti = (FieldTypeInfo)v.elementAt(i);
                fieldTypes.put((String) fti.getTypName() , new Boolean((boolean) fti.isAutoIncrement() ));
                String s = (String) fti.getTypName();
                boolean add = true;
                for ( int j = 0;j < fieldType.getItemCount();j++ )
                    if ( s.equalsIgnoreCase( (String)fieldType.getItemAt(j)) ) add = false;
                //String s2 = (String)fieldType.getItemAt(i);
                //if ( add ) fieldType.addItem((String) s2 );
                if ( add ) fieldType.addItem((String) s);
                
            }
        }
	

	gbc.anchor=GridBagConstraints.WEST;
	gbc.gridx = 1;
	gbc.gridy = 1;
	panel.add (fieldType, gbc);

	gbc.anchor=GridBagConstraints.EAST;
	gbc.gridx = 0;
	gbc.gridy = 2;
	panel.add (new JLabel("length/parameters"), gbc);

	fieldParams = new JTextArea (2,20);
	fieldParams.setLineWrap(true);

	JScrollPane scrollpane = new JScrollPane(fieldParams,
        	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.anchor=GridBagConstraints.WEST;

	panel.add (scrollpane, gbc);

	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.anchor=GridBagConstraints.EAST;
	panel.add (new JLabel("no null"), gbc);

	fieldNull = new JCheckBox ();

	gbc.anchor=GridBagConstraints.WEST;
	gbc.gridx = 1;
	gbc.gridy = 3;
	panel.add (fieldNull, gbc);

	String[] addParams = {"none", "AUTO_INCREMENT","NULL","DEFAULT " };
	additionalParameters = new JComboBox(addParams);
	additionalParameters.setEditable(true);

	gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.anchor=GridBagConstraints.EAST;
	panel.add (new JLabel("Additional Parameters"), gbc);

	gbc.gridx = 1;
	gbc.gridy = 4;
	gbc.anchor=GridBagConstraints.WEST;
	panel.add(additionalParameters,gbc);


	return panel;

    }


    private JPanel create() {

	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());

	cr = new CrTable();
	table = new JTable(cr);

        JScrollPane scrollpane = new JScrollPane(table);
        //scrollpane.getViewport().add(table);
        table.setPreferredScrollableViewportSize(new Dimension(400, 70));

	
	table.getTableHeader().setReorderingAllowed(false);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	fitTableSize();

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

	panel.add(scrollpane,gbc);
	return panel;

    }
 
    private void clearScreen() {
	tableName.setText("");
	fieldName.setText("");
	fieldParams.setText("");
	fName.removeAllElements();
	fType.removeAllElements();
	fNull.removeAllElements();
	fParam.removeAllElements();
	fAddParam.removeAllElements();
	cr.clearData();

    }


    private void fitTableSize() {
	for (int i = 0; i< 4; i++ ) {
	        table.getColumnModel().getColumn(i).setHeaderValue(cr.getColumnName(i));
	    	table.getColumnModel().getColumn(i).sizeWidthToFit();
	}
	
	JComboBox ft = new JComboBox(fieldType.getModel());
        JComboBox ap = new JComboBox(new String[] { "none", "AUTO_INCREMENT","NULL","DEFAULT "});


	table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(ft));
	table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(ap));

    }



    private void addRow() {
      if (fieldName.getText().length() > 1) {
	Vector v = new Vector();

	String v1= fieldName.getText();
	v.addElement(v1);

	fName.addElement(fieldName.getText());

	v.addElement((String)fieldType.getSelectedItem());
	fType.addElement((String)fieldType.getSelectedItem());

	Boolean v3 = new Boolean(fieldNull.isSelected());
	v.addElement(v3);
	fNull.addElement(v3);


	String v4 = fieldParams.getText();
	v.addElement(v4);
	fParam.addElement(v4);

	v.addElement((String)additionalParameters.getSelectedItem());
        fAddParam.addElement((String)additionalParameters.getSelectedItem());

	cr.addRow(v);

	fitTableSize();

	clearFieldEntry();
      }	else { 
	  message("It makes sense to use a longer name..");
      }
    }


    private void addEmptyRow() {

	Vector v = new Vector();

	String v1= " ";
	v.addElement(v1);

	JComboBox ft = new JComboBox(fieldType.getModel());

	v.addElement(ft);

	Boolean v3 = new Boolean(false);
	v.addElement(v3);
	String v4 = " ";
	v.addElement(v4);
	cr.addRow(v);
	fitTableSize();


    }

    public void addEmptyRows(int i) {

	for (int j=0; j < i;j++) {
	    addEmptyRow();
	}


    }

    private void clearFieldEntry() {
	fieldName.setText(null);
	fieldParams.setText(null);
	fieldNull.setSelected(false);
	fieldType.setSelectedIndex(0);
	additionalParameters.setSelectedIndex(0);

    }
   private void message(String msg) {

       logger.log(Level.WARNING,"User " + getUser() + " Message: " + msg);

       //JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.WARNING_MESSAGE);
       msgDialog.setText(msg);
       msgDialog.pack();
       msgDialog.setModal(true);
       msgDialog.setVisible(true);
       msgDialog.setLocationRelativeTo(this);
       msgDialog.close.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
		   msgDialog.setVisible(false);
	       }
	   });
       
    }


    public String getSqlCommand() {

	String cmd;
	String crlf = System.getProperty("line.separator");

	if ( tableName.getText().length() > 0) {
	cmd = crlf + "CREATE TABLE " + tableName.getText() + " (" + crlf + "\t\t";
	for (int i = 0; i < table.getRowCount(); i++) {

	    String s0 = (String)cr.getValueAt(i,0);
	    if ( s0.length() > 0 ) {
		if ( i >0) cmd = cmd + "," + crlf + "\t\t";
		cmd = cmd + " " + (String)table.getValueAt(i,0) + " " +
		      (String)cr.getValueAt(i,1);
	    
	        String    s = (String)table.getValueAt(i,3);

	        if ( s.length() > 0 ) {
		    if (Character.isDigit(s.trim().charAt(0)) ) {
			cmd = cmd + "(" + s + ")";
		    } else {
			cmd = cmd + " " + s + " ";
		    }
		}
	    
	        Boolean b = (Boolean)table.getValueAt(i,2);
 	        if ( b.booleanValue() ) cmd = cmd + " NOT NULL";
		
		if ( ! ((String)cr.getValueAt(i,4)).startsWith("none") )
		    cmd = cmd + " " +  (String)cr.getValueAt(i,4);

	    }
	}

	// let's now add the primary Key....
	try {
	    if ( primaryKey.getItemCount() > 0 ) {
		cmd = cmd + ", PRIMARY KEY  (" + primaryKey.getSelectedItem().toString() + ")";
	    }
	} catch (Exception a_exception) {
	    /**
	       we ignore this, because it seems only to appear if
	       no primary key is selected.
	    **/
	}


	// at this place we create index


	cmd = cmd + crlf + ")";


	} else { 
          message("a table needs a name!");
	  cmd = null;
	}
	return cmd;

    }

    public static void main(String args[]) {


	if (args.length != 4) {

	    System.out.println("Syntax:\njava gpl.fredy.sqltools.CreateTable host user password database ");
	    System.exit(0);
	}


	JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
	CreateTable panel = new CreateTable(args[0], args[1], args[2],args[3]);
	//panel.addEmptyRows(15);
        frame.getContentPane().add("Center", panel);
	frame.pack();
        frame.setVisible(true);
	panel.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	



    }

}

	
	
