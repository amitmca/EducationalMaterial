import java.sql.*;

class check
	{
	public static void main(String args[]) throws Exception
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:wodbc";

			System.out.println("Driver Loaded");

			Connection con=DriverManager.getConnection(url);

			System.out.println("Connection Created");

			DatabaseMetaData dm=con.getMetaData();

			boolean b=dm.SupportGroupBy();

			if(b==true)
				{
				System.out.println("Yes");
				}
			else
				{
				System.out.println("No");
				}
			
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
