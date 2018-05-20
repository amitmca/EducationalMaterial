//college wise student report

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class repstudcollege extends JDialog implements ActionListener,ItemListener
{
	JComboBox cname=new JComboBox();
	JCheckBox male=new JCheckBox("Male");
	JCheckBox female=new JCheckBox("Female");
	JCheckBox all=new JCheckBox("All Colleges");
	JButton ok=new JButton("Ok");
	JButton close=new JButton("Close");
	repstudcollege(JFrame parent)
	{
        super(parent,"College wise Student Report",true);
		
		Container c = getContentPane();
		c.setLayout(null);
	
	    
	    JLabel l=new JLabel("Select College Name");
	    l.setForeground(Color.blue);
	    JLabel l1=new JLabel("Select Type");
	    l1.setForeground(Color.blue);

       //adds in combobox of college name
        cname.addItem("Nowrosjee Wadia College");
        cname.addItem("Ness Wadia College");
        cname.addItem("Cusrow Wadia College");
        cname.addItem("Neville Wadia College");
       
	    ok.setMnemonic('o');
	    close.setMnemonic('c');
	    
	    l.setBounds(10,40,130,20);
	    cname.setBounds(140,40,180,20);
	    all.setBounds(330,40,100,20);
	    l1.setBounds(10,140,80,20);
	    male.setBounds(120,140,70,20);
	    female.setBounds(210,140,70,20);
	    ok.setBounds(150,200,70,30);
	    close.setBounds(250,200,70,30);
	    
	    all.addItemListener(this);
	    male.addItemListener(this);
	    female.addItemListener(this);
	    ok.addActionListener(this);
	    close.addActionListener(this);
	    
	    c.add(l);
	    c.add(l1);
	    c.add(cname);
	    c.add(male);
	    c.add(female);
	    c.add(all);
	    c.add(ok);
	    c.add(close);
	    
	    setSize(450,300);
	    setLocation(100,50);
	    setVisible(true);
	    
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
	  {
		   Runtime iexp;
		   ResultSet rs1;
		   String sql="";
		   int cno=0;
		   Process pro;
		   iexp = Runtime.getRuntime();
		   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","c:\\java\\stud.html"};
		   try
		   {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:hostel",null,null);
		        Statement stmt = con.createStatement();
		        if(cname.isEnabled())
		        {
		          String sqlstr="Select cno from course where college='"+cname.getSelectedItem().toString()+"'";
		          rs1=stmt.executeQuery(sqlstr);
		          while(rs1.next())
		          {
		         	cno=rs1.getInt(1);
		          }
		        }
		        
		        //if all colleges and all students
		        if (all.isSelected() && male.isSelected() && female.isSelected())
		            sql ="Select * from student order by studno";
		        else
		        {
		        	if(male.isSelected() && female.isSelected())
		               sql ="Select studno,lastname,firstname,midname,address,telephone,dd,mm,yy,bgroup,sex,class,student.cno,hno,rno from student,course where student.cno=course.cno and college='"+cname.getSelectedItem().toString()+"'" +"order by studno";
	                else	         
		        	//if boys and course selected
		        	if(male.isSelected())
		               //sql ="Select * from student where cno="+cno +"and sex='Male'" +" order by studno";
		               sql ="Select studno,lastname,firstname,midname,address,telephone,dd,mm,yy,bgroup,sex,class,student.cno,hno,rno from student,course where student.cno=course.cno and sex='Male' and college='"+cname.getSelectedItem().toString()+"'" +"order by studno";
		            else   
		            //if girls and college selected
		        	if(female.isSelected())
		               //sql ="Select * from student where cno="+cno +"and sex='Female'" +" order by studno";   
		               sql ="Select studno,lastname,firstname,midname,address,telephone,dd,mm,yy,bgroup,sex,class,student.cno,hno,rno from student,course where student.cno=course.cno and sex='Female' and college='"+cname.getSelectedItem().toString()+"'" +"order by studno";
		            else   
		              // sql ="Select * from student where cno="+cno +" order by studno";   
		                sql ="Select studno,lastname,firstname,midname,address,telephone,dd,mm,yy,bgroup,sex,class,student.cno,hno,rno from student,course where student.cno=course.cno and college='"+cname.getSelectedItem().toString()+"'" +"order by studno";
		        }
		        if (all.isSelected() && male.isSelected())
		            sql ="Select * from student where sex ='Male' order by studno";
		        if (all.isSelected() && female.isSelected())
		            sql ="Select * from student where sex= 'Female ' order by studno";
		        if (all.isSelected() && !male.isSelected() && !female.isSelected())
		            sql ="Select * from student order by studno";
		        //if all courses and all students
		        if (all.isSelected() && male.isSelected() && female.isSelected())
		            sql ="Select * from student order by studno";    
		        
		       
		       
		        ResultSet rs = stmt.executeQuery(sql);
		        
		        File outFile = new File("c:\\java\\stud.html");
		        FileWriter out = new FileWriter(outFile);
		        
				out.write("</head><body bgcolor=\"#b6d3d3\" alink=\"#800080\">");
				//for logo of college
				out.write("<p align=\"center\"><input type=\"image\" name=\"I1\"");
				out.write("src=\"file:///C:/hostelon/collegelogo.jpg\"");
				out.write("align=\"bottom\" border=\"0\" width=\"140\" height=\"165\"></p>");
				
				out.write("<p align=\"center\"><font color=\"#0000FF\" size=\"3\"");
				out.write("face=\"Monotype Corsiva\"><strong>\"Hostel Admission System\"</strong></font></p>");
				out.write("<p align=\"center\"><font color=\"#0000FF\" size=\"3\"");
				out.write("face=\"Monotype Corsiva\"><strong>Nowrosjee Wadia College,Pune-411001.</strong></font></p>");
				out.write("<p align=\"center\"><font color=\"#FF0000\" size=\"6\"");
				out.write("face=\"Monotype Corsiva\"><strong><u>College wise Student Information Report</u></strong></font></p>");
				if(all.isSelected()==false)
				{
				    out.write("<p align=\"center\"><font color=\"#0000FF\" size=\"5\"");
				    out.write("face=\"Monotype Corsiva\"><strong><u>College Name: "+cname.getSelectedItem().toString()+"</u></strong></font></p>");
				}
				 
				//for date
				//get current date
		        Calendar c = Calendar.getInstance();
		        String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			 	int dd1=c.get(c.DATE);
			 	String mm1=months[(c.get(c.MONTH))];
			 	int yy1=c.get(c.YEAR);
			 	int hh=c.get(c.HOUR);
			 	int mm=c.get(c.MINUTE);
			 	int ss=c.get(c.SECOND);
		        String date=""+dd1+"-"+mm1+"-"+yy1+"";
		        String time=""+hh+":"+mm+":"+ss+"";
		        out.write("<table border=0 align=right><tr><td > <font color =\"000080\">Date: "+date +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:&nbsp;"+time+"</font></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
		        
		        //for table 
		        out.write("<table border = 2 align = right cellpadding=\"0\" cellspacing=\"0\" width=\"1300\" bordercolor=\"#800080\" bgcolor = #EEEEFF>");
		
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\"> Stud&nbsp;No. &nbsp;&nbsp;</font></th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Name &nbsp;&nbsp;&nbsp;&nbsp;</font> </th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Address </font></th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Telephone&nbsp;&nbsp;&nbsp;&nbsp;</font> </th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Birthdate&nbsp;&nbsp;</font> </th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Blood Group&nbsp;&nbsp;</font></th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Sex&nbsp;&nbsp;</font> </th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Class&nbsp;&nbsp;</font> </th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Course&nbsp;&nbsp;</font></th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Hostel No.&nbsp;&nbsp;</font></th>");
				out.write("<th bgcolor=\"#C0C0C0\"><font color =\"800000\">Room No.&nbsp;&nbsp;</font></th>");
		
		    //add from database
			while (rs.next())
			{
		        sql ="Select cname from course where cno="+rs.getInt(13);
		        Statement stmt1 = con.createStatement();
		        rs1 = stmt1.executeQuery(sql);
		        String coursename="";
		        while(rs1.next())
		        {
		        	coursename=rs1.getString(1);
		        }
		        
				out.write("<tr> <td>&nbsp;" +rs.getInt(1)+"</td> <td>&nbsp;" +rs.getString(2) +"&nbsp;"+rs.getString(3)+"&nbsp;"+rs.getString(4) +"</td> <td>&nbsp;" +rs.getString(5)+"</td> <td>&nbsp;" +rs.getInt(6)+"</td> <td>&nbsp;" +rs.getInt(7)+"/"+rs.getString(8)+"/"+rs.getInt(9)+"</td> <td>&nbsp;" +rs.getString(10)+"</td> <td>&nbsp;" +rs.getString(11)+"</td> <td>&nbsp;" +rs.getString(12)+"</td> <td>&nbsp;" +coursename+"</td> <td>&nbsp;" +rs.getInt(14)+"</td> <td>&nbsp;" +rs.getInt(15)+"</td> " );
			}
				out.write("</table>");
				out.write("</body></html>");
		        out.close();
		        pro = iexp.exec(en);
		
		       pro.waitFor();
			stmt.close();
			con.close();
		
		   } // end of try
		
		   catch(Exception e)
		   {
		        System.out.println(e);
		   }
	  }
	  else
	    dispose();	
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==all)
		{
			if(all.isSelected())
				cname.setEnabled(false);
			else
				cname.setEnabled(true);
		}
	}
}
