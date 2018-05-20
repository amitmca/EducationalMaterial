<?
	$s1=$_POST['str'];
	$stk=array();
	for($i=0;$i<strlen($s1);$i++)
	{
		array_push($stk,$s1[$i]);
	}
	for($i=0;$i<strlen($s1);$i++)
		if($s1[$i] != array_pop($stk))		
			break;
	
	if($i==strlen($s1))
		echo"<h1 String is Palindrome</h1>";
	else
		echo"<h1 String is Not Palindrome</h1>";
?>
