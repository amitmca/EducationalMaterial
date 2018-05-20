
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class insert extends HttpServlet 
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

	String rno=request.getParameter("rno");

	String fname=request.getParameter("fname");

	String addr=request.getParameter("addr");

	String city=request.getParameter("city");

	String contact=request.getParameter("contact");

	String no=request.getParameter("no");

	String month=request.getParameter("month");

	String day=request.getParameter("day");

	String year=request.getParameter("year");

	String day1=request.getParameter("day1");

        out.println("<body bgcolor=lighyellow>");

	

	PreparedStatement ps,ps1;
    
        try
            {
	    ps=dbcon.prepareStatement("insert into room values("+rno+",'"+fname+"','"+addr+"','"+city+"',"+contact+","+no+",'"+month+"','"+day+"',"+year+",'"+day1+"')");
	    ps.executeUpdate();
            out.println("<h1><br><br><br><br><br><center><font color=red>Room Allocated</font></center></h1>");
	    out.print("<center><h2><font color=blue>Room No :" +rno +"</font></h2></center>");		
	    out.println("<center><a href='http://localhost/Hotel/select.php'><h3>Back</h3></a></center>");	
	    ps1=dbcon.prepareStatement("insert into record values("+rno+",'"+fname+"','"+addr+"','"+city+"',"+contact+","+no+",'"+month+"','"+day+"',"+year+",'"+day1+"')");
	    ps1.executeUpdate();
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
