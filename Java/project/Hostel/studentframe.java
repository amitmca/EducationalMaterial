import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;


//creates frame for accessing students details
class studentframe extends JDialog implements ActionListener,ItemListener
{
	JButton ok,cancel;
	public JComboBox year,month,day;
	JTextField hno,roomno,ddno,amount,studno,lastname,firstname,midname,tel;
	JComboBox sex,clas,course,bgroup;
	JTextArea address;
	studentframe(JFrame parent)
	{
		//calls to JDialog class's constructor
		super(parent,"Student Details",true);
		 int count=1;
		//for getting next student number
		 try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select max(studno) from student";
            ResultSet rs=stmt.executeQuery(sqlstr);   
            while(rs.next())
            {
            	//get the last student number from database
               count=rs.getInt(1);
            }
            con.close();
		 }
        catch(Exception e)
        {
			   JOptionPane.showMessageDialog(null,e.getMessage());
        }
        count++;
		Container c = getContentPane();
		c.setLayout(null); 
		ok = new JButton("Ok");
		ok.setToolTipText("Save Record");
		ok.setMnemonic('o');
		cancel = new JButton("Cancel");
		cancel.setToolTipText("Cancel");
		cancel.setMnemonic('c');
		
		JLabel l1=new JLabel("Student No.");
		l1.setForeground(Color.blue);
		studno=new JTextField(5);
		studno.setForeground(Color.blue);
		studno.setEnabled(false);
		studno.setText(""+count+"");

		
		JLabel hlabel=new JLabel("Hostel Number");
		hlabel.setForeground(Color.blue);
        hno=new JTextField(3);
        hno.setForeground(Color.blue);
        hno.setEnabled(false);
        JLabel rlabel=new JLabel("Room Number");
        rlabel.setForeground(Color.blue);
        roomno=new JTextField(3);
        roomno.setForeground(Color.blue);
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
		sex1.setForeground(Color.red);
		sex=new JComboBox();
		sex.addItem("Male");
		sex.addItem("Female");
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
        cls.setForeground(Color.red);
        clas=new JComboBox();
        clas.addItem("F.Y.J.C.");
        clas.addItem("S.Y.J.C.");
        clas.addItem("F.Y.");
        clas.addItem("S.Y.");
        clas.addItem("T.Y.");
        clas.addItem("PART-I");
        clas.addItem("PART-II");
        clas.addItem("F.E.");
        clas.addItem("S.E.");
        clas.addItem("T.E.");
        clas.addItem("B.E.");
        
