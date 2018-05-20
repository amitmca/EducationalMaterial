<?php
$con=mysql_connect("localhost","root","");
if($con)
	{
	die("Database is connected");
	}
mysql_select_db("viit");
?>