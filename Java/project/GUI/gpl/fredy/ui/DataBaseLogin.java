package gpl.fredy.ui;

/** 
    DataBaseLogin is a part of Admin and done for loggin in to it...

 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C)     2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or any later version.
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
import java.io.*;
import java.util.Vector;
import java.util.Properties;
import java.util.logging.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import gpl.fredy.share.*;
import gpl.fredy.metadata.DBList;


public class DataBaseLogin extends JPanel {

 // Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002 ";

public String getVersion() {return fredysVersion; }   


    TConnectProperties prop;

    private Logger logger;

    LoadImage loadImage = new LoadImage();
    
    int connections=0;
    int activeConnection=-1;
    int activatedConnections= -1;
    
    /**
     * Get the value of connections.
     * @return value of connections.
     */
    public int getConnections() {
        connections = Integer.parseInt(noConns.getText());
	return connections;
    }
    
    /**
     * Set the value of connections.
     * @param v  Value to assign to connections.
     */
    public void setConnections(int  v) {
	this.connections = v;
	noConns.setText(Integer.toString(v));
    }
    
    Vector preservedConnections;
    Vector conVect;
   
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
               
        activeConnection = activeConnection + 1;
        if ( activeConnection > getConnections()-1 ) activeConnection = 0;
        if (  activeConnection >= activatedConnections ) {
	    activatedConnections++;

            System.out.println("Create new connection:\n" +
                               "- Number: " + activeConnection + "\n" +
                               "- User  : " + getUser() + "\n" +
                               "- Host  : " + getHost() + "\n" +
                               "- DB    : " + getDatabase());

	    // update t_connect.props
	    prop.setDriver(getDriver());
	    prop.setUrl(getUrl());
	    prop.setDatabasePort(getPort());
	    prop.setUsePwd(lUsePassword.isSelected());
	    prop.save();
	    
	    t_connect con =  new t_connect(getHost(),
					   getUser(),
					   getPassword(),
					   getDatabase());

	    conVect.addElement((t_connect)con);
	    if ( ! con.acceptsConnection() ) {
		//con[activeConnection] = null;
                System.out.println("- Status: does not accept connections\n\n");
	    } else { 
		System.out.println("- Status:  accepts connections\n\n");
	    }
	    if ( con.getError() != null ) {
		System.out.println("Connection " + 
				   activatedConnections + " failed!\n" +
				   con.getError() + "\nusing previous if possible " +
				   "and set number of connections to " + activeConnection);
		activeConnection = activeConnection -1;
                if ( activeConnection < 0 ) activeConnection = 0;
		setConnections(activeConnection);
	    }
		
		

	} else {
	    System.out.println("Reusing connection : " + activeConnection);
	}
        
        statusLine.setText("Active Connection: " + Integer.toString(activeConnection));
        statusLine.updateUI();
	return (t_connect)conVect.elementAt(activeConnection);
    }
    
 
   String host;
    
    /**
       * Get the value of host.
       * @return Value of host.
       */
    public String getHost() {
	host = lHost.getText();
	return host;
    }
    
    /**
       * Set the value of host.
       * @param v  Value to assign to host.
       */
    public void setHost(String  v) {
	this.host = v;
	lHost.setText(v);
    }
    

    String user;
    
    /**
       * Get the value of user.
       * @return Value of user.
       */
    public String getUser() {
	user = lUser.getText();
	return user;
    }
    
    /**
       * Set the value of user.
       * @param v  Value to assign to user.
       */
    public void setUser(String  v) {
	this.user = v;
	lUser.setText(v);
    }
    


    String password;
    
    /**
       * Get the value of password.
       * @return Value of password.
       */
    public String getPassword() {
	//password = lPassword.getPassword().toString();
	password=String.valueOf(lPassword.getPassword());	
	    //password = lPassword.getText();
	return password;
    }
    
    /**
       * Set the value of password.
       * @param v  Value to assign to password.
       */
    public void setPassword(String  v) {
	this.password = v;
	lPassword.setText(v);
    }
    

    String driver;
    
    /**
       * Get the value of JDBCdriver.
       * @return Value of JDBCdriver.
       */
    public String getDriver() {
	driver = lJDBCDriver.getText();
	return driver;
    }
    
    /**
       * Set the value of JDBCdriver.
       * @param v  Value to assign to JDBCdriver.
       */
    public void setDriver(String  v) {
	this.driver = v;
	lJDBCDriver.setText(v);
    }
    

    String url;
    
    /**
       * Get the value of JDBCurl.
       * @return Value of JDBCurl.
       */
    public String getUrl() {
	url = lUrl.getText();
	return url;
    }
    
    /**
       * Set the value of JDBCurl.
       * @param v  Value to assign to JDBCurl.
       */
    public void setUrl(String  v) {
	this.url = v;
	lUrl.setText(v);
    }
    
    
    String port;
    
    /**
       * Get the value of DatabasePort.
       * @return Value of DatabasePort.
       */
    public String getPort() {
	port = lPort.getText();
	return port;
    }
    
    /**
       * Set the value of DatabasePort.
       * @param v  Value to assign to DatabasePort.
       */
    public void setPort(String  v) {
	this.port = v;
	lPort.setText(v);
    }
    
    
    String database;
    
    /**
       * Get the value of database.
       * @return Value of database.
       */
    public String getDatabase() {
	database = lDatabase.getText();
	return database;
    }
    
    /**
       * Set the value of database.
       * @param v  Value to assign to database.
       */
    public void setDatabase(String  v) {
	this.database = v;
	lDatabase.setText(v);
    }

    
    String schema;
    
    /**
       * Get the value of schema.
       * @return Value of schema.
       */
    public String getSchema() {
	this.schema = lSchema.getText();
	return schema;
    }
    
    /**
       * Set the value of schema.
       * @param v  Value to assign to schema.
       */
    public void setSchema(String  v) {
	this.schema = v;
	lSchema.setText(v);
    }
    


    String usePassword;
    
    /**
       * Get the value of usePassword.
       * @return Value of usePassword.
       */
    public String getUsePassword() {
	usePassword = "no";
	if ( lUsePassword.isSelected() ) usePassword = "yes";
	return usePassword;
    }
    
    /**
       * Set the value of usePassword.
       * @param v  Value to assign to usePassword.
       */
    public void setUsePassword(String  v) {
	this.usePassword = v.toLowerCase();
	if ( v.equalsIgnoreCase("yes") ) {
	    lUsePassword.setSelected(true); 
	} else {  lUsePassword.setSelected(false); }    
    }



    public JButton cancel, connect;

    private JTextField lHost, 
	               lUser,
                       lJDBCDriver, 
                       lUrl,
                       lPort,
                       lDatabase,
                       lSchema,
                       noConns;

    private JLabel statusLine;
    public JPasswordField lPassword;
    //public JTextField lPassword;
    public JCheckBox lUsePassword;

    /** 
     * propFile is the File containing all the Properties
     **/
    public DataBaseLogin(String db) {

	logger = Logger.getLogger("gpl.fredy.admin");

	prop = new TConnectProperties();

        conVect = new Vector();
	preservedConnections = new Vector();

	this.setLayout(new BorderLayout());


	JPanel ffp = new JPanel();
        ffp.setLayout(new GridBagLayout());
	ffp.setBorder(BorderFactory.createEtchedBorder());

	GridBagConstraints gbc;
	Insets insets = new Insets(1,1,1,1);
	gbc = new GridBagConstraints();
	gbc.weightx = 1.0;     
	gbc.anchor= GridBagConstraints.WEST;
	gbc.fill  = GridBagConstraints.NONE;
	gbc.insets = insets;



	lHost = new JTextField(20);
	lUser = new JTextField(20);
	lDatabase = new JTextField(15);
	lJDBCDriver = new JTextField(20);
	lUrl = new JTextField(20);
	lPort = new JTextField(5);
	lUsePassword = new JCheckBox("use Password");
	lPassword = new JPasswordField(20);
	lSchema   = new JTextField(20);
        noConns   = new JTextField(5);
       
	noConns.setToolTipText("max number of connections for this Session");
	noConns.setDocument (new JTextFieldFilter(JTextFieldFilter.NUMERIC));
        


	//lPassword = new JTextField(20);

        gbc.gridx=0;
        gbc.gridy=0;
	ffp.add(new JLabel("Host"),gbc);
        gbc.gridy=1;
        ffp.add(new JLabel("User"),gbc);
        gbc.gridy=2;
        ffp.add(lUsePassword,gbc);
        gbc.gridy=3;
        ffp.add(new JLabel("Connections"),gbc);

	lHost.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    pushNClearConnections();
		}
	    });
	
	lDatabase.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    pushNClearConnections();
		}
	    });
	
	lJDBCDriver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    pushNClearConnections();
		}
	    });

	lUrl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    pushNClearConnections();
		}
	    });

	lPort.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    pushNClearConnections();
		}
	    });
	

        gbc.gridx=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        gbc.gridy=0;
	ffp.add(lHost,gbc);
	gbc.gridy=1;
	ffp.add(lUser,gbc);
        gbc.gridy=2;
	ffp.add(lPassword,gbc);
	gbc.gridy=3;
        gbc.fill=GridBagConstraints.NONE;
	noConns.setText("5");
        noConns.updateUI();
	ffp.add(noConns,gbc);
        
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=2;
        ffp.add(statusPanel(),gbc);


	FfAlignerLayoutPanel ffp2 = new FfAlignerLayoutPanel();
	ffp2.setBorder(BorderFactory.createEtchedBorder());
	ffp2.addComponent(new JLabel("JDBC-Driver"));
	ffp2.addComponent(lJDBCDriver);
	ffp2.addComponent(new JLabel("Database URL"));
	ffp2.addComponent(lUrl);
        ffp2.addComponent(new JLabel("Database Port"));
	ffp2.addComponent(lPort);
	ffp2.addComponent(new JLabel("Database"));
	ffp2.addComponent(lDatabase);
	ffp2.addComponent(new JLabel("Schema"));
	ffp2.addComponent(lSchema);

	final JComboBox ldb = new JComboBox();
	ldb.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setDatabase((String)ldb.getSelectedItem());
		}});
	
	final JComboBox loadSchema = new JComboBox();
	loadSchema.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setSchema((String)loadSchema.getSelectedItem());
		}});
	


	ImageButton selectDB = new ImageButton("Select","database.gif","Select Database and Schema");
	selectDB.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
              
		try {                   
		    DBList dblist = new DBList(getCon());
		    ldb.removeAllItems();
		    for (int i = 0; i < dblist.getDBs().size(); i++) {
			ldb.addItem((String) dblist.getDBs().get(i));
		    }
		    ldb.setSelectedIndex(0);
		    ldb.updateUI();

		    loadSchema.removeAllItems();
		    for (int j = 0; j < dblist.getSchemas().size(); j++) {
			loadSchema.addItem((String) dblist.getSchemas().get(j));
		    }
		    loadSchema.setSelectedIndex(0);
		    loadSchema.updateUI();

		} catch (Exception excpetion) {;}
	}});
	ffp2.addComponent(selectDB);
	ffp2.addComponent(ldb);
	ffp2.addComponent(new JLabel(""));
	ffp2.addComponent(loadSchema);
			  


	FfAlignerLayoutPanel ffp3 = new FfAlignerLayoutPanel();
	ffp3.setBorder(BorderFactory.createEtchedBorder());
	ffp3.setNumberOfRows(1);

	ffp3.addComponent(new JLabel("Select predefined"));
	final JLabel imgLabel = new JLabel(loadImage.getImage("sql.gif"));

	final SelectDriver sd = new SelectDriver(db);
	if (sd.getItemCount() > 0 ) {
	    sd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			closeConnections();
			JdbcStuff js = new JdbcStuff();
			js = sd.getData(sd.getSelectedIndex());
			logger.log(Level.INFO,"Changing JDBC-Driver to: " + 
					      js.getJDBCDriver());
			setDriver(js.getJDBCDriver());
			setUrl(js.getDbUrl());
			setPort(js.getPort());
			imgLabel.setIcon(js.getImage());
		    }});	
	}
	ffp3.addComponent(sd);
	JScrollPane imgScroller = new JScrollPane(imgLabel);
	ffp3.addComponent(imgScroller);


	this.add("North",ffp);
	this.add("Center",ffp2);
	this.add("West",ffp3);

        lPassword.requestFocus();
	
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.setBorder(BorderFactory.createEtchedBorder());

	connect = new JButton("Connect",loadImage.getImage("plug.gif"));
	connect.setToolTipText("This stores the Info needed to connect to the Database");
	buttonPanel.add(connect);

	cancel = new JButton("Cancel",loadImage.getImage("unplug.gif"));
	cancel.setToolTipText("Exit");
	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	    });
	
	buttonPanel.add(cancel);

	this.add("South",buttonPanel);
	
    }

    private void pushNClearConnections() {
	//saveConnectProperties();
	for (int i=0;i < conVect.size();i++ ) {
	    preservedConnections.addElement((t_connect)conVect.elementAt(i));
	}
	conVect.removeAllElements();
	activeConnection=-1;
	activatedConnections= -1;	    
    }

	

    private boolean changeMessage() {
        boolean a = false;
	if ( conVect.size() > 0 ) {
	    Object[] options = { "Continue", "Cancel" };
	    int n = JOptionPane.showOptionDialog(null,
						 "changeing of either\n" +
						 "host, port, database\n, URL or JDBC-Driver\n"    +
						 "needs me to close all existing connections.\n" +
						 "Do you want to continue?",
						 "Connection changes!",
						 JOptionPane.YES_NO_OPTION,
						 JOptionPane.WARNING_MESSAGE,
						 null,options,"Cancel");
	    if (n == JOptionPane.YES_OPTION)   {  
		closeConnections();
		a = true;
	    }	   
	}
	return a;
    }

    private ImageIcon loadImage(String image) {
	return  loadImage.getImage(image);
    }

    private JPanel statusPanel() {
	JPanel panel = new JPanel();
	statusLine = new JLabel();
	statusLine.setText("Active Connection: none ");
	statusLine.setFont(new Font("Monospaced", Font.PLAIN, 10));
	statusLine.setBackground(Color.yellow);
	statusLine.setForeground(Color.blue);
	panel.setBackground(Color.yellow);
	panel.setForeground(Color.blue);
	panel.setBorder(new BevelBorder(BevelBorder.LOWERED));

	panel.add(statusLine);
	return panel;

    }


    public static void main(String args[]) {
	JFrame f = new JFrame("TestWindow");
	f.getContentPane().add(new DataBaseLogin(args[0]));
	f.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	f.pack();
	f.setVisible(true);
    }

    protected void finalize() {
	closeConnections();
    }


    public void closeConnections() {
	t_connect aConnection;	   
        logger.log(Level.INFO,"Closing connections");
	try {
	    for (int i=0;i < conVect.size();i++ ) {
		aConnection = (t_connect)conVect.elementAt(i);
		aConnection.closeCon();
                logger.log(Level.INFO,"Closing connection no. " + Integer.toString(i));
	    }
	    conVect.removeAllElements();
	    activeConnection=-1;
	    activatedConnections= -1;	    
	} catch (Exception e1) {
	    logger.log(Level.INFO,"could not close all connections");
	}
	try {
	    // and now close the preserved connections
	    for (int i=0;i < preservedConnections.size();i++ ) {
		aConnection = (t_connect)preservedConnections.elementAt(i);
		aConnection.closeCon();
                logger.log(Level.INFO,"Closing preserved connection no. " + Integer.toString(i));
	    }
	    preservedConnections.removeAllElements();
	} catch (Exception e2) {
	    logger.log(Level.INFO,"could not close  preserved connections");
	}	    
    }


    public void saveConnectProperties() {
	Properties tProps = new Properties();
        tProps.put("JDBCdriver",lJDBCDriver.getText());
        tProps.put("JDBCurl",lUrl.getText());
        tProps.put("DatabasePort",lPort.getText());
	tProps.put("usePassword",getUsePassword());

	tProps.put("DebugMode","off");
	try {

	    // Does this File exist?
	    String admin_dir = System.getProperty("admin.work");
	    if (admin_dir  == null ) admin_dir = System.getProperty("user.home");

	    //File f = new File (admin_dir +File.separator+"t_connect.props");
            //boolean df = f.delete();

	    FileOutputStream fops = new FileOutputStream(admin_dir+File.separator+"t_connect.props");
	    //tProps.save(fops,"Properties for t_connect");
	    tProps.store(fops,"Properties for t_connect");
	    //fops.flush();
	    fops.close();
       } catch (Exception e) {
	   System.out.println("Error saving t_connect.props :"+e);
	   e.printStackTrace();
       }

    }


}
