<?php
	$eid=$_GET['eid'];
	if(ereg("^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[_a-z0-9-]+)$",$eid))
		echo "<h1>Valid Email id $eid</h1>";
	else
	echo "<h1>Invalid Email id $eid</h1>";
?>
