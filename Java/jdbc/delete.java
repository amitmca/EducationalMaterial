import java.sql.*;
import java.io.*;

class delete
	{
	public static void main(String args[]) throws Exception
		{
		int eno;
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:wodbc";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();
			
			DataInputStream in=new DataInputStream(System.in);
			
			System.out.println("Enter Employee Number:");
	
			eno=Integer.parseInt(in.readLine());
	
			String sql="delete from emp where eno="+eno+" "; 
			
			st.executeUpdate(sql);

			System.out.println("1 Row Deleted ");
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}