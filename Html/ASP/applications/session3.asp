<%
Session("username")="Donald Duck"
Session("age")=50
dim i
For Each i in Session.Contents
  Response.Write(i & "<br />")
Next
%>
