import java.sql.*;


class fetch
	{
	public static void main(String args[])
	{
	Connection con2=null;

	Statement stmt1;
	try
			{
						
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con2=DriverManager.getConnection(url,"","");

			stmt1=con2.createStatement();

			String sql="select usr,pass from login";

			ResultSet rs=stmt1.executeQuery(sql);

			String usr="",pass="";

			String u="amit",p="rahman";

			while(rs.next())
				{
		
				usr=rs.getString(1);
		
				pass=rs.getString(2);

				if(usr.equals(u) && pass.equals(p))
					{
					System.out.println("Login Successful");
					}
				else	
					{
					System.out.println("Login Failed");
					break;
					}
				}
		
			System.out.println(usr+"\t"+pass);
		
			}
	catch(SQLException e1)
			{
			}
			catch(ClassNotFoundException e3)
			{
			
			}
	}
	}