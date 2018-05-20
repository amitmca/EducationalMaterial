<?php

$dbcon=odbc_connect("phpora","scott","tiger") or die("Connection Failed");

echo "<br><br>Connected Successfully";

$query="create table customer(cnum number(3) primary key,cname varchar(20),city varchar(20),rating number(4),snum references salespeople(snum))";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>Table Created<br>";
	}
else
	{
	echo "<br><b>Table Creation failed<br>";
	}

?>