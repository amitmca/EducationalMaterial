//set CLASSPATH=C:\mysql-connector-java-5.0.7-bin.jar:$CLASSPATH


	import java.sql.*;
	import java.io.*;
	class create
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
				
			String url="jdbc:mysql://localhost:3306/";
				
			Connection conn=DriverManager.getConnection(url,"root","amit12");		
			
			Statement st=conn.createStatement();

			System.out.println("\nConnection Created");

			st=conn.createStatement();

			String sql="create database s";

			st.executeUpdate(sql);			
		
			conn.close();		
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}
