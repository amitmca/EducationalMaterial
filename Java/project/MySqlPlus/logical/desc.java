import java.sql.*;

class desc
	{		
	public static void main(String args[])
	  {
		try
		  {
		  Class.forName("com.mysql.jdbc.Driver");

		  String url="jdbc:mysql://localhost:3306/MysqlPlus";
			
		  Connection conn=DriverManager.getConnection(url,"root","amit12");		
			
		  Statement st=conn.createStatement();
	
		  ResultSet rs=st.executeQuery("SHOW ENGINES");

		  String text=" ";

	          while(rs.next())
		     {
		     text=text + rs.getString(1) +"\t"+rs.getString(2) +"\t"+rs.getString(3) +"\n";
		     }
		 System.out.println(text);

		 }
		 catch(Exception e)
		 {
		 String str2=e.getMessage();
		 System.out.println(str2);
		 }
	   }
	}