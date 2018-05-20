package gpl.fredy.ui;

/** 



    DateButtonPanel is an class representing a standard Column-GUI
    areound CalendarField consisting of:
    - JLabel
    - DateField
    - GridBagConstraints
    - Borders
    - Foreground- and BackGroundColor
    

    it can be in the Form:
    1) Label: data
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

public class DateButtonPanel extends JPanel {

    
    public CalendarField field;
    
    /**
       * Get the value of field.
       * @return value of field.
       */
    public CalendarField getField() {return field;}
    
    /**
       * Set the value of field.
       * @param v  Value to assign to field.
       */
    public void setField(CalendarField  v) {this.field = v;}
    

    public void clear() { setText(toDay()); }

    /**
       * set the content of the JTextField
       **/
    public void setText(String v) { field.setDate(v); }
    /**
       * get the content of the JTextField
       **/   
    public String getText() { return field.getDate(); }
    
    public Calendar getCalendar() { return field.getCalendar(); }
    public String getDate()       { return field.getDate(); }

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
        gbc.fill   = GridBagConstraints.BOTH;
	gbc.gridx  = 1;
	gbcText    = gbc;


  }



    /**
       * @param label    The Label text
       * @param text     The initial text of the DateField ( yyyy-mm-dd )
       * @param titled   true = display a titled border false no border
       * @param title    the title in the border
       * @param layout   0 = standard, 1 = RAISED, 2 = LOWERED)
       **/

    public DateButtonPanel(String label,String textDate,
                           boolean titled, String title,int layout) {
	init(label,textDate,titled,title,layout);
    }

    public DateButtonPanel(String label) {
	init(label,toDay(),false,null,0);
    }
     public DateButtonPanel(String label,String textDate) {
	init(label,textDate,false,null,0);
     }
     
    private String toDay() {
	Calendar cal;
	cal = Calendar.getInstance();
	String y = Integer.toString(cal.get(cal.YEAR));
	String m = Integer.toString(cal.get(cal.MONTH)+1);
	m = trailing(m);
	String d = Integer.toString(cal.get(cal.DAY_OF_MONTH));
	d = trailing(d);
	
	return y + "-" + m + "-" + d;

    }
    private String trailing(String v) {
	if (v.length() < 2 ) v = "0"+ v;
	return v;
    }
    private void init(String label,String textDate, boolean titled, String title,int layout) {

	this.label = new JLabel(label);
	String lx = label;
	if (lx == null) lx = "";
	this.field = new CalendarField(lx);

	if ( textDate.length() < 10) textDate = toDay();
	if ( textDate  != null ) setText(textDate);
        this.field.setDate(textDate);

	this.setLayout(new GridBagLayout());
	gbcLabel = new GridBagConstraints();
	gbcText  = new GridBagConstraints();	

	Insets insets = new Insets(2,2,2,2);

	gbcLabel.weightx = 1.0;     
	gbcLabel.insets  = insets;
	gbcLabel.gridy   = 0;
        gbcLabel.gridx   = 0;
        gbcLabel.anchor  = GridBagConstraints.EAST;
        gbcLabel.fill    = GridBagConstraints.HORIZONTAL;    

	gbcText.weightx = 1.0;     
	gbcText.insets  = insets;
	gbcText.gridy   = 0;
        gbcText.gridx   = 1;
        gbcText.anchor  = GridBagConstraints.WEST;
        gbcText.fill    = GridBagConstraints.NONE;    


	if (getLabel() != null) {
	    this.add(this.label,gbcLabel);
	} else {
	    gbcText.gridx   = 0;
	}
	this.add(getField(),gbcText);

	if (titled) {
	    if ( layout == 1) setRaisedTitledBorder(title);
	    if ( layout == 2) setLoweredTitledBorder(title);
	    if ( layout == 0) setTitledBorder(title);
	}  else {
	    setLayout(layout);
	}
    }

    public static void main(String a[]) {

        DateButtonPanel d = new DateButtonPanel(null);
	CloseableFrame c = new CloseableFrame("Test");
	c.getContentPane().add(d);
	c.pack();
	c.setVisible(true);
	    



    }
}
       
	    
	
    
