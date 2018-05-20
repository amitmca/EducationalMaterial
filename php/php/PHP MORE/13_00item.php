<?
        
        echo"<form method='POST' action='13_01item.php'>";
        echo'<h1>INSERT ITEM</h1>';
	for($i=0;$i<5;$i++)
	{
	echo'<pre><br>';
        echo'Enter Item Number: <input type="text" name="ino[]"><br><br>';
        echo'Enter Item Name  : <input type="text" name="iname[]"><br><br>';
        echo'Enter Item Qty   : <input type="text" name="qty[]"><br><br>';
        echo'Enter Item Rate  : <input type="text" name="rate[]"><br><br>';
        }
	echo'<input type="submit">';echo'<input type="reset">';

?>

