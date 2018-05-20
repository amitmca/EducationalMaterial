package gpl.fredy.ui;

/** ChooseColor is a part of Admin, done to change Colors.....


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

public class ChooseColor extends JPanel {

// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002 ";

public String getVersion() {return fredysVersion; }



    public JColorChooser cc;
    public JButton cancel, select;
    private JButton deflt;
    private Color defaultColor;
    public ChooseColor(Color defaultColor) {

	
	this.defaultColor = defaultColor;
	this.setLayout(new BorderLayout());
	cc = new JColorChooser();
	this.add("Center",cc);
	this.add("South",buttonPanel());
    }


    public Color getColor() { return cc.getColor();}


    private JPanel buttonPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

	deflt = new JButton("Default");
	deflt.setToolTipText("default color");
	deflt.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		cc.setColor(defaultColor);
		}});
	

	
	select = new JButton("Select");
	select.setToolTipText("Selects background Color");

	cancel = new JButton("Cancel");
	cancel.setToolTipText("leave as it is...");

	panel.add(deflt);
	panel.add(select);
	panel.add(cancel);
	return panel;

    }


    public static void main(String args[]) {

	JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
	ChooseColor panel = new ChooseColor(Color.blue);
	panel.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		{System.exit(0);}
		}});
	

        frame.getContentPane().add("Center", panel);
	frame.pack();
        frame.setVisible(true);

    }
}
           
