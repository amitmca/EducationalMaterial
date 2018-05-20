/* A servlet to display the contents of the Oracle database */

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sodbc extends HttpServlet 
{
    public String getServletInfo()
    {
       return "Servlet connects to PostgreSQL database and displays result of a SELECT";
    }

    private Connection dbcon;  

    // "init" sets up a database connection

    public void init(ServletConfig config) throws ServletException
    {
        String loginUser = " ";
        String loginPasswd = " ";
        String loginUrl = "jdbc:odbc:wodbc";

        // Load the Oracle driver

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

    // Use http GET

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");    // Response mime type

        // Output stream to STDOUT
        PrintWriter out = response.getWriter();

        out.println("<HTML><Head><Title>Bedrock</Title></Head>");
        out.println("<body bgcolor=yellow><H1>Bedrock</H1>");
	    
        try
            {
                // Declare our statement
                Statement statement = dbcon.createStatement();

                String query = "SELECT eno,ename from emp";

                // Perform the query
                ResultSet rs = statement.executeQuery(query);
		PreparedStatement ps;
                out.println("<table border=1>");

                // Iterate through each row of rs
                while (rs.next())
                {
                   String e_no = rs.getString("eno");
                   String e_nm = rs.getString("ename");
                   out.println("<tr>" + 
                               "<td>" + e_no + "</td>" +
                               "<td>" + e_nm + "</td>" +
                               "</tr>");
                }
                out.println("</table></body></html>");
	        statement.close();
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
