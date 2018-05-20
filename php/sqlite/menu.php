<?php

$db=$_SERVER['DOCUMENT_ROOT']."/oracle";

$handle=sqlite_open($db);

$eno=$_POST['eno'];
$ename=$_POST['ename'];

$query="insert into emp values('$eno','$ename')";

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