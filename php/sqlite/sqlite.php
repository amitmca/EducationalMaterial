<?php

$db=$_SERVER['DOCUMENT_ROOT']."/oracle";
$handle=sqlite_open($db);

if($handle)
	{
	echo "<b>Successfully Connected To the database<br><br>";
	echo "Connection Details:<br>";
	echo $db;
	}	
else
	{
	echo "Connection to the database failed";
	}

?>