import java.sql.*;
import java.io.*;

class display1
	{
	public static void main(String args[]) throws Exception
		{

		try
			{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/mysql";
			
            Connection con = DriverManager.getConnection(url,"root","amit12");

		
			System.out.print("Connection Created");

			Statement st=con.createStatement();

			String sql="help select";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1) + "\n";
				}
			System.out.println(text);
			
			con.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}
