import java.sql.*;
import java.io.*;

	class Users
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:mysql";

			System.out.println("\nDriver Loaded");

		        Connection conn=DriverManager.getConnection(url,"root","amit12");

			System.out.println("\nConnection Created");

			Statement st=conn.createStatement();

			int b=st.executeUpdate("rename user amit to ajit");

			if(b==0)
			  {
			  System.out.println("\nUser Created");
			  }	
			else
			  {
			  System.out.println("\nUser Creation Failed"); 	
			  }		
			conn.close();		
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}