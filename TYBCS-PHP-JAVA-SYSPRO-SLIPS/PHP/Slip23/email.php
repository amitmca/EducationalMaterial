<?php
	$to = $_POST['to'];
	$subject = $_POST['subject'];
	$message = $_POST['message'];
	$from = "localhost";
	$headers = "From: $from";
	mail($to,$subject,$message,$headers);
	echo "Mail Sent.";
?>
