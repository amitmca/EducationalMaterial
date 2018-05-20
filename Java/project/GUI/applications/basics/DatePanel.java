
package applications.basics;

/** 
    DBcomboBox creates a combobox out of the 1st Field a SQL-Query
    returns.


    Admin is a Tool around mySQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

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
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class DatePanel extends JPanel {

   private JComboBox day, month, year;

   private String dbDate;
    public String getDbDate() {

	String dayDate    = (String)day.getSelectedItem();
        String monthDate  = (String)month.getSelectedItem();
        String yearDate   = (String)month.getSelectedItem();
        return dayDate + "-" + monthDate + "-" + yearDate;
    }
    public String getText() { return getDbDate(); }

    public void setDbDate(String dbd) {
    
    }

    public void setText(String dbd) { setDbDate(dbd);}

    public DatePanel() {

	this.setLayout(new FlowLayout());
	day = new JComboBox();
	for (int i=1;i <=31; i++) {
            day.addItem(Integer.toString(i));
	}
    
	month = new JComboBox();
	month.addItem("Jan");
	month.addItem("Feb");
	month.addItem("Mar");
	month.addItem("April");
	month.addItem("May");
	month.addItem("June");
	month.addItem("July");
	month.addItem("Aug");
	month.addItem("Sept");
	month.addItem("Oct");
	month.addItem("Nov");
	month.addItem("Dec");

	year = new JComboBox();
	for (int i=1990;i <=2036; i++) {
            year.addItem(Integer.toString(i));
	}
    	

	this.add(day);
	this.add(month);
        this.add(year);

    }

    public static void main(String args[]){

	DatePanel dp = new DatePanel();
	JFrame frame = new JFrame("Date");
	frame.getContentPane().setLayout(new BorderLayout());
	frame.getContentPane().add("Center",dp);
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
            public void windowDeactivated(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowOpened(WindowEvent e) {}});
	
	frame.pack();
    }
}
