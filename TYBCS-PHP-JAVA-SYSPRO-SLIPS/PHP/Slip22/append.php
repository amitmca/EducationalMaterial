<?php
	$file1 = $_POST['file1'];
	$file2 = $_POST['file2'];

	$fp1 = fopen($file1,"a") or die("File Error");
	$fp2 = fopen($file2,"r") or die("File Error");

	$n = filesize($file2);
	$data = fread($fp2,$n);
	fwrite($fp1,$data,$n);

	fclose($fp1);
	fclose($fp2);
?>

