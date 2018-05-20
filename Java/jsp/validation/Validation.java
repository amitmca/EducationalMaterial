import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Validation extends HttpServlet{

  private ServletConfig config;
  
  public void init(ServletConfig config)
    throws ServletException{
     this.config=config;
     }
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException,IOException{
      
    PrintWriter out = response.getWriter();
    String connectionURL = "jdbc:odbc:mysql";
    Connection connection=null;
    ResultSet rs;
    String userName=new String("");
    String passwrd=new String("");
    response.setContentType("text/html");
    try {
       // Load the database driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // Get a Connection to the database
      connection = DriverManager.getConnection(connectionURL, "root", " "); 
      //Add the data into the database
      String sql = "select user,password from User";
      Statement s = connection.createStatement();
      s.executeQuery (sql);
      rs = s.getResultSet();
      while (rs.next ()){
        userName=rs.getString("user");
        passwrd=rs.getString("password");
      }
      rs.close ();
      s.close ();
      }catch(Exception e){
      System.out.println("Exception is ;"+e);
      }
      if(userName.equals(request.getParameter("user")) 
          && passwrd.equals(request.getParameter("pass"))){
        out.println("User is Valid");
      }
      else{
        out.println("You are not a Valid User");
      }
  }
}   