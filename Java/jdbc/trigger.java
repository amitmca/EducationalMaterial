import java.sql.*;
import java.io.*;

class trigger
	{
	public static void main(String args[]) throws Exception
		{
			
		try
			{
			Class.forName("com.mysql.jdbc.Driver");
				
			String url="jdbc:mysql://localhost:3306/amit";
				
			Connection conn=DriverManager.getConnection(url,"root","amit12");		
			
			Statement st=conn.createStatement();


			String sql="CREATE TRIGGER comm_inc BEFORE INSERT ON salespeople FOR EACH ROW SET @sum = @sum + NEW.comm";

			st.executeUpdate(sql);

			System.out.println("Trigger Created ");
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}