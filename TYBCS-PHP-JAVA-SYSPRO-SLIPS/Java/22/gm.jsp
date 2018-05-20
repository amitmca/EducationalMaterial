<html>
<body>

<%@ page import="java.util.*"%>
<form action="ass4setb1.jsp" method="get">
Enter User name<input type="text" name="uname"><br>
<input type="submit" value="OK">
<%
Date d= new Date();
int hr=d.getHours();
String m="";

if(hr>=5 && hr<12)
{
		m="GM";
}

else if(hr>=12 && hr<18)
{
		m="GA";
}

else if(hr>=18 && hr<24)
{
		m="GN";
}


if(request.getParameter("uname")!=null)
{
String name=request.getParameter("uname");
out.println(m+"!!!!"+" "+name);
}
%>

</form>
</body>
</html>
