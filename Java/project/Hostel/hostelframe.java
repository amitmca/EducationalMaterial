//creates frame for accessing hostel details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class hostelframe extends JDialog implements ActionListener
{
	int count=1;
	JTextField no;
	JComboBox type;
	JTextField name;
	JTextField totalroom;
	JButton ok,cancel;
	hostelframe(JFrame parent)
	{
		super(parent,"Hostel Details",true);
		//for displaying hostel number in the textfield of hostel number
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select max(hno) from hostel";
            ResultSet rs=stmt.executeQuery(sqlstr);
           while(rs.next())
            {
               count=rs.getInt(1);
            }
            con.close();
            
        Container c = getContentPane();
		c.setLayout(null);
		 
		JLabel hosno=new JLabel("Hostel Number");
		hosno.setForeground(Color.blue);
		no= new JTextField(5);
		no.setEnabled(false);
		count=count+1;
		no.setText(""+count+"");
		
		JLabel hostype=new JLabel("Hostel Type");
		type=new JComboBox();
		type.addItem("Gents");
		type.addItem("Ladies");
			
		JLabel hosname=new JLabel("Hostel Name");
		name=new JTextField(20);
		
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		ok.setToolTipText("Save Record");
		cancel=new JButton("Cancel");
		cancel.setToolTipText("Cancel");
		cancel.setMnemonic('c');
		
		JLabel total=new JLabel("Total Rooms");
		totalroom=new JTextField(20);
		
		//set bounds(xth pos,yth pos,width,height)
		hosno.setBounds(40,30,100,20);
		no.setBounds(140,30,100,20);
		no.setToolTipText("Hostel Number");
		hostype.setBounds(40,60,100,20);
		type.setBounds(140,60,100,20);
		type.setToolTipText("Hostel Type");
		hosname.setBounds(40,90,80,20);
		name.setBounds(140,90,220,20);
		name.setToolTipText("Hostel Name");
		ok.setBounds(100,160,60,30);
		ok.setToolTipText("Save Record");
		cancel.setBounds(200,160,100,30);
		cancel.setToolTipText("Cancel");
		total.setBounds(40,120,220,20);
		totalroom.setBounds(140,120,120,20);
		totalroom.setToolTipText("Total Rooms in Hostel");
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
		
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		c.add(ok);
		c.add(cancel);
		c.add(hosno);
		c.add(no);
		c.add(hostype);
		c.add(type);
		c.add(hosname);
		c.add(name);
		c.add(total);
		c.add(totalroom);
		setLocation(200,160);
		setSize(450,250);
        setVisible(true);
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }
	}
	
	//handling events
      public void actionPerformed(ActionEvent ae)
      {
      	if (ae.getSource()==ok)
      	{
      		if(name.getText().equals(""))
      		{
      			JOptionPane.showMessageDialog(null,"Enter Name of Hostel","Error Message",JOptionPane.ERROR_MESSAGE);
      			name.requestFocus(true);
				return;
      		}
      		//check whether user has entered '
			 for(int i=0;i<name.getText().length();i++)
      		   {
      		   	  char ch = name.getText().charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't  insert  '  character in Hostel Name field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						//name.setText("");
						name.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
  			if(totalroom.getText().equals(""))
      		   {
      			  JOptionPane.showMessageDialog(null,"Enter total rooms of Hostel","Error Message",JOptionPane.ERROR_MESSAGE);
      			  totalroom.requestFocus(true);
					return;
      		   }
      		   for(int i=0;i<totalroom.getText().length();i++)
      		   {
      		   	  char ch = totalroom.getText().charAt(i);
				  if(ch>='0'&&ch<='9')
					{
					}
				 else
				  {
				 	JOptionPane.showMessageDialog(null,"Enter Numerical Value For Total Rooms","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					totalroom.setText("");
					totalroom.requestFocus();
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
            String hno1=no.getText();
            int hno=Integer.parseInt(hno1);
            String hname = name.getText();
            String htype=type.getSelectedItem().toString();
            String room1=totalroom.getText();
            int room=Integer.parseInt(room1);
            String sqlstr="Insert Into hostel values (" + hno+",'"+hname+"','"+htype+"',"+room+")";
            if (JOptionPane.showConfirmDialog(null,"Do you want to Save the Record?")==JOptionPane.YES_OPTION)
            {
              //execute the insert query of SQL
              stmt.executeUpdate(sqlstr);
              JOptionPane.showMessageDialog(null,"Record Saved Successfully !!!");
              ok.setEnabled(false);
              cancel.setText("Close");
              cancel.setToolTipText("Close");
            }
            con.close();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    if (ae.getSource()==cancel)
    	dispose();
   }//end of action performed event     
}
