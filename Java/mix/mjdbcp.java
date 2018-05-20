
//export CLASSPATH=/home/ajit/jdbc/Drivers/mysql-connector-java-5.0.7-bin.jar:$CLASSPATH

import java.sql.*;
	
	public class mjdbcp
	{
	public static void main(String args[])throws Exception
		{
		try
			{
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("\nDriver loaded\n");

			String url="jdbc:mysql:ajit";

			Connection conn = DriverManager.getConnection(url,"root","123456");

			System.out.println("\nConnection Created");

			}
		catch(SQLException e)
			{
			System.out.println(e);
			}
		catch(ClassNotFoundException e1)
			{
			System.out.println("\nConnection Closed");
			}		
		}
	}
//	java -Djdbc.drivers=com.mysql.jdbc.Driver mjdbc
	
/* 
	GRANT ALL PRIVILEGES ON *.* TO root@localhost
    IDENTIFIED BY '123456' WITH GRANT OPTION;
 
*/

//classspath="C:\jdk\jre\lib\ext\mysql-connector-java-5.0.7"
