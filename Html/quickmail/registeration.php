<?php

$con=mysql_connect("localhost","root","") or die("Error:Connection Refused");

$db=mysql_select_db("quickmail") or die("Error:Database Connection Refused");

$txtname=$_POST['txtname'];

$txtuid=$_POST['txtuid'];

$txtpass=$_POST['txtpass'];

$security=$_POST['security'];

$txtans=$_POST['txtans'];

$emailid=$_POST['emailid'];

$month=$_POST['month'];

$date1=$_POST['date1'];

$year=$_POST['year'];

$gender=$_POST['gender'];

$country=$_POST['country'];

$date=""."$year"."-"."$month"."-"."$date1";

$verify=$_POST['verify'];

$query1="select code from Captcha where code='$verify'";

$rs=mysql_query($query1) or die("Query not executed");

$row=mysql_fetch_row($rs);

if($row)
	{
	$query="insert into register values('$txtname','$txtuid','$txtpass','$security','$txtans','$emailid','$date','$gender','$country')";

	mysql_query($query) or die("Error:Insertion Failed");

	echo "Your Account has been Created Successfully<br>";
	}

else
	{
	header('Location:register.php');	
	}	



?>