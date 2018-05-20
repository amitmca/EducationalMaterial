
	import java.sql.*;
	import java.io.*;
	class jdbcm
	{
	public static void main(String args[])throws IOException
		{
		try
			{
			Class.forName("com.hxtt.sql.text.TextDriver");
			String url="jdbc:text:////var/lib/mysql/amit";
			System.out.println("\nDriver Loaded");
			Connection conn=DriverManager.getConnection(url,"root","123456");
			System.out.println("\nConnection Created");
			Statement st=conn.createStatement();
			String sql="Insert into student values(40,'Rohit','Miraj',74)";
			st.executeUpdate(sql);
			System.out.println("\n1 Row Inserted");
			}
		catch(SQLException e)
			{
			System.out.println("\nError");
			}
		catch(ClassNotFoundException e)
			{
			}
		}
	}

//export CLASSPATH=/home/Files/Text_JDBC30.jar:$CLASSPATH
