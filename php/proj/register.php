
<?php

	$con=mysql_connect("localhost","root","") or die("Connection Failed");

	echo "Connected Successfully";	

	mysql_select_db("viit") or die("Unable To select Database");
		
	echo "Database is selected<br>";	
	
	$fname=$_POST['fname'];
	
	//echo "<br>$fname";

	$lname=$_POST['lname'];

//	echo "<br>$lname";

	$addr=$_POST['addr'];

//	echo "<br>$addr";

	$contact=$_POST['contact'];

//	echo "<br>$contact";

	$email=$_POST['email'];

//	echo "<br>$email";

	$query="insert into enquiry values('$fname','$lname','$addr','$contact','$email')";

	$res=mysql_query($query);
?>
