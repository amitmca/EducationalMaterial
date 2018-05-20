<?php

$dbcon=mysql_connect("localhost","root","123456") or die("Connection failed") ;

echo "<b><br>Connected Successfully";

$query="insert into amit.emp values('30','rohit')";

$result=mysql_query($query);

if(!result)
	{
	echo "<br>Not Inserted";
	}
else
	{
	echo "<br>inserted";
	}

?>