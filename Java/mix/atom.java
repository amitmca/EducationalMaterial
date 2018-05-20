	import java.io.*;
	import java.sql.*;
	class atom
	{
	public static void main(String args[])throws IOException
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:amit";
			Connection conn=DriverManager.getConnection(url);
			Statement st=conn.createStatement();
			System.out.println("\nConnection Created");
			DataInputStream dis=new DataInputStream(System.in);
			int choice;
			do
				{
				System.out.println("\n\t1)Display:");
				System.out.println("\n\t2)Delete:");
				System.out.println("\n\t3)Update:");
				System.out.println("\n\t4)Exit:");
				System.out.println("\n\tEnter your choice:");
				choice=Integer.parseInt(dis.readLine());	
				switch(choice)
					{
					case 1:
						System.out.println("\nAtomicWeight\tName\tSymbolic Name\n");
						String text=" ";
						String sql="select * from oxygen";
						ResultSet rs=st.executeQuery(sql); 
						while(rs.next())
							{
							text=text+"\t" +rs.getString(1) + "\t" +rs.getString(2) +"\t" +rs.getString(3) +"\n"; 
							}
					System.out.println(text);
					break;

					case 2:
						System.out.println("\nEnter the atomic weight of the element to delete:");
						int aweight=Integer.parseInt(dis.readLine());
						PreparedStatement ps=conn.prepareStatement("delete from oxygen where aw=?");
						ps.setInt(1,aweight);
						int p=ps.executeUpdate();
						System.out.println("\n" +p +" "+"Row Deleted"); 
					break;
						
					case 3:
						System.out.println("\nEnter the atomic weight which you want to update:");
						int atmw=Integer.parseInt(dis.readLine());
						System.out.println("\nEnter the name of the atom:");
						String aname=new String(dis.readLine());
						PreparedStatement ps1=conn.prepareStatement("update oxygen set name=? where aw=?");
						ps1.setInt(2,atmw);
						ps1.setString(1,aname);
						int pv=ps1.executeUpdate();
					 	System.out.println("\n" +pv +" "+"Row Updated"); 
					break;
					}		
				}while(choice!=4);
			}
		catch(SQLException e)
			{
			System.out.println("\nError");
			}
		catch(ClassNotFoundException e)
			{
			System.out.println("\nError");
			}
		}
	}