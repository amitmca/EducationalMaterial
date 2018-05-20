<html>
<body>
<%@ page import="java.util.*"%>

<%
out.println("<br>"+new Date());
out.println("<br>"+request.getHeader("user-agent"));
out.println("<br>"+new Date());
	Cookie ck=new Cookie("aaa","bbb");
	response.addCookie(ck);
	out.println("<br>"+"Cookies added");
	out.println("<br>"+application.getInitParameter("driver"));
	out.println("<br>"+config.getInitParameter("state"));
	
%>

</body>
</html>
