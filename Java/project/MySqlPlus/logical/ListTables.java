import java.sql.*;
public class ListTables 
{
  public static void main(String [] args) 
   {
    Connection con = null;
    try 
    {

      Class.forName("com.mysql.jdbc.Driver");

      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amit","root","amit12");

      DatabaseMetaData meta = con.getMetaData();

      ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});

      System.out.println("List of tables: "); 

      while (res.next()) 
	{
         System.out.println(res.getString("TABLE_NAME")); 
        }

      ResultSet res1 = meta.getColumns(null, null, "register", null);

      while (res1.next())
            {
            System.out.println(res.getString());
	    }
	
      res.close();

      con.close();
    } 
    catch (java.lang.ClassNotFoundException e)
     {
     System.err.println("ClassNotFoundException: "+e.getMessage());
     }
   catch (SQLException e) 
     {
     System.err.println("SQLException: "+e.getMessage());
     }
  }
}
