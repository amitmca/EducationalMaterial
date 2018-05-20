//creates frame for accessing total fee

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;


class totalfeeframe extends JDialog implements ActionListener
{
	JButton ok,cancel;
	JTextField totalfee;
	int oldfee;
	totalfeeframe(JFrame parent)
	{
		super(parent,"Total Fee",true);
		
		Container c=getContentPane();
		c.setLayout(null);
		
		JLabel tf=new JLabel("Total Fees (in Rs.)");
		tf.setForeground(Color.blue);
		totalfee=new JTextField();
		totalfee.setToolTipText("Total Fee (in Rs.)");
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		ok.setToolTipText("Save Record");
		cancel=new JButton("Cancel");
		cancel.setMnemonic('c');
		cancel.setToolTipText("Cancel");
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
		
		tf.setBounds(40,30,150,20);
		totalfee.setBounds(160,30,70,20);
		ok.setBounds(70,90,50,30);
		cancel.setBounds(170,90,90,30);
		
		cancel.addActionListener(this);
		ok.addActionListener(this);
	
		c.add(ok);
		c.add(cancel);
		c.add(tf);
		c.add(totalfee);
		
			try
	        {
	        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        	String dsn="jdbc:odbc:hostel";
	        	Connection con=DriverManager.getConnection(dsn,null,null);
	            con.setAutoCommit(true);
	            Statement stmt = con.createStatement();
				String sqlstr="select * from totalfee";
				ResultSet rs=stmt.executeQuery(sqlstr);
				while(rs.next())
				{
					oldfee=rs.getInt(1);
				}
				totalfee.setText(""+oldfee+"");
	         }
	         catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null,e.getMessage());
	        }//end of catch
		
		setLocation(170,130);
		setSize(300,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		 {
		 	if(totalfee.getText().equals(""))
      		   {
      			  JOptionPane.showMessageDialog(null,"Enter Total Fee","Error Message",JOptionPane.ERROR_MESSAGE);
      			  totalfee.requestFocus(true);
					return;
      		   }
      		   for(int i=0;i<totalfee.getText().length();i++)
      		   {
      		   	  char ch = totalfee.getText().charAt(i);
				  if(ch>='0'&&ch<='9')
				  {
				  }
				 else
				  {
				 	JOptionPane.showMessageDialog(null,"Enter Numerical Value For Total Fee","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					totalfee.setText("");
					totalfee.requestFocus();
					return;
				  } 
		      }
		    try
	        {
	        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        	String dsn="jdbc:odbc:hostel";
	        	Connection con=DriverManager.getConnection(dsn,null,null);
	            con.setAutoCommit(true);
	            Statement stmt = con.createStatement();
				String sqlstr="Update totalfee set totalfee="+Integer.parseInt(totalfee.getText());
				if (JOptionPane.showConfirmDialog(null,"Do you want to Save the Record?")==JOptionPane.YES_OPTION)
				{
  	              stmt.executeUpdate(sqlstr);
	              JOptionPane.showMessageDialog(null,"Record Saved Successfully !!!");
	              ok.setEnabled(false);
	              cancel.setText("Close");
	              cancel.setToolTipText("Close");
	            }
	            else
	            {
	            	totalfee.setText(""+oldfee+"");
	            }
	         }
	         catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null,e.getMessage());
	        }//end of catch
		 }
		if (ae.getSource()==cancel)
		  dispose();
	}
}