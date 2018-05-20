//creates frame for modifying/deleting course details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class mdcourseframe extends JDialog implements ActionListener,ItemListener
{ 
    JTextField cname;
    JComboBox cno,clname;
    JButton ok,cancel;
    boolean modify;
	mdcourseframe(JFrame parent,boolean flag)
	{
		super(parent,"Modify/Delete Course Details",true);
		modify=flag;
		//for displaying course details from db
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            
			Container c = getContentPane();
			c.setLayout(null);
			 
			JLabel lcno=new JLabel("Course Number");
			cno= new JComboBox();
			
			JLabel name=new JLabel("Course Name");
			cname=new JTextField(20);
			cname.setEnabled(false);
					
			JLabel name2=new JLabel("College Name");
			clname=new JComboBox();
			clname.addItem("Nowrosjee Wadia College");
			clname.addItem("Ness Wadia College");
			clname.addItem("Cusrow Wadia College");
			clname.addItem("Neville Wadia College");
			
		    ok = new JButton("Ok");
			ok.setToolTipText("Modify Record");
			if(flag==false)
			  ok.setToolTipText("Delete Record");
			ok.setMnemonic('o');
			cancel = new JButton("Close");
			cancel.setToolTipText("Close");
			cancel.setMnemonic('c');

            String sqlstr="select cno from course order by cno";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	//get the course number from database
            	cno.addItem(""+rs.getInt(1)+"");
            }
            
			//set bounds(xth pos,yth pos,width,height)
			lcno.setBounds(40,30,100,20);
			cno.setBounds(140,30,100,20);
			cno.setToolTipText("Course Number");
			
			name.setBounds(40,60,100,20);
			cname.setBounds(140,60,220,20);//textfield
			cname.setToolTipText("Course Name");
			
			name2.setBounds(40,90,80,20);
			clname.setBounds(140,90,220,20);//combobox 
			clname.setToolTipText("College Name");
			
			ok.setBounds(100,140,60,30);
			cancel.setBounds(200,140,100,30);
			ok.setForeground(Color.blue);
			cancel.setForeground(Color.red);
			
			if(flag==false)
			{
				clname.setEnabled(false);
			}
			sqlstr="select * from course order by cno";
			rs=stmt.executeQuery(sqlstr);
			while(rs.next())
			{
				cname.setText(rs.getString(2));
			    clname.setSelectedItem(rs.getString(3));
				break;
			}
			
			//first add event listener to the control and then add it to the container
			ok.addActionListener(this);
		    cancel.addActionListener(this);
		    cno.addItemListener(this);

			c.add(ok);
			c.add(cancel);
			c.add(lcno);
			c.add(cno);
			c.add(name);
			c.add(cname);
			c.add(name2);
			c.add(clname);
			setLocation(220,140);
			setSize(450,250);
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
            
            if(modify==true)//if modify option
            {	      	
	            String sqlstr="Update course set college='"+clname.getSelectedItem().toString()+"' where cno="+Integer.parseInt(cno.getSelectedItem().toString());
	            if (JOptionPane.showConfirmDialog(null,"Do you want to Modify the Record?")==JOptionPane.YES_OPTION)
		        {
		             //execute the update query of SQL
		              stmt.executeUpdate(sqlstr);
		              JOptionPane.showMessageDialog(null,"Record Modified Successfully !!!");
		              cno.requestFocus(true);
		        }
		    }
		    else
		if(modify==false)//if delelte
		{
		 	String sqlstr="Delete from Course where cno="+Integer.parseInt(cno.getSelectedItem().toString());;
		    if (JOptionPane.showConfirmDialog(null,"Do you want to Delete Record?")==JOptionPane.YES_OPTION)
	        {
	        	String sqlstr1="select * from student where cno="+Integer.parseInt(cno.getSelectedItem().toString());
	        	ResultSet rs1=stmt.executeQuery(sqlstr1);
	        	while(rs1.next())
	        	{
	        		JOptionPane.showMessageDialog(null,"Can't delete ! Course alloted to one or more students.");
	        	    cno.requestFocus(true);
	        		return;
	        	}
               //execute the update query of SQL
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
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
      }//end of if "ok"
         if (ae.getSource()==cancel)
        	dispose();
    }
    
    public void itemStateChanged(ItemEvent ie)
    {
      try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from course where cno="+Integer.parseInt(cno.getSelectedItem().toString());
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
			{
				cname.setText(rs.getString(2));
				clname.setSelectedItem(rs.getString(3));
			}
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
    }

}
