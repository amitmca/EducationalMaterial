<?php

$dbcon=odbc_connect("SQLITE"," "," ") or die("Connection Failed");
$eno=$_POST['eno'];
$ename=$_POST['ename'];

$query="insert into emp1 values('$eno','$ename')";


if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row inserted<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}

?>