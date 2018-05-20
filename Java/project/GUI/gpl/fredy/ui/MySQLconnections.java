package gpl.fredy.ui;

/*
 * this is a Dashboard to see what MySQL is doing.
 * I did this to enhance the connectionhandling of my Admin-Framework.
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
 */

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

import gpl.fredy.share.t_connect;

public class MySQLconnections extends JFrame {
    
    private JButton start;
    private JDialog jd;
    private t_connect con;
    private Gauge connections,tables,files,threadsCreated;
    
    int pollRate = 1000;
    
    int maxOpenTables = 200;
    int maxOpenFiles  = 250;
    int maxConnections= 100;
    int maxThreads    = 200;
    
    public int getMaxOpenTables() {
        return maxOpenTables;
    }
    public int getMaxOpenFiles() {
        return maxOpenFiles;
    }
    public int getMaxThreads() { return maxThreads; }
    public void setMaxThreads(int v) {
        maxThreads = v;
        threadsCreated.setMaximum(v);
    }
    
    public void setMaxOpenTables(int v) {
        maxOpenTables = v;
        tables.setMaximum(v);
    }
    
    public void setMaxOpenFiles(int v) {
        maxOpenFiles = v;
        files.setMaximum(v);
    }
    
    public void setMaxConnections(int v) {
        maxConnections = v;
        connections.setMaximum(v);
    }
    
    JTextField pr, mot,mof, mxco, mxThreads;
    
    private boolean local = true;
    
    public MySQLconnections( String host,
    String user,
    String password,
    String database) {
        
        
        super("MySQL Meter for Host: " + host);
        con= new t_connect(host,user,password,database);
        
        init();
    }
    
    public MySQLconnections(gpl.fredy.share.t_connect con) {
        super("MySQL Meter for Host: " + con.getHost());
        this.con = con;
        
        init();
    }
    
    private void init() {
        connections = new Gauge();
        connections.setLegend("Connections");
        connections.setUnits("0");
        connections.setMinimum(0);
        connections.setMaximum(getMaxConnections());
        
        threadsCreated = new Gauge();
        threadsCreated.setLegend("Created Threads");
        threadsCreated.setUnits("0");
        threadsCreated.setMinimum(0);
        threadsCreated.setMaximum(getMaxThreads());
        
        tables = new Gauge();
        tables.setLegend("Tables");
        tables.setUnits("0");
        tables.setMinimum(0);
        tables.setMaximum(getMaxOpenTables());
        
        files = new Gauge();
        files.setLegend("Files");
        files.setUnits("0");
        files.setMinimum(0);
        files.setMaximum(getMaxOpenFiles());
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(BorderLayout.CENTER,gaugePanel());
        this.getContentPane().add(BorderLayout.SOUTH,buttonPanel());
        
        
        properties();
        this.pack();
        this.setVisible(true);
        
        
    }
    
