
import java.sql.*;
	
	public class jdbc
	{
	public static void main(String args[])throws Exception
		{
		try
			{
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("\nDriver loaded\n");

			String url="jdbc:mysql://localhost:3306/amit";

			Connection conn = DriverManager.getConnection(url,"root","amit12");

			System.out.println("\nConnection Created");



			String text=" ";

			String sql="select * from register";

			Statement st=conn.createStatement();

			ResultSet rs=st.executeQuery(sql); 

			while(rs.next())
				{
				text=text+"\t" +rs.getString(1) + "\t" +rs.getString(2) +"\t" +rs.getString(3) +"\t" +rs.getString(4) +"\n"; 
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