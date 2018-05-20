<html>
<head>
<title>JDBC Using JSP</title>
</head>
<body>
<%@page import="java.sql.*" %>
<table border="0" bordercolor="red"  align="center" valign="middle" background="HDR_WIZ_RIGHT.PNG">
<th>
	<tr>
		<td><font color="red"><b>Roll no</font></td>
		<td><font color="red"><b>Name</font></td>
		<td><font color="red"><b>Address</font></td>
	</tr>
</th>

<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			String sql="select * from student order by sno";

			ResultSet rs=st.executeQuery(sql);

			String rno="",name="",addr="";
				
	
			while(rs.next())
				{
				rno=rs.getString(1);
				name=rs.getString(2);
				addr=rs.getString(3);	
				%>
				<tr>
				<td><font color="green"><b><% out.println(rno); %></b></font></td>
				<td><font color="green"><% out.println(name); %></b></font></td>
				<td><font color="green"><% out.println(addr); %></b></font></td>
				</tr>
				<%				
				}		
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}

%>

</body>
</html>	