<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Bidding Information System</title>
<script language="javascript">

function checklogin()
{
  var err="";
  
	var cno=document.form.cno.value;
      
  if(document.getElementById("cno").value=="")
  { err +="\nPlease enter Customer number .\t\n";}
  
  if(isNaN(cno))
  { err +="\nPlease enter valid Customer number.\t\n";}
  
    if(document.getElementById("cname").value=="")
  { err +="\nPlease enter Customer name .\t\n";}
  
   if(document.getElementById("addr").value=="")
     { err +="\nPlease enter Customer Address .\t\n";}
     
      if(document.getElementById("amount").value=="")
  { err +="\nPlease enter Bid Amount .\t\n";}
  
   if(document.getElementById("date").value=="")
  { err +="\nPlease enter Bid Date .\t\n";}
  
   

  
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
<form name="form" method="post" action="http://localhost:8080/examples/jsp/Bidding/insert1.jsp">
<table border="1" width="393" height="28" align="center">
	<tr>
		<td height="28" width="383">
		<p align="center"><b><font size="4" face="Verdana" color="#FF0000">
		Bidding Information System</font></b></td>
	</tr>
</table>
<table border="1" width="394" height="29" align="center">
	<tr>
		<td height="23" width="384">
		<b>
		<font color="#0055bb" size=4>&nbsp;<a href="http://localhost:8080/examples/jsp/Bidding/insert.jsp"> Insert</a></font><font size="4">
		<font color="#0055bb" size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/examples/jsp/Bidding/max.jsp"> Show Max</a></font><font size="4">
		</font></b>
		</td>
	</tr>
</table>



<table border="1" width="392" height="174" align="center">
	<tr>
		<td height="21" width="173"><font face="Verdana" color="#008080"><b>
		Customer Number</b></font></td>
		<td height="21" width="16">
		<p align="center">&nbsp;<b>:</b></td>
		<td height="21" width="181">
		<input type="text" name="cno">
		</td>
	</tr>
	<tr>
		<td height="25" width="173"><font face="Verdana" color="#008080"><b>
		Customer Name</b></font></td>
		<td height="25" width="16"><p align="center">&nbsp;<b>:</b></td>
		<td height="25" width="181">
		<input type="text" name="cname">
		</td>
	</tr>
	<tr>
		<td height="23" width="173"><font face="Verdana" color="#008080"><b>
		Address</b></font></td>
		<td height="23" width="16"><p align="center">&nbsp;<b>:</b></td>
		<td height="23" width="181">
		<textarea rows="3" name="addr" cols="20"></textarea>
		
		</td>
	</tr>
	<tr>
		<td height="30" width="173"><font face="Verdana" color="#008080"><b>Bid 
		Amount</b></font></td>
		<td height="30" width="16"><p align="center">&nbsp;<b>:</b></td>
		<td height="30" width="181">
		<input type="text" name="amount">
		</td>
	</tr>
	<tr>
		<td height="25" width="173"><font face="Verdana" color="#008080"><b>Date</b></font></td>
		<td height="25" width="16"><p align="center">&nbsp;<b>:</b></td>
		<td height="25" width="181">
		<input type="text" name="date">
		</td>
	</tr>
	<tr>
		<td height="32" width="382" colspan="3" align="center">
		<input type="submit" name="submit" value="SUBMIT" onclick="return checklogin();">
		</td>
	</tr>
</table>
</form>
</body>

</html>