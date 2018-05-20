<HTML>
<BODY>
<B>Price List DB Sample</B>
<%
Actionvar=Request.QueryString("actionvar")

Set conn = server.createobject("adodb.connection")
DSNtemp="DRIVER={Microsoft Access Driver (*.mdb)}; "
DSNtemp=dsntemp & "DBQ=" & server.mappath("pricelist.mdb")
conn.Open DSNtemp

'If the QueryString has the Actionvar = add then generate
'the page for adding items
IF Actionvar="add" THEN
  IF Len(TRIM(request.form("flag"))) = 0 THEN
    %>
    Add<HR>
    <FORM METHOD="post" ACTION="moddata.asp?Actionvar=add">
    Item: <INPUT TYPE="text" NAME="Item"><BR>
    Price: $<INPUT TYPE="text" NAME="Price"><BR>
    Order #: <INPUT TYPE="text" NAME="Ordernumber"><BR>
    <INPUT TYPE="hidden" NAME="flag" VALUE="2">
    <INPUT TYPE="submit" VALUE="ADD">
    </FORM>
    <%
  ELSEIF Request.Form("flag")="2" THEN
    SQLstmt = "INSERT INTO Prices (Item,Price,Ordernumber)"
    SQLstmt = SQLstmt & " VALUES ('" & request.form("Item") & "','" & request.form("Price") & "','" & request.form("Ordernumber") & "')"
    %>
    <HR>
    SQL statement: <%=SQLstmt%>
    <HR>
    <%
    conn.execute(SQLstmt)
    Response.Write "Operation Complete<BR><A HREF=""moddata.asp"">Home</A>"
  END IF

'If the QueryString has the Actionvar = update then generate
'the page for updating items
ELSEIF Actionvar="update" THEN
  IF Len(TRIM(Request.Form("flag"))) = 0 THEN
    SQLstmt = "SELECT * FROM Prices WHERE ID=" & Request.QueryString("Recid")
    %>
    <HR>
    SQL statement: <%=SQLstmt%>
    <HR>
    <%
    Set rs = conn.Execute(SQLstmt)
    IF NOT RS.EOF THEN 
    %>
      Update<HR>
      <FORM METHOD="post" ACTION="moddata.asp?Actionvar=update">
      <B>Item:</B> <INPUT TYPE="text" NAME="Item" VALUE="<%=rs("Item")%>"><BR>
      <B>Price:</B> $<INPUT TYPE="text" NAME="Price" VALUE="<%=rs("Price")%>"><BR>
      <B>Ordernumber:</B> <INPUT TYPE="text" NAME="Ordernumber" VALUE="<%=rs("Ordernumber")%>"><BR>
      <INPUT TYPE="hidden" NAME="flag" VALUE="2">
      <INPUT TYPE="hidden" NAME="Recordid" VALUE="<%=rs("ID")%>">
      <INPUT TYPE="submit" VALUE="Update">
      </FORM>
      <% 
      rs.MoveNext
      rs.Close
    END IF
  ELSEIF Request.Form("flag")="2" THEN
    SQLstmt = "UPDATE Prices SET "
    SQLstmt = SQLstmt & "Item='" & TRIM(Request.Form("Item")) & "', "
    SQLstmt = SQLstmt & "Price='" & TRIM(Request.Form("Price")) & "', "
    SQLstmt = SQLstmt & "Ordernumber=" & TRIM(Request.Form("Ordernumber"))
    SQLstmt = SQLstmt & " WHERE ID=" & TRIM(Request.Form("Recordid"))
    %>
    <HR>
    SQL statement: <%=SQLstmt%>
    <HR>
    <%
    Conn.Execute (SQLstmt)
    Response.Write "Operation Complete<br><A HREF=""moddata.asp"">Home</A>"
  END IF

'If the QueryString has the Actionvar = delete then delete the item
'and generate an "Operation Complete" page
ELSEIF Actionvar="delete" THEN
  SQLstmt = "DELETE * FROM Prices WHERE ID=" & TRIM(Request.QueryString("Recid"))
  %>
  <HR>
  SQL statement: <%=SQLstmt%>
  <HR>
  <%
  conn.execute(SQLstmt)
  Response.Write "Operation Complete<BR><A HREF=""moddata.asp"">Home</A>"

'If the QueryString Actionvar isn't set to anything, generate the list of items
ELSE
  SQLstmt = "SELECT * FROM Prices"
  %>
  <HR>
  SQL statement: <%=SQLstmt%>
  <HR>
  <%
  Set rs = conn.Execute(SQLstmt)
  %>
  <TABLE BORDER=0>
  <TR>
  <TD><CENTER><B>Item</B></CENTER></TD>
  <TD>&nbsp;</TD>
  <TD><CENTER><B>Price</B></CENTER></TD>
  <TD>&nbsp;</TD>
  <TD><CENTER><B>Order #</B></CENTER></TD>
  <TD COLSPAN=2><CENTER><B>Modify</B></CENTER></TD>
  <%
  x=0
  DO WHILE NOT rs.EOF
    x=x+1
    Recid = rs("ID")
    Item = rs("Item")
    Price = rs("Price")
    Ordernumber = rs("Ordernumber")
    %>
    <TR>
    <TD><%=x%>) <%=Item%></TD>
    <TD>&nbsp;</TD>
    <TD ALIGN=RIGHT>$<%=Price%></TD>
    <TD>&nbsp;</TD>
    <TD><%=Ordernumber%></TD>
    <TD><CENTER><A HREF="moddata.asp?Actionvar=delete&Recid=<%=Recid %>">Delete</A></CENTER></TD>
    <TD><A HREF="moddata.asp?Actionvar=update&Recid=<%=Recid %>">Update</A></TD>
    <%
    rs.MoveNext
  LOOP
  RS.Close
  Response.Write "</TABLE>"
  Response.Write "<HR><A HREF='moddata.asp?actionvar=add'>Add a Record</A>"
END IF

conn.Close
Set conn = nothing
Set SQLstmt = nothing
%>
</BODY>
</HTML>