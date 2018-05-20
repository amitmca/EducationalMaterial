<?php
//echo "hello";
$code=$_GET['code'];
$name=$_GET['name'];
$qty=$_GET['qty'];
$rate=$_GET['rate'];

$codes=explode("," ,$code);
$names=explode("," ,$name);
$qtys=explode("," ,$qty);
$rates=explode("," ,$rate);

?>
<table border=1>
<tr><th>Code</th><th>Name</th><th>Qty</th><th>Rate</th><th>Amount</th></tr>
<?php
$tot=0;
for($i=0;$i<5;$i++)
{
	$amt=$qtys[$i]*$rates[$i];
	$tot+=$amt;

?>
<tr><td><?php echo $codes[$i]?></td>
<td><?php echo $names[$i]?></td>
<td><?php echo $qtys[$i]?></td>
<td><?php echo $rates[$i]?></td>
<td><?php echo $amt?></td></tr>

<?php
}
?>
<tr><td colspan=4><b>Total:</b></td>
<td><?php echo $tot?></td></tr>
</table>
