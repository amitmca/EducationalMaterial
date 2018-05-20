<font size=6>
<?
	include('slip7.inc');
	$s1 = "net2net Computers";
	$s2 = "Comp";
	echo x_strrev($s1,8)."<br>";
	$pos = x_strstr($s1,$s2);
	if($pos===false)
	{
		echo "$s2 not present in $s1<br>";
	}
	else
	{
		echo "$s2 is present in $s1<br>";
	}	
?>
</font>
