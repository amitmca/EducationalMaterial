package gpl.fredy.admin;


/** Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, like:
 * - create/ drop tables
 * - create  indices
 * - perform sql-statements
 * - simple form
 * - a guided query
 * - Data Export
 * and a other usefull things in DB-arena
 *
 * Admin  (Version see below)
 * Copyright (c) 1999 Fredy Fischer
 * sql@hulmen.ch
 *
 * Fredy Fischer
 * Hulmenweg 36
 * 8405 Winterthur
 * Switzerland
 *
 *
 * The icons used in this application are from Dean S.  Jones
 *
 * Icons Copyright(C) 1998 by Dean S.  Jones dean@gallant.com
 * www.gallant.com/icons.htm
 *
 * CalendarBean is Copyright (c) by Kai Toedter
 *
 * MSeries is Copyright (c) by Martin Newstead
 *
 * POI is from the Apache Foundation
 *
 *
 * Copyright (C) 1999  Fredy Fischer
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 **/
import java.io.*;
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
import java.lang.reflect.*;
import java.util.logging.*;

import gpl.fredy.io.*;
import gpl.fredy.generate.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;
import gpl.fredy.sqltools.*;
import gpl.fredy.share.*;
import gpl.fredy.datadrill.*;


public class Admin extends JFrame implements  ActionListener, MouseListener {
    
    
    // Fredy's make Version
    private static String fredysVersion = "Version 2.4.2 2007-05-17";
    
    LoadImage loadImage = new LoadImage();
    
    /**
     * 2003-01-01   adding logging
     * 2003-05-12   adapted compiling out of the GenerateTool
     * implemented a method to init generated code with
     * a t_connect object to save number of connections
     * 2003-08-09   License change from GPL to LGPL
     * Export now is able to create xls-files
     * 2004-10-07   added new CreateTable -> offers foreign-key-relationships
     *              fixed bugs in: SqlMonitor -> desc is now possible
     *                             Import     -> fixed connectionproblem
     * 2007-01      Selection-tool integrated
     * 2007-05      made it jar-safe
     **/
    
    public String getVersion() {return fredysVersion; }
    
    
    private Logger logger;
    
    private gpl.fredy.ui.SplashScreen Splash;
    private JLabel statusLine;
    
    ImageIcon genImgIcon;
    JPopupMenu popup;
    public JLayeredPane lc;
    //JScrollableDesktopPane  lc;
    JInternalFrame desktop;
    JList tableList;
    String[] table;
    String newdb;
    private Properties prop;
    private Qbe qbePanel;
    private AutoForm formPanel;
    private JCheckBoxMenuItem m30;
    private Color defaultColor;
    
    private ChooseColor cg;
    private JMenuBar menubar;
    private JInternalFrame msgFrame, qbeFrame, createFrame, createIdxFrame, formFrame,dropperFrame, aboutFrame,colorFrame,gplFrame,payFrame;
    private JTable tableView;
    public JCheckBox[] userChoice;
    public JTextField  hostHost, hostDB, userHost,userDb, userUser, dbHost, dbUser, dbDb,  User, propsHost, propsDB, propsmySQL;
    public JTextArea  dbInfo, tableInfo, msgBoard;
    // public JPasswordField password,userPassword;
    public JTextField password, userPassword;
    
    private CreateTable crTa;
    private DataBaseLogin logOn;
    
    private StackTracer stackTrace;
    private MsgBoard mb;
    
    protected Action dbInfoAction;
    protected Action generateCodeAction;
    protected Action exitAction;
    protected Action qbeAction;
    protected Action formAction;
    protected Action sqlMonitorAction;
    protected Action dropTableAction;
    protected Action createTableAction;
    protected Action createIndexAction;
    protected Action createUserAction;
    protected Action createDBAction;
    protected Action dropDBAction;
    protected Action backgroundAction;
    protected Action execPrgAction;
    protected Action aboutAction;
    
    private gpl.fredy.tools.SimpleLogServer sls = null;
    
    int mouseX;
    
    /**
     * Get the value of mouseX.
     * @return Value of mouseX.
     */
    public int getMouseX() {
        if (mouseX < 1) mouseX = 1;
        return mouseX;
    }
    
    /**
     * Set the value of mouseX.
     * @param v  Value to assign to mouseX.
     */
    public void setMouseX(int  v) {this.mouseX = v;}
    
    
    
    int mouseY;
    
    /**
     * Get the value of mouseY.
     * @return Value of mouseY.
     */
    public int getMouseY() {
        
        if ( mouseY < 1) mouseY=1;
        return mouseY;
    }
    
    /**
     * Set the value of mouseY.
     * @param v  Value to assign to mouseY.
     */
    public void setMouseY(int  v) {this.mouseY = v;}
    
    /**
     * Get the value of .
     * @return Value of .
     */
    
    private String lnF="default";
    
    private gpl.fredy.ui.MySQLconnections dash = null;
    
    private void setLnF(String v) { lnF = v; }
    private String getLnF() { return lnF; }
    
    /**
     * private boolean testConnection() {
     *
     * String msg = "Connection established";
     * boolean ok = true;
     * String rdbms = " ";
     *
     * t_connect con = logOn.getCon();
     * if ( (! con.acceptsConnection()) && ( con.getError() != null ) ) {
     * msg=con.getError();
     * ok = false;
     * } else {
     * try {
     * DatabaseMetaData md = con.con.getMetaData();
     * rdbms =  md.getDatabaseProductName();
     * //con.close();
     * } catch (Exception exception) {
     * msg=exception.getMessage().toString();
     * ok = false;
     * }
     * }
     *
     * mb.addText("JDBC-Driver: " + con.iJDBC);
     * mb.addText("JDBC-URL: " + con.iURL);
     * mb.addText("DBMS: " + rdbms);
     * mb.addText(msg);
     * if ( ! ok) {
     * mb.addText("Something is wrong,\ncan not connect to database");
     * }
     * //con.close();
     * return ok;
     * }
     **/
    
    private String getRDBMS() {
        try {
            t_connect tc = logOn.getCon();
            if ( tc.acceptsConnection()){
                DbInfo dbi = new DbInfo(logOn.getCon());
                return dbi.getProductName();
            } else {
                return "connection failed";
            }
        }  catch (Exception e) {
            e.initCause(new Throwable("connection failed"));
            stackTracer(e);
            return " no info available ";
        }
        
    }
    private void stackTracer(Exception e) {
        
        stackTrace.setExcpt(e);
        stackTrace.setVisible(true);
        
    }
    
    
    
    
    public static  void main(String args[]) {
        
        String imgDir =  System.getProperty("admin.image");
        
        if (imgDir == null ) imgDir = Admin.class.getResource("..") +  "images";
        if (imgDir.startsWith("nullimages") ) imgDir = "the jar-file";
        
        String workDir = System.getProperty("admin.work");
        if (workDir == null ) workDir =  System.getProperty("user.home");
        
        
        
        System.out.println(
                "\nThis is Fredy's admin-tool for SQL-Databases" +
                "\n--------------------------------------------\n" +
                "Admin is under LGPL\n\n" +
                "This is " + System.getProperty("os.name") + "\n\n" +
                "Systemproperties (to add with java -D<option> -D<option> gpl.fredy.admin.Admin)\n" +
                "----------------\n" +
                "Generic Properties:\n" +
                "admin.work=<directory> Default: "  + System.getProperty("user.home") + "\n" +
                "           this is the location of the config-files (admin.props, t_connect.props)\n" +
                "           I'm using: " + workDir + "\n\n" +
                "admin.image=<directory or URL> Default: gpl.fredy.images \n" +
                "           this is the location where admin fetches the images from\n" +
                "           I'm using: " + imgDir + "\n" +
                "\n");
        
        
        if ( (args.length > 0) && ( args[0].equalsIgnoreCase("-h") ) )
            System.out.println(
                    "\nLogging Properties: (Admin uses java.util.logging-API)\n" +
                    "admin.logging.extended=YES activates Admin-Logging via SimpleLogServer\n" +
                    "                           (your System needs to support TCP/IP)\n" +
                    "                           only for Admin-Main Logs\n" +
                    "admin.logging.host=<hostname or IP-Address> Default: localhost\n" +
                    "admin.logging.port=<PortNumber>  Default: 5237\n" +
                    "admin.logging.level=<Log-Level>  Default: INFO\n" +
                    "                                 Allowed: ALL, CONFIG, FINE, FINEST, FINER, INFO, OFF, SEVERE, WARNING\n\n");
        
        
        
        Admin a = new Admin();
    }
    
