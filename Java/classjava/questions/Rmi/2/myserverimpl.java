import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

class myserverimpl extends UnicastRemoteObject implements myintf
	{
	public myserverimpl()throws RemoteException
		{
		}
	public void Search(int eno)throws RemoteException
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection conn=DriverManager.getConnection("jdbc:odbc:SQLITE");

			Statement stmt=conn.createStatement();

			String sql="select * from emp where eno="+eno+" ";

			ResultSet rs=stmt.executeQuery(sql);
	
			String text="";

			while(rs.next())
				{
				text=text+rs.getString(1)+" "+rs.getString(2)+"\n";
				System.out.println(text);
				}
			}
		catch(SQLException e)
			{
			}
		catch(ClassNotFoundException e1)
			{
			}
		}
	}
