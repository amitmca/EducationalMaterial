<?php
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$class=$_POST['class']; 
$class1=$_POST['class1']; 
$q=$_POST['q'];
$rno=$_POST['rno'];
$pass=$_POST['pass'];


$dbcon=odbc_connect("mysql","root","123456") or die("Connection Failed");


print "Connected Successfully";
?>

/*$query="insert into stud_acc values('$fname','$lname','$class','$class1','$q','$rno','$pass')";


if(@odbc_exec($dbcon,$query))
	{
	echo "<br><b>Confirmed<br>";
	}
else
	{
	echo "<br><b>Insertion failed<br>";
	}

?>
*/


