	import java.sql.*;
	
	class mimer
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("com.mimer.jdbc.Driver");

			System.out.println("\nDriver Loaded");

			String  url = "jdbc:mimer://root:123456@localhost/amit";
	
			Connection con =DriverManager.getConnection(url);

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
