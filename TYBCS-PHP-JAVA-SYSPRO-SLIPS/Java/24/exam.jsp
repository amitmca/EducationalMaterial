<HTML>
<BODY>

<%@ page import="java.sql.*,java.io.*" %>
<%! ResultSet rs;
	Connection con;
	Statement smt;
	int c;
%>	

<form action="exam.jsp" method="get">

<%
c=0;
Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","jp");
Statement smt=con.createStatement();
if(session.getAttribute("count")==null)
{
	session.setAttribute("count","1");
	c=1;
}
else
{
	c=Integer.parseInt(session.getAttribute("count")+"");
	c++;
	session.setAttribute("count",c+"");
}
	out.println("Loaded"+c);
	String html="";
	rs=smt.executeQuery("select * from exam where id="+c);
	if(rs.next())
	{
		html=html+rs.getString("que");
		html=html+"<br><input type='radio' name='option' value='A'>"+rs.getString("opt1");
		html=html+"<br><input type='radio' name='option' value='B'>"+rs.getString("opt2");
		html=html+"<br><input type='radio' name='option' value='C'>"+rs.getString("opt3");
	}
	out.println(html);
	session.setAttribute((c-1)+"",request.getParameter("option"));

if(request.getParameter("submit")!=null)
{
	response.sendRedirect("result.jsp");
}
%>

<input type="submit" name="submit" value="Submit">
<input type="submit" name="next" value="Next">

</BODY>
</HTML>