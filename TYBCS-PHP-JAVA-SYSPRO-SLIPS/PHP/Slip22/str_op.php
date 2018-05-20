<?php
	$large=$_POST['s1'];
	$small=$_POST['s2'];
	$replace=$_POST['s3'];

	$pos=strpos($large,$small);

	if($pos==0)
		echo "'$small' appear at start of '$large'<br>";
	else
		echo "'$small' doesn't appear at start of '$large'<br>";

	$new=ereg_replace($small,$replace,$large);

	echo "Replaced string is $new";
?>

