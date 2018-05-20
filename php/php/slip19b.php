<font size=5>
<?
	echo "Customer Name: ".$_COOKIE['name'].'<br>';
	echo "Address      : ".$_COOKIE['addr'].'<br>';
	echo "Phone No     : ".$_COOKIE['phone'].'<br>';
	echo "Product Name : ".$_POST['pname'].'<br>';
	echo "Qty          : ".$_POST['qty'].'<br>';
	echo "Rate         : ".$_POST['rate'].'<br>';
	echo "Amount       : ".$_POST['qty']*$_POST['rate'].'<br>';
?>
</font>	
