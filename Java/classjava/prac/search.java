import java.io.*;
import java.sql.*;

class search
	{	
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			Connection conn=DriverManager.getConnection(url,"","");

			System.out.println("Connection Created");

			DataInputStream dis=new DataInputStream(System.in);

			int r=Integer.parseInt(dis.readLine());

			String newname=dis.readLine();

			String sql="update student set name=? where rno=? ";

			PreparedStatement stmt=conn.prepareStatement(sql);

			stmt.setInt(2,r);
			stmt.setString(1,newname);

			System.out.println("Statement Created");

			stmt.execute(sql);

			System.out.println("Query Executed");
			}
		catch(ClassNotFoundException e)
			{
			}
		catch(SQLException e)
			{
			}
		catch(IOException e)
			{
			}
		}
	}