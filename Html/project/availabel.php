<html>
<head>
<title>Check Availability</title>
<script language="JavaScript">
function closeIt()
	{
	close();
	}
</script>
</head>
<body bgcolor="#000000">
<script language="javascript" type="text/javascript" src="usingit_js_starfield_background_cfg.js"></script>
<script language="javascript" type="text/javascript" src="usingit_js_starfield_background.js"></script>

<h2><center>
<FONT face="Verdana, Arial, Helvetica" color="red">
<?php

$con=mysql_connect("localhost","root","") or die("Connection Failed");

mysql_select_db("amit") or die("Database selection failed");

$pid=$_POST['txtpid'];

$query="select txtpid from register where txtpid='$pid'";

$rs=mysql_query($query) or die("Query not executed");

$row=mysql_fetch_row($rs);

if($row)
		{
		echo "Id is unavailable.Already taken by other user";
		?>
		<br><br><br><br>	
		<center><a href="http://localhost/project/availability.html"><img src="images\prev.gif" border="0"></a></center>		
		<?php
		}
	else
		{
		echo "Id is available";
		?>
		<br><br><br><br>
		<center><input type="button" name="close" value="Close this window" onClick="closeIt();"></center>		
		<?php
		}
	

?>
</font></center></h2>
<br>
</body>
</html>