import java.awt.*;
import java.applet.*;
import java.sql.*;
/*
<applet code="appc" width=250 height=350>
</applet>
*/
public class appc extends Applet
	{
	String mess=" ";		
	public void init()
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
	public void paint(Graphics g)
		{
		g.drawString(mess,5,15);
		}				
	}
