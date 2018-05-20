import java.sql.*;

class postgresql
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			String url="jdbc:postgresql:post";
			Connection conn=DriverManager.getConnection(url,"amit","");
			System.out.println("Connection Established");
			}
		catch(ClassNotFoundException e)
			{
			System.out.println(e.getMessage());
			}

		catch(SQLException e1)
			{
			System.out.println(e1.getMessage());
			}
		}
	}
