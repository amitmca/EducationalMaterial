package gpl.fredy.share;


/**  
 * Displays a message in a popup dialog. If it appears, something unwanted happened....
 * it is part of my tries  to make the exception handling better...
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

/**
 * MsgDialog.java
 *
 *
 * Created:  Jan  4 7 2003
 *
 * @author Fredy Fischer
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;


import gpl.fredy.ui.*;


public class MsgDialog extends JDialog {

    public JTextArea msgArea;
    public ImageButton close;
    
    public MsgDialog () {

	this.getContentPane().setLayout(new BorderLayout());

	msgArea = new JTextArea(5,20);
	msgArea.setEditable(false);
	msgArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
	msgArea.setLineWrap(true);

	this.getContentPane().add(BorderLayout.CENTER,new JScrollPane(msgArea));
	this.getContentPane().add(BorderLayout.SOUTH,buttonPanel());
	this.pack();
    }

    public void setText(String v) {
	msgArea.setText(v);
	msgArea.updateUI();
    }

    public String getText() { return msgArea.getText(); }

    private JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	close = new ImageButton(null,"exit.gif","Close");
	panel.add(close);
	panel.setBorder(new EtchedBorder());
	return panel;
    }
}
