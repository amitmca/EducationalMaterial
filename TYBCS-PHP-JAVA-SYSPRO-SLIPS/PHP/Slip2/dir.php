<?php
$dname=$_GET['dname'];
$ext=$_GET['ext'];
$dh=opendir($dname);
while(($fname=readdir($dh))!==false)
{
	if(ereg($ext.'$',$fname))
	echo "$fname<br>";
}
closedir($dh);

?>
