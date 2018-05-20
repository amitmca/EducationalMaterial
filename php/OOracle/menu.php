
<body bgcolor="yellow">
<b>
<?php

$eno=$_POST['eno'];
$ename=$_POST['ename'];

$dbcon=odbc_connect("phpora","scott","tiger") or die("Connection Failed");

$query="insert into employee values('$eno','$ename')";

if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>1 Row inserted<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}
?>
</body>