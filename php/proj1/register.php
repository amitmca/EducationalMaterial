<?php
	include("connect.php");
	if($_POST['Submit'])
	{
		$fname=$_POST['loginid'];
		$lname=$_POST['pass'];
		$query="insert into login(id,pass) values('$fname','$lname')";
		$res=mysql_query($query);
	}
?>

<html>
<head>
<title>register</title>
</head>
<body bgcolor='green'>
Welcome to my first exp of connectivity
</body>
</html>