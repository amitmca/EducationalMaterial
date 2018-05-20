
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class register extends HttpServlet 
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

        // Output stream to STDOUT
        PrintWriter out = response.getWriter();

	String name=request.getParameter("name");

	String userid=request.getParameter("uid");

	String pass=request.getParameter("pass");	

	String addr=request.getParameter("addr");

	String month=request.getParameter("month");

	String day=request.getParameter("day");

	String year=request.getParameter("year");

        out.println("<body bgcolor=lighyellow>");

	String date=month+ "/" + day + "/"+ year;

	PreparedStatement ps;
    
        try
            {
	    Statement stmt=dbcon.createStatement();
	    ResultSet rs=stmt.executeQuery("select uid from register");
	     while(rs.next())
		{
		String uid=rs.getString(1);
		if(uid.equals(userid))
			{
  		        out.println("<h1><br><br><br><br><br><center><font color=red>Please choose another user id</font></center></h1>");
		        out.println("<a href='D:/Programs/Java/classjava/questions/register.htm'><font color='yellow'>Click Here</font></a>"); 	
			break;
			}
		else
			{			
		    ps=dbcon.prepareStatement("insert into register values('"+name+"','"+userid+"','"+pass+"','"+date+"','"+addr+"')");
		    ps.executeUpdate();
	            out.println("<h1><br><br><br><br><br><center><font color=red>Registered Successfully</font></center></h1>");
			}
		}
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
