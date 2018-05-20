<%
 IF Len(Request.QueryString("page"))=0 THEN
   %>
   <HTML><BODY>
   You are on page1<BR>
   <A HREF="somepage.asp?page=2">Page 2</A>
   </BODY></HTML>
   <%
 ELSEIF Request.QueryString("page")="2" THEN
   %>
   <HTML><BODY>
   You are on page 2<BR>
   <A HREF="somepage.asp?page=3">Page 3</A>
   </BODY></HTML>
   <%
 ELSEIF Request.QueryString("page")="3" THEN
   %>
   <HTML><BODY>
   You are on page 3<BR>
   <A HREF="somepage.asp">Page 1</A>
   </BODY></HTML>
   <%
 END IF
 %> 