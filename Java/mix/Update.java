import java.io.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
	
class Update
	{
	public static void main(String args[])throws IOException,NumberFormatException
	        {
	        PreparedStatement st;
	         int n;
	        String name;
          	        try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url="jdbc:odbc:SQLITE";
		System.out.println("\nDriver Loaded");
		Connection conn=DriverManager.getConnection(url);
		st=conn.prepareStatement("update student set values name=? where rno=?");
                                   BufferedReader br3= new BufferedReader(new InputStreamReader (System.in)); 
                                  //  DataInputStream br3= new DataInputStream(System.in);   
                                  System.out.print("Enter the  roll no and name which is to be updated");
                                  n=Integer.parseInt(br3.readLine());
                                  name=br3.readLine();
                                  st.setInt(1,n);
                                  st.setString(2,name);
                                  int pov=st.executeUpdate();
                                 System.out.print("\n  "+pov+ " row is updated");
                                }
                        catch(SQLException e)
                               {  
                               System.out.print(" "+e);
                               }
	      catch(ClassNotFoundException e)
                             {  
                             System.out.print(" "+e);
                            }
	   }
         }         
                          
                       