	import java.sql.*;
	
	class jdbcp
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("org.postgresql.Driver");

			String  url = "jdbc:postgresql:fy";
	
			Connection con =DriverManager.getConnection(url,"mca"," ");

			System.out.println("\nConnection Created");

			System.out.println("\nOK\n");

			con.close();
			}
		catch(SQLException e)
			{
			System.out.println("\nError");
			}
		catch(ClassNotFoundException e)
			{
			}

		System.out.println("\nConnection Closed");
		}
	
	}
