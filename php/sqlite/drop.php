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
$query="drop table emp";

$result=sqlite_query($handle,$query);

if($result)
	{
	echo "<b> Table is Dropped<br>";
	}
else
	{
	echo "<b> Table Dropping failed<br>";
	}
?>