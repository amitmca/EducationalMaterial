<?
function x_strrev($s,$n)
{
	for($i=$n,$j=strlen($s)-1;$i<$j;$i++,$j--)
	{
		$t = $s[$i];
		$s[$i]=$s[$j];
		$s[$j]=$t;
	}
	return $s;
}
function x_strstr($s1,$s2)
{
	$j=0;
	for($i=0;$i<strlen($s1);$i++)
  	{
     		if($s1[$i]==$s2[$j])
     		{
         		for($j=0;$j<strlen($s2);$j++,$i++)
	 		{
 	    			if($s1[$i]!=$s2[$j])
	    			{
	       				$j=0;
	       				$i--;
	       				break;
	    			}
         		}
			if($j==strlen($s2)) return true;
     		}
  	}
  	return false;
}
?>	
