	import java.sql.*;
	
	class ejdbc
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("easysoft.sql.jobDriver");

			System.out.println("\nDriver Loaded");

			/*String  url = "jdbc:odbc:wpost";
	
			Connection con =DriverManager.getConnection(url);

			System.out.println("\nConnection Created");*/

			}
		/*catch(SQLException e)
			{
			System.out.println(e);
			}*/
		catch(ClassNotFoundException e1)
			{
			System.out.println(e1);
			}

		System.out.println("\nConnection Closed");
		}
	
	}
