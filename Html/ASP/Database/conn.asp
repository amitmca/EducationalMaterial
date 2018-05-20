<%
set conn=Server.CreateObject("ADODB.Connection")
conn.Provider="Microsoft.Jet.OLEDB.4.0"
conn.Open "D:/Programs/Html/ASP/company.mdb"
Response.write("Connection Created")
%>