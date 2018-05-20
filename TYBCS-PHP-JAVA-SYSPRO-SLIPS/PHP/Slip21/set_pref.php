<?php
	$msg=$_COOKIE['msg'];
	$style=$_COOKIE['style'];
	$size=$_COOKIE['size'];
	$fc=$_COOKIE['fcolor'];
	$bc=$_COOKIE['bcolor'];

echo "<body bgcolor='$bc'>";
echo "<font size='$size' 
	color=' $fc'>
<$style> $msg</ $style>";
echo "</font>";
echo "</body>"; 
?>
