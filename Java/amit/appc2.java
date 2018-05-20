import java.awt.*;
import java.applet.*;
import java.sql.*;
/*
<applet code="appc2" width=250 height=350>
</applet>
*/
class appc2 extends Frame
	{
	String mess=" ";		
	public void mc()
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:master";

			Connection conn=DriverManager.getConnection(url);

			Statement st=conn.createStatement();

			mess="Connected Successfully";
			}
		catch(SQLException e)
			{
			mess="Database Exception";
			}
		catch(ClassNotFoundException e)
			{
			
			}
		}
	public static void main(String args[])
		{
		appc2 A=new appc2();
		A.mc();
		}				
	}
