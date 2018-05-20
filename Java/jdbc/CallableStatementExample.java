import java.sql.CallableStatement; 
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Types; 




public class CallableStatementExample 
{ 
   public static void main(String[] args) 
   { 
    try 
     { 
     Class.forName("com.mysql.jdbc.Driver");

     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MysqlPlus","root","amit12"); 

     CallableStatement call = con.prepareCall("call MysqlPlus.Test(?,?,?)"); 

     call.setInt(1,2); 

     call.setInt(2,2); 

     call.registerOutParameter(3,Types.INTEGER); 

     call.execute(); 

     System.out.println("The addition is "+call.getInt(3));

     con.close(); 
     }
    catch (Exception e) 
     {
     e.printStackTrace();
     } 
   }
} 

