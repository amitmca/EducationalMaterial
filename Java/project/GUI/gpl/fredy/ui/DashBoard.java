package gpl.fredy.ui;

/**  
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
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.tree.*;
import java.awt.datatransfer.*;
import java.lang.reflect.*;

import gpl.fredy.metadata.*;
import gpl.fredy.share.*;
import gpl.fredy.io.*;
import gpl.fredy.ui.*;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.Namespace;



public class DashBoard extends JPanel {

  JLayeredPane desktop;

  String file;
  public void setFile(String v) { this.file=v; }
  public String getFile() { return file; }
  public ImageButton close;
  private JLabel statusLine;

  public DashBoard(String file) {

    setFile(file);
    init();
  }
  public DashBoard() {
    setFile(null);
    init();
  }


  public static void main(String args[]) {
    String file=null;

    System.out.println("Fredy's DashBoard Version 1.0\n" +
		       "-----------------\n" +
		       "Is used to display system-states\n\n" +
                       "Parameters: -f xmlfile\n" );

    if (( args.length > 1 ) && (args[0].toLowerCase().startsWith("-f") ) ) file = args[1];
    if ( args.length == 1 ) file = args[0];

    DashBoard db = new DashBoard(file);
    CloseableFrame cf = new CloseableFrame("DashBoard");
    cf.getContentPane().setLayout(new BorderLayout());
    cf.getContentPane().add(BorderLayout.CENTER,db);
    cf.pack();
    cf.setVisible(true);

    db.close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	System.exit(0);
      }});
  
  }
    
  private void init() {

    
    desktop = new JDesktopPane();
    desktop.setOpaque(false);

    this.setLayout(new BorderLayout());
    this.add(BorderLayout.NORTH,buttonPanel());
    this.add(BorderLayout.CENTER,desktop);
    this.add(BorderLayout.SOUTH,statusPanel());

  }
      
    private JToolBar buttonPanel() {
	JToolBar toolbar = new JToolBar(SwingConstants.HORIZONTAL);
	toolbar.setFloatable(false);

	ImageButton runIt     = new ImageButton(null,"gauge.gif","dash it");
	ImageButton loadFile  = new ImageButton(null,"opendoc.gif","load XML-File");
	ImageButton newWindow = new ImageButton(null,"computer.gif","new Window");
	            close     = new ImageButton(null,"exit.gif","close");

	newWindow.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
		  final JFrame aFrame = new JFrame("another DashBoard");
		  aFrame.getContentPane().setLayout(new BorderLayout());
                  aFrame.addWindowListener(new WindowAdapter() {
		    public void windowActivated(WindowEvent e) {}
		    public void windowClosed(WindowEvent e) {}
		    public void windowClosing(WindowEvent e) {
		      aFrame.setVisible(false);
		      aFrame.dispose();
		    }
		    public void windowDeactivated(WindowEvent e) {}
		    public void windowDeiconified(WindowEvent e) {}
		    public void windowIconified(WindowEvent e) {}
		    public void windowOpened(WindowEvent e) {}});
	      
		  final DashBoard aDashBoard = new DashBoard();
		  aDashBoard.close.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      aFrame.setVisible(false);
		      aFrame.dispose();
		    }
		  });
		  aFrame.getContentPane().add(BorderLayout.CENTER,aDashBoard);
		  aFrame.pack();
		  aFrame.setVisible(true);
	       }
	});


	runIt.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    exec();
	  }});

	loadFile.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	    addFile();
	  }});


	toolbar.add(runIt);
	toolbar.add(loadFile);
	toolbar.add(newWindow);
	toolbar.add(close);

	return toolbar;
    }


    private JPanel statusPanel() {
	JPanel panel = new JPanel();
	statusLine = new JLabel();
	statusLine.setText("Fredy's DashBoard Version 0.1");
	statusLine.setFont(new Font("Monospaced", Font.PLAIN, 10));
	statusLine.setBackground(Color.yellow);
	statusLine.setForeground(Color.blue);
	panel.setBackground(Color.yellow);
	panel.setForeground(Color.blue);
	panel.setBorder(new BevelBorder(BevelBorder.LOWERED));

	panel.add(statusLine);
	return panel;

    }



  private void addFile() {
	JFileChooser chooser = new JFileChooser(); 
	chooser.setDialogTitle("Select XML file");

	MyFileFilter filter = new MyFileFilter();
	filter.addExtension("xml");
	filter.setDescription("XML-files");
	chooser.setFileFilter(filter);

	int returnVal = chooser.showOpenDialog(this);
	if(returnVal == JFileChooser.APPROVE_OPTION) 
	    setFile(chooser.getCurrentDirectory() + java.io.File.separator + chooser.getSelectedFile().getName());

  }

  private void exec() {
    if ( getFile() == null ) addFile();
  }

}
	

