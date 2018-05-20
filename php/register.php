<?php
$name=$_POST['name'];
$address=$_POST['address'];
$q=$_POST['q'];
$date1=$_POST['date1'];
$contact=$_POST['contact'];
$email=$_POST['email'];
$sscb=$_POST['sscb'];
$sscp=$_POST['sscp'];
$sscc=$_POST['sscc'];

$hscb=$_POST['hscb'];
$hscp=$_POST['hscp'];
$hscc=$_POST['hscc'];

$grab=$_POST['grab'];
$grap=$_POST['grap'];
$grac=$_POST['grac'];


$db=odbc_connect("mysql","root","123456") or die("Error");

$query="insert into stud_acc values('$name','$address','$q','$date1','$contact','$email','$sscb','$sscp','$sscc','$hscb','$hscp','$hscc','$grab','$grap','$grac')";


if(@odbc_exec($db,$query))
	{
	echo "<br><b>1 Row inserted<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}

?>