    private JPanel gaugePanel() {
        JPanel panel = new JPanel();
        /**
         * panel.setLayout(new GridBagLayout());
         *
         * GridBagConstraints gbc;
         * Insets insets = new Insets(1,1,1,1);
         * gbc = new GridBagConstraints();
         * //gbc.weightx = 1.0;
         * gbc.anchor= GridBagConstraints.CENTER;
         * gbc.fill  = GridBagConstraints.BOTH;
         * gbc.insets = insets;
         *
         * gbc.gridy = 0;
         * gbc.gridx = 0;
         * panel.add(connections,gbc);
         * gbc.gridx = 1;
         * panel.add(threadsCreated,gbc);
         * gbc.gridx = 2;
         * panel.add(tables,gbc);
         * gbc.gridx = 3;
         * panel.add(files,gbc);
         **/
        panel.setLayout(new FlowLayout());
        panel.add(connections);
        panel.add(threadsCreated);
        panel.add(tables);
        panel.add(files);;
        
        return panel;
    }
    private JPanel buttonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        start = new JButton("Start");
        JButton close = new JButton("Close");
        JButton props = new JButton("Properties");
        
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                poller();
            }});
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    close();
                }});
                
                props.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jd.pack();
                        jd.setVisible(true);
                    }});
                    
                    
                    panel.setBorder(new EtchedBorder());
                    panel.add(start);
                    panel.add(close);
                    panel.add(props);
                    
                    
                    return panel;
    }
    
    public void poller() {
        start.setEnabled(false);
        Thread t = new Thread() {
            public void run() {
                
                while (true) {
                    setValue();
                    try {
                        sleep(pollRate);
                    } catch (Exception e) {;}
                }
            }
        };
        t.start();
    }
    
    private void setValue() {
        
        try {
            ResultSet rs = con.stmt.executeQuery("show status");
            
            String s = "";
            int    v = 0;
            while ( rs.next() ) {
                s = rs.getString(1);
                v = getIntV(rs.getString(2));
                
                if (s.startsWith("Open_tables")    ) {
                    tables.setCurrent(v);
                    tables.setUnits(Integer.toString(v));
                }
                if (s.startsWith("Open_files")     ) {
                    files.setCurrent(v);
                    files.setUnits(Integer.toString(v));
                }
                if (s.startsWith("Threads_connected")) {
                    connections.setCurrent(v+1);
                    connections.setUnits(Integer.toString(v+1));
                }
                if (s.startsWith("Threads_created")) {
                    threadsCreated.setCurrent(v+1);
                    threadsCreated.setUnits(Integer.toString(v+1));
                }
            }
        } catch  (Exception e) {
            e.printStackTrace();
            System.out.println("Exception (setValue): " + e.getMessage().toString());
        }
    }
    
    
    private int getMaxConnections() {
        int mxc = 100;
        
        try {
            ResultSet rs = con.stmt.executeQuery("show status");
            
            String s = "";
            int    v = 0;
            while ( rs.next() ) {
                s = rs.getString(1);
                v = Integer.parseInt(rs.getString(2));
                
                if (s.startsWith("Max_used_connections")    ) {
                    mxc = v;
                }
            }
        } catch  (Exception e) {
            System.out.println("Exception (getMaxConnections): " + e.getMessage().toString());
        }
        if ( mxc < maxConnections ) mxc = maxConnections;
        return mxc;
    }
    
    private void properties() {
        jd = new JDialog(this,"Properties");
        jd.getContentPane().setLayout(new GridBagLayout());
        
        pr        = new JTextField(Integer.toString(pollRate));
        mot       = new JTextField(Integer.toString(getMaxOpenTables()));
        mof       = new JTextField(Integer.toString(getMaxOpenFiles()));
        mxco      = new JTextField(Integer.toString(maxConnections));
        mxThreads = new JTextField(Integer.toString(getMaxThreads()));
        
        GridBagConstraints gbc;
        Insets insets = new Insets(1,1,1,1);
        gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;
        gbc.insets = insets;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        jd.getContentPane().add(new JLabel("Pollrate in Milliseconds:"),gbc);
        gbc.gridy = 1;
        jd.getContentPane().add(new JLabel("Maximum open Tables:"),gbc);
        gbc.gridy = 2;
        jd.getContentPane().add(new JLabel("Maximum open Files:"),gbc);
        gbc.gridy = 3;
        jd.getContentPane().add(new JLabel("Maximum open connections:"),gbc);
        gbc.gridy = 4;
        jd.getContentPane().add(new JLabel("Maximum threads created:"),gbc);
        
        gbc.gridy = 0;
        gbc.gridx = 1;
        jd.getContentPane().add(pr,gbc);
        gbc.gridy = 1;
        jd.getContentPane().add(mot,gbc);
        gbc.gridy = 2;
        jd.getContentPane().add(mof,gbc);
        gbc.gridy = 3;
        jd.getContentPane().add(mxco,gbc);
        gbc.gridy = 4;
        jd.getContentPane().add(mxThreads,gbc);
        
        pr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pollRate = getIntV(pr.getText());
                
            }});
            mof.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setMaxOpenFiles( getIntV(mof.getText()) );
                }});
                
                mot.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setMaxOpenTables(getIntV(mot.getText()));
                    }});
                    
                    mxco.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setMaxConnections(getIntV(mxco.getText()));
                        }
                    });
                    mxThreads.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setMaxThreads(getIntV(mxThreads.getText()));
                        }
                    });
                    
                    
                    JButton close = new JButton("Close");
                    gbc.gridwidth= 2;
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    gbc.anchor= GridBagConstraints.CENTER;
                    gbc.fill = GridBagConstraints.NONE;
                    jd.getContentPane().add(close,gbc);
                    close.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            pollRate = getIntV(pr.getText());
                            setMaxOpenFiles(getIntV(mof.getText()));
                            setMaxOpenTables(getIntV(mot.getText()));
                            maxConnections = getIntV(mxco.getText());
                            jd.setVisible(false);
                        }});
    }
    
    private int getIntV(String s) {
        int i = 0;
        try {
            i = Integer.parseInt(s.trim());
        } catch (Exception e) { }
        return i;
    }
    
    
    public static void main(String args[]) {
        MySQLconnections m = new MySQLconnections(args[0],args[1],args[2],args[3]);
    }
    
    public void setLocal(boolean v) {
        local = v;
    }
    
    public boolean isLocal() {
        return local;
    }
    public void close() {
        if ( isLocal()) {
            System.exit(0);
        } else {
            this.dispose();
        }
    }
    
}

