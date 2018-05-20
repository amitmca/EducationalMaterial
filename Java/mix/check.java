import java.sql.*;
class check
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:test";
			System.out.println("Driver Loaded");
			Connection con=DriverManager.getConnection(url,"amit"," ");
			System.out.println("Connection Created");
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
