//fee dues report

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class repdues 
{
	repdues()
	{
	       Runtime iexp;
		   ResultSet rs,rs1;
		   int cno=0;
		   Process pro;
		   iexp = Runtime.getRuntime();
		   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","c:\\java\\stud.html"};
		   try
		   {	        
		        File outFile = new File("c:\\java\\stud.html");
		        FileWriter out = new FileWriter(outFile);
				//EEECAC yellow aaeef5 cyan
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
				out.write("face=\"Monotype Corsiva\"><strong><u> Fee Dues Report</u></strong></font></p>");
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
		        out.write("<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" width=\"1300\"");
				out.write("bgcolor=\"#EEEEFF\" bordercolor=\"#800080\">");
				//table heading
				out.write("<tr>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Stud");
				out.write("No. &nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Name");
				out.write("&nbsp;&nbsp;&nbsp;&nbsp;</font> </th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Sex&nbsp;&nbsp;</font>");
				out.write("</th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Class&nbsp;&nbsp;</font>");
				out.write("</th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Course&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Hostel");
				out.write(" No.&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Room");
				out.write(" No.&nbsp;&nbsp;</font></th>");
				out.write("<td align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\"><strong>");
				out.write(" Fees Paid</strong></font></td>");
				out.write("<td align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\"><strong>Balance</strong></font></td>");
				out.write("</tr>");
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:hostel",null,null);
		        Statement stmt = con.createStatement();
		        Statement stmt1 = con.createStatement();
                String sql="select * from totalfee ";	
				rs=stmt.executeQuery(sql);
				int totalfee=0;
				while(rs.next())
				{
					totalfee=rs.getInt(1);
				}
				//select student info.
 		        sql="Select studno,lastname,firstname,midname,sex,class,cno,hno,rno from student order by studno";
		        rs = stmt.executeQuery(sql);
		        int totalbal=0;
		        while(rs.next())
		        {
		        	int roll=rs.getInt(1);
		        	sql="select sum(amount) from admission where studno="+roll;
		        	rs1=stmt1.executeQuery(sql);
		        	while(rs1.next())
		        	{
		        		int fee=rs1.getInt(1);
		        		//if total fees paid less than total fee
		        		if( fee < totalfee)
		        		{
		        			//for course name	
					        sql ="Select cname from course where cno="+rs.getInt(7);
						    Statement stmt2 = con.createStatement();
						    ResultSet rs2 = stmt2.executeQuery(sql);
							String coursename="";
							while(rs2.next())
							{
								coursename=rs2.getString(1);
							}
							//add from database
							out.write("<tr>");
							out.write("<td align=\"right\">&nbsp;");
							out.write(""+roll+"");
							out.write("</td>");
							out.write("<td align=\"right\">&nbsp;");
							out.write(""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"");
							out.write("</td>");
							out.write("<td align=\"right\">&nbsp;");
							out.write(""+rs.getString(5)+"</td>");
							out.write("<td align=\"right\">&nbsp;"+rs.getString(6)+"</td>");
							out.write("<td align=\"right\">&nbsp;"+coursename+"</td>");
							out.write("<td align=\"right\">&nbsp;"+rs.getInt(8)+"</td>");
							out.write("<td align=\"right\">&nbsp;"+rs.getInt(9)+"</td>");
							out.write("<td align=\"right\">&nbsp;"+fee+"</td>");
							int balance=totalfee-fee;
							out.write("<td align=\"right\">&nbsp;"+balance+"</td>");
							out.write("</tr>");
							totalbal+=balance;
		        		}//end of if
		        	}//end of total fee sum
		        }//end of student record    
				out.write("</table>");
				//end of table
				out.write("<p align=\"right\"><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
				out.write(" color=\"#800000\" size=\"3\"><strong>Total</strong></font><font");
				out.write(" color=\"#800080\"><strong>&nbsp;</strong></font><font");
				out.write(" color=\"#800000\" size=\"3\"><strong>Balance:</strong></font><font");
				out.write(" color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+totalbal+"</strong></font></p>");
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
	}
	