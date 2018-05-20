<?
	setcookie('name',$_POST['name']);
	setcookie('addr',$_POST['addr']);
	setcookie('phone',$_POST['phone']);

	echo "<form method='post' action='slip19b.php'>";
        echo "<pre>";
        echo "Product Name:<input type='text' name='pname'><br>";
        echo "Qty         :<input type='text' name='qty'><br>";
        echo "Rate        :<input type='text' name='rate'><br>";
        echo "<input type='submit'>   <input type='reset'>";
        echo "</pre>";
        echo "</form>";
?>
	
