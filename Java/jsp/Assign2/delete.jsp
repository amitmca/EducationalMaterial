<%@page import="java.sql.*;" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Insert</title>
</head>

<body>

<% 
try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
	String url="jdbc:odbc:SQLITE";
		
	Connection conn1=DriverManager.getConnection(url);
		
	Statement st1=conn1.createStatement();
	
	String id="";
	
	id=request.getParameter("bid"); 
	
	String sql="delete from Book where bid='"+id+"'"; 
	
	st1.executeUpdate(sql);
	%>	
	<script language="javascript">
	alert("Deleted");
	</script>
	<%
	}
	catch(Exception e)
	{
	%>
	<script language="javascript">
	var st ="Please check the query"; 
	alert(st);
	</script>
	<%	
	}
 %>
 <jsp:include page="Book.jsp" />	
</body>

</html>
