<html>
<head>
<title>Employee Checking</title>
<script language="JavaScript">
function closeIt()
	{
	close();
	}
function openfullwin()
{ 
window.open('http://localhost/project/employers.htm','Window1','toolbar=yes,status=yes,width=900,height=500,scrollbars=yes,resizable=yes,menubar=yes'); 
} 
	
</script>
</head>
<body bgcolor="#000000">
<form>
<script language="javascript" type="text/javascript" src="usingit_js_starfield_background_cfg.js"></script>
<script language="javascript" type="text/javascript" src="usingit_js_starfield_background.js"></script>
<h2><center>
<FONT face="Verdana, Arial, Helvetica" color="red">
<?php

$con=mysql_connect("localhost","root","") or die("Connection Failed");

mysql_select_db("amit") or die("Database selection failed");

$ecode=$_POST['eid'];

$query="select eid from echeck where eid='$ecode'";

$rs=mysql_query($query) or die("Query not executed");

$row=mysql_fetch_row($rs);

if($row)
	{
	?>
	<br><br>	
	<input type="button" onClick="openfullwin()" value="Continue..."> 
	<?php
	}
	else
	{
	echo "Wrong Code";
	?>
	<br><br>
	<center><a href="http://localhost/project/echeck.html"><img src="images\prev.gif" border="0"></a></center>		
	<br><center><input type="button" name="close" value="Close this window" onClick="closeIt();"></center>		
	<?php
	}
?>
</font></center></h2>
<br><br><br>
</body>
</html>