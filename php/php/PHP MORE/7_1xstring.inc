<?
	function xstrrev($s1,$n)
	{
		for($i=$n,$j=strlen($s1)-1;$i<$j;$i++,$j--)
		{
			$t=$s1[$i];
			$s1[$i]=$s1[$j];
			$s1[$j]=$t;
		}
		return $s1;
	}
	function xstrstr($s1,$s2)
	{
		for($i=0,$j=0;$i<strlen($s1)&&$j<strlen($s2);$i++)
		{
			if($s1[$i]==$s2[$j])
				$j++;
			else
			{
				$j=0;
				if($s1[$i]==$s2[$j])
				{
					$j=1;
				}
			}
			if($j==strlen($s2))
			return true;
		}
	}
?>
