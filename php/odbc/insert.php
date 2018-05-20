<?php

$dbcon=odbc_connect("wodbc"," "," ") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="insert into emp values(30,'ajay')";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row inserted<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}

?>