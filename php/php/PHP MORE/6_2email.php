<?
	$user = $_POST['uname'];
	$email=$_POST['mail'];
	$user=ucwords(strtolower($user));
	$pos=strpos($email,'@');
	echo "pos = $pos";
	if($pos==false)
	{
		echo"<h1>$email doesn't contain @ symbol</h1>";
	}
	else
		echo"<h1>Name : $user<br>E-mail id :$email</h1>";
	echo"<a href='6_1email.html'>Go Back</a>";
?>
