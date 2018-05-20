<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="insert into employee values(70,'Appa')";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row inserted<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}

?>