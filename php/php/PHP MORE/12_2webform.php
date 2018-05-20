<html>
<body>
Selected Control :
<br><br>
<?
	$r=$_POST['r1'];
	$c=$_POST['c1'];
	$d=$_POST['color'];
	$s=$_POST['submit'];	
	if($c)
	{
		echo"You selected check Box :<input type='checkbox' checked>";
	}
	if($r)
        {
                echo"You selected Radio Button :<input type='radio' checked>";
        }
	else
	{
		echo'You selected list'.'<select name=color>'.
		"<option>$d</option>".'</select>';
		
	}
?>
</body>
</html>
