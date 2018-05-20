<%
'*****************************************************
'* Code written by Alexander Haneng (C) 1998-2001    *
'* FREE download from http://www.haneng.com/         *
'*****************************************************
%>

<HTML>
<BODY>
<B>Here are my friends:<B><BR>
<%
 Set MyConn = Server.CreateObject("ADODB.Connection")
 MyConn.Open "FILEDSN=c:\dsn\MyTable_dsn.dsn"
 SQL_query = "SELECT * FROM Friends"
 Set RS = MyConn.Execute(SQL_query)
 WHILE NOT RS.EOF
%>
 <LI><%=RS("Name")%>: <A HREF="<%=RS("Link")%>">Homepage</A>
<%
 RS.MoveNext
 WEND
 RS.Close
 MyConn.Close
%>
</BODY>
</HTML>