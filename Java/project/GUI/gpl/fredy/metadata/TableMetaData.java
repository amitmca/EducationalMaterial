package gpl.fredy.metadata;

/**
 *
 * TableMetaData is a part of Admin
 *
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
 *
 **/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;

import gpl.fredy.share.t_connect;


public class TableMetaData extends JPanel {
    
    // Fredy's make Version
    private static String fredysVersion = "Version 1.4   2. Jan.2002";
    
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
        setHost(con.getHost());
        setUser(con.getUser());
        setPassword(con.getPassword());
        setDatabase(con.getDatabase());
    }
    
    
    
    
    
    private JTable info;
    public JButton cancel;
    private TableInfo ti;
    
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
    
    
    String table;
    
    /**
     * Get the value of table.
     * @return Value of table.
     */
    public String getTable() {
        //return spaceFixer(table);
        return table;
    }
    
    private String spaceFixer(String s) {
        s = s.trim();
        if (s.indexOf(' ') > 0 ) s = "'" + s + "'";
        return s;
    }
    
    
    /**
     * Set the value of table.
     * @param v  Value to assign to table.
     */
    public void setTable(String  v) {this.table = v;}
    
    private Vector name, type,size, isNull, remarks, defaults;
    private DatabaseMetaData dmd;
    
    public TableMetaData(String host,
    String user,
    String password,
    String database,
    String table) {
        
        setHost(host);
        setUser(user);
        setPassword(password);
        setDatabase(database);
        setSchema("%");
        setTable(table);
        inits();
        
    }
    
    public TableMetaData() {
        inits();
    }
    public TableMetaData(String host,
    String user,
    String password,
    String database,
    String schema,
    String table) {
        
        setHost(host);
        setUser(user);
        setPassword(password);
        setDatabase(database);
        setSchema(schema);
        setTable(table);
        inits();
        
    }
    
    public TableMetaData(t_connect con, String table) {
        setCon(con);
        setSchema("%");
        setTable(table);
        inits();
    }
    
    public TableMetaData(t_connect con, String schema, String table) {
        setCon(con);
        setSchema(schema);
        setTable(table);
        inits();
    }
    
    
    private void inits() {
        name = new Vector();
        type = new Vector();
        size = new Vector();
        isNull = new Vector();
        remarks = new Vector();
        defaults = new Vector();
        this.setLayout(new BorderLayout());
        this.add("North",descr());
        this.add("Center",listPanel());
        this.add("South",buttonPanel());
    }
    
    
    private void  tableInit() {
        
        ti = new TableInfo();
        info = new JTable(ti);
        
        DbInfo dbi = null;
        if (getCon() == null ) {
            dbi = new DbInfo(getHost(),getUser(),getPassword(),getDatabase());
        } else {
            dbi = new DbInfo(getCon());
        }
        
        Vector columns = new Vector();
        columns = dbi.getColumnNames(getTable());
        Vector pk = new Vector();
        pk = dbi.getPk(getTable());
        
        
        for (int i=0;i < columns.size(); i++) {
            
            SingleColumnInfo sci = new SingleColumnInfo(dbi.getDmd(),
            getDatabase(),
            getSchema(),
            getTable(),
            (String)columns.elementAt(i));
            
            Vector v = new Vector();
            v.addElement((String)sci.getColumn_name());
            v.addElement((String)sci.getType_name());
            v.addElement((Integer)new Integer(sci.getColumn_size()));
            v.addElement((Boolean)new Boolean(sci.isNullable()));
            
            String r = (sci.getRemarks());
            if (r == null) r = " ";
            v.addElement((String)r);
            
            String d = sci.getColumn_def();
            if ( d == null) d= " "; //This is a change for postgres
            
            v.addElement(d);
            
            // is this a primary key?
            if (pk.size() < 1) {
                v.addElement(" ");
            } else {
                for (int j=0; j < pk.size();j++) {
                    try {
                        if (sci.getColumn_name().equals(((PrimaryKey)pk.elementAt(j)).getColumnName()) ) {
                            v.addElement("Primary");
                        }
                        else { v.addElement(" ");
                        }
                    } catch (Exception e) {  v.addElement(" "); }
                }
            }
            
            // exported Foreign Keys
            v.addElement((String)sci.getExportedKeys());
            
            // imported Foreign Keys
            v.addElement((String)sci.getImportedKeys());
            
            ti.addRow(v);
        }
        
    }
    
    
    private JPanel listPanel() {
        
        
        tableInit();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc;
        Insets insets = new Insets(1,1,1,1);
        
        gbc = new GridBagConstraints();
        
        gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.BOTH;
        gbc.insets = insets;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        info.getTableHeader().setReorderingAllowed(false);
        info.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        info.setPreferredScrollableViewportSize(new Dimension(500, 160));
        panel.add(new JScrollPane(info),gbc);
        
        return panel;
    }
    
    private JPanel buttonPanel() {
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        cancel = new JButton("Cancel");
        panel.add(cancel);
        return panel;
    }
    
    
    private JPanel descr() {
        
        JPanel panel = new  JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel      l1 = new JLabel("Host:");
        JTextField  t1 = new JTextField(getHost());
        t1.setEditable(false);
        t1.setBackground(Color.black);
        t1.setForeground(Color.white);
        
        JLabel      l2 = new JLabel("User:");
        JTextField  t2 = new JTextField(getUser());
        t2.setEditable(false);
        t2.setBackground(Color.black);
        t2.setForeground(Color.white);
        
        JLabel      l3 = new JLabel("Database:");
        JTextField  t3 = new JTextField(getDatabase());
        t3.setEditable(false);
        t3.setBackground(Color.black);
        t3.setForeground(Color.white);
        
        
        JLabel      l4 = new JLabel("Table:");
        JTextField  t4 = new JTextField(getTable());
        t4.setEditable(false);
        t4.setBackground(Color.black);
        t4.setForeground(Color.white);
        
        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(t3);
        panel.add(l4);
        panel.add(t4);
        
        
        return panel;
        
    }
    
    
    
    public static void main(String args[]) {
        
        if (args.length != 6) {
            System.out.println("Syntax: java TableMetaData host user password database schema table");
            System.exit(0);
        }
        
        JFrame f = new JFrame("Table Info");
        f.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {}
            public void windowClosed(WindowEvent e) {}
            public void windowClosing(WindowEvent e) {System.exit(0);}
            public void windowDeactivated(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowOpened(WindowEvent e) {}});
            f.getContentPane().setLayout(new BorderLayout());
            TableMetaData tmd = new TableMetaData(args[0],args[1],args[2],args[3],args[4],args[5]);
            f.getContentPane().add("Center",tmd);
            tmd.cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }});
                
                f.pack();
                f.setVisible(true);
    }
}
