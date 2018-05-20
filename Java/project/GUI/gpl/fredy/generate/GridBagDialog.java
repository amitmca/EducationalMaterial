package gpl.fredy.generate;

/** 
 *  GridBagDialog is to modify the GridBagConstraints within the
 *  CodeGenerater and is a part of Admin...
 *  Version 1.2 16. March 2002
 *  Fredy Fischer 
 *
 *  it only returns a JPanel, so it can easily been 
 *  used in different kind of windows
 *
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
import java.io.*;
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
import java.awt.datatransfer.*;
import java.lang.reflect.*;

import mseries.ui.*;        
import mseries.plaf.basic.*; 

import gpl.fredy.ui.*;


public class GridBagDialog extends JDialog {


    private JTextField insetsField;
    private String[] anchorComponents =  { "CENTER",
					   "NORTH",
					   "NORTHEAST",
					   "NORTHWEST",
					   "SOUTH",  
					   "SOUTHEAST",
					   "SOUTHWEST",
					   "WEST", 
					   "EAST" };

    private JComboBox  anchor = new JComboBox(anchorComponents);

    private String[] fillComponents =  { "BOTH",
					 "NONE",
					 "HORIZONTAL",
					 "VERTICAL" };
					   
    private JComboBox fill  = new JComboBox(fillComponents);					     

    private MSpinner gridheight,gridwidth,gridx,gridy,weightx, weighty;
    public ImageButton ok, cancel;


    private String dblConv(double d) {
	return Double.toString(d);
    }

    private String intConv(int i) {
	return Integer.toString(i);
    }

    public void setGBC(GridBagConstraints gbc) {
	insetsField.setText(gbc.insets.toString() );

	/**
	weightx.setText(    dblConv(gbc.weightx) );
	weighty.setText(    dblConv(gbc.weighty) );
	gridheight.setText( dblConv(gbc.gridheight));
	gridwidth.setText(  dblConv(gbc.gridwidth));
	gridx.setText(      intConv(gbc.gridx) );
	gridy.setText(      intConv(gbc.gridy) );
	**/

	if ( gbc.anchor == GridBagConstraints.CENTER ) anchor.setSelectedIndex(0);
	if ( gbc.anchor == GridBagConstraints.NORTH ) anchor.setSelectedIndex(1);
	if ( gbc.anchor == GridBagConstraints.NORTHEAST ) anchor.setSelectedIndex(2);
	if ( gbc.anchor == GridBagConstraints.NORTHWEST ) anchor.setSelectedIndex(3);
	if ( gbc.anchor == GridBagConstraints.SOUTH ) anchor.setSelectedIndex(4);
	if ( gbc.anchor == GridBagConstraints.SOUTHEAST ) anchor.setSelectedIndex(5);
	if ( gbc.anchor == GridBagConstraints.SOUTHWEST ) anchor.setSelectedIndex(6);
	if ( gbc.anchor == GridBagConstraints.WEST ) anchor.setSelectedIndex(7);
	if ( gbc.anchor == GridBagConstraints.EAST ) anchor.setSelectedIndex(8);

	if ( gbc.fill == GridBagConstraints.BOTH )       fill.setSelectedIndex(0);
	if ( gbc.fill == GridBagConstraints.NONE )       fill.setSelectedIndex(1);
	if ( gbc.fill == GridBagConstraints.HORIZONTAL ) fill.setSelectedIndex(2);
	if ( gbc.fill == GridBagConstraints.VERTICAL )   fill.setSelectedIndex(3);

    }

    public GridBagConstraints getGBC() {

	GridBagConstraints gbc = new GridBagConstraints() ;


	return gbc;
    }

    private JPanel gridpanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout() );
	panel.setBorder(new EtchedBorder()  ) ;

	GridBagConstraints gbc;

        Insets insets = new Insets(1,1,1,1);
        gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;
        gbc.insets = insets;
        gbc.gridx = 0;
        gbc.gridy = 0;

	panel.add(new JLabel("Position X"),gbc);

	gbc.gridy = 1;
	panel.add(new JLabel("Position Y"),gbc);

	gbc.gridy = 2;
	panel.add(new JLabel("Insets"),gbc);

	gbc.gridy = 3;
	panel.add(new JLabel("Horizontal weight"),gbc);

	gbc.gridy = 4;
	panel.add(new JLabel("Vertical weight"),gbc);

	gbc.gridy = 5;
	panel.add(new JLabel("Gridheight"),gbc);

	gbc.gridy = 6;
	panel.add(new JLabel("Gridwidth"),gbc);

	gbc.gridy = 7;
	panel.add(new JLabel("Anchor"),gbc);

	gbc.gridy = 8;
	panel.add(new JLabel("Fill"),gbc);


        gridx   = new MSpinner();
	gridx.setModel(new MIntegerSpinnerModel(0, 500, 0, 1, true));
	gridx.setEditor(new IntegerEditor());

        gridy   = new MSpinner();
	gridy.setModel(new MIntegerSpinnerModel(0, 500, 0, 1, true));
	gridy.setEditor(new IntegerEditor());

        gridwidth   = new MSpinner();
	gridwidth.setModel(new MIntegerSpinnerModel(1, 50, 1, 1, true));
	gridwidth.setEditor(new IntegerEditor());

        gridheight   = new MSpinner();
	gridheight.setModel(new MIntegerSpinnerModel(1, 50, 1, 1, true));
	gridheight.setEditor(new IntegerEditor());

	weightx = new MSpinner();
	weightx.setModel(new DoubleSpinnerModel(1.0, 50.0, 1.0, 0.1, true));
	weightx.setEditor(new DoubleEditor());

	weighty = new MSpinner();
	weighty.setModel(new DoubleSpinnerModel(1.0, 50.0, 1.0, 0.1, true));
	weighty.setEditor(new DoubleEditor());



        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.VERTICAL;
        gbc.insets = insets;
        gbc.gridx = 1;
        gbc.gridy = 0;

	panel.add(gridx,gbc);

        gbc.gridy = 1;
	panel.add(gridy,gbc);

        gbc.gridy = 2;

	insetsField = new JTextField("",8);
	insetsField.setDocument (new JTextFieldFilter("0123456789,"));
	insetsField.setToolTipText("e.g. 2,2,2,2");
	panel.add(insetsField,gbc);

        gbc.gridy = 3;
	panel.add(weightx,gbc);

        gbc.gridy = 4;
	panel.add(weighty,gbc);

        gbc.gridy = 5;

	gridheight.setToolTipText("this components consumes \"n\" gridheights");
	panel.add(gridheight,gbc);

        gbc.gridy = 6;

	gridwidth.setToolTipText("this components consumes \"n\" gridwidth");
	panel.add(gridwidth,gbc);

        gbc.gridy = 7;
	anchor.setToolTipText("alignement");
	panel.add(anchor,gbc);

        gbc.gridy = 8;
	fill.setToolTipText("growth");
	panel.add(fill,gbc);

	return panel;
    }
 
    
    private JPanel buttonPanel() {
        JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	ok = new ImageButton(null,"ok.gif",null);
	cancel = new ImageButton(null,"cancel.gif",null);
	panel.add(ok);
	panel.add(cancel);
	panel.setBorder(new EtchedBorder());
	return panel;
    }

    public GridBagDialog() {
	init();
    }


    public GridBagDialog(Frame frame,boolean modal) {
	super(frame,modal);
	init();


    }
    private void init() {
	this.setTitle("GridBagConstraints");
	this.getContentPane().setLayout(new BorderLayout());
	this.getContentPane().add(BorderLayout.CENTER,gridpanel());
	this.getContentPane().add(BorderLayout.SOUTH,buttonPanel());
	this.pack();
    }

    public static void main(String args[]) {

	CloseableFrame cf = new CloseableFrame("TEST");
	GridBagDialog gbd = new GridBagDialog(cf,true);
	gbd.cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		    }});
	gbd.setVisible(true);
    }
}	    
    




