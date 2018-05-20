	import java.io.*;
	import java.sql.*;
	
	class jdbcp
	{
	public static void main(String args[])throws IOException
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQLITE";
			Connection conn=DriverManager.getConnection(url);
			Statement st=conn.createStatement();
			System.out.println("\nConnection Created");
			DataInputStream dis=new DataInputStream(System.in);
			int choice;
			do
				{
				System.out.println("\n\t1)Display:");
				System.out.println("\n\t2)Insert:");
				System.out.println("\n\t3)Delete:");
				System.out.println("\n\t4)Update:");
				System.out.println("\n\t5)Search:");
				System.out.println("\n\t6)Exit:");
				System.out.println("\n\tEnter your choice:");
				choice=Integer.parseInt(dis.readLine());	
				switch(choice)
					{
					case 1:
						System.out.println("\nStudent No\tStudent Name\tAddress\n");
						String text=" ";
						String sql="select * from student";
						ResultSet rs=st.executeQuery(sql); 
						while(rs.next())
							{
							text=text+"\t" +rs.getString(1) + "\t" +rs.getString(2) +"\t" +rs.getString(3) +"\n"; 
							}
					System.out.println(text);
					break;

					case 2:
						System.out.println("\n\tRoll No:");
						int s1=Integer.parseInt(dis.readLine());
						System.out.println("\n\tName:");
						String s2=new String(dis.readLine());
						System.out.println("\n\tAddress:");
						String s3=new String(dis.readLine());
						PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?)");
						ps.setInt(1,s1);
						ps.setString(2,s2);
						ps.setString(3,s3);
						int p=ps.executeUpdate();
						System.out.println("\n" +p +" "+"Row inserted"); 
					break;

					case 3:
					System.out.println("\nEnter the roll number ro deleted:");
					int rno2=Integer.parseInt(dis.readLine());
					PreparedStatement ps1=conn.prepareStatement("delete from student where sno=?");
					ps1.setInt(1,rno2);
					int p1=ps1.executeUpdate();
	 			        System.out.println("\n\t"+p1 +"Row deleted:");	
					break;

					case 4:
					System.out.println("\nEnter the roll number to which you want to update:");
					int rno1=Integer.parseInt(dis.readLine());	
					System.out.println("\nEnter the name of the student:");
					String name1=new String(dis.readLine());
					PreparedStatement ps2=conn.prepareStatement("update student set sname=? where sno=?");
					ps2.setInt(2,rno1);
					ps2.setString(1,name1);
					int pv=ps2.executeUpdate();
					System.out.println("\nEnter the address:");
					String s=new String(dis.readLine());
					PreparedStatement ps3=conn.prepareStatement("update student set per1=? where roll=?");
					ps3.setInt(2,rno1);
					ps3.setString(1,s);
					System.out.println("\n\t"+pv +"Row updated:");

					case 5:
					int flag=0;
					System.out.println("\nEnter the roll number to which you want to search:");	
					int rno3=Integer.parseInt(dis.readLine());
					ResultSet rs1=st.executeQuery("select * from student");
					while(rs1.next())
						{
						if(rs1.getInt(1)==rno3)
							{
							flag=1;
							break;
							}	
						}
					if(flag==0)
						System.out.println("\nRecord is not found");
					else
						System.out.println("\nRecord is found");
					break;
					}
				}while(choice!=6);
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