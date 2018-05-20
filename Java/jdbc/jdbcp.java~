	import java.sql.*;
	
	class jdbcp
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			System.out.println("\nDriver Loaded");

			String  url = "jdbc:odbc:post";
	
			Connection con =DriverManager.getConnection(url,"postgres","");

			System.out.println("\nConnection Created");

			}
		catch(SQLException e)
			{
			System.out.println(e);
			}
		catch(ClassNotFoundException e1)
			{
			System.out.println(e1);
			}

		}
	
	}
