<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Login</title>

<script language="javascript">

function checklogin()
{
  var err="";
  
	 
  if(document.getElementById("usr").value=="")
  	{ 
  	err +="\nPlease enter User Name .\t\n";
  	}
  if(document.getElementById("pass").value=="")
  	{ 
  	err +="\nPlease enter password .\t\n";
  	}
 
  

  
   if(err=="")
  { return true;}
  else
  { alert(err) 
   return false;
   }
}
</script>
</head>

<body>
<form name="form" action="http://localhost:8080/examples/jsp/Assign1/login.jsp">



</form>
<table border="0" width="293" height="171" align="center" bgcolor="lightyellow">
	<tr>
		<td height="171" width="283" align="center">
		<fieldset style="width: 283px; height: 7px">
		<font color="red"><b>
		<%@page import="java.sql.*"%>		
		<%
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
			
			Statement st=conn.createStatement();
			
			String username=request.getParameter("usr");
			
			String password=request.getParameter("pass");
		
			String sql="select * from login where usr='"+username+"' and pass='"+password+"'";
			
			ResultSet rs=st.executeQuery(sql);
			
			String u="",p="";
							
			while(rs.next())
				{
				u=rs.getString(1);
				p=rs.getString(2);
				}
			if(username.equals(u) && password.equals(p))
				{
				out.println("Welcome "+username);
				%>
				<br><br><br>GO Back<a href="login1.jsp"><img src="previous.png" border=0></a>
				<%
				}			
			else
				{				
				String sql1="select * from login where usr='"+username+"'";
				
				ResultSet rs1=st.executeQuery(sql1);
				
				String u1="";
							
				while(rs1.next())
					{
					u1=rs1.getString(1);
					}
				if(username.equals(u1))
					{
					out.println("User "+username+" Already Exists");
					%>
					<jsp:include page="login1.jsp" />		
					<%
					}		
				else
					{
					String sql2="insert into login values('"+username+"','"+password+"')";
					st.executeUpdate(sql2);
					out.println("Registered ");
					%>
					<br><br><br>GO Back<a href="login1.jsp"><img src="previous.png" border=0></a>
					<%
					}					
				}				
			}
		catch(Exception e)
			{
			out.println(e.getMessage());
			}				
		%></b>
		</font>
	     </fieldset>
		</td>
	</tr>
</table>
</body>

</html>