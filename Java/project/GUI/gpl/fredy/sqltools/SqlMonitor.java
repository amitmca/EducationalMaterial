package gpl.fredy.sqltools;

/** 
    SQL-Monitor is a part of Admin ...

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
 *   This Tool has been developed by David Good as contribution to Fredy's Admintool
 *
 **/


import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.beans.*;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;
import gpl.fredy.io.*;
 
public class SqlMonitor extends JPanel {

    private JTextArea query, response;
    public JTabbedPane tabbedPane;
    public JPanel upperPanel;
    public JScrollPane scp;
    
    public Toolkit tk;
    public ImageButton exit;
    public JTable tableView;
    public JScrollPane scrollpane;
    

    boolean retainTabs = false;
	boolean retainStatus = false;
	String sqlSeparators = ";\r";
	final static int TABLE = 0;
	final static int SINGLE_TEXT = 1;
	final static int MULTIPLE_TEXT = 2;
	int resultType = TABLE;
	Container parentFrame; 
	static boolean standAlone = false;
	
	private int tabIndex = 0;



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
    

    private JToolBar toolbar() 
    {

	    JToolBar tb = new JToolBar();
	    tb.setOrientation(JToolBar.HORIZONTAL);

	    ImageButton exec = new ImageButton(null,"binocular.gif",null);
	    exec.setToolTipText("Execute query");
	    exec.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    execQuery();
		    }});	
	    tb.add(exec);


	    ImageButton clear = new ImageButton(null,"sheet.gif",null);
	    clear.setToolTipText("Clear");
	    clear.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    query.setText("");
		    }});
	    tb.add(clear);
    	
	    ImageButton copy = new ImageButton(null,"copy.gif",null);
	    copy.setToolTipText("Copy all to clipboard");
	    copy.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    String s = query.getText();
		    StringSelection ss = new StringSelection(s);
		    tk.getSystemClipboard().setContents(ss,ss);
		    }});
	    tb.add(copy);

	    ImageButton paste = new ImageButton(null,"paste.gif",null);
	    paste.setToolTipText("Paste");
	    paste.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    Clipboard c =tk.getSystemClipboard();
		    Transferable t = c.getContents(this);
		    try { 
		        String s = (String) t.getTransferData(DataFlavor.stringFlavor);
		        query.setText(s); 
		    }
		    catch (Exception eexc) { 
		        tk.beep();
		    }
		    }});
	    tb.add(paste);


	    final ImageButton export = new ImageButton(null,"export.gif",null);
	    export.setToolTipText("Export result");
	    export.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
		    {
		    int index = tabbedPane.getSelectedIndex();
		    if ( tabbedPane.getTitleAt(index).startsWith("Result")) 
		    {
		        DataExportGui eq = new DataExportGui(getCon().con,
                                                       ((SqlPanel)(tabbedPane.getComponentAt(index))).getQuery(),
                                                       true,false); 
                        eq.setLocationRelativeTo(export);
		    }
		    }
	    });
	    tb.add(export);


	    ImageButton xls = new ImageButton(null,"xls.gif","Export query into xls-file (needs POI)");
	    xls.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			int index = tabbedPane.getSelectedIndex();
			if ( tabbedPane.getTitleAt(index).startsWith("Result")) {
			    JFileChooser chooser = new JFileChooser();
			    chooser.setDialogType(JFileChooser.SAVE_DIALOG);
			    chooser.setDialogTitle("Select XLS-File");
			    chooser.setFileFilter(new MyFileFilter(new String[]{ "xls", "XLS"}));
			    
			    int returnVal = chooser.showSaveDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
				XLSExport xe = new XLSExport(getCon().con);
				xe.setQuery(((SqlPanel)(tabbedPane.getComponentAt(index))).getQuery());
				xe.createXLS( chooser.getCurrentDirectory() + 
					      java.io.File.separator + 
					      chooser.getSelectedFile().getName());
			    } 			
			}
		    }
		});
	    tb.add(xls);


	    ImageButton saveQuery = new ImageButton(null,"save.gif","Save Query to file");
	    saveQuery.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			gpl.fredy.io.FileWriter fw = new gpl.fredy.io.FileWriter();
			fw.setFilter(new String[] {"sql","SQL","txt","TXT"});
			fw.setContent(query.getText());
			fw.setFileName("?");
			fw.setSwitch("a");
			fw.write();
		    }
		});
	    tb.add(saveQuery);

	    ImageButton loadQuery = new ImageButton(null,"load.gif","Load query from file");
	    loadQuery.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			ReadFile rf = new ReadFile();
			rf.setFilter(new String[]{"sql","SQL","txt","TXT"});
			rf.setFileName("?");
			if (query.getText().length() > 0 ) query.append(";\n");
			query.append(rf.getText());
			query.updateUI();			
		    }
		});
	    tb.add(loadQuery);
	    


	    ImageButton preferences = new ImageButton(null,"user.gif",null);
	    preferences.setToolTipText("Preferences");
	    preferences.addActionListener(new ActionListener() 
	    {
		    public void actionPerformed(ActionEvent e) 
		    {

			    SqlPrefForm sp = new SqlPrefForm();
    			
		    }
	    });
	    tb.add(preferences);
    	
	    ImageButton pickList = new ImageButton(null,"data.gif",null);
	    pickList.setToolTipText("Pick List");
	    pickList.addActionListener(new ActionListener()
	    {
		    public void actionPerformed(ActionEvent e)
		    {
    			
    			parentFrame =  getParentFrame();
				final Container tla = SqlMonitor.this.getTopLevelAncestor();
				Container PickListFrame;
				
			    ActionListener a  = new ActionListener()
			    {
				    public void actionPerformed(ActionEvent ae)
				    {
					    if (!standAlone)
						{
							try{
							((JInternalFrame)parentFrame).setSelected(true);
							}catch(PropertyVetoException ex){ex.printStackTrace();}
						}
						parentFrame.requestFocus();
						query.requestFocus();
						query.append(ae.getActionCommand());
						
				    }
    				
			    };
    			
			    SqlPickList s = new SqlPickList(getCon(),a,getSchema());
    			
			    //Open Pick List as Dialog if standalone, another internal frame if within admin
			    if (standAlone)
			    {
				    PickListFrame = new JDialog((Frame)(parentFrame),"Pick List");
				    ((RootPaneContainer)PickListFrame).getContentPane().add(s);
				    ((JDialog)PickListFrame).pack();

			    }
			    else 
			    {

				    PickListFrame = new JInternalFrame("Pick List",true,true);

				    ((RootPaneContainer)PickListFrame).getContentPane().add(s);
				    ((JInternalFrame)PickListFrame).pack();
				    ((gpl.fredy.admin.Admin)tla).lc.add(PickListFrame,-1);

			    }
				Point p = parentFrame.getLocationOnScreen();
			    p.translate(parentFrame.getWidth(),0);

			    PickListFrame.setLocation(p);

			    PickListFrame.setVisible(true);
		    }			
	    });
    	
    	
	    tb.add(pickList);
    	
    	
	    exit = new ImageButton(null,"exit.gif",null);
	    exit.setToolTipText("Quit");
	    tb.add(exit);

	    return tb;
    }





    private JPanel queryPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());

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

	query = new JTextArea(20,80);
	query.setFont(new Font("Monospaced", Font.PLAIN, 12));
	panel.add(new JScrollPane(query),gbc);

	return panel;

    }

    private JPanel displayPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());

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

	query = new JTextArea(20,80);
	query.setFont(new Font("Monospaced", Font.PLAIN, 12));
	panel.add(new JScrollPane(response),gbc);

	return panel;

    }

	Container getParentFrame()
	{
		Container c = new Container();
		
		if (standAlone)
			c = getTopLevelAncestor();
		else
		{
			try
			{
				c = SwingUtilities.getAncestorOfClass(Class.forName("javax.swing.JInternalFrame"),(java.awt.Component)this); //get Internal frame when opened in Admin
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		return c;
	}

    public SqlMonitor(String host, String user, String password, String database, String schema) {

	setHost(host);
	setUser(user);
	setPassword(password);
	setDatabase(database);
	setSchema(schema);
        init();
    }

   public SqlMonitor(t_connect con) {
       setCon(con);
       setSchema("%");
       init();

   }

  public SqlMonitor(t_connect con,String schema) {
      setCon(con);
      setSchema(schema);
      init();
  }
    private void init() {
   
	tk = this.getToolkit();
		
	this.setLayout(new GridBagLayout());

	tabbedPane = new JTabbedPane();
	response = new JTextArea(20,80);
	response.setEditable(false);
	response.setFont(new Font("Monospaced", Font.PLAIN, 12));

	/**
	upperPanel = new JPanel();
	upperPanel.add(queryPanel());
	**/

	GridBagConstraints gbc;
	Insets insets = new Insets(1,1,1,1);
	gbc = new GridBagConstraints();
	gbc.insets = insets;
       	gbc.anchor= GridBagConstraints.CENTER;
	gbc.fill  = GridBagConstraints.HORIZONTAL;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1.0; 
	gbc.weighty =0.0;
	this.add(toolbar(),gbc);


       	gbc.anchor= GridBagConstraints.CENTER;
	gbc.fill  = GridBagConstraints.BOTH;
	gbc.weightx = 1.0; 
	gbc.weighty = 1.0;
	gbc.gridx = 0;
	gbc.gridy = 1;

	tabbedPane.add("SQL",queryPanel());
	
	this.add(tabbedPane,gbc);


	//this.setRequestFocusEnabled(true);
	//this.requestFocus();
	//query.requestFocus();
	
	this.addComponentListener(new ComponentAdapter() {
	   public void componentHidden(ComponentEvent e) {}
	   public void componentMoved(ComponentEvent e) {}
	   public void componentResized(ComponentEvent e) { 
	       //fitSize();
	       //tabbedPane.updateUI();
	       
	   }
	      
	});
	   

    }

    public void update() {  this.updateUI();}


    public void execQuery() 
	{

	    /** if it is a query send it to the table, otherwise execute
	     *  the command and display the result of the command in the
	     *  status tab
	     */
		 
		String queryText= "";
		String fullQueryText ;
		
		JPanel lastPanel = new JPanel();
		JPanel statusPanel = new JPanel();
		
		statusPanel.setLayout(new GridBagLayout());

		boolean bError = false;
						
		
		//get query	
		if (query.getSelectionStart() == query.getSelectionEnd())
			fullQueryText = query.getText();
		else
			fullQueryText = query.getSelectedText();

		if (fullQueryText == "" | fullQueryText == null) {
		    return;
		}
		       

		//initialise based on Preferences
		int count = tabbedPane.getTabCount();
		
		if (!retainTabs)
		{
			tabIndex = 0;
			for(int i=(count-1);i>0;i--)
				tabbedPane.remove(i);
		}
		else
		{
			int stat = tabbedPane.indexOfTab("Status");
			if (stat > -1)
				tabbedPane.remove(stat);
		}
		
		
		if (!retainStatus)
			response.setText("");	    
		
		//parse query strings & iterate throught them
		StringTokenizer fqt = new StringTokenizer(fullQueryText,sqlSeparators);

		while (fqt.hasMoreTokens())
		{

			queryText = fqt.nextToken().trim();				
			response.append(queryText +"\n");


			SqlTab tabPanel = new SqlTextArea();
			
			if ( queryText.toLowerCase().startsWith("select") | queryText.toLowerCase().startsWith("show") | queryText.toLowerCase().startsWith("desc")) 
			{
			    
				if (resultType != TABLE)
				    tabPanel = new SqlTextArea(getCon(),queryText);
				else 				   
			 	    tabPanel = new SqlPanel(getCon(),queryText);
								
				if (tabPanel.getSQLError() != null)
				{
					response.append(tabPanel.getSQLError() + "\n\n");
					tk.beep();
					bError = true;
				}
				else
				{	
					tabIndex++;
					tabbedPane.addTab("Results " + tabIndex, null,(JPanel)tabPanel,queryText); 
					fitSize(tabbedPane.getSize(),tabPanel);
					response.append(tabPanel.getNumRows()+" rows returned in Results " + tabIndex+"\n\n");
					lastPanel = (JPanel)tabPanel;
				}
			} 
			else 
			{
				getCon();
			 	if (con.getError() != null) 
				{
					tk.beep();
				} 
				else 
				{
					try
					{
						int records = con.stmt.executeUpdate(queryText);
						response.append(Integer.toString(records)+" rows affected\n\n");
						lastPanel = statusPanel;
					} 
					catch (Exception excpt) 
					{
						response.append(excpt.toString());
			   			tk.beep();
						bError = true;
				   	} 
			 	}
				con.close();
			}
		}
		

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
		statusPanel.add(response,gbc);

		tabbedPane.add("Status",statusPanel);
		
		
		tabbedPane.repaint();
			
		if (bError)
			lastPanel = statusPanel;
		try {
		    tabbedPane.setSelectedComponent(lastPanel);
		} catch ( Exception anException ) { 
		    response.append(anException.toString());
		    tk.beep();
		    bError = true;    ; 
		}
	
    }


    public void fitSize(Dimension d, SqlTab st) {

		 Integer intx = new Integer(d.width);
		 Integer inty = new Integer(d.height);
		 double fx = intx.floatValue() * 0.95;
		 double fy = inty.floatValue() * 0.80;
		 Double dfx = new Double(fx);
		 Double dfy = new Double(fy);
		 d.setSize(dfx.intValue(),dfy.intValue());
		 
		 st.setViewPortSize(d);

    }
    


    public static void main(String args[]) {

	System.out.println("Fredy's SQL-Monitor\n" +
			   "-------------------- Version 2\n" +
                           "is a part of Admin and under GPL\n"+
			   "Developed and contributed by David Good");
						   
	standAlone = true;
	if ( args.length != 5) {
	    System.out.println("Syntax: java SqlMonitor host user password database schema\nWhere schema is avalid schema-pattern (incl. wildcards)");
	    System.exit(0);
	}
	JFrame f = new JFrame("SQL-Monitor");
	f.getContentPane().setLayout(new GridBagLayout());
	final SqlMonitor g = new SqlMonitor(args[0], args[1], args[2], args[3],args[4]);

        GridBagConstraints gbc;
	Insets insets = new Insets(1,1,1,1);
	gbc = new GridBagConstraints();
    	gbc.insets = insets;

       	gbc.anchor= GridBagConstraints.NORTHWEST;
	gbc.fill  = GridBagConstraints.BOTH;
	gbc.weightx = 1.0; 
	gbc.weighty = 1.0;
	gbc.gridx = 0;
	gbc.gridy = 0;

	f.getContentPane().add(g,gbc);
	f.pack();
	f.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
            public void windowDeactivated(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowOpened(WindowEvent e) {}});
	g.exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	f.addComponentListener(new ComponentAdapter() {
	   public void componentHidden(ComponentEvent e) {}
	   public void componentMoved(ComponentEvent e) {}
	   public void componentResized(ComponentEvent e) { 
	      
	      g.tabbedPane.updateUI();
	      
	   }
	});

	f.setVisible(true);
    }
	
	public class SqlPrefForm extends JDialog
	{
	  Container jPanel1 = getContentPane();
	  GridBagLayout gridBagLayout1 = new GridBagLayout();
	  JCheckBox cbRetainTabs = new JCheckBox();
	  JCheckBox cbRetainStatus = new JCheckBox();
	  JTextField txtSeparator = new JTextField(1);
	  JLabel jLabel1 = new JLabel();
	  JButton cbOK = new JButton();
	  JButton cbCancel = new JButton();
	  JRadioButton rbText = new JRadioButton("Text");
	  JRadioButton rbTable = new JRadioButton("Table");
	  JPanel buttonPanel = new JPanel();
	  	  
	  public SqlPrefForm() 
	  {
		
	    try {
	      jbInit();
		  setTitle("SQL Monitor Preferences");
		  setLocationRelativeTo(SqlMonitor.this);
		  setModal(true);
		  pack();
		  show();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	  private void jbInit() throws Exception 
	  {
	    jPanel1.setLayout(gridBagLayout1);
	    
	    
		cbRetainTabs.setText("Retain Results");
		cbRetainTabs.setSelected(retainTabs);
				
	    cbRetainStatus.setText("Retain Status");
		cbRetainStatus.setSelected(retainStatus);
	    
		txtSeparator.setText(sqlSeparators.substring(0,1));
		jLabel1.setText("Statement Separator");
		
		if (SqlMonitor.this.resultType == SqlMonitor.this.TABLE)
			rbTable.setSelected(true);
		else
			rbText.setSelected(true);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(rbText);
		bg.add(rbTable);
			
		buttonPanel.add(rbText);
		buttonPanel.add(rbTable);
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder(),"Results Type"));
		
	    cbCancel.setText("Cancel");
		cbCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				SqlPrefForm.this.dispose();

			}
		});
		
		cbOK.setText("OK");
		cbOK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SqlMonitor.this.retainTabs = cbRetainTabs.isSelected();
				SqlMonitor.this.retainStatus = cbRetainStatus.isSelected();
				SqlMonitor.this.sqlSeparators = txtSeparator.getText().trim().substring(0,1)+ "\r";
				if (rbText.isSelected())
					SqlMonitor.this.resultType = SqlMonitor.this.MULTIPLE_TEXT;
				else
					SqlMonitor.this.resultType = SqlMonitor.this.TABLE;
				
				SqlPrefForm.this.dispose();
	
			}
		});
		
		jPanel1.add(txtSeparator, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 10, 0));
	    jPanel1.add(jLabel1, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    jPanel1.add(cbRetainStatus, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
	    jPanel1.add(cbRetainTabs, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20,0 , 0), 0, 0));
		jPanel1.add(buttonPanel, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 20,0 , 0), 0, 0));
	    jPanel1.add(cbCancel, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 10,10, 20), 0, 0));
	    jPanel1.add(cbOK, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 10, 10), 15, 0));
	  }
	}
		
		
	
	
	
			
		
}
      


