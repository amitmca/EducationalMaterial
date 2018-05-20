import java.sql.*;
import java.io.*;

class display
	{
	public static void main(String args[]) throws Exception
		{

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:mysql";
						
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			/*String sql="CREATE FUNCTION WEIGHTED_AVERAGE3 (n1 INT, n2 INT, n3 INT, n4 INT) "+"\n"+"RETURNS INT"+"\n"+"DETERMINISTIC"+"\n"+"BEGIN"+"\n"+"DECLARE avg INT;"+"\n"+"SET avg = (n1+n2+n3*2+n4*4)/8;"+"\n"+"RETURN avg;"+"\n"+"END";

			st.executeUpdate(sql);

			System.out.println("Function Created");*/

			ResultSet rs=st.executeQuery("SELECT WEIGHTED_AVERAGE(70,65,65,60)");

		        ResultSetMetaData md = rs.getMetaData();
		
			int col = md.getColumnCount();

			String r="";	

		 	while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			 } 
			System.out.println(r);
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}