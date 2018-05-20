<?php
	function add($x=0,$y=0)
	{
		return $x+$y;
	}

	function sub($x=0,$y=0)
	{
		return $x-$y;
	}

	function mult($x=0,$y=0)
	{
		return $x*$y;
	}

	function div($x=0,$y=1)
	{
		return $x/$y;
	}

	 $n1=$_POST['n1'];
	$n2=$_POST['n2'];
	$op=$_POST['op'];

	switch($op)
	{
	case '+':
		
		
			echo add($n1,$n2);
		
		break;
	case '-':
		
			echo sub($n1,$n2);
	
		break;
	case '*':
		
			echo mult($n1,$n2);
		
		break;
	case '/':
		
			echo div($n1,$n2);
		
	}
?>

