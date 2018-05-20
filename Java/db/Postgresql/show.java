/* A servlet to display the contents of the PostgreSQL Bedrock database */
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class show extends HttpServlet 
{
    public String getServletInfo()
    {
       return "Servlet connects to PostgreSQL database and displays result of a SELECT";
    }

    private Connection dbcon;  // Connection for scope of ShowBedrock

    // "init" sets up a database connection
    public void init(ServletConfig config) throws ServletException
    {
        String loginUser = "bed";
        String loginPasswd = " ";
        String loginUrl = "jdbc:postgresql://localhost/bedrock";

        // Load the PostgreSQL driver
        try 
           {
              Class.forName("org.postgresql.Driver");
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

                String query = "SELECT name, dept, ";
                query +=       "       jobtitle ";
                query +=       "FROM   employee ";

                // Perform the query
                ResultSet rs = statement.executeQuery(query);
		PreparedStatement ps;
                out.println("<table border=1>");

                // Iterate through each row of rs
                while (rs.next())
                {
                   String m_name = rs.getString("name");
                   String m_dept = rs.getString("dept");
                   String m_jobtitle = rs.getString("jobtitle");
                   out.println("<tr>" + 
                               "<td>" + m_name + "</td>" +
                               "<td>" + m_dept + "</td>" +
                               "<td>" + m_jobtitle + "</td>" +
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
