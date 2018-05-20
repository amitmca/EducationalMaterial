import java.sql.*;
import java.io.*;

class insert
	{
	public static void main(String args[]) throws Exception
		{
		int eno;
		String ename=" ";	
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:mimer";
			
			Connection conn=DriverManager.getConnection(url,"DEVUSER","123456");
		
			Statement st=conn.createStatement();

			DataInputStream in=new DataInputStream(System.in);

			System.out.println("Enter Employee Number:");

			eno=Integer.parseInt(in.readLine());

			System.out.println("Enter Employee Name:");
			
			ename=in.readLine();

			String sql="insert into employee values("+eno+",'"+ename+"')";

			st.executeUpdate(sql);

			System.out.println("1 Row Inserted ");
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}