<?php
$op=$_GET['op'];
$input=array('Ram'=>35,'Sham'=>30,'Gita'=>30,'Seeta'=>33);

switch($op)
{
	case 1: 
				echo "<b>Before Filp</b><br>";
				print_r($input);
				$filpped=array_flip($input);
				echo "<br><b>After Filp</b><br>";
				print_r($filpped);
				break;
	case 2: 
				echo "<b>Before Shuffle</b><br>";
				print_r($input);
				shuffle($input);
				echo "<br><b>After Shuffle</b><br>";
				print_r($input);
				break;
				
}

?>
