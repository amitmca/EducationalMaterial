/*
 * CreateDemoEnv.java
 *
 * Created on September 27, 2007, 12:54 PM
 *
 * CreateDemoEnv is to:
 *
 *  explain here, what this class does...
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

package gpl.fredy.datadrill;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.util.logging.*;
import java.sql.Connection;

import gpl.fredy.ui.JTextFieldFilter;
import gpl.fredy.ui.CloseableFrame;
import gpl.fredy.ui.ImageButton;
import gpl.fredy.io.ReadFileNet;
import gpl.fredy.sqltools.FileExec;

/**
 *
 * @author afs
 */
public class CreateDemoEnv extends JPanel {
    
    Logger logger = Logger.getLogger("gpl.fredy.datadrill");
    
    /** Creates a new instance of CreateDemoEnv */
    public CreateDemoEnv(String startDir) {
        setStartDir(startDir);
        rfn = new ReadFileNet();
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,definitionsPanel());
        
        createEnv = new ImageButton(null,"newfolder.gif","download demo files from internet to local folder: " + getFileLocation() + File.separator + "datadrill" + File.separator + "resources" + File.separator);
        
        this.add(BorderLayout.SOUTH,buttonPanel());
    }
    
    private JScrollPane definitionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EtchedBorder());
        
        GridBagConstraints gbc;
        Insets insets = new Insets(1,1,1,1);
        
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Use a proxy"),gbc);
        
        
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        useProxy = new JCheckBox();
        useProxy.setSelected(false);
        useProxy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proxyPort.setEditable(useProxy.isSelected());
                proxyHost.setEditable(useProxy.isSelected());
            }
        });
        panel.add(useProxy,gbc);
        
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Proxyhost"),gbc);
        
        proxyHost = new JTextField("", 30);
        proxyHost.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(proxyHost, gbc);
        
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Proxyport"),gbc);
        
        proxyPort = new JTextField("", 5);
        proxyPort.setDocument(new JTextFieldFilter(JTextFieldFilter.NUMERIC));
        proxyPort.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(proxyPort, gbc);
        
        
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Location of the demo environment"),gbc);
        
        
        fileLocation = new JTextField(getStartDir(), 30);
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(fileLocation, gbc);
        fileLocation.setToolTipText("here I create the structure");
        fileLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEnv.setToolTipText("download demo files from internet to local folder: " + getFileLocation() + File.separator + "datadrill" + File.separator + "resources" + File.separator);
            }
        });
        
        gbc.gridx = 2;
        gbc.fill  = GridBagConstraints.NONE;
        JButton selectFile = new JButton("...");
        selectFile.setToolTipText("select the directory, where I'm creating the demo structure: ." + File.separator + "datadrill" + File.separator + "resources" + File.separator);
        selectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectDirectory();
            }
        });
        
        panel.add(selectFile,gbc);
        
        
        return new JScrollPane(panel);
    }
    
    private JPanel buttonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EtchedBorder());
        createDB  = new ImageButton(null,"savedb.gif","create the demo DB-Table inside actual DB (probably you first want to create a demo-DB)");
        exitButton  = new ImageButton(null,"exit.gif","close this window and update SQLAdmin property for selectiontool ");
        //useInternal = new ImageButton(null,"opendoc.gif","use the files inside the jarfile (I still have problems with Windows-fileformat because of CR and LF)");
        undo = new ImageButton(null,"undo.gif","close without doing anything");
        
        //panel.add(useInternal);
        panel.add(createEnv);
        panel.add(createDB);
        panel.add(new JSeparator());
        panel.add(exitButton);
        panel.add(undo);
        
        createEnv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getFilesFromNet();
            }
        });
        
        createDB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (getCon() != null) {
                    FileExec fe = new FileExec(getFileLocation() + File.separator + "car.sql",getCon());
                    fe.doIt();
                    fe.close();                    
                }
                        
            }
        });
        
        /*
        useInternal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        */
        
        return panel;
    }
    
    
    private void selectDirectory() {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Select Directory");
        
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
            setStartDir(chooser.getCurrentDirectory() + java.io.File.separator + chooser.getSelectedFile().getName());
        setLocation(getStartDir());
        createEnv.setToolTipText("download demo files from internet to local folder: "  + getFileLocation() + File.separator + "datadrill" + File.separator + "resources" + File.separator);
    }
    
    
    private void getFilesFromNet() {
        if (useProxy.isSelected()) {
            rfn.setProxyHost(getProxyHost());
            rfn.setProxyPort(getProxyPort());
        }
        
        try {
            File drillFile = new File(getFileLocation() );// + File.separator + "datadrill" + File.separator + "resources" );
            drillFile.mkdirs();
        } catch (Exception createException ) {
            logger.log(Level.WARNING,"error while creating directories and example environment for dataDrill " + createException.getMessage());
        }
        
        getFile("car-list.display");
        getFile("car-list.sel");
        getFile("car-list.other");
        getFile("employee-list.display");
        getFile("employee-list.function");
        getFile("employee-list.sel");
        getFile("selections.txt");
        getFile("car.sql");
    }
    
    private String getFile(String file) {
        String baseURL = "http://www.hulmen.ch/admin/dataselection/resources/";
        
        
        
        rfn.setSrc(baseURL + file);
        //rfn.setDst(getFileLocation() + File.separator + "datadrill" + File.separator + "resources" + File.separator + file);
        rfn.setDst(getFileLocation() + File.separator + file);
        return rfn.getFileFromNet();
    }
    
    public static void main(String args[]){
        String startDir = System.getProperty("user.home");
        
        if ( args.length > 0) startDir = args[0];
        
        CloseableFrame cf = new CloseableFrame("Create demo environment");
        cf.getContentPane().setLayout(new BorderLayout());
        CreateDemoEnv cd = new CreateDemoEnv(startDir);
        cf.getContentPane().add(BorderLayout.CENTER,cd);
        
        cd.exitButton.setEnabled(false);
        cd.undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cf.pack();
        cf.setVisible(true);
    }
    
    private JTextField proxyHost;
    
    private JTextField proxyPort;
    
    private JTextField fileLocation;
    
    private JCheckBox useProxy;
    
    private String startDir;
    
    public String getProxyHost() {
        return proxyHost.getText();
    }
    
    public void setProxyHost(String proxyHost) {
        this.proxyHost.setText( proxyHost );
    }
    
    public int getProxyPort() {
        return Integer.parseInt(proxyPort.getText());
    }
    
    public void setProxyPort(int proxyPort) {
        this.proxyPort.setText( Integer.toString( proxyPort) );
    }
    
    public String getFileLocation() {
        return fileLocation.getText();
    }
    
    public void setLocation(String fileLocation) {
        this.fileLocation.setText(fileLocation);
    }
    
    public String getStartDir() {
        return startDir;
    }
    
    public void setStartDir(String startDir) {
        this.startDir = startDir;
    }
    
    public ImageButton exitButton;
    
    public ImageButton createEnv;
    
    private ReadFileNet rfn;
    
    public ImageButton createDB;
    
    public ImageButton useInternal;

    private java.sql.Connection con = null;

    public java.sql.Connection getCon() {
        return con;
    }

    public void setCon(java.sql.Connection con) {
        this.con = con;
    }

    public ImageButton undo;
}
