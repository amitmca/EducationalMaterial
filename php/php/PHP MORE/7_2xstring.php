<?
	include('7_1xstring.inc');
	$s1 = 'YogeshTheOne';
	$s2 = 'TheOne';
	if(xstrstr($s1,$s2))
		echo 'Sting is Present';
	else
		echo 'String is not present';
	echo '<br>'.xstrrev($s1,6).'<br>';
?>
