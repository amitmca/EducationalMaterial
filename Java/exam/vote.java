//Given table VOTE: constituency no,constituency name,city,number of voters. Write JDBC application to display city wise total number of voters.

import java.io.*;
import java.sql.*;

class vote
	{	
	public static void main(String args[])
		{
		Connection conn;
		Statement stmt;
		
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			conn=DriverManager.getConnection(url);

			stmt=conn.createStatement();

			String sql="select sum(nov) from vote group by city";

			ResultSet rs=stmt.executeQuery(sql);

			String text="";

			while(rs.next())
				{
				text=text+rs.getString(1)+"\n";	
				}
			System.out.println(text);
			}
		catch(ClassNotFoundException e)
			{
			System.out.println(e);
			}
		catch(SQLException e1)
			{
			System.out.println(e1);
			}
		}
	}