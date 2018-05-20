<?php
	$str=$_GET['s'];
	$stack=array();
	
	$n=strlen($str);
	for($i=0;$i<$n;$i++)
			array_push($stack,$str[$i]);
			
	for($i=0;$i<$n;$i++)
			if(array_pop($stack)!=$str[$i])
			{
				echo "$str is not palindrome";
					break;
			}
		if($i==$n)
				echo "$str is palindrome";
	
	
?>
