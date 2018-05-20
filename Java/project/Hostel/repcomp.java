//complaint report

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class repcomp  
{
	repcomp()
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
				out.write("face=\"Monotype Corsiva\"><strong><u>Complaint Report</u></strong></font></p>");
							
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
				out.write("bgcolor=\"#EEEEFF\" bordercolor=\"#800080\"><tr>");
				out.write("<td align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\"><strong>Complaint&nbsp;");
				out.write("No.</strong> &nbsp;&nbsp;</font></td>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Stud");
				out.write(" No. &nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Name&nbsp;&nbsp;&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Sex&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Class&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Course&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Hostel");
				out.write(" No.&nbsp;&nbsp;</font></th>");
				out.write("<th align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\">Room");
				out.write(" No.&nbsp;&nbsp;</font></th>");
				out.write("<td align=\"right\" bgcolor=\"#C0C0C0\"><font color=\"#800000\"><strong>Complaint");
				out.write(" Description</strong></font></td></tr>");
				
				sql="select * from complaint order by compno";	       
				Statement stmt2=con.createStatement();
				Statement stmt3=con.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);
		        while(rs.next())
		        {
		        	int roll=rs.getInt(2);
					out.write("<tr><td align=\"right\">"+rs.getInt(1)+"</td>");
					sql="select lastname,firstname,midname,sex,class,cno,hno,rno from student where studno="+roll;
					rs1 = stmt2.executeQuery(sql);
					while(rs1.next())
					{
						out.write("<td align=\"right\">&nbsp;"+roll+"</td>");
						out.write("<td align=\"right\">&nbsp;"+rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+"</td>");
						out.write("<td align=\"right\">&nbsp;"+rs1.getString(4)+"</td>");
						out.write("<td align=\"right\">&nbsp;"+rs1.getString(5)+"</td>");
						sql="select cname from course where cno="+rs1.getInt(6);
						ResultSet rs2 = stmt3.executeQuery(sql);
						while(rs2.next())
						{
							out.write("<td align=\"right\">&nbsp;"+rs2.getString(1)+"</td>");
						}
						out.write("<td align=\"right\">&nbsp;"+rs1.getInt(7)+"</td>");
						out.write("<td align=\"right\">&nbsp;"+rs1.getInt(8)+"</td>");
						out.write("<td align=\"right\">&nbsp;"+rs.getString(3)+"</td>");
						out.write("</tr>");
				    }
				}
				out.write("</table>");
				out.write("<p align=\"right\"><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font></p>");
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