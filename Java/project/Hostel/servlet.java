import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
 import javax.servlet.*;
 
 public class servlet extends HttpServlet
{     

     String ipaddress=new String();
    
    public void init(ServletConfig config) throws ServletException
    {
    	ipaddress=config.getInitParameter("ipaddr");
        	
    }
    
    
    
    	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		try
		{
		
		 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
			
			ResultSet rs1;
			Statement st1=con.createStatement();
			int max2=0,max1=0,tot1=0,tot2=0,fee=0,tempmax1=0,tempmax2=0;
			
			rs1=st1.executeQuery("select * from hostel where hno = 1");
			while (rs1.next())
			{
				 tot1 =rs1.getInt(4);
			}
			
			
			ResultSet rs2;
			Statement st2=con.createStatement();
			
			rs2=st2.executeQuery("select * from hostel where hno = 2");
			while (rs2.next())
			{
				 tot2 =rs2.getInt(4);
			}
			
			
			
			ResultSet rs3;
			Statement st3=con.createStatement();
			
			rs3=st3.executeQuery("select * from totalfee ");
			while (rs3.next())
			{
				 fee =rs3.getInt(1);
			}
			
			
			
			ResultSet rs4;
			Statement st4=con.createStatement();
			
			rs4=st4.executeQuery("select max(rno) from student where hno = 1");
			
			while (rs4.next())
			{
				 max1 =rs4.getInt(1);
				 
			}
			 tempmax1 =tot1-max1;
			
			
			
			ResultSet rs5;
			Statement st5=con.createStatement();
			
			rs5=st5.executeQuery("select max(rno) from student where hno = 2");
			while (rs5.next())
			{
				 max2 =rs5.getInt(1);
			}
			 tempmax2 =tot2-max2;
			
		
		
			
			
			
			
		out.println("<html>");

		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Language\" content=\"en-us\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">");
		out.println("<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 4.0\">");
		out.println("<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">");
		out.println("<title>HOSTELINFO</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<form method=\"POST\" action=\"--WEBBOT-SELF--\">");
		  out.println("<!--webbot bot=\"SaveResults\"");
		  out.println("U-File=\"C:/hostelon/_private/form_results.txt\" S-Format=\"TEXT/CSV\"");
		  out.println("S-Label-Fields=\"TRUE\" -->");
		  out.println("<p align=\"left\"><span style=\"text-transform: capitalize\"><b><font size=\"7\" color=\"#FF0000\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		  out.println("<u>HOSTELINFO.COM</u></font></b></span></p>");

		  out.println("<p align=\"center\">&nbsp;&nbsp;&nbsp;&nbsp; <img border=\"0\" src=\"file:///C:/hostelon/112.jpg\" width=\"640\" height=\"480\"></p>");

		  out.println("<p align=\"left\">&nbsp;&nbsp; <b><font size=\"4\" color=\"#000000\"><span style=\"text-transform: capitalize\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		  out.println("</span></font><span style=\"text-transform: capitalize\"><font size=\"4\" color=\"#000000\">");
		  out.println("</font><font size=\"4\" color=\"#FF0000\">&nbsp;&nbsp; </font><font size=\"4\" color=\"#000000\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		  out.println("</font><font size=\"4\" color=\"#FF0000\">TOTAL ROOM CAPACITY </font></span></b></p>");
		  out.println("<p align=\"left\">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </p>");
		  out.println("<blockquote>");
		    out.println("<lockquote>");
		      out.println("<p align=\"left\">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <font color=\"#993300\"><b><span style=\"text-transform: capitalize\"><font size=\"4\">wADIA");
		      out.println("bOYS hOSTEL&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font></span></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");		      out.println("<input type=\"text\" name=\"T1\" size=\"20\" value="+tot1+"></font></p");;
		      out.println("<p align=\"left\"><font color=\"#993300\">&nbsp;&nbsp;");
		      out.println("&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\"><span style=\"text-transform: capitalize\">wADIA");
		      out.println("gIRLS hOSTEL : </span></font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		      out.println("<input type=\"text\" name=\"T2\" size=\"20\" value="+tot2+"></font></p>");
		      out.println("<p align=\"left\"><font color=\"#993300\">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <font size=\"3\">");
		      out.println("</font><font size=\"4\"><b>TOTAL FEE PER STUDENT </b></font><font size=\"3\">&nbsp;");
		      out.println(":&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><input type=\"text\" name=\"T3\" size=\"20\" value="+fee+"></font></p>");
		      out.println("<p align=\"left\"><font color=\"#993300\">&nbsp;&nbsp;");
		      out.println("&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\">Total Available rooms in boys");
		      out.println("hostel&nbsp;&nbsp; </font></b><input type=\"text\" name=\"T4\" size=\"20\" value="+tempmax1+"></font></p>");
		      out.println("<p align=\"left\">&nbsp;&nbsp; <font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;");
		      out.println("<b><font size=\"4\">Total Available rooms in Girls hostel&nbsp;&nbsp; </font></b><input type=\"text\" name=\"T5\" size=\"20\" value="+tempmax2+"></font></p>");
		      out.println("<p align=\"left\">&nbsp;</p>");
		      
		      
		      //new 
		      out.println("<p><b><font size=\"4\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color=\"#993300\">Rules");
			  out.println("and Regulations :</font></font></b></p>");
			  out.println("<p><font color=\"#993300\"><font size=\"4\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1)</b></font>&nbsp;");
			  out.println("Fees are taken by Cash or by Demand-draft or by cheque only.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\">2)</font>&nbsp;");
			  out.println("</b>One student get only one room.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size=\"4\"><b>3)&nbsp;");
			  out.println("</b></font>They have to take care their goods themselves.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size=\"4\"><b>4)&nbsp;");
			  out.println("</b></font>Students have to take admissions within the given duration in the");
			  out.println("hostel.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"5\"> </font>");
			  out.println("<font size=\"4\">  &nbsp;5)</font></b> Parents can meet the students twice in a month.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\">6)&nbsp;");
			  out.println("</font></b>Students do not allow smoking and drinking&nbsp; in the hostel.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\">7)&nbsp;");
			  out.println("</font></b>After 10 p.m., students are not allowed to go outside the hostel</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size=\"4\"><b>8)&nbsp;");
			  out.println("</b></font>Boys are not allowed in the girls hostel and Girls are not allowed in");
			  out.println("the boys hostel.</font></p>");
			  out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font size=\"4\"><b>9)&nbsp;");
			  out.println("</b></font>Hostel is made for the students and they will take care of everything");
			  out.println("about the students complaints.</font></p>");
			  //out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>");
              
              out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#993300\"><font size=\"4\"><b>10)");
              out.println("</b></font>Students have to take admission with original documents and xerox");
              out.println("copies of certificates.</font> </p>");
              out.println("<p><font color=\"#993300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=\"4\">11)");
              out.println("</font></b>One room should be allocated for 2 Students of same course only.</font> </p>");
              out.println("<p>&nbsp; </p>");
              
              out.println("<p>&nbsp; </p>");
              out.println("<p>&nbsp; </p>");
              out.println("<p align=\"center\"><b><font color=\"#993300\" size=\"6\">Thank you for co-operation.</font></b> </p>");
              out.println("<p align=\"center\">&nbsp; </p>");
              out.println("<p>&nbsp; </p>");
              out.println("<p>&nbsp; </p>");

              
		      
		    //end
		    out.println("</blockquote>");
		    out.println("</blockquote>");
		    out.println("<p align=\"left\">&nbsp;</p>");
		    out.println("</form>");
		
		out.println("</body>");
		
		out.println("</html>");

			
			
			
			
			
			
			
			
			
		}catch(Exception e)
		{
			PrintWriter t = response.getWriter();
	        response.setContentType("text/html");
	        t.println(e);
		}
	}
}