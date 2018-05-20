import java.sql.*;
import java.io.*;
import java.io.DataInputStream;

public class up
{
	public static void main(String args[])
	{
	DataInputStream in=new DataInputStream(System.in);
	try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:hotel");
			Statement st=con.createStatement();
			
			System.out.println("enter The details");
			String CreateString=new String();
			int e=Integer.parseInt(in.readLine());
			String s=in.readLine();
			int a=Integer.parseInt(in.readLine());
			CreateString="INSERT into amol VALUES"+"("+e+","+s+","+a+");";
			st.executeUpdate(CreateString);
		}
catch(Exception e)
{
}
}

}