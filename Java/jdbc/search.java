import java.sql.*;
import java.io.*;

class search
	{
	public static void main(String args[]) throws Exception
		{
		int eno1;
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			DataInputStream dis=new DataInputStream(System.in);

			System.out.println("Enter Employee No to Search:");

			eno1=Integer.parseInt(dis.readLine()); 
			
			String sql="select * from emp where eno="+eno1+"";

			ResultSet rs=st.executeQuery(sql);

			String text=" ";

			while(rs.next())
				{
				text=text + rs.getString(1) +" " + rs.getString(2) + "\n";
				}
			System.out.println(text);
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}