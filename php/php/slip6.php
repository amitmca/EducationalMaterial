<font size=6>
<?
	$name = $_POST['user'];
	$e_mail = $_POST['email'];
	$name = ucwords(strtolower($name));
	$pos = strpos($e_mail,'@');
	if($pos==false)
	{
	   echo "$e_mail doesn't contain @ symbol<br>";
	}
	else
	{
           echo "Name : $name<br>Email : $e_mail<br>";
	}
	echo "<a href='slip6.html'>Go Back</a>";
?>
</font>
