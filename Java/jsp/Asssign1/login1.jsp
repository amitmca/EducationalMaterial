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
<form name="form" action="http://localhost:8080/examples/jsp/Asssign1/login.jsp">



<table border="0" width="293" height="171" align="center">
	<tr>
		<td height="171" width="283">
		<fieldset>
		<table border="0" width="278" height="151" align="center" bgcolor="lightyellow">
	<tr>
		<td height="38" width="278" colspan="3" align="center">
		<font face="Verdana">
		<font color="red" size="5">Login</font>
		</font>
		</td>
	</tr>
	<tr>
		<td height="33" width="104" align="center"><b>
		<font color="magenta" size="4" face="Arial">Username</font></b></td>
		<td height="33" width="23" align="center"><b>:</b></td>
		<td height="33" width="129" align="center"><input type="text" name="usr"></td>
	</tr>
	<tr>
		<td height="35" width="104" align="center"><b>
		<font color="magenta" size="4" face="Arial">Password</font></b></td>
		<td height="33" width="23" align="center"><b>:</b></td>
		<td height="35" width="129" align="center"><input type="password" name="pass"></td>
	</tr>
	<tr>
		<td height="32" width="278" colspan="3" align="center">
		<input type="image" src="submit1.gif"  onclick="return checklogin();">
		</td>
	</tr>
	</table>
	</fieldset>
		</td>
	</tr>
</table>
</body>
</form>
</html>