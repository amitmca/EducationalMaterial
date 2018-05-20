
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class student extends HttpServlet 
	{
	private Connection conn;
	public void init(ServletConfig config)throws ServletException
		{
		try	
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:SQLITE");		
			}
		catch(ClassNotFoundException e)
			{	
			System.err.println("ClassNotFoundException: " + e.getMessage());
			throw new ServletException("Class not found Error");
			}
		   catch (SQLException ex)
            			{
		               System.err.println("SQLException: " + ex.getMessage());
            			}	
		}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
		{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		String rno=request.getParameter("rno");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		 try
			{
			Statement stmt=conn.createStatement();
			String sql="insert into student values('"+rno+"','"+name+"','"+addr+"')";
			stmt.executeUpdate(sql);
			out.println("1 Row Inserted");
			out.println("<a href='http://localhost:8080/examples/servlet/show'>");
			}
		catch(Exception ex)
			{
			out.println(ex.getMessage());
			}
		}
	}