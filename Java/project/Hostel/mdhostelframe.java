//createc frame for modifying/deleting hostel details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class mdhostelframe extends JDialog implements ActionListener,ItemListener
{
	JComboBox type,hno;
	JTextField name;
	JTextField totalroom;
	JButton ok,cancel;
	boolean modify;
    int firstroom=0;
     
	mdhostelframe(JFrame parent,boolean flag)
	{
		super(parent,"Modify/Delete Hostel Details",true);
		modify=flag;
		//for displaying hostel number in the textfield of hostel number
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            
	        Container c = getContentPane();
			c.setLayout(null);
			 
			JLabel hosno=new JLabel("Hostel Number");
			hno= new JComboBox();
					
			JLabel hostype=new JLabel("Hostel Type");
			type=new JComboBox();
			type.addItem("Gents");
			type.addItem("Ladies");
				
			JLabel hosname=new JLabel("Hostel Name");
			name=new JTextField(20);
			
			ok = new JButton("Ok");
			ok.setToolTipText("Modify Record");
			if(flag==false)
			  ok.setToolTipText("Delete Record");
			ok.setMnemonic('o');
			cancel = new JButton("Close");
			cancel.setToolTipText("Close");
			cancel.setMnemonic('c');
			ok.setForeground(Color.blue);
			cancel.setForeground(Color.red);
			
			JLabel total=new JLabel("Total Rooms");
			totalroom=new JTextField(20);
			
			//set bounds(xth pos,yth pos,width,height)
			hosno.setBounds(40,30,100,20);
			hno.setBounds(140,30,100,20);
			hno.setToolTipText("Hostel Number");
			hostype.setBounds(40,60,100,20);
			type.setBounds(140,60,100,20);
			type.setToolTipText("Hostel Type");
			hosname.setBounds(40,90,80,20);
			name.setBounds(140,90,220,20);
			name.setToolTipText("Hostel Name");
			ok.setBounds(100,160,60,30);
			cancel.setBounds(200,160,100,30);
			total.setBounds(40,120,220,20);
			totalroom.setBounds(140,120,120,20);
			totalroom.setToolTipText("Total Rooms in Hostel");
			
            String sqlstr="select hno from hostel order by hno";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
             {
                hno.addItem(""+rs.getInt(1)+"");
             }
			if(flag==false)
			{
				type.setEnabled(false);
				name.setEnabled(false);
				totalroom.setEnabled(false);
			}
			sqlstr="select * from hostel order by hno";
			rs=stmt.executeQuery(sqlstr);
			while(rs.next())
			{
				name.setText(rs.getString(2));
			    type.setSelectedItem(rs.getString(3));
			    totalroom.setText(""+rs.getInt(4)+"");
			    firstroom=Integer.parseInt(totalroom.getText());
				break;
			}
			
			//first add event listener to the control and then add it to the container
			ok.addActionListener(this);
			cancel.addActionListener(this);
			hno.addItemListener(this);
			
			c.add(ok);
			c.add(cancel);
			c.add(hosno);
			c.add(hno);
			c.add(hostype);
			c.add(type);
			c.add(hosname);
			c.add(name);
			c.add(total);
			c.add(totalroom);
			setLocation(200,160);
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
	
	//handling events
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
			        }//end of for
			        String sqlstr="Update hostel set htype='"+type.getSelectedItem().toString()+"',hname='"+name.getText()+"',total_rooms="+Integer.parseInt(totalroom.getText()) +" where hno="+Integer.parseInt(hno.getSelectedItem().toString());
		            if (JOptionPane.showConfirmDialog(null,"Do you want to Modify the Record?")==JOptionPane.YES_OPTION)
			        {
    			        	//check whether any room allocated to student
 			        		String sqlstr1="select * from student where hno="+Integer.parseInt(hno.getSelectedItem().toString());
				        	ResultSet rs1=stmt.executeQuery(sqlstr1);
				        	boolean allot=false;
				        	while(rs1.next())
				        	{
				        		allot=true;
				        		break;
				        	}//end of while(rs1.next())
				        	
				        	//check whether user is to modify the type of the hostel from gents to ladies or vice versa
				        	if(allot==true)
				        	{
						        	String sqlstr2="select htype from hostel where hno="+Integer.parseInt(hno.getSelectedItem().toString());
						        	ResultSet rs2=stmt.executeQuery(sqlstr2);
						        	while(rs2.next())
						        	{
						        		String htype=rs2.getString(1);
							        	if(!type.getSelectedItem().toString().equals(htype))
							        	{
							        	  JOptionPane.showMessageDialog(null,"Can't Modify Hostel Type ! Hostel alloted to one or more students.");
							        	  type.setSelectedItem(htype);
							              hno.requestFocus(true);
							        	  return;
							            }
						             }//end of while(rs2.next())				                
				             }
				             
				            //check whether total rooms are reduced and that room numbers are alloted to student  
				        	sqlstr1="select max(rno) from student where hno="+Integer.parseInt(hno.getSelectedItem().toString());
				        	rs1=stmt.executeQuery(sqlstr1);
				        	while(rs1.next())
				        	{
				        		int room1=rs1.getInt(1);//get max room number
				        		int room2=Integer.parseInt(totalroom.getText());
				        		if(room1>room2)//if max room greater than new rooms
				        		{
				        			JOptionPane.showMessageDialog(null,"Can't Reduced Total Rooms ! Rooms alloted to one or more students upto Room No.: "+room1);
				        			totalroom.setText(""+firstroom+"");
				        	    	hno.requestFocus(true);
				        			return;
				        		}
				        	}
			             //execute the update query of SQL
			              stmt.executeUpdate(sqlstr);
			              firstroom=Integer.parseInt(totalroom.getText());
			              JOptionPane.showMessageDialog(null,"Record Modified Successfully !!!");
			              hno.requestFocus(true);
			        }//end of "Do you want to modify"
			   } //end of if(modify==true)
			   
			   else
			   
			   if(modify==false)//if delelte
  	 		{
			 	String sqlstr="Delete from hostel where hno="+Integer.parseInt(hno.getSelectedItem().toString());;
			    if (JOptionPane.showConfirmDialog(null,"Do you want to Delete Record?")==JOptionPane.YES_OPTION)
		        {
		        	String sqlstr1="select * from student where hno="+Integer.parseInt(hno.getSelectedItem().toString());
		        	ResultSet rs1=stmt.executeQuery(sqlstr1);
		        	while(rs1.next())
		        	{
		        		JOptionPane.showMessageDialog(null,"Can't delete ! Hostel alloted to one or more students.");
		        	    hno.requestFocus(true);
		        		return;
		        	}
	               //execute the update query of SQL
					stmt.executeUpdate(sqlstr);
			        hno.removeItem(hno.getSelectedItem());
			        //if there are no any complaints 
					if(hno.getItemCount()==0)
			      		ok.setEnabled(false);
			      	else
			          hno.setSelectedIndex(0);
			          JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!!");
			          hno.requestFocus(true);
			      }
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
   
   public void itemStateChanged(ItemEvent ie)
    {
      try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from hostel where hno="+Integer.parseInt(hno.getSelectedItem().toString());
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
			{
				name.setText(rs.getString(2));
			    type.setSelectedItem(rs.getString(3));
			    totalroom.setText(""+rs.getInt(4)+"");
			}
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
    }
    
}
