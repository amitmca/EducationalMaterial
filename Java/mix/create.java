import java.sql.*;

class create 
	{
	public static void main(String args[])
		{
		try
			{

			String text=" ";
	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
			System.out.println("\nDriver Loaded\n");
	
			String url="jdbc:odbc:mysql";
	
			Connection conn=DriverManager.getConnection(url,"root","123456");
	
			System.out.println("\nConnction Created\n");	

			Statement st=conn.createStatement();
			
			String s="show databases";

			ResultSet rs=st.executeQuery(s); 

			while(rs.next())
				{
				text=text + "\t" +rs.getString(1) +"\n"; 
				}
			System.out.println(text);
			}	
		catch(SQLException e)
			{
			System.out.println(e);
			}
		catch(ClassNotFoundException e1)
			{
			System.out.println(e1);
			}
		}

	}	