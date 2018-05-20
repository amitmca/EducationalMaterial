<?
	$passwd=$_POST['passwd'];
	if($_POST['Uname']=='administrator')
	{
	if($passwd=='admin')
	{
		echo"<form method='POST' action=3_3.php>";
		echo"<h2><input type='radio' name='choice' value='add'>   Add Item<br>";
		echo"<h2><input type='radio' name='choice' value='search'>Search Item<br>";
		echo"<br><input type='submit'>";
		echo"    <input type='reset'>";
	}
	else
	{
		echo"<h1>Password not matched, Invalid User";
		echo"<br>Click here to <a href='3_1addsearch.php'>Go Back.</a>";
	}
	}
	else
        {
                echo"<h1>User Name is Invalid";
                echo"<br>Click here to <a href='3_1addsearch.php'>Go Back.</a>";
        }

?>
