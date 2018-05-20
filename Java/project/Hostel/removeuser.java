//creates frame for removing user

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class removeuser extends JDialog implements ActionListener
{
	JComboBox username;
	JButton ok,cancel;
	removeuser(JFrame parent)
	{
	    super(parent,"Remove User",true);
		Container c = getContentPane();
		c.setLayout(null);
       
        JLabel user=new JLabel("Select User Name :");
        
        ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Close");
		cancel.setMnemonic('c');
		
		username=new JComboBox();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String dsn="jdbc:odbc:hostel";
			Connection con=DriverManager.getConnection(dsn,null,null);
			con.setAutoCommit(true);
			Statement stmt=con.createStatement();
			String sqlstr = "select * from login order by username";
			ResultSet rs=stmt.executeQuery(sqlstr);
			while(rs.next())
			{
				username.addItem(rs.getString(1).toUpperCase());
			}
			 username.removeItem("ADMIN");			   		
			 //disables ok button if there is no user
			if(username.getItemCount()==0)
			  ok.setEnabled(false);
			con.close();
		}
		catch(Exception e)
		{
			   JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		Font f=new Font("verdana",Font.BOLD,14);
        Color col=new Color(0,0,255); 
        
        user.setFont(f);
        username.setFont(f);
        ok.setFont(f);
        cancel.setFont(f);
        user.setForeground(col);
        username.setForeground(col);
        ok.setForeground(col);
        cancel.setForeground(Color.red);
		
		user.setBounds(50,10,180,20);
		username.setBounds(210,10,130,20);
		ok.setBounds(70,80,70,30);
		cancel.setBounds(190,80,90,30);
		
		username.setToolTipText("User names");
		ok.setToolTipText("Remove User");
		cancel.setToolTipText("Close");
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		c.add(user);
		c.add(username);
		c.add(ok);
		c.add(cancel);
		
		setLocation(180,150);
		setSize(370,180);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			if(JOptionPane.showConfirmDialog(null,"Do you want to remove user : "+username.getSelectedItem().toString()+" ?","Remove user",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION)
	         try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String dsn="jdbc:odbc:hostel";
				Connection con=DriverManager.getConnection(dsn,null,null);
				con.setAutoCommit(true);
				Statement stmt=con.createStatement();
				String sqlstr = "delete from login where username='"+username.getSelectedItem().toString()+"'";
				stmt.executeUpdate(sqlstr);
				
				//removes user name from combo box
				username.removeItem(username.getSelectedItem());
				
				if(username.getItemCount()!=0)
				  username.setSelectedIndex(0);
				username.requestFocus(true);
				JOptionPane.showMessageDialog(null,"User removed successfully !!!");
				//disables ok button if there is no user
				if(username.getItemCount()==0)
			  		ok.setEnabled(false);
				con.close();
			}
			catch(Exception e)
			{
			   JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		if(ae.getSource()==cancel)
		  dispose();
	}
}
