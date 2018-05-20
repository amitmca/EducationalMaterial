<?
	echo "<table border='1'>";
	echo "<tr><th>Code</th><th>Name</th><th>Qty</th><th>Rate/Unit</th><th>Amt</th></tr>";
	$total = 0;
	for($i=0; $i<4; $i++)
	{
		$code = $_POST['code'][$i];
		$name = $_POST['name'][$i];
		$qty = $_POST['qty'][$i];
		$rate = $_POST['rate'][$i];
		$amt = $rate * $qty;
		$total += $amt;
        	echo "<tr>";
		echo "<td>$code</th><th>$name</th><th>$qty</th><th>$rate</th><th>$amt</th>";
		echo "</tr>";
	}
	echo "</table>";
	echo "Total Amount = $total";
?>

		