        JLabel crs=new JLabel("Course");
        crs.setForeground(Color.red);
        course=new JComboBox();
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from course";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	//adds in combobox of course from database
              	course.addItem(rs.getString(2));
            }
            con.close();
        }
        catch(Exception e)
        {
			   JOptionPane.showMessageDialog(null,e.getMessage());
        }
         JLabel ddlabel=new JLabel("D.D. Number");
         ddlabel.setForeground(Color.red);
         ddno=new JTextField(3);
         JLabel amtlabel=new JLabel("Total Amount (in Rs.)");
         amtlabel.setForeground(Color.red);
         amount=new JTextField(3);
                
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
		
	
		ddlabel.setBounds(10,320,70,20);
		ddno.setBounds(130,320,150,20);
		ddno.setToolTipText("Enter D.D. Number");
		amtlabel.setBounds(300,320,130,20);
		amount.setBounds(430,320,70,20);
		amount.setToolTipText("Enter D.D. Amount in Rupees");

		ok.setBounds(250,400,60,30);
		ok.setForeground(Color.blue);
		cancel.setBounds(400,400,100,30);
		cancel.setForeground(Color.red);
		
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
	    cancel.addActionListener(this);
		year.addItemListener(this);
		month.addItemListener(this);
		
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
		c.add(ddlabel);
		c.add(ddno);
		c.add(amtlabel);
		c.add(amount);
		setLocation(40,70);
		setSize(720,500);
        setVisible(true);
	}
	
	//handling events
    public void actionPerformed(ActionEvent ae)
    {
      if (ae.getSource()==ok)
      {
      	int cno=0;//course number
      	int hnumber=0;//hostel number
      	int hcap=0;//hostel capacity
      	boolean allot=false;
      	try
        { 
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            //course name
            String cname=course.getSelectedItem().toString();
            String sqlstr="select cno from course where cname='"+cname+"';";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	//get the course number from course table
            	cno=rs.getInt(1);
            }
            //check for Boy or Girl for alloting the hostel(Gents or Ladies)
            String sextype=sex.getSelectedItem().toString();
            if (sextype.equalsIgnoreCase("Male"))
              sqlstr="select * from hostel where htype='Gents' order by hno;";
            else
              sqlstr="select * from hostel where htype='Ladies'  order by hno;";  
            rs=stmt.executeQuery(sqlstr);
            
 //code started for allocating room to student
    
       //get the hostel number and capacity of hostel
        while(rs.next())
        {
            	
             hnumber=rs.getInt(1);
             hcap=rs.getInt(4);
             //get total rooms alloted of the particular hostel
             sqlstr="Select count(rno) from student where hno="+hnumber+";";
             Statement stmt1 = con.createStatement();
             ResultSet room=stmt1.executeQuery(sqlstr);
           	 int roomremains=0;
           	   while(room.next())
              	{
            		//get total rooms alloted
            		int allotrooms=room.getInt(1);
            		//get total rooms remained
            	 	roomremains=hcap*2-allotrooms;//there are 2 students in 1 room
            	}
           	  //if room remains
           	 if(roomremains>0)
              {
            	//get the room number for the student from the same class
            	sqlstr="select rno from student where class='"+clas.getSelectedItem().toString()+"' and cno="+cno+"and hno=" + hnumber+";";
            	room=stmt1.executeQuery(sqlstr);
            	//there is only one room of the same class student
                 while(room.next())
            	 {
            	 	  int roomnumber=room.getInt(1);
            		  //get the total students live in particular room
            		  String sqlstr1="select count(rno) from student where rno="+roomnumber+"and hno=" + hnumber+";";
            		  Statement stmt2 = con.createStatement();
            		  ResultSet rs1=stmt2.executeQuery(sqlstr1);
            		  int total=0;
            	 	  while(rs1.next())
                 	  {
            			total=rs1.getInt(1);
            		  }
                	  if(total!=2)//if there is one place for a student
                	  {
                		 roomno.setText(""+roomnumber+"");//roomnumber combobox
            			 hno.setText(""+hnumber+"");//hostel number combobox
            			 allot=true;
            			 break;
            		  } //end of aloocating same room of same class
            		   if (allot)
           			         break;
            	 }//end of room check of same class(while loop)
            			
            	//for allocating next room in hostel if there is no room of same class student
            	  if(allot==false)
            	  {
            	 	 sqlstr="select max(rno) from student where hno="+hnumber+""; 
            	  	 Statement stmt2=con.createStatement();
            	  	 ResultSet	rs1=stmt2.executeQuery(sqlstr);
            	  	 int roomnumber1=0;
            	  	 while(rs1.next())
            	  	 {
            			 roomnumber1=rs1.getInt(1)+1;
            		  }
            		  //for checking whether is there any empty room in between
            	     for(int i=1;i<roomnumber1;i++)
            	     {
            	     	sqlstr="Select count(rno) from student where hno="+hnumber+"and rno="+i;
            	     	rs1=stmt2.executeQuery(sqlstr);
            	     	int count=2;
            	     	while(rs1.next())
            	     	{
            	     		//get room count from db
            	     		count=rs1.getInt(1);
            	     	}
            	     	if(count==0)
            	     	{
            	     		//allocate this empty room to student
            	     		roomno.setText(""+i+"");//roomnumber combobox
            	    		hno.setText(""+hnumber+"");//hostel number combobox
            		   	    allot=true;
            		  		break;
            	     	}
            	     }//end of for loop
       	     //if there is no any empty room in between
            	      if(roomnumber1<=hcap && allot==false)//check for room number with total capacity of rooms of hostel
	            		{
            	 	  		roomno.setText(""+roomnumber1+"");//roomnumber combobox
            	    		hno.setText(""+hnumber+"");//hostel number combobox
            		   	    allot=true;
            		  		break;
            	        }
            	  }//end of allocating next room
            			
           	  }//end of if (roomremains>0)
           			 
       	 //if there is place for stud. in hostel but he/she is not alloted for room because of no room of same class stud and room no. exceeds hostel capacity
         //so allocate room of another class student
          if(roomremains>0 && allot==false)
          {
           	  sqlstr="select rno from student where hno="+hnumber+""; 
              Statement stmt2=con.createStatement();
              ResultSet	rs1=stmt2.executeQuery(sqlstr);
              while(rs1.next())
             {
            	  int roomnumber=rs1.getInt(1);
            	  //get the total students live in particular room
            	  String sqlstr1="select count(rno) from student where rno="+roomnumber+"and hno=" + hnumber+";";
            	  Statement stmt3 = con.createStatement();
            	  ResultSet rs2=stmt3.executeQuery(sqlstr1);
            	  int count=0;
            	  while(rs2.next())
            	  {
            		count=rs2.getInt(1);
            	  }
            	  if(count<2)//if there is one place for student
            	  {
            	  	roomno.setText(""+roomnumber+"");//roomnumber combobox
            		hno.setText(""+hnumber+"");//hostel number combobox
            		allot=true;
            		break;
            	  }
            }//end of while
         }//end of if(roomremains>0 && allot==false)
          			 
            if (allot)
          	   break;  			   
       } //end of hostel count
        
        if(allot==false)
          JOptionPane.showMessageDialog(null,"Can't allocate room");
        else
        //add record in database
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
        	
        	if(ddno.getText().equals(""))
        	{
        		JOptionPane.showMessageDialog(null,"Enter D.D. number","Error Message",JOptionPane.ERROR_MESSAGE);
        		ddno.requestFocus(true);
        		return;
        	}
			if(amount.getText().equals(""))
      		   {
      			  JOptionPane.showMessageDialog(null,"Enter Amount","Error Message",JOptionPane.ERROR_MESSAGE);
      			  amount.requestFocus(true);
					return;
      		   }
      		   //checking for numeric value of amount number
      		   for(int i=0;i<amount.getText().length();i++)
      		   {
      		   	  char ch = amount.getText().charAt(i);
				  if(ch>='0'&&ch<='9')
					{
					}
				 else
				  {
				 	JOptionPane.showMessageDialog(null,"Enter Numerical Value For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					amount.setText("");
					amount.requestFocus();
					return;
				  } 
		      }
		      
	       	String sno=studno.getText();
        	int stno=Integer.parseInt(sno);
        	sno=tel.getText();
        	int telno=Integer.parseInt(sno);
        	sno=day.getSelectedItem().toString();
        	int dd=Integer.parseInt(sno);
        	sno=year.getSelectedItem().toString();
        	int yy=Integer.parseInt(sno);
        	sno=roomno.getText();
        	int rnumber=Integer.parseInt(sno);
        	sqlstr="Insert Into Student values(" +stno+ ",'" +lastname.getText()+"','"+firstname.getText()+"','"+midname.getText()+"','"+address.getText()+"',"+telno+","+dd+",'"+month.getSelectedItem().toString()+"',"+yy+",'"+bgroup.getSelectedItem().toString()+"','"+sex.getSelectedItem().toString()+"','"+clas.getSelectedItem().toString()+"',"+cno+","+hnumber+","+rnumber+")";
        	
        	//get current date
        	Calendar c = Calendar.getInstance();
        	String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	 		int dd1=c.get(c.DATE);
	 		String mm1=months[(c.get(c.MONTH))];
	 		int yy1=c.get(c.YEAR);
        	String date=""+dd1+"-"+mm1+"-"+yy1+"";
            
            String sql="Select max(feeno) from admission";
            ResultSet r=stmt.executeQuery(sql);
            int fee=0;
            while(r.next())
            {
            	fee=r.getInt(1)+1;
            }
        	String sqlstr1="Insert into admission values(" +fee+","+ stno+",'"+ddno.getText()+"',"+Integer.parseInt(amount.getText())+",'"+date+"')";
        	
        	if (JOptionPane.showConfirmDialog(null,"Do you want to Save the Record?")==JOptionPane.YES_OPTION)
            {
              //execute the insert query of SQL to add in student table
              stmt.executeUpdate(sqlstr);
              //add in admission table
              Statement stmt1=con.createStatement();
              stmt1.executeUpdate(sqlstr1);
              JOptionPane.showMessageDialog(null,"Record Saved Successfully !!!");
              ok.setEnabled(false);
              cancel.setText("Close");
              cancel.setToolTipText("Close");
            }
        }  
        con.close();
     }
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
    public void itemStateChanged(ItemEvent e)
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
    	 }
    }
}