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
			String name=request.getParameter("name");
			String addr=request.getParameter("addr");

			String sql="insert into student values('"+rno+"','"+name+"','"+addr+"')";
			st.executeUpdate(sql);
			out.println("1 Row Inserted");
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}
%>
</body>
</html>	