package gpl.fredy.generate;

/**
   This little panel is to enter the user parameters to connect to the DB
**/



/**  * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
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


**/


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.File;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.tree.*;
import java.awt.datatransfer.*;
import java.lang.reflect.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;


import gpl.fredy.metadata.*;
import gpl.fredy.share.*;
import gpl.fredy.io.*;
import gpl.fredy.ui.*;


public class ConnectionPanel extends JPanel {

    private JTextField host,user;
    private JPasswordField password;

    public String getUser()     { return user.getText(); }
    public String getHost()     { return host.getText(); }
    public String getPassword() { return String.valueOf(password.getPassword()); }
    public void setHost(String v) { host.setText(v); }
    public void setUser(String v) { user.setText(v); }
    public void setPassword(String v) { password.setText(v); }

    public ConnectionPanel() {
	this.setLayout(new GridBagLayout());
	this.setBorder(new TitledBorder(new EtchedBorder(),"Connection Values"));

	GridBagConstraints gbc;
	Insets insets = new Insets(2,2,2,2);
	gbc = new GridBagConstraints();
	gbc.weightx = 1.0;     
	gbc.anchor= GridBagConstraints.NORTHWEST;
	gbc.fill  = GridBagConstraints.HORIZONTAL;
	gbc.insets = insets;

	gbc.gridx = 0;
	gbc.gridy = 0;        
	this.add(new JLabel("Host"),gbc);

	gbc.gridx = 1;
	gbc.gridy = 0; 
	host = new JTextField("",15);
	this.add(host,gbc);

	gbc.gridx = 0;
	gbc.gridy = 1;        
	this.add(new JLabel("User"),gbc);

	gbc.gridx = 1;
	gbc.gridy = 1; 
	user = new JTextField("",15);
	this.add(user,gbc);

       	gbc.gridx = 0;
	gbc.gridy = 2;        
	this.add(new JLabel("Password"),gbc);

	gbc.gridx = 1;
	gbc.gridy = 2; 
	password = new JPasswordField("",15);
	this.add(password,gbc);

    }
}
