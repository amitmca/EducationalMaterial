package gpl.fredy.dbtools;

/** 
 *  this package delivers tools for different DBMS
 *
 *  mckoi is a simple tool around mckoi-db
 *  Version 1.0. 13. April 2002
 *  Fredy Fischer 
 *
 */


/**  * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C) August 9, 2003, Fredy Fischer
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


import gpl.fredy.ui.*;
import gpl.fredy.io.*;

public class mckoi extends JPanel {

    
    boolean running=false;;
    
    /**
       * Get the value of running.
       * @return value of running.
       */
    public boolean isRunning() {return running;}
    
    /**
       * Set the value of running.
       * @param v  Value to assign to running.
       */
    public void setRunning(boolean  v) {
	this.running = v;
        if (isRunning() ) {
	    statusLine.setText("is running"); 
	} else {
	    statusLine.setText("not running");
	}
    }
    

    private JTextField     user,host,port,confFile;
    private JLabel         statusLine;
    private JPasswordField password;
    private ImageButton    create,boot,shutdown;
    public  ImageButton    cancel;

    public JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	panel.setBorder(new EtchedBorder());

	boot     = new ImageButton(null,"bootdb.gif","boot server");
	shutdown = new ImageButton(null,"shutdb.gif","shutdown server");
        create   = new ImageButton(null,"createdb.gif","create new DB");
	cancel   = new ImageButton(null,"exit.gif","Exit");

	panel.add(boot);
	panel.add(shutdown);
	panel.add(create);
	panel.add(cancel);

	boot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String params[] = { "-conf", confFile.getText(), "-boot" };
		    if ( ! isRunning() ) {
			exec(params);
			setRunning(true);
		    } else {
			statusLine.setText("is already running");
		    }
		    }});
	
	shutdown.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String params[] = { "-shutdown", host.getText(), port.getText(),
					user.getText(),
					String.valueOf(password.getPassword()) };
		    exec(params);
		    setRunning(false);
		    }});
		    
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String params[] = { "-create",
					user.getText(),
					String.valueOf(password.getPassword()),
					confFile.getText() };
		    exec(params);
		    setRunning(false);
		    }});
	
	return panel;
    }

    private JPanel fields() {
	JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.NONE;
	Insets insets = new Insets(1,1,1,1);
        gbc.insets =insets;
        gbc.gridx = 0;
        gbc.gridy = 0;
	
	panel.add(new JLabel("Host"),gbc);
	
	gbc.gridy = 1;
	panel.add(new JLabel("Port"),gbc);

	gbc.gridy = 2;
	panel.add(new JLabel("User"),gbc);
	
	gbc.gridy = 3;
	panel.add(new JLabel("Password"),gbc);

	gbc.gridy = 4;
	panel.add(new JLabel("Configuration File"),gbc);


	gbc.gridx = 1;
	gbc.gridy = 0;
	
	host = new JTextField("hulmen",15);
	panel.add(host,gbc);

	gbc.gridy = 1;
	port = new JTextField("9157",15);
	panel.add(port,gbc);

	gbc.gridy = 2;
	user = new JTextField(System.getProperty("user.name"),15);
	panel.add(user,gbc);

	gbc.gridy = 3;
	password = new JPasswordField(15);
	panel.add(password,gbc);

	gbc.gridwidth = 2;
	confFile = new JTextField("",30);
	confFile.setText("/export/home/afs/java/dbms/mckoi/mckoi0.93/fredy.conf");
	gbc.gridy = 4;
	panel.add(confFile,gbc);

	gbc.gridwidth = 1;
	ImageButton select = new ImageButton(null,"open.gif","select conf-file");
	gbc.gridx = 3;
	panel.add(select,gbc);
 	select.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
		   	JFileChooser chooser = new JFileChooser(); 
			chooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
			chooser.setDialogTitle("Select Configuration file");

			MyFileFilter filter = new MyFileFilter();
			filter.addExtension("conf");
			filter.addExtension("CONF");
			filter.setDescription("Configration-files");
			chooser.setFileFilter(filter);

			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) 
		            confFile.setText(chooser.getCurrentDirectory() + java.io.File.separator + chooser.getSelectedFile().getName());
			    }});


	return panel;
    }

    public mckoi() {
	this.setLayout(new BorderLayout());
	this.add(BorderLayout.NORTH,buttonPanel());

	statusLine = new JLabel();
	statusLine.setText(" ");
	statusLine.setFont(new Font("Monospaced", Font.PLAIN, 10));
	statusLine.setBackground(Color.yellow);
	statusLine.setForeground(Color.blue);	

	this.add(BorderLayout.SOUTH,statusLine);
	this.add(BorderLayout.CENTER,fields());
    }


    private void exec(final String params[]) {
	Thread t = new Thread() {
		public void run() {	
		    try {
			Runtime rt = Runtime.getRuntime();
			String p = "";
			for (int i=0;i< params.length;i++) p = p + " " + params[i];
			Process prcs = rt.exec("java com.mckoi.runtime.McKoiDBMain " + p);
			InputStreamReader isr = new InputStreamReader( prcs.getInputStream() );
			BufferedReader d = new BufferedReader( isr );
			
			String line;
			while ( (line=d.readLine() ) != null )
			    System.out.println(line);
		    } catch (Exception e) {
			statusLine.setText(e.toString());
			statusLine.setBackground(Color.yellow);
			statusLine.setForeground(Color.blue);	
		    }
		}};
		t.start();
    }

    public static void main(String a[]) {
	JFrame cf = new JFrame("MCKOI Tool");
	final mckoi m = new mckoi();
	cf.getContentPane().setLayout(new BorderLayout());
	cf.getContentPane().add(BorderLayout.CENTER,m);
	m.cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if ( ! m.isRunning() ) System.exit(0);
		    }});

	cf.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
		    if ( ! m.isRunning() ) System.exit(0);
		}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	


	cf.pack();
	cf.setVisible(true);		
    }
}
