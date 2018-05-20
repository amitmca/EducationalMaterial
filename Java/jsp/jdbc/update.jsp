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
		
			int orno=Integer.parseInt(request.getParameter("orno"));
			int nrno=Integer.parseInt(request.getParameter("nrno"));
			String name=request.getParameter("name");
			String addr=request.getParameter("addr");

			String sql="update student set sno=? and name=? and addr=? where sno=?";
			PreparedStatement st=conn.prepareStatement(sql);	
			st.setInt(1,nrno);
			st.setString(2,name);
			st.setString(3,addr);
			st.setInt(4,orno);

			st.executeUpdate();
			out.println("1 Row Updated");
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}
%>
</body>
</html>	