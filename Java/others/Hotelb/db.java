import java.sql.*;
import java.io.*;

public class db
{
	public static void main(String args[])
	{
	Connection con;
	Statement st;
	ResultSet rs;
	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:hotel");
			st=con.createStatement();
			rs=st.executeQuery("Select * From room");
			while(rs.next())
			{
				System.out.println(rs.getString("rno")+" "+rs.getString("rtype")+" "+rs.getString("rstatus")+" "+rs.getString("cno"));
			}	
			rs.close();
			st.close();
			con.close();
		
	}
catch(Exception e)
{
}
}

}