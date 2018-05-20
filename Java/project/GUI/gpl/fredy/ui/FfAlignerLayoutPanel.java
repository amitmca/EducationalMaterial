package gpl.fredy.ui;


/** 
    FfAlignerLayoutPanel is a Panel that allows me to arrange
    the components inside the Panels for Admin much more easy
    
    ..done when I had a lot to learn about layoutmanagers....

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



import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;

public class FfAlignerLayoutPanel extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002 ";

public String getVersion() {return fredysVersion; }

    private int actPos = 1;
    private GridBagConstraints gbc;
    public int numberOfRows = 2;

    
    /**
       * Get the value of numberOfRows.
       * @return Value of numberOfRows.
       */
    public int getNumberOfRows() {return numberOfRows;}
    
    /**
       * Set the value of numberOfRows.
       * @param v  Value to assign to numberOfRows.
       */
    public void setNumberOfRows(int  v) {this.numberOfRows = v;}



    Insets insets;
    
    /**
       * Get the value of insets.
       * @return Value of insets.
       */
    public Insets getInsets() {return insets;}
    
    /**
       * Set the value of insets.
       * @param top    = the inset from the top
       * @param left   = the inset from the left
       * @param bottom = the inset from the bottom
       * @param right  = the inset from the right
       */
    public void setInsets(int top, int left, int bottom, int right) {
	Insets i = new Insets(top, left, bottom, right);
	this.insets = i;
    }
    


    public FfAlignerLayoutPanel() {
	insets = new Insets(5,5,5,5);
	gbc = new GridBagConstraints();
	gbc.fill = gbc.BOTH ;
	this.setLayout(new GridBagLayout());
    }

    /**
       * Adds a component to the Panel
       * @param c = Component to add
       */


    public void addComponent(Component c) {
	
	gbc.insets = getInsets();
	if ( actPos < getNumberOfRows() ) {
	    gbc.anchor    = GridBagConstraints.NORTHEAST;
	    gbc.gridwidth = GridBagConstraints.RELATIVE;
	} else {	    
 	    gbc.anchor    = GridBagConstraints.WEST;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;   
	}
	
        gbc.fill  = GridBagConstraints.BOTH;

	this.add(c,gbc);
	actPos = actPos + 1;
        if ( actPos > numberOfRows ) actPos = 1;
    }
}
