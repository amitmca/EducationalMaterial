package applications.basics;

/** 



    ColumnPanel is an class representing a standard Column-GUI
    consisting of:
    - JLabel
    - JTextField
    - JTextFieldFilter
    - GridBagConstraints
    - Border
    - Foreground- and BackGroundColor
    - HTML-Fragment 
   


    Admin is a Tool around SQL-Databases to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin Version see below
    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


**/


import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class ColumnPanel {


  String name="";
  public void setName(String v) { name = v; }
  public String getName() { return name; }


  JTextField textField;
  public JTextField getTextField() { return textField; }
  public void setTextField(int l,String t) { textField = new JTextField(t,l); }
  public String toString() { return textField.getText(); }
  
  GridBagConstraints gbcLabel;
  public GridBagConstraints getGbcLabel() { return gbcLabel; }
  public void setGbcLabel(GridBagConstraints v) { gbcLabel = v; }

  GridBagConstraints gbcText;
  public GridBagConstraints getGbcText() { return gbcText; }
  public void setGbcText(GridBagConstraints v) { gbcText = v; }


  public void setStandardConstraints() {
	Insets insets = new Insets(2,2,2,2);
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.EAST;
        gbc.fill  = GridBagConstraints.HORIZONTAL;
	gbc.weightx = 1.0;
	gbc.weighty = 1.0;
	gbc.gridwidth = 1;
	gbc.insets = insets;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbcLabel = gbc;

	gbc.anchor = GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;
	gbc.gridx  = 1;
	gbcText    = gbc;


  }

  public JPanel getPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    panel.add(new JLabel(getName()),gbcLabel);
    panel.add(textField,gbcText);
    
    return panel;
    
  }

  public void init() {

    gbcLabel = new GridBagConstraints();
    gbcText  = new GridBagConstraints();
    
  }

  public ColumnPanel(String name,String content, int length) {
    setName(name);
    setTextField(length,content);
    init();
  }
  public ColumnPanel(String name,int length) {
    setName(name);
    setTextField(length,"");
    init();
  }
  public ColumnPanel(String name) {
    setName(name);
    setTextField(15,"");
    init();
  }

  public ColumnPanel() {
    setName("FieldName");
    setTextField(15,"");
    init();
  }

  public static void main(String args[] ) {

    ColumnPanel cp = new ColumnPanel(args[0]);
    CloseableFrame cf = new CloseableFrame("ColumnPanel");
    cf.getContentPane().add(cp.getPanel());
    cf.pack();
    cf.setVisible(true);
  }
}




