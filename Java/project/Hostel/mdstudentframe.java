//creates frame for modifying/deleting students details

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class mdstudentframe extends JDialog implements ActionListener,ItemListener
{
	JButton ok,cancel;
	public JComboBox year,month,day;
	JTextField hno,roomno,lastname,firstname,midname,tel;
	//JTextField ddno,amount;
	JComboBox studno,sex,clas,course,bgroup;
	JTextArea address;
	boolean modify=true;
	mdstudentframe(JFrame parent,boolean flag)//true for modifying and false for deleting
	{
		//calls to JDialog class's constructor
		super(parent,"Modify/Delete Student Details",true);
		modify=flag;
		Container c = getContentPane();
		c.setLayout(null); 
		ok = new JButton("Ok");
		ok.setToolTipText("Modify Record");
		if(flag==false)
		  ok.setToolTipText("Delete Record");
		ok.setMnemonic('o');
		cancel = new JButton("Close");
		cancel.setToolTipText("Close");
		cancel.setMnemonic('c');
		
		JLabel l1=new JLabel("Student No.");
		studno=new JComboBox();
		//for getting student numbers from db
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select studno from student order by studno";
            ResultSet rs=stmt.executeQuery(sqlstr);   
            while(rs.next())
            {
            	//adds student numbers from database
               studno.addItem(rs.getString(1));
            }
            con.close();
		 }
        catch(Exception e)
        {
			   JOptionPane.showMessageDialog(null,e.getMessage());
    	}
		JLabel hlabel=new JLabel("Hostel Number");
        hno=new JTextField(3);
        hno.setEnabled(false);
        JLabel rlabel=new JLabel("Room Number");
        roomno=new JTextField(3);
        roomno.setEnabled(false);
		
		JLabel l2=new JLabel("Student Name");
		JLabel last=new JLabel("Last Name");
		JLabel first=new JLabel("First Name");
	    JLabel mid=new JLabel("Middle Name");
		lastname=new JTextField(20);
		firstname=new JTextField(20);
		midname=new JTextField(20);
		
		JLabel l3=new JLabel("Birth Date");
		JLabel dd=new JLabel("Day");
		JLabel mm=new JLabel("Month");
	    JLabel yy=new JLabel("Year");
		day=new JComboBox();
		for(int i=1;i<32;i++)
		  day.addItem(""+i+"");
		month=new JComboBox();
		month.addItem("January");
		month.addItem("February");
		month.addItem("March");
		month.addItem("April");
		month.addItem("May");
		month.addItem("June");
		month.addItem("July");
		month.addItem("August");
		month.addItem("September");
		month.addItem("October");
		month.addItem("November");
		month.addItem("December");
		year=new JComboBox();
		for(int i=1971;i<2101;i++)
		  year.addItem(""+i+"");
		JLabel sex1=new JLabel("Sex");
		sex=new JComboBox();
	    sex.setEnabled(false);
		JLabel addr=new JLabel("Address");
		address=new JTextArea();
		
		JLabel bgr=new JLabel("Blood Group");
		bgroup=new JComboBox();
		bgroup.addItem("A +ve");
		bgroup.addItem("A -ve");
		bgroup.addItem("B +ve");
		bgroup.addItem("B -ve");
		bgroup.addItem("AB +ve");
		bgroup.addItem("AB -ve");
		bgroup.addItem("O +ve");
		bgroup.addItem("O -ve");
		bgroup.addItem("NA");

        JLabel telephone=new JLabel("Telephone No.");
        tel=new JTextField(20);
        
        JLabel cls=new JLabel("Class");
        clas=new JComboBox();
        clas.setEnabled(false);
               
        JLabel crs=new JLabel("Course");
        course=new JComboBox();
        course.setEnabled(false);
        
        
		//set bounds(xth pos,yth pos,width,height)
		l1.setBounds(10,10,130,20);
		studno.setBounds(130,10,50,20);
		studno.setToolTipText("Student Number");
		
		hlabel.setBounds(210,10,120,20);
		hno.setBounds(306,10,50,20);
		hno.setToolTipText("Hostel Alloted");
		rlabel.setBounds(390,10,100,20);
		roomno.setBounds(480,10,50,20);
		roomno.setToolTipText("Room Alloted");
        
		last.setBounds(150,50,80,20);
		first.setBounds(290,50,80,20);
		mid.setBounds(430,50,80,20);
		l2.setBounds(10,60,100,30);
		lastname.setBounds(130,70,130,20);
		lastname.setToolTipText("Last Name");
		firstname.setBounds(270,70,130,20);
		firstname.setToolTipText("First Name");
		midname.setBounds(410,70,130,20);
		midname.setToolTipText("Middle Name");
		
		dd.setBounds(140,100,80,20);
		mm.setBounds(240,100,80,20);
		yy.setBounds(373,100,80,20);
		l3.setBounds(10,110,100,30);
		day.setBounds(130,120,50,20);
		year.setToolTipText("Select Year");
		month.setBounds(215,120,100,20);
		month.setToolTipText("Select Month");
		year.setBounds(350,120,80,20);
		day.setToolTipText("Select Day");
		
		sex1.setBounds(10,160,30,20);
		sex.setBounds(130,160,70,20);
		sex.setToolTipText("Select Gender");
				
		bgr.setBounds(10,190,90,20);
		bgroup.setBounds(130,190,70,20);
		bgroup.setToolTipText("Select Bloodgroup");
		
		telephone.setBounds(10,220,90,20);
		tel.setBounds(130,220,110,20);
		tel.setToolTipText("Enter telephone number");
		
		addr.setBounds(280,160,70,20);
		address.setBounds(350,160,280,80);
		address.setToolTipText("Enter address");
		
		cls.setBounds(10,250,50,20);
		clas.setBounds(130,250,100,20);
		clas.setToolTipText("Select Class");
		
		crs.setBounds(280,250,50,20);
		course.setBounds(350,250,180,20);
		course.setToolTipText("Select Course");
		
		ok.setBounds(250,340,60,30);
		cancel.setBounds(400,340,100,30);
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
			
		
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
	    cancel.addActionListener(this);
		year.addItemListener(this);
		month.addItemListener(this);
		studno.addItemListener(this);
		
		//disables all control if flag is for delete
        if(flag==false)
        {
          bgroup.setEnabled(false);
          year.setEnabled(false);
          month.setEnabled(false);
          day.setEnabled(false);
          address.setEnabled(false);
          lastname.setEnabled(false);
          midname.setEnabled(false);
          firstname.setEnabled(false);
          tel.setEnabled(false);
        }
        
        String stno=studno.getSelectedItem().toString();
    	int sno=Integer.parseInt(stno);
    	try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="Select * from student where studno="+sno;
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	lastname.setText(rs.getString(2));
            	firstname.setText(rs.getString(3));
            	midname.setText(rs.getString(4));
            	address.setText(rs.getString(5));
            	tel.setText(""+rs.getInt(6)+"");
            	day.setSelectedItem(""+rs.getInt(7)+"");
            	month.setSelectedItem(rs.getString(8));
            	year.setSelectedItem(""+rs.getInt(9)+"");
            	bgroup.setSelectedItem(rs.getString(10));
            	sex.removeAllItems();
            	sex.addItem(rs.getString(11));
            	clas.removeAllItems();
            	clas.addItem(rs.getString(12));
            	//get the course name from db
            	String sqlstr1="select cname from course where cno="+rs.getInt(13);
            	Statement stt=con.createStatement();
            	ResultSet rs1=stt.executeQuery(sqlstr1);
            	course.removeAllItems();
            	while(rs1.next())
            	{
            	  course.addItem(rs1.getString(1));
            	}
            	hno.setText(""+rs.getInt(14)+"");
            	roomno.setText(""+rs.getInt(15)+"");
            	break;
            }//end of while of displaying record
        }//end of try
        catch(Exception e)
     	{
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
		}
		c.add(ok);
		c.add(cancel);
		c.add(l1);
		c.add(studno);
		c.add(l2);
		c.add(last);
		c.add(first);
		c.add(mid);
		c.add(lastname);
		c.add(firstname);
		c.add(midname);
		c.add(dd);
		c.add(mm);
		c.add(yy);
		c.add(day);
		c.add(month);
		c.add(year);
		c.add(l3);
		c.add(sex1);
		c.add(sex);
		c.add(addr);
		c.add(address);
		c.add(tel);
		c.add(telephone);
		c.add(bgr);
		c.add(bgroup);
		c.add(cls);
		c.add(clas);
		c.add(crs);
		c.add(course);
		c.add(hlabel);
		c.add(hno);
		c.add(rlabel);
		c.add(roomno);
		setLocation(40,70);
		setSize(720,500);
        setVisible(true);
	}
	
	//handling events for modifying/deleting record
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
		        	//for checking validity of input in controls
		        	if(lastname.getText().equals(""))
		        	{
		        		JOptionPane.showMessageDialog(null,"Enter Last name","Error Message",JOptionPane.ERROR_MESSAGE);
		        		lastname.requestFocus(true);
		        		return;
		        	}
		        	for(int i=0;i<lastname.getText().length();i++)
		      		 {
		      		   	  char ch = lastname.getText().charAt(i);
						  if((ch>='A'&&ch<='Z') ||(ch>='a'&&ch<='z'))
							{
							}
						 else
						  {
						 	JOptionPane.showMessageDialog(null,"Enter Text For Last name","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							lastname.setText("");
							lastname.requestFocus();
							return;
						  } 
				      }
				      
		        	if(firstname.getText().equals(""))
		        	{
		        		JOptionPane.showMessageDialog(null,"Enter First name","Error Message",JOptionPane.ERROR_MESSAGE);
		        		firstname.requestFocus(true);
		        		return;
		        	}
		        	for(int i=0;i<firstname.getText().length();i++)
		      		 {
		      		   	  char ch = firstname.getText().charAt(i);
						  if((ch>='A'&&ch<='Z') ||(ch>='a'&&ch<='z'))
							{
							}
						 else
						  {
						 	JOptionPane.showMessageDialog(null,"Enter Text For First name","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							firstname.setText("");
							firstname.requestFocus();
							return;
						  } 
				      }
		        	if(midname.getText().equals(""))
		        	{
		        		JOptionPane.showMessageDialog(null,"Enter Middle name","Error Message",JOptionPane.ERROR_MESSAGE);
		        		midname.requestFocus(true);
		        		return;
		        	}
		        	for(int i=0;i<midname.getText().length();i++)
		      		 {
		      		   	  char ch = midname.getText().charAt(i);
						  if((ch>='A'&&ch<='Z') ||(ch>='a'&&ch<='z'))
							{
							}
						 else
						  {
						 	JOptionPane.showMessageDialog(null,"Enter Text For Middle name","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							midname.setText("");
							midname.requestFocus();
							return;
						  } 
				      }
		        	
		        	if(tel.getText().equals(""))
		      		   {
		      			  JOptionPane.showMessageDialog(null,"Enter Telephone Number","Error Message",JOptionPane.ERROR_MESSAGE);
		      			  tel.requestFocus(true);
							return;
		      		   }
		      		   //checking for numeric value of telephone number
		      		   for(int i=0;i<tel.getText().length();i++)
		      		   {
		      		   	  char ch = tel.getText().charAt(i);
						  if(ch>='0'&&ch<='9')
							{
							}
						 else
						  {
						 	JOptionPane.showMessageDialog(null,"Enter Numerical Value For Telephone Number","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							tel.setText("");
							tel.requestFocus();
							return;
						  } 
				      }
					if(address.getText().equals(""))
		        	{
		        		JOptionPane.showMessageDialog(null,"Enter Address","Error Message",JOptionPane.ERROR_MESSAGE);
		        		address.requestFocus(true);
		        		return;
		        	}
		        	
		        	//check whether user has entered '
					 for(int i=0;i<address.getText().length();i++)
		      		   {
		      		   	  char ch = address.getText().charAt(i);
						  if((ch==39))
						  {
								JOptionPane.showMessageDialog(null,"Don't  insert  '  character in Address field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								//address.setText("");
								address.requestFocus();
								return;
						  }
						 else
						  {
						 	
						  } 
				      }
		        		      
		        	String sno=tel.getText();
		        	int telno=Integer.parseInt(sno);
		        	
		        	sno=day.getSelectedItem().toString();
		        	int dd=Integer.parseInt(sno);
		        	
		        	sno=year.getSelectedItem().toString();
		        	int yy=Integer.parseInt(sno);
		       
		        	String sqlstr="Update Student set lastname='"+lastname.getText()+"',firstname='"+firstname.getText()+"',midname='"+midname.getText()+"',address='"+address.getText()+"',telephone="+telno+",dd="+dd+",mm='"+month.getSelectedItem().toString()+"',yy="+yy+",bgroup='"+bgroup.getSelectedItem().toString()+"' where studno="+Integer.parseInt(studno.getSelectedItem().toString());
		        	if (JOptionPane.showConfirmDialog(null,"Do you want to Modify the Record?")==JOptionPane.YES_OPTION)
		            {
		              //execute the update query of SQL
		              stmt.executeUpdate(sqlstr);
		              JOptionPane.showMessageDialog(null,"Record Modified Successfully !!!");
		              studno.requestFocus(true);
		           }  

       }//end if modify==true  (modify record)
       else //if modify ==false (delete record)
       {
       	//write code for deleting record
//       	String sqlstr="Delete from Student where studno="+Integer.parseInt(studno.getSelectedText().toString());
         if (JOptionPane.showConfirmDialog(null,"Do you want to Delete the Record?")==JOptionPane.YES_OPTION)
		    {
		       //execute the update query of SQL
		      // stmt.executeUpdate(sqlstr);
		       JOptionPane.showMessageDialog(null,"Record Deleted Successfully !!!");
		       studno.removeItem(studno.getSelectedItem());
		       studno.requestFocus(true);
		    }  
       }
       con.close();
    }//end of try
    catch(Exception e)
     {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
     }
    }//end of if (ae.getSource()==ok)
    
    if(ae.getSource()==cancel)
    	dispose();
   }
   
    //event handling for handling date input   
    public void itemStateChanged(ItemEvent ie)
    {
    	if(ie.getSource()==month || ie.getSource()==year)
    	{
    	boolean leap;
    	String dd=day.getSelectedItem().toString();
      	String yy=year.getSelectedItem().toString();
    	int y=Integer.parseInt(yy);
    	day.removeAllItems();
    	String mm= month.getSelectedItem().toString();
    	int m=0;
    	if (mm.equalsIgnoreCase("January"))
    	  m=1;
    	if (mm.equalsIgnoreCase("February"))
    	  m=2;
    	  if (mm.equalsIgnoreCase("March"))
    	  m=3;
    	if (mm.equalsIgnoreCase("April"))
    	  m=4;
    	if (mm.equalsIgnoreCase("May"))
    	  m=5;
    	if (mm.equalsIgnoreCase("June"))
    	  m=6;
    	if (mm.equalsIgnoreCase("July"))
    	  m=7;
    	if (mm.equalsIgnoreCase("August"))
    	  m=8;
    	if (mm.equalsIgnoreCase("September"))
    	  m=9;
    	if (mm.equalsIgnoreCase("October"))
    	  m=10;
    	if (mm.equalsIgnoreCase("November"))
    	  m=11;
    	if (mm.equalsIgnoreCase("December"))
    	  m=12;
    	
    	//check for leap year
    	if(y%4==0 && y%100!=0 || y%400==0)
    	   leap=true;
    	else
    	   leap=false;
    	   //adds days in combobox of day
    	  switch(m)
    	  {
    	  	case 1:case 3:case 5:case 7:case 8:case 10:case 12:
    	       for(int i=1;i<32;i++)
    	       day.addItem(""+i+"");	
    	       day.setSelectedItem(dd);
    	       break;
    	    case 4:case 6:case 9:case 11:   
    	    for(int i=1;i<31;i++)
    	       day.addItem(""+i+"");	
    	       if(dd.equalsIgnoreCase("31"))
    	         day.setSelectedItem("30");
    	       else
    	         day.setSelectedItem(dd);  
    	       break;
    	    case 2:
    	    	 //if leap year
		    	if(leap)
    			{
    	  			if (m==2)
    	   				for(int i=1;i<30;i++)
    	     				day.addItem(""+i+"");	
    	     		if (dd.equalsIgnoreCase("31") || dd.equalsIgnoreCase("30")||dd.equalsIgnoreCase("29"))
    	     		   day.setSelectedItem("29");
    	     		else
    	     		   day.setSelectedItem(dd);   		
    			}
    			else
    			{
    	    		for(int i=1;i<29;i++)   
    	      			day.addItem(""+i+"");
    	      		if (dd.equalsIgnoreCase("31") || dd.equalsIgnoreCase("30")||dd.equalsIgnoreCase("29"))
    	     		   day.setSelectedItem("28");
    	     		else
    	     		   day.setSelectedItem(dd);
    	      		break;
    	     	}
    	 }//end of switch
    }//end of if(ie.getSource()==month || ie.getSource()==year)
    
    if(ie.getSource()==studno)
    {
    	//write code for displaying student from data base
    	String stno=studno.getSelectedItem().toString();
    	int sno=Integer.parseInt(stno);
    	try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="Select * from student where studno="+sno;
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	lastname.setText(rs.getString(2));
            	firstname.setText(rs.getString(3));
            	midname.setText(rs.getString(4));
            	address.setText(rs.getString(5));
            	tel.setText(""+rs.getInt(6)+"");
            	day.setSelectedItem(""+rs.getInt(7)+"");
            	month.setSelectedItem(rs.getString(8));
            	year.setSelectedItem(""+rs.getInt(9)+"");
            	bgroup.setSelectedItem(rs.getString(10));
            	sex.removeAllItems();
            	sex.addItem(rs.getString(11));
            	clas.removeAllItems();
            	clas.addItem(rs.getString(12));
            	//get the course name from db
            	String sqlstr1="select cname from course where cno="+rs.getInt(13);
            	Statement stt=con.createStatement();
            	ResultSet rs1=stt.executeQuery(sqlstr1);
            	course.removeAllItems();
            	while(rs1.next())
            	{
            	  course.addItem(rs1.getString(1));
            	}
            	hno.setText(""+rs.getInt(14)+"");
            	roomno.setText(""+rs.getInt(15)+"");
            }//end of while of displaying record
        }//end of try
        catch(Exception e)
     	{
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
		}
    	
    }//end of if(ie.getSource()==studno)
    
  }//end of item switch event
}