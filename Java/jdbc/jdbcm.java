//export set CLASSPATH=/home/Files/mysql-connector-java-5.0.7-bin.jar:$CLASSPATH
//export CLASSPATH=CLASSPATH:/home/Files/mysql-connector-java-5.0.7-bin.jar


	import java.sql.*;
	import java.io.*;
	class jdbcm
	{
	public static void main(String args[])
		{
		try
			{
			//Class.forName("com.hxtt.sql.text.TextDriver");
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/amit";
			System.out.println("\nDriver Loaded");
		        Connection conn=DriverManager.getConnection(url,"root","123456");
			System.out.println("\nConnection Created");
			Statement st=conn.createStatement();

			/*String sql="select * from emp1d";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1) +" " + rs.getString(2) + "\n";
				}
			System.out.println(text);*/
			
			conn.close();		
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}

//export CLASSPATH=/home/Files/Text_JDBC30.jar:$CLASSPATH
