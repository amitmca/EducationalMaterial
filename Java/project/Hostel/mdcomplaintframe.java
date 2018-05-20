//creates frame for modofying/deleting student's complaints

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class mdcomplaintframe extends JDialog implements ActionListener,ItemListener
{
	JButton ok,cancel; 
	JComboBox studno,cno;
	JTextArea description;
	boolean modify;
	mdcomplaintframe(JFrame parent,boolean flag)
	{
		super(parent,"Modify/Delete Student Complaints",true);
        modify=flag;
	    Container c = getContentPane();
		c.setLayout(null);
		
		JLabel cno1=new JLabel("Complaint Number");
		cno= new JComboBox();
	    try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select compno from complaint order by compno";
            ResultSet rs=stmt.executeQuery(sqlstr);
             while(rs.next())
             {
             	//add complaint numbers from db
                cno.addItem(""+rs.getInt(1)+"");
              }
			JLabel stud=new JLabel("Student Number");
			studno=new JComboBox();
			studno.setEnabled(false);
	
			JLabel desc=new JLabel("Description");
			description=new JTextArea();
					
			ok = new JButton("Ok");
			ok.setToolTipText("Modify Record");
			if(flag==false)
			  ok.setToolTipText("Delete Record");
			ok.setMnemonic('o');
			cancel = new JButton("Close");
			cancel.setToolTipText("Close");
			cancel.setMnemonic('c');
			
			//set bounds(xth pos,yth pos,width,height)
			cno1.setBounds(20,30,120,20);
			cno.setBounds(150,30,80,20);
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
			cno.addItemListener(this);
			
			if(flag==false)//if delete option
			{
				description.setEnabled(false);
			}
			
			sqlstr="select * from complaint order by compno";
			rs=stmt.executeQuery(sqlstr);
			while(rs.next())
			{
				studno.addItem(""+rs.getInt(2)+"");
				description.setText(rs.getString(3));
				break;
			}
			if(studno.getItemCount()==0)
			{
				ok.setEnabled(false);
			}
			
		c.add(ok);
		c.add(cancel);
		c.add(cno1);
		c.add(cno);
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
		    try
            {
		       	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       	String dsn="jdbc:odbc:hostel";
		       	Connection con=DriverManager.getConnection(dsn,null,null);
		        con.setAutoCommit(true);
		        Statement stmt = con.createStatement();
		        
		       if(modify==true)//if option is to modify
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
								JOptionPane.showMessageDialog(null,"Don't  insert   '   character in Description field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								//description.setText("");
								description.requestFocus();
								return;
						  }
						 else
						  {
						  } 
				      }
		            String cno1=cno.getSelectedItem().toString();
		            int cnumber=Integer.parseInt(cno1);
		            String desc = description.getText();
		            String sno1=studno.getSelectedItem().toString();
		            int sno=Integer.parseInt(sno1);
		            String sqlstr="Update Complaint set details='"+desc+"' where compno="+cnumber;
		            if (JOptionPane.showConfirmDialog(null,"Do you want to Modify the Record?")==JOptionPane.YES_OPTION)
		            {
		              //execute the insert query of SQL
		              stmt.executeUpdate(sqlstr);
		              JOptionPane.showMessageDialog(null,"Record Modified Successfully !!!");
		             cno.requestFocus(true);
		            }
		       }//end of if(modify==true)
		       
		       else
				if(modify==false)//if delete
				{
  				  String sqlstr="Delete from Complaint where compno="+Integer.parseInt(cno.getSelectedItem().toString());;
		          if (JOptionPane.showConfirmDialog(null,"Do you want to Delete Record?")==JOptionPane.YES_OPTION)
		          {
		              //execute the insert query of SQL
		              stmt.executeUpdate(sqlstr);
		              cno.removeItem(cno.getSelectedItem());
		              //if there are no any complaints 
					if(cno.getItemCount()==0)
		      			ok.setEnabled(false);
		      		else
		              cno.setSelectedIndex(0);
		            JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!!");
		            cno.requestFocus(true);
		          }
				}
			   con.close();
			}//end of try
            catch(Exception e)
	       {
		        	System.out.println(e.getMessage());
    	        	JOptionPane.showMessageDialog(null,e.getMessage());
	       }
	 }//end of if ok
	 
     if (ae.getSource()==cancel)
        	dispose();
   } //end of action listener
   
   public void itemStateChanged(ItemEvent ie)
   {
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from complaint where compno="+Integer.parseInt(cno.getSelectedItem().toString());
			ResultSet rs=stmt.executeQuery(sqlstr);
			studno.removeAllItems();
			while(rs.next())
			{
				studno.addItem(""+rs.getInt(2)+"");
				description.setText(rs.getString(3));
			}
       }
       catch(Exception e)
         {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
         }
  }
}
