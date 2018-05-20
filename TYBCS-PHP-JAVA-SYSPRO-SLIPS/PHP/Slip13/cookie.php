<?php
	if(isset($_COOKIE['count']))
	{
		$count=$_COOKIE['count'];
	}
	else
	{
		$count=0;
	}
	$count++;
	setcookie('count',$count);
	echo"<b>This page iss accessed $count times.</b>"
?>
