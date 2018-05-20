import java.sql.*;
import java.io.*;

class password
	{
	public static void main(String args[]) throws Exception
		{

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			String url="jdbc:odbc:mysql";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			DataInputStream dis=new DataInputStream(System.in);

			System.out.println("\n User Name :");
			
			String input=dis.readLine();
	
			System.out.println("\n Password :");
	
			String pass=dis.readLine();

			String sql="select user,Password from mysql.user where user='"+input+"'";

			ResultSet rs=st.executeQuery(sql);

			String u=" ",p="";

			while(rs.next())
				{
				u=rs.getString(1);
			 	p=rs.getString(2);
				}
			System.out.println(u+" "+p);
			
			st.executeUpdate("create user temp");

			String sql1="set password for temp=password('"+pass+"')";
			
			st.executeUpdate(sql1);

			String sql2="select Password from mysql.user where user='temp'";

			ResultSet rs1=st.executeQuery(sql2);

			String p1="";

			while(rs1.next())
				{
			 	p1=rs1.getString(1);
				}		

			if(p.equals(p1))
				{
				System.out.println("Valid User");	
				}
			else
				{
				System.out.println("InValid User");	
				}
			st.executeUpdate("drop user temp");

			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}