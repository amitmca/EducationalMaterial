<html>
<body>
<%
set conn=Server.CreateObject("ADODB.Connection")
conn.Provider="Microsoft.Jet.OLEDB.4.0"
conn.Open "D:/Programs/Html/ASP/company.mdb"
set rs = Server.CreateObject("ADODB.recordset")
rs.Open "SELECT * FROM customers", conn
do until rs.EOF
  for each x in rs.Fields
    Response.Write(x.name)
    Response.Write(" = ")
    Response.Write(x.value & "<br />") 
  next
  Response.Write("<br />")
  rs.MoveNext
loop
rs.close
conn.close
%>
</body>
