
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class show extends HttpServlet 
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
		
		 try
			{
			Statement stmt=conn.createStatement();
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			String text="";
			while(rs.next())
				{
				text=text+rs.getString(1)+"\t"+rs.getString(2)+"\n";
				out.println(text);
				}	
			}
		catch(Exception ex)
			{
			out.println(ex.getMessage());
			}
		}
	}