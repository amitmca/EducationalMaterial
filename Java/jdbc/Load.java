import java.sql.*;
import java.io.*;

	class Load
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:mysql";

			System.out.println("\nDriver Loaded");

		        Connection conn=DriverManager.getConnection(url,"root","123456");

			System.out.println("\nConnection Created");

			Statement st=conn.createStatement();

			String open="'C:/open.txt'";

			String q="LOAD DATA LOCAL INFILE "+open+" INTO TABLE amit.emp";		
	
			int b=st.executeUpdate(q);

			if(b==1)
			  {
			  System.out.println("\nData Loaded");
			  }	
			else
			  {
			  System.out.println("\nData Loading Failed"); 	
			  }		
			String save="'C:/save.txt'";
		
			String q1="select * INTO OUTFILE "+save+" FROM amit.emp";

			st.executeUpdate(q1);

			conn.close();		
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}