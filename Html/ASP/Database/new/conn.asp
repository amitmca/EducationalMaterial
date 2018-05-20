<b>
<%
Set MyConn = Server.CreateObject("ADODB.Connection")
MyConn.Open "FILEDSN=C:\Inetpub\wwwroot\asp\Database\new\mimer.dsn"
Response.write("Connected Successfully")
%>