    private void initLogging() {
        logger = Logger.getLogger("gpl.fredy.admin");
        //logger.setLevel(Level.ALL);
        int loggPort = 5237;
        if ( isSocketHandler()) {
            if ( System.getProperty("admin.logging.port") != null )
                loggPort = Integer.parseInt(System.getProperty("admin.logging.port"));
            sls = new gpl.fredy.tools.SimpleLogServer(true, loggPort, 4096, false);
            sls.setLocal(false);
        }
        logger.log(Level.INFO,"base logger initialized");
        
        if ( System.getProperty("admin.logging.extended") !=null )
            logger.log(Level.INFO,"Extended logging is: " + System.getProperty("admin.logging.extended"));
        
        if ( (System.getProperty("admin.logging.extended") != null ) &&
                (System.getProperty("admin.logging.extended").equalsIgnoreCase("YES")) ) {
            
            logger.log(Level.INFO,"Using SocketHandler");
            try {
                
                // determine logger port
                if ( System.getProperty("admin.logging.port") != null )
                    loggPort = Integer.parseInt(System.getProperty("admin.logging.port"));
                
                // determine LogLevel
                String lev = "INFO";
                if ( System.getProperty("admin.logging.level") != null )
                    lev = System.getProperty("admin.logging.level");
                
                // on which host?
                String loggHost = "localhost";
                if ( System.getProperty("admin.logging.host") != null )
                    loggHost = System.getProperty("admin.logging.host");
                
                if ( (loggHost.equalsIgnoreCase("localhost") ) &&
                        ( sls != null)) {
                    sls = new gpl.fredy.tools.SimpleLogServer(true, loggPort, 4096, false);
                    sls.setLocal(false);
                }
                
                SocketHandler socketHandler = new SocketHandler(loggHost, loggPort);
                socketHandler.setFormatter(new gpl.fredy.tools.FxmlFormatter());
                
                if ( lev.equalsIgnoreCase("ALL") ) socketHandler.setLevel(Level.ALL);
                if ( lev.equalsIgnoreCase("CONFIG") ) socketHandler.setLevel(Level.CONFIG);
                if ( lev.equalsIgnoreCase("FINE") ) socketHandler.setLevel(Level.FINE);
                if ( lev.equalsIgnoreCase("FINER") ) socketHandler.setLevel(Level.FINER);
                if ( lev.equalsIgnoreCase("FINEST") ) socketHandler.setLevel(Level.FINEST);
                if ( lev.equalsIgnoreCase("INFO") ) socketHandler.setLevel(Level.INFO);
                if ( lev.equalsIgnoreCase("OFF") ) socketHandler.setLevel(Level.OFF);
                if ( lev.equalsIgnoreCase("WARNING") ) socketHandler.setLevel(Level.WARNING);
                if ( lev.equalsIgnoreCase("SEVERE") ) socketHandler.setLevel(Level.SEVERE);
                
                logger.addHandler(socketHandler);
            } catch ( SecurityException secEx) {
                logger.log(Level.WARNING,"Security Exception while creating logger");
                logger.log(Level.FINE,"Message: " + secEx.getMessage());
            } catch ( IOException logIOEx) {
                logger.log(Level.WARNING,"IO-Exception while creating logger");
                logger.log(Level.FINE,"Message: " + logIOEx.getMessage());
            }
        }
        
        
    }
    
