<?php
$usr=$_POST['usr'];
$pass=$_POST['pass'];
Require_once('DB.php');
$dsn="pgsql://postgres@localhost/website";
$db=DB::connect($dsn);
if(DB::isError($db))
	{
	die($db->getMessage());
	}
if($_POST['usr']=="")
	{
	echo "<font color='red'> Please enter the user name</font>";
	echo "<hr>";
	include("login.php");
	}	
elseif($_POST['pass']=="")
	{
	echo "<font color='red'> Please enter the password</font>";
	echo "<hr>";
	include("login.php");
	}	
else
	{
$query="select examid from admin where examid='$usr'";
$q=$db->query($query); 
if(DB::isError($q))
	{
	die($db->getMessage());
	}
$query1="select pass from admin where pass='$pass'";
$q1=$db->query($query1); 
if(DB::isError($q1))
	{
	die($db->getMessage());
	}

while($q->fetchInto($row) && $q1->fetchInto($row1))
	{
	if($row[0]==$usr)
		{
		if($row1[0]==$pass)
			{
			echo "<b>USER NAME AND PASSWORD MATCHES";
			}
		else
			{
			echo "<b>USER NAME AND PASSWORD NOT MATCHES";
			}
		}
	else
		{
		echo "<b>USER NAME AND PASSWORD NOT MATCHES";
		}		
	}
	}
?>
