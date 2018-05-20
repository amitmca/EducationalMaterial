//creates frame for accessing student's complaints

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class complaintframe extends JDialog implements ActionListener
{
	JButton ok,cancel; 
	JTextField no;
	JComboBox studno;
	TextArea description;
	complaintframe(JFrame parent)
	{
		super(parent,"Student Complaints",true);
	    try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select max(compno) from complaint";
            ResultSet rs=stmt.executeQuery(sqlstr);
            int count=1;
           while(rs.next())
            {
            	//get the next number from database
                 count=rs.getInt(1);
            }
        count++;
	    Container c = getContentPane();
		c.setLayout(null);
		
		JLabel cno=new JLabel("Complaint Number");
		cno.setForeground(Color.blue);
		no= new JTextField(5);
		no.setToolTipText("Complaint Number");
		no.setText(""+count+"");
		no.setEnabled(false);
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		ok.setToolTipText("Save Record");
		cancel=new JButton("Cancel");
		cancel.setMnemonic('c');
		cancel.setToolTipText("Cancel");
		JLabel stud=new JLabel("Student Number");
		studno=new JComboBox();
		studno.setToolTipText("Select Student Number");
		//ADD STUDENT NUMBERS FROM DATABASE
		 sqlstr="select studno from student order by studno";
         rs=stmt.executeQuery(sqlstr);
         while(rs.next())
        {
        	studno.addItem(""+rs.getInt(1)+"");
	    }
		if(studno.getItemCount()==0)
		{
			ok.setEnabled(false);
		}
		JLabel desc=new JLabel("Description");
		description=new TextArea();
		
		//set bounds(xth pos,yth pos,width,height)
		cno.setBounds(20,30,120,20);
		no.setBounds(150,30,80,20);
		stud.setBounds(300,30,100,20);
		studno.setBounds(450,30,80,20);//textfield
		desc.setBounds(20,90,80,20);
		description.setBounds(110,90,340,220);//text area
		ok.setBounds(230,340,60,30);
		cancel.setBounds(350,340,90,30);
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		c.add(ok);
		c.add(cancel);
		c.add(cno);
		c.add(no);
		c.add(stud);
		c.add(studno);
		c.add(desc);
		c.add(description);
		setLocation(100,100);
		setSize(550,420);
		setVisible(true);
		con.close();
		}
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }
	}	
	
	public void actionPerformed(ActionEvent ae)
    {
    	if (ae.getSource()==ok)
      	{
      		if(description.getText().equals(""))
      		{
      		  JOptionPane.showMessageDialog(null,"Enter the Complaint Description","Error Message",JOptionPane.ERROR_MESSAGE);
      		  description.requestFocus();
              return;
      		}
      		//check whether user has entered '
			 for(int i=0;i<description.getText().length();i++)
      		   {
      		   	  char ch = description.getText().charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't  insert  '   character in Description field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						//description.setText("");
						description.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
            
			if(studno.getItemCount()==0)
      		{
      			JOptionPane.showMessageDialog(null,"Select the Student Number","Error Message",JOptionPane.ERROR_MESSAGE);
      			studno.requestFocus(true);
      			return;
      		}
	      	try
	        {
	        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        	String dsn="jdbc:odbc:hostel";
	        	Connection con=DriverManager.getConnection(dsn,null,null);
	            con.setAutoCommit(true);
	            Statement stmt = con.createStatement();
	            String cno1=no.getText();
	            int cno=Integer.parseInt(cno1);
	            String desc = description.getText();
	            String sno1=studno.getSelectedItem().toString();
	            int sno=Integer.parseInt(sno1);
	            String sqlstr="Insert Into complaint values (" + cno+","+sno+",'"+desc+"')";
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
   }
}
