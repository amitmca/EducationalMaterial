<?php
	$str=$_GET['str'];
	$op=$_GET['op'];
	
	$stack=array('Red','Blue','Green');
	switch($op)
	{
		case 1:	echo "<br><b>Before Push</b><br>";
					print_r($stack);
					array_push($stack,$str);
					echo "<br><b>After Push</b<br>";
					print_r($stack);
					
					break;
		case 2:	echo "<br><b>Before Pop</b<br>";
					print_r($stack);
					$val=array_pop($stack);
					echo "<br><b>After Pop</b><br>";
					print_r($stack);
					echo "<br><br><b> Popped Element::$val";
					break;
	}

?>
