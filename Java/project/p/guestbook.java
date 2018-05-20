// guestbk.java //

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class guestbk extends httpservlet
{
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
throws
IOException,ServletException
	{
		PrintWriter out=new PrintWriter(res.getOutputStream());
		int ctr=0;
		res.setContentType("text/html");
	try
	{
   		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		con=DriverManager.getConnection("jdbc:odbc:booksrc","","");
   		Statement stmt=con.createStatement();
   		ResultSet rs=stmt.executeQuery("select * from gbook");
   		out.println("<Html>");
		out.println("<Head>");
	   	out.println("<Title>GuestBook</Title>");
	   	out.println("</Head>");
	   	out.println("<Table border=1 align=center >");
   		out.println("<H4><B><center>GUEST BOOK DETAILS
</center></B></H4><BR>");
   		out.println("<TR><TD><b>E-Mail
Address</b></TD><TD><b>Comment</b></TD></TR>");
   	while(rs.next())
   	{
    		ctr++;
    		String email=rs.getString("emailid");
    		String cmt=rs.getString("comment");
    		out.println("<TR><TD>"+email+"</TD><TD>"+cmt+"</TD></TR>");
	}
    		out.println("</Table>");
	if(ctr==0)
      	out.println("<BR>No Records Found<BR>");
	stmt.close();
    	con.close();
  	}
   		catch(SQLException SQLExcep)
   	{
    		System.out.println("error");
   	}
   		catch(ClassNotFoundException CNFE)
   	{
    		System.out.println("error");
   	}
   		out.println("</Html>");
   		out.close();
  	}
 }

// submit.java //
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class submit extends HttpServlet
{
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
throws
IOException,ServletException
{
	String str1,str2;
	str1=req.getParameter("emailid");
	str2=req.getParameter("comment");
	System.out.println(str1);
	System.out.println(str2);
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><h2>Guest Book is Successfully 
Updated</h2></html>");
	try
  	{
   		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:booksrc","","");
		Statement stmt=con.createStatement();
		ResultSet rs;
		int i= stmt.executeUpdate("insert into gbook
values('"+str1+"','"+str2+"')");
        if(i==1)
   	{
   		System.out.println("ok");
   	}
		stmt.close();
		con.close();
   	}
   		catch(SQLException SQLExcep)
  	{
   	        System.out.println("error");
   	}
   		catch(ClassNotFoundException CNFE)
   	{
    		System.out.println("error");
   	}}
 }

//guestbk.htm//
<Html>
<Head>
<Title>GUEST BOOK</Title>
</Head>
<Body>
<P>
<Center>
<Form Action= "http:\localhost:8080servletguestbk" Method= "POST">
<Input Type="Submit" Value="VIEW THE GUEST BOOK">
</Form>
<BR>
<Form action= "http:\localhost:8080servletsubmit" method= "Post">
ENTER YOUR EMAIL ADDRESS<Br>
<Input Type="text" Name="emailid" Size="40"><BR>
COMMENTS ARE ALWAYS WELCOME<BR>
<TextArea Name="comment" Rows="8" Cols="65"></TextArea>
</Center>
<P>
<P>
<BR>
<P>
<Center>
<Input Type="Submit" Value="Submit">
</Form>
<Input Type="Reset" Value="Reset">
</Center>
<BR>
</Body>
</Html>