import java.sql.*;
import java.io.*;

class display
	{
	public static void main(String args[]) throws Exception
		{

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			System.out.print("Driver Loaded");
	
			String url="jdbc:odbc:mysql";
			
			Connection conn=DriverManager.getConnection(url,"root","");
		
			System.out.print("Connection Created");

			Statement st=conn.createStatement();

			String sql="show databases";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1)+"\n";
				}
			System.out.println(text);
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}