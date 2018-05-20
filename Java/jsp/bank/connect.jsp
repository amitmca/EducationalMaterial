<%@ page language="java" import="java.sql.*;"%>

<%

    System.out.println("MySQL Connect Example.");
Connection conn = null;
    String url = "jdbc:odbc:mysql";
//	 String dbName = "userdetails";
    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    String username = "root"; 
    String password = " ";
	
    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url,userName,password);
	  out.println("ok");
      System.out.println("Connected to the database");
      conn.close();
      System.out.println("Disconnected from database");
    } catch (Exception e) {
      e.printStackTrace();
    }
 %> 