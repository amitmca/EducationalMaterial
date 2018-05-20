<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="delete from employee where eno=60";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row Deleted<br>";
	}
else
	{
	echo "<br><b>Deletion failed<br>";
	}

?>