import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class student1 extends HttpServlet
	{	
	Connection conn;
	Statement stmt;

	public void init(ServletConfig config)throws ServletException
		{
		
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			conn=DriverManager.getConnection(url);

			}
		catch(ClassNotFoundException e)
			{
			}
		catch(SQLException e1)
			{
			}	
		}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws  ServletException,IOException
		{
		PrintWriter out=response.getWriter();
		try
			{
			stmt=conn.createStatement();
			
			response.setContentType("text/html");
			String div=request.getParameter("div");
			String sql="select name from student1 where division='"+div+"' group by std";
			ResultSet rs=stmt.executeQuery(sql);
			String text="";
			while(rs.next())
				{
				text=text+rs.getString(1)+"\n";
				}
			out.println(text);
			}
		
		catch(SQLException e1)
			{
			out.println(e1);
			}
		}	
	}