    public Admin(){
        
        super("Fredy's SQL Admintool ");
        
        /**
         * The Logger is based onto Standard LogManager. See jre.lib.logging.properties
         * I wrote a Simple Log Server to use SocketHandler to log zentralized.
         *
         * The default logger I use for all my stuff is: gpl.fredy.admin
         *
         **/
        initLogging();
        
        
        // init the StackTracer
        stackTrace = new StackTracer(this,"Exception",true);
        stackTrace.cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stackTrace.setVisible(false);
            }
        });
        
        
        // handle Window-Events
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {goodbye();}
            public void windowActivated(WindowEvent evt) {;}
            public void windowDeactivated(WindowEvent evt) {;}
            public void windowIconified(WindowEvent evt) {
                mb.frame.setState(Frame.ICONIFIED);
            }
            public void windowDeiconified(WindowEvent evt) {;}
            public void windowOpened(WindowEvent evt) {;}
            public void windowClosed(WindowEvent evt) {goodbye();}
        });
        
        
        // setting IconImage
        try {
            this.setIconImage(loadImage.getImage("icon.gif").getImage());
        } catch (Exception whatException ) {
            logger.log(Level.INFO,"Error loading Image for Frame. Exception: " + whatException.getMessage());
            whatException.initCause(new Throwable("Error loading Image for Frame"));
            stackTracer(whatException);
        }
        
        
        
        // display Splash-Screen
        splash();
        
        mb = new MsgBoard();
        mb.setLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mb.openFile();
                setLogFile();
            }}
        );
        setLogFile();
        
        
        
        propertyChecks();
        
        genImgIcon = loadImage.getImage("generated.gif");
        
        
        lc = new JDesktopPane();
        //lc = new JScrollableDesktopPane();
        lc.setOpaque(false);
        defaultColor = lc.getBackground();
        
        lc.add(login(),JLayeredPane.PALETTE_LAYER);
        
        JScrollPane mc = new JScrollPane(lc);
        //mc.getViewport().add(lc);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(mc,BorderLayout.CENTER);
        this.getContentPane().add(statusPanel(),BorderLayout.SOUTH);
        this.addMouseListener(this);
        
        
        this.setSize(Integer.parseInt(prop.getProperty("width")),Integer.parseInt(prop.getProperty("heigth")));
        
        Splash.close();
        lnfchange(prop.getProperty("Look-n-Feel","default"));
        
        mb.frame.setVisible(true);
        this.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("exit")) goodbye();
    }
    
    
    public void processMouseEvent(MouseEvent e) {
        
        if ((popup != null) && e.isPopupTrigger()) {
            popup.show(this,e.getX(), e.getY());
            setMouseX(e.getX());
            setMouseY(e.getY());
        }
    }
    public void mouseClicked(MouseEvent e) {
        if ((popup != null) && e.isPopupTrigger()) {
            popup.show(this,e.getX(), e.getY());
            setMouseX(e.getX());
            setMouseY(e.getY());
        } else {
            super.processMouseEvent(e);
        }
    }
    public void mousePressed(MouseEvent e) {;}
    public void mouseReleased(MouseEvent e) {;}
    public void mouseEntered(MouseEvent e) {;}
    public void mouseExited(MouseEvent e) {;}
    
    
    
    private void propertyChecks() {
        // Load Properties
        prop = new Properties();
        
        /**
         * this is the same dir as the class: Admin.class.getResourceAsStream
         * but we put the props-File in the user's home-dir if there is not -D parameter for
         * place given at start
         **/
        try {
            
            String admin_dir = System.getProperty("admin.work");
            if (admin_dir  == null ) admin_dir = System.getProperty("user.home");
            
            FileInputStream fip = new FileInputStream(admin_dir + File.separator+"admin.props");
            prop.load(fip);
            fip.close();
            if (prop.getProperty("JDBCdriver") == null ) setDefaultProperties();
            logger.log(Level.INFO,"Using property-file: " + admin_dir + File.separator+"admin.props");
            
            
        } catch (Exception ioex) {
            
            logger.log(Level.WARNING,"can not lod properties file admin.props: " + ioex.getMessage().toString());
            
            mb.addText("Exception while loading props:" +
                    ioex
                    + "\n\nCreating default-file admin.props\nhost=localhost\nuser="+
                    System.getProperty("user.name")+
                    "\ndb=none\nwidth=600\nheigth=400\nmysqladmin=/usr/local/mysql/bin/mysqladmin\nusePassword=yes\nJDBCdriver=ocom.mysql.jdbc.Driver\nJDBCurl=jdbc:mysql://\nDatabasePort=3306\nRDBMS=mysql");
            setDefaultProperties();
        }
        
    }
    
    
    private void setDefaultProperties() {
        
        logger.log(Level.INFO,"Creating default Property-File");
        
        prop.put("host","localhost");
        prop.put("user",System.getProperty("user.name"));
        prop.put("db","");
        prop.put("width","800");
        prop.put("heigth","600");
        prop.put("mysqladmin","/usr/local/mysql/bin/mysqladmin");
        prop.put("usePassword","yes");
        prop.put("JDBCdriver","com.mysql.jdbc.Driver");
        prop.put("JDBCurl","jdbc:mysql://");
        prop.put("DatabasePort","3306");
        prop.put("RDBMS","mysql");
        prop.put("Look-n-Feel","default");
        prop.put("schema","%");
        prop.put("connections","25");
        
        saveConnectProperties();
        
    }
    
    
    
    private void splash() {
        
        
        Splash= new gpl.fredy.ui.SplashScreen(loadImage.getImage("admin.gif"));
        try{
            
            Splash.showStatus("Welcome to Fredy's");
            Thread.sleep(500);
            Splash.showStatus("Admin-Tool for SQL " + getVersion());
            Thread.sleep(500);
            Splash.showStatus("Fredy Fischer");
            Thread.sleep(500);
            Splash.showStatus("Hulmenweg 36");
            Thread.sleep(500);
            Splash.showStatus("CH-8405 Winterthur");
            Thread.sleep(500);
        } catch(Exception e){
            e.initCause(new Throwable("something went wrong with the Splash-Screen"));
            stackTracer(e);}
        
        
    }
    
    private void setLogFile() {
        if (mb.file != null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(mb.file)));
                mb.poller();
            } catch (FileNotFoundException fne) {
                fne.initCause(new Throwable("FileNotFound Exception for LogFile"));
                stackTracer(fne); }
        }
    }
    
    
    
    private JInternalFrame login() {
        
        
        Container contentPane;
        
        final JInternalFrame log = new JInternalFrame("Login",true,false,true,true);
        contentPane = log.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        logOn = new DataBaseLogin(prop.getProperty("RDBMS"));
        
        setLogOnValues();
        
        contentPane.add(logOn);
        
        logOn.lPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProperties();
                lc.add(pm());
                normalMenu();
                try {
                    log.setIcon(true);
                } catch (java.beans.PropertyVetoException pve) {
                    message(pve.getMessage());
                    pve.initCause(new Throwable(pve.getMessage()));
                    stackTracer(pve);
                }
            }}
        );
        
        
        logOn.connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                saveProperties();
                lc.add(pm());
                normalMenu();
                try {
                    log.setIcon(true);
                } catch (java.beans.PropertyVetoException pve) {
                    message(pve.getMessage());
                    pve.initCause(new Throwable(pve.getMessage()));
                    stackTracer(pve);
                }
            }}
        );
        
        
        logOn.cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string1 = "Yes";
                String string2 = "No";
                Object[] options = {string1, string2};
                int n = JOptionPane.showOptionDialog(null,
                        "Do you really want to leave?",
                        "Quit Admin?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //don't use a custom Icon
                        options,  //the titles of buttons
                        string2); //the title of the default button
                if (n == JOptionPane.YES_OPTION)   {
                    logOn.closeConnections();
                    System.exit(0);
                }}}
        );
        
        
        Dimension dim = new Dimension(logOn.getPreferredSize());
        log.pack();//setBounds(getMouseX(), getMouseY(), dim.width, dim.height+30);
        log.setVisible(true);
        return log;
    }
    
    
    private JInternalFrame users() {
        
        
        Container contentPane;
        
        JInternalFrame frame = new JInternalFrame("User",true,true,true,true);
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        
        JPanel     panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        JPanel     panel1 = new JPanel();
        ColumnLayout layout1 = new ColumnLayout(5,5,10,2);
        panel1.setLayout(layout1);
        JLabel label = new JLabel();
        label.setText("Host");
        panel1.add(label);
        
        
        JLabel label3 = new JLabel("Database");
        panel1.add(label3);
        
        JLabel label1 = new JLabel();
        label1.setText("User");
        panel1.add(label1);
        
        
        JLabel label2 = new JLabel();
        label2.setText("Password");
        panel1.add(label2);
        
        
        
        JPanel     panel2 = new JPanel();
        ColumnLayout layout2 = new ColumnLayout(5,5,5,0);
        panel2.setLayout(layout2);
        
        userHost = new JTextField(15);
        userHost.setText("%");
        userUser = new JTextField(15);
        userDb   = new JTextField(15);
        //userPassword = new JPasswordField(null,15);
        userPassword = new JTextField(null,15);
        
        panel2.add(userHost);
        panel2.add(userDb);
        panel2.add(userUser);
        panel2.add(userPassword);
        
        JLabel l = new JLabel(loadImage.getImage("mysql-06.gif"));
        panel2.add(l);
        
        
        Box box1 = Box.createVerticalBox();
        String[] choices = { "Select Priv", "Insert Priv", "Update Priv",
        "Delete Priv", "Create Priv", "Drop Priv",
        "Reload Priv", "Shutdown Priv", "Process Priv", "File Priv","Grant_priv","References_priv","Index_priv","Alter_priv"};
        String[] tips = { "Select Privilegs", "Insert Privilegs", "Update Privilegs",
        "Delete Privilegs", "Create Privilegs", "Drop Privilegs",
        "Reload Privilegs", "Shutdown Privilegs","Process Privilegs", "File Privilegs","Grant","Ref","Index","Alter" };
        
        userChoice = new JCheckBox[choices.length];
        for (int i = 0; i < choices.length; i++) {
            userChoice[i] = new JCheckBox(choices[i]);
            userChoice[i].setToolTipText(tips[i]);
            box1.add(userChoice[i]);
        }
        
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        
        JButton list = new JButton("List");
        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");
        
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pos = " ";
                
                t_connect con = new t_connect(logOn.getHost(), logOn.getUser(), logOn.getPassword(),"mysql");
                if (con.getError() != null) {
                    message(con.getError());
                } else {
                    try {
                        // first insert into user-Table of mysql
                        pos = "user";
                        int records = con.stmt.executeUpdate("insert into user " +
                                "values ('"+userHost.getText()+"', '"+userUser.getText() + "',PASSWORD('"+userPassword.getText()+"')" +
                                ", '" + checkPriv(userChoice[0]) +
                                "', '" + checkPriv(userChoice[1]) +
                                "', '" + checkPriv(userChoice[2]) +
                                "', '" + checkPriv(userChoice[3]) +
                                "', '" + checkPriv(userChoice[4]) +
                                "', '" + checkPriv(userChoice[5]) +
                                "', '" + checkPriv(userChoice[6]) +
                                "', '" + checkPriv(userChoice[7]) +
                                "', '" + checkPriv(userChoice[8]) +
                                "', '" + checkPriv(userChoice[9]) +
                                "', '" + checkPriv(userChoice[10]) +
                                "', '" + checkPriv(userChoice[11]) +
                                "', '" + checkPriv(userChoice[12]) +
                                "', '" + checkPriv(userChoice[13]) + "')");
                        // then insert into DB
                        pos = "db";
                        int records1 = con.stmt.executeUpdate("insert into db " +
                                "values ('"+userHost.getText() +"','"+userDb.getText() + "','"+userUser.getText() +
                                "', '" + checkPriv(userChoice[0]) +
                                "', '" + checkPriv(userChoice[1]) +
                                "', '" + checkPriv(userChoice[2]) +
                                "', '" + checkPriv(userChoice[3]) +
                                "', '" + checkPriv(userChoice[4]) +
                                "', '" + checkPriv(userChoice[5]) +
                                "', '" + checkPriv(userChoice[6]) +
                                "', '" + checkPriv(userChoice[7]) +
                                "', '" + checkPriv(userChoice[8]) +
                                "', '" + checkPriv(userChoice[9]) + "')");
                        //con.close();
                    } catch (Exception excpt) {
                        String ms = "affected: " + pos + "\n"+excpt.getMessage().toString();
                        message(ms);
                        excpt.initCause(new Throwable(ms));
                        stackTracer(excpt);
                    }
                }
                //con.close();
            }}
        );
        
        
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                t_connect con = new t_connect(logOn.getHost(), logOn.getUser(), logOn.getPassword(),"mysql");
                if (con.getError() != null) {
                    message(con.getError());
                } else {
                    try {
                        // first delete from user-Table of mysql
                        int records = con.stmt.executeUpdate("delete from user where User = '"+ userUser.getText()+"'");
                        // then delete from DB
                        int records1 = con.stmt.executeUpdate("delete from db where User = '"+ userUser.getText()+"'");
                        //con.close();
                    } catch (Exception excpt) {
                        message(excpt.getMessage().toString());
                        excpt.initCause(new Throwable(excpt.getMessage().toString()));
                        stackTracer(excpt);
                    }
                }
                //con.close();
            }}
        );
        
        
        
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sqlTable sqlt = new sqlTable(logOn.getHost(),logOn.getUser(),logOn.getPassword(),"mysql","select * from user");
                Dimension dim = sqlt.getPreferredSize();
                newFrame((JPanel)sqlt,"User-List",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,null);
                
                
            }}
        );
        
        buttonPanel.add(list);
        buttonPanel.add(insert);
        buttonPanel.add(delete);
        
        
        panel.add("West",panel1);
        panel.add("Center",panel2);
        panel.add("East",box1);
        panel.add("South",buttonPanel);
        
        
        JScrollPane mc = new JScrollPane();
        mc.getViewport().add(panel);
        
        contentPane.add("Center",mc);
        frame.pack();//setBounds(getMouseX(), getMouseY(), 400, 300);
        frame.setVisible(true);
        
        return frame;
    }
    
    private String checkPriv(JCheckBox b) {
        if (b.isSelected()) {
            return "Y";
        } else {
            return"N";
        }
        
        
    }
    
    
    private void message(String msg) {
        //JOptionPane.showMessageDialog(this, msg);
        //JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.WARNING_MESSAGE);
        
        logger.log(Level.FINE,msg);
        mb.addText(msg);
        mb.frame.setState(Frame.NORMAL);
        Toolkit tk = this.getToolkit();
        tk.beep();
        
    }
    
    
    
    
    private JInternalFrame dbs() {
        
        
        Container contentPane;
        
        JInternalFrame frame = new JInternalFrame("Databases",true,false,true,true);
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        frame.pack();//setBounds(getMouseX(), getMouseY(), 400, 215);
        
        JPanel     panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        JPanel     panel1 = new JPanel();
        ColumnLayout layout1 = new ColumnLayout(5,5,10,2);
        panel1.setLayout(layout1);
        JLabel label = new JLabel();
        label.setText("Host");
        panel1.add(label);
        
        JLabel label1 = new JLabel();
        label1.setText("Db");
        panel1.add(label1);
        
        
        JLabel label2 = new JLabel();
        label2.setText("User");
        panel1.add(label2);
        
        
        
        JPanel     panel2 = new JPanel();
        ColumnLayout layout2 = new ColumnLayout(5,5,5,0);
        panel2.setLayout(layout2);
        
        dbHost = new JTextField(15);
        dbDb   = new JTextField(15);
        dbUser = new JTextField(15);
        
        panel2.add(dbHost);
        panel2.add(dbDb);
        panel2.add(dbUser);
        
        JLabel l = new JLabel(loadImage.getImage("mysql-06.gi"));
        panel2.add(l);
        
        
        Box box1 = Box.createVerticalBox();
        String[] choices = { "Select Priv", "Insert Priv", "Update Priv",
        "Delete Priv", "Create Priv", "Drop Priv"};
        String[] tips = { "Select Privilegs", "Insert Privilegs", "Update Privilegs",
        "Delete Privilegs", "Create Privilegs", "Drop Privilegs"};
        for (int i = 0; i < choices.length; i++) {
            JCheckBox b = new JCheckBox(choices[i]);
            b.setToolTipText(tips[i]);
            box1.add(b);
        }
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        
        JButton list = new JButton("List");
        JButton modify = new JButton("Modify");
        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");
        
        buttonPanel.add(list);
        buttonPanel.add(modify);
        buttonPanel.add(insert);
        buttonPanel.add(delete);
        
        
        panel.add("West",panel1);
        panel.add("Center",panel2);
        panel.add("East",box1);
        panel.add("South",buttonPanel);
        
        
        JScrollPane mc = new JScrollPane();
        mc.getViewport().add(panel);
        
        contentPane.add("Center",mc);
        
        return frame;
    }
    
    private JInternalFrame setColor() {
        Container contentPane;
        
        colorFrame = new JInternalFrame("Color",true,true,true,true);
        contentPane = colorFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        
        cg = new ChooseColor(defaultColor);
        contentPane.add("Center",cg);
        cg.select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lc.setBackground(cg.getColor());
                lc.updateUI();
                colorFrame.dispose();
            }}
        );
        cg.cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorFrame.dispose();
            }}
        );
        colorFrame.pack();
        colorFrame.setVisible(true);
        return colorFrame;
        
    }
    
    
    
    private void qbe() {
        
        logger.log(Level.FINEST,"launching QBE by user " + logOn.getUser());
        
        t_connect aConnection = logOn.getCon();
        if ( (aConnection.acceptsConnection()) && (aConnection.getError() == null) ) {
            qbePanel = new Qbe(aConnection,logOn.getSchema());
            qbePanel.execQuery.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sqlTable sqlt = new sqlTable(qbePanel.getCon(),qbePanel.getQuery());
                    Dimension dim = sqlt.getPreferredSize();
                    newFrame((JPanel)sqlt,"Generated Query",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,null);
                }}
            );
            
            Dimension dim = qbePanel.getPreferredSize();
            newFrame((JPanel)qbePanel,"Guided Query",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,qbePanel.cancel);
        }
        
    }
    
    private JInternalFrame form() {
        
        try {
            logger.log(Level.FINEST,"launching AutoForm by user " + logOn.getUser());
            
            Container contentPane;
            
            formFrame = new JInternalFrame("Form",true,true,true,true);
            contentPane = formFrame.getContentPane();
            contentPane.setLayout(new BorderLayout());
            formFrame.setFrameIcon(genImgIcon);
            
            
            formPanel = new AutoForm(logOn.getCon(),logOn.getSchema());
            
            formFrame.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {}
                public void componentMoved(ComponentEvent e) {}
                public void componentResized(ComponentEvent e) {
                    Dimension d = new Dimension();
                    d = formFrame.getSize();
                    Integer intx = new Integer(d.width);
                    Integer inty = new Integer(d.height);
                    double fx = intx.floatValue() * 0.75;
                    double fy = inty.floatValue() * 0.65;
                    Double dfx = new Double(fx);
                    Double dfy = new Double(fy);
                    
                    formPanel.setVSize(dfx.intValue(), dfy.intValue() );
                    formPanel.setFormSize();
                }
                public void componentShown(ComponentEvent e) {}
            });
            
            
            
            formPanel.cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formPanel.close();
                    formFrame.dispose();
                }}
            );
            
            JScrollPane mc = new JScrollPane();
            mc.getViewport().add(formPanel);
            
            contentPane.add("Center",mc);
            formFrame.pack();//setBounds(getMouseX(), getMouseY(), 560, 310);
            formFrame.setVisible(true);
            return formFrame;
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
            return null;
        }
    }
    
    private void dropTable() {
        
        try {
            logger.log(Level.FINEST,"launching DropTable by user " + logOn.getUser());
            
            DropTable panel = new DropTable(logOn.getCon(),logOn.getSchema());
            Dimension dim = panel.getPreferredSize();
            newFrame((JPanel)panel,"Drop Table",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,panel.cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
        
    }
    
    
    private void select() {
        
        try {
            SqlMonitor sm = new SqlMonitor(logOn.getCon(),logOn.getSchema());
            Dimension dim = sm.getPreferredSize();
            newFrame((JPanel)sm,"SQL-Monitor",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,sm.exit);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
    }
    
    private void dataSelect() {
        try {
            SelectionGui selGui = new SelectionGui(logOn.getCon());
            Dimension dim = selGui.getPreferredSize();
            newFrame((JPanel)selGui,"Data Selection",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,selGui.exit);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
    }
    
    private void dataSelectionDemoEnvironment() {
        
        String filePath = "";
        localAdminDir = System.getProperty("admin.work");
        final Properties prop = new Properties();
        try {
            
            if (localAdminDir  == null ) localAdminDir = System.getProperty("user.home");
            
            try {
                FileInputStream fip = new FileInputStream(localAdminDir + File.separator+"admin.selgui.props");
                prop.load(fip);
                fip.close();
            } catch (Exception fipEx) {
                logger.log(Level.INFO,"need to create properties for the first time");
            }
            
            if (prop.getProperty("selection.path") == null )  {
                filePath = localAdminDir + File.separator + "datadrill" + File.separator + "resources" + File.separator;
                prop.put("selection.path",filePath);
            } else {
                filePath = prop.getProperty("selection.path");
            }
            
            final CreateDemoEnv demoEnv = new CreateDemoEnv(filePath);
            demoEnv.setCon(logOn.getCon().getCon());
            
            Dimension dim = demoEnv.getPreferredSize();
            
            Thread t = new Thread() {
                public void run() {
                    try {
                        Container contentPane;
                        final JInternalFrame frame = new JInternalFrame("Create Demo Environment",
                                true,
                                true,
                                false,
                                true);
                        contentPane = frame.getContentPane();
                        contentPane.setLayout(new BorderLayout());
                        
                        
                        JScrollPane scrollpane = new JScrollPane(demoEnv);
                        
                        contentPane.add("Center",scrollpane);
                        
                        demoEnv.undo.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                            }}
                        );
                        
                        demoEnv.exitButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                
                                // update Properties path
                                prop.put("selection.path",demoEnv.getFileLocation());
                                // write back properties
                                try {
                                    FileOutputStream fops = new FileOutputStream(localAdminDir+File.separator+"admin.selgui.props");
                                    prop.store(fops,"Selection properties Fredy's SqlAdmin");
                                    fops.close();
                                } catch (Exception propE) {
                                    logger.log(Level.WARNING,"Can not save properties " + propE.getMessage());
                                }
                                frame.dispose();
                            }}
                        );                                                
                        
                        lc.add(frame,4);
                        frame.moveToFront();
                        frame.pack();
                        frame.setVisible(true);
                    } catch (Exception foo ) {
                        foo.initCause(new Throwable(foo.getMessage()));
                        stackTracer(foo); }
                }
                
            };
            t.start();                                                
            
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
        
        
        
    }
    
    private void importDelimiter() {
        
        try {
            logger.log(Level.FINEST,"launching Import by user " + logOn.getUser());
            
            Import imp = new Import(logOn.getCon(),logOn.getSchema());
            Dimension dim = imp.getPreferredSize();
            newFrame(imp,"Import",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,imp.cancel);
        }catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
        
    }
    
    private void cpTable() {
        
        logger.log(Level.FINEST,"launching TableCopy by user " + logOn.getUser());
        
        TableCopyGUI tcg = new TableCopyGUI();
        Dimension dim = tcg.getPreferredSize();
        newFrame(tcg,"Import",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,tcg.cancel);
        
        
    }
    
    
    private JMenu dbOpsMenu() {
        
        JMenu m0 = new JMenu("Database operations");
        
        JMenuItem m01 = new JMenuItem("Create Tables",loadImage.getImage("newsheet.gif"));
        m01.setActionCommand("createTables");
        m01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTable();
            }}
        );
        JMenuItem m01aa = new JMenuItem("Create Tables (2)",loadImage.getImage("newsheet.gif"));
        m01aa.setActionCommand("createTables2");
        m01aa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTable2();
            }}
        );
        
        JMenuItem m0a = new JMenuItem("Create Index",loadImage.getImage("updatecolumn.gif"));
        m0a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createIndex();
            }}
        );
        
        JMenuItem m02 = new JMenuItem("Drop Tables",loadImage.getImage("deletesheet.gif"));
        m02.setActionCommand("dropTables");
        m02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dropTable();
            }}
        );
        
        JMenuItem m03 = new JMenuItem("Create User",loadImage.getImage("user.gif"));
        m03.setToolTipText("must have acces to mysql-database");
        m03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lc.add(users(),3);
            }}
        );
        
        JMenuItem m04 = new JMenuItem("Create Database",loadImage.getImage("data.gif"));
        m04.setToolTipText("must have acces to mysql-database and File-Create Permissions");
        m04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createDB();
            }}
        );
        
        JMenuItem m05 = new JMenuItem("Drop Database",loadImage.getImage("delete.gif"));
        m05.setToolTipText("must have acces to mysql-database and File-Create Permissions");
        m05.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDB();
            }}
        );
        
        
        JMenuItem m06 = new JMenuItem("Alter Table",loadImage.getImage("altertable.gif"));
        m06.setToolTipText("change a table (update/add rows)");
        m06.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ChangeTable ctbl = new ChangeTable(logOn.getCon(),logOn.getSchema());
                    newFrame(ctbl,"ChangeTable",true, true, true, true, getMouseX(), getMouseY(),0,0,ctbl.exit);
                } catch (Exception e2) {
                    e2.initCause(new Throwable(e2.getMessage()));
                    stackTracer(e2);
                }
            }}
        );
        
        
        m0.add(m01);
        m0.add(m01aa);
        m0.add(m06);
        m0.add(m02);
        m0.add(m0a);
        //m0.add(m03);
        //m0.add(m04);
        //m0.add(m05);
        
        return m0;
        
    }
    
    
    private JMenu dataOpsMenu() {
        JMenu m1 = new JMenu("Data operations");
        
        JMenuItem m10 = new JMenuItem("guided query",loadImage.getImage("binocular.gif"));
        m1.add(m10);
        m10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                qbe();
            }}
        );
        
        JMenuItem m11 = new JMenuItem("Form",loadImage.getImage("documentdraw.gif"));
        m1.add(m11);
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lc.add(form(),4);
            }}
        );
        
        JMenuItem m12 = new JMenuItem("SQL Monitor",loadImage.getImage("computer.gif"));
        m1.add(m12);
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select();
            }}
        );
        
        JMenu m13Menu = new JMenu("Data Selection Tool");
        JMenuItem m14 = new JMenuItem("Create Demo environment",loadImage.getImage("hammer.gif"));
        m14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataSelectionDemoEnvironment();
            }}
        );
        JMenuItem m13 = new JMenuItem("Data Selections",loadImage.getImage("dataextract.gif"));
        
        m13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataSelect();
            }}
        );
        
        m13Menu.add(m13);
        m13Menu.add(m14);

        m1.add(m13Menu);
        
        return m1;
        
    }
    
    
    private JMenu dbInfoMenu() {
        
        JMenu dbIM = new JMenu("Database Info");
        
        JMenuItem m1 = new JMenuItem("RDBMS",loadImage.getImage("camera.gif"));
        m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DBTreeView dbtv = new DBTreeView(logOn.getCon());;
                    newFrame(dbtv,"RDBMS",true, true, true, true, getMouseX(), getMouseY(),0,0,dbtv.cancel);
                } catch (Exception e2) {
                    e2.initCause(new Throwable(e2.getMessage()));
                    stackTracer(e2); }
            }}
        );
        
        JMenuItem m2 = new JMenuItem("this DB",loadImage.getImage("cameraflash.gif"));
        m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                databaseInfo(logOn.getDatabase());
            }}
        );
        
        dbIM.add(m1);
        dbIM.add(m2);
        return dbIM;
    }
    
    
    
    private JMenuItem generateCode() {
        
        JMenuItem m2 = new JMenuItem("Generate Java-Code",loadImage.getImage("hammer.gif"));
        m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gC();
            }}
        );
        return m2;
    }
    
    
    private void gC() {
        
        logger.log(Level.FINEST,"launching GenerateCode by user " + logOn.getUser());
        try {
            
            GenerateTool gt = new GenerateTool(logOn.getCon());
            gt.setPassword(logOn.getPassword());
            gt.setHost(logOn.getHost());
            gt.setUser(logOn.getUser());
            gt.setDatabase(logOn.getDatabase());
            gt.setSchema(logOn.getSchema());
            gt.askXMLFile.setText(System.getProperty("user.home") +
                    java.io.File.separator +
                    dbNameVerifier(logOn.getDatabase().toLowerCase() ) +
                    ".xml");
            Dimension dim = gt.getPreferredSize();
            newFrame(gt,"Generate Java-Code Tool",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,gt.cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e); }
    }
    public String dbNameVerifier( String v ) {
        
        File f = new File(v);
        if ( f.exists() ) {
            if ( f.isDirectory() ) v = f.getName() + "_dbdesc";
            if ( f.isFile()      ) v = f.getName() + "_dbdesc";
        }
        
        return v;
    }
    
    
    
    private JMenu propsMenu() {
        
        
        JMenu m3 = new JMenu("Properties");
        m30 = new JCheckBoxMenuItem("Save on exit");
        m30.setState(true);
        m30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }}
        );
        
        m3.add(m30);
        
        JMenuItem m31 = new JMenuItem("Select background color",loadImage.getImage("palette.gif"));
        m31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lc.add(setColor(),4);
            }}
        );
        
        m3.add(m31);
        
        return m3;
    }
    
    
    
    private JMenu progMenu() {
        JMenu m4 = new JMenu("Tools");
        
        
        JMenuItem m47 = new JMenuItem("Data Export",loadImage.getImage("export.gif"));
        m47.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataExport();
            }}
        );
        
        m4.add(m47);
        if ( isSocketHandler() && (sls != null) ) {
            JMenuItem m48 = new JMenuItem("Simple Log Server",loadImage.getImage("logserver.gif"));
            m48.setToolTipText("makes only sense, if you let Admin use the right logging.properties");
            m48.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sls.frame.setVisible(true);
                }}
            );
            
            m4.add(m48);
            m4.add(new JSeparator());
        }
        
        if ( logOn.getCon().getProductName().toLowerCase().startsWith("mysql") ) {
            JMenuItem m49 = new JMenuItem("MySQL Dashboard",loadImage.getImage("dashboard.gif"));
            m49.setToolTipText("displays information about the running MySQL");
            m49.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if ( dash == null) {
                        dash = new gpl.fredy.ui.MySQLconnections(logOn.getCon());
                        dash.setLocal(false);
                    } else {
                        dash.setVisible(true);
                    }
                    
                }}
            );
            m4.add(m49);
            m4.add(new JSeparator());
            
        }
        JMenuItem m40 = new JMenuItem("Execute Command",loadImage.getImage("enter.gif"));
        m40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                execCMD();
            }}
        );
        m4.add(m40);
        
        JMenuItem m41 = new JMenuItem("Import delimiter file",loadImage.getImage("documentin.gif"));
        m41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                importDelimiter();
            }}
        );
        m4.add(m41);
        
        
        JMenuItem m42 = new JMenuItem("Copy Table",loadImage.getImage("move.gif"));
        m42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cpTable();
            }}
        );
        m4.add(m42);
        
        JMenuItem m43 = new JMenuItem("Browser",loadImage.getImage("home.gif"));
        m43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser();
            }}
        );
        
        m4.add(m43);
        
        return m4;
        
    }
    
    
    private JMenuItem aboutMenu() {
        
        JMenuItem m5 = new JMenuItem("About",loadImage.getImage("bulb.gif"));
        m5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                about();
            }}
        );
        
        return m5;
    }
    
    
    private void setOS(String os) {
        Properties p = System.getProperties();
        p.put("os.name",os);
        System.setProperties(p);
    }
    
    
    
    private JMenu laf() {
        
        JMenu lookfeel = new JMenu("Look & Feel");
        ButtonGroup group = new ButtonGroup();
        
        JRadioButtonMenuItem defaultMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Default"));
        defaultMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("default");
            }}
        );
        defaultMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("default"));
        defaultMenuItem.setSelected(true);
        group.add(defaultMenuItem);
        
        
        JRadioButtonMenuItem motifMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("CDE / Motif Look and Feel"));
        motifMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOS("CDE/Motif");
                lnfchange("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            }}
        );
        motifMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("CDE/Motif"));
        group.add(motifMenuItem);
        //motifMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        JRadioButtonMenuItem metalMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Metal Look and Feel"));
        metalMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("javax.swing.plaf.metal.MetalLookAndFeel");
            }}
        );
        metalMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("Metal"));
        metalMenuItem.setSelected(true);
        group.add(metalMenuItem);
        //metalMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        
        /*
        JRadioButtonMenuItem macMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Mac Look and Feel"));
        macMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOS("Mac");
                lnfchange("javax.swing.plaf.mac.MacLookAndFeel");
            }}
        );
        macMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("Mac"));
        //macMenuItem.setSelected(true);
        group.add(macMenuItem);
        //macMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
         */
        
        JRadioButtonMenuItem kunstStoffMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Kunststoff look and Feel"));
        kunstStoffMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("com.incors.plaf.kunststoff.KunststoffLookAndFeel");
            }}
        );
        kunstStoffMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("Kunststoff"));
        kunstStoffMenuItem.setSelected(true);
        group.add(kunstStoffMenuItem);
        
        
        JRadioButtonMenuItem nextMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("NextStep look and Feel"));
        nextMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("nextlf.plaf.NextLookAndFeel");
            }}
        );
        nextMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("nextlf"));
        nextMenuItem.setSelected(true);
        group.add(nextMenuItem);
        
        
        JRadioButtonMenuItem nimrodMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("nimrod look and Feel"));
        nimrodMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("com.nilo.plaf.nimrod.NimRODLookAndFeel");
            }}
        );
        
        nimrodMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("nimrod"));
        nimrodMenuItem.setSelected(true);
        group.add(nimrodMenuItem);
        
        
        /*
         * Tonic has problems with some layoutmanager
         *
        JRadioButtonMenuItem tonicMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Tonic look and Feel"));
        tonicMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("com.digitprop.tonic.TonicLookAndFeel");
            }}
        );
        tonicMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("tonic"));
        tonicMenuItem.setSelected(true);
        group.add(tonicMenuItem);
         */
        
        JRadioButtonMenuItem napkinMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Napkin look and Feel"));
        napkinMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("net.sourceforge.napkinlaf.NapkinLookAndFeel");
            }}
        );
        napkinMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("napkin"));
        napkinMenuItem.setSelected(true);
        group.add(napkinMenuItem);
        
        /*
         
        JRadioButtonMenuItem lipstickMenuItem = (JRadioButtonMenuItem) lookfeel.add(new JRadioButtonMenuItem("Lipstick look and Feel"));
        lipstickMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lnfchange("com.lipstikLF.LipstickLookAndFeel");
            }}
        );
        lipstickMenuItem.setSelected(UIManager.getLookAndFeel().getName().equals("lipstick"));
        lipstickMenuItem.setSelected(true);
        lipstickMenuItem.setToolTipText("for the girls of us");
        group.add(lipstickMenuItem);
         
         */
        return lookfeel;
        
    }
    
    
    private JMenuItem exitMenu() {
        
        JMenuItem mx = new JMenuItem("Exit",loadImage.getImage("exit.gif"));
        mx.setActionCommand("exit");
        popup.add(mx);
        mx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goodbye();
            }}
        );
        
        return mx;
        
    }
    
    
    private void normalMenu() {
        
        menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        fileMenu.add(dbInfoMenu());
        fileMenu.add(new JSeparator());
        fileMenu.add(generateCode());
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenu());
        helpMenu.add(aboutMenu());
        
        menubar.add(fileMenu);
        menubar.add(dataOpsMenu());
        menubar.add(dbOpsMenu());
        menubar.add(propsMenu());
        menubar.add(progMenu());
        menubar.add(laf());
        menubar.add(Box.createHorizontalGlue());
        menubar.add(helpMenu);
        menubar.setEnabled(false);
        this.setJMenuBar(menubar);
        //this.getContentPane().add("North",menubar);
        //	this.pack();
        this.setSize(Integer.parseInt(prop.getProperty("width"))+1,Integer.parseInt(prop.getProperty("heigth"))+1);
        this.setSize(Integer.parseInt(prop.getProperty("width")),Integer.parseInt(prop.getProperty("heigth")));
        
        
    }
    
    
    private JPopupMenu pm() {
        
        
        popup = new JPopupMenu("Main Menu");
        
        
        popup.add(aboutMenu());
        popup.add(dbInfoMenu());
        popup.add(generateCode());
        popup.add(dataOpsMenu());
        popup.add(dbOpsMenu());
        popup.add(propsMenu());
        popup.add(progMenu());
        popup.add(new JSeparator());
        popup.add(laf());
        popup.add(new JSeparator());
        popup.add(exitMenu());
        
        return popup;
    }
    
    private void browser() {
        Thread t = new Thread() {
            public void run() {
                Browser bro = new Browser();
                Dimension dim = bro.getPreferredSize();
                newFrame(bro,"Browser",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,bro.cancel);
            }};
            t.start();
            
    }
    
    private boolean isSocketHandler() {
        boolean v = false;
        Handler[] handler = logger.getHandlers();
        logger.log(Level.FINE,"Number of Handlers found:  " + handler.length);
        for (int i = 0; i < handler.length; i++) {
            if ( handler[i] instanceof SocketHandler) v = true;
        }
        
        return v;
    }
    
    
    public void lnfchange(String lnf) {
        
        try {
            if ( lnf.toLowerCase().startsWith("default") )  lnf = UIManager.getSystemLookAndFeelClassName();
            
            UIManager.setLookAndFeel(lnf);
            SwingUtilities.updateComponentTreeUI(this);
            setLnF(lnf);
        } catch (Exception exc) {
            message("can not load look & feel: " + lnf);
            exc.initCause(new Throwable("can not load look & feel: " + lnf));;
            stackTracer(exc);
        }
        
        //this.setSize(Integer.parseInt(prop.getProperty("width")),Integer.parseInt(prop.getProperty("heigth")));
        //this.setVisible(true);
        //this.pack();
    }
    
    
    private void databaseInfo(String db) {
        try {
            Container contentPane;
            
            tableList = new JList();
            
            JPanel     panel = new JPanel();
            panel.setLayout(new BorderLayout());
            
            
            JPanel     panel1 = new JPanel();
            panel1.setLayout(new ColumnLayout(5,5,5,0));
            
            dbInfo = new JTextArea("",5,30);
            dbInfo.setEditable(false);
            JScrollPane scrollpane = new JScrollPane();
            scrollpane.getViewport().add(dbInfo);
            
            panel1.add((JLabel) new JLabel("About"));
            panel1.add(scrollpane);
            
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            JButton cancel = new JButton("Cancel",loadImage.getImage("exit.gif"));
            buttonPanel.add(cancel);
            panel1.add(buttonPanel);
            
            DbInfo dbi = new DbInfo(logOn.getCon());
            
            dbInfo.append("DBMS: \t" + dbi.getProductName() +
                    dbi.getProductVersion()+"\n");
            dbInfo.append("JDBC Driver: \t" + dbi.getDriverName() +
                    dbi.getDriverVersion()+"\n");
            dbInfo.append("Database: \t" + db + "\n");
            dbInfo.append("Schema: \t" + logOn.getSchema() + "\n");
            dbInfo.append("Driver: \t" + logOn.getCon().getDriver()+ "\n");
            dbInfo.append("URL: \t" + logOn.getCon().getURL());
            
            tableList.setListData(dbi.getTables(db,logOn.getSchema()));
            
            MouseListener mouseListener = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int index = tableList.locationToIndex(e.getPoint());
                        
                        TableMetaData tmd = new  TableMetaData(logOn.getCon(),
                                logOn.getSchema(),
                                tableList.getModel().getElementAt(index).toString());
                        
                        newFrame(tmd,"Info on: " + tableList.getModel().getElementAt(index).toString(), true,true,true,true, getMouseX(), getMouseY(),500,215, tmd.cancel);
                        
                    }
                }};
                tableList.addMouseListener(mouseListener);
                
                
                JScrollPane listPane = new JScrollPane(tableList);
                
                JPanel panel2 = new JPanel();
                panel2.setLayout(new ColumnLayout(5,5,5,0));
                panel2.add((JLabel) new JLabel("Tables"));
                panel2.add(listPane);
                
                panel.add("West",panel1);
                panel.add("East",panel2);
                
                JScrollPane mc = new JScrollPane();
                mc.getViewport().add(panel);
                
                Dimension dim = panel.getPreferredSize();
                newFrame(panel,"DB-Info ", true,true,true,true, getMouseX(), getMouseY(),
                        dim.width,dim.height + 20, cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e); }
    }
    
    private void newFrame(final JPanel panel,
            final String title,
            final boolean resizable,
            final boolean closable,
            final boolean maximizable,
            final boolean iconifiable,
            final int x, final int y,
            final int width, final int height,
            final JButton cancel) {
        
        Thread t = new Thread() {
            public void run() {
                try {
                    Container contentPane;
                    final JInternalFrame frame = new JInternalFrame(title,
                            resizable,
                            closable,
                            maximizable,
                            iconifiable);
                    contentPane = frame.getContentPane();
                    contentPane.setLayout(new BorderLayout());
                    
                    
                    JScrollPane scrollpane = new JScrollPane(panel);
                    
                    contentPane.add("Center",scrollpane);
                    if ( cancel != null ) {
                        cancel.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                            }}
                        );
                    }
                    
                    lc.add(frame,4);
                    frame.moveToFront();
                    frame.reshape(x,y,width,height);
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception foo ) {
                    foo.initCause(new Throwable(foo.getMessage()));
                    stackTracer(foo); }
            }
            
        };
        t.start();
        
    }
    public void createDB() {
        
        if (  ( newdb = JOptionPane.showInputDialog(this,"Please enter Database-Name")) != null ) {
            
            try {
                Runtime rt = Runtime.getRuntime();
                Process prcs = rt.exec(prop.getProperty("mysqladmin") + " create " + newdb);
                InputStreamReader isr = new InputStreamReader( prcs.getInputStream() );
                BufferedReader d = new BufferedReader( isr );
                
                String line;
                while ( (line=d.readLine() ) != null )
                    message(line);
            } catch (IOException ioe) {
                message("IO-Exception: " + ioe);
                ioe.initCause(new Throwable("IO-Exception: " + ioe.getMessage()));
                stackTracer(ioe);
            }
        }
        
    }
    public void deleteDB() {
        
        if (  ( newdb = JOptionPane.showInputDialog(this,"Please enter Database-Name to delete")) != null ) {
            
            try {
                Runtime rt = Runtime.getRuntime();
                Process prcs = rt.exec(prop.getProperty("mysqladmin") + " drop " + newdb);
                InputStreamReader isr = new InputStreamReader( prcs.getInputStream() );
                BufferedReader d = new BufferedReader( isr );
                
                String line;
                while ( (line=d.readLine() ) != null )
                    message(line);
            } catch (IOException ioe) {
                message("IO-Exception: " + ioe);
                ioe.initCause(new Throwable("IO-Exception: " + ioe.getMessage()));
                stackTracer(ioe);
            }
        }
        
    }
    
    
    public void execCMD() {
        if (  ( newdb = JOptionPane.showInputDialog(this,"Please enter command")) != null ) {
            
            Thread t = new Thread() {
                public void run() {
                    messageBoard();
                    try {
                        Runtime rt = Runtime.getRuntime();
                        Process prcs = rt.exec(newdb);
                        InputStreamReader isr = new InputStreamReader( prcs.getInputStream() );
                        BufferedReader d = new BufferedReader( isr );
                        
                        String line;
                        msgBoard.setText("");
                        while ( (line=d.readLine() ) != null )
                            msgBoard.append(line+"\n");
                    } catch (IOException ioe) {
                        message("IO-Exception: " + ioe);
                        ioe.initCause(new Throwable("IO-Exception: " + ioe.getMessage()));
                        stackTracer(ioe);
                    }
                }
            };
            t.start();
        }
    }
    
    private void setLogOnValues() {
        logOn.setHost(prop.getProperty("host"));
        logOn.setUser(prop.getProperty("user"));
        logOn.setUsePassword(prop.getProperty("usePassword"));
        logOn.setDatabase(prop.getProperty("db"));
        logOn.setDriver(prop.getProperty("JDBCdriver"));
        logOn.setUrl(prop.getProperty("JDBCurl"));
        logOn.setPort(prop.getProperty("DatabasePort"));
        logOn.setSchema(prop.getProperty("schema"));
        logOn.setConnections(Integer.parseInt(prop.getProperty("connections")));
    }
    
    
    public void goodbye() {
        if ( m30.getState()) saveProperties();
        logOn.closeConnections();
        stackTrace.dispose();
        System.exit(0);
    }
    
    private void saveProperties() {
        Dimension dim = this.getSize();
        prop.put("width",Integer.toString(dim.width));
        prop.put("heigth",Integer.toString(dim.height));
        prop.put("host",logOn.getHost());
        prop.put("user",logOn.getUser());
        prop.put("db",logOn.getDatabase());
        prop.put("usePassword",logOn.getUsePassword());
        prop.put("JDBCdriver",logOn.getDriver());
        prop.put("JDBCurl",logOn.getUrl());
        prop.put("DatabasePort",logOn.getPort());
        prop.put("RDBMS",getRDBMS());
        prop.put("Look-n-Feel",getLnF());
        prop.put("schema",logOn.getSchema());
        prop.put("connections",Integer.toString(logOn.getConnections()));
        
        
        saveAdminProps();
        saveConnectProperties();
    }
    
    private void saveAdminProps() {
        
        try {
            
            // Does this File exist?
            String admin_dir = System.getProperty("admin.work");
            if (admin_dir  == null ) admin_dir = System.getProperty("user.home");
            
            FileOutputStream fops = new FileOutputStream(admin_dir+File.separator+"admin.props");
            prop.store(fops,"Properties Fredy's SqlAdmin");
            fops.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error saving admin.props :"+e.getMessage());
            e.initCause(new Throwable("Error saving admin.props : "+e.getMessage()));
            stackTracer(e);
        }
        
    }
    
    
    private void saveConnectProperties() {
        Properties tProps = new Properties();
        tProps.put("JDBCdriver",prop.getProperty("JDBCdriver"));
        tProps.put("JDBCurl",prop.getProperty("JDBCurl"));
        tProps.put("DatabasePort",prop.getProperty("DatabasePort"));
        tProps.put("usePassword",prop.getProperty("usePassword"));
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
            mb.addText("Error saving t_connect.props :"+e);
            e.initCause(new Throwable("Error saving t_connect.props : "+e.getMessage()));
            stackTracer(e);
        }
        
    }
    
    
    
    public void messageBoard() {
        
        Container contentPane;
        
        msgFrame = new JInternalFrame("MessageBoard",true,true,true,true);
        contentPane = msgFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        msgBoard = new JTextArea("",10,30);
        msgBoard.setEditable(false);
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(msgBoard);
        
        contentPane.add("Center",scrollpane);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msgFrame.dispose();
            }}
        );
        
        panel1.add(close);
        contentPane.add("South",panel1);
        
        msgFrame.pack();
        lc.add(msgFrame,4);
        msgFrame.moveToFront();
        msgFrame.setVisible(true);
    }
    
    
    
    private void createTable() {
        try {
            crTa = new CreateTable(logOn.getCon());
            
            Dimension dim = crTa.getPreferredSize();
            newFrame(crTa,"Create Table",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,crTa.cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e); }
    }
    
    private void createTable2() {
        try {
            CreateTable2 crTa2 = new CreateTable2(logOn.getCon());
            
            Dimension dim = crTa2.getPreferredSize();
            newFrame(crTa2,"Create Table2",true, true, true, true, getMouseX(), getMouseY(),dim.width,dim.height + 20,crTa2.cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
    }
    private void createIndex() {
        try {
            CreateIndex crIdx = new CreateIndex(logOn.getCon(),logOn.getSchema());
            Dimension dim = crIdx.getPreferredSize();
            newFrame((JPanel)crIdx,"Create Index",
                    true,
                    true,
                    true,
                    true,
                    getMouseX(),
                    getMouseY(),
                    dim.width,
                    dim.height + 20,
                    crIdx.cancel);
        } catch (Exception e) {
            e.initCause(new Throwable(e.getMessage()));
            stackTracer(e);
        }
        
    }
    
    private void execSQL(String sqlQuery) {
        try {
            int records = logOn.getCon().stmt.executeUpdate(sqlQuery);
            message(Integer.toString(records)+" rows affected");
        } catch (Exception excpt) {
            message(excpt.getMessage().toString());
            excpt.initCause(new Throwable(excpt.getMessage()));
            stackTracer(excpt);
        }
    }
    
    public String getInfo() {
        
        return "Admin is a Tool around SQL-DBs to do basic jobs" +"\n" +
                "for DB-Administrations, like:" +"\n" +
                "- create/ drop tables" +"\n" +
                "- create  indices" +"\n" +
                "- perform sql-statements" +"\n" +
                "- create Java-Code" +"\n" +
                "- simple form" +"\n" +
                "- a guided query" +"\n" +
                "- export data into various formats\n" +
                "and other usefull things in DB-arena" +"\n" +
                "" +"\n" +
                "Admin  " + getVersion()  + "\n" +
                "Copyright (c) 1999 Fredy Fischer" +"\n" +
                "                   sql@hulmen.ch" +"\n" +
                "" +"\n" +
                "		       Fredy Fischer" +"\n" +
                "		       Hulmenweg 36" +"\n" +
                "		       8405 Winterthur" +"\n" +
                "		       Switzerland" +"\n" +
                "" +"\n\n" +
                "Icons used are under the followings:\n" +
                "Icons Copyright(C) 1998 by Dean S.  Jones dean@gallant.com\n" +
                "www.gallant.com/icons.htm\n\n" +
                "CalendarBean Copyright (c) by Kai T?dter\n" +
                "MSeries Copyright (c) by Martin Newstead\n\n" +
                "This library is free software; you can redistribute it and/or\n" +
                "modify it under the terms of the GNU Lesser General Public\n" +
                "License as published by the Free Software Foundation; either\n" +
                "version 2.1 of the License, or (at your option) any later version.\n" +
                "\n" +
                "This library is distributed in the hope that it will be useful,\n" +
                "but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU\n" +
                "Lesser General Public License for more details.\n" +
                "\n" +
                "You should have received a copy of the GNU Lesser General Public\n" +
                "License along with this library; if not, write to the Free Software\n" +
                "Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA\n";
        
    }
    
    
    private void about() {
        
        Container contentPane;
        
        aboutFrame = new JInternalFrame("About",true,true,true,true);
        contentPane = aboutFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        //aboutFrame.setBounds(200,200, 450, 250);
        
        
        JTextArea a = new JTextArea(24,80);
        a.setEditable(false);
        a.setFont(new Font("Monospaced", Font.PLAIN, 10));
        
        a.setText(getInfo());
        a.setCaretPosition(1);
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(a);
        
        contentPane.add("Center",scrollpane);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        
        
        JButton gpl = new JButton("LGPL");
        gpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayGpl();
            }}
        );
        
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutFrame.dispose();
            }}
        );
        
        
        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                payFor();
            }}
        );
        
        
        panel1.add(gpl);
        panel1.add(close);
        panel1.add(pay);
        contentPane.add("South",panel1);
        aboutFrame.pack();
        lc.add(aboutFrame,4);
        aboutFrame.setVisible(true);
        
        
    }
    
    
    
    private JPanel statusPanel() {
        JPanel panel = new JPanel();
        statusLine = new JLabel();
        statusLine.setText("Fredy's SQL-Admin-Tool" + getVersion() + " Running now on " + System.getProperty("os.name"));
        statusLine.setFont(new Font("Monospaced", Font.PLAIN, 10));
        statusLine.setBackground(Color.yellow);
        statusLine.setForeground(Color.blue);
        panel.setBackground(Color.yellow);
        panel.setForeground(Color.blue);
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        
        panel.add(statusLine);
        return panel;
        
    }
    
    
    /*
     * private ImageIcon loadImage(String image) {
     *
     *    return loadImage.getImage(image);
     *  }
     */
    
    
    private void payFor() {
        Container contentPane;
        
        payFrame = new JInternalFrame("Pay?",true,true,true,true);
        payFrame.setBackground(Color.blue);
        contentPane = payFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setLayout(new BorderLayout());
        JLabel l = new JLabel(loadImage.getImage("virago.gif"));
        panel.add("North",l);
        
        java.awt.Font f = new  java.awt.Font("Helvetica", Font.BOLD, 24);
        JLabel np = new JLabel("Admin is FREE!!",SwingConstants.CENTER);
        np.setFont(f);
        np.setForeground(Color.yellow);
        panel.add("Center",np);
        
        
        JTextArea a = new JTextArea("",10,35);
        a.setEditable(false);
        a.setText("In fact this product is under GNU Lesser Public License\n"+
                "what means it is free.\n"+
                "But, if you want to pay something for it, because you\n"+
                "think I did a good job and this must be paid....\n"+
                "then I'm happy to get a little amount so I can still\n"+
                "hope to be once in the future the proud owner of a\n"+
                "Yamaha Virago XV750, I'm really dreaming of....");
        
        panel.add("South",a);
        
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(panel);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                payFrame.dispose();
            }}
        );
        
        panel1.add(close);
        contentPane.add("South",panel1);
        
        contentPane.add("Center",scrollpane);
        payFrame.pack();
        lc.add(payFrame,4);
        payFrame.moveToFront();
        payFrame.setVisible(true);
    }
    
    private void displayGpl() {
        Container contentPane;
        
        gplFrame = new JInternalFrame("LGPL",true,true,true,true);
        contentPane = gplFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JTextArea a = new JTextArea(24,80);
        a.setEditable(false);
        a.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        a.setText(getGpl());
        a.setCaretPosition(1);
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(a);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gplFrame.dispose();
            }}
        );
        
        panel1.add(close);
        contentPane.add("South",panel1);
        
        contentPane.add("Center",scrollpane);
        gplFrame.pack();
        lc.add(gplFrame,4);
        gplFrame.moveToFront();
        gplFrame.setVisible(true);
    }
    
    
    private String getGpl() {
        try {
            java.net.URL url = new java.net.URL(Admin.class.getResource(".." + File.separator +  ".." + File.separator +".." + File.separator +  "COPYRIGHT").toString());
            gpl.fredy.io.ReadFile rf = new gpl.fredy.io.ReadFile(url.getFile());
            return "\n" + rf.getText();
        }  catch ( java.net.MalformedURLException mfe) {
            return "see http://www.gnu.org";
        }
        
        
    }
    
    protected void finalize() {
        logOn.closeConnections();
    }
    
    private void dataExport() {
        DataExportGui deg = new DataExportGui(logOn.getCon().con,false);
        deg.setLocationRelativeTo(this);
    }

    private String localAdminDir = "";
    
}



class mScrollPane extends JScrollPane {
    
    public mScrollPane() {
        super();
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setLayout(new BorderLayout());
        getViewport().add(p);
    }
    
    public Dimension getMinimumSize() {
        return new Dimension(25, 25);
    }
    
    public boolean isOpaque() {
        return true;
    }
}
