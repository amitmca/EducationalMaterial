<?php

$db=$_SERVER['DOCUMENT_ROOT']."/oracle";

$handle=sqlite_open($db);

if($handle)
	{
	echo "<b>Successfully Connected To the database<br><br>";
	}	
else
	{
	echo "Connection to the database failed";
	}
$query="create table emp(eno int primary key,ename varchar(20))";

$result=sqlite_query($handle,$query);

if($result)
	{
	echo "<b> Table is Created<br>";
	}
else
	{
	echo "<b> Table Creation failed<br>";
	}
?>