package gpl.fredy.tools;

/**
   TextViewer is used within the
   SLS (SimpleLogServer) to zoom a value.
   
   SimpleLogServer is part of Admin and under LGPL

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
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class TextViewer extends JDialog {

    public JButton close;
    private JTextArea text;

    public void setText(String s) {
	text.setText(s);
	text.updateUI();
    }
    
    private JPanel textPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
       
	text = new JTextArea(10,100);
	text.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 12));
	text.setEditable(false);

	panel.add(BorderLayout.CENTER,new JScrollPane(text));
	panel.setBorder(new BevelBorder(BevelBorder.RAISED));

	return panel;
    }

    private JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	panel.setBorder(new EtchedBorder());

	close = new JButton("Close");

	panel.add(close);
	return panel;
    }

    public TextViewer(JFrame f,String title,boolean m) {

        super(f,title,m);
	
	this.getContentPane().setLayout(new BorderLayout());
	this.getContentPane().add(BorderLayout.CENTER,textPanel());
	this.getContentPane().add(BorderLayout.SOUTH,buttonPanel());
	this.pack();
    }
}
	
