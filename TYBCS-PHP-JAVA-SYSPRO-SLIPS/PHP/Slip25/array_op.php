<pre>
<?php
	$mat = array(array(1,2,3),
		     array(4,5,6),
		     array(7,8,9));

	$r = $_POST['row'];
	$c = $_POST['col'];
	$op = $_POST['op'];

	switch($op)
	{
	case 1:
		print_r($mat);
		echo "<br>";
		echo "Value at row $r and col $c is {$mat[$r][$c]}";
		break;
	case 2:
		echo "Before deleting:<br>";
		print_r($mat);
		echo "<br>";
		unset($mat[$r][$c]);
		echo "After deleting:<br>";
		print_r($mat);
	}
?>
</pre>
