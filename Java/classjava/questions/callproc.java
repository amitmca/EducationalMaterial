import java.sql.*;

class callproc
	{	
	public static void main(String args[])
		{
		try
			{
			Class.forName("org.postgresql.Driver");

			System.out.println("Driver Loaded");

			String url="jdbc:postgresql:fy";

			Connection conn=DriverManager.getConnection(url,"mca"," ");

			System.out.println("Connectionn Created");

			CallableStatement callstmt=conn.prepareCall("{call emp_display()}");

			ResulSet rs=callstmt.executeQuery("select );
			}
		catch(SQLException e)
			{		
			}
		catch(ClassNotFoundException e1)
			{
			}
		}
	}
