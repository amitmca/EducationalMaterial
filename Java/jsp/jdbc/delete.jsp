<html>
<head>
<title>JDBC Using JSP</title>
</head>
<body>
<%@page import="java.sql.*" %>

<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			String rno=request.getParameter("rno");
			
			String sql="delete from student where sno='"+rno+"'";
			st.executeUpdate(sql);
			out.println("<b>1 Row Deleted");
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}
%>
</body>
</html>	