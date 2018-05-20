<%@ page import="java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat" %>
<html>
<head>
<TITLE>Login Application</TITLE>
</head>
<body>
<br><br>
<table align="center" width="400px" border=0>
  <%
  if(session.getAttribute("username")!=null && session.getAttribute("username")!="")
  {
  %>
    <tr>
      <td align="right" width="350"><a href="home.jsp">Home</a></td>
      <td align="right"><a href="logout.jsp">Logout</a></td>
    </tr>
  <%
  }
  else
  {
  %>
  <tr>
    <td align="right" width="350"><a href="home.jsp">Home</a></td>
    <td align="right"><a href="login.jsp">Login</a></td>
  </tr>
  <%
  }
  %>
</table>

<table width="400px" align="center" border=0> 

  <tr style="background-color:#D9B0D8;">
    <td align="center"><b>User Id</b></td>
    <td align="center"><b>Username</b></td>
    <td align="center"><b>Login</b></td>
    <td align="center"><b>Logout</b></td>
  </tr> 
<%

System.out.println("MySQL Connect Example.");
Connection conn = null;
String url = "jdbc:odbc:mysql";
//String dbName = "ister";
String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
String username = "root"; 
String userPassword = " ";
String user = "";

try 
{
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url,username,userPassword);
  Statement st = conn.createStatement();
  Statement st1 = conn.createStatement();
  String queryString = "select * from admin order by userid";
  ResultSet rs = st.executeQuery(queryString);
  ResultSet rs1=null;
  String queryStringuser="";
  SimpleDateFormat sdfDestination=null;
  int count=0;
  String strcolor = "";
  while(rs.next())
  {
    count = count%2;
    if(count==0)
    {
      strcolor = "#D9D9D9";
    }
    else
    {
      strcolor = "#EFEFEF";
    }
    count++;
    queryStringuser = "select * from userregister where id="+rs.getInt(2);
    rs1 = st1.executeQuery(queryStringuser);
    while(rs1.next())
    {
      user  = rs1.getString(2);
    }

    String inStr="";
    String outStr="";
    java.util.Date date;
    String intime="";
    String outtime="";
    if((rs.getString(3)!=null && rs.getString(3)!=""))
    {
      inStr = rs.getString(3).toString().substring(0,rs.getString(3).toString().indexOf("."));
      try
      {
        date = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(inStr);
        sdfDestination = new SimpleDateFormat("MMM dd, hh:mm:ss");
        intime = sdfDestination.format(date);
      }
      catch (Exception e)
      {
        e.getMessage();
      }
    }

    if((rs.getString(4)!=null && rs.getString(4)!=""))
    {
      outStr = rs.getString(4).toString().substring(0,rs.getString(3).toString().indexOf("."));
      try
      {
        date = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(outStr);
        sdfDestination = new SimpleDateFormat("MMM dd, hh:mm:ss");
        outtime = sdfDestination.format(date);
      }
      catch (Exception e)
      {
        e.getMessage();
      }
    }
    %>
    <tr style="background-color:<%=strcolor%>;">
       <td align="center"><%=rs.getInt(2)%></td>
       <td align="left" style="padding-left:10px;"><%=user%></td>
       <td align="center"><%=intime%></td><td align="center"><%=outtime%></td>
   </tr>
    <%
  }
  conn.close();
} 
catch (Exception e)
{
  e.printStackTrace();
}
%>  