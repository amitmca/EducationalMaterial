<?php
	$names = array("Ram"=>35,"Seeta"=>37,"Laxman"=>33,"Radha"=>18,"Krishna"=>25);
	$op = $_POST['op'];
	switch($op)
	{
	case 1: 
		foreach($names as $k=>$v)
		{
			echo "Key = $k, Value = $v<br>";
		}
		break;
	case 2: 
		$n = sizeof($names);
		echo "Array Size: $n";
	}
?>

