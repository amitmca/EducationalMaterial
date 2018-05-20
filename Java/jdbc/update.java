import java.sql.*;
import java.io.*;

class update
	{
	public static void main(String args[]) throws Exception
		{
		int eno1;
		String ename1=" ";
		
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			DataInputStream dis=new DataInputStream(System.in);
                    
                        System.out.println("Enter Emp No which you want to update:");

			eno1=Integer.parseInt(dis.readLine()); 

			System.out.println("Enter new name:");

			
			Statement st=conn.createStatement();

	
			ename1=dis.readLine();			       
                
                       	String sql="update emp set ename='"+ename1+"' where eno="+eno1+" ";

			st.executeUpdate(sql);

			System.out.println("\n1 Row Updated ");
			
			conn.close();
			}

		catch(Exception e)
			{
			System.out.print(e);
			}
	
		}
	}