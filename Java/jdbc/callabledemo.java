import java.io.*;
import java.sql.*;

class callabledemo
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			System.out.println("Driver Loaded");
			
			Connection conn=DriverManager.getConnection("jdbc:odbc:mysql");

			System.out.println("Connection Created");
				
			CallableStatement cstmt=conn.prepareCall("{call  city_list() }");
			
			System.out.println("Callable Statement Created");
			
			cstmt.registerOutParameter(2,Types.DECIMAL);
			
			ResultSet rs=cstmt.executeQuery();

			String text="";
	
			while(rs.next())
				{
				text=text+rs.getString(1)+"\t"+rs.getString(2)+"\n";
				}	
			System.out.println(text);
			}
		catch(ClassNotFoundException e)
			{	
			}
		catch(SQLException e1)
			{
			}
		}
	}