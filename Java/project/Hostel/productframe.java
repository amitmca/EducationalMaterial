//creates frame of product details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class productframe extends JDialog implements ActionListener
{
	productframe(JFrame parent)
	{
		super(parent,"Hostel Admission System",true);
		
	    Container c = getContentPane();
		c.setLayout(null);
	
	    JLabel l1=new JLabel("Product Name :");
	    l1.setForeground(Color.blue);
	    JLabel l2=new JLabel("  Hostel Admission System.");
	    l2.setForeground(Color.blue);
	    JLabel l5=new JLabel("Version 1.0");
	    l5.setForeground(Color.blue);
	    JLabel l3=new JLabel("This Product is Licensed to ===>");
	    l3.setForeground(Color.blue);
		JLabel l4=new JLabel("  Nowrosjee Wadia College,Pune-411001");
		l4.setForeground(Color.blue);
		JLabel l6=new JLabel("Warning : This Product is CopyRighted under Judicial Laws");
		JButton b1=new JButton("Ok");
		b1.setMnemonic('o');
		b1.setToolTipText("Ok");
		
		Font f=new Font("verdana",Font.PLAIN,12);
        Color col=new Color(255,0,0); 
        l6.setFont(f);  
        l6.setForeground(col);
        b1.setForeground(col);
        
		//set bounds(xth pos,yth pos,width,height)
		l1.setBounds(60,10,180,20);		
		l2.setBounds(95,30,180,20);
		l3.setBounds(40,90,200,20);
		l4.setBounds(50,110,240,20);
		l5.setBounds(60,50,100,20);
		l6.setBounds(20,140,370,20);
		b1.setBounds(240,170,50,30);
		b1.setForeground(Color.blue);
		
		b1.addActionListener(this);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(b1);
		//the left-top corner's position of Dialog Box
		setLocation(200,100);
		//width &  height of frame
		setSize(400,250);
        setVisible(true);
	}	
	public void actionPerformed(ActionEvent ae)
    {
    	dispose();
    }
}
