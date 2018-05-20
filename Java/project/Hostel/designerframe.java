//creates frame for displaying designers
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;


class designerframe extends JDialog implements ActionListener
{
	designerframe(JFrame parent)
	{
		super(parent,"Application Designers",true);
		
	    Container c = getContentPane();
		c.setLayout(null);
	    JLabel l1=new JLabel("Hostel Admission System.");
	    JLabel l2=new JLabel("Developed By ==>");
	    JLabel l3=new JLabel("   Vijay V Bhosale (6)");
		JLabel l4=new JLabel("& Sandesh Lodha (38)");
		JLabel l5=new JLabel("M.C.S. Sem-II (2005)");
		JLabel l6=new JLabel("(Nowrosjee Wadia College,Pune-411001)");
		JButton ok=new JButton("Ok");
		ok.setToolTipText("Ok");
		ok.setMnemonic('o');
		
		//set bounds(xth pos,yth pos,width,height)
		l1.setBounds(110,10,180,20);
		l2.setBounds(70,40,180,20);		
		l3.setBounds(130,60,180,20);		
		l4.setBounds(140,80,180,20);
		l5.setBounds(90,110,150,20);
		l6.setBounds(90,130,240,20);
		ok.setBounds(260,170,50,30);
		ok.setForeground(Color.blue);
		ok.addActionListener(this);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(ok);
		//the left-top corner's position of Dialog Box
		setLocation(200,100);
		//width&height of frame
		setSize(370,250);
        setVisible(true);
		
	}	
public void actionPerformed(ActionEvent ae)
    {
    	dispose();
    }
}