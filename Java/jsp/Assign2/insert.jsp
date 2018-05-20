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
	
	String id="",nm="";
	
	id=request.getParameter("bid"); 
	
	nm=request.getParameter("bname");
	
	String a=request.getParameter("author");
	
	String p=request.getParameter("pub");
	
	String no=request.getParameter("no"); 
	
	String sql="insert into Book values('"+id+"','"+nm+"','"+a+"','"+p+"','"+no+"')"; 
	
	st1.executeUpdate(sql);
	%>	
	<script language="javascript">
	alert("Inserted");
	</script>
	<%
	}
	catch(Exception e)
	{
	%>
	<script language="javascript">
	st = "<% String str=e.getMessage(); %>";
	alert(st);
	</script>
	<%	
	}
 %>
 <jsp:include page="Book.jsp" />	
</body>

</html>
