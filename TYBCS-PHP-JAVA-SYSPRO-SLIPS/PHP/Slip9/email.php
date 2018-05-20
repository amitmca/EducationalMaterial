<?php
$email=$_GET['email'];
$pos=strpos($email,'@');
	if($pos==false)
	
		echo "Email id $email doesn't contain @ symbol<br>";
		
	else
		echo "Email id::$email<br>";

?>
<a href='email.html'>Go Back</a> 
