package gpl.fredy.sqltools;
/**
 *
 * This software is part of David Good's contribution to the Admin-Framework and under LGPL
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
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.tree.*;
import java.io.*;

import gpl.fredy.share.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;

public class SqlPickList extends JPanel {
    
    t_connect con=null;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
        if ( (con == null) || (getSqlCon() == null)) {
            con = new t_connect(getHost(),
            getUser(),
            getPassword(),
            getDatabase());
            if ( ! con.acceptsConnection() ) con = null;
            setSqlCon(con.con);
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
        setSqlCon(con.con);
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
    
    
    
    private DatabaseMetaData dmd;
    ResultSet rsTables;
    Vector vTables = new Vector(10,10);
    JTree jtTables;
    JButton cbPaste;
    Container jPanel1 = this;
    
    private java.sql.Connection sqlCon = null;
    
    SqlPickList(String host,
    String user,
    String password,
    String db,
    ActionListener paste,
    String schema) {
        
        setHost(host);
        setUser(user);
        setPassword(password);
        setDatabase(db);
        setSchema(schema);
        init(paste);
        getCon();
    }
    
    
    SqlPickList(t_connect con, ActionListener paste) {
        setCon(con);
        setSchema("%");
        init(paste);
    }
    
    
    SqlPickList(t_connect con, ActionListener paste, String schema) {
        setCon(con);
        setSchema(schema);
        init(paste);
    }
    
    SqlPickList(java.sql.Connection con, ActionListener paste, String schema) {
        setSqlCon(con);
        setSchema(schema);
        init(paste);
    }
    
   SqlPickList(java.sql.Connection con, ActionListener paste) {
        setSqlCon(con);
        setSchema("%");
        init(paste);
    } 
    
    public void init(ActionListener paste) {
        try {
            
            //getCon();
            dmd = getSqlCon().getMetaData();
            rsTables = dmd.getTables(null,
            schema,
            null,
            new String[]{"TABLE","VIEW"});
            
            getTableList(rsTables);
            
            jPanel1.setLayout(new BorderLayout());
            
            cbPaste = new JButton("Paste");
            cbPaste.addActionListener(paste);
            cbPaste.setActionCommand("");
            
            jPanel1.add(cbPaste,BorderLayout.SOUTH);
            
            jtTables = new JTree(vTables);
            
            jtTables.addMouseListener( new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    TreePath selPath = jtTables.getPathForLocation(e.getX(), e.getY());
                    if(selPath != null) {
                        
                        cbPaste.setActionCommand(" " + ((PickListItem)((DefaultMutableTreeNode)(selPath.getLastPathComponent())).getUserObject()).getName() + " ");
                        if(e.getClickCount() == 2) {
                            e.consume();
                            cbPaste.doClick();
                            
                        }
                    }
                }
            });
            
            
            JScrollPane scp = new JScrollPane(jtTables);
            scp.setSize(100,80);
            
            jPanel1.add(scp);
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getTableList(ResultSet rs) throws Exception {
        while (rs.next())
            vTables.add(new ColumnList(rs.getString(3)));
    }
    
    
    public class ColumnList extends Vector implements PickListItem {
        private String tableName;
        
        public ColumnList(String TableName) throws Exception {
            super(10,5);
            tableName = TableName;
            ResultSet rs = dmd.getColumns(null,null,tableName,null);
            while (rs.next())
                add(new Column(rs.getString(4)));
        }
        
        public String toString() {
            return tableName;
        }
        
        public String getName() {
            return tableName;
        }
        
        public class Column implements PickListItem {
            private String columnName;
            
            public Column(String columnName) {
                this.columnName = columnName;
            }
            
            public String toString() {
                return columnName;
            }
            
            public String getName() {
                return ColumnList.this.tableName + "." + columnName;
            }
        }
    }
    
    protected void finalize() {
        //con.close();
    }
    
    /**
     * Getter for property sqlCon.
     * @return Value of property sqlCon.
     */
    public java.sql.Connection getSqlCon() {
        return sqlCon;
    }
    
    /**
     * Setter for property sqlCon.
     * @param sqlCon New value of property sqlCon.
     */
    public void setSqlCon(java.sql.Connection sqlCon) {
        this.sqlCon = sqlCon;
    }
    
}

