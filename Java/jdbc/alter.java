import java.sql.*;
import java.io.*;

class alter
	{
	public static void main(String args[]) throws Exception
		{
		try
			  {
  			  String q="Alter Table emp add desig int";
		
			  Class.forName("com.mysql.jdbc.Driver");

	  	  	  String url="jdbc:mysql://localhost:3306/amit";
			
                          Connection con = DriverManager.getConnection(url,"root","amit12");

		          Statement stmt=con.createStatement();

			  stmt.executeUpdate(q);

			  System.out.println("ok");
			  }	
			catch(Exception e)
		  	  {
		  	  System.out.println(e.getMessage()); 			
   		  	  }
		}
	}