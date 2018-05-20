<?php
	$con=mysql_connect("localhost","root","");
	if(!$con)
	{
		die('Database is Not connected');

	}
	else
	{
		echo "connected";
	}
	
	mysql_select_db("viit");
?>