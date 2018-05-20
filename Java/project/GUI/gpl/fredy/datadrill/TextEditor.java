package gpl.fredy.datadrill;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.datatransfer.*;
import gpl.fredy.ui.*;


public class TextEditor extends JPanel {

  public ImageButton ok,cancel;
   
    public JTextArea text;
  
    public String getText() {
	return text.getText();

    }

    public void setText(String v) { 
	    text.setText(v);
    }

    public void setTitle(String t) {
	this.setTitle(t);
    }

    public TextEditor() {
	doIt();
    }
    public TextEditor(String text) {
	doIt();
	this.text.setText(text);
    }



    private void doIt() {

	initComponents();
	this.setLayout(new GridBagLayout());

	GridBagConstraints gbc;
	Insets insets = new Insets(5,5,5,5);

	gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.HORIZONTAL;

	JPanel panel = new JPanel();


        panel = textPanel();

	gbc.gridx = 0;
	gbc.gridy = 0;	
	gbc.weightx = 0.8;	
	gbc.weighty = 0.2;
	this.add(panel,gbc);

	gbc.gridx = 0;
	gbc.gridy = 1;
        gbc.fill  = GridBagConstraints.BOTH;
	gbc.weightx = 0.8;	
	gbc.weighty = 0.2;
	this.add(buttonPanel(),gbc);		


    }

    private JPanel buttonPanel() {
	JPanel panel = new JPanel();
	panel.setBorder(new EtchedBorder());
	ok = new ImageButton(null,"ok.gif",null);
	cancel = new ImageButton(null,"exit.gif",null);
	panel.add(ok);
	panel.add(cancel);
	return panel;
    }



    private void initComponents() {
	text = new JTextArea(10,20);
    }

	
    private JPanel textPanel() {
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout());

	GridBagConstraints gbc;
	Insets insets = new Insets(5,5,5,5);

	gbc = new GridBagConstraints();
	gbc.anchor= GridBagConstraints.WEST;
        gbc.fill  = GridBagConstraints.BOTH;

	JScrollPane pane = new JScrollPane(text);


	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1.0;	
	gbc.weighty = 1.0;
	panel.add(pane,gbc);

	return panel;

    }


    public static void main(String args[] ) {
	final TextEditor f = new TextEditor();
	JFrame e = new JFrame("Editor");
	e.getContentPane().add(f);
	e.pack();
	e.setVisible(true);
	e.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
		    System.out.println(f.getText());
		    System.exit(0);
		}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	f.cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		    }});
	


    }

}
