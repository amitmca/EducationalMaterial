<?php

$con=mysql_connect("localhost","root","") or die("Error:Connection Refused");

$db=mysql_select_db("quickmail") or die("Error:Database Connection Refused");

$verify=$_POST['verify'];

$query1="select code from Captcha where code='$verify'";

$rs=mysql_query($query1) or die("Query not executed");

$row=mysql_fetch_row($rs);

if($row)
	{
	echo "Matching";
	}
else
	{
	echo "Not matching";
	}

?>