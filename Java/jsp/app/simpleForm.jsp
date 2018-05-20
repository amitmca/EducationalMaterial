<HTML>
<HEAD> <TITLE> JSP that processes parameters in a link </TITLE> </HEAD>
<BODY>
Parameters
<UL>
    <LI>First Name = <%= request.getParameter("firstName") %>
   <LI>Last Name = <%= request.getParameter("lastName") %>
</UL>
</BODY> </HTML>
