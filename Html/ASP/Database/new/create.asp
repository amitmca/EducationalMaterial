<b>
<font color="red"><h2>Databases:</h2></font>
<%

Set MyConn = Server.CreateObject("ADODB.Connection")

MyConn.Open "FILEDSN=C:\Inetpub\wwwroot\asp\Database\new\mysql.dsn"

sql="show databases"

Set RS=MyConn.execute(sql)

while not RS.EOF

	Response.write(RS("Database")&"<br>")

RS.MoveNext()

wend	

MyConn.close
%>

<font color="red"><h2>Tables:</h2></font>

<b>
<%

Set MyConn = Server.CreateObject("ADODB.Connection")

MyConn.Open "FILEDSN=C:\Inetpub\wwwroot\asp\Database\new\mysql.dsn"

sql="show tables"

Set RS=MyConn.execute(sql)

while not RS.EOF

	Response.write(RS("Tables_in_amit")&"<br>")

RS.MoveNext()

wend	

MyConn.close
%>