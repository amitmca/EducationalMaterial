<?php
	$eid=$_POST['eid'];
	if(ereg("^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)$",$eid))
		echo "<h2>VALID EMAILID</h2>";
	else 
		echo "<h2>INVALID EMAILID</h2>";
?>

