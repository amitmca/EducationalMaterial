	import java.awt.*;
	import java.applet.*;
	import java.sql.*;

	/*
	<applet code="Ajdbc" width=250 height=250>
	</applet>
	*/
	public class Ajdbc extends Applet
	{
	String mess="";	
	public void init()
		{
		try
			{	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQLITE";
			Connection conn=DriverManager.getConnection(url); 	
			mess="Success";
			}
		catch(SQLException e)
			{
			mess="SQL error";
			}	
		catch(ClassNotFoundException e)
			{
			mess="Class Not Found Exception";
			}	
		}
	public void paint(Graphics g)
		{
		g.drawString(mess,100,20);
		}
	}
	
	