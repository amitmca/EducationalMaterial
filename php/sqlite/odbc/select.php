<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="select * from employee";

$rs=odbc_prepare($dbcon,$query);

odbc_execute($rs) or die("<br>Execution of the SQL Query failed");

while($row=odbc_fetch_array($rs))
	{
	echo "<br>Emp No:";
	echo $row["eno"];

	echo "<br>Emp Name:";
	echo $row["ename"];
	}
?>