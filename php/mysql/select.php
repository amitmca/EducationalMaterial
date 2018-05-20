<?php

$dbcon=odbc_connect("mysql","root","123456") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="select * from emp";

$rs=odbc_prepare($dbcon,$query);

odbc_execute($rs) or die("<br>Execution of the SQL Query failed");

echo "<b>";

while($row=odbc_fetch_array($rs))
	{
	echo "<br>Emp No:";
	echo $row["eno"];

	echo "<br>Emp Name:";
	echo $row["ename"];
	}
?>