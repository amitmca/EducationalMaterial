<%
Session.Timeout=5
Response.write("Session Timeout is created")
Session.Abandon
Response.write("<br>Session Timeout is created using abondon")
%>
