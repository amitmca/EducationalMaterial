package gpl.fredy.ui;

/** 
    Toolbar is a part of Admin ...

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
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class Toolbar extends JPanel {

LoadImage loadImage = new LoadImage();
    
public JButton dbInfo,generateCode, exit, qbe, form, sqlMonitor;
public JButton dropTable, createTable, createIndex,createUser,createDB,dropDB;
public JButton background,execPrg,windows,motif,metal;
public JButton about;


    public Toolbar() {

	this.setLayout(new FlowLayout());

	JToolBar toolbar = new JToolBar();
	toolbar.setOrientation(JToolBar.VERTICAL);

	dbInfo = new JButton(loadImage.getImage("cameraflash.gif"));
	dbInfo.setToolTipText("Database Info");

	toolbar.add(dbInfo);

	generateCode = new JButton(loadImage.getImage("hammer.gif"));
	generateCode.setToolTipText("Generate Java Code");
	toolbar.add(generateCode);

	qbe  = new JButton(loadImage.getImage("binocular.gif"));
	qbe.setToolTipText("Guided Query");
	toolbar.add(qbe);

	form = new JButton(loadImage.getImage("documentdraw.gif"));
	form.setToolTipText("Form");
	toolbar.add(form);

	sqlMonitor  = new JButton(loadImage.getImage("computer.gif"));
	sqlMonitor.setToolTipText("SQL Monitor");
	toolbar.add(sqlMonitor);

	createTable = new JButton(loadImage.getImage("newsheet.gif"));
	createTable.setToolTipText("Create Table");
	toolbar.add(createTable);

	createIndex = new JButton(loadImage.getImage("updatecolumn.gif"));
	createIndex.setToolTipText("Create Index");
	toolbar.add(createIndex);

	createUser  = new JButton(loadImage.getImage("user.gif"));
	createUser.setToolTipText("Create mysql-User");
	toolbar.add(createUser);

        createDB    = new JButton(loadImage.getImage("data.gif"));
	createDB.setToolTipText("Create mysql-Database (must have access)");
	toolbar.add(createDB);


        dropTable   = new JButton(loadImage.getImage("deletesheet.gif"));
	dropTable.setToolTipText("Drop Table");
	toolbar.add(dropTable);

	dropDB      = new JButton(loadImage.getImage("delete.gif"));
	dropDB.setToolTipText("Drop Database");
	toolbar.add(dropDB);


        background =  new JButton(loadImage.getImage("palette.gif"));
	background.setToolTipText("change Background color");
	toolbar.add(background);

        about       = new JButton(loadImage.getImage("bulb.gif"));
	about.setToolTipText("about Admin");
	toolbar.add(about);

	exit        = new JButton(loadImage.getImage("exit.gif"));
	exit.setToolTipText("Exit Admin");
	toolbar.add(exit);
	this.add(toolbar);
    }


    private ImageIcon loadImage(String image) {
	return loadImage.getImage(image);
   }

    public static void main(String args[]) {
	JFrame frame = new JFrame();
	Toolbar tb = new Toolbar();
	frame.getContentPane().add(tb);
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	
	frame.pack();
	frame.setVisible(true);
    }

}
