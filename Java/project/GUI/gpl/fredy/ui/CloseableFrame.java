package gpl.fredy.ui;
/*
 * ...is a closeable JFrame
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
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.AWTEvent.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;



public class CloseableFrame extends JFrame {

    
    boolean exitOnClose=true;
    
    /**
       * Get the value of exitOnClose.
       * @return value of exitOnClose.
       */
    public boolean isExitOnClose() {return exitOnClose;}
    
    /**
       * Set the value of exitOnClose.
       * @param v  Value to assign to exitOnClose.
       */
    public void setExitOnClose(boolean  v) {this.exitOnClose = v;}
    


    public  CloseableFrame() {
	init();
    }

    public CloseableFrame(String title) {

	super(title);
	init();

    }


    public void init() {
	this.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
		    if ( isExitOnClose() ){
			System.exit(0);
		    } else {
			close();
		    }
		}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});

    }

    public void close() { this.dispose(); }

    public void doPack() { this.pack(); }

    public static void main(String args[]) {
	if (args.length > 0 ) {
	    CloseableFrame c = new CloseableFrame(args[0]);
	} else {
	    CloseableFrame c = new CloseableFrame();
	}
    }
}
	

    
