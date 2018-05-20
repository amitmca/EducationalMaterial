Welcome <%Response. Write (Session ("username")) %>
<% 
 Session.Contents.Remove("username") 
Response.write("Session variable removed")
%>