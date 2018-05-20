<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<style type="text/css">
 tr{font-size:17px;font-weight:bold;text-align:center}
</style>  
</head>

<body>
<center>
<div style="border-style: solid; border-width: 1px; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px">
	<span style="background-color: #FFFF00"><b>
	<font face="Verdana" color="#0000FF"><a href="http://localhost:8080/examples/jsp/Database/new/menu.html">Home</a> |&nbsp;<a href="http://localhost:8080/examples/jsp/Database/new/insert.html">Insert </a>|<a href="http://localhost:8080/examples/jsp/Database/new/delete.html"> Delete </a>|<a href="http://localhost:8080/examples/jsp/Database/new/update.html"> Update</a> | 
	<a href="http://localhost:8080/examples/jsp/Database/new/select.jsp">Display</a>|<a href="http://localhost:8080/examples/jsp/Database/new/search.html">Search</a>
	</font></b></span></div>
</center>



<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>

<center>
<b>
<%@page import="java.sql.*" %>

<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			String eno=request.getParameter("eno");
			String ename=request.getParameter("ename");

			String sql="insert into emp values('"+eno+"','"+ename+"')";
			st.executeUpdate(sql);
			out.println("1 Row Inserted");
			
			conn.close();
			}

		catch(Exception e)
			{
			out.println(e);
			}
%></b>
</center>
<h2><center><a href="http://localhost:8080/examples/jsp/Database/new/insert.html">Insert Another</a></center></h2>

<%@page import="java.sql.*" %>
<table border="1" bordercolor="red"  align="center" valign="middle" background="HDR_WIZ_RIGHT.PNG">
<th>
	<tr>
		<td><font color="red"><b>Emp No</font></td>
		<td><font color="red"><b>Emp Name</font></td>
		
	</tr>
</th>

<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			String sql="select * from emp order by eno";

			ResultSet rs=st.executeQuery(sql);

			String eno="",ename="";
				
	
			while(rs.next())
				{
				eno=rs.getString(1);
				ename=rs.getString(2);
				%>
				<tr>
				<td><font color="green"><b><% out.println(eno); %></b></font></td>
				<td><font color="green"><% out.println(ename); %></b></font></td>
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


</table>

</body>