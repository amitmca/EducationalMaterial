package gpl.fredy.ui;

/** 

    DBTreeView is a part of Admin, it displays a DB in atree
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


**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gpl.fredy.metadata.DBTree;
import gpl.fredy.share.t_connect;

public class DBTreeView extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002 ";

public String getVersion() {return fredysVersion; }

    public JButton cancel;

    public DBTreeView(String host, String user, String password, String database) {
	DBTree dbTree = new DBTree(host, user, password,database);	
        init(dbTree);
    }

    public DBTreeView(t_connect con) {
	DBTree dbTree = new DBTree(con);	
        init(dbTree);
    }

    public void init(DBTree dbTree) {

	this.setLayout(new BorderLayout());
	

	this.add("Center",dbTree);
	this.add("South",buttonPanel());


    }

    private JPanel buttonPanel() {

	JPanel panel = new JPanel();
	cancel = new JButton("Cancel");
	panel.add(cancel);
	return panel;

    }

}
