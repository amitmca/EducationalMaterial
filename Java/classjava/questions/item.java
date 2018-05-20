
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class item extends HttpServlet 
{

    public String getServletInfo()
    {
       return "Servlet connects to ODBC database and displays result of a SELECT";
    }

    private Connection dbcon;  

    

    public void init(ServletConfig config) throws ServletException
    {
        String loginUser = " ";
        String loginPasswd = " ";
        String loginUrl = "jdbc:odbc:SQLITE";

        try 
           {
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              dbcon = DriverManager.getConnection(loginUrl, loginUser, loginPasswd);
            }
        catch (ClassNotFoundException ex)
            {
               System.err.println("ClassNotFoundException: " + ex.getMessage());
               throw new ServletException("Class not found Error");
            }
        catch (SQLException ex)
            {
               System.err.println("SQLException: " + ex.getMessage());
            }
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");    // Response mime type

        PrintWriter out = response.getWriter();

	String ino=request.getParameter("ino");

	out.println("<body bgcolor=skyblue>");

    
        try
            {
 	    Statement stmt=dbcon.createStatement();	 	

	    String sql="select ename from emp where eno='"+ino+"'";

	    ResultSet rs=stmt.executeQuery(sql);

	    String text="";	
	
	    while(rs.next())
		{
		text=text+rs.getString(2);
		
		}		
   	    out.println("<b>text</b>");	
	    out.println("<a href='D:/Programs/Java/classjava/questions/item.htm'><font color='yellow'>Enter Another Item</font></a>"); 	
	    }
        catch(Exception ex)
            {
                out.println("<HTML>" +
                            "<Head><Title>" +
                            "Bedrock: Error" +
                            "</Title></Head>\n<Body>" +
                            "<P>SQL error in doGet: " +
                            ex.getMessage() + "</P></body></HTML>");
                return;
            }
         out.close();
    }
}
