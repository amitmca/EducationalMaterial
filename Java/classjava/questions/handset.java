
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class handset extends HttpServlet 
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

	String mname=request.getParameter("mname");

	String cname=request.getParameter("cname");

	String price=request.getParameter("price");	

	int p = Integer.valueOf(price).intValue();

        out.println("<body bgcolor=skyblue>");

	PreparedStatement ps;
    
        try
            {
	    ps=dbcon.prepareStatement("insert into handset values('"+mname+"','"+cname+"',"+p+")");
	    ps.executeUpdate();
            out.println("<h1><br><br><br><br><br><center><font color=red>Order Placed Successfully</font></center></h1>");
	    out.println("<a href='D:/Programs/Java/classjava/questions/handset.htm'><font color='yellow'>Place Another Order</font></a>"); 	
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
