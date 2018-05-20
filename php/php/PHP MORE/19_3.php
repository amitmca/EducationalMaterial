<?
	session_start();

	$qty=$_POST['qty'];
	$rate=$_POST['rate'];
	$amt=$qty*$rate;
	echo'<pre><strong>';
	echo"Cust Name :".$_SESSION['cname'].'<br>';
	echo"Cust Add  :".$_SESSION['cadd'].'<br>';
	echo"Cust PhNo :".$_SESSION['phno'].'<br>';
	echo"Amount Payable $amt";
	echo'</pre>';
?>

