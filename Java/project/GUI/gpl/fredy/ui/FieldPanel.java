package gpl.fredy.ui;

/** 



    FieldPanel is an class representing a standard Column-GUI
    consisting of:
    - JLabel
    - JTextField
    - JTextFieldFilter
    - GridBagConstraints
    - Border
    - Foreground- and BackGroundColor
    

    it can be in the Form:
    1) Label: ____________
    2) a field having a titled Border with the Field-name


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

public class FieldPanel extends JPanel {

    
    public JTextField field;
    
    /**
       * Get the value of field.
       * @return value of field.
       */
    public JTextField getField() {return field;}
    
    /**
       * Set the value of field.
       * @param v  Value to assign to field.
       */
    public void setField(JTextField  v) {this.field = v;}
    

    /**
       * set the content of the JTextField
       **/
    public void setText(String v) { field.setText(v); }

    /**
       * get the content of the JTextField
       **/   
    public String getText() { return field.getText(); }
    /**
       * set the filter of the JTextField
       * @param v  Value to assign to field.
       * can be:JTextFieldFilter.NUMERIC
       *        JTextFieldFilter.LOWERCASE
       *        JTextFieldFilter.UPPERCASE
       *        JTextFieldFilter.ALPHA
       *        JTextFieldFilter.FLOAT
       *        JTextFieldFilter.ALPHA_NUMERIC
       *        or whatever you want to allow
       **/       
    public void setFilter(String v) { field.setDocument (new JTextFieldFilter(v));}

    /**
       * setting directly the JTextFilter
       * @param v  JTextFieldFilter to assign
       **/
    public void setFilter(JTextFieldFilter v) { field.setDocument(v); }


    public void setTitledBorder(String v) {   
	this.setBorder(new TitledBorder(v));
    }

    public void setRaisedTitledBorder(String v) {
	this.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),v));
    }
    public void setLoweredTitledBorder(String v) {
	this.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),v));
    }

    
    public void setLayout(int l) {
	switch (l){
	case 0:
	    break;
	case 1:
	    this.setBorder(new BevelBorder(BevelBorder.RAISED));
	    break;
	case 2:
	    this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    break;
	default:
	    break;
	}

    }

    public JLabel label;
    
    /**
       * Get the value of label.
       * @return value of label.
       */
    public String getLabel() {return label.getText();}
    
    /**
       * Set the value of label.
       * @param v  Value to assign to label.
       */
    public void setLabel(String  v) {this.label.setText(v);}


    public void setThisFont(java.awt.Font f) {
	field.setFont(f);
    }
    
    public void setStandardFont() { 
	setThisFont( new java.awt.Font("Monospaced", Font.PLAIN, 12)); 
    }

    public void clear() { field.setText(""); }

    GridBagConstraints gbcLabel;
    public GridBagConstraints getGbcLabel() { return gbcLabel; }
    public void setGbcLabel(GridBagConstraints v) { gbcLabel = v; }

    GridBagConstraints gbcText;
    public GridBagConstraints getGbcText() { return gbcText; }
    public void setGbcText(GridBagConstraints v) { gbcText = v; }


    public void setStandardConstraints() {
	Insets insets = new Insets(2,2,2,2);
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.NORTHWEST;
        gbc.fill  = GridBagConstraints.HORIZONTAL;
	gbc.weightx = 1.0;
	gbc.weighty = 1.0;
	gbc.gridwidth = 1;
	gbc.insets = insets;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbcLabel = gbc;

	gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill   = GridBagConstraints.NONE;
	gbc.weightx = 1.0;
	gbc.weighty = 1.0;
	gbc.gridwidth = 1;
	gbc.insets = insets;
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbcText    = gbc;


  }



    /**
       * @param label    The Label text
       * @param length   The length of the JTextField
       * @param text     The initial text of the JTextField
       * @param filter   a constant from JTextFieldFilter or a string containing accepted values
       * @param titled   true = display a titled border false no border
       * @param title    the title in the border
       * @param layout   0 = standard, 1 = RAISED, 2 = LOWERED)
       **/

    public FieldPanel(String label,int length,String text,String filter, boolean titled, String title,int layout) {
	init(label,length,text,filter,titled,title,layout);
    }

    public FieldPanel(String label,int length) {
	init(label,length,"",JTextFieldFilter.ALPHA_NUMERIC,false,null,0);
    }

    public FieldPanel(String label,int length, String filter) {
	init(label,length,"",filter,false,null,0);
    }
  

    private void init(String label,int length,String text,String filter, boolean titled, String title,int layout) {

	this.label = new JLabel(label);
	this.field = new JTextField(length);

	if ( text   != null ) setText(text);
	if ( filter != null ) setFilter(filter);

	this.setLayout(new GridBagLayout());
	gbcLabel = new GridBagConstraints();
	gbcText  = new GridBagConstraints();	
	setStandardConstraints();

	if (getLabel() != null) this.add(this.label,gbcLabel);
	this.add(getField(),gbcText);

	if (titled) {
	    if ( layout == 1) setRaisedTitledBorder(title);
	    if ( layout == 2) setLoweredTitledBorder(title);
	    if ( layout == 0) setTitledBorder(title);
	} else {
	    setLayout(layout);
	}
    }
}
       
	    
	
    
