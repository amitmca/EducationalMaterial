<font size=6>
<?
	$s1 = $_POST['str1'];
	$s2 = $_POST['str2'];
	$s3 = $_POST['str3'];
	$op = $_POST['op'];
	if($op=="replace")
	{
  		$pos = strpos($s1,$s2);
  		if($pos==false)
  		{
     			echo "$s2 not present in $s1<br>";
  		}
  		else
  		{
     			$s1 = substr_replace($s1,$s3,$pos,strlen($s2));
     			echo $s1.'<br>';
  		}
	}
	elseif($op=='search')
	{
  		$pos = strpos($s1,$s2);
  		if($pos==false)
  		{
     			echo "$s2 not present in $s1<br>";
  		}
  		else
  		{
     			echo "$s2 present in $s1 at postion $pos<br>";
  		}	
	}
	elseif($op=="concat")
	{
  		echo $s1.$s2.'<br>';
	}
	echo "<a href='slip14.html'>Go Back</a>";
?> 
</font> 	
				
