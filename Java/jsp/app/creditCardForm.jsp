<HTML>
<HEAD> <TITLE>Credit Card Processing JSP</TITLE>
</HEAD>
<BODY>
  Verify Credit Card Information:
<UL>
  <LI>Name   = <%= request.getParameter("name") %>
  <LI>Number = <%= request.getParameter("number") %>
  <LI>Type   = <%= request.getParameter("type") %>
  <LI>Date   = <%= request.getParameter("month") %>/
               <%= request.getParameter("year")%>
</UL>
</BODY>
</HTML>
