//set CLASSPATH=C:\mysql-connector-java-5.0.7-bin.jar:$CLASSPATH


	import java.sql.*;
	import java.io.*;
	class a
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql:amit";

			System.out.println("\nDriver Loaded");

		        Connection conn=DriverManager.getConnection(url,"root","amit12");

			System.out.println("\nConnection Created");

			/*Statement st=conn.createStatement();

			String sql="select * from emp";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1) +" " + rs.getString(2) + "\n";
				}
			System.out.println(text);
			
			conn.close();		*/
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}
