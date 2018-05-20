<?php
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$class=$_POST['class']; 
$class1=$_POST['class1']; 
$q=$_POST['q'];
$rno=$_POST['rno'];
$pass=$_POST['pass'];
Require_once('DB.php');
$dsn="pgsql://postgres@localhost/website";
$db=DB::connect($dsn);
if(DB::isError($db))
	{
	die($db->getMessage());
	}
$query="insert into stud_acc values('$fname','$lname','$class','$class1','$q','$rno','$pass')";
$q=$db->query($query);
if(DB::isError($q))
	{
	echo "<b>Please check the query";
	}
else
	{
	echo "<b>Registred Sucessfully";
	}
$query1="insert into stud_acc values('$class$class1$rno')";
$q1=$db->query($query1);
if(DB::isError($q1))
	{
	echo "<b><br>Please check the query";
	}
else
	{
	echo "<b><br>ID is Created";
	}
$query2="insert into admin values('$class$class1$rno','$pass')";
$q2=$db->query($query2);
if(DB::isError($q1))
	{
	echo "<b><br>Please check the query";
	}
else
	{
	echo "<b><br>Password is Created";
	}
echo "<br><b>Your Exam id is:$class$class1$rno"
?>
<br><center><a href="login.php"><img src="prev.gif"></a></center>


