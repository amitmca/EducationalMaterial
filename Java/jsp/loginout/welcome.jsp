<%@ page import="java.sql.*,java.util.*" %>
<html>
<body>
<br><br>
<table align="center" width="300px" border=0>
<%
String username="";
if(session.getAttribute("username")!=null && session.getAttribute("username")!="")
{
username=session.getAttribute("username").toString();
%>
  <tr>
     <td align="right" width="690"><a href="home.jsp">Home</a></td>
     <td align="right"><a href="logout.jsp">Logout</a></td>
  </tr>
<%
}
else
{
%>
  <tr>
     <td align="right"><a href="home.jsp">Home</a></td>
     <td align="right"><a href="login.jsp">Login</a></td>
  </tr>
<%
}
%>
<tr><td colspan=2>&nbsp;</td></tr>
<tr><td colspan=2><h1>Welcome <%=username%></h1></td></tr>
<table>
</body>
</html> 