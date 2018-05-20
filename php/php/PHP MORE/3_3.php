<?

	if($_POST['choice']=='add')
	{
		echo'<form method="POST" action="3_4.php">';
		echo'<h1>INSERT ITEM</h1>';
		echo'<pre><h3>';
		echo'Enter Item Number: <input type="text" name="ino"><br><br>';
		echo'Enter Item Name  : <input type="text" name="iname"><br><br>';
		echo'Enter Item Qty   : <input type="text" name="qty"><br><br>';
		echo'Enter Item Rate  : <input type="text" name="rate"><br><br>';
		echo'Enter Min Stock  : <input type="text" name="mstk"><br><br>';
		echo'<input type="submit">';
		echo'   <input type="reset">';
	}
	else
	if($_POST['choice']=='search')
	{
		echo'<form method="POST" action="3_4.php">';
		echo'<h1>SEARCH ITEM';
		echo'<h3>Enter Item Name : <input type="text" name="iname">';
		echo'<br><input type="submit">';
                echo'   <input type="reset">';

	}
?>
