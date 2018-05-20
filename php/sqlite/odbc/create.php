<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="create table emp1(eno integer primary key,ename varchar(20))";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>Table Created<br>";
	}
else
	{
	echo "<br><b>Table Creation failed<br>";
	}

?>