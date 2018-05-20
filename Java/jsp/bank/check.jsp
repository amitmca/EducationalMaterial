<%@ page language="java" import="java.sql.*;"%>

<%

    System.out.println("MySQL Connect Example.");
Connection conn = null;
    String url = "jdbc:odbc:mysql";

    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    String userName = "root"; 
    String password = " ";
	
   
      Class.forName(driver).newInstance();
	
	  try {
       conn = DriverManager.getConnection(url,userName,password);
	     
        Statement stmt = conn.createStatement();
		ResultSet rst = stmt.executeQuery("select * from user");
		while(rst.next()){
			out.println(rst.getString(2));
		}

      System.out.println("Connected to the database");
      conn.close();
      System.out.println("Disconnected from database");
    } catch (Exception e) {
      e.printStackTrace();
    }
      
    
 %> 