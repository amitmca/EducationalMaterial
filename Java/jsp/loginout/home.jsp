<HTML>
 <HEAD>
  <TITLE>Login Application</TITLE>
  </HEAD>

  <BODY>
  <br><br><br><br><br>
  <table align="center">
  <%
  if(session.getAttribute("username")!=null && session.getAttribute("username")!="")
  { 
  %>
    <tr><td align="left"><a href="logout.jsp">Click Here to Logout</a></td></tr>
  <%
  }
  else
  {
  %>
    <tr><td align="left"><a href="login.jsp">Click Here to User Login</a></td></tr>
  <%
  }
  %>
  <tr><td align="left">&nbsp;</td></tr>
  <tr><td align="left"><a href="userstatus.jsp">View Users Logon status</a></td></tr>
  </table>
  </BODY>
</HTML> 