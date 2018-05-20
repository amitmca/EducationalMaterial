
import java.sql.*;
	
	public class select
	{
	public static void main(String args[])throws Exception
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			System.out.println("\nDriver loaded\n");

			String url="jdbc:odbc:mysql";

			Connection conn = DriverManager.getConnection(url,"root","123456");

			System.out.println("\nConnection Created");

			System.out.println("\n\tEmp No\tEmp Name\n");

			System.out.println("\t----------------");

			String text=" ";

			String sql="select * from emp order by eno";

			Statement st=conn.createStatement();

			ResultSet rs=st.executeQuery(sql); 

			while(rs.next())
				{
				text=text+"\t" +rs.getString(1) + "\t" +rs.getString(2) +"\n"; 
				}
			System.out.println(text);

			}
		catch(SQLException e)
			{
			System.out.println(e);
			}
		catch(ClassNotFoundException e1)
			{
			System.out.println("\nConnection Closed");
			}		
		}
	}