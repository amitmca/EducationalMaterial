import java.io.*;
import java.sql.*;

public class DBSerialization
	{
	public static void main(String args[])
		{		
		try
			{
			MyClass object1=new MyClass("Hello");
		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection conn=DriverManager.getConnection("jdbc:odbc:SQLITE");

			Statement stmt=conn.createStatement();

			String sql="insert into Object values('"+object1+"')";

			stmt.executeUpdate(sql);

			}
		catch(Exception e)
			{
			System.out.println("Exception During Serialization:"+e);
			System.exit(0);
			}
		try
			{
				
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection conn=DriverManager.getConnection("jdbc:odbc:SQLITE");

			Statement stmt=conn.createStatement();

			String sql="select * from Object";

			ResultSet rs=stmt.executeQuery(sql);

			String text="";		

			while(rs.next())
				{
				text=text+rs.getString(1);				
				}
			System.out.println(text);
			}
		catch(Exception e)
			{
			System.out.println("Exception During Serialization:"+e);
			System.exit(0);
			}
		}	
	}

class MyClass implements Serializable
	{	
	String s;
	
	public MyClass(String s)
		{
		this.s=s;
		
		}
	public String toString()
		{
		return "S="+s;
		}
	}		