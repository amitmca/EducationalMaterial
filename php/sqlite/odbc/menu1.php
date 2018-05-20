<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");
$eno=$_POST['eno'];
$ename=$_POST['ename'];

$query="delete from employee where eno=$eno";


if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row Deleted<br>";
	}
else
	{
	echo "<br><b>Deletion failed<br>";
	}

?>