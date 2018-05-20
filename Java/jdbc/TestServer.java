import java.sql.*;
import java.io.*;

  public class TestServer 
  {
    static 
    {
        try  { 
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } 
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String args[]) {
        Connection conn=null;
        Statement stmt=null;
        String sql="",sql1="",table="emp";
        ResultSet rs=null;
 
        try {
            conn=DriverManager.getConnection("jdbc:odbc:wodbc","","");
            stmt=conn.createStatement();
            sql="select * from emp";
	    DataInputStream dis=new DataInputStream(System.in);	
            String eno=dis.readLine();
  	    String ename=dis.readLine();
		
	    sql1="insert into "+table+" values('"+eno+"','"+ename+"')";		
	    stmt.executeUpdate(sql1);
            rs=stmt.executeQuery(sql);
	    	

            while(rs.next()){
                System.out.println(rs.getString("USERID")+
                  " "+ rs.getString("FIRST_NAME")+" "+ 
                  rs.getString("LAST_NAME"));
            }
        } 
        catch (Exception e){
            System.err.println(e);
        } 
        finally {
            try{
                rs.close();
                stmt.close();
                conn.close();
                rs=null;
                stmt=null;
                conn=null; 
            }
            catch(Exception e){}
        }
    }
 }
