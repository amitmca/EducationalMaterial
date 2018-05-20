//creates frame for accessing course details
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class courseframe extends JDialog implements ActionListener
{ 
    int count=1;
    JTextField cname;
    JTextField no;
    JComboBox cname2;
    JButton ok,cancel;
	courseframe(JFrame parent)
	{
		super(parent,"Course Details",true);
		//for displaying course number in the textfield of course number
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select max(cno) from course";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	//get the last course number from database
               count=rs.getInt(1);
            }
            con.close();
            count++;
        Container c = getContentPane();
		c.setLayout(null);
		 
		JLabel cno=new JLabel("Course Number");
		cno.setForeground(Color.blue);
		no= new JTextField(5);
		no.setEnabled(false);
		no.setText(""+ count +"");
		
		JLabel name=new JLabel("Course Name");
		name.setForeground(Color.red);
		cname=new JTextField(20);
				
		JLabel name2=new JLabel("College Name");
		cname2=new JComboBox();
		cname2.addItem("Nowrosjee Wadia College");
		cname2.addItem("Ness Wadia College");
		cname2.addItem("Cusrow Wadia College");
		cname2.addItem("Neville Wadia College");
		
	    ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Cancel");
		cancel.setMnemonic('c');
		
		//set bounds(xth pos,yth pos,width,height)
		cno.setBounds(40,30,100,20);
		no.setBounds(140,30,100,20);
		no.setToolTipText("Course Number");
		name.setBounds(40,60,100,20);
		cname.setBounds(140,60,220,20);//textfield
		cname.setToolTipText("Course Name");
		name2.setBounds(40,90,80,20);
		cname2.setBounds(140,90,220,20);//combobox 
		cname2.setToolTipText("College Name");
		ok.setBounds(100,140,60,30);
		ok.setToolTipText("Save Record");
		cancel.setBounds(200,140,100,30);
		cancel.setToolTipText("Cancel");
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
		
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
	    cancel.addActionListener(this);
		
		c.add(ok);
		c.add(cancel);
		c.add(cno);
		c.add(no);
		c.add(name);
		c.add(cname);
		c.add(name2);
		c.add(cname2);
		setLocation(220,140);
		setSize(450,250);
        setVisible(true);
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }
	
	}
	
      public void actionPerformed(ActionEvent ae)
      {
      	 int already=0;
      	if (ae.getSource()==ok)
      	{
      		if(cname.getText().equals(""))
      		{
      			JOptionPane.showMessageDialog(null,"Enter Course name","Error Message",JOptionPane.ERROR_MESSAGE);
      			cname.requestFocus(true);
      			return;
      		}
      		
      		//check whether user has entered '
			 for(int i=0;i<cname.getText().length();i++)
      		   {
      		   	  char ch = cname.getText().charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't  insert  '  character in course name field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						//cname.setText("");
						cname.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
      	try 
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            //get the fields from control
            String cno1=no.getText();
            int cno=Integer.parseInt(cno1);
            String crs = cname.getText();
            String col=cname2.getSelectedItem().toString();
            
            String sqlstr="Select * from course";
            ResultSet rs = stmt.executeQuery(sqlstr);
           
            while(rs.next())
            {   //check whether course name already exist in database
            	if(rs.getString(2).equalsIgnoreCase(crs))
            	{
            	  JOptionPane.showMessageDialog(null,"Course name already exist in database");
            	  already=1;
            	  cname.setText("");
            	  cname.requestFocus();
            	  break;
            	 }
            }
            if(already==0)
            {
	            sqlstr="insert into course values (" + cno+",'"+crs+"','"+col+"');";
	            int sts=JOptionPane.showConfirmDialog(null,"Do you want to Save the Record?");
	            if (sts==0)//if JOptionPane.YES_OPTION
	            {
	            //execute the insert query of SQL
	              stmt.executeUpdate(sqlstr);
	              JOptionPane.showMessageDialog(null,"Record Saved Successfully !!!");
	              ok.setEnabled(false);
	              cname.setEditable(false);
	              cancel.setText("Close");
	              cancel.setToolTipText("Close");
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
}
