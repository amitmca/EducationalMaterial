<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Bidding Information System</title>
</head>

<body>
<form name="form" method="post" action="http://localhost:8080/examples/jsp/Bidding/insert1.jsp">
<table border="1" width="393" height="28" align="center">
	<tr>
		<td height="28" width="383">
		<p align="center"><b><font size="4" face="Verdana" color="#FF0000">
		Bidding Information System</font></b></td>
	</tr>
</table>
<table border="1" width="394" height="29" align="center">
	<tr>
		<td height="23" width="384">
		<b>
		<font color="#0055bb" size=4>&nbsp;<a href="http://localhost:8080/examples/jsp/Bidding/insert.jsp"> Insert</a></font><font size="4">
		<font color="#0055bb" size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/examples/jsp/Bidding/max.jsp"> Show Max</a></font><font size="4">
		</font></b>
		</td>
	</tr>
</table>



<table border="1" width="392" height="174" align="center">
	<tr>
		<td height="32" width="382" align="center">
		<%@page import="java.sql.*;" %>
		<%
		
		
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			Connection conn=DriverManager.getConnection("jdbc:odbc:amit");
			
			Statement st=conn.createStatement();
			
			String sql="select max(amount),cno,cname,addr,date from Customer group by cno,cname,addr,date ";
			
			ResultSet rs=st.executeQuery(sql);
			
			String m="",no="",name="",ad="",date="";
			
			while(rs.next())
				{
				m=rs.getString(1);
				no=rs.getString(2);
				name=rs.getString(3);
				ad=rs.getString(4);
				date=rs.getString(5);

				}
				%>				
				<table border="1" bordercolor="red">
				<tr>
					<td><%=no %></td>
					<td><%=name %></td>
					<td><%=ad %></td>
					<td bgcolor="yellow"><%=m %></td>
					<td><%=date %></td>
				</tr>
				</table>
				<%
	     	}
		catch(Exception e)
			{
			out.println(e.getMessage());
			}			
		%>

		</td>
		<jsp:plugin type="applet" code="draw"></jsp:plugin>
	</tr>
</table>
</form>
</body>

</html>