<%@page import="java.sql.*;" %>
<html>
<head>
<title>Book Information</title>

<script language="javascript">
function Insert()
{
  var err="";
  	 
  if(document.getElementById("bid").value=="")
  	{ 
  	err +="\nPlease enter Book ID .\t\n";
  	}
  if(document.getElementById("bname").value=="")
  	{ 
  	err +="\nPlease enter Book Name .\t\n";
  	}
   if(document.getElementById("author").value=="")
  	{ 
  	err +="\nPlease enter Author Name .\t\n";
  	}
    if(document.getElementById("pub").value=="")
  	{ 
  	err +="\nPlease enter Publication Name .\t\n";
  	}
	if(document.getElementById("no").value=="")
  	{ 
  	err +="\nPlease enter Number Of Copies.\t\n";
  	
  	}

   if(err=="")
  { return true;}
  else
  { alert(err) 
   return false;
   }
}

</script>
<script language="javascript">
function Delete()
{
  var err="";
  	 
  if(document.getElementById("bid").value=="")
  	{ 
  	err +="\nPlease enter Book ID .\t\n";
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
<form name="form1" action="http://localhost:8080/examples/jsp/Assign2/delete.jsp" method="post">
<br><br><br><br>
<table border="0" width="446" height="365" align="center">
	<tr>
		<td height="361" width="440">
		<fieldset style="width: 435px; height: 362px">
		<table border="0" width="394" height="342" align="center" bgcolor="lightyellow">
	<tr>
		<td height="23" width="181"><b><font color="red" face="Verdana">Book Id</font></b></td>
		<td height="23" width="16" align="center"><b>:</b></td>
		<td height="23" width="243" align="center"><input type="text" name="bid"></td>
	</tr>



	<tr>
		<td height="25" width="181"><b><font color="red" face="Verdana">Book 
		Name</font></b></td>
		<td height="23" width="16" align="center"><b>:</b></td>
		<td height="23" width="243" align="center"><input type="text" name="bname"></td>	
	</tr>
	<tr>
		<td height="23" width="181"><b><font face="Verdana" color="#FF0000">
		Author name</font></b></td>
		<td height="23" width="16" align="center"><b>:</b></td>
		<td height="23" width="243" align="center"><input type="text" name="author"></td>	
	</tr>
	<tr>
		<td height="26" width="181"><b><font face="Verdana" color="#FF0000">
		Publication</font></b></td>
		<td height="23" width="16" align="center"><b>:</b></td>
		<td height="23" width="243" align="center"><input type="text" name="pub"></td>	
	</tr>
	<tr>
		<td height="22" width="181"><b><font face="Verdana" color="#FF0000">No. 
		Of Copies</font></b></td>
		<td height="23" width="16" align="center"><b>:</b></td>
		<td height="22" width="243">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select name="no">
		<option>Select</option>
		<option name="1" value="1">1</option>
		<option name="2" value="2">2</option>
		<option name="3" value="3">3</option>
		<option name="4" value="4">4</option>
		<option name="5" value="5">5</option>	
		<option name="6" value="6">6</option>
		</select>
		</td>
	</tr>
	
	<tr>
		<td height="181" width="388" colspan="3">
		<fieldset>
		<table cellpadding="0" cellspacing="0" width="451" height="158">
			<!-- MSTableType="layout" -->
			<tr>
			<td width="451" height="158">
				
		</h1></font>	
		<table border="1" height="51" width="453">
		<tr>
			<td height="23" bgcolor="#FFFFFF" align="center"><b>
			<font face="Verdana" size="2" color="#0000FF">BID</font></b></td>
			<td height="23" bgcolor="#FFFFFF" align="center"><b>
			<font face="Verdana" size="2" color="#0000FF">Book Name</font></b></td>
			<td height="23" bgcolor="#FFFFFF" align="center"><b>
			<font face="Verdana" size="2" color="#0000FF">AUTHOR</font></b></td>
			<td height="23" bgcolor="#FFFFFF" align="center"><b>
			<font face="Verdana" size="2" color="#0000FF">Publication</font></b></td>
			<td height="23" bgcolor="#FFFFFF" align="center"><b>
			<font face="Verdana" size="2" color="#0000FF">No </font></b></td>
		</tr>		
				
		<%

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String url="jdbc:odbc:SQLITE";
			
			Connection conn=DriverManager.getConnection(url);
		
			Statement st=conn.createStatement();

			String sql1="select * from Book";

			ResultSet rs=st.executeQuery(sql1);

			String b="",n="",a="",p="",nob="";
				
	
			while(rs.next())
				{
				b=rs.getString(1);
				n=rs.getString(2);
				a=rs.getString(3);
				p=rs.getString(4);
				nob=rs.getString(5);

		%>
			
			<tr>
				<td width="26" bgcolor="#FFFFFF" align="center"><font color="green"><b><% out.println(b); %></b></font></td>
				<td width="113" bgcolor="#FFFFFF" align="center"><font color="green"><b><% out.println(n); %></b></font></td>
				<td width="148" bgcolor="#FFFFFF" align="center"><font color="green"><b><% out.println(a); %></b></font></td>
				<td width="112" bgcolor="#FFFFFF" align="center"><font color="green"><b><% out.println(p); %></b></font></td>
				<td width="20" bgcolor="#FFFFFF" align="center"><font color="green"><b><% out.println(nob); %></b></font></td>
			</tr>
			<%				
			}
			conn.close();
			st.close();
			
			}

		catch(Exception e)
			{
			out.println(e);
			}
			%>

			</table>
			

			</td>
			
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td height="21" width="388" colspan="3">
		<table cellpadding="0" cellspacing="0" width="425" height="41">
			<!-- MSTableType="layout" -->
			<tr>
				<td width="79" height="41">
				
				<input type="submit" name="submit" value="INSERT" style="font-weight: 700; background-color: #FFFFFF" onclick="return Insert();">
						
				</td>
				
				<td width="84" height="41">
				
				<input type="submit" name="submit1" value="DELETE" style="font-weight: 700; background-color: #FFFFFF" onclick="return Delete();">
					
				</td>
				
				<td width="88" height="41">
				<input type="button" name="update" value="UPDATE" style="font-weight: 700; background-color: #FFFFFF">
				</td>
				
				<td width="87" height="41">
				<input type="button" name="search" value="SEARCH" style="font-weight: 700; background-color: #FFFFFF">
				
				</td>
				<td width="87" height="41">
				<input type="button" name="display" value="DISPLAY" style="font-weight: 700; background-color: #FFFFFF">
				
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
		</fieldset>
		</td>
	</tr>
</table>
</form>
</body>
</html>