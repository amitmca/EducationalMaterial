<?
echo "<form bgcolor = 'yellow'>";
$s1 = $_POST['str1'];
$s2 = $_POST['str2'];
$s3 = $_POST['str3'];
echo'<h2>';
	if($_POST['option']=="replace")
	{
	$pos = strpos($s1,$s2);
	if($pos == null)
	echo "$s2 not found in $s1<br>";
	else
	{
		$s1 = substr_replace($s1,$s3,$pos,strlen($s2));
		echo "Replaced string is $s1<br>";
	}
	}
	elseif($_POST['option']=="search")
	{
		$pos =strpos($s1,$s2);
		if($pos == false)
		echo "$s2 not found in $s1<br>";
		else
		echo "$s2 is present in $s1 at position $pos<br>";
	}
	elseif($_POST['option']=="concat")
	echo "The Concatinated string is $s1".$s2."<br>";
	echo"<a href = '14_1stropr.php'>Goback";
echo'</form>';
?>	
