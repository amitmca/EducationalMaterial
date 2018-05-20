
package myexample;
import java.sql.*;
import java.io.*;

public class bean
	{
	public void select()
		{
		
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:mysql";
			
			Connection conn=DriverManager.getConnection(url,"root","123456");
		
			Statement st=conn.createStatement();

			String sql="select * from emp";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1) +" " + rs.getString(2) + "\n";
				}
			out.println(text);
			
			conn.close();
			}

		catch(Exception e)
			{
			out.print(e);
			}
	
		}
	}