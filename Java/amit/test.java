import java.io.*;
	import java.sql.*;
	
	class test
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:amit";

			Connection conn=DriverManager.getConnection(url);

			Statement st=conn.createStatement();

			System.out.println("\nConnection Created");

			/*String sql="create database extern";
			st.execute(sql);
			System.out.println("\nDatabase Created Successfully");*/

			String sql1="use extern";
			st.execute(sql1);
			System.out.println("\nNow you can use the database extern\n");

			/*String sql2="CREATE TABLE student(sno int primary key,sname varchar(20))";
			st.execute(sql2);
			System.out.println("\nTable is Created Successfully");

			String sql3="insert into student values(30,'ajit')";			
			st.execute(sql3);
			System.out.println("\n1 Row Inserted");	*/

			String text=" ";
			String sql="select * from student";
			ResultSet rs=st.executeQuery(sql);
			System.out.println("\nBefore Deleting 1 Row....\n");			
			System.out.println("\nSt No\tSt Name\n");
			while(rs.next())
				{
				text=text+rs.getString(1) +"\t"+rs.getString(2)+"\n";
				}
			System.out.println(text);

			String text1=" ";

			String sql4="delete from student where sno=20";			
			st.execute(sql4);
			System.out.println("\n1 Row Deleted");	

			String sql5="select * from student";
			ResultSet rs1=st.executeQuery(sql5);
			System.out.println("\nAfter Deleting 1 Row....\n");			
			System.out.println("\nSt No\tSt Name\n");
			while(rs1.next())
				{
				text1=text1+rs1.getString(1) +"\t"+rs1.getString(2)+"\n";
				}
			System.out.println(text1);

			}
		
	catch(SQLException e)
			{
			System.out.println("\nError");
			}
		catch(ClassNotFoundException e)
			{
			}
		}
	
	}