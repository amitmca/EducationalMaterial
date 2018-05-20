<?php
	session_start();
	if((mktime()-$_SESSION["Time"])>10):
		session_unset();
		header("Location : Timeout.html");
		echo "timeout";
	else:
		header("Location : Thankyou.html");
		echo "Thank U";	
endif;
?>
	
