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

$query="insert into emp values(40,'Parag')";

$result=sqlite_query($handle,$query);

if($result)
	{
	echo "<b>1 Row Inserted<br>";
	}
else
	{
	echo "<b>Insertion failed<br>";
	}
?>