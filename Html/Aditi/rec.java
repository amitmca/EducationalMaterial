
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class rec extends HttpServlet 
{

    public String getServletInfo()
    {
       return "Servlet connects to ODBC database and displays result of a SELECT";
    }

    private Connection dbcon;  

    

    public void init(ServletConfig config) throws ServletException
    {
        String loginUser = "root";
        String loginPasswd = " ";
        String loginUrl = "jdbc:odbc:mysql";

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

	

	String fname=request.getParameter("fname");

	String mobile=request.getParameter("mobile");

	String scratch=request.getParameter("scratch");

	PreparedStatement ps;
    
        try
            {
	    ps=dbcon.prepareStatement("insert into recharge values('"+fname+"','"+mobile+"','"+scratch+"')");
	    ps.executeUpdate();
            out.println("<h1><br><br><br><br><br><center><font color=red>Recharged</font></center></h1>");
	    out.println("<center><a href='http://localhost/Aditi/select1.php'><h3>Back</h3></a></center>");	    
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
