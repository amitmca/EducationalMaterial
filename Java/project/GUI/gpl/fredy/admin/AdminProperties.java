package gpl.fredy.admin;


/** Admin is a Tool around mySQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin 
    Copyright (c) 1999 Fredy Fischer
                       se-afs@dial.eunet.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
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

import gpl.fredy.io.*;
import gpl.fredy.generate.*;
import gpl.fredy.metadata.*;
import gpl.fredy.ui.*;
import gpl.fredy.sqltools.*;
import gpl.fredy.share.*;

public class AdminProperties extends JPanel {


// Fredy's make Version
private static String fredysVersion = "Version 1.3  2001-8-11 10:7";

public String getVersion() {return fredysVersion; }

    private JTable table;
    private RdbmsTable rt;
    public JButton close;
    private LoadImage loadThatImage = new LoadImage();
   
    Logger logger = Logger.getLogger("gpl.fredy.admin");
    private JScrollPane rdbmsDat() {


	rt = new RdbmsTable();
	table = new JTable(rt);
        JScrollPane scrollpane = new JScrollPane(table);
        //table.setPreferredScrollableViewportSize(new Dimension(400, 70));

	
	table.getTableHeader().setReorderingAllowed(false);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	fillTablefromFile();
	//fitTableSize();

	return scrollpane;

    }

    private void fitTableSize() {
	for (int i = 0; i< rt.getColumnCount(); i++ ) {
	        table.getColumnModel().getColumn(i).setHeaderValue(rt.getColumnName(i));
	    	table.getColumnModel().getColumn(i).sizeWidthToFit();
	}

    }

    private void fillTablefromFile() {

	String line="";
	String tmp = "";
        int sel=0;
	int idx = -1;
     /*
      *	   BufferedReader in  = new BufferedReader(
      *				new InputStreamReader(
      *				     AdminProperties.class.getResourceAsStream("rdbms.dat")));
     */
       
       logger.log(Level.FINEST,"hello, it's me"); 
        
       InputStream rdbmsFile = null;
        try {
           //rdbmsFile = SelectDriver.class.getResource("rdbms.dat").getFile();
           rdbmsFile = this.getClass().getClassLoader().getResourceAsStream("gpl/fredy/share/rdbms.dat");
        } catch (Exception exception) {
            logger.log(Level.WARNING,"Could not load file");
            try {
            FileInputStream fis = new FileInputStream(System.getProperty("admin.share") + File.separator + "rdbms.dat");            
            rdbmsFile = fis;
            } catch (FileNotFoundException fne) {
                logger.log(Level.WARNING,"Something went wrong, I can not find rdbms.dat at the expected location. Admin works either");
            }
        }
	
       /**     
	   BufferedReader in  = new BufferedReader(
				new InputStreamReader(
				     SelectDriver.class.getResourceAsStream("rdbms.dat")));
          **/  
       try {
	   BufferedReader in  = new BufferedReader(
				new InputStreamReader( rdbmsFile )); 
		while (line != null) {
			try  {
				line = in.readLine();
                                logger.log(Level.INFO,"Reading " + line );
				if (line != null)
				{
					if ( ! line.startsWith("#") && (line.trim().length() != 0))
					{
					        Vector v = new Vector();
						idx = idx + 1;
						JdbcStuff js = new JdbcStuff() ;
						js.setObject(line);
						v.addElement(js.getName());
						v.addElement(js.getJDBCDriver());
						v.addElement(js.getDbUrl());
						v.addElement(js.getPort());
						//v.addElement(js.getImage());
						v.addElement(js.gif);
						rt.addRow(v);
					}
				}
			} catch (IOException iox) { line=null; }		
		}
       } catch (Exception someException) {
           logger.log(Level.WARNING,"Could not load file");
       }
    }

    public AdminProperties() {

	this.setLayout(new BorderLayout());

	this.add("Center",rdbmsDat());
	createLines();
	this.add("South",buttonPanel());
    }


    private void createLines() {

      for (int i = 0; i< 10; i++ ) {
	  addLine();
      }

    }


    private ImageIcon loadImage(String image) {
	return loadThatImage.getImage(image);

   }


    private JPanel buttonPanel() {

	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());

	close = new JButton("Exit",loadImage("exit.gif"));
	
	JButton add = new JButton("Add",loadImage("plus.gif"));
	add.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		addLine();
		}});
	
	JButton save = new JButton("Save",loadImage("save.gif"));
	save.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		}});
	

	panel.add(add);
	panel.add(save);
	panel.add(close);
	return panel;
	


    }
   
    private void addLine() {
		Vector v = new Vector();
		String s = " ";
		for (int i = 0; i< rt.getColumnCount(); i++ ) {
		    v.addElement(s);
		}
		rt.addRow(v);
    }


    public static void main(String a[]) {

	JFrame frame = new JFrame();
	AdminProperties ap = new AdminProperties();
	ap.close.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	
	frame.getContentPane().add(ap);
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	frame.pack();
	frame.setVisible(true);
	

    }

}
