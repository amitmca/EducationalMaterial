import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class student2 extends HttpServlet
	{
	private Connection conn;
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
			throw new ServletException("Class Not Found");
			}
		catch(SQLException e1)
			{
				
			}
		}	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
			{
			PrintWriter out=response.getWriter();
			try
				{
				response.setContentType("text/html");
				stmt=conn.createStatement();
				String rno=request.getParameter("rno");
				String name=request.getParameter("name");
				String addr=request.getParameter("addr");
				String sql="insert into student values('"+rno+"','"+name+"','"+addr+"')";
				stmt.executeUpdate(sql);
				out.println("<b>1 Row Inserted");
				}
			catch(SQLException e)
				{
				out.println(e);
				}
			}
	}


