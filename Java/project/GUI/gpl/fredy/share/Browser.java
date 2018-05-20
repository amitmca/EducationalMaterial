package gpl.fredy.share;


/**  
 * a very simple browser, more a test, how it works. 
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
 * Browser.java
 *
 *
 * Created: Tue Jan  2 12:37:37 2001
 *
 * @author Fredy Fischer
 * @version
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import gpl.fredy.ui.*;


public class Browser extends JPanel {
    
      
    private JTextField url;
    private JEditorPane editorPane;
    public JButton cancel;
    private Stack urlStack = new Stack();
    private String homeUrl=null;
    private ImageButton home;

    public Browser() {
	this.setLayout(new BorderLayout());
	this.add(BorderLayout.SOUTH,buttonPanel());
	this.add(BorderLayout.CENTER,showPanel());
	
    }

    private JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());

	home = new ImageButton(null,"home.gif","Home");
	home.setEnabled(false);
	home.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setURL(homeUrl);
		}});
	
	ImageButton left = new ImageButton(null,"left.gif","Back");
	left.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (urlStack.size() <= 1) return;
		try { 
		    urlStack.pop();		
		    String urlString = (String)urlStack.peek();
		    url.setText(urlString);                 
		    editorPane.setPage(urlString);
		} catch(IOException e1) {
		  editorPane.setText("Fehler: " + e1);		    
	        }
	    }});
	
	

	cancel = new JButton();
	ImageButton imb = new ImageButton();
	ImageIcon i1 = imb.getImageIcon("exit.gif");
	ImageIcon i2 = imb.grayed(i1.getImage());
	cancel.setIcon(i2);
	cancel.setRolloverIcon(i1);
	cancel.setRolloverEnabled(true);
	cancel.setToolTipText("Exit");

	panel.add(home);
	panel.add(left);
	panel.add(cancel);
	panel.add(new JLabel("URL:"));
	url = new JTextField(25);
	url.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setURL(url.getText());
	    }});
	
	panel.add(url);

	return panel;	   
    }

    public void setURL(String s) {
		try {
		     urlStack.push(s);
		     editorPane.setPage(s);
		     url.setText(s);
		     if (homeUrl == null) {
			 homeUrl = url.getText();
			 home.setEnabled(true);
		     }
		} catch (IOException ex) {
		    editorPane.setText("Error: " + ex);
		}
    }


    private JScrollPane showPanel() {
      editorPane = new JEditorPane();
      editorPane.setEditable(false);
      editorPane.addHyperlinkListener(new HyperlinkListener()
         {  public void hyperlinkUpdate(HyperlinkEvent event)
            {  if (event.getEventType() 
                 == HyperlinkEvent.EventType.ACTIVATED)
              { 
		  setURL(event.getURL().toString());
	      }
            }
         });
       JScrollPane scrollpane = new JScrollPane(editorPane);
       return scrollpane;
    }

    
    public static void main(String args[]) {
	JFrame frame = new JFrame("Fredy's Browser");
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	
	Browser browser = new Browser();
	browser.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	frame.getContentPane().add(browser);
	if (args.length > 0) browser.setURL(args[0]);
	frame.pack();
	frame.setVisible(true);
    }


} // Browser
