<?php

$dbcon=odbc_connect("phpora","scott","tiger") or die("Connection Failed");

echo "<br><B>Connected Successfully<BR>";

$query="select * from orders";

$rs=odbc_prepare($dbcon,$query);

odbc_execute($rs) or die("<br>Execution of the SQL Query failed");

echo "<b>";

while($row=odbc_fetch_array($rs))
	{
	echo "<br>ONUM:";
	echo $row["ONUM"];

	echo "<br>ODATE:";
	echo $row["ODATE"];

	echo "<br>SNUM:";
	echo $row["SNUM"];

	echo "<br>AMT:";
	echo $row["AMT"];

	echo "<br><HR>";

	}
?>