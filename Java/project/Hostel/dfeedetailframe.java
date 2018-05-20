//creates frame for deleting fee details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class dfeedetailframe extends JDialog implements ActionListener,ItemListener
{
	JButton ok,cancel;
	JComboBox feeno;
	JTextField ddno,amt,studno;
	dfeedetailframe(JFrame parent)
	{
		super(parent,"Delete Fee Details",true);
		Container c=getContentPane();
		c.setLayout(null);
		JLabel stno,dno,amtl,fee;
		
		stno=new JLabel("Student Number");
	    fee=new JLabel("Fee Number");
		dno=new  JLabel("D.D. Number");
		amtl=new  JLabel("Amount (in Rs.)");
		
		feeno=new JComboBox();
		ddno=new JTextField();
		amt=new JTextField();
		studno=new JTextField();
		studno.setEnabled(false);
		ddno.setEnabled(false);
		amt.setEnabled(false);
		
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Close");
		cancel.setMnemonic('c');

        feeno.setToolTipText("Student Number");
        studno.setToolTipText("Student Number");
        ddno.setToolTipText("D.D. Number");
        amt.setToolTipText("Amount (in Rs.)");
        ok.setToolTipText("Delete Record");
        cancel.setToolTipText("Cancel");
        
        fee.setBounds(240,30,90,20);
        feeno.setBounds(320,30,60,20);
        stno.setBounds(50,70,100,20);
        studno.setBounds(160,70,60,20);
        dno.setBounds(50,110,100,20);
        ddno.setBounds(160,110,100,20);
        amtl.setBounds(50,150,100,20);
        amt.setBounds(160,150,70,20);
        ok.setBounds(90,220,50,30);
        cancel.setBounds(200,220,90,30);
        ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
        
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select feeno from admission order by feeno";
            ResultSet rs=stmt.executeQuery(sqlstr);
            //add student numbers from db
            while(rs.next())
            {
            	feeno.addItem(""+rs.getInt(1)+"");
            }         
            
            sqlstr="select * from admission order by feeno";
            rs=stmt.executeQuery(sqlstr);
            //add from db
            while(rs.next())
			{
				studno.setText(""+rs.getString(2)+"");
			    ddno.setText(rs.getString(3));
			    amt.setText(""+rs.getInt(4)+"");
				break;
			}
         }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        feeno.addItemListener(this);
 		c.add(stno);
 		c.add(studno);
		c.add(dno);
		c.add(amtl);
		c.add(ok);
		c.add(cancel);
		c.add(fee);
		c.add(feeno);
		c.add(ddno);
		c.add(amt);
		setLocation(140,110);
		setSize(400,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
		      	try
		        {
		        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        	String dsn="jdbc:odbc:hostel";
		        	Connection con=DriverManager.getConnection(dsn,null,null);
		            con.setAutoCommit(true);
		            Statement stmt = con.createStatement();

		        	String sqlstr="Delete from admission where feeno="+Integer.parseInt(feeno.getSelectedItem().toString());
		        	if (JOptionPane.showConfirmDialog(null,"Do you want to Delete the Record?")==JOptionPane.YES_OPTION)
		            {
		                 //delete from admission table
		                 stmt.executeUpdate(sqlstr);
		                 feeno.removeItem(feeno.getSelectedItem());
		        		//if there are no any complaints 
						if(feeno.getItemCount()==0)
		      				ok.setEnabled(false);
		      			else
		          			feeno.setSelectedIndex(0);
		                 JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!!");
		                 feeno.requestFocus(true);
		            }
		            con.close();
		        }
		        catch(Exception e)
		        {
		        	System.out.println(e.getMessage());
		        	JOptionPane.showMessageDialog(null,e.getMessage());
		        }
	}//end of if "ok"
	
		if(ae.getSource()==cancel)
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
				String sqlstr="select * from admission where feeno="+Integer.parseInt(feeno.getSelectedItem().toString());
	            ResultSet rs=stmt.executeQuery(sqlstr);
	            //display from db
	            while(rs.next())
				{
					studno.setText(""+rs.getString(2)+"");
				    ddno.setText(rs.getString(3));
				    amt.setText(""+rs.getInt(4)+"");
					break;
				}
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null,e.getMessage());
	        }//end of catch
	    }
}